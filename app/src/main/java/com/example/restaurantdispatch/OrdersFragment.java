package com.example.restaurantdispatch;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * OrdersFragment.java - A class that displays all orders
 *
 * @author Zephania Mwando
 * @version 1.0
 */

public class OrdersFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    private MyAdapter myAdapter;
    private RecyclerView recyclerView;

    public OrdersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Check if there is internet
        checkConnectionStatus();

        //Handler for Retrofit Instance
        GetData service = RetrofitClient
                .getRetrofitInstance()
                .create(GetData.class);

        Call<List<ModelClass>> call = service.getAllOrders();

        //Executing the request asynchronously
        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call,
                                   Response<List<ModelClass>> response) {
                loadDataList(response.body());
            }

            //If the request fails
            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

                Toast.makeText(getActivity(),
                        "Unable to load Orders",
                        Toast.LENGTH_SHORT)
                        .show();

            }
        });

    }


    //Display the data as a list
    private void loadDataList(List<ModelClass> ordersList) {
        //Reference the RecyclerView
        recyclerView = getView().findViewById(R.id.pending_orders);
        myAdapter = new MyAdapter(ordersList);

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        swipeRefreshLayout = view.findViewById(R.id.swipeToRefresh);

        //refresh on swipe
        swipeRefreshLayout.setOnRefreshListener(() -> {

            final Handler handler = new Handler();
            handler.postDelayed(this::checkConnectionStatus, 1000);

            swipeRefreshLayout.setRefreshing(false);
        });
    }

    @Override
    public void onRefresh() {
        checkConnectionStatus();
    }

    //Checking internet connection state
    private void checkConnectionStatus() {

        if (ConnectionChecker.isConnectedToNetwork(Objects.requireNonNull(getContext()))) {

            Toast.makeText(getActivity(),
                    "Internet Connection",
                    Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(getActivity(),
                    "NETWORK ERROR! Please check your Internet connection",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

}
