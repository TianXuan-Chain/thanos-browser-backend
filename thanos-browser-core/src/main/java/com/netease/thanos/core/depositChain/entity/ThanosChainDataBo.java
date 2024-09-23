package com.netease.thanos.core.depositChain.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 类ThanosChainData.java的实现描述：
 *
 * @author xuhao create on 2021/1/28 11:34
 */

@Data
public class ThanosChainDataBo {

    private ThanosBlockchaininfo thanosBlockchaininfo;

    private ThanosBlock thanosBlock;

    private List<ThanosEvmTransactionWithBLOBs> thanosEvmTransactions;

    private List<ThanosEvmTransactionreceiptWithBLOBs> thanosEvmTransactionReceipts;

    private List<ThanosGlobalEvent> thanosGlobalEvents;


    private List<ThanosContract> thanosContracts;

    /**
     * 合约交易
     */
    private Map<String, List<ThanosContractTransaction>> contractTransactionMap;

    private Map<String, List<Long>> removeContractTransactionMap;
}
