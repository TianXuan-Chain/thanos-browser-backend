package com.netease.thanos.web.assember;

import com.alibaba.fastjson.JSON;
import com.netease.thanos.api.dto.thanos.ThanosBlockDTO;
import com.netease.thanos.api.dto.thanos.ThanosEvmTransactionReceiptDTO;
import com.netease.thanos.api.dto.thanos.ThanosGlobalEventDTO;
import com.thanos.common.utils.ByteUtil;
import com.thanos.web3j.model.ThanosBlock;
import com.thanos.web3j.model.ThanosGlobalNodeEvent;
import com.thanos.web3j.model.ThanosTransactionReceipt;
import com.thanos.web3j.utils.Numeric;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类ThanosBlockChainAssmbler.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 17:28
 */

public class ThanosBlockChainAssmbler {

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
        dto.setPkHash(Numeric.toHexString(bo.getHash()));
        dto.setNumber(bo.getNumber());
        dto.setEventId(Numeric.toHexString(bo.getEventId()));
        dto.setPreEventId(Numeric.toHexString(bo.getPreEventId()));
        dto.setEpoch(bo.getEpoch());
        dto.setTimestamp(new Date(bo.getTimestamp()));
        if (CollectionUtils.isEmpty(bo.getReceiptList())) {
            dto.setEvmTnxNum(0L);
        } else {
            dto.setEvmTnxNum((long) bo.getReceiptList().size());
        }
        if (CollectionUtils.isEmpty(bo.getGlobalEventList())) {
            dto.setGlobalEventNum(0L);
        } else {
            dto.setGlobalEventNum((long) bo.getGlobalEventList().size());
        }
        return dto;
    }


//    /**
//     * thanosEvmTransactionWithBLOBs2DTO 转换
//     *
//     * @param block
//     * @param tnxBo
//     * @param index
//     * @return
//     */
//    public static ThanosEvmTransactionDTO thanosEvmTransactionWithBLOBs2DTO(ThanosBlockDTO block, ThanosTransaction tnxBo, long index) {
//        if (block == null || tnxBo == null) {
//            return null;
//        }
//        ThanosEvmTransactionDTO dto = new ThanosEvmTransactionDTO();
//        dto.setHash(Numeric.toHexString(tnxBo.getHash()));
//        dto.setBlockHash(block.getHash());
//        dto.setBlockNumber(block.getNumber());
//        dto.setBlockTimestamp(block.getTimestamp());
//        dto.setTransactionIndex(index);
//        dto.setTransactionFrom(Numeric.toHexString(tnxBo.getSendAddress()));
//        if (ArrayUtils.isNotEmpty(tnxBo.getReceiveAddress())) {
//            dto.setTransactionTo(Numeric.toHexString(tnxBo.getReceiveAddress()));
//        }
//        dto.setGasLimit(ByteUtil.byteArrayToLong(tnxBo.getGasLimit()));
//        if (ArrayUtils.isNotEmpty(tnxBo.getGasPrice())) {
//            dto.setGasPrice(new BigDecimal(ByteUtil.byteArrayToLong(tnxBo.getGasPrice())));
//        }
//        dto.setInputText(Numeric.toHexString(tnxBo.getData()));
//        dto.setRandomId(Numeric.toHexString(tnxBo.getNonce()));
//        return dto;
//    }
//
//    /**
//     * thanosEvmTransactionBo2DTOList 转换
//     *
//     * @param block
//     * @param tnxList
//     * @return
//     */
//    public static List<ThanosEvmTransactionDTO> thanosEvmTransactionBo2DTOList(ThanosBlockDTO block, List<ThanosTransaction> tnxList) {
//        List<ThanosEvmTransactionDTO> dtoList = new ArrayList<>();
//        if (block == null || CollectionUtils.isEmpty(tnxList)) {
//            return dtoList;
//        }
//        for (int i = 0; i < tnxList.size(); i++) {
//            dtoList.add(thanosEvmTransactionWithBLOBs2DTO(block, tnxList.get(i), i));
//        }
//        return dtoList;
//    }


    /**
     * thanosEvmTransactionReceiptBo2DTO 转换
     *
     * @param blockBo
     * @param receiptBo
     * @param index
     * @return
     */
    public static ThanosEvmTransactionReceiptDTO thanosEvmTransactionReceiptBo2DTO(ThanosBlockDTO blockBo, ThanosTransactionReceipt receiptBo, long index) {
        if (blockBo == null || receiptBo == null) {
            return null;
        }
        ThanosEvmTransactionReceiptDTO dto = new ThanosEvmTransactionReceiptDTO();
        dto.setTransactionHash(Numeric.toHexString(receiptBo.getTransaction().getHash()));
        dto.setBlockHash(blockBo.getPkHash());
        dto.setBlockNumber(blockBo.getNumber());
        dto.setTransactionIndex(index);
        dto.setGasUsed(ByteUtil.byteArrayToLong(receiptBo.getGasUsed()));
        dto.setLogs(JSON.toJSONString(receiptBo.getLogInfoList()));
        dto.setError(receiptBo.getError());
        if (ArrayUtils.isNotEmpty(receiptBo.getExecutionResult())) {
            dto.setExecutionResult(Numeric.toHexString(receiptBo.getExecutionResult()));
        }
        return dto;
    }

    /**
     * thanosEvmTransactionReceiptBo2DTOList 转换
     *
     * @param block
     * @param receiptList
     * @return
     */
    public static List<ThanosEvmTransactionReceiptDTO> thanosEvmTransactionReceiptBo2DTOList(ThanosBlockDTO block, List<ThanosTransactionReceipt> receiptList) {
        List<ThanosEvmTransactionReceiptDTO> dtoList = new ArrayList<>();
        if (block == null || CollectionUtils.isEmpty(receiptList)) {
            return dtoList;
        }
        for (int i = 0; i < receiptList.size(); i++) {
            dtoList.add(thanosEvmTransactionReceiptBo2DTO(block, receiptList.get(i), i));
        }
        return dtoList;
    }

    /**
     * thanosGlobalEventBo2DTO 转换
     *
     * @param bo
     * @return
     */
    public static ThanosGlobalEventDTO thanosGlobalEventBo2DTO(ThanosBlockDTO block, ThanosGlobalNodeEvent bo) {
        if (bo == null) {
            return null;
        }
        ThanosGlobalEventDTO dto = new ThanosGlobalEventDTO();
        dto.setEventHash(Numeric.toHexString(bo.getHash()));
        dto.setBlockHash(block.getPkHash());
        dto.setBlockNumber(block.getNumber());
        dto.setNonce(com.thanos.common.utils.Numeric.toHexString(bo.getNonce()));
        dto.setSenderAddress(com.thanos.common.utils.Numeric.toHexString(bo.getSendAddress()));
        dto.setCommandCode((int) bo.getCommandCode());
        dto.setRawData(com.thanos.common.utils.Numeric.toHexString(bo.getData()));
        return dto;
    }

    /**
     * thanosEvmTransactionReceiptBo2DTOList 转换
     *
     * @param eventList
     * @return
     */
    public static List<ThanosGlobalEventDTO> thanosGlobalEventBo2DTOList(ThanosBlockDTO block, List<ThanosGlobalNodeEvent> eventList) {
        List<ThanosGlobalEventDTO> dtoList = new ArrayList<>();
        if (block == null || CollectionUtils.isEmpty(eventList)) {
            return dtoList;
        }
        for (ThanosGlobalNodeEvent event : eventList) {
            dtoList.add(thanosGlobalEventBo2DTO(block, event));
        }
        return dtoList;
    }
}
