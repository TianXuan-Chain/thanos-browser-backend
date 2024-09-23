package com.netease.thanos.core.depositChain.bo.browser;

import lombok.Data;


/**
 * @ClassName: TransferBO
 * @Description:
 * @Author: Ravintich
 * @Date: 2022-07-25 16:27
 */
@Data
public class DrawLotteryBO {
    /**
     * 项目id
     */
    String projectId;
    /**
     * 开奖因子
     */
    String lotteryFactor;
}
