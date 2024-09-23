package com.netease.thanos.api.commom;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类CommonResultDto.java的实现描述：公共返回结果类(不带分页)
 * 
 * @author hzcaochongrui 2017年1月3日 上午9:42:05
 */
@Data
@ToString
public class CommonResultDto<T> implements Serializable {

    
    private static final long serialVersionUID = -3808490966757523348L;
    /**
     * 接口是否执行成功
     */
    private boolean           isSuccessed;
    //接口执行结果
    private T                 result;
    //错误代码
    private NBassErrorCodeDTO errorCode;
    //备注信息
    private String            remark;

  

}
