package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.NvDepositEvidencePointObjectDTO;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidencePointObject;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public class NvDepositEvidencePointObjectAssembler {

    private final static BeanCopier copier = BeanCopier.create(NvDepositEvidencePointObject.class,
            NvDepositEvidencePointObjectDTO.class, false);

    public static NvDepositEvidencePointObjectDTO userReqDto2Bo(NvDepositEvidencePointObject evidenceChain) {
        NvDepositEvidencePointObjectDTO dto = new NvDepositEvidencePointObjectDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<NvDepositEvidencePointObjectDTO> userReqDto2Bo(List<NvDepositEvidencePointObject> evidenceChain) {
        List<NvDepositEvidencePointObjectDTO> evidenceChainDTOList = new ArrayList<>();
        for (NvDepositEvidencePointObject ec : evidenceChain) {
            NvDepositEvidencePointObjectDTO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
