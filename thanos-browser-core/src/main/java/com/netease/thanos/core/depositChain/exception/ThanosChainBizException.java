package com.netease.thanos.core.depositChain.exception;


import com.netease.thanos.common.dto.ThanosErrorCodeDTO;

/**
 * @author xuhao create on 2021/1/20 17:39
 */
public class ThanosChainBizException extends ThanosChainDomainException {
    public ThanosChainBizException(String msg) {
        super(msg);
    }

    public ThanosChainBizException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ThanosChainBizException(ThanosErrorCodeDTO errorCode) {
        super(errorCode.getDesc());
        this.setRetCode(errorCode.getCode());
    }

}
