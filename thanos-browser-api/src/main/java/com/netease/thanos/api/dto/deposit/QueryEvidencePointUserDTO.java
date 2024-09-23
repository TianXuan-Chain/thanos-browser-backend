package com.netease.thanos.api.dto.deposit;

import lombok.Data;

@Data
public class QueryEvidencePointUserDTO {

    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 序列号
     */
    private String serialNumber;

}
