package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_evm_transactionReceipt表数据实体对象
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:27
 */ 
@Data
public class ThanosEvmTransactionreceipt implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 交易hash值
     */
    private String transactionHash;

    /**
     * 块hash值
     */
    private String blockHash;

    /**
     * 块高
     */
    private Long blockNumber;

    /**
     * 交易顺序
     */
    private Long transactionIndex;

    /**
     * 已用gas
     */
    private Long gasUsed;

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