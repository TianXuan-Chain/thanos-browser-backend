package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainTransactionDTO;
import com.netease.thanos.api.dto.response.TransactionInfoResponseDTO;
import com.netease.thanos.core.depositChain.bo.BcTransactionBO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */

@Slf4j
public class DepositChainTransactionAssembler {

    public final static String NFX_MERCHANT_POOL = "0xee572016864622f66638b016e6c282e437d812ac";
    public final static String NFX_USER_POOL = "0x60e7e5893c77353dc4ed28d23624553da221e474";


    public static BcTransactionBO dto2Bo(DepositChainTransactionDTO source) {
        BcTransactionBO dest = new BcTransactionBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcTransactionBO> dtos2Bos(List<DepositChainTransactionDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcTransactionBO> result = new ArrayList<>();
        for (DepositChainTransactionDTO source : sources) {
            BcTransactionBO dest = new BcTransactionBO();
            dest.setBatchCount(source.getBatchCount());
            dest.setBatchHash(source.getBatchHash());
            dest.setBatchNum(source.getBatchNum());
            dest.setBcAddress(source.getBcAddress());
            dest.setBlockGasLimit(source.getBlockGasLimit());
            dest.setBlockHash(source.getBlockHash());
            dest.setBlockNumber(source.getBlockNumber());
            dest.setBlockTimestamp(source.getBlockTimestamp());
            dest.setCoin(source.getCoin());
            dest.setContractAddress(source.getContractAddress());
            dest.setContractName(source.getContractName());
            dest.setCumulativeGas(source.getCumulativeGas());
            dest.setGas(source.getGas());
            dest.setGasPrice(source.getGasPrice());
            dest.setId(source.getId());
            dest.setIfBatch(source.getIfBatch());
            dest.setInputText(source.getInputText());
            dest.setMethod(source.getMethod());
            dest.setParams(source.getParams());
            dest.setPartitionKey(source.getPartitionKey());
            dest.setPkHash(source.getPkHash());
            dest.setRandomId(source.getRandomId());
            dest.setRealTime(source.getRealTime());
            dest.setTraceId(source.getTraceId());
            dest.setTradeStat(source.getTradeStat());
            dest.setTransactionFrom(source.getTransactionFrom());
            dest.setTransactionIndex(source.getTransactionIndex());
            dest.setTransactionTo(source.getTransactionTo());
            dest.setVersion(source.getVersion());
            dest.setBizData(source.getBizData());
            //BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }


    public static TransactionInfoResponseDTO bo2ResponseDto(BcTransactionBO source) {
        TransactionInfoResponseDTO dest = new TransactionInfoResponseDTO();
        BeanUtils.copyProperties(source, dest);

		/*
		 * if (source.getInputText().startsWith(BlockChainMethodPreifx.TRANSFER_SIGN)) {
		 * try { List<Type> types =
		 * TokenMethod.getTransferValTypeList(source.getInputText()); if
		 * (!CollectionUtils.isEmpty(types)) {
		 * dest.setTxnMoney(Long.parseLong(types.get(1).getValue().toString())); } }
		 * catch (Exception e) { log.warn("bo2ResponseDto setTxnMoney error, pkid:{}",
		 * source.getId()); dest.setTxnMoney(0L); } } else if
		 * (source.getInputText().startsWith(BlockChainMethodPreifx.BATCH_METHOD_SIGN))
		 * { dest.setTxnMoney(source.getCoin().multiply(BigDecimal.valueOf(100000000L)).
		 * longValue()); } else { dest.setTxnMoney((null == source.getCoin() ?
		 * BigDecimal.ZERO :
		 * source.getCoin()).multiply(BigDecimal.valueOf(100000000L)).longValue()); }
		 */
        return dest;
    }


    public static List<TransactionInfoResponseDTO> bo2ResponseDtos(List<BcTransactionBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<TransactionInfoResponseDTO> result = new ArrayList<>();
        for (BcTransactionBO source : sources) {
            TransactionInfoResponseDTO dest = new TransactionInfoResponseDTO();
            BeanUtils.copyProperties(source, dest);

			/*
			 * if (source.getInputText().startsWith(BlockChainMethodPreifx.TRANSFER_SIGN)) {
			 * try { List<Type> types =
			 * TokenMethod.getTransferValTypeList(source.getInputText()); if
			 * (!CollectionUtils.isEmpty(types)) {
			 * dest.setTxnMoney(Long.parseLong(types.get(1).getValue().toString())); } }
			 * catch (Exception e) { log.warn("bo2ResponseDtos setTxnMoney error, pkid:{}",
			 * source.getId()); dest.setTxnMoney(0L); } } else if
			 * (source.getInputText().startsWith(BlockChainMethodPreifx.BATCH_METHOD_SIGN))
			 * { dest.setTxnMoney((null == source.getCoin() ? BigDecimal.ZERO :
			 * source.getCoin()).multiply(BigDecimal.valueOf(100000000L)).longValue()); }
			 * else { dest.setTxnMoney((null == source.getCoin() ? BigDecimal.ZERO :
			 * source.getCoin()).multiply(BigDecimal.valueOf(100000000L)).longValue()); }
			 */
            result.add(dest);
        }
        return result;
    }

    public static BcTransactionBO copyGameChainTransactionBo(BcTransactionBO bo) {
        BcTransactionBO copyBo = new BcTransactionBO();
        BeanUtils.copyProperties(bo, copyBo);
        return copyBo;
    }


}
