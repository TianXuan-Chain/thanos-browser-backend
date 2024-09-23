package com.netease.thanos.api.dto.deposit;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NvDepositEvidenceChainDTO implements Serializable {
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

    /**
     * 上链开始时间
     */
    private Date txStartTime;

    /**
     * 上链结束时间
     */
    private Date txEndTime;

    /**
     * 上链交易区块链列表
     */
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

}