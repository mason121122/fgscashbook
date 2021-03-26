package com.fgs.fgscashbook;


import com.csvreader.CsvWriter;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class HttpClint {
    public static final int connectionRequestTimeout = 2 * 1000;
    public static final int connectTimeout = 3 * 1000;
    public static final int socketTimeOut = 10 * 1000;
    public static HttpClient httpclient = createHttpClient();

    private static HttpClient createHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeOut)
                .build();

        return HttpClients.custom()
                .setRetryHandler((e, executionCount, contr) -> executionCount < 4)
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnTotal(24)
                .setMaxConnPerRoute(48)
                .build();
    }

    public static void main(String[] args) {
        try {
//            HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet("http://baidu123123123123asdasd.com");

            for (int i = 0; i < 100; i++) {
                HttpResponse response = httpclient.execute(request);
                /**请求发送成功，并得到响应**/
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    /**读取服务器返回过来的json字符串数据**/
                    String strResult = EntityUtils.toString(response.getEntity());
                }
            }
        } catch (IOException e) {
            System.out.println("出错啦");
        }
    }
}
