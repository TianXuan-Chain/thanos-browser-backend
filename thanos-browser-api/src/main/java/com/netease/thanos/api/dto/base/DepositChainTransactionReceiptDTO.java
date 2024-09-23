package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class DepositChainTransactionReceiptDTO implements Serializable {
    private Long id;
    private String pkHash;
    private String blockHash;
    private Integer blockNumber;
    private String contractAddress;
    private Long transactionIndex;
    private Long gasUsed;
    private Long cumulativeGasUsed;
    private String detailInfo;
    private String logs;
}
