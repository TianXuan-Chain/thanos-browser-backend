package com.netease.thanos.api.dto.deposit;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NvDepositEvidencePointCorporationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

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
     * 备注
     */
    private String txDataRemark;

}