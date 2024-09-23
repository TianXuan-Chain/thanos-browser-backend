package com.netease.thanos.core.depositChain.enums;

import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ContractBizType
 * @Description: 交易类型（未知-1、加载中0、转账1、抽签1、存证3、合约部署4）
 * @Author: Ravintich
 * @Date: 2022-07-25 16:13
 */
@Getter
public enum ContractBizType {
    UNKOWN("未知" , -1,"","","未知"),
    LOADING("加载中" , 0,"","","加载中，正在解析交易业务数据"),
    DEPOSIT("存证",1,"0x715c4d84", "function objectEvent(string serialNumber, string objectId, string corporationId, string accountId, string eventName, string allParamsHash, string partParamsHashJson, string remark) ","存证"),

    ZIPDEPOSIT("zip包存证",2,"","","zip包存证"),
    LOTTERY_DRAW("抽签",3,"0xe4c869d3","function draw(string sessionId, string shopId, string awardsId, bytes32 seedTxHash,bytes32 latestBlockHash) " ,"抽签"),
    CONTRACT_DEPLOY("合约部署",4,"","" ,"合约部署"),
    BRIDGE_DEPOSIT("跨链" , 5,"","","跨链数据存证"),
    ;
    private String name;
    private Integer bizType;
    private String functionSign;
    private String functionDefine;
    private String remark;

    /**
     * @param name
     * @param bizType
     * @param functionDefine
     */
    ContractBizType(String name, Integer bizType, String functionSign, String functionDefine, String remark){
        this.name = name;
        this.bizType = bizType;
        this.functionSign = functionSign;
        this.functionDefine = functionDefine;
        this.remark = remark;
    }

    /**
     * @param bizType
     * @return
     */
    public static ContractBizType getContractBizType(Integer bizType){
        List<ContractBizType> contractBizTypeList = Arrays.asList(ContractBizType.values()).stream().
                filter(e-> e.getBizType().equals(bizType)).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(contractBizTypeList)){
            return UNKOWN;
        }
        return contractBizTypeList.get(0);
    }
}
