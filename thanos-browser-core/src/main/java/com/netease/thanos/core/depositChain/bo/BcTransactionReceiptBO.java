package com.netease.thanos.core.depositChain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author lyy create on 2018-05-11
 */
@Getter
@Setter
@ToString
public class BcTransactionReceiptBO {
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
