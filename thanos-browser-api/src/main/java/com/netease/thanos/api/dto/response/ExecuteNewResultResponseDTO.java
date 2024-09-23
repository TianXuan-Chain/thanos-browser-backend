package com.netease.thanos.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类ExecuteNewResultResponseDTO.java 的实现描述:
 * Created by wangting04 on 2018/09/25
 */
@Getter
@Setter
@ToString
public class ExecuteNewResultResponseDTO implements Serializable {

    private String traceId;

    private Boolean result;

    private String errorType;
    private String errorReason;


    private int ifBatch; //是否批次
    private String pkHash; //交易真实Hash
    private int batchNum; //批次的当前第几笔
    private int batchCount;//批次的总笔数

}
