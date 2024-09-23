package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainPeerNodeDTO;
import com.netease.thanos.core.depositChain.bo.BcPeerNodeBO;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */

public class DepositChainPeerNodeAssembler {

    public static BcPeerNodeBO dto2Bo(DepositChainPeerNodeDTO source) {
        BcPeerNodeBO dest = new BcPeerNodeBO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<BcPeerNodeBO> dtos2Bos(List<DepositChainPeerNodeDTO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<BcPeerNodeBO> result = new ArrayList<>();
        for (DepositChainPeerNodeDTO source : sources) {
            BcPeerNodeBO dest = new BcPeerNodeBO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }

    public static DepositChainPeerNodeDTO bo2dto(BcPeerNodeBO source) {
        DepositChainPeerNodeDTO dest = new DepositChainPeerNodeDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static List<DepositChainPeerNodeDTO> bos2dtos(List<BcPeerNodeBO> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.EMPTY_LIST;
        }

        List<DepositChainPeerNodeDTO> result = new ArrayList<>();
        for (BcPeerNodeBO source : sources) {
            DepositChainPeerNodeDTO dest = new DepositChainPeerNodeDTO();
            BeanUtils.copyProperties(source, dest);
            result.add(dest);
        }
        return result;
    }
}
