package com.netease.thanos.core.depositChain.constant;

/**
 * 类 ContractProtocolEnum.java 的实现描述: nft协议枚举
 * <p>
 * 合约类型， 721默认基础合约：Default-721；1155默认基础合约：Default-1155，所有权使用权合约：OwnAndUse
 * Created by wangting04 on 2022/03/14
 */
public enum ContractProtocolEnum {
    NFT721(1, "721"),
    NFT1155(2, "1155"),
    NO(-1, "未指定"),
    ;

    private Integer protocolType;
    private String desc;

    ContractProtocolEnum(Integer protocolType, String desc) {
        this.protocolType = protocolType;
        this.desc = desc;
    }

    public Integer getProtocolType() {
        return protocolType;
    }

    public String getDesc() {
        return desc;
    }
}
