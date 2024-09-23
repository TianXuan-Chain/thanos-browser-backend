package com.netease.thanos.api.dto.deposit;

import lombok.Data;

@Data
public class QueryEvidenceChainDTO {

    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 对象ID
     */
    private String objectId;

    /**
     * 时间分区
     */
    private Integer partionKey;

}
