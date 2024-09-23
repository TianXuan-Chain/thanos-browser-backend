package com.netease.thanos.web.util;


import lombok.ToString;

import java.io.Serializable;

/**
 * 建议使用 {@link com.netease.star.immortal.stateless.commonresult.WebResponse}
 *
 * @param <T>
 */
@ToString
public class WebResponse<T> implements Serializable {

    private static final long serialVersionUID = 1971284630103470632L;

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
