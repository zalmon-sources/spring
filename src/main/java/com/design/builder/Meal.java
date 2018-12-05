package com.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng.zhang
 * description: 食物类,带有Item 对象,使用java 的多态特性
 * Time: 2018-12-05 21:33
 */
public class Meal {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }

}
