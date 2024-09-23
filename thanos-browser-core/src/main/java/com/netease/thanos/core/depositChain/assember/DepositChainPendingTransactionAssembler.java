package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainPendingTransactionDTO;
import com.netease.thanos.core.depositChain.bo.BcPendingTransactionBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */
public class DepositChainPendingTransactionAssembler {

    public static BcPendingTransactionBO dto2Bo(DepositChainPendingTransactionDTO source) {
        BcPendingTransactionBO dest = new BcPendingTransactionBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcPendingTransactionBO> dtos2Bos(List<DepositChainPendingTransactionDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcPendingTransactionBO> result = new ArrayList<>();
        for (DepositChainPendingTransactionDTO source : sources) {
            BcPendingTransactionBO dest = new BcPendingTransactionBO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    public static DepositChainPendingTransactionDTO dto2Bo(BcPendingTransactionBO source) {
        DepositChainPendingTransactionDTO dest = new DepositChainPendingTransactionDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<DepositChainPendingTransactionDTO> bos2dtos(List<BcPendingTransactionBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainPendingTransactionDTO> result = new ArrayList<>();
        for (BcPendingTransactionBO source : sources) {
            DepositChainPendingTransactionDTO dest = new DepositChainPendingTransactionDTO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }
}
