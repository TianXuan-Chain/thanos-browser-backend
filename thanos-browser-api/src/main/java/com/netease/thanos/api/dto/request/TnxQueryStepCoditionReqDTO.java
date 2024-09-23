package com.netease.thanos.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类TnxQueryStepCoditionReqDTO.java 的实现描述: 支持上一页下一页
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class TnxQueryStepCoditionReqDTO implements Serializable {

    /**
     * 交易地址
     */
    private String bcAddress;

    /**
     * 交易hash
     */
    private String txnHash;

    /**
     * 块的num
     */
    private Integer blockNumber;

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

    /**
     *  取最后一页的pagesize.
     */
    private Integer lastPageSize;

    /**
     * startId 对应的块number
     */
    private Integer startBlockNumber;

    /**
     * 存证数据hash
     */
    private String bizData;

}