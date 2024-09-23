package com.netease.thanos.core.depositChain.exception;

/**
 * @Author lyy create on 2018-05-15
 */
public class BlockChainBizException extends RuntimeException {
    public BlockChainBizException(String msg) {
        super(msg);
    }

    public BlockChainBizException(Throwable cause) {
        super(cause);
    }
}
