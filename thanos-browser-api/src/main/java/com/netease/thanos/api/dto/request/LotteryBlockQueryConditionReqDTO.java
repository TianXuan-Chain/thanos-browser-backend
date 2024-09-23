package com.netease.thanos.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类LotteryBlockQueryConditionReqDTO.java 的实现描述:
 * Created by wang04ting on 2019/01/07
 */
@Getter
@Setter
@ToString
public class LotteryBlockQueryConditionReqDTO implements Serializable {

    private Integer number;

    private String pkHash;

    /**
     * 类型，1 最新一个  2 当然最新一个
     */
    private Integer type;
}
