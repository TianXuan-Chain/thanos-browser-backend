package com.netease.thanos.web.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author lyy create on 2018-06-02
 */

@Getter
@Setter
@ToString
public class BlockQueryConditionForm {

    //交易hash
    private Integer number;

    //快高
    private String pkHash;

    /**
     * 页大小
     */
    private Integer pageSize;


    /**
     *  取最后一页的pagesize.
     */
    private Integer lastPageSize;

    /**
     * 下一页(min)或者上一页Id(max)，
     */
    private Long startId;

    /**
     * 类型，1下一页，2上一页
     */
    private Integer type;
}
