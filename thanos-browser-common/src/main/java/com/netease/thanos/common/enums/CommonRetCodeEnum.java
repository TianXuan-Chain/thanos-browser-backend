package com.netease.thanos.common.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通用错误码枚举
 *
 * @author hzliubenlong
 */
public enum CommonRetCodeEnum {
    SUCCESS(34000, "成功"),
    NET_ERROR(34001, "网络繁忙，请稍后再试"),
    MISS_NEEDED_PARA(34002, "缺失必要参数"),
    PARAMETER_ERROR(34003, "参数错误"),
    DATABASE_ERROR(34004, "数据库异常"),
    KYLIN_CLIENT_ERROR(34005, "初始化麒麟客户端异常"),
    KYLIN_ERROR(34006, "请求麒麟异常"),
    SURVEY_REPEAT(34007, "重复提交问卷调整");

    private long code;
    private String desc;

    private CommonRetCodeEnum(long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public static CommonRetCodeEnum valueOf(Long code) {
        if (code == null) {
            return null;
        } else {
            List<CommonRetCodeEnum> existCodeList = Arrays.stream(values()).filter(
                    commonRetCodeEnum -> commonRetCodeEnum.getCode().equals(code)).collect(
                    Collectors.toList());
            if (existCodeList != null && existCodeList.size() == 1) {
                return existCodeList.get(0);
            }
            return null;
        }
    }

}
