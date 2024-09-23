package com.netease.thanos.report.job.thanos;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.netease.thanos.api.dto.thanos.*;
import com.netease.thanos.common.constants.ConfCenterConstants;
import com.netease.thanos.core.depositChain.adapter.ThanosChainAdapter;
import com.netease.thanos.core.depositChain.bo.ThanosContractTransactionDetailBo;
import com.netease.thanos.core.depositChain.constant.ContractProtocolEnum;
import com.netease.thanos.core.depositChain.service.contract.NFTToken;
import com.netease.thanos.core.depositChain.util.PartitionKeyUtil;
import com.thanos.web3j.abi.datatypes.Bool;
import com.thanos.web3j.abi.datatypes.Type;
import com.thanos.web3j.abi.datatypes.Utf8String;
import com.thanos.web3j.abi.datatypes.generated.Bytes4;
import com.thanos.web3j.abi.datatypes.generated.Uint256;
import com.thanos.web3j.utils.SystemConstant;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.netease.thanos.common.dto.CommonResultDTO;
import com.netease.thanos.core.depositChain.domain.ThanosChainDomain;
import com.netease.thanos.web.assember.ThanosBlockChainAssmbler;
import com.thanos.common.crypto.key.asymmetric.SecureKey;
import com.thanos.common.utils.ByteUtil;
import com.thanos.web3j.crypto.Credentials;
import com.thanos.web3j.model.ThanosBlock;
import com.thanos.web3j.model.ThanosEthTransaction;
import com.thanos.web3j.model.ThanosTransactionReceipt;
import com.thanos.web3j.protocol.Web3j;
import com.thanos.web3j.tx.RawTransactionManager;
import com.thanos.web3j.tx.TransactionManager;
import com.thanos.web3j.utils.Numeric;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;


/**
 * @Author lyy create on 2018-05-13
 */

@Slf4j
@Component
public class BlockTnxReporterHandler implements InitializingBean {

    @Autowired
    private ThanosChainDomain thanosChainDomain;

    /**
     * 单批导出的最大区块数量
     */
    private static int MAX_EXPORT_BLOCK_NUMBER = 10000000;


    private final static String DS_CHECK_ERROR = "current tx is ds tx!!!";
    @Resource
    private Environment environment;
    @Autowired
    private ThanosChainAdapter chainAdapter;

    public static class AbortPolicyWithoutException implements RejectedExecutionHandler {

        /**
         * doNothing
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        }
    }

    Executor blockTnxExecutor = new ThreadPoolExecutor(1, 1, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new AbortPolicyWithoutException());
    private static Credentials credentials;

    /**
     * 721  erc721
     */
    private static final String INTERFACE_ID_ERC721 = "0x80ac58cd";
    /**
     * 1155 erc1155
     */
    private static final String INTERFACE_ID_ERC1155 = "0xd9b67a26";


    @Override
    public void afterPropertiesSet() throws Exception {
        credentials = Credentials.create(SecureKey.getInstance("ECDSA", 1));
    }

    public void doHandle() {
        blockTnxExecutor.execute(() -> {
            log.info("BlockTnxReporterHandler start handle!");

            try {
                doBlockTnxExport();
            } catch (Exception e) {
                log.error("doBlockTnxExport occur error!", e);
            }
            log.info("BlockTnxReporterHandler start handle done!");
        });
    }

