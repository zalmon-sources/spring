package com.zp.worm;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WormTest {

    private static RequestConfig requestConfig = RequestConfig //请求设置
            .custom()
            .setConnectionRequestTimeout(5000) //从连接池获取连接超时时间
            .setConnectTimeout(5000) //连接超时时间
            .setSocketTimeout(5000).build(); //套接字超时时间

    private static HttpClientBuilder builder = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .setMaxConnTotal(5000); //设置最大连接数

    private static CloseableHttpClient httpClient = builder.build();

    public static void main(String[] args) {

        //创建一个get请求
//        HttpGet httpGet = new HttpGet("https://api.douban.com/v2/book/1220562");

        //创建一个get请求
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme("https")
                    .setHost("bilibili.com")
//                    .setPath("/v2/movie/in_theaters")
//                    .setParameter("city", "北京")
                    .build();
        } catch (URISyntaxException e) {
            System.out.println("uri语法错误");
        }

        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {//判断状态码
                HttpEntity httpEntity = response.getEntity(); //获取返回body
                String result = EntityUtils.toString(httpEntity, "UTF-8");// 转成string
                System.out.println(result);

//                获取网页中所有的a标签
                Pattern pattern = Pattern.compile("<img\\b[^>]+\\bsrc=\"([^\"]*)\"[^>]*>([\\s\\S]*?)");
                Matcher matcher = pattern.matcher(result);

                while (matcher.find()) {
                    String newLink = matcher.group(0).trim(); // 链接
                    String img = newLink.substring(
                            newLink.indexOf("//") + 2,
                            newLink.indexOf("\"",newLink.indexOf("//"))
                    );
                    System.out.println(newLink);

                    if (newLink.contains(".jpg")) {
                        URL imgURL = new URL("https://"+img);
                        String imageName = img.substring(img.lastIndexOf("/") + 1);
                        InputStream in = imgURL.openStream();
                        FileOutputStream fo = new FileOutputStream(new File("D:\\下载\\图片\\" + imageName));//文件输出流
                        byte[] buf = new byte[1024];
                        int length;
                        System.out.println("开始下载:" + img);
                        while ((length = in.read(buf, 0, buf.length)) != -1) {
                            fo.write(buf, 0, length);
                        }
                        //关闭流
                        in.close();
                        fo.close();
                    }
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close(); //释放连接
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (httpClient != null) {
                    httpClient.close();//关闭客户端
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
