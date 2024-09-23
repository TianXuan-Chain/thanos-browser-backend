package com.netease.thanos.common.exception;

/**
 * 类DomainServiceException.java的实现描述：领域异常
 *
 * @author hzcaochongrui 2018年1月25日 下午2:33:16
 */
public class DomainServiceException extends RuntimeException {


    private static final long serialVersionUID = -4967341871718201888L;

    public DomainServiceException() {
        super();
    }

    public DomainServiceException(String message) {
        super(message);
    }

    public DomainServiceException(Throwable exception) {
        super(exception);
    }

    public DomainServiceException(String message, Throwable exception) {
        super(message, exception);
    }

}
