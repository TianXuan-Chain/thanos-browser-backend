package com.netease.thanos.api.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 类StarChainTransactionInfoResponseDTO.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */

@Data
public class OriginTransactionResponseDTO implements Serializable {

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
    
}
