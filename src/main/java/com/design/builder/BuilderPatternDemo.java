package com.design.builder;

/**
 * Created by peng.zhang
 * description: 使用 MealBuilder 来演示建造者模式（Builder Pattern）
 * Time: 2018-12-05 21:43
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {

        MealBuilder builder = new MealBuilder();

        Meal vegMeal = builder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }

}
