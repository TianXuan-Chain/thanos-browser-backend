package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class ThanosEvmTransactionreceiptWithBLOBs extends ThanosEvmTransactionreceipt implements Serializable {
    private static final long serialVersionUID = 1L;

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