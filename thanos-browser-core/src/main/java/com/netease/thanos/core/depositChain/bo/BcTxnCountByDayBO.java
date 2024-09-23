package com.netease.thanos.core.depositChain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author lyy create on 2018-05-15
 */

@Getter
@Setter
@ToString
public class BcTxnCountByDayBO {

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
