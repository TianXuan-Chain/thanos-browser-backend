package com.netease.thanos.core.depositChain.entity;

import com.netease.thanos.common.dto.CommonPageResult;

import lombok.Data;

/**
 * 类ThanosGlobalSearchResponseBo.java的实现描述：
 *
 * @author xuhao create on 2021/2/3 18:04
 */

@Data
public class ThanosGlobalSearchResponse {
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
    private int type;
    /**
     * 分页查询结果
     */
    private CommonPageResult<Object> result;
}
