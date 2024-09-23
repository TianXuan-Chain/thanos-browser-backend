package com.netease.thanos.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类TransactionCheckRequestDTO.java的实现描述：
 *
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class TransactionCheckRequestDTO implements Serializable {

    private String traceId;
    private String transactionTime;

}

