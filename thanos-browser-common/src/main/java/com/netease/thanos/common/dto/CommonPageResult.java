package com.netease.thanos.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 类CommonResultDto.java的实现描述：公共返回结果类(带分页)
 *
 * @author hzcaochongrui 2017年1月3日 上午9:42:05
 */
@Data
@ToString
public class CommonPageResult<T> implements Serializable {

    private static final long serialVersionUID = -4557865009139715367L;
    //接口是否执行
    private boolean isSuccessed = true;
    //执行结果
    private List<T> result;
    //总数
    private int totalCount = 0;
    //每页多少条
    private int pageSize = 0;
    //总页数
    private int pageTotal = 0;
    //错误代码
    private ThanosErrorCodeDTO errorCode;


}
