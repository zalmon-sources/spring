package com.zp.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-15:34.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
//        Person person = ctx.getBean(Person.class); // 不能有多个装配
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
        person.print();
        System.out.println(person.getStudent().getNumber());
    }

}
