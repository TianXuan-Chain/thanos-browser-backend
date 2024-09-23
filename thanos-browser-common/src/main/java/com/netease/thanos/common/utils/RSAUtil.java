package com.netease.thanos.common.utils;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAUtil {
    public static final String RSA = "RSA";// 非对称加密密钥算法
    public static final String ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";//加密填充方式
    public static final int DEFAULT_KEY_SIZE = 1024;//秘钥默认长度
    public static final byte[] DEFAULT_SPLIT = "#PART#".getBytes();    // 当要加密的内容超过bufferSize，则采用partSplit进行分块加密
    public static final int DEFAULT_BUFFERSIZE = (DEFAULT_KEY_SIZE / 8) - 11;// 当前秘钥支持加密的最大字节数


    // 数字签名，密钥算法
    private static final String RSA_KEY_ALGORITHM = "RSA";

    // 数字签名签名/验证算法  
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    // RSA密钥长度  
    private static final int KEY_SIZE = 1024;

    private static final String PUBLIC_KEY = "publicKey";
    private static final String PRIVATE_KEY = "privateKey";

    /**
     * 初始化RSA密钥对
     *
     * @return RSA密钥对
     * @throws Exception 抛出异常
     */
    private static Map<String, String> initKey() throws Exception {
        KeyPairGenerator keygen = KeyPairGenerator
                .getInstance(RSA_KEY_ALGORITHM);
        SecureRandom secrand = new SecureRandom();
        secrand.setSeed("star".getBytes());// 初始化随机产生器
        keygen.initialize(KEY_SIZE, secrand); // 初始化密钥生成器  
        KeyPair keys = keygen.genKeyPair();
        String pub_key = Base64.encodeBase64String(keys.getPublic().getEncoded());
        String pri_key = Base64.encodeBase64String(keys.getPrivate().getEncoded());
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put(PUBLIC_KEY, pub_key);
        keyMap.put(PRIVATE_KEY, pri_key);
        System.out.println("公钥：" + pub_key);
        System.out.println("私钥：" + pri_key);
        return keyMap;
    }

    /**
     * 得到公钥
     *
     * @param keyMap RSA密钥对
     * @return 公钥
     * @throws Exception 抛出异常
     */
    public static String getPublicKey(Map<String, String> keyMap) throws Exception {
        return keyMap.get(PUBLIC_KEY);
    }

    /**
     * 得到私钥
     *
     * @param keyMap RSA密钥对
     * @return 私钥
     * @throws Exception 抛出异常
     */
    public static String getPrivateKey(Map<String, String> keyMap) throws Exception {
        return keyMap.get(PRIVATE_KEY);
    }

    /**
     * 数字签名
     *
     * @param data    待签名数据
     * @param pri_key 私钥
     * @return 签名
     * @throws Exception 抛出异常
     */
    public static String sign(byte[] data, String pri_key) throws Exception {
        // 取得私钥  
        byte[] pri_key_bytes = Base64.decodeBase64(pri_key);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key_bytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 生成私钥  
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 实例化Signature  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature  
        signature.initSign(priKey);
        // 更新  
        signature.update(data);

        return Base64.encodeBase64String(signature.sign());
    }

    /**
     * RSA校验数字签名
     *
     * @param data    数据
     * @param sign    签名
     * @param pub_key 公钥
     * @return 校验结果，成功为true，失败为false
     * @throws Exception 抛出异常
     */
    public boolean verify(byte[] data, byte[] sign, String pub_key) throws Exception {
        // 转换公钥材料  
        // 实例化密钥工厂  
        byte[] pub_key_bytes = Base64.decodeBase64(pub_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 初始化公钥  
        // 密钥材料转换  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub_key_bytes);
        // 产生公钥  
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        // 实例化Signature  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature  
        signature.initVerify(pubKey);
        // 更新  
        signature.update(data);
        // 验证  
        return signature.verify(sign);
    }

    /**
     * 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    private static byte[] encryptByPubKey(byte[] data, byte[] publicKey) throws Exception {
//        // 取得公钥
//        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub_key);
//        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
//        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
//        // 对数据加密
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        return cipher.doFinal(data);

        int dataLen = data.length;
        if (dataLen <= DEFAULT_BUFFERSIZE) {
            return encryptByPublicKey(data, publicKey);
        }
        List<Byte> allBytes = new ArrayList<Byte>(2048);
        int bufIndex = 0;
        int subDataLoop = 0;
        byte[] buf = new byte[DEFAULT_BUFFERSIZE];
        for (int i = 0; i < dataLen; i++) {
            buf[bufIndex] = data[i];
            if (++bufIndex == DEFAULT_BUFFERSIZE || i == dataLen - 1) {
                subDataLoop++;
                if (subDataLoop != 1) {
                    for (byte b : DEFAULT_SPLIT) {
                        allBytes.add(b);
                    }
                }
                byte[] encryptBytes = encryptByPublicKey(buf, publicKey);
                for (byte b : encryptBytes) {
                    allBytes.add(b);
                }
                bufIndex = 0;
                if (i == dataLen - 1) {
                    buf = null;
                } else {
                    buf = new byte[Math.min(DEFAULT_BUFFERSIZE, dataLen - i - 1)];
                }
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;

    }

    /**
     * 用公钥对字符串进行加密
     *
     * @param data 原文
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
        // 得到公钥
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PublicKey keyPublic = kf.generatePublic(keySpec);
        // 加密数据
        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
        cp.init(Cipher.ENCRYPT_MODE, keyPublic);
        return cp.doFinal(data);
    }

    /**
     * 公钥加密
     *
     * @param data    待加密数据
     * @param pub_key 公钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    public static String encryptByPubKey(String data, String pub_key) throws Exception {
        // 私匙加密  
        byte[] pub_key_bytes = Base64.decodeBase64(pub_key);
        byte[] enSign = encryptByPubKey(data.getBytes(), pub_key_bytes);
        return Base64.encodeBase64String(enSign);
    }

    /**
     * 私钥加密
     *
     * @param data    待加密数据
     * @param pri_key 私钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    private static byte[] encryptByPriKey(byte[] data, byte[] pri_key) throws Exception {
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密
     *
     * @param data    待加密数据
     * @param pri_key 私钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    public static String encryptByPriKey(String data, String pri_key) throws Exception {
        // 私匙加密  
        byte[] pri_key_bytes = Base64.decodeBase64(pri_key);
        byte[] enSign = encryptByPriKey(data.getBytes(), pri_key_bytes);
        return Base64.encodeBase64String(enSign);
    }

    /**
     * 公钥解密
     *
     * @param data    待解密数据
     * @param pub_key 公钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    private static byte[] decryptByPubKey(byte[] data, byte[] pub_key) throws Exception {
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data    待解密数据
     * @param pub_key 公钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    public static String decryptByPubKey(String data, String pub_key) throws Exception {
        // 公匙解密  
        byte[] pub_key_bytes = Base64.decodeBase64(pub_key);
        byte[] design = decryptByPubKey(Base64.decodeBase64(data), pub_key_bytes);
        return new String(design);
    }

    /**
     * 私钥解密
     *
     * @param encrypted  待解密数据
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    private static byte[] decryptByPriKey(byte[] encrypted, byte[] privateKey) throws Exception {
//        // 取得私钥
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key);
//        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
//        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
//        // 对数据解密
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);
//        return cipher.doFinal(data);

        int splitLen = DEFAULT_SPLIT.length;
        if (splitLen <= 0) {
            return decryptByPrivateKey(encrypted, privateKey);
        }
        int dataLen = encrypted.length;
        List<Byte> allBytes = new ArrayList<Byte>(1024);
        int latestStartIndex = 0;
        for (int i = 0; i < dataLen; i++) {
            byte bt = encrypted[i];
            boolean isMatchSplit = false;
            if (i == dataLen - 1) {
                // 到data的最后了
                byte[] part = new byte[dataLen - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            } else if (bt == DEFAULT_SPLIT[0]) {
                // 这个是以split[0]开头
                if (splitLen > 1) {
                    if (i + splitLen < dataLen) {
                        // 没有超出data的范围
                        for (int j = 1; j < splitLen; j++) {
                            if (DEFAULT_SPLIT[j] != encrypted[i + j]) {
                                break;
                            }
                            if (j == splitLen - 1) {
                                // 验证到split的最后一位，都没有break，则表明已经确认是split段
                                isMatchSplit = true;
                            }
                        }
                    }
                } else {
                    // split只有一位，则已经匹配了
                    isMatchSplit = true;
                }
            }
            if (isMatchSplit) {
                byte[] part = new byte[i - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;

    }


    /**
     * 使用私钥进行解密
     */
    public static byte[] decryptByPrivateKey(byte[] encrypted, byte[] privateKey) throws Exception {
        // 得到私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PrivateKey keyPrivate = kf.generatePrivate(keySpec);

        // 解密数据
        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
        cp.init(Cipher.DECRYPT_MODE, keyPrivate);
        byte[] arr = cp.doFinal(encrypted);
        return arr;
    }

    /**
     * 私钥解密
     *
     * @param data    待解密数据
     * @param pri_key 私钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    public static byte[] decryptByPriKey(String data, String pri_key) throws Exception {
        // 私匙解密  
        byte[] pri_key_bytes = Base64.decodeBase64(pri_key);
        byte[] design = decryptByPriKey(Base64.decodeBase64(data), pri_key_bytes);
        return design;
    }


    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String datastr = "天街小雨润如酥，草色遥看近却无。最是一年春好处，绝胜烟柳满皇都。aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println("待加密数据：\n" + datastr);
        Map<String, String> map = initKey();


        //获取密钥对
//        String pub_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMSsDmn8wTUxwY23yetw1lUiPv64jEPuf9uNCkS2ZQtuwj4Ssl8SjxspEJd1l3lC06Lyw5YJ7gdhrH7+8iJV1MwfQefQ+B54uzwIOmMDGa0XlcAwL8dtA9Ob/H5VMPwj1RKsBiwJK4gkuBOdz8ZvW7N4N+wE4p9NcFJVWZC57xIdAgMBAAECgYAfXyq1cWIIcDVlu8lzyv4Fen799sY5F9RBW1AmAcpAdpx5dlYJoFY/iN9iqZlN+ID13y+fwVm8x7HSWCybmYFl/jEz1tesMEahgG48NKRV96c1vHgNixax1/w5CQkFIarm1DIsPi4BRIX3+vdHK5TH+6XXRMDZbPJe4Gx4hpU5AQJBAPdkrwP6ezMrs12cA5/380Ap0NMFyFAaSmapy7GHJb5+mjfqvE5N8/gYsUsGHGwmTluZKcVGOZHypWW/cjlicqECQQDLg6SlVPAE5ETCVGcOGGfOYZEkHJOhb85+S912gXoO8UXiCOmfrXLO8wYHYdSmZjw0uIwEWLUg1AZ+lI/CSCn9AkEAjzX3ooPzobGgiYXxCz+Lzw7l1eK5DLXLcBbG1aP4k4fSWqBGFcZGfs48g8Or3GdoYNoPNiXq2bPvTzE+PD3jQQJBAIPCYRBhY1vnZdTizC3GAz8Mz+kvTy1Ps8L03xbgUOPntTTYTFkC9Lejg5236vMocYY4jP4raGkunF3LVR+VlQkCQQDmG0Y1nFhsMKdutuHgQAJQY31r642RVLfoTvOmkxiTvYbWLtDBOdza8k0HzSk5E3UBawtEgbCuMy75pQRyL3ss";
//        String pri_key = "MIICXgIBAAKBgQDErA5p/ME1McGNt8nrcNZVIj7+uIxD7n/bjQpEtmULbsI+ErJfEo8bKRCXdZd5QtOi8sOWCe4HYax+/vIiVdTMH0Hn0PgeeLs8CDpjAxmtF5XAMC/HbQPTm/x+VTD8I9USrAYsCSuIJLgTnc/Gb1uzeDfsBOKfTXBSVVmQue8SHQIDAQABAoGAH18qtXFiCHA1ZbvJc8r+BXp+/fbGORfUQVtQJgHKQHaceXZWCaBWP4jfYqmZTfiA9d8vn8FZvMex0lgsm5mBZf4xM9bXrDBGoYBuPDSkVfenNbx4DYsWsdf8OQkJBSGq5tQyLD4uAUSF9/r3RyuUx/ul10TA2WzyXuBseIaVOQECQQD3ZK8D+nszK7NdnAOf9/NAKdDTBchQGkpmqcuxhyW+fpo36rxOTfP4GLFLBhxsJk5bmSnFRjmR8qVlv3I5YnKhAkEAy4OkpVTwBOREwlRnDhhnzmGRJByToW/OfkvddoF6DvFF4gjpn61yzvMGB2HUpmY8NLiMBFi1INQGfpSPwkgp/QJBAI8196KD86GxoImF8Qs/i88O5dXiuQy1y3AWxtWj+JOH0lqgRhXGRn7OPIPDq9xnaGDaDzYl6tmz708xPjw940ECQQCDwmEQYWNb52XU4swtxgM/DM/pL08tT7PC9N8W4FDj57U02ExZAvS3o4Odt+rzKHGGOIz+K2hpLpxdy1UflZUJAkEA5htGNZxYbDCnbrbh4EACUGN9a+uNkVS36E7zppMYk72G1i7QwTnc2vJNB80pORN1AWsLRIGwrjMu+aUEci97LA==";
        // 公匙加密
        String pubKeyStr = RSAUtil.encryptByPubKey(datastr,"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJyRrK3FjcJWOEwhkYIPDspQXYpaMAoipsI/JQP4IXaxhdOv1tsf9ijBG9/jGoMnSRzGXZgd3LM3DdRpvP4Id30frzX3F5evmFHiO+874mZ7K+dzvdFL6GcjAZP6KB4UXEY1XQcHnmDr8d/uaowtMRCF4hWJe/n9tPe42mQHs9EwIDAQAB");
        System.out.println("公匙加密结果：\n" + pubKeyStr);
        // 私匙解密
        byte[] bytes = RSAUtil.decryptByPriKey(pubKeyStr, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAInJGsrcWNwlY4TCGRgg8OylBdilowCiKmwj8lA/ghdrGF06/W2x/2KMEb3+MagydJHMZdmB3cszcN1Gm8/gh3fR+vNfcXl6+YUeI77zviZnsr53O90UvoZyMBk/ooHhRcRjVdBweeYOvx3+5qjC0xEIXiFYl7+f2097jaZAez0TAgMBAAECgYBE+lmgXwlZRJp6ttTrQGp8fezcVaexxH1qX+CKDhEpeiLbYZHH3clVY3vqWpwvcPrslqAScLJBbQI+tH+CZQxL0Fov34Aua5qPRqof9D9u23coeu3dYO5In3Q9lrwiXv26cqinc6cpx3M1F17OpWXrIYvQlalQqaz/mPimXX4rCQJBANzt1ijet157MgWa9C2rRn8AcW33XqBFU3bd2ztbA9HCgvkJ3rK3ZeHO9/cPlTWhEmXWyrOqIPcteSBDQqwbQM8CQQCfqHcAb/1n7jOANMhyEwGoFvbmruHDErK07w+zKgdJTotr0UDR0Ni3WdcX+Bzvx0nBiYOvjGslMqFGWpm2v+h9AkEAvsuPhiBBUBEos/qMIdymtwuU6hkV2WfFmwQiTvJdLAvFvHkvoDwOeqKZNv54J6aBEv4adGraqVzWHGy56ZRntQJAIgQXjp1NpTYH/PnB9yP7h1+VLSL3cMNsFcaVVrvOn5y/cbI8mDdh5PacMDwpliCkozp0NxO4xE0cNUwaUehjVQJAC0THUjKTi/rX0ZDL9WpNNA+wyiuJWrPtadi+ywBX91PJ5nsEsBPPg64guy3WIOrhBdIBl1ipGZZxt09Ah1JHvw==");
        System.out.println("私匙解密结果：\n" + new String(bytes));

    }

//
//    /**
//     * @param args
//     */
//    @SuppressWarnings("static-access")
//    public static void main(String[] args) throws Exception {
////        String datastr = "天街小雨润如酥，草色遥看近却无。最是一年春好处，绝胜烟柳满皇都。aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
////        System.out.println("待加密数据：\n" + datastr);
//        //获取密钥对
////        String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCH2m+ktKtj0+qwKBB08jKtYKr+oir52ZpYr3eA9Z2pIXXpFFh+UfJLWkgwFSGh7SV2Bf9wBB5+Yd1RH60PjljkpdEE2MaWjCnd8pCelhbDNeUAgnu00gm97BV9e8QsNYpZ/XBklIUXn2JNnuyoIgajILD8uNAvE0Pcg9r7W1RyzQIDAQAB";
//        String pri_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK6nzBVzKRZKTLw69MEGg0a4D21moRZsQ3Nwc2wzfLvXhOnyXdbNCt59fG0RWwA7gaEI69hEudzA+zxojKE8kYxFNJU/ZR3S0o7U6eJIPmYvestvLDugBG7nBpW7GYcdPqOYwQp4gdQDpsxw8sffAg+2aMYX6E6qL4H/NhQVZLtBAgMBAAECgYEpEMSMRZHDTzB4MI+ERCUBL31XHoKhPE7muWm2Juv82amDfUxhmT/lPNGQ7nv8U8GArNGRPeWKmWhpFXb9YTmiQ2Dpsilyt7H+ctd+cB8pSzbU4/1hGs/sFsCzgo27+2lgTwkLJkVc0FZrKfUqT9kqlmt29PkGa/4u1LyP4uCKaUCQQDWDgf00LDt6DVf4JjOuOvjZd5+3RkyqR3uJRiet4Y0xve3hMTbnaa1b5EkOzKQDCIGjobGE2PI+i16HA56cGTAkEA0OFQePuWmHlCeJrepgw9G6Oe1GLFG0YLY2Jt4nXW365r3Z/dvZx3zhOv783rXKs0McHkPBwf35R/AEoHXULkWwJAJfJC0tGUK/i4TZDhRfReTOeoM9E6QFLerXMCFFDwh7al/3CX/V7LSOrITh55+7i5YcdUea0rQq7Y+DaGfp3D5QJAY2zMXDoNLdiSTkwRbOJod+6DH9C6T+HDjB884150RD6IQ0GhEmlMT9nwHK49Gw9tO2A0Sfl+At8BEw4gyji/wJAO2wynMkhnOQiEpUdmY9WGZbqF8ouM/eWzmHpBwh3xW8WIX9tRbsw3RDejQAPcVfw+O5k+FWiZ2sPVoKvEefROQ==";
//        // 公匙加密
////        String pubKeyStr = RSATest.encryptByPubKey(datastr, pub_key);
////        System.out.println("公匙加密结果：\n" + pubKeyStr);
//        // 私匙解密
//        byte[] priKeyStr = RSATest.decryptByPriKey("kOpcqSODDYd/pneADXg/XjAX4GB59WL3d7lxgQCNmUAMAYZRV8D8vjjgqTUvXo3pPlLVSaSV5i1QWCblsCeXBHjL1W5FJEvLAqEQC+4jbzuJDpU8mMTNjkTszKe4sNtSAeJSW++wadK3tN/p/3nf1OWUKl58zilgWtlCmrnNlME=", pri_key);
//        System.out.println("私匙解密结果：\n" + priKeyStr);
//    }


}  