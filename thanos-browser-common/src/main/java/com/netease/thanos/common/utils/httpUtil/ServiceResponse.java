package com.netease.thanos.common.utils.httpUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Yang Tengfei on 10/20/16.
 */
@Getter
@Setter
public class ServiceResponse<T> {
    private String error_code;

    private String error_message;

    private String data;

    private T ret;
}
