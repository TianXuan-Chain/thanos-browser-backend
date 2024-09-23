package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_evidence_chain表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月17日17:53:37
 */ 
@Data
public class NvDepositEvidenceChain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 关联对象
     */
    private String relateObject;

    /**
     * 证据链交易hash
     */
    private String txHash;

    private Date txStartTime;

    private Date txEndTime;

    private String txsBlockheight;

    /**
     * 合同证据唯一编号
     */
    private String uniqueNumber;

    /**
     * 证据状态
     */
    private Integer onchainStatus;

    /**
     * 分区字段
     */
    private Integer partitionKey;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}