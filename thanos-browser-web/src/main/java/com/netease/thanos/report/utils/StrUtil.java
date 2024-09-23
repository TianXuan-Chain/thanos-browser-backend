package com.netease.thanos.report.utils;

/**
 * 类 StrUtil.java的实现描述：字符串处理
 *
 * @author tongheqiang  2022年11月03日 15:59
 */
public class StrUtil {

    public static String strTrim(String str){
        if(null == str|| "".equals(str)){
            return str;
        }
        str = str.replace(" ","");
        str = str.replace("\n","");
        return str;
    }
}
