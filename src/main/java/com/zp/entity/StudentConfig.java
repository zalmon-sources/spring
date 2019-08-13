package com.zp.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * Created by peng.zhang
 * Description: 通过配置类进行装配
 * Time: 2019/8/12-15:03.
 */
@Configuration // 配置类
@ComponentScan // 扫描当前包下的注解
// 导入xml配置，导入后在使用xml的Main方法中形成了循环调用，使切面执行了两次
// 即配置了多个代理创建器，产生了多个代理，代理2代理了代理1，代理1代理了本体，所以就产生了aop执行两次
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:zh.properties") // 声明属性源
public class StudentConfig {

    @Autowired
    Environment env;

    @Bean
    @Qualifier("rebort") // 限定符
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 设置为原型注入，每次注入都会重新生成一个实例
    public Student student() {
        Student student = new Student();
        student.setNumber(Math.random() + "");
        return student;
    }

    @Bean
    @Lion // 自定义限定符
    public Person person(Student student) {
        Person person = new Person(
                env.getProperty("student.name"), // 从配置文件动态注入值
                env.getProperty("student.sex"),
                env.getProperty("student.age", Integer.class,20));
        person.setStudent(student);
        return person;
    }
}
