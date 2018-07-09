package com.zp.annotation;

import com.zp.annotation.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-16:23.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowired.xml");

        LoginController loginController = (LoginController) ctx.getBean("loginController");

        loginController.save();

    }
}
