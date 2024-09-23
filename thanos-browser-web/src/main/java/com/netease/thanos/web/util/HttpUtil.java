package com.netease.thanos.web.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取ip
 * Created by wangting04 on 2018/07/18
 */
public class HttpUtil {

    public static final String IP_REG = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";


    public static final String getRemoteAddr(HttpServletRequest request) {
        String rip = request.getRemoteAddr();
        String xff = request.getHeader("X-Forwarded-For");
        String ip;
        if (xff != null && xff.length() != 0) {
            int px = xff.indexOf(',');
            if (px != -1) {
                ip = xff.substring(0, px);
            } else {
                ip = xff;
            }
            if ("unknown".equalsIgnoreCase(ip)) {
                ip = rip;
            } else if (!ip.matches(IP_REG)) {
//                log.fatal("Wrong format IP from header, X-Forwarded-For:" + xff + ", IP:" + rip);
                ip = rip;
            }
        } else {
            ip = rip;
        }
        return ip.trim();
    }
}
