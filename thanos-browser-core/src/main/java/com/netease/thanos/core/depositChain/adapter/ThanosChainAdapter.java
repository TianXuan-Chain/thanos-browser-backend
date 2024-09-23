package com.netease.thanos.core.depositChain.adapter;

import com.netease.thanos.core.depositChain.adapter.config.ThanosChainConfig;
import com.netease.thanos.core.depositChain.exception.BlockChainBizException;
import com.thanos.web3j.model.ThanosBlock;
import com.thanos.web3j.protocol.Web3j;
import com.thanos.web3j.protocol.core.methods.response.EthGetNumber;
import com.thanos.web3j.protocol.core.methods.response.EthGetString;
import com.thanos.web3j.protocol.http.OkHttpService;
import com.thanos.web3j.protocol.manage.GatewayConnector;
import com.thanos.web3j.protocol.manage.Web3Manager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.spongycastle.util.encoders.Hex;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 类 ThanosChainAdapter.java 的实现描述: 天玄链适配器
 * Created by wangting04 on 2022/08/25
 */
@Slf4j
@Component
public class ThanosChainAdapter {
    @Resource
    private Environment environment;

    /**
     * web3连接管理器
     */
    private Web3Manager web3Manager;
    @Resource
    private ThanosChainConfig thanosChainConfig;


    private static List<Web3j> connectHttpList = new ArrayList<>();
    private static List<GatewayConnector> rpcConnectList = new ArrayList<>();
    private static AtomicLong rpcCurrentUse = new AtomicLong();

    private static boolean clientRpc = false;
    private volatile boolean isClosed = false;

    @PostConstruct
    public synchronized void initConnections() {
        if (thanosChainConfig.getClientType() == null
                || (thanosChainConfig.getClientType() != 1 && thanosChainConfig.getClientType() != 2)) {
            log.error("initConnections clientType is null or error clientType:{}", thanosChainConfig.getClientType());
            return;
        }

        if (thanosChainConfig.getClientType() == 2) {
            clientRpc = true;
        }

        log.info("start initConnections, thanosChainConfig:{}", thanosChainConfig);

        List<String> rpcIPList = Arrays.asList(thanosChainConfig.getRpcIpList().split(","));

        if (thanosChainConfig.getClientType() == 1) {
            for (String ipPort : rpcIPList) {
                String url = "http://" + ipPort + "/rpc";
                Web3j web3j = Web3j.build(new OkHttpService(url));
                connectHttpList.add(web3j);
            }
            log.info("http end initConnections");
        } else {
            for (String ipPort : rpcIPList) {
                if (StringUtils.isBlank(thanosChainConfig.getCertsPath()) || StringUtils.isBlank(thanosChainConfig.getKeyPath())) {
                    GatewayConnector gatewayConnector = new GatewayConnector(ipPort, 5, false, "", "");
                    rpcConnectList.add(gatewayConnector);
                } else {
                    GatewayConnector gatewayConnector = new GatewayConnector(ipPort, 5, true, thanosChainConfig.getKeyPath(), thanosChainConfig.getCertsPath());
                    rpcConnectList.add(gatewayConnector);
                }
            }
            checkClient(rpcConnectList);
            log.info("rpc end initConnections");
        }
    }

    private void checkClient(List<GatewayConnector> rpcConnectList) {
        new Thread(() -> {
            while (!isClosed) {
                try {
                    Thread.sleep(30 * 1000);
                    for (GatewayConnector gatewayConnector : rpcConnectList) {
                        gatewayConnector.checkConnect();
                    }
                    log.info("checkConnect end!");
                } catch (Exception e) {
                    log.error("checkConnect exception.", e);
                }
            }
        }).start();
    }

    /**
     * 获取 http web3j
     *
     * @return
     */
    public Web3j getWeb3jRandomly() throws BlockChainBizException {
        if (clientRpc) {
            int i = (int) (rpcCurrentUse.getAndIncrement() % rpcConnectList.size());
            Web3j web3j = rpcConnectList.get(i).getWeb3jRandomly();
            if (web3j == null) {
                throw new BlockChainBizException("randomWeb3j rpc web3j is null");
            }
            return web3j;
        } else {
            int i = (int) (rpcCurrentUse.getAndIncrement() % (long) connectHttpList.size());
            return connectHttpList.get(i);
        }

    }

    //获取最新共识高度
    public Long getLatestConsensusNumber() throws BlockChainBizException {
        try {
            Web3j web3j = getWeb3jRandomly();
            if (web3j == null) {
                log.error("ThanosChainConnector getLatestConsensusNumber failed, no web3j available.");
                throw new BlockChainBizException("区块链调用异常");
            }
            EthGetNumber result = web3j.thanosGetLatestConsensusNumber().send();
            return result.getNumber();
        } catch (Exception e) {
            log.warn("ThanosChainConnector getLatestConsensusNumber failed. ", e);
            throw new BlockChainBizException("区块链调用异常");
        }
    }

    /**
     * 获取最新执行高度
     *
     * @return
     * @throws BlockChainBizException
     */
    public Long getLatestBeExecutedNum() throws BlockChainBizException {
        try {
            Web3j web3j = getWeb3jRandomly();
            if (web3j == null) {
                log.error("ThanosChainConnector getLatestBeExecutedNum failed, no web3j available.");
                throw new BlockChainBizException("区块链调用异常");
            }
            EthGetNumber result = web3j.thanosGetLatestBeExecutedNum().send();
            return result.getNumber();
        } catch (Exception e) {
            log.warn("ThanosChainConnector getLatestBeExecutedNum failed. ", e);
            throw new BlockChainBizException("区块链调用异常");
        }
    }

    /**
     * 获取最新执行高度
     *
     * @return
     * @throws BlockChainBizException
     */
    public ThanosBlock getBlockByNumber(Long blockNumber) throws BlockChainBizException {
        try {
            Web3j web3j = getWeb3jRandomly();
            if (web3j == null) {
                log.error("ThanosChainConnector getBlockByNumber failed, no web3j available.");
                throw new BlockChainBizException("区块链调用异常");
            }
            EthGetString result = web3j.thanosGetBlockByNumber(blockNumber.toString()).send();
            String blockStr = result.getString();
            if (StringUtils.isBlank(blockStr)) {
                log.warn("ThanosChainConnector getBlockByNumber not exist, blockNumber:{}.", blockNumber);
                return null;
            }
            byte[] data = Hex.decode(blockStr);
            return new ThanosBlock(data);
        } catch (Exception e) {
            log.warn("ThanosChainConnector getBlockByNumber failed. ", e);
            throw new BlockChainBizException("区块链调用异常");
        }
    }
}
