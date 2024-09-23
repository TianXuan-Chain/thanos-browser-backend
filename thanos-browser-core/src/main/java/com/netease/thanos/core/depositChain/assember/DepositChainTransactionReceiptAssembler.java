package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainTransactionReceiptDTO;
import com.netease.thanos.core.depositChain.bo.BcTransactionReceiptBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */
public class DepositChainTransactionReceiptAssembler {


    public static BcTransactionReceiptBO bo2Dto(DepositChainTransactionReceiptDTO source) {
        BcTransactionReceiptBO dest = new BcTransactionReceiptBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcTransactionReceiptBO> dtos2Bos(List<DepositChainTransactionReceiptDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcTransactionReceiptBO> result = new ArrayList<>();
        for (DepositChainTransactionReceiptDTO source : sources) {
            BcTransactionReceiptBO dest = new BcTransactionReceiptBO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    public static DepositChainTransactionReceiptDTO bo2Dto(BcTransactionReceiptBO source) {
        DepositChainTransactionReceiptDTO dest = new DepositChainTransactionReceiptDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<DepositChainTransactionReceiptDTO> bos2dtos(List<BcTransactionReceiptBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainTransactionReceiptDTO> result = new ArrayList<>();
        for (BcTransactionReceiptBO source : sources) {
            DepositChainTransactionReceiptDTO dest = new DepositChainTransactionReceiptDTO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }
}
