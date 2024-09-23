package com.netease.thanos.core.depositChain.service.biz.impl;

import com.netease.thanos.common.constants.PageConstant;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.entity.ThanosBlock;
import com.netease.thanos.core.depositChain.entity.ThanosBlockchaininfo;
import com.netease.thanos.core.depositChain.exception.ThanosChainBizException;
import com.netease.thanos.core.depositChain.service.base.ThanosBlockDBService;
import com.netease.thanos.core.depositChain.service.base.ThanosChainInfoDBService;
import com.netease.thanos.core.depositChain.service.biz.ThanosBlockBizService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类ThanosBlockBizServiceImpl.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:37
 */
@Component
@Slf4j
public class ThanosBlockBizServiceImpl implements ThanosBlockBizService {
    @Autowired
    private ThanosBlockDBService thanosBlockDBService;
    @Autowired
    private ThanosChainInfoDBService chainInfoDBService;

    @Override
    public Long queryMaxBlockHeight() throws ThanosChainBizException {
        try {
            ThanosBlockchaininfo chaininfo = chainInfoDBService.queryThanosBlockchainInfo();
            if (chaininfo == null || chaininfo.getLastBlockNum() == null) {
                return 0L;
            }
            return chaininfo.getLastBlockNum();
        } catch (Exception e) {
            log.error("ThanosBlockBizServiceImpl queryMaxBlockHeight exception.", e);
            throw new ThanosChainBizException("ThanosBlockBizServiceImpl queryMaxBlockHeight Exception.", e);
        }
    }

    @Override
    public ThanosBlock queryBlockDetail(String hash) {

        try {
            if (StringUtils.isBlank(hash)) {
                log.warn("ThanosBlockBizServiceImpl.queryBlockDetail hash is null.");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            return thanosBlockDBService.queryBlockByHash(hash);
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosBlockBizServiceImpl queryBlockDetail exception.", e);
            throw new ThanosChainBizException("ThanosBlockBizServiceImpl queryBlockDetail Exception.", e);
        }
    }

    @Override
    public CommonPageResult<ThanosBlock> pageQueryBlocks(CommonPageQuery<Void> request) {
        CommonPageResult<ThanosBlock> commonPageResult = new CommonPageResult<>();
        try {
            if (request == null) {
                log.warn(" ThanosBlockBizServiceImpl pageQueryBlocks request is null!");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            //分页信息
            CommonPageQuery.PageInfo pageInfo = request.getPageInfo();
            if (pageInfo == null) {
                pageInfo = new CommonPageQuery.PageInfo();
            }
            //分页查询的单页条数不能超过50条，默认为30条
            if (pageInfo.getPageSize() == null || pageInfo.getPageSize() < 0) {
                pageInfo.setPageSize(PageConstant.PAGE_SIZE_30);
            }
            if (pageInfo.getPageSize() > PageConstant.PAGE_SIZE_50) {
                pageInfo.setPageSize(PageConstant.PAGE_SIZE_50);
            }
            //分页查询页数默认为第一页
            if (pageInfo.getPageNumber() == null || pageInfo.getPageNumber() <= 0) {
                pageInfo.setPageNumber(1);
            }
            if (pageInfo.getPageNumber() > PageConstant.PAGE_NUMBER_100) {
                pageInfo.setPageNumber(PageConstant.PAGE_NUMBER_100);
            }

            ThanosBlockchaininfo chaininfo = chainInfoDBService.queryThanosBlockchainInfo();
            if (chaininfo != null && chaininfo.getLastBlockNum() != null && chaininfo.getLastBlockNum() > 0) {
                int totalCount = chaininfo.getLastBlockNum().intValue();
                commonPageResult.setTotalCount(totalCount);
                commonPageResult.setPageSize(pageInfo.getPageSize());
                int pageTotal = (totalCount % pageInfo.getPageSize() == 0) ? (totalCount / pageInfo.getPageSize()) : (totalCount / pageInfo.getPageSize() + 1);
                commonPageResult.setPageTotal(pageTotal);
                List<ThanosBlock> list = thanosBlockDBService.queryBlocksByPage(pageInfo.getPageSize(), pageInfo.getPageNumber());
                commonPageResult.setResult(list);
            }
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosBlockBizServiceImpl queryBlockDetail exception.", e);
            throw new ThanosChainBizException("ThanosBlockBizServiceImpl queryBlockDetail Exception.", e);
        }
        return commonPageResult;
    }
    
    
    @Override
    public ThanosBlock queryBlockByNumber(Long number) {
        try {
            if (number==null) {
                log.warn("ThanosBlockBizServiceImpl.queryBlockByNumber hash is null.");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            return thanosBlockDBService.queryBlockByNumber(number);
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosBlockBizServiceImpl queryBlockByNumber exception.", e);
            throw new ThanosChainBizException("ThanosBlockBizServiceImpl queryBlockByNumber Exception.", e);
        }
    }
    
    

    //最多2000条
    @Override
    public List<ThanosBlock> queryLatestBlocks(Integer num) {
        try {
            if (num==null) {
                log.warn("ThanosBlockBizServiceImpl.queryLatestBlocks num is null.");
                throw new ThanosChainBizException(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
            }
            
            if(num>2000) {
            	 log.warn("ThanosBlockBizServiceImpl.queryLatestBlocks num >2000.");
                 throw new ThanosChainBizException(ThanosErrorCodeDTO.PARAMETER_ERROR);
            }
            
            return thanosBlockDBService.queryLatestBlocks(num);
        } catch (ThanosChainBizException e) {
            throw e;
        } catch (Exception e) {
            log.error("ThanosBlockBizServiceImpl queryLatestBlocks exception.", e);
            throw new ThanosChainBizException("ThanosBlockBizServiceImpl queryLatestBlocks Exception.", e);
        }
    }
    
    
    
    
}
