package com.netease.thanos.core.depositChain.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author wangting04 create on 2018-05-16
 */
@Component
public class Constant implements InitializingBean {

    public static final int MAX_DAY_DIFF = 30;

    public static final int MAX_PAGE_SIZE = 100;

    public static final int MIN_PAGE_SIZE = 25;

    // 交易最多展示50万条
    public static final long TNX_MAX_NUM = 500000;

    // 交易最多展示1万条
    public static final long TNX_MIN_NUM = 10000;

//    @Value("${nbgame.fox.desensitizationAddress.length}")
//    @Setter
    private String desensitizationAddressLength;


    private static int startLen = 6;
    private static int endLen = 4;

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!StringUtils.isEmpty(desensitizationAddressLength)){
            String[] dl = desensitizationAddressLength.split(",");
            if (dl != null) {
                if (dl.length == 2) {
                    startLen = Integer.parseInt(dl[0]);
                    endLen = Integer.parseInt(dl[1]);
                }
            }
        }
    }

    public static String showDesensitizationAddress(String address) {
        return address.substring(0, startLen) + address.substring(startLen, address.length() - endLen).replaceAll(".", "*") + address.substring(address.length() - endLen);
    }

    public static void main(String[] args) {
        System.out.println(showDesensitizationAddress("0xf06761efa67cbb4087e38d29f64ab54f05b61ca9"));
        System.out.println("0xf06761efa67cbb4087e38d29f64ab54f05b61ca9".length());
        System.out.println(showDesensitizationAddress("0xf06761efa67cbb4087e38d29f64ab54f05b61ca9").length());
    }
}
