package com.example.restaurantdispatch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * GetData.java - Class that acts as the endPoint to all orders
 *
 * @version 1.0
 * @author Zephania Mwando
 */

public interface GetData {

    String baseUrl = "https://demo.kilimanjarofood.co.ke/api/";

    @Headers("Content-Type: application/json")
    //Request type
    @GET("v1/dispatch/orders")

    //Response in a call object
    Call<ModelClass> getOrdersData();
    //.data.orders
}
