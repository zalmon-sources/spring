package com.annotation;

import java.lang.annotation.*;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2021/1/7-15:32.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface People {

    Game[] value();
}
