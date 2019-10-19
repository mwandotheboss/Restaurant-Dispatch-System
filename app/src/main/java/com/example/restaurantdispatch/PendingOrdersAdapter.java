package com.example.restaurantdispatch;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PendingOrdersAdapter extends RecyclerView.Adapter<PendingOrdersAdapter.CustomViewHolder> {
    private List<Orders> ordersList;

    PendingOrdersAdapter(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //Reference the views in the layout

        public final View ordersView;
        TextView orderId;
        TextView userName;
        TextView userEmail;
        TextView orderDispatchStatus;

        CustomViewHolder(View itemView) {
            super(itemView);
            ordersView = itemView;

            orderId = ordersView.findViewById(R.id.tvOrderId);
            userName = ordersView.findViewById(R.id.tvUserName);
            userEmail = ordersView.findViewById(R.id.tvUserEmail);
            orderDispatchStatus = ordersView.findViewById(R.id.tvOrderDispatchStatus);

        }
    }

    //RecyclerView View Holder
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_order_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder
            (@NonNull CustomViewHolder holder, int position) {
        String status = ordersList.get(position).getDispatch_status();
        final String orderIdentity = ordersList.get(position).getId();
        if (status.equals("0")) {
            holder.orderId.setText(ordersList.get(position).getId());
            holder.userName.setText(ordersList.get(position).getName());
            holder.userEmail.setText(ordersList.get(position).getEmail());
            holder.orderDispatchStatus.setText(ordersList.get(position).getDispatch_status());

            holder.ordersView.setOnClickListener(view -> {
                Intent clickOrderIntent = new Intent(view.getContext(),
                        CartItemsActivity.class);
                clickOrderIntent.putExtra("orderId", orderIdentity);
                view.getContext().startActivity(clickOrderIntent);
            });
        }else{
           // holder.mView.setVisibility(View.GONE);
            ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
            params.height = 0;
            holder.ordersView.setLayoutParams(params);
        }
    }

    //Calculate the Item count
    @Override
    public int getItemCount() {
        return ordersList.size();
    }
}
