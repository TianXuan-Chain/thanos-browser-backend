package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.NvDepositEvidencePointCorporationDTO;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidencePointCorporation;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public class NvDepositEvidencePointCorporationAssembler {

    private final static BeanCopier copier = BeanCopier.create(NvDepositEvidencePointCorporation.class,
            NvDepositEvidencePointCorporationDTO.class, false);

    public static NvDepositEvidencePointCorporationDTO bo2Dto(NvDepositEvidencePointCorporation evidenceChain) {
        NvDepositEvidencePointCorporationDTO dto = new NvDepositEvidencePointCorporationDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<NvDepositEvidencePointCorporationDTO> bo2DtoList(List<NvDepositEvidencePointCorporation> evidenceChain) {
        List<NvDepositEvidencePointCorporationDTO> evidenceChainDTOList = new ArrayList<>();
        for (NvDepositEvidencePointCorporation ec : evidenceChain) {
            NvDepositEvidencePointCorporationDTO chainDTO = bo2Dto(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
