package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_global_event表数据实体对象
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:28
 */ 
@Data
public class ThanosGlobalEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 事件hash值
     */
    private String eventHash;

    /**
     * 块hash值
     */
    private String blockHash;

    /**
     * 块高
     */
    private Long blockNumber;

    /**
     * 事件发起者
     */
    private String senderAddress;

    /**
     * nonce值
     */
    private String nonce;

    /**
     * 事件类型码： 0-注册 1-退出
     */
    private Integer commandCode;

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
     * 事件数据（未解析）
     */
    private String rawData;
}