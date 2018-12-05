package com.design.builder;

/**
 * Created by peng.zhang
 * description: 汉堡抽象类,实现Item 的Packing 方法
 * Time: 2018-12-05 21:16
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
