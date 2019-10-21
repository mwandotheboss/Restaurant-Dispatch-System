package com.example.restaurantdispatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class SingleOrderActivity extends AppCompatActivity {

    String baseUrl = "https://demo.kilimanjarofood.co.ke/api/";

    private String orderIdentity;
    private Toolbar toolbar;

    private TextView userName;
    private TextView userEmail;
    private TextView dispatchStatus;
    private TextView countryCode;
    private TextView phoneNumber;
    private TextView totalAmount;
    private TextView timeCreated;
    private TextView timeUpdated;

    private AppCompatButton buttonDispatchOrder;

    private CartItemsAdapter cartItemsAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_order);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.dispatch));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(view -> sendUserBack());

        userName = findViewById(R.id.tvUserName);
        userName = findViewById(R.id.tvUserName);
        userEmail = findViewById(R.id.tvUserEmail);
        dispatchStatus = findViewById(R.id.tvDispatchStatus);
        countryCode = findViewById(R.id.tvCountryCode);
        phoneNumber = findViewById(R.id.tvMobile);
        totalAmount = findViewById(R.id.tvTotal);
        timeCreated = findViewById(R.id.tvCreatedAt);
        timeUpdated = findViewById(R.id.tvUpdatedAt);

        recyclerView = findViewById(R.id.rvCartItems);

        orderIdentity = getIntent().getExtras().get("orderId").toString();
        int orderId = Integer.parseInt(orderIdentity);

        buttonDispatchOrder = findViewById(R.id.buttonDispatch);
        buttonDispatchOrder.setOnClickListener(view -> dispatchOrder(orderId));

        getOrderData(orderId);

    }

    private void getOrderData(Integer orderId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetData getData = retrofit.create(GetData.class);
        Call<ModelClass2> call = getData.getOrder(orderId);

        call.enqueue(new Callback<ModelClass2>() {
            @Override
            public void onResponse(Call<ModelClass2> call, Response<ModelClass2> response) {

                Order order = response.body().getData().getOrders();
                String name = order.getName();
                String email = order.getEmail();
                String dispatch = order.getDispatch_status();
                String code = order.getCountry_code();
                String phone = order.getMobile();
                String sum = order.getTotal();
                String time = order.getCreated_at();
                String update = order.getUpdated_at();

                //Retreiving cart
                ArrayList<CartItemsModel> cartItems = response.body()
                        .getData()
                        .getOrders()
                        .getCart();

                userName.setText(name);
                userEmail.setText(email);
                dispatchStatus.setText(dispatch);
                countryCode.setText(code);
                phoneNumber.setText(phone);
                totalAmount.setText(sum);
                timeCreated.setText(time);
                timeUpdated.setText(update);

                cartItemsAdapter = new CartItemsAdapter(cartItems);
                recyclerView = findViewById(R.id.rvCartItems);

                //Layout manager
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SingleOrderActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(cartItemsAdapter);


            }

            @Override
            public void onFailure(Call<ModelClass2> call, Throwable t) {
                Toast.makeText(SingleOrderActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void dispatchOrder(Integer orderId) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetData getData = retrofit.create(GetData.class);
        Call<ModelClass2> call = getData.dispatchOrder(orderId);

        call.enqueue(new Callback<ModelClass2>() {
            @Override
            public void onResponse(Call<ModelClass2> call, Response<ModelClass2> response) {
                Toast.makeText(SingleOrderActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelClass2> call, Throwable t) {
                Toast.makeText(SingleOrderActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        sendUserToMainActivity();
    }

    private void sendUserToMainActivity() {
        Intent mainActivityIntent = new
                Intent(SingleOrderActivity.this, MainActivity.class);
        finish();
        startActivity(mainActivityIntent);
    }

    private void sendUserBack() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

}
