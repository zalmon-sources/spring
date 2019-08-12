package com.zp.entity;

import org.springframework.stereotype.Component;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-15:28.
 */
@Component // 也可以使用 @Named注解，效果和 @Component相同
public class Person {

    private String name;
    private String sex;
    private Integer age;
    private Student student;

    public void print(){
        System.out.println("we are studying");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Person() {
    }

    public Person(String name, String sex, Integer age) {

        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
