package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_evidence_chain_user表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月23日15:59:18
 */ 
@Data
public class NvDepositEvidenceChainUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

    /**
     * 合约地址
     */
    private Long evidenceChainId;

    /**
     * 关联用户
     */
    private String relateUser;

    /**
     * 用户区块链地址
     */
    private String relateUserAddress;

    /**
     * 用户关联企业
     */
    private String relateCorporation;

    /**
     * 分区字段
     */
    private Integer partitionKey;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}