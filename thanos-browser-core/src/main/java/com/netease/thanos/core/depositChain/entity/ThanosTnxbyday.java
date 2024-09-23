package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_tnxByDay表数据实体对象
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:28
 */ 
@Data
public class ThanosTnxbyday implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 交易时间
     */
    private Date pkDate;

    /**
     * 交易量
     */
    private Long txnCount;

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