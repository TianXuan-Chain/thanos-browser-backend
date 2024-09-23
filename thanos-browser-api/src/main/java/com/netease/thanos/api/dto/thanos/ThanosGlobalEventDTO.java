package com.netease.thanos.api.dto.thanos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ThanosGlobalEventDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 事件hash值
     */
    private String eventHash;

    /**
     * 块hash值
     */
    private String blockHash;

    /**
     * 块高
     */
    private Long blockNumber;

    /**
     * 事件发起者
     */
    private String senderAddress;

    /**
     * nonce值
     */
    private String nonce;

    /**
     * 事件类型码： 0-注册 1-退出
     */
    private Integer commandCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 事件数据（未解析）
     */
    private String rawData;

}
