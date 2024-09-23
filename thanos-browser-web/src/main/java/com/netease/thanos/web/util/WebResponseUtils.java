package com.netease.thanos.web.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 类WebResponseUtils.java的实现描述：处理 WebResponse对象工具类
 *
 * @author chenws 2017年3月29日 下午4:37:49
 */
public class WebResponseUtils<T> {

    /**
     * @param code 返回结果枚举
     * @return
     */
    public static <T> WebResponse<T> response(ResponseCodeEnum code) {
        return response(code, null);
    }

    public static <T> WebResponse<T> success(T t) {
        return response(ResponseCodeEnum.OK, ResponseCodeEnum.OK.getRemark(), t);
    }

    public static <T> WebResponse<T> error(String desc) {
        return response(ResponseCodeEnum.COMMON_ERROR, desc);
    }

    public static <T> WebResponse<T> response(ResponseCodeEnum code, String msg, T t) {
        WebResponse<T> response = response(code, msg);
        response.setData(t);
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
