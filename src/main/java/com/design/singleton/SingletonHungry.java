package com.design.singleton;

/**
 * Created by peng.zhang
 * description: 饿汉式 单例模式,
 *              基于 classloader 机制避免了多线程的同步问题,但是浪费内存
 * Time: 2018/12/4-17:47.
 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry(){}

    public static SingletonHungry getInstance(){
        return instance;
    }
}
