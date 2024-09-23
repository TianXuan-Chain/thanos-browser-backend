package com.netease.thanos.core.depositChain.constant;

/**
 * 类StarErrorCodeDTO.java的实现描述：错误码
 *
 * @author wangting04 2018年8月28日 上午9:42:05
 */
public enum NeteaseDepositErrorCode {

    //********常用错误码********
    SUCCESS("0000", "成功"),
    NET_ERROR("0001", "网络异常"),
    MISS_NEEDED_PARA("0002", "缺失必要参数"),
    PARAMETER_ERROR("0003", "参数校验错误"),
    REPERT("0004", "重复"),
    SYSTEM_ERROR("0005", "服务器异常"),
    INTERFACE_OVERTIME("0006", "接口超时"),
    DB_ERROR("0007", "数据库异常"),
    FAIL("0008", "失败"),

    DEPOSIT_CHANNEL_USER_NOT_EXISTS("0010", "渠道用户不存在"),
    DEPOSIT_USER_NOT_EXISTS("0011", "渠道用户不存在"),

    BIZ_UNKOWN_ERROR("0020", "业务未知异常")
    ;

    // 错误码
    private String code;
    // 错误码描述
    private String desc;

    NeteaseDepositErrorCode(String code, String desc) {
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

    public static NeteaseDepositErrorCode queryCodeEnumByName(String name) {
        for (NeteaseDepositErrorCode param : values()) {
            if (param.name().equals(name)) {
                return param;
            }
        }
        return null;
    }

    public static NeteaseDepositErrorCode queryErrorCodeByCode(String code) {
        for (NeteaseDepositErrorCode param : values()) {
            if (param.getCode().equals(code)) {
                return param;
            }
        }
        return null;
    }

}
