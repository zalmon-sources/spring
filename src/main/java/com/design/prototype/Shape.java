package com.design.prototype;

import java.io.*;

/**
 * Created by peng.zhang
 * description: 原型模式,用于创建重复的对象，同时又能保证性能
 *              实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式
 *              该例子为浅拷贝,只会拷贝基础类型,如存在引用类型则只是拷贝引用
 *              若需要深拷贝,则所引用的类,也需要实现Cloneable 接口,并重写clone 方法
 *              或者实现 serializable,使用序列化方法深拷贝
 * Time: 2018/12/7-16:45.
 */
public abstract class Shape implements Cloneable,Serializable {

    private String id;
    private String type;

    abstract void draw();

    /**
     * 实现Cloneable接口
     * 对象的浅度克隆,在bean里面重写clone()方法，权限为public
     */
    public Shape clone() {
        Shape clone = null;
        try {
            clone = (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * 实现 Serizlizable 接口
     * 对象的深度克隆，此处的对象涉及Collection接口和Map接口下对象的深度克隆
     * 利用序列化和反序列化的方式进行深度克隆对象
     * @param object 待克隆的对象
     * @param <T> 待克隆对象的数据类型
     * @return 已经深度克隆过的对象
     */
    public static <T extends Serializable> T deepCloneObject(T object) {
        T deepClone = null;
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bais = new ByteArrayInputStream(baos
                    .toByteArray());
            ois = new ObjectInputStream(bais);
            deepClone = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return deepClone;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
