package com.netease.thanos.web.form;

import lombok.Data;

/**
 * @Author lyy create on 2018-06-02
 */

@Data
public class PageQueryForm {
    /**
     * 页大小
     */
    private Integer pageSize;


    /**
     * 页数.
     */
    private Integer page;


}
