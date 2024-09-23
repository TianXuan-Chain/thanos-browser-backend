package com.netease.thanos.web.assember;

import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.core.depositChain.entity.ThanosGlobalSearchResponse;
import com.netease.thanos.web.form.PageQueryForm;
import com.netease.thanos.web.vo.CommonPageVo;
import com.netease.thanos.web.vo.GlobalSearchVo;

/**
 * 类BlockControllerAssmbler.java的实现描述：
 *
 * @author xuhao create on 2021/2/2 16:58
 */

public class BlockControllerAssmbler {
    /**
     * pageQueryForm2CommonPageQuery 转换
     *
     * @param queryCriteria
     * @param form
     * @param <T>
     * @return
     */
    public static <T> CommonPageQuery<T> pageQueryForm2CommonPageQuery(T queryCriteria, PageQueryForm form) {
        CommonPageQuery<T> pageQuery = new CommonPageQuery<>();
        CommonPageQuery.PageInfo pageInfo = new CommonPageQuery.PageInfo();
        pageInfo.setPageNumber(form.getPage());
        pageInfo.setPageSize(form.getPageSize());
        pageQuery.setPageInfo(pageInfo);
        pageQuery.setQueryCriteria(queryCriteria);
        return pageQuery;
    }

    /**
     * commonPageDTO2Vo 转换
     *
     * @param dto
     * @param <T>
     * @return
     */
    public static <T> CommonPageVo<T> commonPageDTO2Vo(CommonPageResult<T> dto) {
        CommonPageVo<T> vo = new CommonPageVo<>();
        if (dto == null) {
            return vo;
        }
        vo.setTotalCount(dto.getTotalCount());
        vo.setPageSize(dto.getPageSize());
        vo.setPageTotal(dto.getPageTotal());
        vo.setList(dto.getResult());
        return vo;
    }

    public static GlobalSearchVo globalSearchDTO2Vo(ThanosGlobalSearchResponse response) {
        if (response == null) {
            return null;
        }
        GlobalSearchVo vo = new GlobalSearchVo();
        CommonPageResult<Object> dto = response.getResult();
        vo.setTotalCount(dto.getTotalCount());
        vo.setPageSize(dto.getPageSize());
        vo.setPageTotal(dto.getPageTotal());
        vo.setList(dto.getResult());
        vo.setSearchType(response.getSearchType());
        vo.setSearchValue(response.getSearchValue());
        vo.setType(response.getType());
        return vo;
    }
}
