package com.netease.thanos.core.depositChain.constant;


public enum BizTypeEnum {

    BIZ_DEPOSIT(1, "存证业务"),
    BIZ_ZIP(2, "Zip包存证业务"),
    LOTTERY(3,"抽奖");

    // 类型
    private Integer type;
    // 描述
    private String reason;

    BizTypeEnum(Integer type, String reason) {
        this.type = type;
        this.reason = reason;
    }

    public Integer getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }
}
