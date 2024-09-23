package com.netease.thanos.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecurityUtil {

    private static final Log log = LogFactory.getLog(SecurityUtil.class);
    private static byte NUMBER_KEY = 48;
    private static byte UPPER_KEY = 55;

    public static String getMd5(String s) throws Exception {
        return getMd5(s, "utf-8");
    }

    public static String getMd5(String s, String encode) throws Exception {
        return generateDigest("MD5", s, encode);
    }

    public static String hmacmd5(String ssn, int seed) throws Exception {
        byte[] plainText = ssn.getBytes();

        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecureRandom sr = new SecureRandom();
        log.debug("seed=" + seed);
        sr.setSeed(seed);
        keyGen.init(64, sr);
        SecretKey MD5key = keyGen.generateKey();
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(MD5key);
        mac.update(plainText);

        return URLEncoder.encode(new String(mac.doFinal()), "UTF-8");
    }

    private static String generateDigest(String algorithm, String s, String encode) throws Exception {
        byte abyte0[] = null;
        MessageDigest messagedigest;
        try {
            messagedigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
            log.error("SecurityUtil.generateDigest", nosuchalgorithmexception);
            throw new IllegalArgumentException("no " + algorithm + " support", nosuchalgorithmexception);
        }
        messagedigest.update(s.getBytes(encode));

        abyte0 = messagedigest.digest();
        return byte2hex(abyte0);
    }

    public static String byte2hex(byte abyte0[]) {
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        for (int i = 0; i < abyte0.length; i++) {
            if ((abyte0[i] & 0xff) < 16) {
                stringbuffer.append("0");
            }
            stringbuffer.append(Long.toString((long) abyte0[i] & (long) 255, 16));
        }

        return stringbuffer.toString().toUpperCase();
    }

    public static String hexToStr(byte[] pBytes) {
        String result = "";
        for (int i = 0; i < pBytes.length; i++) {
            int tmpInt = new Byte(pBytes[i]).intValue();
            if (tmpInt < 0) {
                tmpInt = tmpInt + 256;
            }
            byte[] strList = new byte[2];
            strList[1] = new Integer(tmpInt % 16).byteValue();
            strList[0] = new Integer((tmpInt / 16) % 16).byteValue();

            if (strList[1] > 9 && strList[1] < 16) {
                strList[1] += UPPER_KEY;
            }
            if (strList[1] >= 0 && strList[1] < 10) {
                strList[1] += NUMBER_KEY;
            }
            if (strList[0] > 9 && strList[0] < 16) {
                strList[0] += UPPER_KEY;
            }
            if (strList[0] >= 0 && strList[0] < 10) {
                strList[0] += NUMBER_KEY;
            }

            result = result + new String(strList);

        }
        return result;
    }
}
