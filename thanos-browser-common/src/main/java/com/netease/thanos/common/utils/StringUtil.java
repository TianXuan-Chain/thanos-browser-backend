package com.netease.thanos.common.utils;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hzxuyankang on 2017/7/31.
 */
public class StringUtil {
    private static Log log = LogFactory.getLog(DateUtil.class);

    public static String generateSessionId(long id) {
        return UUID.randomUUID().toString().replaceAll("-", "") + id;
    }


    /**
     * java去除字符串中的空格、回车、换行符、制表符
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    /**
     * 是否需要更新版本号
     *
     * @param latestVersion     最新版本号
     * @param currentSdkVersion 当前传入的版本号
     * @return
     */
    public static boolean isOldSDK(String latestVersion, String currentSdkVersion) {
        if (StringUtils.isBlank(currentSdkVersion) || StringUtils.isBlank(latestVersion)) {
            throw new RuntimeException("sdkVersion or latestVersion  is null");
        }
        currentSdkVersion = currentSdkVersion.replace(".", "");
        latestVersion = latestVersion.replace(".", "");

        long currentSdkVersionLong = 0;
        long latestVersionLong = 0;
        try {
            currentSdkVersionLong = Long.valueOf(currentSdkVersion);
            latestVersionLong = Long.valueOf(latestVersion);
        } catch (NumberFormatException e) {
            throw new RuntimeException("NumberFormatException: For sdkVersion latestVersion:" + latestVersion + ";latestVersion=" + latestVersion);
        }
        if (currentSdkVersionLong < latestVersionLong) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 身份证号手机号脱敏（18978787878->189****7878）
     *
     * @param info 身份证
     * @return 脱敏后的手机号码
     */
    public static String infoDesensitization(String info) {
        if (Strings.isNullOrEmpty(info)) {
            return "";
        }
        int length = info.length();
        if (length < 4) {
            return info;
        }
        String a = info.substring(0, 3);
        String b = info.substring(length - 4, length);
        return a + "****" + b;
    }

    /**
     * 姓名：姓加*
     *
     * @param realName 身份证
     * @return 脱敏后的手机号码
     */
    public static String realNameDesensitization(String realName) {
        if (Strings.isNullOrEmpty(realName)) {
            return "";
        }

        return "*" + realName.substring(1, realName.length());
    }


    /**
     * 数字转字符串前面补0
     * <p>
     * 长度固定为9位
     *
     * @param num
     * @return
     */
    public static String num2StrWithFixedLength(long num) {
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return String.format("%09d", num);
    }


    /**
     * 数字转字符串前面补0
     * <p>
     * 小数点后8位
     *
     * @param b
     * @return
     */
    public static String BigDecimal2StrWith8(BigDecimal b) {
        DecimalFormat format = new DecimalFormat("#.########");
        return format.format(b);
    }


    /**
     * 数字转字符串前面补0
     * <p>
     * 小数点后5位
     *
     * @param b
     * @return
     */
    public static String BigDecimal2StrWith5(BigDecimal b) {
        DecimalFormat format = new DecimalFormat("#.#####");
        return format.format(b);
    }

    /**
     * 数字转字符串前面补0
     * <p>
     * 小数点后5位
     *
     * @param b
     * @return
     */
    public static String BigDecimal2StrWith5N(BigDecimal b) {
        String coin = BigDecimal2StrWith8(b);
        int index = coin.indexOf(".");
        if (index != -1) {
            coin = coin.substring(0, Math.min(index + 6, coin.length()));
        }
        return coin;
    }

    /**
     * 数字转字符串前面补0
     * <p>
     * 小数点后3位
     *
     * @param b
     * @return
     */
    public static String BigDecimal2StrWith3(BigDecimal b) {
        DecimalFormat format = new DecimalFormat("#.###");
        return format.format(b);
    }


    /**
     * 小数点后3位, 不足补0
     *
     * @param b
     * @return
     */
    public static String BigDecimal2StrWith3Accurate(BigDecimal b) {
        DecimalFormat format = new DecimalFormat("0.00000000");
        String format1 = format.format(b);
        return format1.substring(0, format1.indexOf(".") + 4);
    }


    public static void main(String[] asd) {
        String s = BigDecimal2StrWith3N(new BigDecimal(1.2));
        System.out.println(s);
    }

    public static String BigDecimal2StrWith3N(BigDecimal b) {
        String coin = BigDecimal2StrWith8(b);
        int index = coin.indexOf(".");
        if (index != -1) {
            coin = coin.substring(0, Math.min(index + 4, coin.length()));
        }
        return coin;
    }
}
