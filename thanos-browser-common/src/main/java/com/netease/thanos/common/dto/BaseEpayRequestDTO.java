package com.netease.thanos.common.dto;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类BaseEpayRequestDto.java的实现描述：网易宝接口基类
 *
 * @author chenws 2017年4月10日 下午9:18:14
 */
@ToString
@Data
public class BaseEpayRequestDTO implements Serializable {

    /**
     * 网易宝商户号
     **/
    private String platformId;
    private String keyPassword;
}
