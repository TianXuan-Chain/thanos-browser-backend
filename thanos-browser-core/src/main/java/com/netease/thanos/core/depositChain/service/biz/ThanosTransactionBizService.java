package com.netease.thanos.core.depositChain.service.biz;


import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.core.depositChain.entity.ThanosContract;
import com.netease.thanos.core.depositChain.entity.ThanosContractTransaction;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransaction;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransactionWithBLOBs;

import java.util.Date;
import java.util.List;

/**
 * 类ThanosBlockBizService.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:18
 */

public interface ThanosTransactionBizService {

    /**
     * 根据交易hash，查询交易详情
     *
     * @param hash
     * @return
     */
    ThanosEvmTransactionWithBLOBs queryTransactionDetail(String hash, Date blockTimestamp);

    /**
     * 带业务处理
     */
    ThanosEvmTransactionWithBLOBs queryTransactionDetailWithConvert(String hash, Date blockTimestamp);

    /**
     * 分页查询指定区块中的交易信息
     *
     * @param request
     * @return
     */
    CommonPageResult<ThanosEvmTransaction> pageQueryTnxsByBlockNumber(CommonPageQuery<Long> request);

    /**
     * 查询合约指定区间的交易
     *
     * @param contractAddress
     * @param fromOffset
     * @return
     */
    List<ThanosContractTransaction> queryLastContractTxByContractAddressAndOffset(String contractAddress, Integer fromOffset);

    /**
     * 通过合约地址查询合约
     *
     * @param contractAddress
     * @return
     */
    ThanosContract queryContract(String contractAddress);

    /**
     * 通过合约查询交易
     * @param request
     * @return
     */
    CommonPageResult<ThanosEvmTransaction> pageQueryTnxsByContractAddress(CommonPageQuery<String> request);
}
