package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class DepositChainPendingTransactionDTO implements Serializable {
    private Long id;
    private String pkHash;//	TxHash
    private String blockHash;//		VARCHAR	32
    private Integer blockNumber;
    private Long transactionIndex;
    private String transactionFrom;
    private String transactionTo;
    private Long gas;//Used By Txn
    private BigDecimal gasPrice;
    private Long cumulativeGas;
    private String randomId;
    private String inputText;//Input Data
    private String queueType;
}
