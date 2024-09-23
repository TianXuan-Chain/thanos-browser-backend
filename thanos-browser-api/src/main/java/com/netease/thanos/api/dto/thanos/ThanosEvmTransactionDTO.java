package com.netease.thanos.api.dto.thanos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class ThanosEvmTransactionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 交易hash值
     */
    private String pkHash;

    /**
     * 块hash值
     */
    private String blockHash;

    /**
     * 块高
     */
    private Long blockNumber;

    /**
     * 区块生成时间
     */
    private Date blockTimestamp;

    /**
     * 交易下标
     */
    private Long transactionIndex;

    /**
     * 发起地址
     */
    private String transactionFrom;

    /**
     * 接收地址
     */
    private String transactionTo;

    /**
     * gas限制
     */
    private Long gasLimit;

    /**
     * gas价格
     */
    private BigDecimal gasPrice;

    /**
     * 交易nonce值
     */
    private String randomId;

    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 合约名
     */
    private String contractName;

    /**
     * 合约版本
     */
    private String contractVersion;

    /**
     * 被调用的合约中的函数名
     */
    private String method;

    /**
     * 上链事件hash
     */
    private String bizData;

    /**
     * 交易类型（未知-1、加载中0、转账1、抽签1、存证3、合约部署4）
     */
    private Integer transactionType;

    /**
     * 被调用的函数的参数
     */
    private String params;

    /**
     * 交易调用字符串
     */
    private String inputText;

    /**
     * 交易dag执行状态
     */
    private String dagExecuteStatus;

    /**
     * 交易链上执行状态：1成功， 0失败
     */
    private Integer tradeStat;
}
