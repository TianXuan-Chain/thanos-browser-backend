package com.netease.thanos.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类CommonResultDTO.java的实现描述：公共返回结果类(不带分页)
 *
 * @author hzcaochongrui 2019年5月21日 下午4:37:01
 */
@Data
@ToString
public class CommonResultDTO<T> implements Serializable {

    private static final long serialVersionUID = -3808490966757523348L;
    /**
     * 接口是否执行成功
     */
    private boolean isSuccessed;
    //接口执行结果
    private T result;
    //错误代码
    private ThanosErrorCodeDTO errorCode;
    //备注信息
    private String remark;

}
