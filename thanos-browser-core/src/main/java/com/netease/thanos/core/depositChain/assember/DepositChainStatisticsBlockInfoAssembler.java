package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainStatisticsBlockInfoDTO;
import com.netease.thanos.core.depositChain.bo.BcStatisticsBlockInfoBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */
public class DepositChainStatisticsBlockInfoAssembler {

    public static BcStatisticsBlockInfoBO dto2Bo(DepositChainStatisticsBlockInfoDTO source) {
        BcStatisticsBlockInfoBO dest = new BcStatisticsBlockInfoBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcStatisticsBlockInfoBO> dtos2Bos(List<DepositChainStatisticsBlockInfoDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcStatisticsBlockInfoBO> result = new ArrayList<>();
        for (DepositChainStatisticsBlockInfoDTO source : sources) {
            BcStatisticsBlockInfoBO dest = new BcStatisticsBlockInfoBO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    public static DepositChainStatisticsBlockInfoDTO dto2Bo(BcStatisticsBlockInfoBO source) {
        DepositChainStatisticsBlockInfoDTO dest = new DepositChainStatisticsBlockInfoDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<DepositChainStatisticsBlockInfoDTO> bos2dtos(List<BcStatisticsBlockInfoBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainStatisticsBlockInfoDTO> result = new ArrayList<>();
        for (BcStatisticsBlockInfoBO source : sources) {
            DepositChainStatisticsBlockInfoDTO dest = new DepositChainStatisticsBlockInfoDTO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }
}
