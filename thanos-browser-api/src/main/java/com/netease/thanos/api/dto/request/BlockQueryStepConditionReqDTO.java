package com.netease.thanos.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类BlockQueryStepConditionReqDTO.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class BlockQueryStepConditionReqDTO implements Serializable {
    private Integer number;

    private String pkHash;

    private String startTime;

    private String endTime;

    /**
     *  取最后一页的pagesize.
     */
    private Integer lastPageSize;

    /**
     * 下一页(min)或者上一页Id(max)，
     */
    private Long startId;

    /**
     * 类型，1下一页，2上一页
     */
    private Integer type;

    /**
     * 取多少条
     */
    private Integer pageSize;
}
