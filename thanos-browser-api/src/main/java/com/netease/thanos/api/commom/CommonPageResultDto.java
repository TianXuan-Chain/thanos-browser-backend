package com.netease.thanos.api.commom;

import java.io.Serializable;
import java.util.List;

/**
 * 类CommonResultDto.java的实现描述：公共返回结果类(带分页)
 * 
 * @author hzcaochongrui 2017年1月3日 上午9:42:05
 */
public class CommonPageResultDto<T> implements Serializable {

    
    private static final long serialVersionUID = -4557865009139715367L;
    //接口是否执行
    private boolean           isSuccessed;
    //执行结果
    private List<T>           result; 
    //总数
    private Long               totalCount;
    //错误代码
    private String            errorCode;
    //错误描述
    private String            errorDesc;

    public CommonPageResultDto(){
        isSuccessed = true;
    }

    public boolean isSuccessed() {
        return isSuccessed;
    }

    public void setSuccessed(boolean isSuccessed) {
        this.isSuccessed = isSuccessed;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

}
