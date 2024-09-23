package com.netease.thanos.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 类LotteryQueryBlockRequestDTO.java 的实现描述:
 * Created by niyuelin on 2019/01/02
 */
@Getter
@Setter
public class LotteryQueryBlockRequestDTO implements Serializable {
    private int starBlockHeight;

    private int endBlockHeight;
}
