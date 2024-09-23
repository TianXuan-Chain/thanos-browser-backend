package com.netease.thanos.core.depositChain.service.facade.impl;

import com.netease.thanos.api.dto.thanos.ThanosBlockchainInfoDTO;
import com.netease.thanos.api.dto.thanos.ThanosChainDataDTO;
import com.netease.thanos.api.dto.thanos.ThanosTnxByDayDTO;
import com.netease.thanos.common.assembler.CommonAssembler;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.CommonResultDTO;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.assember.ThanosChainAssmbler;
import com.netease.thanos.core.depositChain.entity.ThanosBlockchaininfo;
import com.netease.thanos.core.depositChain.entity.ThanosChainDataBo;
import com.netease.thanos.core.depositChain.entity.ThanosGlobalSearchResponse;
import com.netease.thanos.core.depositChain.entity.ThanosTnxbyday;
import com.netease.thanos.core.depositChain.exception.ThanosChainBizException;
import com.netease.thanos.core.depositChain.service.biz.ThanosChainBizService;
import com.netease.thanos.core.depositChain.service.facade.ThanosChainFacadeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 类ThanosBlockFacadeServiceImpl.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 15:52
 */
@Service
@Slf4j
public class ThanosChainFacadeServiceImpl implements ThanosChainFacadeService {

    @Autowired
    private ThanosChainBizService thanosChainBizService;
   // @Autowired
   // private CommonTransactionBizService commonTransactionBizService;


    @Override
    public CommonResultDTO<Boolean> importBlockChainData(ThanosChainDataDTO chainDataDTO) {
        CommonResultDTO<Boolean> resultDTO = new CommonResultDTO<>();
        try {
            if (chainDataDTO == null) {
                log.warn("ThanosChainFacadeServiceImpl.importBlockChainData chainDataDTO is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            ThanosChainDataBo thanosChainDataBo = ThanosChainAssmbler.thanosChainDataDTO2Bo(chainDataDTO);
            Boolean res = thanosChainBizService.importBlockChainData(thanosChainDataBo);

            resultDTO.setSuccessed(true);
            resultDTO.setResult(res);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosChainFacadeServiceImpl.importBlockChainData Exception.", e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonResultDTO<Boolean> createTnxCountRecordForNewDay(Date pkDate) {
        CommonResultDTO<Boolean> resultDTO = new CommonResultDTO<>();
        try {
            if (pkDate == null) {
                log.warn("ThanosChainFacadeServiceImpl.createTnxCountRecordForNewDay chainDataDTO is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            Boolean res = thanosChainBizService.createTnxCountRecordForNewDay(pkDate);
            resultDTO.setSuccessed(true);
            resultDTO.setResult(res);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosChainFacadeServiceImpl.createTnxCountRecordForNewDay Exception.", e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonResultDTO<ThanosBlockchainInfoDTO> queryBlockChain() {
        CommonResultDTO<ThanosBlockchainInfoDTO> resultDTO = new CommonResultDTO<>();
        try {
            ThanosBlockchaininfo bo = thanosChainBizService.queryBlockChain();
            resultDTO.setSuccessed(true);
            resultDTO.setResult(ThanosChainAssmbler.thanosBlockchaininfoBo2DTO(bo));
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosChainFacadeServiceImpl.queryBlockChain Exception.", e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonResultDTO<List<ThanosTnxByDayDTO>> queryTnxCountBySize(Integer size) {
        CommonResultDTO<List<ThanosTnxByDayDTO>> resultDTO = new CommonResultDTO<>();
        try {
            if (size == null) {
                log.warn("ThanosChainFacadeServiceImpl.queryTnxCountBySize size is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            List<ThanosTnxbyday> boList = thanosChainBizService.queryTnxCountBySize(size);
            resultDTO.setSuccessed(true);
            resultDTO.setResult(ThanosChainAssmbler.thanosTnxByDayBo2DTOList(boList));
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosChainFacadeServiceImpl.queryTnxCountBySize Exception.", e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public ThanosGlobalSearchResponse globalSearch(CommonPageQuery<String> request) {
        ThanosGlobalSearchResponse response = new ThanosGlobalSearchResponse();
        CommonPageResult<Object> result = new CommonPageResult<>();
        try {
            if (request == null) {
                log.warn("ThanosChainFacadeServiceImpl.globalSearch request is null.");
                result.setSuccessed(false);
                result.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                response.setResult(result);
                return response;
            }
            response = thanosChainBizService.globalSearch(request);
        } catch (ThanosChainBizException e) {
            result.setSuccessed(false);
            result.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            result.setSuccessed(false);
            log.error("ThanosChainFacadeServiceImpl.globalSearch Exception. request:{}.", request, e);
            result.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
            response.setResult(result);
        }
        return response;
    }

}
