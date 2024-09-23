package com.netease.thanos.core.depositChain.bo;

import lombok.Data;

import java.util.Date;

/**
 * 类 ThanosContractTransactionDetailBo.java 的实现描述: 合约交易详情信息
 * Created by wangting04 on 2023/06/15
 */
@Data
public class ThanosContractTransactionDetailBo {

    /**
     * 块高
     */
    private Long blockNumber;

    /**
     * 区块生成时间
     */
    private Date blockTimestamp;

    /**
     * 发起地址
     */
    private String transactionFrom;

    /**
     * 接收地址
     */
    private String transactionTo;


    /**
     * 交易链上执行状态：1成功， 0失败
     */
    private Integer tradeStat;
}
