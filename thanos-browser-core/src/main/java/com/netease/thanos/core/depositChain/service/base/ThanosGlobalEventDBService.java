package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosGlobalEvent;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosGlobalEventMapper;

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
public class ThanosGlobalEventDBService {
    @Autowired
    private ThanosGlobalEventMapper thanosGlobalEventMapper;


    /**
     * 批量生成全局事件记录
     * @param eventList
     * @return
     * @throws ThanosChainDBException
     */
    public boolean batchCreate(List<ThanosGlobalEvent> eventList) throws ThanosChainDBException {
        try {
            if (CollectionUtils.isEmpty(eventList)) {
                log.warn("ThanosGlobalEventDBService batchCreate exception, thanosEvmTransactionList is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            int count = thanosGlobalEventMapper.batchInsert(eventList);
            if (count != eventList.size()) {
                log.error("ThanosGlobalEventDBService batchCreate error!  count={}, request size={}", count, eventList.size());
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
        } catch (Exception e) {
            log.error("ThanosGlobalEventDBService batchCreate Exception. e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosGlobalEventDBService batchCreate exception.", e);
        }
        return true;
    }

}
