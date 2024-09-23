package com.netease.thanos.common.utils.httpUtil;


import com.alibaba.fastjson.JSONObject;
import com.netease.thanos.common.enums.HttpErrorCodeEnum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.nio.charset.Charset;


public class HttpClientUtil {
    private static Log log = LogFactory.getLog(HttpClientUtil.class);

    /**
     * 连接池管理对象
     */
    private static volatile PoolingHttpClientConnectionManager cm = null;

    /**
     * 指的是连接池内连接最大数:400
     */
    private static int MAX_CONNECTION_NUM = 400;


    /**
     * 一定要设置，路由指的是请求的系统，如访问 localhost:8080 和 localhost:8081 就是两个路由。
     * perRote 指的是每个路由的连接数，因为我目前只连接一个系统的进行数据同步，所以 perRote 设置和最大连接数一样
     * <p>
     * 我们这里只有kylin一个地址，所以配置与MAX_CONNECTION_NUM一样
     */
    private static int MAX_PER_ROUTE = 400;

    public static ClientConfig clientConfig = new ClientConfig();

    static {
        clientConfig.setConnectTimeout(3000);
        clientConfig.setSocketTimeout(6000);
    }

    /**
     * @param URL
     * @param param
     * @return
     * @throws Exception
     */
    public static ServiceResponse doPost(String URL, String param) throws Exception {
        HttpPost httpPost = new HttpPost(URL);// 创建httpPost

        CloseableHttpResponse response = null;
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            //设置参数
            StringEntity stringEntity = new StringEntity(param, "UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            CloseableHttpClient httpClient = getHttpClient(getConfig(clientConfig));
            // 执行请求
            response = httpClient.execute(httpPost);
            serviceResponse.setData(EntityUtils.toString(response.getEntity(), Charset.defaultCharset()));
            serviceResponse.setError_code(HttpErrorCodeEnum.SUCCESS.getCode().toString());

            EntityUtils.consume(response.getEntity());
        } catch (ConnectTimeoutException e) {
            serviceResponse.setError_message(HttpErrorCodeEnum.ERROR_CONNECTTIMEOUT.getDesc().toString());
            serviceResponse.setError_code(HttpErrorCodeEnum.ERROR_CONNECTTIMEOUT.getCode().toString());
            log.error("URL=" + URL + " 连接超时.", e);
        } catch (SocketTimeoutException e) {
            serviceResponse.setError_message(HttpErrorCodeEnum.ERROR_SOCKETTIMEOUT.getDesc().toString());
            serviceResponse.setError_code(HttpErrorCodeEnum.ERROR_SOCKETTIMEOUT.getCode().toString());
            log.error("URL=" + URL + " 响应超时.", e);
        } catch (Exception e) {
            serviceResponse.setError_message(HttpErrorCodeEnum.ERROR_OTHER.getDesc().toString());
            serviceResponse.setError_code(HttpErrorCodeEnum.ERROR_OTHER.getCode().toString());
            log.error("URL=" + URL + " ERROR.", e);
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                }
            } catch (IOException e) {
                log.error("URL=" + URL + " 关闭连接,释放资源ERROR.", e);
            }
        }

        return serviceResponse;
    }


    public static ServiceResponse doGet(String url) throws Exception {
        URI URL = new URIBuilder(url).build();

        CloseableHttpClient client = null;
        CloseableHttpResponse httpResponse = null;
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            client = getHttpClient(getConfig(clientConfig));
            HttpGet req = new HttpGet(URL);
            httpResponse = client.execute(req);
            if (httpResponse.getStatusLine().getStatusCode() != 200)
                throw new Exception("http status is not right code is "+ httpResponse.getStatusLine().getStatusCode());

            HttpEntity resEntity = httpResponse.getEntity();
            String result = EntityUtils.toString(resEntity, Charset.defaultCharset());

            serviceResponse.setData(result);
            serviceResponse.setError_code(HttpErrorCodeEnum.SUCCESS.getCode().toString());

            EntityUtils.consume(httpResponse.getEntity());
        } catch (ConnectTimeoutException e) {
            serviceResponse.setError_message(HttpErrorCodeEnum.ERROR_CONNECTTIMEOUT.getDesc().toString());
            serviceResponse.setError_code(HttpErrorCodeEnum.ERROR_CONNECTTIMEOUT.getCode().toString());
            log.error("URL=" + URL + " 连接超时.", e);
        } catch (SocketTimeoutException e) {
            serviceResponse.setError_message(HttpErrorCodeEnum.ERROR_SOCKETTIMEOUT.getDesc().toString());
            serviceResponse.setError_code(HttpErrorCodeEnum.ERROR_SOCKETTIMEOUT.getCode().toString());
            log.error("URL=" + URL + " 响应超时.", e);
        } catch (Exception e) {
            serviceResponse.setError_message(HttpErrorCodeEnum.ERROR_OTHER.getDesc().toString());
            serviceResponse.setError_code(HttpErrorCodeEnum.ERROR_OTHER.getCode().toString());
            log.error("URL=" + URL + " ERROR.", e);
        } finally {
            try {
                if (httpResponse != null) {
                    EntityUtils.consume(httpResponse.getEntity());
                    httpResponse.close();
                }
            } catch (IOException e) {
                throw new Exception("doGet response.close IOException,the e {}", e);
            }
        }
        return serviceResponse;
    }


    /**
     * 初始化连接池管理对象
     */
    public static PoolingHttpClientConnectionManager getPoolManager() {
        if (null == cm) {
            synchronized (HttpClientUtil.class) {
                if (null == cm) {
                    try {
                        LayeredConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
                        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                                .register("https", sslsf)
                                .register("http", new PlainConnectionSocketFactory())
                                .build();
                        cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
                        cm.setMaxTotal(MAX_CONNECTION_NUM);
                        cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
                    } catch (Exception e) {
                        log.error("HttpClientUtil.getPoolManager ERROR.", e);
                    }
                }
            }
        }
        return cm;
    }


    /**
     * 创建线程安全的HttpClient
     * <p>
     * 只要注入的连接池单例的就行
     *
     * @param config 客户端超时设置
     * @return
     */
    public static CloseableHttpClient getHttpClient(RequestConfig config) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config)
                .setConnectionManager(getPoolManager())
                .build();
        return httpClient;
    }


    private static RequestConfig getConfig(ClientConfig clientConfig) {
        if (clientConfig.getSocketTimeout() == 0 || clientConfig.getConnectTimeout() == 0) {
            return RequestConfig.custom()
                    .setConnectTimeout(ClientConfig.DEFAULT_CONNECT_TIMEOUT)
                    .setSocketTimeout(ClientConfig.DEFAULT_SOCKET_TIMEOUT)
                    .setConnectionRequestTimeout(ClientConfig.DEFAULT_CONNECT_REQUESTTIMEOUT).build();
        }

        return RequestConfig.custom()
                .setConnectTimeout(clientConfig.getConnectTimeout())
                .setSocketTimeout(clientConfig.getSocketTimeout())
                //连接不够用时等待超时时间，一定要设置，如果不设置的话，如果连接池连接不够用，就会线程阻塞。
                .setConnectionRequestTimeout(ClientConfig.DEFAULT_CONNECT_REQUESTTIMEOUT)//连接超时时间.
                .build();
    }


    public static void main(String[] asd) throws Exception {
        ServiceResponse serviceResponse = doPost("https://epay.163.com/api/real_name_check.htm?msg=eyJhY2NvdW50SWQiOiJnYXRlQHd5Yi4xNjMuY29tIiwiYWN0aW9uIjoicmVhbF9uYW1lX2NoZWNrIiwiaWRlbnRpdHlObyI6IjM3MjgzMDE5ODkwODA2MDQzOCIsImlkZW50aXR5VHlwZSI6IjAiLCJwbGF0Zm9ybUlkIjoiMjAxNjA2MjcxNVBUMTY4Nzg5OTEiLCJyZWFsTmFtZSI6IuWImOacrOm%2BmSIsInZlcnNpb24iOiIxLjAuMCJ9&msgType=JSON&sign=308205b406092a864886f70d010702a08205a5308205a1020101310e300c06082a864886f70d02050500300b06092a864886f70d010701a08203e8308203e4308202cca00302010202143ee22b30d03c7c6ec12ab03066371fe50dd6216a300d06092a864886f70d0101050500304f3119301706035504030c10e7bd91e69893e5ae9d5573657220434131123010060355040b0c09e59586e58aa1e983a8311e301c060355040a0c15e7bd91e69893e5ae9de69c89e99990e585ace58fb8301e170d3136313232333038323431325a170d3139313232333038323431325a3081823133303106092a864886f70d010901162432303136303632373135505431363837383939314063612e657061792e3136332e636f6d3114301206035504030c0b78647a61627a6a666c637331123010060355040b0c09e59586e58aa1e983a83121301f060355040a0c18e7bd91e69893e5ae9de69c89e69c89e99990e585ace58fb830820122300d06092a864886f70d01010105000382010f003082010a0282010100abe8dd410d5a911a39c7625161cfed93672948af7912cfe0de27bf7f29ac9f2d031a7ccc58432ef49c990ce61f2e67f1b027cb4036395ded7e9d91449b1ff989a443511008cecb1109ffd1241d499d9dbf750501b0748ca5aa1097ce5f8283a01300face4550f54b15f3d98f2d2d5bb2694b542514227851a0f1d3808eef18ebb0796d492cdd9294b3b8bcf8677645a8feb1f4713707b799db69f0a5e9011dd8d61c5e28bf94a198c16f2c6a4d8215be9778be3b10e7d581ddfa5cea3ec4528dcc7c21ef438fdeadf7cf722b5b142445b282cfe33d286819d1c376027dfdf7149f2dd482a5702e582afb8b65c4f92fde8765184bc8df1b1bd92fc2c6caefc95b0203010001a3818330818030090603551d1304023000300b0603551d0f0404030205a030660603551d1f045f305d305ba059a0578655687474703a2f2f746f7063612e69747275732e636f6d2e636e2f7075626c69632f697472757363726c3f43413d36443844394243363333334236363633334645353439414546393733463130363745373035393343300d06092a864886f70d0101050500038201010024bd11600499f28b48ded1d12c0f08be127a0c1aade53be5c17256f6db451efd65c98717ab9a4886270341b0c08decf66f6a8b0d15ef34eba986d4a0b54246f3b0b58b101dd22b79067ce823fdac90ba094551f2a7f43e5a0cb660965f44664f74c1aea9f386da02ad4ba8bcae24abcf62ad58f8a90915dceda8921a72d344973f99ad27dc9b73840826ddf195c65eba27de0fb6f037fced4ccd532fafdadafe70767b571291fd66aec1f72a29ab72fbe7918713e9975d02c42bcc6b7c5ec8422a90744a41d0c05f18f4ec7c20a9c9689f944066cfff0a084685c7a53aaddbb7cfee02adf3cd1e0f5c489b10e7c1f2f7e24232f564a6c5e8ff71a2ba48ee7ea7318201913082018d0201013067304f3119301706035504030c10e7bd91e69893e5ae9d5573657220434131123010060355040b0c09e59586e58aa1e983a8311e301c060355040a0c15e7bd91e69893e5ae9de69c89e99990e585ace58fb802143ee22b30d03c7c6ec12ab03066371fe50dd6216a300c06082a864886f70d02050500300d06092a864886f70d0101010500048201006c89bf31db91f19031cda7998f2cc0aca6430dfdfcf035f2f2fd1819e06dc2a9347224dcde20722eb2984e80146519e864cc9446808a5a0d673c2fb4ea8deefae623e06928aefe709851cdc3ab14a1f1109ab55b0830436cddfb6a64713e6c07cb47ba13819bfffc1586331c1a00d9ba3801f12a52a62908f173696e49f05c6a3e9bc44a87f47f59931a8a49b648f4c0c622af01511b69bee485e013684c4f7702d94a4ed9102ba41a4da1a4f03b44a68fd2a9f009e9b30805a2bd55bf7b1d559a9ba3a41cd34a80a00594eecbc8eb72210288f07e03d306a08713ad6bc783c7949f452ecd9952f2b2f3a6183f6beeb4966f4480fe2f871881e0b6ce50dbea08",
                "");

        System.out.println(JSONObject.toJSONString(serviceResponse));
    }

}
