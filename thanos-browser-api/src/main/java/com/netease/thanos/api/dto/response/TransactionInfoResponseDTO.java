package com.netease.thanos.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 类StarChainTransactionInfoResponseDTO.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class TransactionInfoResponseDTO implements Serializable {
    private Long id;
    private String pkHash;//	TxHash
    private String bcAddress; //交易这地址
    private String blockHash;//	所属块  （更具区块hash跳转区块详情）
    private Integer blockNumber; //块number
    private Timestamp blockTimestamp; //出块时间
    private Long transactionIndex; //交易块内id
    private String transactionFrom;    //发送者
    private String transactionTo;    //接受者
    private String contractAddress;
    private Long txnMoney;
    private int tradeStat; //交易成功失败状态  1成功， 0失败
    private String bizData;//业务数据
    
}
