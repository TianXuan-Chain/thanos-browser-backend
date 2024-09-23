package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * nv_deposit_contract_func_define表数据实体对象
 * 
 * @author db-generator
 * @since 2020年12月08日14:44:19
 */ 
@Data
public class NvDepositContractFuncDefine implements Serializable {
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
     * 方法名
     */
    private String funcName;

    /**
     * 方法参数定义
     */
    private String funcParams;

    /**
     * 合约方法签名
     */
    private String contractFuncSign;

    /**
     * 合约参数数量
     */
    private Integer contractFuncParamsLength;

    /**
     * 是否证据链主体事件
     */
    private Integer mainEvidenceDefine;

    /**
     * 是否为结束事件
     */
    private Integer endFunc;

    private Date createTime;

    private String remark;

    private Long version;

    private Date businessTime;
}