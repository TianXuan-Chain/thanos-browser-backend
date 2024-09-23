package com.netease.thanos.common.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Created by hzliubenlong on 2018/1/26.
 */
@Data
@ToString
public class EpayRealNameCheckRequestDTO extends BaseEpayRequestDTO {

    private String action;
    private String version;
    /**
     * 网易宝商户号
     **/
    private String platformId;
    private String accountId;
    private String identityType;
    private String identityNo;
    private String realName;
//    private Boolean autoUpdateGrade;
//    private String requestId;
}
