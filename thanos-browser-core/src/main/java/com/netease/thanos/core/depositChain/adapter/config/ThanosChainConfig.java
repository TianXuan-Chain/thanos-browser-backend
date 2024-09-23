package com.netease.thanos.core.depositChain.adapter.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类 ThanosChainConfig.java 的实现描述:
 * Created by wangting04 on 2022/09/07
 */
@Component
@Data
public class ThanosChainConfig {
    @Value("${thanos.client.type}")
    private Integer clientType;

    @Value("${thanos.rpc.ip.List}")
    private String rpcIpList;

    @Value("${thanos.certs.path}")
    private String certsPath;

    @Value("${thanos.key.path}")
    private String keyPath;

    @Value("${thanos.log.config.path}")
    private String logPath;
}
