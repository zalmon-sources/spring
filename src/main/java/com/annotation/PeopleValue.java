package com.annotation;

import java.lang.annotation.*;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2021/1/7-15:52.
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PeopleValue {

    String name() default "zalmon";

    int age() default 24;
}
