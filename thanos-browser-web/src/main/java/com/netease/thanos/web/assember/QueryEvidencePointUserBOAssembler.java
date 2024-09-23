package com.netease.thanos.web.assember;

import com.netease.thanos.api.dto.deposit.QueryEvidencePointUserDTO;
import com.netease.thanos.web.form.QueryEvidencePointUserFrom;

import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryEvidencePointUserBOAssembler {

    private final static BeanCopier copier = BeanCopier.create(QueryEvidencePointUserFrom.QueryUserForm.class,
            QueryEvidencePointUserDTO.class, false);

    public static QueryEvidencePointUserDTO convert(QueryEvidencePointUserFrom.QueryUserForm evidenceChain) {
        QueryEvidencePointUserDTO dto = new QueryEvidencePointUserDTO();
        copier.copy(evidenceChain, dto, null);
        return dto;
    }

    public static List<QueryEvidencePointUserDTO> convertList(List<QueryEvidencePointUserFrom.QueryUserForm> evidenceChain) {
        List<QueryEvidencePointUserDTO> evidenceChainDTOList = new ArrayList<>();
        for (QueryEvidencePointUserFrom.QueryUserForm ec : evidenceChain) {
            QueryEvidencePointUserDTO chainDTO = convert(ec);
            evidenceChainDTOList.add(chainDTO);
        }
        return evidenceChainDTOList;
    }

}
