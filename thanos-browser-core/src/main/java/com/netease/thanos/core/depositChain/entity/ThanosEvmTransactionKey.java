package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class ThanosEvmTransactionKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    private Long partitionKey;
}