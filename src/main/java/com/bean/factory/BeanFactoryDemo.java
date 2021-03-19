package com.bean.factory;

import com.zp.entity.Student;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * 编程式使用 Ioc 容器
 */
public class BeanFactoryDemo {

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        Student student = factory.getBean("student", Student.class);
        System.out.println(student);


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student) context.getBean("student");
        System.out.println(student1);
    }
}
