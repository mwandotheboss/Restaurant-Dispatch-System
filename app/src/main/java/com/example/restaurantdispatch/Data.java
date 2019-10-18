package com.example.restaurantdispatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Data.java - Model class to consume the outer node of the API JSON
 *
 * @version 1.0
 * @author Zephania Mwando
 */
public class Data {

    @SerializedName("orders")
    @Expose
    private ArrayList<Orders> orders;

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Data{" +
                "orders=" + orders +
                '}';
    }
}