    private void doBlockTnxExport() throws Exception {
        Web3j web3j = chainAdapter.getWeb3jRandomly();
        if (web3j == null) {
            log.error("doBlockTnxExport failed. no available web3j.");
            return;
        }
        //对于新的一天，需要把初始化当天的交易记录（0条交易），这样即使当天没有区块生成，交易记录仍然可查。如果不是新的一天，则维持记录不变。
        CommonResultDTO<Boolean> res = thanosChainDomain.getThanosChainFacadeService().createTnxCountRecordForNewDay(new Date());
        if (res == null || !res.isSuccessed()) {
            log.error("BlockTnxReporterHandler doBlockTnxExport failed. createTnxCountRecordForNewDay error. date:{}.", new Date());
            return;
        }

        TransactionManager transactionManager = new RawTransactionManager(web3j, credentials);
        Long lastBlockHeight = transactionManager.getThanosLatestBlockNumber();
        log.debug("###handleBlockInfo, the latest blockHeight：{}###", lastBlockHeight);
        CommonResultDTO<Long> resultDTO = thanosChainDomain.getThanosBlockFacadeService().queryMaxBlockHeight();
        if (resultDTO == null || !resultDTO.isSuccessed()) {
            log.error("BlockTnxReporterHandler doBlockTnxExport failed. queryMaxBlockHeight error. resultDTO:{}.", resultDTO);
            return;
        }
        Long dbBlockHeight = resultDTO.getResult();
        log.debug("###handleBlockInfo db blockHeight：{}###", dbBlockHeight);

        if (lastBlockHeight.equals(dbBlockHeight)) {
            return;
        } else {
            long targetBlockHeight = lastBlockHeight < dbBlockHeight + MAX_EXPORT_BLOCK_NUMBER ? lastBlockHeight : dbBlockHeight + MAX_EXPORT_BLOCK_NUMBER;
            log.debug("###handleBlockInfo target blockHeight：{}###", targetBlockHeight);
            for (long i = dbBlockHeight + 1; i <= targetBlockHeight; i++) {
                try {
                    handleBlockInfo(i, transactionManager);
                } catch (Exception e) {
                    log.error("handleBlockInfo failed. blockHeight:{}. e:", i, e);
                    break;
                }
            }
        }
    }

    /**
     * handle block info
     *
     * @param blockHeight
     * @throws Throwable
     */
    private void handleBlockInfo(long blockHeight, TransactionManager transactionManager) throws Exception {
        ThanosBlock block = transactionManager.getThanosBlockByNumber(String.valueOf(blockHeight));
        if (block == null || block.getTimestamp() == 0) {
            //对于创世区块，timestamp为0，直接跳过。
            log.info("ThanosChainInfoCollector handleBlockInfo block is genesis. blockHeight：{}###", blockHeight);
            return;
        }
        log.info("###handleBlockInfo：number:{}, txCount:{} ###", block.getNumber(), CollectionUtils.isEmpty(block.getReceiptList()) ? 0 : block.getReceiptList().size());
        //1. 区块信息
        ThanosBlockDTO thanosBlockDTO = ThanosBlockChainAssmbler.thanosBlockBo2DTO(block);
        //2. 交易信息
        List<ThanosEvmTransactionDTO> thanosTnxDTOs = new ArrayList<>();
        //3. 交易回执
        List<ThanosEvmTransactionReceiptDTO> thanosTnxReceiptDTOs = new ArrayList<>();
        //4、新合约列表
        List<ThanosContractDTO> thanosContractDTOList = new ArrayList<>();
        //5、合约交易列表信息
        Map<String, List<ThanosContractTransactionDTO>> contractTransactionMap = new HashMap<>();

        //组装交易和回执列表
        handleTransactionsAndReceipts(thanosBlockDTO, block.getReceiptList(), thanosTnxDTOs, thanosTnxReceiptDTOs, thanosContractDTOList, contractTransactionMap);
        //4. 全局事件
        List<ThanosGlobalEventDTO> nodeEventDTOS = ThanosBlockChainAssmbler.thanosGlobalEventBo2DTOList(thanosBlockDTO, block.getGlobalEventList());
        //5. 区块链整体信息
        ThanosBlockchainInfoDTO blockchainInfoDTO = new ThanosBlockchainInfoDTO();
        blockchainInfoDTO.setLastBlockNum(thanosBlockDTO.getNumber());
        blockchainInfoDTO.setEpoch(thanosBlockDTO.getEpoch());
        blockchainInfoDTO.setTxnCount(thanosBlockDTO.getEvmTnxNum());

        //6、解析新增的合约信息
        handleContractDetail(thanosContractDTOList);

        //7、合约交易列表信息，超过一定数量的进行删除
        Map<String, List<Long>> removeContractTransactionMap = queryRemovedContractTransactions(contractTransactionMap);

        //8. 存储
        ThanosChainDataDTO chainDataDTO = new ThanosChainDataDTO();
        chainDataDTO.setThanosBlockDTO(thanosBlockDTO);
        chainDataDTO.setThanosEvmTransactionDTOS(thanosTnxDTOs);
        chainDataDTO.setThanosEvmTransactionReceiptDTOS(thanosTnxReceiptDTOs);
        chainDataDTO.setThanosGlobalNodeEventDTOS(nodeEventDTOS);
        chainDataDTO.setThanosBlockchainInfoDTO(blockchainInfoDTO);
        chainDataDTO.setThanosContractDTOList(thanosContractDTOList);
        chainDataDTO.setRemoveContractTransactionMap(removeContractTransactionMap);
        chainDataDTO.setContractTransactionMap(contractTransactionMap);

        CommonResultDTO<Boolean> resultDTO = thanosChainDomain.getThanosChainFacadeService().importBlockChainData(chainDataDTO);
        if (resultDTO == null || !resultDTO.isSuccessed()) {
            log.error("BlockTnxReporterHandler importBlockChainData failed. blockNumber:{}, resultDTO:{}.", blockHeight, resultDTO);
            throw new Exception("BlockTnxReporterHandler importBlockChainData failed. blockNumber=" + blockHeight);
        }
    }

