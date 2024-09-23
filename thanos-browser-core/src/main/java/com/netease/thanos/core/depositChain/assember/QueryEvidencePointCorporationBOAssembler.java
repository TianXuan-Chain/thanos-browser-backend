package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidencePointCorporationDTO;
import com.netease.thanos.core.depositChain.bo.QueryEvidencePointCorporationBO;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidencePointCorporationBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidencePointCorporationDTO.class,
            QueryEvidencePointCorporationBO.class, false);

    public static QueryEvidencePointCorporationBO userReqDto2Bo(QueryEvidencePointCorporationDTO evidenceChain) {
        QueryEvidencePointCorporationBO dto = new QueryEvidencePointCorporationBO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidencePointCorporationBO> userReqDto2Bo(List<QueryEvidencePointCorporationDTO> evidenceChain) {
        List<QueryEvidencePointCorporationBO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidencePointCorporationDTO ec : evidenceChain) {
            QueryEvidencePointCorporationBO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
