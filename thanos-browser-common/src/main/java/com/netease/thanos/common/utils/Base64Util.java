package com.netease.thanos.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

public class Base64Util {

    public static String decoderBase64ByUTF8(String message) {
        String result;
        try {
            byte[] base64Message = Base64.decodeBase64(message);
            result = new String(base64Message, "UTF-8");
            return result;
        } catch (IOException e) {
            // log.error(e);
        }
        return "";
    }

    public static String encoderBase64ByUTF8(String message) {
        String result;
        try {
            result = Base64.encodeBase64String(message.getBytes("UTF-8")).replaceAll("\r|\n", "");
            return result;
        } catch (Exception e) {
            // log.error(e);
        }
        return "";
    }
}
