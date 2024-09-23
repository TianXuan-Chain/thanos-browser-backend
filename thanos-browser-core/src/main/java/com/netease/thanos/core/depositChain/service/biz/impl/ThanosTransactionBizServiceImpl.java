package com.netease.thanos.core.depositChain.service.biz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.netease.thanos.core.depositChain.bo.ThanosContractTransactionDetailBo;
import com.netease.thanos.core.depositChain.entity.*;
import com.netease.thanos.core.depositChain.service.base.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.netease.thanos.common.constants.PageConstant;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.exception.ThanosChainBizException;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.service.biz.ThanosTransactionBizService;
import com.netease.thanos.core.depositChain.util.PartitionKeyUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 类ThanosBlockBizServiceImpl.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:37
 */
@Component
@Slf4j
public class ThanosTransactionBizServiceImpl implements ThanosTransactionBizService {
    @Autowired
    private ThanosTransactionDBService thanosTransactionDBService;
    @Autowired
    private ThanosTnxByDayDBService tnxByDayDBService;
    @Autowired
    private ThanosBlockDBService thanosBlockDBService;
    @Autowired
    private ThanosChainInfoDBService chainInfoDBService;
    @Autowired
    private ThanosContractTransactionDBService thanosContractTransactionDBService;
    @Autowired
    private ThanosContractDBService thanosContractDBService;

