package com.netease.thanos.common.utils.httpUtil;


/**
 * Created by Yang Tengfei on 10/20/16.
 */
public interface ServiceRequest {
    String getVersion();

    String getMethod();

    HttpMethod getHttpMethod();

    void setRequestId(String requestId);

}
