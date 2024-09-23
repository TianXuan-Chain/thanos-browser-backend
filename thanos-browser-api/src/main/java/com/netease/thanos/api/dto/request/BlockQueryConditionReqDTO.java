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
public class BlockQueryConditionReqDTO extends PageReqDTO implements Serializable {

    private Integer number;

    private String pkHash;

    private String startTime;

    private String endTime;
}
