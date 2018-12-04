package com.design.singleton;

/**
 * Created by peng.zhang
 * description: 双重校验锁 单例模式 (DCL，即 double-checked locking）
 *              采用双锁机制，安全且在多线程情况下能保持高性能
 *              volatile 防止指令重排
 * Time: 2018/12/4-17:51.
 */
public class SingletonDCL {

    private volatile static SingletonDCL instance;
    private SingletonDCL(){}

    public static SingletonDCL getInstance(){
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
