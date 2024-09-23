package com.netease.thanos.core.depositChain.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

import com.netease.thanos.core.depositChain.service.facade.ThanosBlockFacadeService;
import com.netease.thanos.core.depositChain.service.facade.ThanosChainFacadeService;
import com.netease.thanos.core.depositChain.service.facade.ThanosTransactionFacadeService;

import javax.annotation.Resource;

/**
 * 类ThanosChainDomain.java的实现描述：
 *
 * @author xuhao create on 2021/1/26 16:19
 */

@Component
@Getter
public class ThanosChainDomain {
    @Resource
    private ThanosBlockFacadeService thanosBlockFacadeService;
    @Resource
    private ThanosChainFacadeService thanosChainFacadeService;
    @Resource
    private ThanosTransactionFacadeService thanosTransactionFacadeService;
}
