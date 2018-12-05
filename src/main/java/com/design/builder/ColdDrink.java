package com.design.builder;

/**
 * Created by peng.zhang
 * description: 冷饮抽象类,实现 Item 的Packing 方法
 * Time: 2018-12-05 21:22
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

}
