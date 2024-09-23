package com.netease.thanos.api.dto.thanos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ThanosTnxByDayDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 交易时间
     */
    private Date pkDate;

    /**
     * 交易量
     */
    private Long txnCount;
}


