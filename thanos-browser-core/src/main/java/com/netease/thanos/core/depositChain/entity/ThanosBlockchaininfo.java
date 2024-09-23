package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_blockChainInfo表数据实体对象
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:28
 */ 
@Data
public class ThanosBlockchaininfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 最新块高
     */
    private Long lastBlockNum;

    /**
     * 交易量
     */
    private Long txnCount;

    /**
     * 共识纪元
     */
    private Long epoch;

    /**
     * 当前共识轮数
     */
    private Long round;

    /**
     * 相邻两个块的timestamp之差的平均值
     */
    private BigDecimal avgTime;

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