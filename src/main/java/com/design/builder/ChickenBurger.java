package com.design.builder;

/**
 * Created by peng.zhang
 * description: 鸡肉汉堡类,继承 Burger
 * Time: 2018-12-05 21:21
 */
public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
