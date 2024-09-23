package com.netease.thanos.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类ExecuteResultResponseDTO.java的实现描述：
 *
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class ExecuteResultResponseDTO implements Serializable {

    private String traceId;
    private Boolean result;

    private String errorType;
    private String errorReason;

}
