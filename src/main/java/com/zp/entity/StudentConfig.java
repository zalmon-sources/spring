package com.zp.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by peng.zhang
 * Description: 通过配置类进行装配
 * Time: 2019/8/12-15:03.
 */
@Configuration // 配置类
@ComponentScan // 扫描当前包下的注解
@ImportResource("classpath:applicationContext.xml") // 导入xml配置
public class StudentConfig {

    @Bean
    public Student student(){
        Student student = new Student();
        student.setNumber("20141043011");
        return student;
    }

    @Bean
    public Person person(Student student){
        Person person = new Person("lanlan", "female", 23);
        person.setStudent(student);
        return person;
    }
}
