package com.design.builder;

/**
 * Created by peng.zhang
 * description: 可口可乐类,继承 ColdDrink
 * Time: 2018-12-05 21:28
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
