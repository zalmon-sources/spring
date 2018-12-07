package com.design.prototype;

/**
 * Created by peng.zhang
 * Description: Square 类,继承自Shape,重写draw 方法
 * Time: 2018/12/7-17:10.
 */
public class Square extends Shape {

    public Square() {
        setType("Square");
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
