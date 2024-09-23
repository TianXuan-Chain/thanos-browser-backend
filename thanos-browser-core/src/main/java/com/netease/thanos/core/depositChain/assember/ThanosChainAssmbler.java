package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.thanos.*;
import com.netease.thanos.core.depositChain.entity.*;
import com.netease.thanos.core.depositChain.util.PartitionKeyUtil;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 类ThanosChainAssmbler.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 17:28
 */

public class ThanosChainAssmbler {

    //---------------DTO2BO---------------------------------
    public static ThanosChainDataBo thanosChainDataDTO2Bo(ThanosChainDataDTO dto) {
        if (dto == null) {
            return null;
        }
        ThanosChainDataBo bo = new ThanosChainDataBo();
        bo.setThanosBlockchaininfo(thanosBlockchaininfoDTO2Bo(dto.getThanosBlockchainInfoDTO()));
        bo.setThanosBlock(thanosBlockDTO2Bo(dto.getThanosBlockDTO()));
        bo.setThanosEvmTransactions(thanosEvmTransactionDTO2BoList(dto.getThanosEvmTransactionDTOS()));
        bo.setThanosEvmTransactionReceipts(thanosEvmTransactionReceiptDTO2BoList(dto.getThanosEvmTransactionReceiptDTOS()));
        bo.setThanosGlobalEvents(thanosGlobalEventDTO2BoList(dto.getThanosGlobalNodeEventDTOS()));
        bo.setThanosContracts(thanosContractDTO2BoList(dto.getThanosContractDTOList()));
        bo.setRemoveContractTransactionMap(dto.getRemoveContractTransactionMap());
        bo.setContractTransactionMap(thanosContractTransactionDTO2BoList(dto.getContractTransactionMap()));
        return bo;
    }

    /**
     * 转换
     *
     * @param contractTransactionMap
     * @return
     */
    private static Map<String, List<ThanosContractTransaction>> thanosContractTransactionDTO2BoList(Map<String, List<ThanosContractTransactionDTO>> contractTransactionMap) {
        if (contractTransactionMap == null || contractTransactionMap.isEmpty()) {
            return null;
        }
        Map<String, List<ThanosContractTransaction>> transactionMap = new HashMap<>();
        Set<String> keys = contractTransactionMap.keySet();

        for (String key : keys) {
            List<ThanosContractTransactionDTO> list = contractTransactionMap.get(key);
            List<ThanosContractTransaction> boList = new ArrayList<>();

            for (ThanosContractTransactionDTO dto : list) {
                ThanosContractTransaction thanosContractTransaction = new ThanosContractTransaction();
                thanosContractTransaction.setContractAddress(dto.getContractAddress());
                thanosContractTransaction.setPartitionKey(dto.getPartitionKey());
                thanosContractTransaction.setPkHash(dto.getPkHash());
                thanosContractTransaction.setTxDetail(dto.getTxDetail());
                boList.add(thanosContractTransaction);
            }
            transactionMap.put(key, boList);
        }

        return transactionMap;
    }

    /**
     * 转换
     *
     * @param thanosContractDTOList
     * @return
     */
    public static List<ThanosContract> thanosContractDTO2BoList(List<ThanosContractDTO> thanosContractDTOList) {
        if (CollectionUtils.isEmpty(thanosContractDTOList)) {
            return null;
        }
        List<ThanosContract> boList = new ArrayList<>();
        for (ThanosContractDTO dto : thanosContractDTOList) {
            ThanosContract bo = new ThanosContract();
            bo.setContractAddress(dto.getContractAddress());
            bo.setContractName(dto.getContractName());
            bo.setContractDescription(dto.getContractDescription());
            bo.setContractProtocol(dto.getContractProtocol());
            bo.setContractDeployAddress(dto.getContractDeployAddress());
            bo.setTotalLimitSupply(dto.getTotalLimitSupply());
            boList.add(bo);
        }
        return boList;
    }

