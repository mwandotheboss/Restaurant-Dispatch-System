package com.example.restaurantdispatch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    //Request type
    @GET("/v1/dispatch/orders")
    //Response in a call object
    Call<List<ModelClass>> getAllOrders();
}
