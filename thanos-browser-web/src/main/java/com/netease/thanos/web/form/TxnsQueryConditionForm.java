package com.netease.thanos.web.form;

import lombok.Data;

/**
 * @Author lyy create on 2018-06-07
 */

@Data
public class TxnsQueryConditionForm {
    /**
     * 交易者
     */
    private String bcAddress;

    /**
     * 交易hash
     */
    private String pkHash;

    /**
     * 块的num
     */
    private Integer blockNumber;

    /**
     *  取最后一页的pagesize.
     */
    private Integer lastPageSize;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 下一页(min)或者上一页Id(max)，
     */
    private Long startId;

    /**
     * 类型，1下一页，2上一页
     */
    private Integer type;

    /**
     * startId 对应的块number
     */
    private Integer startBlockNumber;

    /**
     * 存证数据hash
     */
    private String bizData;

}
