package com.example.restaurantdispatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data2 {

    @SerializedName("orders")
    @Expose
    private Order orders;

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Data{" +
                "orders=" + orders +
                '}';
    }
}
