package com.netease.thanos.web.controller.thanos;

import com.netease.thanos.web.util.ResponseCodeEnum;

import org.apache.commons.lang3.StringUtils;

/**
 * 类WebResponseUtils.java的实现描述：处理 WebResponse对象工具类
 * Created by wangting04 on 2018/07/14
 */
public class WebResponseUtils<T> {

    /**
     * 自定义错误码返回
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> WebResponse<T> responseWithErrorCode(String code, String msg, T data) {
        WebResponse<T> response = new WebResponse<T>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    /**
     * 返回自有 错误data
     * @param code
     * @param remark
     * @param <T>
     * @return
     */
    public static <T> WebResponse<T> responseWithErrorData(String code, String remark) {
        WebResponse<T> response = new WebResponse<T>();
        response.setCode(code);
        response.setMsg(remark);
        return response;
    }


    /**
     * @param code 返回结果枚举
     * @return
     */
    public static <T> WebResponse<T> response(ResponseCodeEnum code) {
        return response(code, null);
    }

    /**
     * @param code
     * @param data  指定返回信息内容
     * @param <T> 指定返回信息内容
     * @return
     */
    public static <T> WebResponse<T> responseWithData(ResponseCodeEnum code, T data) {
        WebResponse<T> response = new WebResponse<T>();
        response = response(code);
        response.setData(data);
        return response;
    }


    /**
     * @param code
     * @param msg  指定返回信息内容
     * @return
     */
    public static <T> WebResponse<T> response(ResponseCodeEnum code, String msg) {
        WebResponse<T> response = new WebResponse<T>();
        response.setCode(code.getCode().toString());
        if (StringUtils.isBlank(msg)) {
            response.setMsg(code.getRemark());
        } else {
            response.setMsg(msg);
        }
        return response;
    }

}