    /**
     * 查询需要删除的合约交易
     *
     * @param contractTransactionMap
     * @return
     */
    private Map<String, List<Long>> queryRemovedContractTransactions(Map<String, List<ThanosContractTransactionDTO>> contractTransactionMap) {
        if (contractTransactionMap.isEmpty()) {
            return null;
        }
        Map<String, List<Long>> removeContractTransactionMap = new HashMap<>();

        //合约最多数据库保存数量
        int maxContractTxNum = Integer.parseInt(environment.getProperty(ConfCenterConstants.MAX_CONTRACT_TX_SAVA, "10"));

        Set<String> contractAddressSet = contractTransactionMap.keySet();
        for (String contractAddress : contractAddressSet) {
            CommonResultDTO<List<ThanosContractTransactionDTO>> resultDTO = thanosChainDomain.getThanosTransactionFacadeService().queryLastContractTxByContractAddressAndOffset(contractAddress, maxContractTxNum);

            if (!CollectionUtils.isEmpty(resultDTO.getResult())) {
                List<Long> ids = new ArrayList<>();
                for (ThanosContractTransactionDTO thanosContractTransactionDTO : resultDTO.getResult()) {
                    ids.add(thanosContractTransactionDTO.getId());
                }
                removeContractTransactionMap.put(contractAddress, ids);
            }
        }
        return removeContractTransactionMap;
    }

