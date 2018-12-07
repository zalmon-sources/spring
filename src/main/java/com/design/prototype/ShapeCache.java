package com.design.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2018/12/7-17:12.
 */
public class ShapeCache {

    /*
       注册表,存放需要克隆的实例
     */
    private static Map<String,Shape> shapeMap = new HashMap<String, Shape>();

    /*
       获取实例克隆的方法
     */
    public static Shape getShape(String shapeId){
        Shape shape = shapeMap.get(shapeId);
        return shape.clone();
    }

     /*
       对每种形状都运行数据库查询，并创建该形状
       shapeMap.put(shapeKey, shape);
       在此添加三个实例
      */
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId("3");
        shapeMap.put(square.getId(), square);
    }


}
