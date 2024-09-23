package com.netease.thanos.core.depositChain.bo;

import lombok.Data;

@Data
public class QueryEvidenceChainBO {

    /**
     *
     */
    private String contractAddress;

    /**
     *
     */
    private String objectId;

    /**
     *
     */
    private Integer partionKey;

}
