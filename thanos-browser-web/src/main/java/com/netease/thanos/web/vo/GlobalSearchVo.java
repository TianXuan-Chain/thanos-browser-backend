package com.netease.thanos.web.vo;

import lombok.Data;

/**
 * 类GlobalSearchVo.java的实现描述：
 *
 * @author xuhao create on 2021/2/4 11:24
 */
@Data
public class GlobalSearchVo extends CommonPageVo {
    /**
     * 查询参数类型： pkHash or bcAddress
     */
    private String searchType;
    /**
     * 查询参数值
     */
    private String searchValue;
    /**
     * 查询结果类型 1-交易 2-区块
     */
    private int type = 0;
}
