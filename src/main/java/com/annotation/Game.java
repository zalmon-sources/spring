package com.annotation;

import java.lang.annotation.*;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2021/1/7-15:24.
 */
// 将注解中的元素包含到 Javadoc 中
@Documented
// 被@Inherited修饰的类的子类可以继承MyAnnotation
@Inherited
// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
// 作用接口、类、枚举、注解
@Target(ElementType.TYPE)
// 修饰的注解可以同时作用一个对象多次，但是每次作用注解又可以代表不同的含义
// 将Game注解的值放入到People注解中
@Repeatable(People.class)
public @interface Game {

    String value() default "";

}
