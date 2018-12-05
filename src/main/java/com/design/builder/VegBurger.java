package com.design.builder;

/**
 * Created by peng.zhang
 * description: 蔬菜汉堡类,继承 Burger
 * Time: 2018-12-05 21:19
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
