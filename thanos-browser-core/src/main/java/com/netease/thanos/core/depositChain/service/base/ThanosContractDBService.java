package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosContract;
import com.netease.thanos.core.depositChain.entity.ThanosContractExample;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosContractMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 类 ThanosContractDBService.java 的实现描述: 合约DB服务
 * Created by wangting04 on 2023/06/15
 */
@Service
@Slf4j
public class ThanosContractDBService {
    @Autowired
    private ThanosContractMapper thanosContractMapper;

    /**
     * 创建合约列表
     *
     * @param thanosContractList
     * @return
     * @throws ThanosChainDBException
     */
    public boolean createThanosContractList(List<ThanosContract> thanosContractList) throws ThanosChainDBException {
        try {
            boolean flag = thanosContractMapper.batchInsert(thanosContractList) >= thanosContractList.size();
            if (!flag) {
                log.error("ThanosContractDBService createThanosContractList error! ");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
            return true;
        } catch (Exception e) {
            log.error("ThanosContractDBService createThanosContractList Exception, thanosContractList:{}.", thanosContractList, e);
            throw new ThanosChainDBException("ThanosContractDBService createThanosContractList exception.", e);
        }
    }

    /**
     * 查询合约
     * @param contractAddress
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosContract queryContractByAddress(String contractAddress) throws ThanosChainDBException {
        try {
            ThanosContractExample example = new ThanosContractExample();
            example.createCriteria().andContractAddressEqualTo(contractAddress);
            List<ThanosContract> contractList = thanosContractMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(contractList)) {
                return contractList.get(0);
            }
            return null;
        } catch (Exception e) {
            log.error("ThanosContractDBService queryContractByAddress Exception, contractAddress:{}.", contractAddress, e);
            throw new ThanosChainDBException("ThanosContractDBService queryContractByAddress exception.", e);
        }

    }
}
