package com.design.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Created by peng.zhang
 * description: 反射机制/反序列化破解单例模式(枚举除外)
 * Time: 2018/12/5-14:51.
 */
public class BreakSingleton {

    public static void main(String[] args) throws Exception {
        /*
         * 反射机制破解
         */
        Class clazz = Class.forName("com.design.singleton.Singleton");
        Constructor c = clazz.getDeclaredConstructor();

        c.setAccessible(true);

//        通过反射,获得两个不同的对象
        Singleton singleton1 = (Singleton)c.newInstance();
        Singleton singleton2 = (Singleton)c.newInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);



        /*
            反序列化破解
         */
//       先根据单例模式创建对象(单例模式所以s1,s2是一样的)
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();

//       将s1写入本地某个路径
        FileOutputStream fos=new FileOutputStream("本地某个路径下文件");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

//       从本地某个路径读取写入的对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("和上面的本地参数路径相同"));
        Singleton s3=(Singleton) ois.readObject();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);//s3是一个新对象
    }

}

class Singleton{
    private static final Singleton instance = new Singleton();
    private Singleton() {
//       在构造器中加个逻辑判断,多次调用抛出异常,避免反射机制破解单例模式
        if(instance!= null){
            throw new RuntimeException();
        }
    }
    public static Singleton getInstance(){
        return instance;
    }

//   反序列化定义该方法，则不需要创建新对象,避免反序列化破解单例模式
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
