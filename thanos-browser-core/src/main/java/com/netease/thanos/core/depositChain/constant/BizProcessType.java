package com.netease.thanos.core.depositChain.constant;

public enum BizProcessType {

    BIZ_DEPOSIT(1, "存证类业务"),
    BIZ_FILE_DEPOSIT(2, "zip文件存证"),
    BIZ_OTHER(3, "其他业务"),
    ;

    private Integer type;
    private String remark;

    BizProcessType(Integer type, String remark) {
        this.type = type;
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public String getRemark() {
        return remark;
    }

}


