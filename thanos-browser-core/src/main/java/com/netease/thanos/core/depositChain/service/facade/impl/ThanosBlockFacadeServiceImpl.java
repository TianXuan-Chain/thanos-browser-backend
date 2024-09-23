package com.netease.thanos.core.depositChain.service.facade.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.thanos.api.dto.thanos.ThanosBlockDTO;
import com.netease.thanos.common.assembler.CommonAssembler;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.CommonResultDTO;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.assember.CommonPageAssmbler;
import com.netease.thanos.core.depositChain.assember.ThanosChainAssmbler;
import com.netease.thanos.core.depositChain.entity.ThanosBlock;
import com.netease.thanos.core.depositChain.exception.ThanosChainBizException;
import com.netease.thanos.core.depositChain.service.biz.ThanosBlockBizService;
import com.netease.thanos.core.depositChain.service.facade.ThanosBlockFacadeService;

import lombok.extern.slf4j.Slf4j;

/**
 * 类ThanosBlockFacadeServiceImpl.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:52
 */
@Service
@Slf4j
public class ThanosBlockFacadeServiceImpl implements ThanosBlockFacadeService {

    @Autowired
    private ThanosBlockBizService thanosBlockBizService;

    @Override
    public CommonResultDTO<Long> queryMaxBlockHeight() {
        CommonResultDTO<Long> resultDTO = new CommonResultDTO<>();
        try {

            Long maxBlockHeight = thanosBlockBizService.queryMaxBlockHeight();
            resultDTO.setSuccessed(true);
            resultDTO.setResult(maxBlockHeight);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosBlockFacadeServiceImpl.queryMaxBlockHeight Exception.", e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonResultDTO<ThanosBlockDTO> queryBlockDetail(String hash) {
        CommonResultDTO<ThanosBlockDTO> resultDTO = new CommonResultDTO<>();
        try {
            if (StringUtils.isBlank(hash)) {
                log.warn("ThanosBlockFacadeServiceImpl.queryBlockDetail hash is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            ThanosBlock bo = thanosBlockBizService.queryBlockDetail(hash);
            resultDTO.setSuccessed(true);
            resultDTO.setResult(ThanosChainAssmbler.thanosBlockBo2DTO(bo));
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosBlockFacadeServiceImpl.queryBlockDetail Exception. hash:{}.", hash, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonPageResult<ThanosBlockDTO> pageQueryBlocks(CommonPageQuery<Void> request) {
        CommonPageResult<ThanosBlockDTO> resultDTO = new CommonPageResult<>();
        try {
            if (request == null) {
                log.warn("ThanosBlockFacadeServiceImpl.pageQueryBlocks request is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            CommonPageResult<ThanosBlock> bo = thanosBlockBizService.pageQueryBlocks(request);
            resultDTO = CommonPageAssmbler.thanosBlockCommonPageResultBo2DTO(bo);
            resultDTO.setSuccessed(true);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosBlockFacadeServiceImpl.queryBlockDetail Exception. request:{}.", request, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }
    
    @Override
    public CommonResultDTO<List<ThanosBlockDTO>> queryBlocks(Long blockNumber,Integer num ) {
    	CommonResultDTO<List<ThanosBlockDTO>> resultDTO = new CommonResultDTO<>();
        try {
            if (blockNumber != null) {
            	ThanosBlock thanosBlock=thanosBlockBizService.queryBlockByNumber(blockNumber);
            	 ThanosBlockDTO dto = ThanosChainAssmbler.thanosBlockBo2DTO(thanosBlock);
            	 resultDTO.setSuccessed(true);
            	 resultDTO.setResult(Arrays.asList(dto));
            	return resultDTO;
            }
           List<ThanosBlock>  list= thanosBlockBizService.queryLatestBlocks(num);
           resultDTO.setResult(CommonPageAssmbler.thanosBlockBo2DTOList(list));
           resultDTO.setSuccessed(true);
            return resultDTO;
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosBlockFacadeServiceImpl.queryBlockDetail Exception. blockNumber:{},num:{}", blockNumber,num, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }
    
    
    
    
    

}
