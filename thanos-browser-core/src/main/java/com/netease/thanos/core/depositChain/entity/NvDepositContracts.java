package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_contracts表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月27日17:43:46
 */ 
@Data
public class NvDepositContracts implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

    /**
     * 业务类型
     */
    private Integer bizType;

    /**
     * 业务详细名称
     */
    private String bizFullName;

    /**
     * 业务详细区块链地址
     */
    private String bizAddress;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}