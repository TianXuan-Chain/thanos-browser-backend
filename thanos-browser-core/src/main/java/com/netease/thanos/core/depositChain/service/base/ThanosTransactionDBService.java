package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.constants.PageConstant;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransaction;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransactionExample;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransactionWithBLOBs;
import com.netease.thanos.core.depositChain.enums.ContractBizType;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosEvmTransactionMapper;
import com.netease.thanos.core.depositChain.util.PartitionKeyUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 类ThanosBlockDBService.java的实现描述：区块 db service
 *
 * @author xuhao create on 2021/1/20 17:39
 */

@Service
@Slf4j
public class ThanosTransactionDBService {
    @Autowired
    private ThanosEvmTransactionMapper thanosEvmTransactionMapper;


    public boolean batchCreate(List<ThanosEvmTransactionWithBLOBs> thanosEvmTransactionList) throws ThanosChainDBException {
        try {
            if (CollectionUtils.isEmpty(thanosEvmTransactionList)) {
                log.warn("ThanosTransactionDBService batchCreate exception, thanosEvmTransactionList is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            int count = thanosEvmTransactionMapper.batchInsert(thanosEvmTransactionList);
            if (count != thanosEvmTransactionList.size()) {
                log.error("ThanosTransactionDBService batchCreate error!  count={}, tnxSize={}", count, thanosEvmTransactionList.size());
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
        } catch (Exception e) {
            log.error("ThanosTransactionDBService batchCreate Exception. e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService batchCreate exception.", e);
        }
        return true;
    }


    /**
     * 根据交易hash查询对应交易
     *
     * @param hash
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosEvmTransactionWithBLOBs queryThanosTransactionByHashAndBlockTimestamp(String hash, Date timestamp) throws ThanosChainDBException {
        try {
            if (hash == null) {
                log.warn("ThanosTransactionDBService queryThanosTransactionByHashAndBlockTimestamp exception, hash is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }


            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            ThanosEvmTransactionExample.Criteria criteria = example.createCriteria().andPkHashEqualTo(hash);
            if (timestamp != null) {
                Long partitionKey = PartitionKeyUtil.getPartitionKey(timestamp);
                criteria.andPartitionKeyEqualTo(partitionKey);
            }
            example.withLimit(1);
            List<ThanosEvmTransactionWithBLOBs> list = thanosEvmTransactionMapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            log.error("ThanosTransactionDBService queryThanosTransactionByHashAndBlockTimestamp Exception, hash:{}. e:{}.", hash, e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService queryThanosTransactionByHashAndBlockTimestamp exception.", e);
        }
    }

    /**
     * 根据交易hash和时间范围查询对应交易
     *
     * @param hash
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosEvmTransactionWithBLOBs queryThanosTransactionByHashAndDateRange(String hash, Date startDate, Date endDate) throws ThanosChainDBException {
        try {
            if (StringUtils.isBlank(hash)) {
                log.warn("ThanosTransactionDBService queryThanosTransactionByHashAndDateRange exception, hash is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }


            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            ThanosEvmTransactionExample.Criteria criteria = example.createCriteria().andPkHashEqualTo(hash);
            if (endDate != null) {
                Long endPartitionKey = PartitionKeyUtil.getPartitionKey(endDate);
                criteria.andPartitionKeyLessThanOrEqualTo(endPartitionKey);
            }
            if (startDate != null) {
                Long startPartitionKey = PartitionKeyUtil.getPartitionKey(startDate);
                criteria.andPartitionKeyGreaterThan(startPartitionKey);
            }
            example.withLimit(1);
            example.setOrderByClause(" id desc");
            List<ThanosEvmTransactionWithBLOBs> list = thanosEvmTransactionMapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            log.error("ThanosTransactionDBService queryThanosTransactionByHashAndDateRange Exception, hash:{}. e:{}.", hash, e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService queryThanosTransactionByHashAndDateRange exception.", e);
        }
    }

    /**
     * 根据区块高度，查询该区块中的交易数量
     *
     * @param blockNumber
     * @return
     */
    public int countTransactionsByBlockNumber(Long blockNumber, Long partitionKey) {
        try {
            if (blockNumber == null) {
                log.error("ThanosTransactionDBService.countTransactionsByBlockNumber blockNumber is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            example.createCriteria().andPartitionKeyEqualTo(partitionKey).andBlockNumberEqualTo(blockNumber);
            return thanosEvmTransactionMapper.countByExample(example);
        } catch (Exception e) {
            log.error("ThanosTransactionDBService countTransactionsByBlockNumber Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService countTransactionsByBlockNumber exception.", e);
        }
    }

    /**
     * 根据块高分页查询交易列表，最近的交易放在最前面
     *
     * @param blockNumber
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public List<ThanosEvmTransaction> queryThanosTnxsByBlockNumberByPage(Long blockNumber, Long partitionKey, Integer pageSize, Integer pageNumber) {
        try {
            if (blockNumber == null || blockNumber < 0) {
                log.error("ThanosTransactionDBService.queryThanosTnxsByBlockNumberByPage blockNumber invalid, blockNumber:{}.", blockNumber);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            if (pageSize == null || pageSize <= 0 || pageSize > PageConstant.TOTAL_MAX_500000) {
                log.error("ThanosTransactionDBService.queryThanosTnxsByBlockNumberByPage pageSize invalid, pageSize:{}.", pageSize);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            if (pageNumber == null || pageNumber <= 0) {
                log.error("ThanosTransactionDBService.queryThanosTnxsByBlockNumberByPage pageNumber invalid, pageNumber:{}.", pageNumber);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            example.createCriteria().andBlockNumberEqualTo(blockNumber).andPartitionKeyEqualTo(partitionKey);
            example.setOrderByClause(" id desc");
            example.withLimit((pageNumber - 1) * pageSize, pageSize);
            return thanosEvmTransactionMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("ThanosTransactionDBService queryThanosTnxsByBlockNumberByPage Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService queryThanosTnxsByBlockNumberByPage exception.", e);
        }
    }


    /**
     * 分页查询交易列表，最近的交易放在最前面
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public List<ThanosEvmTransaction> pageQueryThanosTnxsBeforePartition(Integer pageSize, Integer pageNumber, Long partitionKey) {
        try {
            if (pageSize == null || pageSize <= 0 || pageSize > PageConstant.PAGE_SIZE_50) {
                log.error("ThanosTransactionDBService.queryThanosTnxsByBlockNumberByPage pageSize invalid, pageSize:{}.", pageSize);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            if (pageNumber == null || pageNumber <= 0 || pageNumber > PageConstant.PAGE_NUMBER_100) {
                log.error("ThanosTransactionDBService.queryThanosTnxsByBlockNumberByPage pageNumber invalid, pageNumber:{}.", pageNumber);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            if (partitionKey != null) {
                example.createCriteria().andPartitionKeyLessThanOrEqualTo(partitionKey);
            }
            example.setOrderByClause(" id desc");
            example.withLimit((pageNumber - 1) * pageSize, pageSize);
            return thanosEvmTransactionMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("ThanosTransactionDBService pageQueryThanosTnxsBeforePartition Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService pageQueryThanosTnxsBeforePartition exception.", e);
        }
    }

    /**
     * 根据区块链地址查询关联交易数量（目前暂不使用，效率太低）
     *
     * @param bcAddress
     * @return
     */
    public int countTransactionsByBcAddressAndDateRange(String bcAddress, Date startDate, Date endDate) {
        try {
            if (StringUtils.isBlank(bcAddress)) {
                log.error("ThanosTransactionDBService.countTransactionsByBcAddressAndDateRange bcAddress is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            ThanosEvmTransactionExample.Criteria criteria = example.createCriteria().andTransactionFromEqualTo(bcAddress);
            if (endDate != null) {
                Long endPartitionKey = PartitionKeyUtil.getPartitionKey(endDate);
                criteria.andPartitionKeyLessThanOrEqualTo(endPartitionKey);
            }
            if (startDate != null) {
                Long startPartitionKey = PartitionKeyUtil.getPartitionKey(startDate);
                criteria.andPartitionKeyGreaterThan(startPartitionKey);
            }
            return thanosEvmTransactionMapper.countByExample(example);
        } catch (Exception e) {
            log.error("ThanosTransactionDBService countTransactionsByBcAddressAndDateRange Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService countTransactionsByBcAddressAndDateRange exception.", e);
        }
    }

    /**
     * 根据区块链地址分页查询关联交易列表（目前暂不使用，效率太低）
     *
     * @param bcAddress
     * @param offset
     * @param rows
     * @return
     */
    public List<ThanosEvmTransaction> queryThanosTnxsByBcAddressAndDateRange(String bcAddress, int offset, int rows, Date startDate, Date endDate) {
        try {
            if (StringUtils.isBlank(bcAddress)) {
                log.error("ThanosTransactionDBService.queryThanosTnxsByBcAddressByPage bcAddress is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            ThanosEvmTransactionExample.Criteria criteria = example.createCriteria().andTransactionFromEqualTo(bcAddress);
            if (endDate != null) {
                Long endPartitionKey = PartitionKeyUtil.getPartitionKey(endDate);
                criteria.andPartitionKeyLessThanOrEqualTo(endPartitionKey);
            }
            if (startDate != null) {
                Long startPartitionKey = PartitionKeyUtil.getPartitionKey(startDate);
                criteria.andPartitionKeyGreaterThan(startPartitionKey);
            }
            example.withLimit(offset, rows);
            example.setOrderByClause(" id desc");
            return thanosEvmTransactionMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("ThanosTransactionDBService queryThanosTnxsByBcAddressByPage Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionDBService queryThanosTnxsByBcAddressByPage exception.", e);
        }
    }

    public void modify(ThanosEvmTransactionWithBLOBs transaction) {
        try {
            int count = thanosEvmTransactionMapper.updateByPrimaryKeyWithBLOBs(transaction);
            if (count != 1) {
                log.error("ThanosTransactionDBService modify failed, count:{}, transaction:{}.", count, transaction);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
        } catch (ThanosChainDBException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionDBService modify Exception, transaction:{}.", transaction, e);
            throw new ThanosChainDBException("ThanosTransactionDBService modify exception.", e);
        }
    }

    public void modifySelective(ThanosEvmTransactionWithBLOBs transaction) {
        try {
            int count = thanosEvmTransactionMapper.updateByPrimaryKeySelective(transaction);
            if (count != 1) {
                log.error("ThanosTransactionDBService modifySelective failed, count:{}, transaction:{}.", count, transaction);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
        } catch (ThanosChainDBException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionDBService modifySelective Exception, transaction:{}.", transaction, e);
            throw new ThanosChainDBException("ThanosTransactionDBService modify exception.", e);
        }

    }

    /**
     * @param contractBizType
     * @param partitionKey
     * @return
     */
    public Long maxId(ContractBizType contractBizType, Long partitionKey) {
        try {
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            example.createCriteria().andPartitionKeyGreaterThan(partitionKey).andTransactionTypeEqualTo(contractBizType.getBizType());
            return thanosEvmTransactionMapper.maxId(example);
        } catch (ThanosChainDBException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionDBService maxId error, contractBizType:{}, partitionKey:{}", contractBizType, partitionKey, e);
            throw new ThanosChainDBException("ThanosTransactionDBService maxId exception.", e);
        }
    }

    /**
     * @param contractBizType
     * @param partitionKey
     * @return
     */
    public Long minId(ContractBizType contractBizType, Long partitionKey) {
        try {
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            example.createCriteria().andPartitionKeyGreaterThan(partitionKey).andTransactionTypeEqualTo(contractBizType.getBizType());
            return thanosEvmTransactionMapper.minId(example);
        } catch (ThanosChainDBException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionDBService minId error, contractBizType:{}, partitionKey:{}", contractBizType, partitionKey, e);
            throw new ThanosChainDBException("ThanosTransactionDBService minId exception.", e);
        }
    }

    /**
     * @param startIndex
     * @param endIndex
     * @param bizType
     * @return
     */
    public List<ThanosEvmTransactionWithBLOBs> queryRange(Long startIndex, Long endIndex, ContractBizType bizType) {
        try {
            ThanosEvmTransactionExample example = new ThanosEvmTransactionExample();
            example.createCriteria().andIdGreaterThanOrEqualTo(startIndex).andIdLessThanOrEqualTo(endIndex).andTransactionTypeEqualTo(bizType.getBizType());
            return thanosEvmTransactionMapper.selectByExampleWithBLOBs(example);
        } catch (ThanosChainDBException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosTransactionDBService queryRange error, contractBizType:{}, startIndex:{}，endIndex:{}",bizType, startIndex, endIndex, e);
            throw new ThanosChainDBException("ThanosTransactionDBService queryRange exception.", e);
        }
    }

}
