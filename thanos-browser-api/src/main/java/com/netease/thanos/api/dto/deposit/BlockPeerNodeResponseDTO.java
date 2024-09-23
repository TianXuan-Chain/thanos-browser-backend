package com.netease.thanos.api.dto.deposit;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlockPeerNodeResponseDTO implements Serializable {
    /**
     * ip地址
     */
    private String ip;

    /**
     * 端口
     */
    private Integer rpcPort;
    /**
     * 块高
     */
    private Integer blockHeight;
    /**
     * 是否存活
     */
    private Boolean active;
    /**
     * 是否探活链接 部分接口外网ip不通，故不探活，active为false
     */
    private Boolean ifLink;
    /**
     * 第几个节点
     */
    private Integer nodeId;
    /**
     * 节点前缀信息 ,对应节点的 node.nodeid信息  用于确定挖矿节点信息
     */
    private String nodePrefix;
}
