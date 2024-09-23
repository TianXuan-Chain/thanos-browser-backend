package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.base.DepositChainBlockChainDTO;
import com.netease.thanos.core.depositChain.bo.BcBlockChainBO;

import org.springframework.beans.BeanUtils;

/**
 * @Author kingkong create on 2018-08-28
 */

public class DepositChainBlockChainAssembler {

    public static BcBlockChainBO dto2Bo(DepositChainBlockChainDTO source) {
        BcBlockChainBO dest = new BcBlockChainBO();

        dest.setAvgTime(source.getAvgTime());
        dest.setId(source.getId());
        dest.setLastBlock(source.getLastBlock());
        dest.setPbftView(source.getPbftView());
        dest.setPendingTxn(source.getPendingTxn());
        dest.setTxn(source.getTxn());

        //BeanUtils.copyProperties(source, dest);
        return dest;
    }

    public static DepositChainBlockChainDTO bo2dto(BcBlockChainBO source) {
        DepositChainBlockChainDTO dest = new DepositChainBlockChainDTO();
        BeanUtils.copyProperties(source, dest);
        return dest;
    }
}