    /**
     * 查询合约详情信息
     *
     * @param thanosContractDTOList
     */
    public void handleContractDetail(List<ThanosContractDTO> thanosContractDTOList) {
        if (CollectionUtils.isEmpty(thanosContractDTOList)) {
            return;
        }
        Web3j web3j = chainAdapter.getWeb3jRandomly();
        if (web3j == null) {
            log.error("doBlockTnxExport failed. no available web3j.");
            return;
        }
        try {
            for (ThanosContractDTO thanosContractDTO : thanosContractDTOList) {
                NFTToken nftToken = NFTToken.load(thanosContractDTO.getContractAddress(), web3j, credentials, SystemConstant.GAS_PRICE, SystemConstant.GAS_LIMIT);

                ContractProtocolEnum contractProtocol = ContractProtocolEnum.NO;
                Bytes4 bytes_721 = new Bytes4(Numeric.hexStringToByteArray(INTERFACE_ID_ERC721));
                Bool flag = nftToken.supportsInterface(bytes_721).get();
                if (flag != null && flag.getValue() != null && flag.getValue()) {
                    contractProtocol = ContractProtocolEnum.NFT721;
                } else {
                    Bytes4 bytes_1155 = new Bytes4(Numeric.hexStringToByteArray(INTERFACE_ID_ERC1155));
                    Bool flag2 = nftToken.supportsInterface(bytes_1155).get();
                    if (flag2 != null && flag2.getValue() != null && flag2.getValue()) {
                        contractProtocol = ContractProtocolEnum.NFT1155;
                    }
                }

                thanosContractDTO.setContractProtocol(contractProtocol.getProtocolType());

                if (contractProtocol != ContractProtocolEnum.NO) {
                    List<Type> types = nftToken.getTokenMeta().get();
                    if (CollectionUtils.isNotEmpty(types)) {
                        String name = ((Utf8String) types.get(0)).getValue();
                        String description = ((Utf8String) types.get(2)).getValue();

                        thanosContractDTO.setContractName(name);
                        thanosContractDTO.setContractDescription(description);
                    }

                    Uint256 uint256 = nftToken.totalLimitSupply().get();
                    if (uint256 != null) {
                        int totalLimitSupply = uint256.getValue().intValue();
                        thanosContractDTO.setTotalLimitSupply(totalLimitSupply);
                    }
                }
            }
        } catch (Exception e) {
            log.error("handleContractDetail error ", e);
        }
    }


    /**
     * 处理交易信息
     *
     * @param block
     * @param receiptList
     * @return
     */
    public List<ThanosEvmTransactionDTO> handleTransactionsInfo(ThanosBlockDTO block, List<ThanosTransactionReceipt> receiptList) {
        List<ThanosEvmTransactionDTO> dtoList = new ArrayList<>();
        if (block == null || CollectionUtils.isEmpty(receiptList)) {
            return dtoList;
        }
        for (int i = 0; i < receiptList.size(); i++) {
            //处理单个交易
            ThanosTransactionReceipt receiptBo = receiptList.get(i);
            if (block == null || receiptBo == null) {
                return null;
            }
            ThanosEthTransaction tnxBo = receiptBo.getTransaction();
            ThanosEvmTransactionDTO dto = new ThanosEvmTransactionDTO();
            dto.setPkHash(Numeric.toHexString(tnxBo.getHash()));
            dto.setBlockHash(block.getPkHash());
            dto.setBlockNumber(block.getNumber());
            dto.setBlockTimestamp(block.getTimestamp());
            dto.setTransactionIndex((long) i);
            dto.setTransactionFrom(Numeric.toHexString(tnxBo.getSendAddress()));
            dto.setGasLimit(ByteUtil.byteArrayToLong(tnxBo.getGasLimit()));
            if (ArrayUtils.isNotEmpty(tnxBo.getGasPrice())) {
                dto.setGasPrice(new BigDecimal(ByteUtil.byteArrayToLong(tnxBo.getGasPrice())));
            }
            dto.setRandomId(Numeric.toHexString(tnxBo.getNonce()));
            //目前所有交易都是调用合约执行的，接收地址即为合约地址
            if (ArrayUtils.isNotEmpty(tnxBo.getReceiveAddress())) {
                dto.setContractAddress(Numeric.toHexString(tnxBo.getReceiveAddress()));
                dto.setTransactionTo(dto.getContractAddress());
            }

            if (ArrayUtils.isNotEmpty(tnxBo.getData())) {
                dto.setInputText(Numeric.toHexString(tnxBo.getData()));
//                if (dto.getInputText().startsWith(MethodAnalyzer.TRANSFER_SIGN)) {
//                    dto.setMethod(MethodAnalyzer.Token.getTransferSign());
//                    List<Type> types = MethodAnalyzer.Token.getTransferTypeList(dto.getInputText());
//                    dto.setTransactionTo(Numeric.prependHexPrefix(types.get(0).toString()));
//                    dto.setParams(JSON.toJSONString(types));
//                } else if (dto.getInputText().startsWith(MethodAnalyzer.MAIL_STORE_SIGN)) {
//                    dto.setMethod(MethodAnalyzer.Mail.getStoreSign());
//                    List<Type> types = MethodAnalyzer.Mail.getStoreTypeList(dto.getInputText());
//                    dto.setParams(JSON.toJSONString(types));
//                }
            }
            dto.setDagExecuteStatus(JSON.toJSONString(tnxBo.getExecuteStates()));
            if (StringUtils.isNotBlank(receiptBo.getError())) {
                //执行回执中错误信息不为空，表示交易执行失败
                dto.setTradeStat(0);
            } else {
                dto.setTradeStat(1);
            }
            dtoList.add(dto);
        }
        return dtoList;
    }


