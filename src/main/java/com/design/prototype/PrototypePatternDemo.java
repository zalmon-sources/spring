package com.design.prototype;

/**
 * Created by peng.zhang
 * Description: 测试原型模式
 * Time: 2018/12/7-17:19.
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Circle circle = (Circle) ShapeCache.getShape("1");
        System.out.println("Cloneable : " + circle.getType());

        Rectangle rectangle = (Rectangle) ShapeCache.getShape("2");
        System.out.println("Cloneable : " + rectangle.getType());

        Square square = (Square) ShapeCache.getShape("3");
        System.out.println("Cloneable : " + square.getType());



        Circle circleSer = new Circle();
        circleSer.setType("circleSer");

        Circle circleSerClone = Shape.deepCloneObject(circleSer);
        System.out.println("\nSerializable : " + circleSerClone.getType());

    }
}
