package com.netease.thanos.core.depositChain.service.facade.impl;

import com.netease.thanos.api.dto.thanos.ThanosContractDTO;
import com.netease.thanos.api.dto.thanos.ThanosContractTransactionDTO;
import com.netease.thanos.api.dto.thanos.ThanosEvmTransactionDTO;
import com.netease.thanos.common.assembler.CommonAssembler;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.CommonResultDTO;
import com.netease.thanos.common.dto.ThanosErrorCodeDTO;
import com.netease.thanos.core.depositChain.assember.CommonPageAssmbler;
import com.netease.thanos.core.depositChain.assember.ThanosChainAssmbler;
import com.netease.thanos.core.depositChain.entity.ThanosContract;
import com.netease.thanos.core.depositChain.entity.ThanosContractTransaction;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransaction;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransactionWithBLOBs;
import com.netease.thanos.core.depositChain.exception.ThanosChainBizException;
import com.netease.thanos.core.depositChain.service.biz.ThanosTransactionBizService;
import com.netease.thanos.core.depositChain.service.facade.ThanosTransactionFacadeService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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
public class ThanosTransactionFacadeServiceImpl implements ThanosTransactionFacadeService {

    @Autowired
    private ThanosTransactionBizService thanosTransactionBizService;


    @Override
    public CommonResultDTO<ThanosEvmTransactionDTO> queryTransactionDetail(String hash, Date blockTimestamp) {
        CommonResultDTO<ThanosEvmTransactionDTO> resultDTO = new CommonResultDTO<>();
        try {
            if (StringUtils.isBlank(hash)) {
                log.warn("ThanosTransactionFacadeServiceImpl.queryTransactionDetail hash is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            ThanosEvmTransactionWithBLOBs bo = thanosTransactionBizService.queryTransactionDetail(hash, blockTimestamp);
            resultDTO.setSuccessed(true);
            resultDTO.setResult(ThanosChainAssmbler.thanosEvmTransactionWithBLOBs2DTO(bo));
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosTransactionFacadeServiceImpl.queryTransactionDetail Exception. hash:{}.", hash, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonResultDTO<ThanosEvmTransactionDTO> queryTransactionDetailWithConvert(String hash, Date blockTimestamp) {
        CommonResultDTO<ThanosEvmTransactionDTO> resultDTO = new CommonResultDTO<>();
        try {
            if (StringUtils.isBlank(hash)) {
                log.warn("ThanosTransactionFacadeServiceImpl.queryTransactionDetailWithConvert hash is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            ThanosEvmTransactionWithBLOBs bo = thanosTransactionBizService.queryTransactionDetailWithConvert(hash, blockTimestamp);
            resultDTO.setSuccessed(true);
            resultDTO.setResult(ThanosChainAssmbler.thanosEvmTransactionWithBLOBs2DTO(bo));
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosTransactionFacadeServiceImpl.queryTransactionDetailWithConvert Exception. hash:{}.", hash, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonPageResult<ThanosEvmTransactionDTO> pageQueryTnxsByBlockNumber(CommonPageQuery<Long> request) {
        CommonPageResult<ThanosEvmTransactionDTO> resultDTO = new CommonPageResult<>();
        try {
            if (request == null) {
                log.warn("ThanosTransactionFacadeServiceImpl.pageQueryTnxsByBlockNumber request is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            CommonPageResult<ThanosEvmTransaction> bo = thanosTransactionBizService.pageQueryTnxsByBlockNumber(request);
            resultDTO = CommonPageAssmbler.thanosTnxCommonPageResultBo2DTO(bo);
            resultDTO.setSuccessed(true);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosTransactionFacadeServiceImpl.pageQueryTnxsByBlockNumber Exception. request:{}.", request, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonResultDTO<List<ThanosContractTransactionDTO>> queryLastContractTxByContractAddressAndOffset(String contractAddress, Integer fromOffset) {
        CommonResultDTO<List<ThanosContractTransactionDTO>> resultDTO = new CommonResultDTO<>();
        try {
            if (StringUtils.isBlank(contractAddress) || fromOffset == null) {
                log.warn("ThanosTransactionFacadeServiceImpl.queryLastContractTxByContractAddressAndOffset request is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            List<ThanosContractTransaction> list = thanosTransactionBizService.queryLastContractTxByContractAddressAndOffset(contractAddress, fromOffset);
            List<ThanosContractTransactionDTO> transactionDTOS = ThanosChainAssmbler.thanosContractTransactionBo2DTO(list);
            resultDTO.setResult(transactionDTOS);
            resultDTO.setSuccessed(true);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosTransactionFacadeServiceImpl.queryLastContractTxByContractAddressAndOffset Exception. contractAddress:{}, fromOffset:{}.", contractAddress, fromOffset, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonResultDTO<ThanosContractDTO> queryContract(String contractAddress) {
        CommonResultDTO<ThanosContractDTO> resultDTO = new CommonResultDTO<>();
        try {
            if (StringUtils.isBlank(contractAddress)) {
                log.warn("ThanosTransactionFacadeServiceImpl.queryContract request is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            ThanosContract thanosContract = thanosTransactionBizService.queryContract(contractAddress);
            resultDTO.setResult(ThanosChainAssmbler.thanosContract2Dto(thanosContract));
            resultDTO.setSuccessed(true);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosTransactionFacadeServiceImpl.queryContract Exception. contractAddress:{}.", contractAddress, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

    @Override
    public CommonPageResult<ThanosEvmTransactionDTO> pageQueryTnxsByContractAddress(CommonPageQuery<String> request) {
        CommonPageResult<ThanosEvmTransactionDTO> resultDTO = new CommonPageResult<>();
        try {
            if (request == null) {
                log.warn("ThanosTransactionFacadeServiceImpl.pageQueryTnxsByContractAddress request is null.");
                resultDTO.setSuccessed(false);
                resultDTO.setErrorCode(ThanosErrorCodeDTO.MISS_NEEDED_PARA);
                return resultDTO;
            }
            CommonPageResult<ThanosEvmTransaction> bo = thanosTransactionBizService.pageQueryTnxsByContractAddress(request);
            resultDTO = CommonPageAssmbler.thanosTnxCommonPageResultBo2DTO(bo);
            resultDTO.setSuccessed(true);
        } catch (ThanosChainBizException e) {
            resultDTO.setSuccessed(false);
            resultDTO.setErrorCode(CommonAssembler.errorCode2DTO(e.getRetCode()));
        } catch (Exception e) {
            resultDTO.setSuccessed(false);
            log.error("ThanosTransactionFacadeServiceImpl.pageQueryTnxsByContractAddress Exception. request:{}.", request, e);
            resultDTO.setErrorCode(ThanosErrorCodeDTO.SYSTEM_ERROR);
        }
        return resultDTO;
    }

}
