package com.netease.thanos.web.util;


import com.netease.thanos.common.enums.BaseEnum;

public enum ResponseCodeEnum implements BaseEnum {

    /**
     * 请求成功
     **/
    OK(200, "请求成功"),
    /**
     * 重定向
     **/
    REDIRECT(1, "重定向"),
    /**
     * 请求出错,需查看返回的msg字段中给出的信息
     **/
    COMMON_ERROR(-1, "请求出错"),
    /**
     * 登录超时
     **/
    SESSION_OUT(-2, "登录超时"),
    /**
     * 未注册，请重新授权
     **/
    NOT_REGISTERED(-3, "未注册，请重新授权"),
    /**
     * 服务器维护中，请稍后再试
     **/
    DOWN_GRADE(-4, "服务器维护中，请稍后再试"),
    /**
     *
     **/
    PARAMETER_ERROR(-5, "参数错误"),

    /**
     *
     **/
    BIZ_ERROR(-6, "业务逻辑错误"),

    ACCOUNT_NOT_FOUND(-7, "账号不存在"),
    PASSWORD_ERROR(-8, "密码错误"),


    FAIL_TOKEN(-99, "请不要重复提交"),

    FAIL(-200, "请求失败"),

    

    



    ;


    private Integer code;
    private String remark;

    ResponseCodeEnum(Integer code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getRemark() {
        return remark;
    }

}
