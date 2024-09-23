package com.netease.thanos.web.form;

import lombok.Data;

import java.util.List;

@Data
public class QueryEvidencePointUserFrom {

    private List<QueryUserForm> queryList;

    @Data
    public static class QueryUserForm {
        private String contractAddress;
        private String serialNumber;
    }

}
