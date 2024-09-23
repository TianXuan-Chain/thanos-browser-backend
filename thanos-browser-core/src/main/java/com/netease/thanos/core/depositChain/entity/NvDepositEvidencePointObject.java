package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_evidence_point_object表数据实体对象
 * 
 * @author db-generator
 * @since 2021年06月17日16:10:34
 */ 
@Data
public class NvDepositEvidencePointObject extends NvDepositEvidencePointObjectKey implements Serializable {
    private static final long serialVersionUID = 1L;

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
     * 上链时间
     */
    private Date txTime;

    /**
     * 交易数据
     */
    private String txData;

    /**
     * 交易序列码
     */
    private String txDataSerialNumber;

    /**
     * 方法名
     */
    private String txDataFuncName;

    /**
     * 关联对象
     */
    private String txDataRelateObject;

    /**
     * 关联企业
     */
    private String txDataRelateCorporation;

    /**
     * 关联用户
     */
    private String txDataRelateUser;

    /**
     * 交易数据
     */
    private String txDataAllparamsHash;

    /**
     * 部分参数哈希值
     */
    private String txDataPartparamsHashjson;

    /**
     * 数据备注
     */
    private String txDataRemark;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}