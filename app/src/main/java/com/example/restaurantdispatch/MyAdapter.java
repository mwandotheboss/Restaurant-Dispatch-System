package com.example.restaurantdispatch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {
    private List<Orders> ordersList;

    public MyAdapter(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //Reference the views in the layout

        public final View mView;
        TextView orderID;
        TextView orderName;
        TextView orderDispatchStatus;
        TextView orderDescription;
        TextView orderTotal;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            orderID = mView.findViewById(R.id.tvID);
            orderName = mView.findViewById(R.id.tvName);
            orderDispatchStatus = mView.findViewById(R.id.tvDispatchStatus);
            orderDescription = mView.findViewById(R.id.tvDescription);
            orderTotal = mView.findViewById(R.id.tvTotal);

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
        holder.orderID.setText(ordersList.get(position).getId());
        holder.orderName.setText(ordersList.get(position).getName());
        holder.orderDispatchStatus.setText(ordersList.get(position).getDispatchStatus());
        holder.orderDescription.setText(ordersList.get(position).getDescription());
        holder.orderTotal.setText(ordersList.get(position).getTotal());

    }

    //Calculate the Item count
    @Override
    public int getItemCount() {
        return ordersList.size();
    }
}