    /**
     * thanosEvmTransactionReceiptBo2DTOList 转换
     *
     * @param block
     * @param receiptList
     * @return
     */
    private void handleTransactionsAndReceipts(ThanosBlockDTO block, List<ThanosTransactionReceipt> receiptList, List<ThanosEvmTransactionDTO> txnDTOList, List<ThanosEvmTransactionReceiptDTO> receiptDTOList, List<ThanosContractDTO> thanosContractDTOList, Map<String, List<ThanosContractTransactionDTO>> contractTransactionMap) {
        if (block == null || CollectionUtils.isEmpty(receiptList)) {
            return;
        }

        for (int i = 0; i < receiptList.size(); i++) {
            ThanosTransactionReceipt receiptBo = receiptList.get(i);
            if (!StringUtils.isEmpty(receiptBo.getError()) && DS_CHECK_ERROR.equals(receiptBo.getError())) {
                continue;
            }
            long transactionIndex = (long) i;
            //1） 组装交易
            ThanosEthTransaction tnxBo = receiptBo.getTransaction();
            ThanosEvmTransactionDTO txnDTO = new ThanosEvmTransactionDTO();
            txnDTO.setPkHash(Numeric.toHexString(tnxBo.getHash()));
            txnDTO.setBlockHash(block.getPkHash());
            txnDTO.setBlockNumber(block.getNumber());
            txnDTO.setBlockTimestamp(block.getTimestamp());
            txnDTO.setTransactionIndex(transactionIndex);
            txnDTO.setTransactionFrom(Numeric.toHexString(tnxBo.getSendAddress()));
            txnDTO.setGasLimit(ByteUtil.byteArrayToLong(tnxBo.getGasLimit()));
            if (ArrayUtils.isNotEmpty(tnxBo.getGasPrice())) {
                txnDTO.setGasPrice(new BigDecimal(ByteUtil.byteArrayToLong(tnxBo.getGasPrice())));
            }
            txnDTO.setRandomId(Numeric.toHexString(tnxBo.getNonce()));
            //目前除部署交易外，所有交易都是调用合约执行的，接收地址即为合约地址
            if (ArrayUtils.isNotEmpty(tnxBo.getReceiveAddress())) {
                txnDTO.setContractAddress(Numeric.toHexString(tnxBo.getReceiveAddress()));
                txnDTO.setTransactionTo(txnDTO.getContractAddress());
            }
            if (ArrayUtils.isNotEmpty(tnxBo.getData())) {
                txnDTO.setInputText(Numeric.toHexString(tnxBo.getData()));
            }
            txnDTO.setDagExecuteStatus(JSON.toJSONString(tnxBo.getExecuteStates()));
            if (StringUtils.isNotBlank(receiptBo.getError())) {
                //执行回执中错误信息不为空，表示交易执行失败
                txnDTO.setTradeStat(0);
            } else {
                txnDTO.setTradeStat(1);
            }
            txnDTOList.add(txnDTO);

            //2） 组装交易回执
            ThanosEvmTransactionReceiptDTO receiptDTO = new ThanosEvmTransactionReceiptDTO();
            receiptDTO.setTransactionHash(Numeric.toHexString(receiptBo.getTransaction().getHash()));
            receiptDTO.setBlockHash(block.getPkHash());
            receiptDTO.setBlockNumber(block.getNumber());
            receiptDTO.setTransactionIndex(transactionIndex);
            receiptDTO.setGasUsed(ByteUtil.byteArrayToLong(receiptBo.getGasUsed()));
            receiptDTO.setLogs(JSON.toJSONString(receiptBo.getLogInfoList()));
            receiptDTO.setError(receiptBo.getError());
            if (ArrayUtils.isNotEmpty(receiptBo.getExecutionResult())) {
                receiptDTO.setExecutionResult(Numeric.toHexString(receiptBo.getExecutionResult()));
            }
            receiptDTOList.add(receiptDTO);


            //合约交易
            ThanosContractTransactionDTO thanosContractTransactionDTO = new ThanosContractTransactionDTO();
            thanosContractTransactionDTO.setContractAddress(txnDTO.getContractAddress());
            Long partitionKey = PartitionKeyUtil.getPartitionKey(txnDTO.getBlockTimestamp());
            thanosContractTransactionDTO.setPartitionKey(partitionKey);
            thanosContractTransactionDTO.setPkHash(txnDTO.getPkHash());

            ThanosContractTransactionDetailBo thanosContractTransactionDetailBo = new ThanosContractTransactionDetailBo();
            thanosContractTransactionDetailBo.setBlockNumber(txnDTO.getBlockNumber());
            thanosContractTransactionDetailBo.setBlockTimestamp(txnDTO.getBlockTimestamp());
            thanosContractTransactionDetailBo.setTransactionFrom(txnDTO.getTransactionFrom());
            thanosContractTransactionDetailBo.setTransactionTo(txnDTO.getTransactionTo());
            thanosContractTransactionDetailBo.setTradeStat(txnDTO.getTradeStat());
            thanosContractTransactionDTO.setTxDetail(JSON.toJSONString(thanosContractTransactionDetailBo));

            //合约部署失败的交易，不插入合约交易列表
            if (receiptBo.getTransaction().isContractCreation()) {
                //只有合约部署成功的交易进行保存
                if (StringUtils.isBlank(receiptBo.getError()) && ArrayUtils.isNotEmpty(receiptBo.getExecutionResult())) {
                    //合约创建
                    ThanosContractDTO contractDTO = new ThanosContractDTO();
                    contractDTO.setContractAddress(Numeric.toHexString(receiptBo.getExecutionResult()));
                    contractDTO.setContractDeployAddress(Numeric.toHexString(receiptBo.getTransaction().getSendAddress()));
                    thanosContractDTOList.add(contractDTO);

                    thanosContractTransactionDTO.setContractAddress(contractDTO.getContractAddress());

                    if (contractTransactionMap.containsKey(thanosContractTransactionDTO.getContractAddress())) {
                        contractTransactionMap.get(thanosContractTransactionDTO.getContractAddress()).add(thanosContractTransactionDTO);
                    } else {
                        List<ThanosContractTransactionDTO> thanosContractTransactionDTOList = new ArrayList<>();
                        thanosContractTransactionDTOList.add(thanosContractTransactionDTO);
                        contractTransactionMap.put(thanosContractTransactionDTO.getContractAddress(), thanosContractTransactionDTOList);
                    }
                }
            } else {
                //普通交易均插入
                if (contractTransactionMap.containsKey(thanosContractTransactionDTO.getContractAddress())) {
                    contractTransactionMap.get(thanosContractTransactionDTO.getContractAddress()).add(thanosContractTransactionDTO);
                } else {
                    List<ThanosContractTransactionDTO> thanosContractTransactionDTOList = new ArrayList<>();
                    thanosContractTransactionDTOList.add(thanosContractTransactionDTO);
                    contractTransactionMap.put(thanosContractTransactionDTO.getContractAddress(), thanosContractTransactionDTOList);
                }
            }
        }
        //这里区块存放的是有效交易数量，排除重复交易
        block.setEvmTnxNum((long) txnDTOList.size());
    }

}
