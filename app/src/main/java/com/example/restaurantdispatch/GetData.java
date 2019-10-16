package com.example.restaurantdispatch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    //Request type
    @GET("https://www.getpostman.com/collections/8cd41b2c738ac158c06f")
    //Response in a call object
    Call<List<ModelClass>> getAllOrders();
}
