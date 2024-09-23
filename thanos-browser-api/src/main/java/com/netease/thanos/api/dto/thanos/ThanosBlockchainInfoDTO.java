package com.netease.thanos.api.dto.thanos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class ThanosBlockchainInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 最新块高
     */
    private Long lastBlockNum;

    /**
     * 交易量
     */
    private Long txnCount;

    /**
     * 共识纪元
     */
    private Long epoch;

    /**
     * 当前共识轮数
     */
    private Long round;

    /**
     * 相邻两个块的timestamp之差的平均值
     */
    private BigDecimal avgTime;
}
