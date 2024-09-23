package com.netease.thanos.api.dto.thanos;

import lombok.Data;

import java.io.Serializable;


@Data
public class ThanosEvmTransactionReceiptDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 交易hash值
     */
    private String transactionHash;

    /**
     * 块hash值
     */
    private String blockHash;

    /**
     * 块高
     */
    private Long blockNumber;

    /**
     * 交易顺序
     */
    private Long transactionIndex;

    /**
     * 已用gas
     */
    private Long gasUsed;

    /**
     * logs信息
     */
    private String logs;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 执行结果，16进制字符串
     */
    private String executionResult;

    /**
     * rpc查询结果的所有数据
     */
    private String detailInfo;
}
