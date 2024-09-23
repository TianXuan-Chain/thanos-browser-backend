package com.netease.thanos.core.depositChain.constant;


public enum EvidenceStatusEnum {

    EVIDENCE_STATUS_DOING(-1, "证据收集中"),
    EVIDENCE_STATUS_DONE(0, "证据收集完成"),
    ;

    private Integer type;
    private String remark;

    EvidenceStatusEnum(Integer type, String remark) {
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
