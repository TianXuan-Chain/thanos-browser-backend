package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_evidence_process表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月15日15:30:05
 */ 
@Data
public class NvDepositEvidenceProcess implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

    /**
     * 区块解析类型
     */
    private Integer bizType;

    /**
     * 区块链解析进度
     */
    private Integer bizProcess;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}