package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class ThanosEvmTransactionWithBLOBs extends ThanosEvmTransaction implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 被调用的函数的参数
     */
    private String params;

    /**
     * 交易调用字符串
     */
    private String inputText;

    /**
     * 交易dag执行状态
     */
    private String dagExecuteStatus;
}