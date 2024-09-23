package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_evm_transaction表数据实体对象
 * 
 * @author db-generator
 * @since 2021年08月26日10:47:24
 */ 
@Data
public class ThanosEvmTransaction extends ThanosEvmTransactionKey implements Serializable {
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
     * 交易类型，1合约部署，2合约调用
     */
    private Integer transactionType;

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
     * 交易链上执行状态：1成功， 0失败
     */
    private Integer tradeStat;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 版本
     */
    private Long version;

    /**
     * 描述
     */
    private String remark;
}