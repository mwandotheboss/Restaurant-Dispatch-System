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
 * OrdersFragment.java - A class that displays all orders
 *
 * @author Zephania Mwando
 * @version 1.0
 */

public class OrdersFragment extends Fragment {

    //BaseUrl
    private static final String baseUrl = "https://demo.kilimanjarofood.co.ke/api/";

    private MyAdapter myAdapter;
    private RecyclerView recyclerView;

    public OrdersFragment() {
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
        Call<ModelClass> call = getData.getOrdersData();

        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {

                Toast.makeText(getActivity(), "OK" + response, Toast.LENGTH_SHORT).show();

                ArrayList<Orders> ordersList = response.body().getData().getOrders();
                myAdapter = new MyAdapter(ordersList);
                recyclerView = getView().findViewById(R.id.pending_orders);

                //Layout manager
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(myAdapter);
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

    //Display the data as a list
    private void loadDataList(Response<ModelClass> call) {
        //Reference the RecyclerView
        recyclerView = getView().findViewById(R.id.pending_orders);
        //   myAdapter = new MyAdapter(Response<Orders> call);

        //Layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false);
    }

}
