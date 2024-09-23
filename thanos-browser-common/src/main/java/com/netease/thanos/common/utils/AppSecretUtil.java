package com.netease.thanos.common.utils;

import com.google.common.collect.ImmutableMap;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by wangting04 on 2018/07/16
 */
public class AppSecretUtil {

    private static final String KEY_MD5 = "MD5";
    private static final String KEY_SHA1 = "SHA-1";


    public static Map getAppKeyAndSecret(String merchantId) throws NoSuchAlgorithmException {
        long nowtime = System.currentTimeMillis();
        String data = merchantId + Long.toString(nowtime);
        String appKey = Hex.toHexString(encryptMD5(data.getBytes()));
        String appSecret = Hex.toHexString(encryptSH1(data.getBytes()));
        return ImmutableMap.of("appKey", appKey, "appSecret", appSecret);
    }


    public static byte[] encryptMD5(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        return md5.digest();
    }

    public static byte[] encryptSH1(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(KEY_SHA1);
        digest.reset();
        digest.update(data);
        return digest.digest();
    }


    public static void main(String[] args) throws Exception {
        Map<String, String> m = getAppKeyAndSecret("HM");
        System.out.println(m);

        String ss ="/AtkeyJiYXRjaCI6Ilt7XCJ0bnhUeXBlXCI6MSwFDiRSZWFzb25cIjowARBwb1wiOlwidGVzdHNiNEAxNjMuY29tXCIsXCJjb2kBJihcIjAuMDAwMDgyOAUXBGZyASAcOlwibmIwMDEFEwFjHGltZXN0YW1wAWgoNTMyNDIzODE3MDAFZChueFNlcmlhbE51bQVuAU8VARgxMTAwMEU5ARAsODlFRTU2NUJcIn0s/roAHboEOTMJp6q6AAGOIR6GugAERDIBLAQ4Mt66AAA1bnQBCDQxOSVhqroApnQBAEYBuep0AQAybroACDg4Nba6AAg5MjSiLgIpdARGNN50AXboAgQzNLa6ALLoAkku4ugCcnQBCDA3N/66AGa6AABEQVnqLgJydAEINjYy/roAZroAAEX6ugAAMW7oAgQ3Nf66AGq6AARERWGjXS4YXSIsInJlcbVtBCI6qWwkNTYxMTAwMH07Ow==";
//        byte [] sbyte = Snappy.uncompress(Base64.decodeBase64(ss));
//        System.out.println(new String(sbyte));
    }


}
