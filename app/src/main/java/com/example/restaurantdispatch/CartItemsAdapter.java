package com.example.restaurantdispatch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.CustomViewHolder> {
    private List<CartItemsModel> cartList;

    CartItemsAdapter(List<CartItemsModel> cartList) {
        this.cartList = cartList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //Reference the views in the layout

        public final View cartItemsView;
        TextView quantity;
        TextView price;
        TextView productName;
        TextView description;
        TextView accompaniment;
        TextView size;
        TextView productPrice;

        CustomViewHolder(View itemView) {
            super(itemView);
            cartItemsView = itemView;

            quantity = cartItemsView.findViewById(R.id.tvQuantity);
            price = cartItemsView.findViewById(R.id.tvPrice);
            productName = cartItemsView.findViewById(R.id.tvProductName);
            description = cartItemsView.findViewById(R.id.tvDescription);
            accompaniment = cartItemsView.findViewById(R.id.tvAccompaniment);
            size = cartItemsView.findViewById(R.id.tvSize);
            productPrice = cartItemsView.findViewById(R.id.tvPrice);

        }
    }

    @NonNull
    @Override
    public CartItemsAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_cart_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemsAdapter.CustomViewHolder holder, int position) {
        holder.quantity.setText(cartList.get(position).getQuantity());
        holder.price.setText(cartList.get(position).getPrice());
        holder.productName.setText(cartList.get(position).getProduct_name());
        holder.description.setText(cartList.get(position).getDescription());
        holder.accompaniment.setText(cartList.get(position).getProducts_attribute_accompaniment());
        holder.size.setText(cartList.get(position).getProduct_attrubute_size());
        holder.productPrice.setText(cartList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
