package com.netease.thanos.core.depositChain.service.facade;


import com.netease.thanos.api.dto.thanos.ThanosContractDTO;
import com.netease.thanos.api.dto.thanos.ThanosContractTransactionDTO;
import com.netease.thanos.api.dto.thanos.ThanosEvmTransactionDTO;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.CommonResultDTO;

import java.util.Date;
import java.util.List;

/**
 * 类ThanosBlockFacadeService.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:16
 */


public interface ThanosTransactionFacadeService {

    /**
     * 根据交易hash，查询交易详情
     *
     * @param hash
     * @return
     */
    CommonResultDTO<ThanosEvmTransactionDTO> queryTransactionDetail(String hash, Date blockTimestamp);

    /**
     * 参数转换的
     * @param hash
     * @param blockTimestamp
     * @return
     */
    CommonResultDTO<ThanosEvmTransactionDTO> queryTransactionDetailWithConvert(String hash, Date blockTimestamp);
    /**
     * 分页查询指定区块中的交易信息
     *
     * @param request
     * @return
     */
    CommonPageResult<ThanosEvmTransactionDTO> pageQueryTnxsByBlockNumber(CommonPageQuery<Long> request);

    /**
     * 通过合约地址及fromOffst 查询 合约交易信息
     * @param contractAddress
     * @param fromOffset
     * @return
     */
    CommonResultDTO<List<ThanosContractTransactionDTO>> queryLastContractTxByContractAddressAndOffset(String contractAddress, Integer fromOffset);

    /**
     * 通过合约地址查询合约信息
     * @param contractAddress
     * @return
     */
    CommonResultDTO<ThanosContractDTO> queryContract(String contractAddress);

    /**
     * 通过合约查询交易
     * @param request
     * @return
     */
    CommonPageResult<ThanosEvmTransactionDTO> pageQueryTnxsByContractAddress(CommonPageQuery<String> request);
}
