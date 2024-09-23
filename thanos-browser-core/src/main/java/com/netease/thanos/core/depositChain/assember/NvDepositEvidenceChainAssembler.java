package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.NvDepositEvidenceChainDTO;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidenceChain;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public class NvDepositEvidenceChainAssembler {

    private final static BeanCopier copier = BeanCopier.create(NvDepositEvidenceChain.class,
            NvDepositEvidenceChainDTO.class, false);

    public static NvDepositEvidenceChainDTO userReqDto2Bo(NvDepositEvidenceChain evidenceChain) {
        NvDepositEvidenceChainDTO dto = new NvDepositEvidenceChainDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<NvDepositEvidenceChainDTO> userReqDto2Bo(List<NvDepositEvidenceChain> evidenceChain) {
        List<NvDepositEvidenceChainDTO> evidenceChainDTOList = new ArrayList<>();
        for (NvDepositEvidenceChain ec : evidenceChain) {
            NvDepositEvidenceChainDTO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
