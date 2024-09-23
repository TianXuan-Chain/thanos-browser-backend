package com.netease.thanos.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {
    private static Log log = LogFactory.getLog(DateUtil.class);

    public static final String IP_REG = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    public static final int DEFAULT_READ_TIMEOUT = 5000;

    public static final int DEFAULT_CONNECT_TIMEOUT = 5000;

    public static final String DEFAULT_CHARSET = "UTF-8";

    public static final int DEFAULT_RETRY_TIME = 1;                                                                                           // 打开URL失败默认重新连接的次数

    public static String openUrlReturnMoreMessage(String strUrl, String charSet) {
        return openUrlReturnMoreMessage(strUrl, charSet, DEFAULT_CONNECT_TIMEOUT, DEFAULT_READ_TIMEOUT);
    }

    public static String openUrlReturnMoreMessage(String strUrl) {
        return openUrlReturnMoreMessage(strUrl, DEFAULT_CHARSET, DEFAULT_CONNECT_TIMEOUT, DEFAULT_READ_TIMEOUT);
    }

    public static String openUrlReturnMoreMessage(String strUrl, int connectTimeout, int readTimeout) {
        return openUrlReturnMoreMessage(strUrl, DEFAULT_CHARSET, connectTimeout, readTimeout);
    }

    /**
     * 本方法用于调用远程的接口
     * <p>
     * 接口的url
     *
     * @return 返回调用接收Url后的返回值
     */
    public static String openUrlReturnMoreMessage(String strUrl, String charSet, int connectTimeout, int readTimeout) {
        InputStream is = null;

        try {

            URL webUrl = new URL(strUrl);
            HttpURLConnection httpConn = (HttpURLConnection) webUrl.openConnection();
            httpConn.setConnectTimeout(connectTimeout);
            httpConn.setReadTimeout(readTimeout);
            if (httpConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                log.warn(strUrl + "|ResponseCode=" + httpConn.getResponseCode());
                return null;
                // throw new NetConnectionException("Connect to url[" + strUrl + "] error, response code is "
                // + httpConn.getResponseCode());

            }
            is = httpConn.getInputStream();
            return getReturnValueFromInputStream(is, charSet);
        } catch (Exception e) {
            log.error("webUrl.openConnection error ", e);
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e1) {
                    log.error("openUrl(String strUrl)", e1);
                }
            }
        }
    }

    /**
     * 本方法用于调用远程的接口
     * <p>
     * 接口的url
     *
     * @return 返回调用接收Url后的返回值
     */
    public static String postToUrlReturnMoreMessage(String strUrl, Map<String, String> params, int connectTimeout, int readTimeout) {
        return postToUrlReturnMoreMessage(strUrl, params, DEFAULT_CHARSET, connectTimeout, readTimeout);
    }

    /**
     * 本方法用于调用远程的接口
     * <p>
     * 接口的url
     *
     * @return 返回调用接收Url后的返回值
     */
    public static String postToUrlReturnMoreMessage(String strUrl, Map<String, String> params, String charSet,
                                                    int connectTimeout, int readTimeout) {
        InputStream is = null;
        OutputStream os = null;
        StringBuilder postParams = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                postParams.append("&").append(entry.getKey()).append("=").append(urlEncode(entry.getValue()));
            }
        }

        try {
            URL webURL = new URL(strUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) webURL.openConnection();
            httpURLConnection.setDoOutput(true);// 打开写入属性
            httpURLConnection.setDoInput(true);// 打开读取属性
            httpURLConnection.setRequestMethod("POST");// 设置提交方法
            httpURLConnection.setConnectTimeout(connectTimeout);// 连接超时时间
            httpURLConnection.setReadTimeout(readTimeout);
            httpURLConnection.connect();
            os = httpURLConnection.getOutputStream();
            os.write(postParams.toString().getBytes());

            os.flush();

            if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                log.warn(strUrl + "|ResponseCode=" + httpURLConnection.getResponseCode());
                return null;
            }
            is = httpURLConnection.getInputStream();
            return getReturnValueFromInputStream(is, charSet);
        } catch (Exception e) {
            log.error(" webURL.openConnection error", e);
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e1) {
                    log.error("openUrl(String strUrl)", e1);
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    log.error("openUrl(String strUrl)", e1);
                }
            }
        }
    }

    /**
     * 从输入流获取所有数据并以指定字符集拼装成字符串
     *
     * @param is
     * @param charSet
     * @return
     */
    public static String getReturnValueFromInputStream(InputStream is, String charSet) {
        if (StringUtils.isBlank(charSet)) {
            charSet = DEFAULT_CHARSET;
        }

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, charSet));
            char[] temp = new char[1024];
            int charCount = 0;
            while ((charCount = br.read(temp)) != -1) {
                sb.append(new String(temp, 0, charCount));
            }
            return sb.toString();
        } catch (Exception e) {
            log.fatal(e.getMessage(), e);
            return null;
        }
    }

    public static String urlEncode(String source) {
        return urlEncode(source, null);
    }

    public static String urlEncode(String source, String encode) {
        if (StringUtils.isBlank(source)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.isBlank(encode)) {
            encode = DEFAULT_CHARSET;
        }
        try {
            return URLEncoder.encode(source, encode);
        } catch (UnsupportedEncodingException e) {
            log.fatal("不支持的编码，source:" + source + ",encode:" + encode, e);
            return StringUtils.EMPTY;
        }
    }

    public static String urlDecode(String source) {
        return urlEncode(source, null);
    }

    public static String urlDecode(String source, String encode) {
        if (StringUtils.isBlank(source)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.isBlank(encode)) {
            encode = DEFAULT_CHARSET;
        }
        try {
            return URLEncoder.encode(source, encode);
        } catch (UnsupportedEncodingException e) {
            log.fatal("不支持的编码，source:" + source + ",encode:" + encode, e);
            return StringUtils.EMPTY;
        }
    }


    public static void main(String[] args) {
        System.out.println("xiaotaoli999@163.com" + System.currentTimeMillis());
    }

}
