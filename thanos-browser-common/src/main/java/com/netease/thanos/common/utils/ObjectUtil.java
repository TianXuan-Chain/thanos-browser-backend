package com.netease.thanos.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * ObjectUtil.java的实现描述：stream/filter对象空校验
 *
 * @author dumaobing 2017年6月3日 上午9:18:25
 */
public class ObjectUtil {

    public static Boolean isNotNull(Object obj){
        return null != obj;
    }


    public static String compressArgs(final String argsStr) throws IOException {
        return Base64.encodeBase64String(Snappy.compress(argsStr));
    }

    public static String uncompressArgs(final String argsStr) throws IOException {
        return Snappy.uncompressString(Base64.decodeBase64(argsStr));
    }
}
