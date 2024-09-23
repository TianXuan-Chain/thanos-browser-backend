package com.netease.thanos.web.form;

import lombok.Data;

import java.util.List;

@Data
public class QueryEvidenceChainListFrom {

    private List<QueryEvidenceChainForm> queryList;

    @Data
    public static class QueryEvidenceChainForm {
        private String contractAddress;
        private String objectId;
        private Integer partionKey;
    }

}
