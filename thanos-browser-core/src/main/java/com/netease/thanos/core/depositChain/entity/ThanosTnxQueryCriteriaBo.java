package com.netease.thanos.core.depositChain.entity;

import lombok.Data;

/**
 * 类ThanosTnxQueryCriteriaBo.java的实现描述：
 *
 * @author xuhao create on 2021/1/29 17:48
 */

@Data
public class ThanosTnxQueryCriteriaBo {
    /**
     * 区块高度
     */
    private Long blockNumber;

    /**
     * 区块链地址
     */
    private String bcAddress;
}
