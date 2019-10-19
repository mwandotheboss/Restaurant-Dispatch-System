package com.example.restaurantdispatch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * GetData.java - Class that acts as the API Service to all orders
 *
 * @author Zephania Mwando
 * @version 1.0
 */

public interface GetOrder {

    String baseUrl = "https://demo.kilimanjarofood.co.ke/api/";

    @Headers("Content-Type: application/json")
    //Request type
    @GET("v1/dispatch/order?orderId={orderId}")

        //Response in a call object
    Call<ModelClass> getOrderData(@Path(value = "orderId", encoded = true) String orderId  );
}