    /**
     * thanosBlockDTO2Bo 转换
     *
     * @param dto
     * @return
     */
    public static ThanosBlock thanosBlockDTO2Bo(ThanosBlockDTO dto) {
        if (dto == null) {
            return null;
        }
        ThanosBlock bo = new ThanosBlock();
        bo.setPkHash(dto.getPkHash());
        bo.setNumber(dto.getNumber());
        bo.setEventId(dto.getEventId());
        bo.setPreEventId(dto.getPreEventId());
        bo.setEpoch(dto.getEpoch());
        bo.setTimestamp(dto.getTimestamp());
        bo.setEvmTnxNum(dto.getEvmTnxNum());
        bo.setGlobalEventNum(dto.getGlobalEventNum());
        bo.setDetailInfo(dto.getDetailInfo());
        return bo;
    }


    /**
     * thanosEvmTransactionWithBLOBs2DTO 转换
     *
     * @param dto
     * @return
     */
    public static ThanosEvmTransactionWithBLOBs thanosEvmTransactionDTO2Bo(ThanosEvmTransactionDTO dto) {
        if (dto == null) {
            return null;
        }
        ThanosEvmTransactionWithBLOBs bo = new ThanosEvmTransactionWithBLOBs();
        bo.setPkHash(dto.getPkHash());
        bo.setBlockHash(dto.getBlockHash());
        bo.setBlockNumber(dto.getBlockNumber());
        bo.setBlockTimestamp(dto.getBlockTimestamp());
        bo.setTransactionIndex(dto.getTransactionIndex());
        bo.setTransactionFrom(dto.getTransactionFrom());
        bo.setTransactionTo(dto.getTransactionTo());
        bo.setGasLimit(dto.getGasLimit());
        bo.setGasPrice(dto.getGasPrice());
        bo.setRandomId(dto.getRandomId());
        bo.setContractAddress(dto.getContractAddress());
        bo.setContractName(dto.getContractName());
        bo.setContractVersion(dto.getContractVersion());
        bo.setMethod(dto.getMethod());
        bo.setParams(dto.getParams());
        bo.setInputText(dto.getInputText());
        bo.setDagExecuteStatus(dto.getDagExecuteStatus());
        bo.setTradeStat(dto.getTradeStat());

        Long partitionKey = PartitionKeyUtil.getPartitionKey(dto.getBlockTimestamp());
        bo.setPartitionKey(partitionKey);

        return bo;
    }

    public static List<ThanosEvmTransactionWithBLOBs> thanosEvmTransactionDTO2BoList(List<ThanosEvmTransactionDTO> dtos) {
        List<ThanosEvmTransactionWithBLOBs> bos = new ArrayList<>();
        if (CollectionUtils.isEmpty(dtos)) {
            return bos;
        }
        for (ThanosEvmTransactionDTO dto : dtos) {
            ThanosEvmTransactionWithBLOBs bo = thanosEvmTransactionDTO2Bo(dto);
            bos.add(bo);
        }
        return bos;
    }

    /**
     * thanosEvmTransactionReceiptBo2DTO 转换
     *
     * @param dto
     * @return
     */
    public static ThanosEvmTransactionreceiptWithBLOBs thanosEvmTransactionReceiptDTO2Bo(ThanosEvmTransactionReceiptDTO dto) {
        if (dto == null) {
            return null;
        }
        ThanosEvmTransactionreceiptWithBLOBs bo = new ThanosEvmTransactionreceiptWithBLOBs();
        bo.setTransactionHash(dto.getTransactionHash());
        bo.setBlockHash(dto.getBlockHash());
        bo.setBlockNumber(dto.getBlockNumber());
        bo.setTransactionIndex(dto.getTransactionIndex());
        bo.setGasUsed(dto.getGasUsed());
        bo.setLogs(dto.getLogs());
        bo.setError(dto.getError());
        bo.setExecutionResult(dto.getExecutionResult());
        bo.setDetailInfo(bo.getDetailInfo());
        return bo;
    }

    public static List<ThanosEvmTransactionreceiptWithBLOBs> thanosEvmTransactionReceiptDTO2BoList(List<ThanosEvmTransactionReceiptDTO> dtos) {
        List<ThanosEvmTransactionreceiptWithBLOBs> bos = new ArrayList<>();
        if (CollectionUtils.isEmpty(dtos)) {
            return bos;
        }
        for (ThanosEvmTransactionReceiptDTO dto : dtos) {
            ThanosEvmTransactionreceiptWithBLOBs bo = thanosEvmTransactionReceiptDTO2Bo(dto);
            bos.add(bo);
        }
        return bos;
    }

