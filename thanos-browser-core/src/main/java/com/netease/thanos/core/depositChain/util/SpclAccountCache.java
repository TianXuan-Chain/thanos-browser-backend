package com.netease.thanos.core.depositChain.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @Author lyy create on 2018-05-12
 */

@Component
public class SpclAccountCache implements InitializingBean {

    private final HashSet<String> spclCache = new HashSet<>();
    private final HashSet<String> digCache = new HashSet<>();

    /**
     * 所有B端账号
     */
//    @Value("${star.spcl.acct}")
//    @Setter
//    private String spclAccts;
//
//    /**
//     * 挖矿等b端账号账号
//     */
//    @Value("${star.dig.acct}")
//    @Setter
//    private String digAccts;

    @Override
    public void afterPropertiesSet() throws Exception {
        initCache();
    }

    private void initCache() {
//        if (!StringUtils.isEmpty(spclAccts)) {
//            String[] spclAcctArr = spclAccts.split(",");
//
//            for (String acct : spclAcctArr) {
//                spclCache.add(acct.trim());
//            }
//        }
//
//        if (!StringUtils.isEmpty(digAccts)) {
//            String[] digAcctArr = digAccts.split(",");
//
//            for (String acct : digAcctArr) {
//                digCache.add(acct.trim());
//            }
//        }
    }

    /**
     * 本次都是商户，所以这里就先写死返回true
     * @param bcAddress
     * @return
     */
    public boolean isSpclAcct(String bcAddress) {
    	return true;
       // return spclCache.contains(bcAddress);
    }

    public boolean isDigAcct(String bcAddress) {
        return digCache.contains(bcAddress);
    }
}
