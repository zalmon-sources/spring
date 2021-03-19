package com.zp.entity;

import org.springframework.stereotype.Component;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-15:40.
 */
@Component
public class Student {

    String number;

    public void beforeStudy(){
        System.out.println("before study...");
    }

    public void afterStudy(){
        System.out.println("after study...");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                '}';
    }
}
