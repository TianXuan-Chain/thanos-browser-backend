package com.netease.thanos.web.form;

import lombok.Data;

import java.util.List;

@Data
public class QueryEvidencePointCorporationFrom {

    private List<QueryCorporationForm> queryList;

    @Data
    public static class QueryCorporationForm {
        private String contractAddress;
        private String serialNumber;
    }

}
