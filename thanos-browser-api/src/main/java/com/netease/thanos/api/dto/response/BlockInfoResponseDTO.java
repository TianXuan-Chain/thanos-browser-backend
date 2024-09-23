package com.netease.thanos.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 类StarChainBlockInfoResponseDTO.java 的实现描述:
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class BlockInfoResponseDTO implements Serializable {
    private Long id;
    //块高
    private Integer number;
    //哈希
    private String pkHash;
    //父hash
    private String parentHash;
    private Integer genIndex;
    //大小
    private Integer size;
    //出块时间
    private Timestamp timestamp;
    //交易数量
    private Long txn;
    private String extraData;
    private String blockAreaInfo; //块矿区 名称
}