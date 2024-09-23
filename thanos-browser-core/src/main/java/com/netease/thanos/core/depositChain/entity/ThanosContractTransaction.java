package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * thanos_contract_transaction表数据实体对象
 * 
 * @author db-generator
 * @since 2023年06月15日14:45:26
 */ 
@Data
public class ThanosContractTransaction extends ThanosContractTransactionKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 交易hash值
     */
    private String pkHash;

    /**
     * 交易时间Key
     */
    private Long partitionKey;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 业务时间
     */
    private Date businessTime;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 备注
     */
    private String remark;

    /**
     * 交易详情
     */
    private String txDetail;
}