package com.netease.thanos.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class FPDecorder {

    private static Log log = LogFactory.getLog(DateUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static final String ANDROID = "android";
    public static final String IOS = "ios";

    // RSA 1024bit
    /* 注意:在客户端实现的sdk中，不要出现private_key */
    private static String publick_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVcstMCifdJnF7Wc0fsG+4Ubje"
            + "q1XgB2MmArKbqHkMHHbcq/9CVaOlYYH06dXw4uu81/w0WzxmnrkFjrwGMih5lvyj"
            + "tSkTcI0OJTu4+N65f4+LaZwgWIH2Z9wp+grlgRZTb6VQogHny99qYmkr39hWalMd"
            + "d/XdKD7IELHevtEiUQIDAQAB";

    private static String private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANVyy0wKJ90mcXtZ"
            + "zR+wb7hRuN6rVeAHYyYCspuoeQwcdtyr/0JVo6VhgfTp1fDi67zX/DRbPGaeuQWO"
            + "vAYyKHmW/KO1KRNwjQ4lO7j43rl/j4tpnCBYgfZn3Cn6CuWBFlNvpVCiAefL32pi"
            + "aSvf2FZqUx139d0oPsgQsd6+0SJRAgMBAAECgYEArd38S8xZ/IK8HcZgmFeYKYQo"
            + "Gvll0j8yPFwmMTVipMLq74YLP3WS/7wVp/JyGu49KG6nOd63rL/N5wEFl+ZzoFlJ"
            + "wZLyGZJihzFHyZHUibe4cdRUQmRgK/bIIlKnD44SqIgfcXcE824iVnQ4yKLf1LR4"
            + "od4VyBG1GN+Xm+FEe4ECQQD/rBaarTSPgh5sQzz6Z6QQURijGXtmvxQzeySQSfxa"
            + "qhT90FzomsXI9wn4dvuqRliyvHdBUi5smD3VarX2yhvlAkEA1bjZFEBY2ookdEQz"
            + "SY09qFGLw/zMzRLLE475suf+HD7xeVnpmocdxs2ACEauEAKXEvHiwdzGwESMDO62"
            + "89Y9/QJACIwpSUyHGFEiUT5COKDkZENBzpoYfQvgUgRI6aX/kMxk3UNtB7285QYV"
            + "SEA6E6w8ZOVWG1HzCWBhmNPzd2e0XQJBAKNoHbG6MTWGgbDTpFMMRqQ3FSHYW85A"
            + "HDzsCEad0lBOX9pkwJOB02Z5IPcy80sSb+fwQWvwHZZL0rjgm8l7eRECQQCtZneb"
            + "tPITgD/Wd+AHHU45vfuzwBtJJlvZYquFLixSxjcEQRALDHaxtSjWZ33gKvv0UHNr"
            + "5afWAYwMUUx4Ifnq";

    private static PublicKey getPublicKey(String public_key) throws Exception {
        // byte[] keyBytes = Base64.decode(public_key, Base64.DEFAULT);
        byte[] keyBytes = Base64.decodeBase64(public_key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    private static PrivateKey getPrivateKey(String private_key) throws Exception {
        // byte[] keyBytes = Base64.decode(private_key, Base64.DEFAULT);
        byte[] keyBytes = Base64.decodeBase64(private_key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    private static byte[] rsa_ecnrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PublicKey publicKey = getPublicKey(publick_key);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] enBytes = cipher.doFinal(data);
        return enBytes;
    }

    private static byte[] rsa_decyprt(byte[] endata) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PrivateKey privateKey = getPrivateKey(private_key);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] deBytes = cipher.doFinal(endata);
        return deBytes;
    }

    private static byte[] rsa_decyprt_nopadding(byte[] endata) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        PrivateKey privateKey = getPrivateKey(private_key);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] deBytes = cipher.doFinal(endata);
        return deBytes;
    }

    public static String decode(JsonNode root) throws IOException {
        String rk = root.get("rk").asText();
        String rdata = root.get("rdata").asText();
        String idVer = root.get("id_ver").asText();

        rk = StringUtils.replace(rk, " ", "+");
        rdata = StringUtils.replace(rdata, " ", "+");

        if (StringUtils.isNotBlank(rk) && StringUtils.isNotBlank(rdata)) {
            return decodeOnMobile(idVer, rk, rdata);
        }
        return null;
    }

    public static String decode(String fingerprint) throws IOException {
        if (StringUtils.isBlank(fingerprint)) {
            return null;
        }
        JsonNode root = mapper.readTree(fingerprint);
        return decode(root);
    }

    /**
     * android/ios decode
     *
     * @param rk
     * @param rdata
     * @return
     */
    private static String decodeOnMobile(String idVer, String rk, String rdata) {
        try {
            byte[] bytes = null;
            if (idVer.toLowerCase().startsWith(IOS) && idVer.substring(4).compareTo("1.2.1.1") < 0) {
                // 老的ios解密
                bytes = rsa_decyprt_nopadding(Base64.decodeBase64(rk.getBytes()));
            } else if (idVer.toLowerCase().startsWith(ANDROID)
                    || (idVer.toLowerCase().startsWith(IOS) && idVer.substring(4).compareTo("1.2.1.1") >= 0)) {
                // 新的ios解密和安卓一样
                bytes = rsa_decyprt(Base64.decodeBase64(rk.getBytes()));
            } else {
                return null;
            }

            byte[] aes_bytes = new byte[16];
            System.arraycopy(bytes, 0, aes_bytes, 0, 16); // iOS 过来的是128
            // byte，统一做一次copy算了

            Key aesKey = new SecretKeySpec(aes_bytes, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decValue = c.doFinal(Base64.decodeBase64(rdata.getBytes()));
            return new String(decValue);
        } catch (Exception e) {
            log.error(String.format("decodeOnMobileError:id_ver=%s,rk=%s,rdata=%s", idVer, rk, rdata), e);
        }
        return null;
    }


    /**
     * 该类可以解IOS的 antiSpamInfo
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String raw = "{\"id_ver\":\"IOS_1.3.0\",\"rk\":\"KL5AdQSMRX6NndTuM4KF\\/XGC5Ia70tBZPIYBj5\\/U4VYtRB61H6DoVsQbSs49hXdr3MfWXid5z9dsUnksLXVm64ffGZ0iOSeqOlyBAAedKHF7q9WoF14eHR2yRlkw2oUYrSZB4Dw0ZiWNrGEe43eA\\/JY5DGbTzQ9y1PzT++F68SY=\",\"rdata\":\"6dMrz4\\/H85Y+61k5lWD\\/r0yckx7G9I5kzfYAT82Lx4kPugT1r5+VIDcZwmKeOdSqqoyniB5v0BNS\\/FWhtEC4JSJ488uerNRU82ko5O9M1rpmYALI7ZMLpATiCcWBDfAElAwkejJFCotX7UEbo1M+m9i7\\/VDhaGoVK2rQN42aj+Ei5I8qowkccK\\/7fJe2shDWMa7n3WD30QDctEr7mKhHpUi0divojauHlc1fq+pjCZYiY4t2gl8cvvlHvxfWiR232nJ5IxtwHBBAZjeE5aDNNU3brJP+EH0vdAdHSd0V7fc=\",\"datatype\":\"aimt_datas\"}";
        raw = "{\"id_ver\":\"IOS_1.3.0\",\"rk\":\"BbveoFG3Vr9yc1JcuuETAnIRNTezHAylcCF5YKUy6Spbfle5J3lqPoq4O6kbSfQ8LgKyzToP4qDNsjXdl8n2K6G0T4hD4pvvTCm8ZabGvckKb574ATeXaUuYUbRFLeLZD1aImG3darZieQE0VsbCWIGujeEXVZEWMVf3TbeulPQ=\",\"rdata\":\"cdpJb3BLDixuNfjj+hrtinzsJy\\/v+7VrVvfX65hzgYgie8jlHeIGbrYM3qAtAew2\",\"datatype\":\"aimt_datas\"}";
        System.out.println(decode(raw));
    }
}
