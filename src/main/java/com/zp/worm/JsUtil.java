package com.zp.worm;

import java.io.*;


/**
 * Created with IntelliJ IDEA.
 * <p>
 * User: lsz
 * <p>
 * Date: 14-4-22
 * <p>
 * Time: 下午1:17
 * <p>
 * utils for http
 */

public class JsUtil {

    private static String projectPath = System.getProperty("user.dir");
    private static String jsPath = projectPath + File.separator + "worm.js";
    private static String exePath = projectPath + File.separator + "phantomjs" + File.separator + "bin" + File.separator + "phantomjs.exe";

    public static String getAjaxContent(String url) throws IOException {

        Runtime rt = Runtime.getRuntime();

        Process p = rt.exec(exePath + " " + jsPath + " " + url);

        InputStream is = p.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringBuilder sbf = new StringBuilder();

        String tmp = "";

        while ((tmp = br.readLine()) != null) {

            sbf.append(tmp);

        }

        return sbf.toString();

    }


    public static void main(String[] args) throws IOException {

        String a = getAjaxContent("https://www.bilibili.com");
        System.out.println(a);

    }

}
