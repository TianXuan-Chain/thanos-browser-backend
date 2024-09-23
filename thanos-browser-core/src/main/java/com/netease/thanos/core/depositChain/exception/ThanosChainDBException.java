package com.netease.thanos.core.depositChain.exception;


import com.netease.thanos.common.dto.ThanosErrorCodeDTO;

/**
 * 类GalaxyDBException.java 的实现描述:
 *
 * @author xuhao create on 2021/1/20 17:39
 */
public class ThanosChainDBException extends ThanosChainDomainException {
    public ThanosChainDBException(String msg) {
        super(msg);
    }

    public ThanosChainDBException(String msg, Throwable t) {
        super(msg, t);
    }

    public ThanosChainDBException(ThanosErrorCodeDTO errorCode) {
        super(errorCode.getDesc());
        this.setRetCode(errorCode.getCode());
    }
}
