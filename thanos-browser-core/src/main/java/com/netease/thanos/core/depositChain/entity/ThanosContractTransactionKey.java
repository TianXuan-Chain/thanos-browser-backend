package com.netease.thanos.core.depositChain.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class ThanosContractTransactionKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Long id;

    /**
     * 合约地址
     */
    private String contractAddress;
}