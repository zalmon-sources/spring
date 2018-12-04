package com.design.singleton;

/**
 * Created by peng.zhang
 * description: 懒汉式 单例模式,不支持多线程
 *              getInstance 加上synchronize,为线程安全,但效率很低
 * Time: 2018/12/4-17:42.
 */
public class SingletonLazy {

    private static SingletonLazy instance;
    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
