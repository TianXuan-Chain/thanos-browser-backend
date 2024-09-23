package com.netease.thanos.api.dto.thanos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 类ThanosChainDataDTO.java的实现描述：
 *
 * @author xuhao create on 2021/1/28 10:36
 */

@Data
public class ThanosChainDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private ThanosBlockchainInfoDTO thanosBlockchainInfoDTO;

    private ThanosBlockDTO thanosBlockDTO;

    private List<ThanosEvmTransactionDTO> thanosEvmTransactionDTOS;

    private List<ThanosEvmTransactionReceiptDTO> thanosEvmTransactionReceiptDTOS;

    private List<ThanosGlobalEventDTO> thanosGlobalNodeEventDTOS;

    /**
     * 新建合约
     */
    private List<ThanosContractDTO> thanosContractDTOList;

    /**
     * 合约交易
     */
    private  Map<String, List<ThanosContractTransactionDTO>> contractTransactionMap;

    /**
     * 合约交易列表信息，需要删除的合约
     */
    private Map<String, List<Long>> removeContractTransactionMap;

}
