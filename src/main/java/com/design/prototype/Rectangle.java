package com.design.prototype;

/**
 * Created by peng.zhang
 * Description: Rectangle 类,继承自Shape,重写draw 方法
 * Time: 2018/12/7-17:05.
 */
public class Rectangle extends Shape {

    public Rectangle(){
        setType("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
