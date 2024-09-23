package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_contract_ec_define表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月08日11:29:36
 */ 
@Data
public class NvDepositContractEcDefine implements Serializable {
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
     * 证据链关联用户事件
     */
    private String relateUserFuncList;

    /**
     * 证据链关联对象事件
     */
    private String relateObjectFuncList;

    /**
     * 证据链关联企业事件
     */
    private String relateCorporationFuncList;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}