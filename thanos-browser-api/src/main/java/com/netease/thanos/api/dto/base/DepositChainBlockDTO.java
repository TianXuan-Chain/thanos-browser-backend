package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class DepositChainBlockDTO implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 块高
     */
    private Integer number;
    /**
     * 哈希
     */
    private String pkHash;

    /**
     * 父hash
     */
    private String parentHash;

    /**
     * 出块者
     */
    private String miner;
    /**
     *
     */
    private Integer genIndex;
    /**
     * 大小
     */
    private Integer size;
    /**
     * gas限制
     */
    private Long gasLimit;
    /**
     * gas使用
     */
    private Long gasUsed;

    /**
     * 平均gas
     */
    private BigDecimal avgGasPrice;

    /**
     * 出块时间
     */
    private Timestamp timestamp;

    /**
     * 交易数量
     */
    private Long txn;
    /**
     *
     */
    private String extraData;
    /**
     * 块矿区
     */
    private Integer blockArea;
}


