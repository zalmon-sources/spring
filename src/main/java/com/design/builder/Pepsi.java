package com.design.builder;

/**
 * Created by peng.zhang
 * description: 百事可乐类,继承 ColdDrink
 * Time: 2018-12-05 21:29
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
