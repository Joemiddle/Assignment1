// Andrew McGuire n01121995 Assignment 1
package com.example.andrewassign1;

/**
 * Created by User on 29/09/2017.
 */

public class Pizza extends Item {

    private String topping1;
    private String topping2;
    private String size;


    Pizza (String name,double cost, String top1,String top2, String size)
    {

        this.itemName = name;
        this.price = cost;
        this.topping1 = top1;
        this.topping2 = top2;
        this.size = size;

    }
}
