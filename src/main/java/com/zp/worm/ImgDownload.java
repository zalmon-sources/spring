package com.zp.worm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by peng.zhang
 * Time: 2018/11/1-15:46.
 */
public class ImgDownload {

    public static void main(String[] args) {

        for (int i = 0; i <= 52; i++) {
            String URL;
            if (i < 10) {
                URL = "http://pm.weakcn.com/uploadfile/gx02/181026/200" + i + ".jpg";
            } else if (i < 100 && i > 10) {
                URL = "http://pm.weakcn.com/uploadfile/gx02/181026/20" + i + ".jpg";
            } else {
                URL = "http://pm.weakcn.com/lifanacgup/lifanacg//20180223/7/" + i + "d.jpg";
            }
            java.net.URL imgURL;
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
