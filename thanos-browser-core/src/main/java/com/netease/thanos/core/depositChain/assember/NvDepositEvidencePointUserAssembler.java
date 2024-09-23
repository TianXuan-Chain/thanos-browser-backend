package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.NvDepositEvidencePointUserDTO;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidencePointUser;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public class NvDepositEvidencePointUserAssembler {

    private final static BeanCopier copier = BeanCopier.create(NvDepositEvidencePointUser.class,
            NvDepositEvidencePointUserDTO.class, false);

    public static NvDepositEvidencePointUserDTO userReqDto2Bo(NvDepositEvidencePointUser evidenceChain) {
        NvDepositEvidencePointUserDTO dto = new NvDepositEvidencePointUserDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<NvDepositEvidencePointUserDTO> userReqDto2Bo(List<NvDepositEvidencePointUser> evidenceChain) {
        List<NvDepositEvidencePointUserDTO> evidenceChainDTOList = new ArrayList<>();
        for (NvDepositEvidencePointUser ec : evidenceChain) {
            NvDepositEvidencePointUserDTO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
