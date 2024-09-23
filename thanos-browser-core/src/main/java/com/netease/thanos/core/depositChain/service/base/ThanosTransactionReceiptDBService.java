package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransactionreceiptWithBLOBs;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosEvmTransactionreceiptMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 类ThanosBlockDBService.java的实现描述：区块 db service
 *
 * @author xuhao create on 2021/1/20 17:39
 */

@Service
@Slf4j
public class ThanosTransactionReceiptDBService {
    @Autowired
    private ThanosEvmTransactionreceiptMapper thanosEvmTransactionreceiptMapper;


    /**
     * 批量生成记录
     * @param receiptList
     * @return
     * @throws ThanosChainDBException
     */
    public boolean batchCreate(List<ThanosEvmTransactionreceiptWithBLOBs> receiptList) throws ThanosChainDBException {
        try {
            if (CollectionUtils.isEmpty(receiptList)) {
                log.warn("ThanosTransactionReceiptDBService batchCreate exception, thanosEvmTransactionList is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            int count = thanosEvmTransactionreceiptMapper.batchInsert(receiptList);
            if (count != receiptList.size()) {
                log.error("ThanosTransactionReceiptDBService batchCreate error!  count={}, request size={}", count, receiptList.size());
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
        } catch (Exception e) {
            log.error("ThanosTransactionReceiptDBService batchCreate Exception. e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosTransactionReceiptDBService batchCreate exception.", e);
        }
        return true;
    }

}
