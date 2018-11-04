package com.zp.worm;

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
 * Time: 2018/11/2-17:00.
 */
public class Index {

    public static void main(String[] args) {

        Document document;
        try {
//            获取页面首页
            document = Jsoup.connect("http://m.511wa.com/shaonv")
                    .userAgent("Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1")
                    .timeout(5000)
                    .get();
//            String shaonv = getAjaxContent("http://m.511wa.com/shaonv");
//            document = Jsoup.parse(shaonv);
            Elements uls = document.getElementsByClass("pic pic1");
            System.out.println(uls);
            for (Element ul : uls) {

//                获取ul下的所有a标签
                Elements as = ul.select("a");

//                遍历a标签,获取图集的对应url
                for (Element a : as) {
                    String url = "http://m.511wa.com" + a.attr("href");
                    Document sonDocument = Jsoup.connect(url).get();
//                    String sonShaonv = getAjaxContent(url);
//                    Document sonDocument = Jsoup.parse(sonShaonv);
                    System.out.println(sonDocument);
                    Index index = new Index();

//                    为图集新建文件夹命名
                    String path = "D:\\下载\\图片\\" + sonDocument.title();

//                    获取图片集前缀url
                    String frontUrl = url.substring(0, url.lastIndexOf("/") + 1);

//                    获取页面中的页数选择下拉框
                    Elements option = sonDocument.getElementById("dedepagetitles").select("option");

//                    遍历下拉框,获取所有页面中的图片地址,并用文件流保存
                    for (Element element : option) {
                        String imgUrl = element.attr("value");
                        Document next;
                        try {
                            next = Jsoup.connect(frontUrl + imgUrl).get();
                        } catch (Exception e) {
                            continue;
                        }

                        Element nextDiv = next.getElementById("nr234img");
                        Elements nextUrl = nextDiv.select("img");
                        index.downloadImg(nextUrl,path);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 输入流下载图片
     *
     * @param url img节点集合
     */
    private void downloadImg(Elements url, String path) {

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        } else {
            return;
        }

        for (Element element : url) {
            String URL = element.attr("src");
            System.out.println(URL);
            java.net.URL imgURL;
            try {
                imgURL = new URL(URL);
                String imageName = URL.substring(URL.lastIndexOf("/") + 1);
                InputStream in = imgURL.openStream();
                FileOutputStream fo = new FileOutputStream(new File(path + "\\" + imageName));//文件输出流
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
