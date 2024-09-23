package com.netease.thanos.core.depositChain.service.biz.impl;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import com.netease.thanos.core.depositChain.entity.*;
import com.netease.thanos.core.depositChain.service.base.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.netease.thanos.common.constants.PageConstant;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.common.utils.DateUtils;
import com.netease.thanos.common.utils.ThreadPoolGenerator;
import com.netease.thanos.core.depositChain.constant.GlobalSearchConstant;
import com.netease.thanos.core.depositChain.exception.ThanosChainBizException;
import com.netease.thanos.core.depositChain.service.biz.ThanosChainBizService;

import lombok.extern.slf4j.Slf4j;

/**
 * 类ThanosBlockBizServiceImpl.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:37
 */
@Component
@Slf4j
public class ThanosChainBizServiceImpl implements ThanosChainBizService {
    @Autowired
    private ThanosChainInfoDBService thanosChainInfoDBService;
    @Autowired
    private ThanosTnxByDayDBService thanosTnxByDayDBService;
    @Autowired
    private ThanosBlockDBService thanosBlockDBService;
    @Autowired
    private ThanosTransactionDBService thanosTransactionDBService;
    @Autowired
    private ThanosTransactionReceiptDBService thanosTransactionReceiptDBService;
    @Autowired
    private ThanosGlobalEventDBService thanosGlobalEventDBService;
    @Autowired
    private ThanosContractDBService thanosContractDBService;
    @Autowired
    private ThanosContractTransactionDBService thanosContractTransactionDBService;

    /**
     * 单次插入的最大交易数量
     */
    private static final int BATCH_INSERT_COUNT = 3000;


