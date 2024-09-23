package com.netease.thanos.api.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 类GlobalSearchFormDTO.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@Builder
public class GlobalSearchReqDTO implements Serializable {
    private String search;

    /**
     * 取多少条
     */
    private Integer pageSize;
}
