package com.example.restaurantdispatch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * OrdersHistoryFragment.java - A class that displays the history of previous dispatches
 *
 * @author Zephania Mwando
 * @version 1.0
 */
public class OrdersHistoryFragment extends Fragment {

    //BaseUrl
    private static final String baseUrl = "https://demo.kilimanjarofood.co.ke/api/";

    private OrdersHistoryAdapter ordersHistoryAdapter;
    private RecyclerView recyclerViewHistory;

    public OrdersHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetData getData = retrofit.create(GetData.class);
        Call<ModelClass> call = getData.getOrders();

        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {

                ArrayList<Orders> ordersList = response.body().getData().getOrders();
                ordersHistoryAdapter = new OrdersHistoryAdapter(ordersList);
                recyclerViewHistory = getView().findViewById(R.id.previous_orders);

                //Layout manager
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerViewHistory.setLayoutManager(layoutManager);
                recyclerViewHistory.setAdapter(ordersHistoryAdapter);
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                Log.e(TAG, "on Failure: Error" + t.getMessage());
                Toast.makeText(getActivity(),
                        "Unable to load Orders",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders_history, container, false);
    }
}
