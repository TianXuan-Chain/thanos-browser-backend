package com.netease.thanos.core.depositChain.service.biz;


import java.util.List;

import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.core.depositChain.entity.ThanosBlock;

/**
 * 类ThanosBlockBizService.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:18
 */

public interface ThanosBlockBizService {
    /**
     * 查询数据库中链的最新块高
     *
     * @return
     */
    Long queryMaxBlockHeight();

    /**
     * 根据区块hash，查询区块详情
     *
     * @param hash
     * @return
     */
    ThanosBlock queryBlockDetail(String hash);

    /**
     * 分页查询区块信息
     *
     * @param request
     * @return
     */
    CommonPageResult<ThanosBlock> pageQueryBlocks(CommonPageQuery<Void> request);
    
    
    /**
     * 根据区块number，查询区块详情
     *
     * @param number
     * @return
     */
    public ThanosBlock queryBlockByNumber(Long number);
    /**
     * 查询最近num条数据 最多2000条
     * @param num
     * @return
     */
    
    public List<ThanosBlock> queryLatestBlocks(Integer num);
}
