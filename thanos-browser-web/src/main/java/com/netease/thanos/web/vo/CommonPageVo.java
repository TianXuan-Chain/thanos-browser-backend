package com.netease.thanos.web.vo;

import lombok.Data;

import java.util.List;

/**
 * 类CommonPageVo.java的实现描述：
 *
 * @author xuhao create on 2021/2/3 17:35
 */

@Data
public class CommonPageVo<T> {
    //总数
    private int totalCount = 0;
    //每页多少条
    private int pageSize = 0;
    //总页数
    private int pageTotal = 0;
    /**
     * 查询结果列表
     */
    private List<T> list;
}
