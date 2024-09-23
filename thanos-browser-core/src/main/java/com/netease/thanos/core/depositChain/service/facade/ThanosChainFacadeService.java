package com.netease.thanos.core.depositChain.service.facade;


import com.netease.thanos.api.dto.thanos.ThanosBlockchainInfoDTO;
import com.netease.thanos.api.dto.thanos.ThanosChainDataDTO;
import com.netease.thanos.api.dto.thanos.ThanosTnxByDayDTO;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonResultDTO;
import com.netease.thanos.core.depositChain.entity.ThanosGlobalSearchResponse;

import java.util.Date;
import java.util.List;

/**
 * 类ThanosBlockFacadeService.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:16
 */


public interface ThanosChainFacadeService {

    /**
     * 导入链上区块和交易
     *
     * @param chainDataDTO
     * @return
     */
    CommonResultDTO<Boolean> importBlockChainData(ThanosChainDataDTO chainDataDTO);

    /**
     * 对于新的一天，需要把初始化当天的交易记录（0条交易），这样即使当天没有区块生成，交易记录仍然可查。
     *
     * @param pkDate
     * @return
     */
    CommonResultDTO<Boolean> createTnxCountRecordForNewDay(Date pkDate);

    /**
     * 查询链整体信息
     *
     * @return
     */
    CommonResultDTO<ThanosBlockchainInfoDTO> queryBlockChain();

    /**
     * 查询最近几天交易数
     *
     * @param size
     * @return
     */
    CommonResultDTO<List<ThanosTnxByDayDTO>> queryTnxCountBySize(Integer size);

    /**
     * 全局搜索交易、区块信息
     *
     * @param request
     * @return
     */
    ThanosGlobalSearchResponse globalSearch(CommonPageQuery<String> request);
}
