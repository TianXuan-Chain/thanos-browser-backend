package com.netease.thanos.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 类CommonQueryByPageRequestDTO.java的实现描述：分页查询 请求DTO
 *
 * @Author xuhao create on 2019/9/16 16:25
 */

@Data
public class CommonPageQuery<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 查询条件
     */
    private T queryCriteria;

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

    /**
     * 排序信息
     */
    private SortInfo sortInfo;

    /**
     * 分页信息
     */
    @Data
    public static class PageInfo implements Serializable {
        private static final long serialVersionUID = 1L;
        /**
         * 每页大小
         */
        private Integer pageSize;

        /**
         * 第几页
         */
        private Integer pageNumber;
    }

    /**
     * 排序信息
     */
    @Data
    public static class SortInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 排序类型 0-降序 1-升序。 默认是降序
         */
        private Integer sortType;
    }
}
