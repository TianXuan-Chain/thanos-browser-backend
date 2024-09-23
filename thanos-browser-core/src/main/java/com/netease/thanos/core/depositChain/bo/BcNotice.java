package com.netease.thanos.core.depositChain.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** 
 * bc_notice表数据实体对象
 * 
 * @author db-generator
 * @since 2018年08月09日15:17:29
 */ 
@Data
public class BcNotice implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 创建用户
     */
    private String createUser;

    private String remark;

    private Date createTime;

    private Integer ifOnline;

    private Long version;

    private Date businessTime;

    /**
     * 消息内容
     */
    private String noticeInfo;
}