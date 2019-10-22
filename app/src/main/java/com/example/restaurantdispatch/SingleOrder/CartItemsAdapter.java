package com.example.restaurantdispatch.SingleOrder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantdispatch.R;

import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.CustomViewHolder> {
    private List<CartItemsModel> cartList;

    CartItemsAdapter(List<CartItemsModel> cartList) {
        this.cartList = cartList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private final View cartItemsView;
        TextView quantity;
        TextView price;
        TextView productName;
        TextView description;
        TextView accompaniment;
        TextView productPrice;

        CustomViewHolder(View itemView) {
            super(itemView);
            cartItemsView = itemView;

            quantity = cartItemsView.findViewById(R.id.tvQuantity);
            productName = cartItemsView.findViewById(R.id.tvProductName);
            description = cartItemsView.findViewById(R.id.tvDescription);
            accompaniment = cartItemsView.findViewById(R.id.tvAccompaniment);
            productPrice = cartItemsView.findViewById(R.id.tvPrice);

        }
    }

    @NonNull
    @Override
    public CartItemsAdapter.CustomViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_cart_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemsAdapter.CustomViewHolder holder, int position) {

        String itemName = "Name: " + cartList.get(position).getProduct_name();
        String itemQuantity ="Quantity: " + cartList.get(position).getQuantity();
        String itemPrice ="Price: " + cartList.get(position).getPrice();
        String itemDescription ="Description: " + cartList.get(position).getDescription();
        String itemAccompaniment ="Accompaniment: " + cartList
                .get(position)
                .getProducts_attribute_accompaniment();

        holder.productName.setText(itemName);
        holder.quantity.setText(itemQuantity);
        holder.description.setText(itemDescription);
        holder.accompaniment.setText(itemAccompaniment);
        holder.productPrice.setText(itemPrice);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
