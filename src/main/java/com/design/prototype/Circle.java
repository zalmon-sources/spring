package com.design.prototype;

/**
 * Created by peng.zhang
 * Description: Circle 类,继承自Shape,重写draw 方法
 * Time: 2018/12/7-17:11.
 */
public class Circle extends Shape {

    public Circle() {
        setType("Circle");
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
