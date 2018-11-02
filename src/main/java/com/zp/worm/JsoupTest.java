package com.zp.worm;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by peng.zhang
 * Time: 2018/11/1-14:58.
 */
public class JsoupTest {

    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("http://m.511wa.com/shaonv/2018/1027/5639.html").get();

            System.out.println(document);
            Element div = document.getElementById("nr234img");
            Elements url = div.select("img");
            JsoupTest jsoupTest = new JsoupTest();
            jsoupTest.downloadImg(url);

            Elements option = document.getElementById("dedepagetitles").select("option");
            for (Element element : option) {
                String imgUrl = element.attr("value");
                Document next = Jsoup.connect("http://m.511wa.com/shaonv/2018/1027/" + imgUrl).get();
                Element nextDiv = next.getElementById("nr234img");
                Elements nextUrl = nextDiv.select("img");
                jsoupTest.downloadImg(nextUrl);
                System.out.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输入流下载图片
     * @param url img节点集合
     */
    public void downloadImg(Elements url){
        for (Element element : url) {
            String URL=element.attr("src");
            System.out.println(URL);
            java.net.URL imgURL = null;
            try {
                imgURL = new URL(URL);
                String imageName = URL.substring(URL.lastIndexOf("/") + 1);
                InputStream in = imgURL.openStream();
                FileOutputStream fo = new FileOutputStream(new File("D:\\下载\\图片\\" + imageName));//文件输出流
                byte[] buf = new byte[1024];
                int length;
                System.out.println("开始下载:" + URL);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                //关闭流
                in.close();
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
