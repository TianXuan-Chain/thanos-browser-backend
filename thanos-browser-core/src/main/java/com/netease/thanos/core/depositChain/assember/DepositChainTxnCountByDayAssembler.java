package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainTxnCountByDayDTO;
import com.netease.thanos.core.depositChain.bo.BcTxnCountByDayBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */
public class DepositChainTxnCountByDayAssembler {

    public static BcTxnCountByDayBO dto2Bo(DepositChainTxnCountByDayDTO source) {
        BcTxnCountByDayBO dest = new BcTxnCountByDayBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcTxnCountByDayBO> dtos2Bos(List<DepositChainTxnCountByDayDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcTxnCountByDayBO> result = new ArrayList<>();
        for (DepositChainTxnCountByDayDTO source : sources) {
            BcTxnCountByDayBO dest = new BcTxnCountByDayBO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    public static DepositChainTxnCountByDayDTO bo2Dto(BcTxnCountByDayBO source) {
        DepositChainTxnCountByDayDTO dest = new DepositChainTxnCountByDayDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<DepositChainTxnCountByDayDTO> bos2dtos(List<BcTxnCountByDayBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainTxnCountByDayDTO> result = new ArrayList<>();
        for (BcTxnCountByDayBO source : sources) {
            DepositChainTxnCountByDayDTO dest = new DepositChainTxnCountByDayDTO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }
}
