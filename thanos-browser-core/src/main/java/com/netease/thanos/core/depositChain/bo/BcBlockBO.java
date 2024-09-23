package com.netease.thanos.core.depositChain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class BcBlockBO {
    private Long id;
    private Integer number;
    private String pkHash;
    private String parentHash;
    private String miner;
    private Integer genIndex;
    private Integer size;
    private Long gasLimit;
    private Long gasUsed;
    private BigDecimal avgGasPrice;
    private Timestamp timestamp;
    private Long txn; //包含的交易数
    private String extraData;
    private Integer blockArea; //块矿区
}


