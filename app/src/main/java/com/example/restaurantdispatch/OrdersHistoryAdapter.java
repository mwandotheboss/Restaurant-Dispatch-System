package com.example.restaurantdispatch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrdersHistoryAdapter extends RecyclerView.Adapter<OrdersHistoryAdapter.CustomViewHolder> {

    private List<Orders> ordersList;

    OrdersHistoryAdapter(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View ordersView;
        TextView orderId;
        TextView userName;
        TextView userEmail;
        TextView orderDispatchStatus;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            ordersView = itemView;

            orderId = ordersView.findViewById(R.id.tvOrderId);
            userName = ordersView.findViewById(R.id.tvUserName);
            userEmail = ordersView.findViewById(R.id.tvUserEmail);
            orderDispatchStatus = ordersView.findViewById(R.id.tvOrderDispatchStatus);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_order_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String status = ordersList.get(position).getDispatch_status();
        if (status.equals("1")) {

            holder.orderId.setText(ordersList.get(position).getId());
            holder.userName.setText(ordersList.get(position).getName());
            holder.userEmail.setText(ordersList.get(position).getEmail());
            holder.orderDispatchStatus.setText(ordersList.get(position).getDispatch_status());
        }else{
            // holder.mView.setVisibility(View.GONE);
            ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
            params.height = 0;
            holder.ordersView.setLayoutParams(params);
        }

    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }
}
