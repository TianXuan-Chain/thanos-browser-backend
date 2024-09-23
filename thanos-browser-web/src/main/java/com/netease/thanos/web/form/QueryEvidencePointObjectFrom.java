package com.netease.thanos.web.form;

import lombok.Data;

import java.util.List;

@Data
public class QueryEvidencePointObjectFrom {

    private List<QueryObjectForm> queryList;

    @Data
    public static class QueryObjectForm {
        private String contractAddress;
        private String serialNumber;
    }

}
