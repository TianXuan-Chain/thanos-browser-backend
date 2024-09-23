package com.netease.thanos.web.controller.thanos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.thanos.api.dto.thanos.ThanosBlockDTO;
import com.netease.thanos.common.dto.CommonResultDTO;
import com.netease.thanos.core.depositChain.domain.ThanosChainDomain;
import com.netease.thanos.web.form.BlockQueryForm;
import com.netease.thanos.web.util.ResponseCodeEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "api/browser/")
public class BlockChainExternalServiceController {
 
	@Autowired
	private ThanosChainDomain thanosChainDomain;
 
	@RequestMapping(value = "queryBlocks", method = RequestMethod.POST)
	@ResponseBody
	public Object queryBlocks(@RequestBody BlockQueryForm form) {
		try {
			if (form == null) {
				log.warn("ThanosBlockController queryBlocks form is null.");
				return WebResponseUtils.response(ResponseCodeEnum.PARAMETER_ERROR);
			}
			CommonResultDTO<List<ThanosBlockDTO>> resultDTO = thanosChainDomain.getThanosBlockFacadeService()
					.queryBlocks(form.getBlockNumber(), form.getLimitNum());
			if (!resultDTO.isSuccessed()) {
				return WebResponseUtils.responseWithErrorData(resultDTO.getErrorCode().getCode(),
						resultDTO.getErrorCode().getDesc());
			}
			return WebResponseUtils.responseWithData(ResponseCodeEnum.OK, resultDTO.getResult());
		} catch (Exception e) {
			log.error("ThanosBlockController queryBlocks error!. form:{}.", e, form);
			return WebResponseUtils.response(ResponseCodeEnum.COMMON_ERROR);
		}

	}

}
