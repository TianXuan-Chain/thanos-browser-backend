package com.netease.thanos.core.depositChain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class BcTransactionBO {
    private Long id;
    private String pkHash;//	TxHash
    private Long partitionKey;
    private String bcAddress;
    private String blockHash;//		VARCHAR	32
    private Integer blockNumber;
    private Timestamp blockTimestamp;
    private Long blockGasLimit;//Gas Limit
    private Long transactionIndex;
    private String transactionFrom;
    private String transactionTo;
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

    private int ifBatch; //是否批次
    private String batchHash; //批次真实Hash
    private int batchNum; //批次的当前第几笔
    private int batchCount;//批次的总笔数
    private BigDecimal coin; //金额
    
    private String bizData;//业务数据
 }
