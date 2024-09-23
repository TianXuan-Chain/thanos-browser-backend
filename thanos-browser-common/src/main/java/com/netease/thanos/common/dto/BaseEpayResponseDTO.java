package com.netease.thanos.common.dto;


import lombok.ToString;

import java.io.Serializable;


@ToString
public class BaseEpayResponseDTO implements Serializable {

    private String businessResp;
    private String detailMsg;
    private String operationResp;

    public String getBusinessResp() {
        return businessResp;
    }

    public void setBusinessResp(String businessResp) {
        this.businessResp = businessResp;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public String getOperationResp() {
        return operationResp;
    }

    public void setOperationResp(String operationResp) {
        this.operationResp = operationResp;
    }

}
