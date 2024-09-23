package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author kingkong create on 2018-08-28
 */

@Getter
@Setter
public class PageReqDTO implements Serializable {

    private Integer offset;

    private Integer size;
}
