package com.example.restaurantdispatch.AllOrders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantdispatch.R;

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
        int orderDispatchStatus = Integer.parseInt(status);


        if (status.equals("1")) {
            final String orderIdentity = ordersList.get(position).getId();
            int id = Integer.parseInt(orderIdentity);

            String personName = ordersList.get(position).getName();
            String personEmail = ordersList.get(position).getEmail();
            //  String personPhone = ordersList.get(position).
            String personDispatchStatus = ordersList.get(position).getDispatch_status();


            holder.orderId.setText(ordersList.get(position).getId());
            holder.userName.setText(personName);
            holder.userEmail.setText(personEmail);
            holder.orderDispatchStatus.setText(personDispatchStatus);

            String alert1 = "Customer's Name: " + personName;
            String alert2 = "Customer's Email: " + personEmail;
            String alert3 = "Order Dispatch Status: Dispatched";

            //Alert Dialog for more details
            holder.ordersView.setOnClickListener(view -> {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setTitle("Order " + id + "'s details.");
                alertDialog.setMessage(alert1 + "\n" + alert2 + "\n" + alert3);
                alertDialog.show();
            });
        } else {
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
