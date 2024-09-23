package com.netease.thanos.common.dto;

/**
 * @author hzliubenlong
 * <p>
 * 统一错误编码
 */
public enum ThanosErrorCodeDTO {

    // ********公共错误码********
    SUCCESS("0000", "成功"),
    NET_ERROR("0001", "网络异常"),
    MISS_NEEDED_PARA("0002", "缺失必要参数"),
    PARAMETER_ERROR("0003", "参数校验错误"),
    REPERT("0004", "重复"),
    SYSTEM_ERROR("0005", "服务器异常"),
    INTERFACE_OVERTIME("0006", "接口超时"),
    DB_ERROR("0007", "数据库异常"),
    FAIL("0008", "失败"),
    INTERFACE_CLOSE("0009", "接口关闭"),
    ;
    // 错误码
    private String code;
    // 错误码描述
    private String desc;

    ThanosErrorCodeDTO(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ThanosErrorCodeDTO queryCodeEnumByName(String name) {
        for (ThanosErrorCodeDTO param : values()) {
            if (param.name().equals(name)) {
                return param;
            }
        }
        return null;
    }

    public static ThanosErrorCodeDTO queryErrorCodeByCode(String code) {
        for (ThanosErrorCodeDTO param : values()) {
            if (param.getCode().equals(code)) {
                return param;
            }
        }
        return null;
    }
}
