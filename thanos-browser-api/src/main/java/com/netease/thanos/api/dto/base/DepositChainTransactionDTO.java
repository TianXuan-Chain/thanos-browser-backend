package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class DepositChainTransactionDTO implements Serializable {
    private Long id;
    private String pkHash;//	TxHash
    private Long partitionKey;
    private String bcAddress; //交易这地址
    private String blockHash;//	所属块  （更具区块hash跳转区块详情）
    private Integer blockNumber; //块number
    private Timestamp blockTimestamp; //出块时间
    private Long blockGasLimit;//Gas Limit
    private Long transactionIndex; //交易块内id
    private String transactionFrom;    //发送者
    private String transactionTo;    //接受者
    private String contractAddress;
    private Long gas;//Used By Txn
    private BigDecimal gasPrice;
    private Long cumulativeGas;
    private String randomId;
    private String inputText;//Input Data
    private String contractName;
    private String version;
    private String method;
    private String params;
    private String traceId;
    private String realTime;

    private int tradeStat; //交易成功失败状态  1成功， 0失败

    private Long txnMoney;

    private int ifBatch; //是否批次
    private String batchHash; //批次真实Hash
    private int batchNum; //批次的当前第几笔
    private int batchCount;//批次的总笔数
    private BigDecimal coin; //金额
    /**
     * 存放的业务数据
     */
    private String bizData;
}
