package com.netease.thanos.core.depositChain.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidencePointUserDTO;
import com.netease.thanos.core.depositChain.bo.QueryEvidencePointUserBO;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidencePointUserBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidencePointUserDTO.class,
            QueryEvidencePointUserBO.class, false);

    public static QueryEvidencePointUserBO userReqDto2Bo(QueryEvidencePointUserDTO evidenceChain) {
        QueryEvidencePointUserBO dto = new QueryEvidencePointUserBO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidencePointUserBO> userReqDto2Bo(List<QueryEvidencePointUserDTO> evidenceChain) {
        List<QueryEvidencePointUserBO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidencePointUserDTO ec : evidenceChain) {
            QueryEvidencePointUserBO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
