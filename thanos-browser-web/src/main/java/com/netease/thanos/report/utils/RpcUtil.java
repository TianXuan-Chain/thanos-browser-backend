package com.netease.thanos.report.utils;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.netease.thanos.api.dto.base.DepositChainPeerNodeDTO;
import com.netease.thanos.common.exception.NotarialVerifiationBizException;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;

/**
 * @Author lyy create on 2018-05-11
 */
@Slf4j
public class RpcUtil {

    /**
     * get node rpc info
     *
     * @param methodName
     * @param params
     * @param chainPeerNodeDTO
     * @return Object
     * @throws Throwable
     */
    public static Object queryInfo(String methodName, Object[] params, DepositChainPeerNodeDTO chainPeerNodeDTO)  {
        Object object = null;
        try {
            JsonRpcHttpClient client = null;
            client = new JsonRpcHttpClient(new URL("http://" + chainPeerNodeDTO.getIp()+":" + chainPeerNodeDTO.getRpcPort()));
            object = client.invoke(methodName, params, Object.class);
            return object;
        } catch (Throwable e) {
            log.error("rpc Exception!!!");
            throw new NotarialVerifiationBizException(e.getMessage());
        }
    }

}
