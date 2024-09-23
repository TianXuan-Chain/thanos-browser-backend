package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosContractTransaction;
import com.netease.thanos.core.depositChain.entity.ThanosContractTransactionExample;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosContractTransactionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类 ThanosContractTransactionDBService.java 的实现描述: 合约交易DB数据库服务
 * Created by wangting04 on 2023/06/15
 */
@Service
@Slf4j
public class ThanosContractTransactionDBService {
    @Autowired
    private ThanosContractTransactionMapper thanosContractTransactionMapper;

    /**
     * 查询合约的交易数量
     *
     * @param contractAddress
     * @return
     * @throws ThanosChainDBException
     */
    public int countContractTransactionByContractAddress(String contractAddress) throws ThanosChainDBException {
        try {
            ThanosContractTransactionExample example = new ThanosContractTransactionExample();
            example.createCriteria().andContractAddressEqualTo(contractAddress);

            return thanosContractTransactionMapper.countByExample(example);
        } catch (Exception e) {
            log.error("ThanosContractTransactionDBService countContractTransactionByContractAddress Exception, contractAddress:{}", contractAddress, e);
            throw new ThanosChainDBException("ThanosContractTransactionDBService countContractTransactionByContractAddress exception.", e);
        }
    }

    /**
     * 查询合约交易
     *
     * @param contractAddress
     * @param offset
     * @param limit
     * @return
     * @throws ThanosChainDBException
     */
    public List<ThanosContractTransaction> queryContractTransactionByContractAddressAndOffset(String contractAddress, int offset, int limit) throws ThanosChainDBException {
        try {
            ThanosContractTransactionExample example = new ThanosContractTransactionExample();
            example.createCriteria().andContractAddressEqualTo(contractAddress);
            example.setOrderByClause(" create_time desc, id desc ");
            example.withLimit(offset, limit);

            return thanosContractTransactionMapper.selectByExampleWithBLOBs(example);
        } catch (Exception e) {
            log.error("ThanosContractTransactionDBService queryContractTransactionByContractAddressAndOffset Exception, contractAddress:{}. offset:{}", contractAddress, offset, e);
            throw new ThanosChainDBException("ThanosContractTransactionDBService queryContractTransactionByContractAddressAndOffset exception.", e);
        }
    }

    /**
     * 创建 合约交易
     *
     * @param contractTransactions
     * @throws ThanosChainDBException
     */
    public boolean batchCreate(List<ThanosContractTransaction> contractTransactions) throws ThanosChainDBException {
        try {
            boolean flag = thanosContractTransactionMapper.batchInsert(contractTransactions) >= contractTransactions.size();
            if (!flag) {
                log.error("ThanosContractTransactionDBService batchCreate error! ");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
            return true;
        } catch (Exception e) {
            log.error("ThanosContractTransactionDBService batchCreate Exception, contractTransactions:{}", contractTransactions, e);
            throw new ThanosChainDBException("ThanosContractTransactionDBService batchCreate exception.", e);
        }

    }

    /**
     * 删除 合约交易
     *
     * @param contractAddress
     * @param removeIds
     */
    public boolean deleteByContractAddressAndIds(String contractAddress, List<Long> removeIds) {
        try {
            boolean flag = thanosContractTransactionMapper.deleteContractTxByIDs(contractAddress, removeIds) >= removeIds.size();
            if (!flag) {
                log.error("ThanosContractTransactionDBService deleteByContractAddressAndIds error! ");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
            return true;
        } catch (Exception e) {
            log.error("ThanosContractTransactionDBService deleteByContractAddressAndIds Exception,contractAddress:{}, removeIds:{}", contractAddress, removeIds, e);
            throw new ThanosChainDBException("ThanosContractTransactionDBService deleteByContractAddressAndIds exception.", e);
        }
    }
}
