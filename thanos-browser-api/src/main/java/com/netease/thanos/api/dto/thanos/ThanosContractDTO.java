package com.netease.thanos.api.dto.thanos;

import lombok.Data;

/**
 * 类 ThanosContractDTO.java 的实现描述: 合约DTO信息
 * Created by wangting04 on 2023/06/15
 */
@Data
public class ThanosContractDTO {
    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 合约协议，1:721 2:1155 -1:未指定
     */
    private Integer contractProtocol;

    /**
     * 合约名称
     */
    private String contractName;

    /**
     * 合约部署者区块链地址
     */
    private String contractDeployAddress;

    /**
     * 合约描述信息
     */
    private String contractDescription;

    /**
     * 计划发行数量
     */
    private int totalLimitSupply;

}
