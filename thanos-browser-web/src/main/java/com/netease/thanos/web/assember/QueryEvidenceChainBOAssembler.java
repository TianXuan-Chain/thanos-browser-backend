package com.netease.thanos.web.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidenceChainDTO;
import com.netease.thanos.web.form.QueryEvidenceChainListFrom;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidenceChainBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidenceChainListFrom.QueryEvidenceChainForm.class,
            QueryEvidenceChainDTO.class, false);

    public static QueryEvidenceChainDTO userReqDto2Bo(QueryEvidenceChainListFrom.QueryEvidenceChainForm evidenceChain) {
        QueryEvidenceChainDTO dto = new QueryEvidenceChainDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidenceChainDTO> userReqDto2Bo(List<QueryEvidenceChainListFrom.QueryEvidenceChainForm> evidenceChain) {
        List<QueryEvidenceChainDTO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidenceChainListFrom.QueryEvidenceChainForm ec : evidenceChain) {
            QueryEvidenceChainDTO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