    /**
     * thanosGlobalEventDTO2Bo 转换
     *
     * @param dto
     * @return
     */
    public static ThanosGlobalEvent thanosGlobalEventDTO2Bo(ThanosGlobalEventDTO dto) {
        if (dto == null) {
            return null;
        }
        ThanosGlobalEvent bo = new ThanosGlobalEvent();
        bo.setEventHash(dto.getEventHash());
        bo.setBlockHash(dto.getBlockHash());
        bo.setBlockNumber(dto.getBlockNumber());
        bo.setSenderAddress(dto.getSenderAddress());
        bo.setNonce(dto.getNonce());
        bo.setCommandCode(dto.getCommandCode());
        bo.setRawData(dto.getRawData());
        return bo;
    }

    public static List<ThanosGlobalEvent> thanosGlobalEventDTO2BoList(List<ThanosGlobalEventDTO> dtos) {
        List<ThanosGlobalEvent> bos = new ArrayList<>();
        if (CollectionUtils.isEmpty(dtos)) {
            return bos;
        }
        for (ThanosGlobalEventDTO dto : dtos) {
            ThanosGlobalEvent bo = thanosGlobalEventDTO2Bo(dto);
            bos.add(bo);
        }
        return bos;
    }

    /**
     * thanosBlockchaininfoDTO2Bo 转换
     *
     * @param dto
     * @return
     */
    public static ThanosBlockchaininfo thanosBlockchaininfoDTO2Bo(ThanosBlockchainInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        ThanosBlockchaininfo bo = new ThanosBlockchaininfo();
        bo.setLastBlockNum(dto.getLastBlockNum());
        bo.setTxnCount(dto.getTxnCount());
        bo.setEpoch(dto.getEpoch());
        bo.setEpoch(dto.getEpoch());
        bo.setRound(dto.getRound());
        bo.setAvgTime(dto.getAvgTime());
        return bo;
    }

    //---------------BO2DTO---------------------------------

    /**
     * thanosBlockBo2DTO 转换
     *
     * @param bo
     * @return
     */
    public static ThanosBlockDTO thanosBlockBo2DTO(ThanosBlock bo) {
        if (bo == null) {
            return null;
        }
        ThanosBlockDTO dto = new ThanosBlockDTO();
        dto.setPkHash(bo.getPkHash());
        dto.setNumber(bo.getNumber());
        dto.setEventId(bo.getEventId());
        dto.setPreEventId(bo.getPreEventId());
        dto.setEpoch(bo.getEpoch());
        dto.setTimestamp(bo.getTimestamp());
        dto.setEvmTnxNum(bo.getEvmTnxNum());
        dto.setGlobalEventNum(bo.getGlobalEventNum());
        dto.setDetailInfo(bo.getDetailInfo());
        return dto;
    }


    /**
     * thanosEvmTransactionWithBLOBs2DTO 转换
     *
     * @param bo
     * @return
     */
    public static ThanosEvmTransactionDTO thanosEvmTransactionWithBLOBs2DTO(ThanosEvmTransactionWithBLOBs bo) {
        if (bo == null) {
            return null;
        }
        ThanosEvmTransactionDTO dto = new ThanosEvmTransactionDTO();
        dto.setPkHash(bo.getPkHash());
        dto.setBlockHash(bo.getBlockHash());
        dto.setBlockNumber(bo.getBlockNumber());
        dto.setBlockTimestamp(bo.getBlockTimestamp());
        dto.setTransactionIndex(bo.getTransactionIndex());
        dto.setTransactionFrom(bo.getTransactionFrom());
        dto.setTransactionTo(bo.getTransactionTo());
        dto.setGasLimit(bo.getGasLimit());
        dto.setGasPrice(bo.getGasPrice());
        dto.setRandomId(bo.getRandomId());
        dto.setContractAddress(bo.getContractAddress());
        dto.setContractName(bo.getContractName());
        dto.setContractVersion(bo.getContractVersion());
        dto.setMethod(bo.getMethod());
        dto.setBizData(bo.getBizData());
        dto.setParams(bo.getParams());
        dto.setInputText(bo.getInputText());
        dto.setDagExecuteStatus(bo.getDagExecuteStatus());
        dto.setTradeStat(bo.getTradeStat());
        dto.setTransactionType(bo.getTransactionType());
        return dto;
    }

