package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidenceChainDTO;
import com.netease.thanos.core.depositChain.bo.QueryEvidenceChainBO;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidenceChainBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidenceChainDTO.class,
            QueryEvidenceChainBO.class, false);

    public static QueryEvidenceChainBO userReqDto2Bo(QueryEvidenceChainDTO evidenceChain) {
        QueryEvidenceChainBO dto = new QueryEvidenceChainBO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidenceChainBO> userReqDto2Bo(List<QueryEvidenceChainDTO> evidenceChain) {
        List<QueryEvidenceChainBO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidenceChainDTO ec : evidenceChain) {
            QueryEvidenceChainBO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
