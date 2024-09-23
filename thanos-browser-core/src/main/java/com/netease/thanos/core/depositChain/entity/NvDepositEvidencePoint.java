package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_evidence_point表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月08日13:42:51
 */ 
@Data
public class NvDepositEvidencePoint implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

    /**
     * 证据链编号
     */
    private Long evidenceChainId;

    /**
     * 来自渠道
     */
    private String contractAddress;

    /**
     * 交易id
     */
    private Long txId;

    /**
     * 交易hash
     */
    private String txHash;

    /**
     * 交易数据
     */
    private String txData;

    /**
     * 方法名
     */
    private String txDataFuncName;

    /**
     * 关联对象
     */
    private String txDataRelateObject;

    /**
     * 关联用户
     */
    private String txDataRelateUser;

    /**
     * 关联企业
     */
    private String txDataRelateCorporation;

    /**
     * 交易数据
     */
    private String txDataAllparamsHash;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}