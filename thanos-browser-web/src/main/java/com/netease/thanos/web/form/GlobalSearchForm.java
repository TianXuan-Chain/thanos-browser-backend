package com.netease.thanos.web.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 类GlobalSearchForm.java 的实现描述:
 * Created by wangting04 on 2018/08/09
 */
@Getter
@Setter
@ToString
public class GlobalSearchForm {
    private String search;

    /**
     * 取多少条
     */
    private Integer pageSize;
}
