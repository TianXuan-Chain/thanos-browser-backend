package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainSingleStatisticsInfoDTO;
import com.netease.thanos.core.depositChain.bo.BcSingleStatisticsInfoBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */
public class DepositChainSingleStatisticsInfoAssembler {

    public static BcSingleStatisticsInfoBO dto2Bo(DepositChainSingleStatisticsInfoDTO source) {
        BcSingleStatisticsInfoBO dest = new BcSingleStatisticsInfoBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcSingleStatisticsInfoBO> dtos2Bos(List<DepositChainSingleStatisticsInfoDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcSingleStatisticsInfoBO> result = new ArrayList<>();
        for (DepositChainSingleStatisticsInfoDTO source : sources) {
            BcSingleStatisticsInfoBO dest = new BcSingleStatisticsInfoBO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    public static DepositChainSingleStatisticsInfoDTO dto2Bo(BcSingleStatisticsInfoBO source) {
        DepositChainSingleStatisticsInfoDTO dest = new DepositChainSingleStatisticsInfoDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<DepositChainSingleStatisticsInfoDTO> bos2dtos(List<BcSingleStatisticsInfoBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainSingleStatisticsInfoDTO> result = new ArrayList<>();
        for (BcSingleStatisticsInfoBO source : sources) {
            DepositChainSingleStatisticsInfoDTO dest = new DepositChainSingleStatisticsInfoDTO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }
}
