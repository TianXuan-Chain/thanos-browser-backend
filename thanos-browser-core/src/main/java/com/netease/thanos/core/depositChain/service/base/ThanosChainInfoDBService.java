package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosBlockchaininfo;
import com.netease.thanos.core.depositChain.entity.ThanosBlockchaininfoExample;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosBlockchaininfoMapper;

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
public class ThanosChainInfoDBService {
    @Autowired
    private ThanosBlockchaininfoMapper thanosBlockchaininfoMapper;

    /**
     * 新增或修改记录
     * @param request
     * @return
     * @throws ThanosChainDBException
     */
    public boolean createOrModifyWithTnxIncr(ThanosBlockchaininfo request) throws ThanosChainDBException {
        try {
            if (request == null) {
                log.warn("ThanosChainInfoDBService createOrModifyWithTnxIncr exception, request is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            //先查询，如果已存在，则更新；否则，直接插入新记录
            ThanosBlockchaininfo blockchaininfo = queryThanosBlockchainInfo();
            if (blockchaininfo == null) {
                int count = thanosBlockchaininfoMapper.insert(request);
                if (count != 1) {
                    log.error("ThanosChainInfoDBService insert error! and count:{}, request:{}.", count, request.toString());
                    throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
                }
            } else {
                blockchaininfo.setLastBlockNum(request.getLastBlockNum());
                blockchaininfo.setTxnCount(blockchaininfo.getTxnCount() + request.getTxnCount());
                blockchaininfo.setEpoch(request.getEpoch());
                blockchaininfo.setRound(request.getRound());
                blockchaininfo.setAvgTime(request.getAvgTime());
                int count = thanosBlockchaininfoMapper.updateByPrimaryKey(blockchaininfo);
                if (count != 1) {
                    log.error("ThanosChainInfoDBService updateByPrimaryKey error! and count:{}, request:{}.", count, request.toString());
                    throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
                }
            }
            return true;
        } catch (Exception e) {
            log.error("ThanosChainInfoDBService createOrModifyWithTnxIncr Exception, request:{}. e:{}.", request, e.getMessage());
            throw new ThanosChainDBException("ThanosChainInfoDBService createOrModifyWithTnxIncr exception.", e);
        }
    }

    /**
     * 查询表中的链信息记录（表中只有一条）
     *
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosBlockchaininfo queryThanosBlockchainInfo() throws ThanosChainDBException {
        try {
            ThanosBlockchaininfoExample example = new ThanosBlockchaininfoExample();
            List<ThanosBlockchaininfo> list = thanosBlockchaininfoMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            log.error("ThanosChainInfoDBService queryThanosBlockchainInfo Exception. e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosChainInfoDBService queryThanosBlockchainInfo exception.", e);
        }
    }

}
