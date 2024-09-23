package com.netease.thanos.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import com.netease.thanos.api.dto.base.PageReqDTO;

/**
 * @Author kingkong create on 2018-08-28
 */

@Getter
@Setter
@ToString
public class TxnQueryConditionReqDTO extends PageReqDTO implements Serializable {

    private Long id;

    private String bcAddress;

    private String startTime;

    private String endTime;

    private String txnHash;

    private String methodSign;
}
