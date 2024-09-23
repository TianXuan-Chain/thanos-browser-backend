package com.netease.thanos.web.controller.thanos;


import com.netease.thanos.api.dto.thanos.*;
import com.netease.thanos.common.dto.CommonPageQuery;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.common.dto.CommonResultDTO;
import com.netease.thanos.core.depositChain.domain.ThanosChainDomain;
import com.netease.thanos.core.depositChain.entity.ThanosGlobalSearchResponse;
import com.netease.thanos.report.utils.StrUtil;
import com.netease.thanos.web.assember.BlockControllerAssmbler;
import com.netease.thanos.web.form.*;
import com.netease.thanos.web.util.ResponseCodeEnum;
import com.netease.thanos.web.vo.CommonPageVo;
import com.netease.thanos.web.vo.GlobalSearchVo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Slf4j
@Controller
@RequestMapping(value = "/browser/thanos/block")
public class ThanosBlockController {

    @Autowired
    private ThanosChainDomain thanosChainDomain;


    //http://localhost:8888/block/queryBlockHeight
    @RequestMapping(value = "/queryBlockHeight", method = RequestMethod.POST)
    @ResponseBody
    public Object queryBlockHeight() {
        try {
            CommonResultDTO<Long> resultDTO = thanosChainDomain.getThanosBlockFacadeService().queryMaxBlockHeight();
            if (!resultDTO.isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
            }
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, resultDTO.getResult());
        } catch (Exception e) {
            log.error("ThanosBlockController queryBlockHeight error!.", e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }

    //http://localhost:8888/block/queryBlockChain
    @RequestMapping(value = "/queryBlockChain", method = RequestMethod.POST)
    @ResponseBody
    public Object queryBlockChain() {
        try {
            CommonResultDTO<ThanosBlockchainInfoDTO> resultDTO = thanosChainDomain.getThanosChainFacadeService().queryBlockChain();
            if (!resultDTO.isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
            }
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, resultDTO.getResult());
        } catch (Exception e) {
            log.error("ThanosBlockController queryBlockChain error!.", e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }


    //http://localhost:8888/block/queryTxnCountBy?size=7
    @RequestMapping(value = "/queryTxnCount", method = RequestMethod.POST)
    @ResponseBody
    public Object queryTxnCount(@RequestBody TxnCountForm form) {
        try {
            if (form == null) {
                log.warn("ThanosBlockController queryTxnCountBy form is null.");
                return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
            }
            CommonResultDTO<List<ThanosTnxByDayDTO>> resultDTO = thanosChainDomain.getThanosChainFacadeService().queryTnxCountBySize(form.getSize());
            if (!resultDTO.isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
            }
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, resultDTO.getResult());
        } catch (Exception e) {
            log.error("ThanosBlockController queryTxnCount error!. form:{}.", form, e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }

    @RequestMapping(value = "/queryBlocks", method = RequestMethod.POST)
    @ResponseBody
    public Object queryBlocks(@RequestBody PageQueryForm form) {
        try {
            if (form == null) {
                log.warn("ThanosBlockController queryBlocks form is null.");
                return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
            }
            CommonPageQuery<Void> request = BlockControllerAssmbler.pageQueryForm2CommonPageQuery(null, form);
            CommonPageResult<ThanosBlockDTO> resultDTO = thanosChainDomain.getThanosBlockFacadeService().pageQueryBlocks(request);
            if (!resultDTO.isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
            }
            CommonPageVo<ThanosBlockDTO> vo = BlockControllerAssmbler.commonPageDTO2Vo(resultDTO);
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, vo);
        } catch (Exception e) {
            log.error("ThanosBlockController queryBlocks error!. form:{}.", form, e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }

    }

    @RequestMapping(value = "/queryBlockDetail", method = RequestMethod.POST)
    @ResponseBody
    public Object queryBlockDetail(@RequestBody BlockDetailForm form) {
        try {
            if (form == null) {
                log.warn("ThanosBlockController queryBlockDetail form is null.");
                return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
            }
            CommonResultDTO<ThanosBlockDTO> resultDTO = thanosChainDomain.getThanosBlockFacadeService().queryBlockDetail(form.getPkHash());
            if (!resultDTO.isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
            }
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, resultDTO.getResult());
        } catch (Exception e) {
            log.error("ThanosBlockController queryBlockDetail error!. form:{}.", form, e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }

    @RequestMapping(value = "/queryTransactions", method = RequestMethod.POST)
    @ResponseBody
    public Object queryTransactions(@RequestBody TransactionPageQueryForm form) {
        try {
            if (form == null) {
                log.warn("ThanosBlockController queryTransactions form is null.");
                return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
            }
            if (!StringUtils.isBlank(form.getContractAddress() )){
                CommonPageQuery<String> request = BlockControllerAssmbler.pageQueryForm2CommonPageQuery(form.getContractAddress(), form);
                CommonPageResult<ThanosEvmTransactionDTO> resultDTO = thanosChainDomain.getThanosTransactionFacadeService().pageQueryTnxsByContractAddress(request);
                if (!resultDTO.isSuccessed()) {
                    return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
                }
                CommonPageVo<ThanosEvmTransactionDTO> vo = BlockControllerAssmbler.commonPageDTO2Vo(resultDTO);
                return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, vo);
            }else{
                CommonPageQuery<Long> request = BlockControllerAssmbler.pageQueryForm2CommonPageQuery(form.getBlockNumber(), form);
                CommonPageResult<ThanosEvmTransactionDTO> resultDTO = thanosChainDomain.getThanosTransactionFacadeService().pageQueryTnxsByBlockNumber(request);
                if (!resultDTO.isSuccessed()) {
                    return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
                }
                CommonPageVo<ThanosEvmTransactionDTO> vo = BlockControllerAssmbler.commonPageDTO2Vo(resultDTO);
                return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, vo);
            }

        } catch (Exception e) {
            log.error("ThanosBlockController queryTransactions error!. form:{}.", form, e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }

    @RequestMapping(value = "/queryTransactionDetail", method = RequestMethod.POST)
    @ResponseBody
    public Object queryTransactionDetail(@RequestBody TransactionDetailForm form) {
        try {
            if (form == null) {
                log.warn("ThanosBlockController queryTransactionDetail pkHash is null.");
                return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
            }
            CommonResultDTO<ThanosEvmTransactionDTO> resultDTO = thanosChainDomain.getThanosTransactionFacadeService().queryTransactionDetailWithConvert(form.getPkHash(), form.getBlockTimestamp());
            if (!resultDTO.isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
            }
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, resultDTO.getResult());
        } catch (Exception e) {
            log.error("ThanosBlockController queryTransactionDetail error!. form:{}.", form, e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }

    @RequestMapping(value = "/globalSearch", method = RequestMethod.POST)
    @ResponseBody
    public Object globalSearch(@RequestBody ThanosGlobalSearchForm form) {
        try {
            if (form == null) {
                log.warn("ThanosBlockController globalSearch form is null.");
                return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
            }
            form.setSearch(StrUtil.strTrim(form.getSearch()));
            CommonPageQuery<String> request = BlockControllerAssmbler.pageQueryForm2CommonPageQuery(form.getSearch(), form);
            ThanosGlobalSearchResponse response = thanosChainDomain.getThanosChainFacadeService().globalSearch(request);
            if (response == null) {
                log.warn("ThanosBlockController globalSearch error!. response is null. form:{}", form);
                return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
            }
            if (!response.getResult().isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(response.getResult().getErrorCode().getCode(), response.getResult().getErrorCode().getDesc());
            }
            GlobalSearchVo vo = BlockControllerAssmbler.globalSearchDTO2Vo(response);
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, vo);
        } catch (Exception e) {
            log.error("ThanosBlockController queryTransactions error!. form:{}.", form, e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }

    /**
     * 查询合约信息
     *
     * @param form
     * @return
     */
    @RequestMapping(value = "/queryContract", method = RequestMethod.POST)
    @ResponseBody
    public Object queryContract(@RequestBody ContractDetailForm form) {
        try {
            if (form == null) {
                log.warn("ThanosBlockController queryContract form is null.");
                return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
            }
            CommonResultDTO<ThanosContractDTO> resultDTO = thanosChainDomain.getThanosTransactionFacadeService().queryContract(form.getContractAddress());
            if (!resultDTO.isSuccessed()) {
                return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(), resultDTO.getErrorCode().getDesc());
            }
            return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, resultDTO.getResult());
        } catch (Exception e) {
            log.error("ThanosBlockController queryContract error!. form:{}.", form, e);
            return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
        }
    }

}
