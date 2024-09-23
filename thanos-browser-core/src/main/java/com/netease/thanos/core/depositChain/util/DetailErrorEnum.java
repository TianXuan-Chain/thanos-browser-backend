package com.netease.thanos.core.depositChain.util;


public enum DetailErrorEnum {

    NO_RECORD("NO_RECORD", "没有执行记录"),
    MORE_RECORD("MORE_RECORD", "执行多次记录"),
    UNKNOW_ERROR("UNKNOW_ERROR", "未知异常"),
    EXECUTE_ERROR("EXECUTE_ERROR", "执行失败"); // 有执行记录，但是都没有没有成功

    // 类型
    private String type;
    // 描述
    private String reason;

    DetailErrorEnum(String type, String reason) {
        this.type = type;
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
