package com.netease.thanos.common.utils;

/**
 * @author hzliubenlong
 *         <p>
 *         统一错误编码
 */
public enum ErrorCodeEnum {

    OK(200, "请求成功"),
    COMMON_ERROR(-1, "网络异常，请稍后重试"),
    PASSWORD_ERROR(10001, "用户名或密码错误"),
    PARAMETER_ERROR(10002, "参数错误"),
    HTTPMETHOD_ERROR(10003, "RequestMethod不支持");

    private int code;
    private String remark;

    ErrorCodeEnum(int code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public int getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }

}
