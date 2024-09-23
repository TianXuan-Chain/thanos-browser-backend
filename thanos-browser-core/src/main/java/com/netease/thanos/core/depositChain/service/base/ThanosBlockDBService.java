package com.netease.thanos.core.depositChain.service.base;

import com.netease.thanos.common.constants.PageConstant;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosBlock;
import com.netease.thanos.core.depositChain.entity.ThanosBlockExample;
import com.netease.thanos.core.depositChain.exception.ThanosChainDBException;
import com.netease.thanos.core.depositChain.repository.ThanosBlockMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 类ThanosBlockDBService.java的实现描述：区块 db service
 *
 * @author xuhao create on 2021/1/20 17:39
 */

@Service
@Slf4j
public class ThanosBlockDBService {
    @Autowired
    private ThanosBlockMapper thanosBlockMapper;

    /**
     * 新增区块信息
     *
     * @param request
     * @return
     * @throws ThanosChainDBException
     */
    public boolean createThanosBlock(ThanosBlock request) throws ThanosChainDBException {
        try {
            if (request == null) {
                log.warn("ThanosBlockDBService createThanosBlock exception, block is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            int count = thanosBlockMapper.insert(request);
            if (count != 1) {
                log.error("ThanosBlockDBService createThanosBlock error! and count:{}, request:{}.", count, request.toString());
                throw new ThanosChainDBException(ThanosErrorCodeDTO.DB_ERROR);
            }
            return true;
        } catch (ThanosChainDBException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosBlockDBService createThanosBlock Exception, request:{}. e:{}.", request, e.getMessage());
            throw new ThanosChainDBException("ThanosBlockDBService createThanosBlock exception.", e);
        }
    }


    /**
     * 根据块高查询区块信息
     *
     * @param blockNumber
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosBlock queryBlockByNumber(Long blockNumber) throws ThanosChainDBException {
        try {
            if (blockNumber == null) {
                log.warn("ThanosBlockDBService queryBlockByNumber exception, blockNumber or chainId is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosBlockExample example = new ThanosBlockExample();
            example.createCriteria().andNumberEqualTo(blockNumber);
            example.withLimit(1);
            List<ThanosBlock> list = thanosBlockMapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            log.error("ThanosBlockDBService queryBlockByNumber Exception, blockNumber:{}. e:{}.", blockNumber, e.getMessage());
            throw new ThanosChainDBException("ThanosBlockDBService queryBlockByNumber exception.", e);
        }
    }


    /**
     * 查询链的最大块高
     *
     * @return
     */
    public Long queryMaxBlockHeight() {
        try {
            ThanosBlockExample example = new ThanosBlockExample();
            Long height = thanosBlockMapper.maxNumber(example);
            return height == null ? 0 : height;

        } catch (Exception e) {
            log.error("ThanosBlockDBService queryMaxBlockHeight Exception, e:{}.", e);
            throw new ThanosChainDBException("ThanosBlockDBService queryMaxBlockHeight exception.", e);
        }
    }

    /**
     * 根据hash查询区块
     *
     * @param hash
     * @return
     * @throws ThanosChainDBException
     */
    public ThanosBlock queryBlockByHash(String hash) throws ThanosChainDBException {
        try {
            if (StringUtils.isEmpty(hash)) {
                log.warn("ThanosBlockDBService queryBlockByHash exception, hash is null.");
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosBlockExample example = new ThanosBlockExample();
            example.createCriteria().andPkHashEqualTo(hash);
            example.setOrderByClause(" id desc ");
            example.withLimit(1);
            List<ThanosBlock> list = thanosBlockMapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            log.error("ThanosBlockDBService queryBlockByHash Exception, hash:{}. e:{}.", hash, e.getMessage());
            throw new ThanosChainDBException("ThanosBlockDBService queryBlockByHash exception.", e);
        }
    }

    /**
     * 查询所有区块数量
     *
     * @return
     * @throws ThanosChainDBException
     */
    public int countBlocks() throws ThanosChainDBException {
        try {
            ThanosBlockExample example = new ThanosBlockExample();
            return thanosBlockMapper.countByExample(example);
        } catch (Exception e) {
            log.error("ThanosBlockDBService countBlocks Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosBlockDBService countBlocks exception.", e);
        }
    }

    /**
     * 分页查询区块列表
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public List<ThanosBlock> queryBlocksByPage(Integer pageSize, Integer pageNumber) {
        try {
            if (pageSize == null || pageSize <= 0 || pageSize > PageConstant.PAGE_SIZE_500) {
                log.error("ThanosBlockDBService.pageQueryBlocks pageSize invalid, pageSize:{}.", pageSize);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            if (pageNumber == null || pageNumber <= 0) {
                log.error("ThanosBlockDBService.pageQueryBlocks pageNumber invalid ,pageNumber:{}", pageNumber);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosBlockExample example = new ThanosBlockExample();
            example.setOrderByClause(" id desc ");
            example.withLimit((pageNumber - 1) * pageSize, pageSize);
            return thanosBlockMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("ThanosBlockDBService pageQueryBlocks Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosBlockDBService pageQueryBlocks exception.", e);
        }
    }


    /**
     * 查询最新区块
     *
     * @param num
     * @param
     * @return
     */
    public List<ThanosBlock> queryLatestBlocks(Integer num) {
        try {
            if (num == null || num > 2000) {
                log.error("ThanosBlockDBService.pageQueryBlocks queryLatestBlocks invalid ,num:{}", num);
                throw new ThanosChainDBException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            ThanosBlockExample example = new ThanosBlockExample();
            example.setOrderByClause(" id desc ");
            example.withLimit(num);
            return thanosBlockMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("ThanosBlockDBService queryLatestBlocks Exception, e:{}.", e.getMessage());
            throw new ThanosChainDBException("ThanosBlockDBService queryLatestBlocks exception.", e);
        }
    }


}
