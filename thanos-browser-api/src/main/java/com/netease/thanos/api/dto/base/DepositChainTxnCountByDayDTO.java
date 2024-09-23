package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author kingkong create on 2018-08-28
 */

@Getter
@Setter
@ToString
public class DepositChainTxnCountByDayDTO implements Serializable {

    private Long id;

    /**
     * yyyyMMdd，唯一索引
     */
    private Date date;

    /**
     * 当天交易量
     */
    private Long txn;

    private Date gmtCreate;

    private Date gmtModify;
}
