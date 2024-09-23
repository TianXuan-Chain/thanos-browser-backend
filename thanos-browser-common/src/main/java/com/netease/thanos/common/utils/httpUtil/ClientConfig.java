package com.netease.thanos.common.utils.httpUtil;

import com.alibaba.fastjson.JSONArray;
import com.netease.thanos.common.utils.DateUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * http client 的客户端配置
 * Created by mwjsolar on 17/3/26.
 */
public class ClientConfig {
    private static Log log = LogFactory.getLog(DateUtil.class);

    /**
     * 传入的url
     **/
    private String url;

    public static final int DEFAULT_CONNECT_TIMEOUT = 6000;

    public static final int DEFAULT_SOCKET_TIMEOUT = 6000;
    /**
     * 连接超时时间.
     */
    public static final int DEFAULT_CONNECT_REQUESTTIMEOUT = 500;

    /**
     * http链接超时时间
     **/
    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT;
    /**
     * http socket超时时间
     **/
    private int socketTimeout = DEFAULT_SOCKET_TIMEOUT;

    /**
     * 是否不走zebra，启用新的httpclient
     * 默认true，
     */
    private boolean httpclientEnable = true;

    private List<String> httpclientInterfaceVip;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public boolean isHttpclientEnable() {
        return httpclientEnable;
    }

    public List<String> getHttpclientInterfaceVip() {
        return httpclientInterfaceVip;
    }

    public void setHttpclientInterfaceVip(String httpclientInterfaceVip) {
        try {
            if (StringUtils.isNotBlank(httpclientInterfaceVip)) {
                JSONArray jsonArray = JSONArray.parseArray(httpclientInterfaceVip);
                this.httpclientInterfaceVip = jsonArray.toJavaList(String.class);
            } else {
                this.httpclientInterfaceVip = null;
            }
        } catch (Exception e) {
            log.error("ClientConfig.getHttpclientInterfaceVip ERROR.", e);
            this.httpclientInterfaceVip = null;
        }
    }

    public void setHttpclientEnable(boolean httpclientEnable) {
        this.httpclientEnable = httpclientEnable;
    }
}
