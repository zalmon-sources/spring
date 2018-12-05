package com.design.builder;

/**
 * Created by peng.zhang
 * description: 建造者模式,食物条目总接口
 * Time: 2018-12-05 21:04
 */
public interface Item {

    String name();
    Packing packing();
    float price();
}
