package com.example.restaurantdispatch.AllOrders;

import android.app.ProgressDialog;
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

import com.example.restaurantdispatch.AllOrders.ModelClass;
import com.example.restaurantdispatch.AllOrders.Orders;
import com.example.restaurantdispatch.AllOrders.OrdersHistoryAdapter;
import com.example.restaurantdispatch.GetData;
import com.example.restaurantdispatch.R;
import com.example.restaurantdispatch.SingleOrder.SingleOrderActivity;

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
                LinearLayoutManager layoutManager = new
                        LinearLayoutManager(getContext(),
                        LinearLayoutManager.VERTICAL,
                        true);

                layoutManager.setStackFromEnd(true);
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

    @Override
    public void onResume() {
        super.onResume();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetData getData = retrofit.create(GetData.class);
        Call<ModelClass> call = getData.getOrders();

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(getActivity());
        //show progress dialog
        progressDialog.setTitle("Fetching Orders");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();

        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {

                progressDialog.dismiss();

                ArrayList<Orders> ordersList = response.body().getData().getOrders();
                ordersHistoryAdapter = new OrdersHistoryAdapter(ordersList);
                recyclerViewHistory = getView().findViewById(R.id.previous_orders);

                //Layout manager
                LinearLayoutManager layoutManager = new
                        LinearLayoutManager(getContext(),
                        LinearLayoutManager.VERTICAL,
                        true);

                layoutManager.setStackFromEnd(true);
                recyclerViewHistory.setLayoutManager(layoutManager);
                recyclerViewHistory.setAdapter(ordersHistoryAdapter);
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
               progressDialog.dismiss();

                Toast.makeText(getActivity(),
                        "Unable to load Orders" + t.getMessage(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
