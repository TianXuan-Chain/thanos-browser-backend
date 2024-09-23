package com.netease.thanos.core.depositChain.exception;


import com.netease.thanos.common.exception.DomainServiceException;

/**
 * ThanosChainDomainException.java的实现描述
 *
 * @author xuhao create on 2021/1/20 17:39
 */
public class ThanosChainDomainException extends DomainServiceException {


    private static final long serialVersionUID = -4242801414496856490L;
    /**
     * 异常对应的返回码
     */
    private String retCode;
    /**
     * 异常对应的描述信息
     */
    private String msgDesc;


    public ThanosChainDomainException(String msg, Throwable t) {
        super(msg, t);

    }

    public ThanosChainDomainException(String message) {
        super(message);
    }


    public String getRetCode() {
        return retCode;
    }


    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }


    public String getMsgDesc() {
        return msgDesc;
    }


    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }


}
