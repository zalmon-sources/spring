package com.zp.entity;

import com.zp.config.StudentConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-15:34.
 */
public class Main {

    public static void main(String[] args) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
//        Person person = ctx.getBean(Person.class); // 不能存在多个Person定义
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
        person.studying("1");
        System.out.println(person.getStudent().getNumber());

        Object lion = ctx.getBean("Lion");
        System.out.println(lion);

        System.out.println("GitTest");
    }

}
