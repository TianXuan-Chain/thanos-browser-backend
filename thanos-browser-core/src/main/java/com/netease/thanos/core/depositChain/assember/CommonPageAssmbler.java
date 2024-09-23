package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.thanos.ThanosBlockDTO;
import com.netease.thanos.api.dto.thanos.ThanosEvmTransactionDTO;
import com.netease.thanos.common.dto.CommonPageResult;
import com.netease.thanos.core.depositChain.entity.ThanosBlock;
import com.netease.thanos.core.depositChain.entity.ThanosEvmTransaction;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类CommonPageAssmbler.java的实现描述：
 *
 * @author xuhao create on 2021/1/29 17:23
 */

public class CommonPageAssmbler {
    public static CommonPageResult<ThanosBlockDTO> thanosBlockCommonPageResultBo2DTO(CommonPageResult<ThanosBlock> bo) {
        if (bo == null) {
            return null;
        }
        CommonPageResult<ThanosBlockDTO> dto = new CommonPageResult<>();
        dto.setPageTotal(bo.getPageTotal());
        dto.setTotalCount(bo.getTotalCount());
        dto.setPageSize(bo.getPageSize());
        dto.setResult(thanosBlockBo2DTOList(bo.getResult()));
        return dto;
    }

    public static List<ThanosBlockDTO> thanosBlockBo2DTOList(List<ThanosBlock> bos) {
        List<ThanosBlockDTO> dtos = new ArrayList<>();
        if (CollectionUtils.isEmpty(bos)) {
            return dtos;
        }
        for (ThanosBlock bo : bos) {
            ThanosBlockDTO dto = ThanosChainAssmbler.thanosBlockBo2DTO(bo);
            dtos.add(dto);
        }
        return dtos;
    }

    public static CommonPageResult<ThanosEvmTransactionDTO> thanosTnxCommonPageResultBo2DTO(CommonPageResult<ThanosEvmTransaction> bo) {
        if (bo == null) {
            return null;
        }
        CommonPageResult<ThanosEvmTransactionDTO> dto = new CommonPageResult<>();
        dto.setPageTotal(bo.getPageTotal());
        dto.setTotalCount(bo.getTotalCount());
        dto.setPageSize(bo.getPageSize());
        dto.setResult(thanosEvmTnxBo2DTOList(bo.getResult()));
        return dto;
    }

    public static List<ThanosEvmTransactionDTO> thanosEvmTnxBo2DTOList(List<ThanosEvmTransaction> bos) {
        List<ThanosEvmTransactionDTO> dtos = new ArrayList<>();
        if (CollectionUtils.isEmpty(bos)) {
            return dtos;
        }
        for (ThanosEvmTransaction bo : bos) {
            ThanosEvmTransactionDTO dto = ThanosChainAssmbler.thanosEvmTransactionBo2DTO(bo);
            dtos.add(dto);
        }
        return dtos;
    }
}
