package com.netease.thanos.core.depositChain.constant;

public enum PointType {

    POINT_USER(1, "用户证据点"),
    POINT_CORPORATION(2, "企业证据点"),
    POINT_OBJECT(3, "对象证据点");

    private final Integer type;
    private final String remark;

    PointType(Integer type, String remark) {
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


