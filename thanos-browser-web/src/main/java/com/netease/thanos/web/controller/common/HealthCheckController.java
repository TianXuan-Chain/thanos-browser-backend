package com.netease.thanos.web.controller.common;

import com.netease.thanos.common.constants.ConfCenterConstants;
import com.netease.thanos.web.util.HttpUtil;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kingkong on 2018/2/26.
 */
@Controller
@RequestMapping(value = { "/health" })
@Slf4j
public class HealthCheckController {

    // 默认状态码为200 
    private static final  int HEALTH_CHECK_STATUS_CODE200 = 200;
    private static final  int    HEALTH_CHECK_STATUS_CODE403 = 403;

    public static volatile int  STATUS_CODE= 200;

    @Resource
    Environment environment;

    /**
     * 查看应用状态
     */
    @RequestMapping(value = "/status", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD })
    public void status(HttpServletResponse response) {
        response.setStatus(STATUS_CODE);
        return;
    }

    /**
     * 上线应用
     */
    @RequestMapping(value = "/active", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD })
    public void active(HttpServletRequest request, HttpServletResponse response) {
        String ip = HttpUtil.getRemoteAddr(request);

        if (!checkIp(ip))// 限制调用IP
        {
            response.setStatus(HEALTH_CHECK_STATUS_CODE403);
            return;
        }
        // 设置应用状态码为200
        STATUS_CODE = HEALTH_CHECK_STATUS_CODE200;
        return;
    }

    /**
     * 下线应用
     */
    @RequestMapping(value = "/offline", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD })
    public void offline(HttpServletRequest request, HttpServletResponse response) {
        String ip = HttpUtil.getRemoteAddr(request);
        log.info("HealthCheckController.offline**************offline*************ip={}", ip);

        if (!checkIp(ip))// 限制调用IP
        {
            response.setStatus(HEALTH_CHECK_STATUS_CODE403);
            return;
        }

        // 设置应用状态码为403
        STATUS_CODE = HEALTH_CHECK_STATUS_CODE403;
        return;
    }

    private boolean checkIp(String ip) {
        String ips = environment.getProperty(ConfCenterConstants.STAR_ALLOW_USE_HEALTH_CHECK_IP);
        if (StringUtils.isBlank(ips)) {
            return false;
        }
        String[] ipArr = StringUtils.split(ips, "\\,");
        for (int i = 0; i < ipArr.length; i++) {
            if (StringUtils.equalsIgnoreCase(ip, ipArr[i])) {
                return true;
            }
        }
        log.error("非法ip。ip={}", ip);
        return false;
    }
}

