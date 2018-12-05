package com.design.singleton;

/**
 * Created by peng.zhang
 * description: 枚举,实现单例模式的最佳方法
 *              不仅能避免多线程同步问题，而且还自动支持序列化机制，
 *              防止反序列化重新创建新的对象，绝对防止多次实例化
 * Time: 2018/12/5-14:29.
 */
public class SingletonEnum {

    private SingletonEnum(){}
    public SingletonEnum getInstance(){
        return Singleton.INSTANCE.singletonEnum;
    }

//    声明枚举类型
    private static enum Singleton {
        INSTANCE;

        private SingletonEnum singletonEnum;
        private Singleton(){
            singletonEnum = new SingletonEnum();
        }
        private SingletonEnum getInstance(){
            return singletonEnum;
        }
    }
}
