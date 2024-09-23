package com.netease.thanos.web.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidencePointCorporationDTO;
import com.netease.thanos.web.form.QueryEvidencePointCorporationFrom;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidencePointCorporationBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidencePointCorporationFrom.QueryCorporationForm.class,
            QueryEvidencePointCorporationDTO.class, false);

    public static QueryEvidencePointCorporationDTO userReqDto2Bo(QueryEvidencePointCorporationFrom.QueryCorporationForm evidenceChain) {
        QueryEvidencePointCorporationDTO dto = new QueryEvidencePointCorporationDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidencePointCorporationDTO> userReqDto2Bo(List<QueryEvidencePointCorporationFrom.QueryCorporationForm> evidenceChain) {
        List<QueryEvidencePointCorporationDTO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidencePointCorporationFrom.QueryCorporationForm ec : evidenceChain) {
            QueryEvidencePointCorporationDTO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
