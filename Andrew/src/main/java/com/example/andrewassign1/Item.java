// Andrew McGuire n01121995 Assignment 1
package com.example.andrewassign1;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by User on 29/09/2017.
 */

public class Item implements Serializable{


    public double price;
    public String itemName;


    Item()
    {

    }

    Item(String name,double cost)
    {

        this.itemName = name;
        this.price = cost;


    }

    public String getItemName()
    {
        return this.itemName;
    }

    public double getCost()
    {
        return this.price;
    }
}
