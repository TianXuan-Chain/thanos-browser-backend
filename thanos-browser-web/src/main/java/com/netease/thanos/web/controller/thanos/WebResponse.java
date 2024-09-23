package com.netease.thanos.web.controller.thanos;

import lombok.ToString;

import java.io.Serializable;

/**
 * web返回类
 * Created by wangting04 on 2018/07/14
 */
@ToString
public class WebResponse<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
