package com.netease.thanos.core.depositChain.service.facade;


import java.util.List;

import com.netease.thanos.api.dto.thanos.ThanosBlockDTO;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.CommonResultDTO;

/**
 * 类ThanosBlockFacadeService.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:16
 */


public interface ThanosBlockFacadeService {

    /**
     * 查询数据库中链的最新块高
     * @return
     */
    CommonResultDTO<Long> queryMaxBlockHeight();

    /**
     * 根据区块hash，查询区块详情
     *
     * @param hash
     * @return
     */
    CommonResultDTO<ThanosBlockDTO> queryBlockDetail(String hash);

    /**
     * 分页查询区块信息
     *
     * @param request
     * @return
     */
    CommonPageResult<ThanosBlockDTO> pageQueryBlocks(CommonPageQuery<Void> request);
    /**
     * 查询指定区块，或查询最近num区块
     * @param blockNumber
     * @param num
     * @return
     */
    
    CommonResultDTO<List<ThanosBlockDTO>> queryBlocks(Long blockNumber,Integer num );

}