    /**
     * thanosEvmTransactionWithBLOBs2DTO 转换
     *
     * @param bo
     * @return
     */
    public static ThanosEvmTransactionDTO thanosEvmTransactionBo2DTO(ThanosEvmTransaction bo) {
        if (bo == null) {
            return null;
        }
        ThanosEvmTransactionDTO dto = new ThanosEvmTransactionDTO();
        dto.setPkHash(bo.getPkHash());
        dto.setBlockHash(bo.getBlockHash());
        dto.setBlockNumber(bo.getBlockNumber());
        dto.setBlockTimestamp(bo.getBlockTimestamp());
        dto.setTransactionIndex(bo.getTransactionIndex());
        dto.setTransactionFrom(bo.getTransactionFrom());
        dto.setTransactionTo(bo.getTransactionTo());
        dto.setGasLimit(bo.getGasLimit());
        dto.setGasPrice(bo.getGasPrice());
        dto.setRandomId(bo.getRandomId());
        dto.setContractAddress(bo.getContractAddress());
        dto.setContractName(bo.getContractName());
        dto.setContractVersion(bo.getContractVersion());
        dto.setMethod(bo.getMethod());
        dto.setBizData(bo.getBizData());
        dto.setTransactionType(bo.getTransactionType());
        dto.setTradeStat(bo.getTradeStat());
        return dto;
    }

    public static ThanosTnxByDayDTO thanosTnxByDayBo2DTO(ThanosTnxbyday bo) {
        if (bo == null) {
            return null;
        }
        ThanosTnxByDayDTO dto = new ThanosTnxByDayDTO();
        dto.setPkDate(bo.getPkDate());
        dto.setTxnCount(bo.getTxnCount());
        return dto;
    }

    public static List<ThanosTnxByDayDTO> thanosTnxByDayBo2DTOList(List<ThanosTnxbyday> bos) {
        List<ThanosTnxByDayDTO> dtos = new ArrayList<>();
        if (CollectionUtils.isEmpty(bos)) {
            return dtos;
        }
        for (ThanosTnxbyday bo : bos) {
            ThanosTnxByDayDTO dto = thanosTnxByDayBo2DTO(bo);
            dtos.add(dto);
        }
        return dtos;
    }

    public static ThanosBlockchainInfoDTO thanosBlockchaininfoBo2DTO(ThanosBlockchaininfo bo) {
        if (bo == null) {
            return null;
        }
        ThanosBlockchainInfoDTO dto = new ThanosBlockchainInfoDTO();
        dto.setLastBlockNum(bo.getLastBlockNum());
        dto.setTxnCount(bo.getTxnCount());
        dto.setEpoch(bo.getEpoch());
        dto.setEpoch(bo.getEpoch());
        dto.setRound(bo.getRound());
        dto.setAvgTime(bo.getAvgTime());
        return dto;
    }

    /**
     * 转换
     *
     * @param list
     * @return
     */
    public static List<ThanosContractTransactionDTO> thanosContractTransactionBo2DTO(List<ThanosContractTransaction> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<ThanosContractTransactionDTO> dtos = new ArrayList<>();
        for (ThanosContractTransaction bo : list) {
            ThanosContractTransactionDTO dto = new ThanosContractTransactionDTO();
            dto.setTxDetail(bo.getTxDetail());
            dto.setContractAddress(bo.getContractAddress());
            dto.setPartitionKey(bo.getPartitionKey());
            dto.setId(bo.getId());
            dto.setPkHash(bo.getPkHash());
            dtos.add(dto);
        }
        return dtos;
    }

    /**
     * 转换
     * @param thanosContract
     * @return
     */
    public static ThanosContractDTO thanosContract2Dto(ThanosContract thanosContract) {
        if (thanosContract == null) {
            return null;
        }

        ThanosContractDTO dto = new ThanosContractDTO();
        dto.setContractProtocol(thanosContract.getContractProtocol());
        dto.setContractAddress(thanosContract.getContractAddress());
        dto.setContractName(thanosContract.getContractName());
        dto.setContractDescription(thanosContract.getContractDescription());
        dto.setContractDeployAddress(thanosContract.getContractDeployAddress());
        dto.setTotalLimitSupply(thanosContract.getTotalLimitSupply());
        return dto;

    }
}
