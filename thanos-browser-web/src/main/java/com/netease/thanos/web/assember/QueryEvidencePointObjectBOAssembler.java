package com.netease.thanos.web.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidencePointObjectDTO;
import com.netease.thanos.web.form.QueryEvidencePointObjectFrom;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidencePointObjectBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidencePointObjectFrom.QueryObjectForm.class,
            QueryEvidencePointObjectDTO.class, false);

    public static QueryEvidencePointObjectDTO userReqDto2Bo(QueryEvidencePointObjectFrom.QueryObjectForm evidenceChain) {
        QueryEvidencePointObjectDTO dto = new QueryEvidencePointObjectDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidencePointObjectDTO> userReqDto2Bo(List<QueryEvidencePointObjectFrom.QueryObjectForm> evidenceChain) {
        List<QueryEvidencePointObjectDTO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidencePointObjectFrom.QueryObjectForm ec : evidenceChain) {
            QueryEvidencePointObjectDTO chainDTO = userReqDto2Bo(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
