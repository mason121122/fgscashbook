package com.fgs.fgscashbook;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fgs.fgscashbook.support.BsRuntimeException;
import com.fgs.fgscashbook.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import springfox.documentation.spring.web.json.Json;

import javax.xml.stream.StreamFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Test {

    public static final int connectionRequestTimeout = 2 * 1000;
    public static final int connectTimeout = 3 * 1000;
    public static final int socketTimeOut = 10 * 1000;


    public static void main(String[] args) throws IOException {
        String path = "E:\\squareMapping(1).csv";
        String CHATBOT_WEBHOOK = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=3deb3246-e0e8-49bc-a1b4-2c9e30cfc43d";
        String key = "3deb3246-e0e8-49bc-a1b4-2c9e30cfc43d";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/upload_media?key=3deb3246-e0e8-49bc-a1b4-2c9e30cfc43d&type=file";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(url);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addTextBody("key", "3deb3246-e0e8-49bc-a1b4-2c9e30cfc43d", ContentType.TEXT_PLAIN);
//        builder.addTextBody("type", "file", ContentType.TEXT_PLAIN);
        // 把文件加到HTTP的post请求中
        File f = new File(path);
        builder.addBinaryBody(
                "type",
                new FileInputStream(f),
                ContentType.APPLICATION_OCTET_STREAM,
                f.getName()
        );
        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        Map<String , Object> sResponse=JSONObject.parseObject(EntityUtils.toString(responseEntity, "UTF-8"));
        if (null != response) {
            response.getEntity().getContent().close();
        }
        if (response == null || response.getStatusLine ().getStatusCode() != 200) {
            throw new BsRuntimeException("推送机器人消息异常");
        }
        System.out.println("Post 返回结果"+sResponse.get("media_id"));
//        HttpClient httpclient = createHttpClient();
//        Map<String , Object > map = new HashMap<>();
//        Map<String,String> map1 = new HashMap<>();
//        map1.put("media_id","3-DiytQdPlIwXAm7Q6MyMQoqwtDBYO3mHSMplo2VaDO0");
//        map.put("msgtype","file");
//        map.put("file",map1);
//        HttpPost httppost = new HttpPost(CHATBOT_WEBHOOK);
//        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
//        StringEntity se = new StringEntity(JSON.toJSONString(map), "utf-8");
//        log.info(JSON.toJSONString(map).toString());
//        httppost.setEntity(se);
//        HttpResponse response = httpclient.execute(httppost);
//        if (null != response) {
//            response.getEntity().getContent().close();
//        }

    }

    private static HttpClient createHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeOut)
                .build();

        return HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnTotal(24)
                .setMaxConnPerRoute(48)
                .build();
    }
}