    @Transactional(rollbackFor = Exception.class)
    public Boolean importBlockChainData(ThanosChainDataBo thanosChainData) throws ThanosChainBizException {
        try {
            if (thanosChainData == null) {
                log.warn("importBlockChainData thanosChainData  is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            if (thanosChainData.getThanosBlockchaininfo() == null || thanosChainData.getThanosBlock() == null) {
                log.warn("importBlockChainData chainInfo or block is null. request:{}.", thanosChainData);
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            //插入block
            ThanosBlock thanosBlock = thanosChainData.getThanosBlock();
            thanosBlockDBService.createThanosBlock(thanosBlock);
            //插入tnxByDay
            thanosTnxByDayDBService.createOrModifyWithTnxIncr(thanosBlock.getEvmTnxNum(), thanosBlock.getTimestamp());
            //插入transactions
            if (!CollectionUtils.isEmpty(thanosChainData.getThanosEvmTransactions())) {
                List<ThanosEvmTransactionWithBLOBs> txnList = thanosChainData.getThanosEvmTransactions();
                int totalCount = txnList.size();
                //保存的时候不在保存 inputText
                if (totalCount <= BATCH_INSERT_COUNT) {
                    //数量较少，一批插入
                    thanosTransactionDBService.batchCreate(thanosChainData.getThanosEvmTransactions());
                } else {
                    //数量较多，分批插入
                    int tmpBatchCount = totalCount / BATCH_INSERT_COUNT;
                    int batchCount = totalCount % BATCH_INSERT_COUNT == 0 ? tmpBatchCount : (tmpBatchCount + 1);
                    for (int i = 0; i < batchCount; i++) {
                        int startIndex = i * BATCH_INSERT_COUNT;
                        int endIndex = (i + 1) * BATCH_INSERT_COUNT;
                        if (endIndex > totalCount) {
                            endIndex = totalCount;
                        }
                        thanosTransactionDBService.batchCreate(txnList.subList(startIndex, endIndex));
                    }
                }
            }

            //插入receipts
            if (!CollectionUtils.isEmpty(thanosChainData.getThanosEvmTransactionReceipts())) {
                List<ThanosEvmTransactionreceiptWithBLOBs> receiptList = thanosChainData.getThanosEvmTransactionReceipts();
                int totalCount = receiptList.size();
                if (totalCount <= BATCH_INSERT_COUNT) {
                    //数量较少，一批插入
                    thanosTransactionReceiptDBService.batchCreate(receiptList);
                } else {
                    //数量较多，分批插入
                    int tmpBatchCount = totalCount / BATCH_INSERT_COUNT;
                    int batchCount = totalCount % BATCH_INSERT_COUNT == 0 ? tmpBatchCount : (tmpBatchCount + 1);
                    for (int i = 0; i < batchCount; i++) {
                        int startIndex = i * BATCH_INSERT_COUNT;
                        int endIndex = (i + 1) * BATCH_INSERT_COUNT;
                        if (endIndex > totalCount) {
                            endIndex = totalCount;
                        }
                        thanosTransactionReceiptDBService.batchCreate(receiptList.subList(startIndex, endIndex));
                    }
                }
            }

            //插入events
            if (!CollectionUtils.isEmpty(thanosChainData.getThanosGlobalEvents())) {
                thanosGlobalEventDBService.batchCreate(thanosChainData.getThanosGlobalEvents());
            }
            //插入blockInfo
            thanosChainInfoDBService.createOrModifyWithTnxIncr(thanosChainData.getThanosBlockchaininfo());

            //保存合约
            if (!CollectionUtils.isEmpty(thanosChainData.getThanosContracts())) {
                thanosContractDBService.createThanosContractList(thanosChainData.getThanosContracts());
            }

            //保存合约交易
            if (thanosChainData.getContractTransactionMap() != null && !thanosChainData.getContractTransactionMap().isEmpty()) {
                Set<String> keys = thanosChainData.getContractTransactionMap().keySet();
                for (String key : keys) {
                    List<ThanosContractTransaction> contractTransactions = thanosChainData.getContractTransactionMap().get(key);
                    thanosContractTransactionDBService.batchCreate(contractTransactions);
                }
            }

            //删除超量的合约交易
            if (thanosChainData.getRemoveContractTransactionMap() != null && !thanosChainData.getRemoveContractTransactionMap().isEmpty()) {
                Set<String> keys = thanosChainData.getRemoveContractTransactionMap().keySet();
                for (String key : keys) {
                    List<Long> removeIds = thanosChainData.getRemoveContractTransactionMap().get(key);
                    thanosContractTransactionDBService.deleteByContractAddressAndIds(key, removeIds);
                }
            }

            return true;
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosChainBizServiceImpl importBlockChainData exception.", e);
            throw new ThanosChainBizException("ThanosChainBizServiceImpl importBlockChainData Exception.", e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean createTnxCountRecordForNewDay(Date pkDate) throws ThanosChainBizException {
        try {
            if (pkDate == null) {
                log.warn("importBlockChainData thanosChainData  is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            //插入tnxByDay
            return thanosTnxByDayDBService.createOrModifyWithTnxIncr(0L, pkDate);
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosChainBizServiceImpl queryMaxBlockHeight exception.", e);
            throw new ThanosChainBizException("ThanosChainBizServiceImpl queryMaxBlockHeight Exception.", e);
        }
    }

    @Override
    public ThanosBlockchaininfo queryBlockChain() {
        try {
            return thanosChainInfoDBService.queryThanosBlockchainInfo();
        } catch (Exception e) {
            log.error("ThanosChainBizServiceImpl queryBlockChain exception.", e);
            throw new ThanosChainBizException("ThanosChainBizServiceImpl queryBlockChain Exception.", e);
        }
    }

    @Override
    public List<ThanosTnxbyday> queryTnxCountBySize(Integer size) {
        try {
            if (size == null) {
                log.warn("queryTnxCountBySize size  is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            List<ThanosTnxbyday> list = thanosTnxByDayDBService.queryListBySize(size);
            if (org.apache.commons.collections.CollectionUtils.isNotEmpty(list)) {
                list.sort(Comparator.comparing(ThanosTnxbyday::getPkDate));
            }
            return list;
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosChainBizServiceImpl queryTnxCountBySize exception.", e);
            throw new ThanosChainBizException("ThanosChainBizServiceImpl queryTnxCountBySize Exception.", e);
        }
    }

    @Override
    public ThanosGlobalSearchResponse globalSearch(CommonPageQuery<String> request) {
        ThanosGlobalSearchResponse responseBo = new ThanosGlobalSearchResponse();
        CommonPageResult<Object> result = new CommonPageResult<>();
        try {
            if (request == null) {
                log.warn(" ThanosChainBizServiceImpl globalSearch request is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            String searchCriteria = request.getQueryCriteria();
            if (StringUtils.isBlank(searchCriteria)) {
                log.warn(" ThanosChainBizServiceImpl globalSearch searchCriteria is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            //分页信息
            CommonPageQuery.PageInfo pageInfo = request.getPageInfo();
            if (pageInfo == null) {
                pageInfo = new CommonPageQuery.PageInfo();
            }
            //分页查询的单页条数不能超过500条，默认为30条
            if (pageInfo.getPageSize() == null || pageInfo.getPageSize() < 0 || pageInfo.getPageSize() > PageConstant.PAGE_SIZE_500) {
                pageInfo.setPageSize(PageConstant.PAGE_SIZE_30);
            }
            //分页查询页数默认为第一页
            if (pageInfo.getPageNumber() == null || pageInfo.getPageNumber() <= 0) {
                pageInfo.setPageNumber(1);
            }

            //1. 按照区块hash查询区块
            ThanosBlock thanosBlock = thanosBlockDBService.queryBlockByHash(searchCriteria);
            if (thanosBlock != null) {
                result.setTotalCount(1);
                result.setPageSize(pageInfo.getPageSize());
                result.setPageTotal(1);
                result.setResult(Arrays.asList(thanosBlock));
                responseBo.setResult(result);
                responseBo.setSearchType(GlobalSearchConstant.SearchKeyType.TYPE_PKHASH);
                responseBo.setSearchValue(searchCriteria);
                responseBo.setType(GlobalSearchConstant.SearchResultType.TYPE_BLOCK);
                return responseBo;
            }
            //2. 按照区块高度查询区块
            Long blockNumber = null;
            try {
                blockNumber = Long.parseLong(searchCriteria);
            } catch (Exception e) {
                //log.warn("globalSearch with invalid searchCriteria:{}", searchCriteria);
            }
            if (blockNumber != null) {
                thanosBlock = thanosBlockDBService.queryBlockByNumber(blockNumber);
                if (thanosBlock != null) {
                    result.setTotalCount(1);
                    result.setPageSize(pageInfo.getPageSize());
                    result.setPageTotal(1);
                    result.setResult(Arrays.asList(thanosBlock));
                    responseBo.setResult(result);
                    responseBo.setSearchType(GlobalSearchConstant.SearchKeyType.TYPE_BLOCK_NUMBER);
                    responseBo.setSearchValue(searchCriteria);
                    responseBo.setType(GlobalSearchConstant.SearchResultType.TYPE_BLOCK);
                    return responseBo;
                }
            }
            //3. 按照合约地址查询交易
            String contractAddress = searchCriteria;
            if (!searchCriteria.startsWith("0x")) {
                contractAddress = "0x" + searchCriteria;
            }
            ThanosContract thanosContract = thanosContractDBService.queryContractByAddress(contractAddress);
            if (thanosContract != null) {
                int count = thanosContractTransactionDBService.countContractTransactionByContractAddress(contractAddress);
                result.setTotalCount(count);
                result.setPageSize(pageInfo.getPageSize());
                if (count > 0) {
                    int pageTotal = (count % pageInfo.getPageSize() == 0) ? (count / pageInfo.getPageSize()) : (count / pageInfo.getPageSize() + 1);
                    result.setPageTotal(pageTotal);
                }

                result.setSuccessed(true);
                responseBo.setResult(result);
                responseBo.setSearchType(GlobalSearchConstant.SearchKeyType.TYPE_CONTRACT_ADDRESS);
                responseBo.setSearchValue(searchCriteria);
                responseBo.setType(GlobalSearchConstant.SearchResultType.TYPE_CONTRACT);
                return responseBo;
            }

            //4. 按照交易hash查询交易
            ThanosEvmTransactionWithBLOBs thanosTransaction = queryTransactionByHash(searchCriteria, 20, 18);
            if (thanosTransaction != null) {
                result.setTotalCount(1);
                result.setPageSize(pageInfo.getPageSize());
                result.setPageTotal(1);
                result.setResult(Arrays.asList(thanosTransaction));
                responseBo.setResult(result);
                responseBo.setSearchType(GlobalSearchConstant.SearchKeyType.TYPE_PKHASH);
                responseBo.setSearchValue(searchCriteria);
                responseBo.setType(GlobalSearchConstant.SearchResultType.TYPE_TRANSACTION);
                return responseBo;
            }
            //5.按照bcAddress查询交易列表
            result = queryTransactionsByBcAddress(request.getQueryCriteria(), pageInfo.getPageSize(), pageInfo.getPageNumber(), 5, 18);
            if (result != null) {
                responseBo.setResult(result);
                responseBo.setSearchType(GlobalSearchConstant.SearchKeyType.TYPE_BCADDRESS);
                responseBo.setSearchValue(searchCriteria);
                responseBo.setType(GlobalSearchConstant.SearchResultType.TYPE_TRANSACTION);
            } else {
                //返回空
                result = new CommonPageResult<>();
                result.setResult(new ArrayList<>());
                responseBo.setResult(result);
            }
            return responseBo;
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosChainBizServiceImpl globalSearch exception.", e);
            throw new ThanosChainBizException("ThanosChainBizServiceImpl globalSearch Exception.", e);
        }
    }


    /**
     * 根据交易hash查询交易
     *
     * @param txnHash
     * @param queryDaysPerThread
     * @param threadCount
     * @return
     */
    private ThanosEvmTransactionWithBLOBs queryTransactionByHash(String txnHash, int queryDaysPerThread, int threadCount) {
        //捞半年的数据
        Date today = new Date();
        CompletableFuture<Optional<ThanosEvmTransactionWithBLOBs>> completableFuture = new CompletableFuture();
        AtomicInteger queryCounter = new AtomicInteger(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Date endDay = DateUtils.getDateBeforeDate(today, i * queryDaysPerThread);
            ThreadPoolGenerator.queryDBExecutor.execute(() -> {
                boolean dataExist = false;
                try {
                    for (int j = 0; j < queryDaysPerThread; j++) {
                        if (completableFuture.isDone()) {
                            return;
                        }
                        ThanosEvmTransactionWithBLOBs currentTnx = thanosTransactionDBService.queryThanosTransactionByHashAndBlockTimestamp(txnHash, DateUtils.getDateBeforeDate(endDay, j));
                        if (currentTnx != null) {
                            dataExist = true;
                            completableFuture.complete(Optional.of(currentTnx));
                            return;
                        }

                    }
                } catch (Exception e) {
                    log.error("queryTransactionByHash queryDBExecutor failed. ", e);
                } finally {
                    if (!dataExist) {
                        int num = queryCounter.decrementAndGet();
                        if (num == 0) {
                            completableFuture.complete(Optional.empty());
                            return;
                        }
                    }
                }
            });
        }
        try {
            return completableFuture.get().get();
        } catch (Exception e) {
            //log.warn("queryTransactionByHash tnx is null. ");
        }
        return null;
    }

    /**
     * 根据bcAddress查询交易列表
     *
     * @param bcAddress
     * @param queryDaysPerThread
     * @param threadCount
     * @return
     */
    private CommonPageResult<Object> queryTransactionsByBcAddress(String bcAddress, Integer pageSize, Integer pageNumber, int queryDaysPerThread, int threadCount) {
        try {
//            log.info("queryTransactionsByBcAddress start. bcAddress:{}, pageSize:{}, pageNumber:{}, queryDaysPerThread:{}, threadCount:{}.", bcAddress, pageSize, pageNumber, queryDaysPerThread, threadCount);
            try {
                Date today = new Date();
                //统计指定bcAddress在各时间段的交易数量
                Integer[] txnCountArr = new Integer[threadCount];
                CountDownLatch countDownLatch = new CountDownLatch(threadCount);
                for (int i = 0; i < threadCount; i++) {
                    Date endDay = DateUtils.getDateBeforeDate(today, i * queryDaysPerThread);
                    final int index = i;
                    ThreadPoolGenerator.queryDBExecutor.execute(() -> {
                        try {
                            Date startDay = DateUtils.getDateBeforeDate(endDay, queryDaysPerThread);
                            txnCountArr[index] = thanosTransactionDBService.countTransactionsByBcAddressAndDateRange(bcAddress, startDay, endDay);
//                            log.info("queryTransactionsByBcAddress txnCount:{}, bcAddress:{}, startDay:{}, endDay:{}.", txnCountArr[index], bcAddress,
//                                    DateUtils.formatDate(startDay, DateUtils.FMT_DATE_YYYYMMDDHHMM), DateUtils.formatDate(endDay, DateUtils.FMT_DATE_YYYYMMDDHHMM));
                        } catch (Exception e) {
                            log.warn("queryTransactionsByBcAddress countTransactionsByBcAddressAndDateRange failed. bcAddress:{}, endDay:{}, queryDaysPerThread:{}.", bcAddress, endDay, queryDaysPerThread, e);
                        } finally {
                            countDownLatch.countDown();
                        }
                    });
                }
                countDownLatch.await();

                int totalCount = 0;
                for (int i = 0; i < txnCountArr.length; i++) {
                    totalCount += txnCountArr[i];
                }
                //未查询到交易数据，返回空
                if (totalCount == 0) {
                    return null;
                }

                //组装分页信息
                CommonPageResult<Object> result = new CommonPageResult<>();
                result.setTotalCount(totalCount);
                result.setPageSize(pageSize);
                int pageTotal = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
                result.setPageTotal(pageTotal);

                //查询交易列表
                List<ThanosEvmTransaction> list = new ArrayList<>();
                //计算各时间段的交易累加数量
                Integer[] accrueTxnCountArr = txnCountArr.clone();
                for (int i = 1; i < txnCountArr.length; i++) {
                    accrueTxnCountArr[i] = accrueTxnCountArr[i] + accrueTxnCountArr[i - 1];
                }

//                log.info("queryTransactionsByBcAddress accrueTxnCountArr:{}.", JSON.toJSONString(accrueTxnCountArr));
                //[startOffset,endOffset]
                int beginOffset = pageSize * (pageNumber - 1);
                Integer startIndex = null, endIndex = null, startOffset = null, restRaws = pageSize;
                if (beginOffset + restRaws > totalCount) {
                    restRaws = totalCount - beginOffset;
                }

                for (int i = 0; i < accrueTxnCountArr.length; i++) {
                    if (startIndex == null && beginOffset < accrueTxnCountArr[i]) {
                        startIndex = i;
                        startOffset = (i > 0) ? beginOffset - accrueTxnCountArr[i - 1] : beginOffset;
                        if (startOffset + restRaws <= txnCountArr[i]) {
                            //代码走到这，说明查询交易列表在同一个时间段内。
                            endIndex = startIndex;
                            break;
                        } else {
                            restRaws -= txnCountArr[i] - startOffset;
                            continue;
                        }
                    }
                    if (startIndex != null) {
                        //如果剩余交易能在当前时间端查完，或者已经查到最后，则确定endIndex。否则，更新剩余待查交易量，继续遍历。
                        if ((restRaws <= txnCountArr[i]) || (i == accrueTxnCountArr.length - 1)) {
                            endIndex = i;
                            break;
                        } else {
                            restRaws -= txnCountArr[i];
                        }
                    }
                }

//                log.info("queryTransactionsByBcAddress startIndex:{}, endIndex:{}, startOffset:{}, restRaws:{}.", startIndex, endIndex, startOffset, restRaws);

                //代码走到这，如果startIndex为空，说明查询的 初始偏移量> 总交易数，返回空交易列表。否则，继续查询
                if (startIndex != null && endIndex != null) {
                    if (startIndex.equals(endIndex)) {
                        //代码走到这，说明分页查询的交易在同一时间段内。
                        Date endDay = DateUtils.getDateBeforeDate(today, startIndex * queryDaysPerThread);
                        Date startDay = DateUtils.getDateBeforeDate(endDay, queryDaysPerThread);
                        list = thanosTransactionDBService.queryThanosTnxsByBcAddressAndDateRange(bcAddress, startOffset, pageSize, startDay, endDay);
                    } else {
                        //代码走到这，说明分页查询的交易在同多个时间段内，多线程并行查询。
                        int count = endIndex - startIndex + 1;
                        CountDownLatch countDownLatch1 = new CountDownLatch(count);
                        List<ThanosEvmTransaction>[] tnxsArr = new List[count];
                        for (int i = startIndex; i <= endIndex; i++) {
                            Date endDay = DateUtils.getDateBeforeDate(today, i * queryDaysPerThread);
                            int offset = 0, rows = txnCountArr[i];
                            if (i == startIndex) {
                                offset = startOffset;
                                rows = txnCountArr[i] - startOffset;
                            } else if (i == endIndex) {
                                rows = restRaws;
                            }
                            final int queryOffset = offset, queryRows = rows, currentIndex = i - startIndex;
                            ThreadPoolGenerator.queryDBExecutor.execute(() -> {
                                try {
                                    List<ThanosEvmTransaction> currentList = null;
                                    if (queryRows <= 0) {
                                        currentList = new ArrayList<>();
                                    } else {
                                        Date startDay = DateUtils.getDateBeforeDate(endDay, queryDaysPerThread);
                                        currentList = thanosTransactionDBService.queryThanosTnxsByBcAddressAndDateRange(bcAddress, queryOffset, queryRows, startDay, endDay);
                                        if (currentList == null || currentList.size() != queryRows) {
                                            log.warn("queryThanosTnxsByBcAddressAndDateRange size not equal. queryRows:{}, currentList:{}, bcAddress:{}, endDay:{}, queryDaysPerThread:{}.",
                                                    queryRows, currentList == null ? "null" : currentList.size(), bcAddress, endDay, queryDaysPerThread);
                                            currentList = new ArrayList<>();
                                        }
//                                        log.info("queryTransactionsByBcAddress currentIndex:{}, txnCount:{}, bcAddress:{}, startDay:{}, endDay:{}.", currentIndex, currentList.size(), bcAddress,
//                                                DateUtils.formatDate(startDay, DateUtils.FMT_DATE_YYYYMMDDHHMM), DateUtils.formatDate(endDay, DateUtils.FMT_DATE_YYYYMMDDHHMM));
                                    }
                                    tnxsArr[currentIndex] = currentList;
                                } catch (Exception e) {
                                    log.warn("queryTransactionsByBcAddress countTransactionsByBcAddressAndDateRange failed. bcAddress:{}, endDay:{}, queryDaysPerThread:{}.", bcAddress, endDay, queryDaysPerThread, e);
                                } finally {
                                    countDownLatch1.countDown();
                                }
                            });
                        }
                        countDownLatch1.await();
                        for (int i = 0; i < tnxsArr.length; i++) {
                            list.addAll(tnxsArr[i]);
                        }
                    }
                }
                //组装返回值
                result.setResult(new ArrayList<>(list));
                return result;
            } catch (Exception e) {
                log.error("queryTransactionsByBcAddress get tnx failed. ", e);
            }
//            finally {
//                log.info("queryTransactionsByBcAddress down. bcAddress:{}, pageSize:{}, pageNumber:{}, queryDaysPerThread:{}, threadCount:{}.", bcAddress, pageSize, pageNumber, queryDaysPerThread, threadCount);
//            }
            return null;


        } catch (Exception e) {
            log.error("queryTransactionsByBcAddress get tnx failed. ", e);
        }
        return null;
    }

    public static void main(String[] args) {

        Integer[] txnCountArr = new Integer[]{332, 430, 15474, 2309, 52, 220, 450, 0, 2, 10, 3, 0, 0, 0, 0, 0, 5, 0};

        int totalCount = 0;
        for (int i = 0; i < txnCountArr.length; i++) {
            totalCount += txnCountArr[i];
        }

        int pageSize = 20, pageNumber = 965;
        int pageTotal = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);

        //查询交易列表
        List<ThanosEvmTransaction> list = new ArrayList<>();
        //计算各时间段的交易累加数量
        Integer[] accrueTxnCountArr = txnCountArr.clone();
        for (int i = 1; i < txnCountArr.length; i++) {
            accrueTxnCountArr[i] = accrueTxnCountArr[i] + accrueTxnCountArr[i - 1];
        }

        //[startOffset,endOffset]
        int beginOffset = pageSize * (pageNumber - 1);
        Integer startIndex = null, endIndex = null, startOffset = null, restRaws = pageSize;
        if (beginOffset + restRaws > totalCount) {
            restRaws = totalCount - beginOffset;
        }

        for (int i = 0; i < accrueTxnCountArr.length; i++) {
            if (startIndex == null && beginOffset < accrueTxnCountArr[i]) {
                startIndex = i;
                startOffset = (i > 0) ? beginOffset - accrueTxnCountArr[i - 1] : beginOffset;
                if (startOffset + restRaws <= txnCountArr[i]) {
                    //代码走到这，说明查询交易列表在同一个时间段内。
                    endIndex = startIndex;
                    break;
                } else {
                    restRaws -= txnCountArr[i] - startOffset;
                    continue;
                }
            }
            if (startIndex != null) {
                //如果剩余交易能在当前时间端查完，或者已经查到最后，则确定endIndex。否则，更新剩余待查交易量，继续遍历。
                if ((restRaws <= txnCountArr[i]) || (i == accrueTxnCountArr.length - 1)) {
                    endIndex = i;
                    break;
                } else {
                    restRaws -= txnCountArr[i];
                }
            }
        }

        System.out.println("end");
    }
}
