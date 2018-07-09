package com.zp.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-15:34.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
        System.out.println(person.getStudent().getNumber());
    }
}
