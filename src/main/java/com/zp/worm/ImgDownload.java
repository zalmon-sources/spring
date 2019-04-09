package com.zp.worm;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

/**
 * Created by peng.zhang
 * Time: 2018/11/1-15:46.
 */
public class ImgDownload {

    static HttpURLConnection htpcon = null;
    static InputStream in = null;
    static FileOutputStream fo = null;
    static java.net.URL imgURL;
    static String URL;
    static String imageName;

    public static void main(String[] args) {

        for (int i = 18; i <= 196; i++) {
            if (i < 10) {
                URL = "http://pm.jxmfxs.com/lifanacgup/lifanacg/20170710/2/00" + i + ".jpg";
            } else if (i < 100 && i >= 10) {
                URL = "http://pm.jxmfxs.com/lifanacgup/lifanacg/20170710/2/0" + i + ".jpg";
            } else {
                URL = "http://pm.jxmfxs.com/lifanacgup/lifanacg/20170710/2/" + i + ".jpg";
            }

            try {
                imgURL = new URL(URL);
                imageName = URL.substring(URL.lastIndexOf("/") + 1);

                downloadImg();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            in.close();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过URL获取网络连接,下载图片,失败将尝试重新连接
     */
    public static void downloadImg(){
        try {
            System.out.println("获取连接中...");
            htpcon = (HttpURLConnection) imgURL.openConnection();
            htpcon.setRequestMethod("GET");
            htpcon.setDoOutput(true);
            htpcon.setDoInput(true);
            htpcon.setUseCaches(false);
            htpcon.setConnectTimeout(5000);
            htpcon.setReadTimeout(5000);
            in = htpcon.getInputStream();
            String downloadUrl = "D:\\下载\\图片\\" + imageName;
            fo = new FileOutputStream(new File(downloadUrl));//文件输出流
            byte[] buf = new byte[1024];
            int length;
            System.out.println("开始下载:" + URL);
            while ((length = in.read(buf, 0, buf.length)) != -1) {
                fo.write(buf, 0, length);
            }
            if (isJPEG(downloadUrl)) {
                System.out.println("下载完成:" + URL);
            } else {
                System.out.println("下载图片不完整,正在重新下载...");
                downloadImg();
            }
        }catch (IOException e) {
            System.out.println("连接超时,正在重新连接...");
            downloadImg();
        }
    }

    /**
     * 检测图片是否完整
     * @param fileName
     * @return
     */
    private static Boolean isJPEG(String fileName) {
        boolean canRead = false;
        try(ImageInputStream iis = ImageIO.createImageInputStream(new File(fileName))){
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
            while (readers.hasNext()) {
                ImageReader reader = readers.next();
                reader.setInput(iis);
                reader.read(0);
                canRead = true;
                break;
            }
        }catch (Exception e){

        }
        return canRead;
    }
}
