package com.annotation;

import org.junit.Test;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2021/1/7-15:55.
 */
public class AnnoTest {

    @Test
    public void testFather(){
        Class<Father> clazz = Father.class;
        // 判断类上是否存在指定的注释类型
        boolean annotationPresent = clazz.isAnnotationPresent(PeopleValue.class);
        if (annotationPresent) {
            PeopleValue annotation = clazz.getAnnotation(PeopleValue.class);
            System.out.println(annotation.name());
            System.out.println(annotation.age());
        }
    }

    @Test
    public void testSon(){
        Class<Son> clazz = Son.class;
        boolean annotationPresent = clazz.isAnnotationPresent(PeopleValue.class);
        if (annotationPresent) {
            PeopleValue annotation = clazz.getAnnotation(PeopleValue.class);
            System.out.println(annotation.name());
            System.out.println(annotation.age());
        }
    }

    @Test
    public void testGame(){
        Class<Son> clazz = Son.class;
        Game[] games = clazz.getAnnotationsByType(Game.class);
        for (Game game : games) {
            System.out.println(game.value());
        }

        System.out.println("---------------------");

        Class<LittleSon> littleSonClass = LittleSon.class;
        boolean annotationPresent = littleSonClass.isAnnotationPresent(People.class);
        if (annotationPresent) {
            People annotation = littleSonClass.getAnnotation(People.class);
            Game[] value = annotation.value();
            for (Game game : value) {
                System.out.println(game.value());
            }
        }
    }
}
