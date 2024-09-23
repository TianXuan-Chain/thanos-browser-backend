package com.netease.thanos.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

    private static final char[] bcdLookup = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'};

    /*
     * 将字符数组转换为16进制字符串
     */
    public static String bytesToHexStr(byte[] bcd) {
        StringBuffer s = new StringBuffer(bcd.length * 2);

        for (int i = 0; i < bcd.length; i++) {
            s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
            s.append(bcdLookup[bcd[i] & 0x0f]);
        }

        return s.toString();
    }

    /*
     * 将16进制字符串转换为字符数组
     */
    public static byte[] hexStrToBytes(String s) {
        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }

        return bytes;
    }

    /**
     * 判断IP是否在白名单里面
     *
     * @param whiteStr IP白名单
     * @param IP       候选的IP
     * @return true 在；false 不在
     */
    public static boolean ipInWhiteList(String whiteStr, String IP) {
        String[] strs = whiteStr.split(",");
        for (String str : strs) {
            boolean yes;
            if (str.contains("/")) {
                yes = validateIp(str.trim(), IP); // 网段表示，例如 123.58.185.0/24
            } else {
                yes = str.trim().equals(IP); // IP直接匹配
            }
            if (yes) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检验ip是否在ipM表示的网段里面
     *
     * @param ipM 网段，形如 123.58.185.0/24
     * @param ip  IPV4 的IP地址
     * @return true 在；false 不在
     */
    public static boolean validateIp(String ipM, String ip) {
        String[] strs = ipM.split("/");
        int mask = Integer.parseInt(strs[1]);
        String gate = ipMCache.get(ipM);
        if (gate == null) {
            gate = afterMask(strs[0], mask);
            ipMCache.put(ipM, gate);
        }
        String gate2 = afterMask(ip, mask);
        return gate.equals(gate2);
    }

    private static Map<String, String> ipMCache = new HashMap<>();

    // 将IP转成二进制，并只取前“掩码”位
    private static String afterMask(String ip, int mask) {
        if (mask < 0 || mask > 32) {
            throw new IllegalArgumentException("mask should be in between 0 and 32");
        }

        String[] strs = ip.split("\\.");
        StringBuilder ipb = new StringBuilder();
        for (String str : strs) {
            String b = Integer.toBinaryString(Integer.parseInt(str));
            int len = b.length();
            for (int i = 0; i < 8 - len; i++) {
                b = "0" + b;
            }
            ipb.append(b);
        }
        return ipb.toString().substring(0, mask);
    }

    /**
     * 为敏感字符串加上型号
     *
     * @param plainStr
     * @param headLength 头几位显示
     * @param tailLength 末几位显示
     * @param starLength 星号的数量
     * @return
     */
    public static String getSecretNumberWithStart(String plainStr, int headLength, int tailLength, int starLength) {
        if (StringUtils.isBlank(plainStr)) {
            return "";
        }
        char[] star = new char[starLength];
        Arrays.fill(star, '*');
        String starString = new String(star);

        if (plainStr.length() <= tailLength) {
            return plainStr;
        } else {
            return plainStr.substring(0, headLength) + starString
                    + plainStr.substring(plainStr.length() - tailLength, plainStr.length());
        }
    }

    /**
     * 返回隐藏的手机号，例如：13812345678转为*******5678
     *
     * @param mobile
     * @return
     * @author Lin Yaohua
     */
    public static String maskMobile(String mobile) {
        return getSecretNumberWithStart(mobile, 0, 4, 7);
    }

    public static void main(String[] args) {

    }

}
