package com.netease.thanos.api.dto.thanos;

import lombok.Data;

/**
 * 类 ThanosContractTransactionDTO.java 的实现描述: 合约交易DTO
 * Created by wangting04 on 2023/06/15
 */
@Data
public class ThanosContractTransactionDTO {
    private Long id;

    /**
     * 合约地址
     */
    private String contractAddress;
    /**
     * 交易hash值
     */
    private String pkHash;

    /**
     * 交易时间Key
     */
    private Long partitionKey;

    /**
     * 交易详情
     */
    private String txDetail;
}
