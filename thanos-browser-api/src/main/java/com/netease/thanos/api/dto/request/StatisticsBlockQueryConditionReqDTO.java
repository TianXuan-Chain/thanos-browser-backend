package com.netease.thanos.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import com.netease.thanos.api.dto.base.PageReqDTO;

/**
 * @Author kingkong create on 2018-08-28
 */

@Getter
@Setter
public class StatisticsBlockQueryConditionReqDTO extends PageReqDTO implements Serializable {

    private Long partitionKey;

    private String hash;

    private String startTime;

    private String endTime;



}
