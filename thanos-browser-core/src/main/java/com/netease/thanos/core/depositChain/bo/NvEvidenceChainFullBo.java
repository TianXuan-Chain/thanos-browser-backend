package com.netease.thanos.core.depositChain.bo;

import lombok.Data;

import java.util.List;

import com.netease.thanos.core.depositChain.entity.NvDepositEvidenceChain;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidenceChainUser;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidencePoint;

@Data
public class NvEvidenceChainFullBo {

    /**
     *
     */
    private NvDepositEvidenceChain evidenceChain;
    /**
     *
     */
    private List<NvDepositEvidenceChainUser> evidenceChainUsers;
    /**
     *
     */
    private List<NvDepositEvidencePoint> evidencePoints;

}
