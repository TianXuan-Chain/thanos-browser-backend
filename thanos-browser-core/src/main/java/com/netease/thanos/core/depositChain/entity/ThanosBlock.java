package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_block表数据实体对象
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:28
 */ 
@Data
public class ThanosBlock implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 块hash值
     */
    private String pkHash;

    /**
     * 高度
     */
    private Long number;

    /**
     * 事件id
     */
    private String eventId;

    /**
     * 父事件id
     */
    private String preEventId;

    /**
     * 共识时期
     */
    private Long epoch;

    /**
     * 时间戳
     */
    private Date timestamp;

    /**
     * 块包含的交易数
     */
    private Long evmTnxNum;

    /**
     * 块包含的交易数
     */
    private Long globalEventNum;

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

    /**
     * rpc查询结果的所有数据
     */
    private String detailInfo;
}