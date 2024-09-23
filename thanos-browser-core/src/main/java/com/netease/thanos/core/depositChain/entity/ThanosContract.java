package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_contract表数据实体对象
 * 
 * @author db-generator
 * @since 2023年06月15日14:45:26
 */ 
@Data
public class ThanosContract implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 合约协议，1:721 2:1155 -1:未指定
     */
    private Integer contractProtocol;

    /**
     * 合约名称
     */
    private String contractName;

    /**
     * 合约部署者区块链地址
     */
    private String contractDeployAddress;

    /**
     * 合约描述信息
     */
    private String contractDescription;

    /**
     * 计划发行数量
     */
    private Integer totalLimitSupply;

    /**
     * 合约，扩展描述信息
     */
    private String extendInfo;

    private Date createTime;

    /**
     * 业务时间：真正发生的时间
     */
    private Date businessTime;

    private Long version;

    /**
     * 描述
     */
    private String remark;
}