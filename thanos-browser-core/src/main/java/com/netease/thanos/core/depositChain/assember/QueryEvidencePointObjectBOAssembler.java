package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidencePointObjectDTO;
import com.netease.thanos.core.depositChain.bo.QueryEvidencePointObjectBO;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidencePointObjectBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidencePointObjectDTO.class,
            QueryEvidencePointObjectBO.class, false);

    public static QueryEvidencePointObjectBO userReqDto2Bo(QueryEvidencePointObjectDTO evidenceChain) {
        QueryEvidencePointObjectBO dto = new QueryEvidencePointObjectBO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidencePointObjectBO> userReqDto2Bo(List<QueryEvidencePointObjectDTO> evidenceChain) {
        List<QueryEvidencePointObjectBO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidencePointObjectDTO ec : evidenceChain) {
            QueryEvidencePointObjectBO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
