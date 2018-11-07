package com.zp.worm;

import java.io.IOException;

/**
 * Created by peng.zhang
 * Time: 2018/11/7-16:59.
 */
public class Phantomjs {

    public static void main(String[] args) {

        try {

            String result = JsUtil.getAjaxContent("http://m.511wa.com/shaonv/2018/0723/5431.html");
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
