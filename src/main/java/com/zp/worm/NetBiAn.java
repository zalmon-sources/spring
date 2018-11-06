package com.zp.worm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by peng.zhang
 * Time: 2018/11/2-17:00.
 */
public class NetBiAn {

    public static void main(String[] args) {

        Document document;
        try {
//            获取页面首页
            String basePath = "http://www.netbian.com";
            document = Jsoup.connect(basePath)
                    .timeout(5000)
                    .get();

            Elements divs = document.getElementsByClass("list");
            Elements as = divs.get(0).select("a");
            for (Element a : as) {
                if (a.attr("href").contains("http")) {
                    continue;
                }
                String url = basePath + a.attr("href");
                Document detail = Jsoup.connect(url).get();
                Elements picDiv = detail.getElementsByClass("pic-down");
                Element picA = picDiv.get(0).select("a").get(0);
                String imgUrl = basePath + picA.attr("href");
                Document imgHtml = Jsoup.connect(imgUrl).get();
                Elements tbody = imgHtml.select("tbody").select("img");
                String imgPath = tbody.get(0).attr("src");
                downloadImg(imgPath,tbody.get(0).attr("alt") + ".jpg");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 输入流下载图片
     */
    private static void downloadImg(String URL,String imageName) {

        String path = "D:\\下载\\";
        java.net.URL imgURL;
        try {
            imgURL = new URL(URL);
            InputStream in = imgURL.openStream();
            FileOutputStream fo = new FileOutputStream(path + imageName);//文件输出流
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
