package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainStatisticsTransactionInfoDTO;
import com.netease.thanos.core.depositChain.bo.BcStatisticsTransactionInfoBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */
public class DepositChainStatisticsTransactionInfoAssembler {

    public static BcStatisticsTransactionInfoBO dto2Bo(DepositChainStatisticsTransactionInfoDTO source) {
        BcStatisticsTransactionInfoBO dest = new BcStatisticsTransactionInfoBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcStatisticsTransactionInfoBO> dtos2Bos(List<DepositChainStatisticsTransactionInfoDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcStatisticsTransactionInfoBO> result = new ArrayList<>();
        for (DepositChainStatisticsTransactionInfoDTO source : sources) {
            BcStatisticsTransactionInfoBO dest = new BcStatisticsTransactionInfoBO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    public static DepositChainStatisticsTransactionInfoDTO dto2Bo(BcStatisticsTransactionInfoBO source) {
        DepositChainStatisticsTransactionInfoDTO dest = new DepositChainStatisticsTransactionInfoDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<DepositChainStatisticsTransactionInfoDTO> bos2dtos(List<BcStatisticsTransactionInfoBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainStatisticsTransactionInfoDTO> result = new ArrayList<>();
        for (BcStatisticsTransactionInfoBO source : sources) {
            DepositChainStatisticsTransactionInfoDTO dest = new DepositChainStatisticsTransactionInfoDTO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }
}
