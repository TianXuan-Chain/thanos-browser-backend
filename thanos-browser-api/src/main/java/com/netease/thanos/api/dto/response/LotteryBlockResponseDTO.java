package com.netease.thanos.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 类LotteryBlockResponseDTO.java 的实现描述:
 * Created by niyuelin on 2019/01/02
 */
@Getter
@Setter
public class LotteryBlockResponseDTO implements Serializable {
    private Integer number;
    //哈希
    private String pkHash;
    //出块时间
    private Timestamp timestamp;
    //交易数量
    private Long txn;

}