    @Override
    public ThanosEvmTransactionWithBLOBs queryTransactionDetail(String hash, Date blockTimestamp) {
        try {
            if (StringUtils.isBlank(hash)) {
                log.warn("ThanosTransactionBizServiceImpl.queryTransactionDetail hash is null.");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            ThanosEvmTransactionWithBLOBs thanosTx = thanosTransactionDBService
                    .queryThanosTransactionByHashAndBlockTimestamp(hash, blockTimestamp);
            return thanosTx;
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionBizServiceImpl queryTransactionDetail exception.", e);
            throw new ThanosChainBizException("ThanosTransactionBizServiceImpl queryTransactionDetail Exception.", e);
        }
    }

    @Override
    public ThanosEvmTransactionWithBLOBs queryTransactionDetailWithConvert(String hash, Date blockTimestamp) {
        try {
            if (StringUtils.isBlank(hash)) {
                log.warn("ThanosTransactionBizServiceImpl.queryTransactionDetail hash is null.");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            ThanosEvmTransactionWithBLOBs thanosTx = thanosTransactionDBService
                    .queryThanosTransactionByHashAndBlockTimestamp(hash, blockTimestamp);
            /*
             * if(ContractBizType.DEPOSIT.getBizType().equals(thanosTx.getTransactionType())
             * ){ thanosTx.setBizData(createDeopsitBizData(thanosTx)); }
             */
            return thanosTx;
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionBizServiceImpl queryTransactionDetailWithConvert exception.", e);
            throw new ThanosChainBizException(
                    "ThanosTransactionBizServiceImpl queryTransactionDetailWithConvert Exception.", e);
        }
    }


    @Override
    public CommonPageResult<ThanosEvmTransaction> pageQueryTnxsByBlockNumber(CommonPageQuery<Long> request) {
        return pageQueryTnxsByBlockNumber(request, false);
    }

    @Override
    public List<ThanosContractTransaction> queryLastContractTxByContractAddressAndOffset(String contractAddress, Integer fromOffset) {
        try {
            int count = thanosContractTransactionDBService.countContractTransactionByContractAddress(contractAddress);
            if (count <= fromOffset) {
                return null;
            }

            return thanosContractTransactionDBService.queryContractTransactionByContractAddressAndOffset(contractAddress, fromOffset, 1000);
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionBizServiceImpl queryLastContractTxByContractAddressAndOffset exception.", e);
            throw new ThanosChainBizException("ThanosTransactionBizServiceImpl queryLastContractTxByContractAddressAndOffset Exception.", e);
        }
    }

    @Override
    public ThanosContract queryContract(String contractAddress) {
        try {
            if (!contractAddress.startsWith("0x")) {
                contractAddress = "0x" + contractAddress;
            }
            ThanosContract contract = thanosContractDBService.queryContractByAddress(contractAddress);
            if (contract != null) {
                if (StringUtils.isBlank(contract.getContractName())) {
                    contract.setContractName("未定义");
                }
                if (contract.getTotalLimitSupply() <= 0) {
                    contract.setTotalLimitSupply(-1);
                }
            }
            return contract;
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionBizServiceImpl queryLastContractTxByContractAddressAndOffset exception.", e);
            throw new ThanosChainBizException("ThanosTransactionBizServiceImpl queryLastContractTxByContractAddressAndOffset Exception.", e);
        }
    }

    @Override
    public CommonPageResult<ThanosEvmTransaction> pageQueryTnxsByContractAddress(CommonPageQuery<String> request) {
        CommonPageResult<ThanosEvmTransaction> commonPageResult = new CommonPageResult<>();
        try {
            if (request == null) {
                log.warn(" ThanosTransactionBizServiceImpl pageQueryTnxsByContractAddress request is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }  // 分页信息
            CommonPageQuery.PageInfo pageInfo = request.getPageInfo();
            if (pageInfo == null) {
                pageInfo = new CommonPageQuery.PageInfo();
            }
            // 分页查询的单页条数不能超过500条，默认为30条
            if (pageInfo.getPageSize() == null || pageInfo.getPageSize() < 0
                    || pageInfo.getPageSize() > PageConstant.TOTAL_MAX_500000) {
                pageInfo.setPageSize(PageConstant.PAGE_SIZE_30);
            }
            // 分页查询页数默认为第一页
            if (pageInfo.getPageNumber() == null || pageInfo.getPageNumber() <= 0) {
                pageInfo.setPageNumber(1);
            }
            if (pageInfo.getPageNumber() > PageConstant.PAGE_NUMBER_100) {
                pageInfo.setPageNumber(PageConstant.PAGE_NUMBER_100);
            }

            String contractAddress = request.getQueryCriteria();

            int count = thanosContractTransactionDBService.countContractTransactionByContractAddress(contractAddress);

            commonPageResult.setTotalCount(count);
            commonPageResult.setPageSize(pageInfo.getPageSize());
            if (count > 0) {
                int pageTotal = (count % pageInfo.getPageSize() == 0) ? (count / pageInfo.getPageSize()) : (count / pageInfo.getPageSize() + 1);
                commonPageResult.setPageTotal(pageTotal);

                List<ThanosContractTransaction> thanosContractTransactions = thanosContractTransactionDBService.queryContractTransactionByContractAddressAndOffset(contractAddress, pageInfo.getPageSize() * (pageInfo.getPageNumber() - 1), pageInfo.getPageSize());
                List<ThanosEvmTransaction> transactionList = new ArrayList<>();

                if (!CollectionUtils.isEmpty(thanosContractTransactions)) {
                    for (ThanosContractTransaction thanosContractTransaction : thanosContractTransactions) {
                        ThanosEvmTransaction transaction = new ThanosEvmTransaction();
                        ThanosContractTransactionDetailBo thanosContractTransactionDetailBo = JSON.parseObject(thanosContractTransaction.getTxDetail(), ThanosContractTransactionDetailBo.class);

                        transaction.setPkHash(thanosContractTransaction.getPkHash());
                        transaction.setBlockTimestamp(thanosContractTransactionDetailBo.getBlockTimestamp());
                        transaction.setBlockNumber(thanosContractTransactionDetailBo.getBlockNumber());
                        transaction.setTransactionTo(thanosContractTransactionDetailBo.getTransactionTo());
                        transaction.setTransactionFrom(thanosContractTransactionDetailBo.getTransactionFrom());
                        transaction.setContractAddress(thanosContractTransaction.getContractAddress());
                        transaction.setTradeStat(thanosContractTransactionDetailBo.getTradeStat());
                        transactionList.add(transaction);
                    }
                }
                commonPageResult.setResult(new ArrayList<>(transactionList));
            }

        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionBizServiceImpl pageQueryTnxsByContractAddress exception.", e);
            throw new ThanosChainBizException("ThanosTransactionBizServiceImpl pageQueryTnxsByContractAddress Exception.", e);
        }
        return commonPageResult;
    }

    private CommonPageResult<ThanosEvmTransaction> pageQueryTnxsByBlockNumber(CommonPageQuery<Long> request,
                                                                              boolean queryBLOBS) {
        CommonPageResult<ThanosEvmTransaction> commonPageResult = new CommonPageResult<>();

        try {
            if (request == null) {
                log.warn(" ThanosTransactionBizServiceImpl pageQueryTnxsByBlockNumber request is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }

            // 分页信息
            CommonPageQuery.PageInfo pageInfo = request.getPageInfo();
            if (pageInfo == null) {
                pageInfo = new CommonPageQuery.PageInfo();
            }
            // 分页查询的单页条数不能超过500条，默认为30条
            if (pageInfo.getPageSize() == null || pageInfo.getPageSize() < 0
                    || pageInfo.getPageSize() > PageConstant.TOTAL_MAX_500000) {
                pageInfo.setPageSize(PageConstant.PAGE_SIZE_30);
            }
            // 分页查询页数默认为第一页
            if (pageInfo.getPageNumber() == null || pageInfo.getPageNumber() <= 0) {
                pageInfo.setPageNumber(1);
            }
            if (pageInfo.getPageNumber() > PageConstant.PAGE_NUMBER_100) {
                pageInfo.setPageNumber(PageConstant.PAGE_NUMBER_100);
            }

            Long blockNumber = request.getQueryCriteria();
            if (blockNumber != null && blockNumber > 0) {
                // 输入块高不为空，则取对应区块中的交易列表
                ThanosBlock thanosBlock = thanosBlockDBService.queryBlockByNumber(blockNumber);
                if (thanosBlock == null) {
                    log.warn(
                            " ThanosTransactionBizServiceImpl pageQueryTxnsByBlockNumber block not exist, blockNumber:{}.",
                            blockNumber);
                    throw new ThanosChainBizException(ThanosErrorCodeDTO.PARAMETER_ERROR);
                }
                Long partitionKey = PartitionKeyUtil.getPartitionKey(thanosBlock.getTimestamp());
                int count = thanosBlock.getEvmTnxNum() == null ? 0 : thanosBlock.getEvmTnxNum().intValue();
                if (count > 0) {
                    commonPageResult.setTotalCount(count);
                    commonPageResult.setPageSize(pageInfo.getPageSize());
                    int pageTotal = (count % pageInfo.getPageSize() == 0) ? (count / pageInfo.getPageSize())
                            : (count / pageInfo.getPageSize() + 1);
                    commonPageResult.setPageTotal(pageTotal);
                    List<ThanosEvmTransaction> list = thanosTransactionDBService.queryThanosTnxsByBlockNumberByPage(
                            blockNumber, partitionKey, pageInfo.getPageSize(), pageInfo.getPageNumber());
                    if (queryBLOBS) {
                        List<ThanosEvmTransactionWithBLOBs> listWithBlobs = thanosEvmTransactionToBlobs(list);
                        list = blobs2Entity(listWithBlobs);
                    }
                    commonPageResult.setResult(list);
                }
            } else {
                // 输入块高为空，取最新的交易。
                ThanosBlockchaininfo chaininfo = chainInfoDBService.queryThanosBlockchainInfo();
                if (chaininfo != null && chaininfo.getTxnCount() != null && chaininfo.getTxnCount() > 0) {
                    int totalCount = chaininfo.getTxnCount().intValue();
                    commonPageResult.setTotalCount(totalCount);
                    commonPageResult.setPageSize(pageInfo.getPageSize());
                    int pageTotal = (totalCount % pageInfo.getPageSize() == 0) ? (totalCount / pageInfo.getPageSize())
                            : (totalCount / pageInfo.getPageSize() + 1);
                    commonPageResult.setPageTotal(pageTotal);

                    ThanosTnxbyday tnxbyday = tnxByDayDBService.queryLastTxnRecord();
                    if (tnxbyday != null) {
                        Long partitionKey = PartitionKeyUtil.getPartitionKey(tnxbyday.getPkDate());
                        List<ThanosEvmTransaction> list = thanosTransactionDBService.pageQueryThanosTnxsBeforePartition(
                                pageInfo.getPageSize(), pageInfo.getPageNumber(), partitionKey);
                        if (queryBLOBS) {
                            List<ThanosEvmTransactionWithBLOBs> listWithBlobs = thanosEvmTransactionToBlobs(list);
                            list = blobs2Entity(listWithBlobs);
                        }
                        commonPageResult.setResult(list);
                    }
                }
            }
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionBizServiceImpl pageQueryTnxsByBlockNumber exception.", e);
            throw new ThanosChainBizException("ThanosTransactionBizServiceImpl pageQueryTnxsByBlockNumber Exception.",
                    e);
        }
        return commonPageResult;
    }

    /**
     * @param list
     * @return
     */
    private List<ThanosEvmTransactionWithBLOBs> thanosEvmTransactionToBlobs(List<ThanosEvmTransaction> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.EMPTY_LIST;
        }
        List<ThanosEvmTransactionWithBLOBs> listWithBlobs = new ArrayList<>(list.size());
        list.stream().forEach(t -> {
            try {
                ThanosEvmTransactionWithBLOBs thanosEvmTransactionWithBLOBs = thanosTransactionDBService
                        .queryThanosTransactionByHashAndBlockTimestamp(t.getPkHash(), null);
                listWithBlobs.add(thanosEvmTransactionWithBLOBs);
            } catch (ThanosChainDBException e) {
                log.error("thanosEvmTransactionToBlobs error, ThanosEvmTransaction:{}", t, e);
            }
        });
        return listWithBlobs;
    }

    private List<ThanosEvmTransaction> blobs2Entity(List<ThanosEvmTransactionWithBLOBs> blobs) {
        List<ThanosEvmTransaction> list = new ArrayList<>();
        for (ThanosEvmTransactionWithBLOBs thblobs : blobs) {
            list.add(thblobs);
        }
        return list;
    }

}
