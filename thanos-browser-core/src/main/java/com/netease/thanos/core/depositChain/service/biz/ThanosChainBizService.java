package com.netease.thanos.core.depositChain.service.biz;


import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.core.depositChain.entity.ThanosBlockchaininfo;
import com.netease.thanos.core.depositChain.entity.ThanosChainDataBo;
import com.netease.thanos.core.depositChain.entity.ThanosGlobalSearchResponse;
import com.netease.thanos.core.depositChain.entity.ThanosTnxbyday;

import java.util.Date;
import java.util.List;

/**
 * 类ThanosBlockBizService.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:18
 */

public interface ThanosChainBizService {
    /**
     * 导入链上区块和交易
     *
     * @param thanosChainData
     * @return
     */
    Boolean importBlockChainData(ThanosChainDataBo thanosChainData);

    /**
     * 对于新的一天，需要把初始化当天的交易记录（0条交易），这样即使当天没有区块生成，交易记录仍然可查。
     *
     * @param pkDate
     * @return
     */
    Boolean createTnxCountRecordForNewDay(Date pkDate);

    /**
     * 查询链整体信息
     *
     * @return
     */
    ThanosBlockchaininfo queryBlockChain();

    /**
     * 查询最近几天交易数
     *
     * @param size
     * @return
     */
    List<ThanosTnxbyday> queryTnxCountBySize(Integer size);

    /**
     * 全局搜索交易、区块信息
     *
     * @param request
     * @return
     */
    ThanosGlobalSearchResponse globalSearch(CommonPageQuery<String> request);
}
