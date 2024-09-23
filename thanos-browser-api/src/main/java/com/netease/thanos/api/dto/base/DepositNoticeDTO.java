package com.netease.thanos.api.dto.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * GameNoticeDTO.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
@Builder
public class DepositNoticeDTO implements Serializable {
    private Long id;

    /**
     * 创建用户
     */
    private String createUser;

    private String remark;

    private Date createTime;

    private Long version;

    private Date businessTime;

    /**
     * 消息内容
     */
    private String noticeInfo;

    /**
     * 是否上线
     */
    private int ifOnline;
}
