package com.netease.thanos.core.depositChain.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 类SingleTransaction.java的实现描述：
 *
 * @author dumaobing  on 2018/9/25 下午2:29
 */
@Getter
@Setter
public class SingleTransaction implements Serializable {

    private String to;
    private BigDecimal tokens;
    private String traceId;
    private String realtime;

}
