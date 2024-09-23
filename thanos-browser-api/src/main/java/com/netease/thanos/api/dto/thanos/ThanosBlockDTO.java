package com.netease.thanos.api.dto.thanos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ThanosBlockDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 块hash值
     */
    private String pkHash;

    /**
     * 高度
     */
    private Long number;

    /**
     * 事件id
     */
    private String eventId;

    /**
     * 父事件id
     */
    private String preEventId;

    /**
     * 共识时期
     */
    private Long epoch;

    /**
     * 时间戳
     */
    private Date timestamp;

    /**
     * 块包含的交易数
     */
    private Long evmTnxNum;

    /**
     * 块包含的交易数
     */
    private Long globalEventNum;

    /**
     * rpc查询结果的所有数据
     */
    private String detailInfo;
}


