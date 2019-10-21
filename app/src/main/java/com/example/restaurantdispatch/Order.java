package com.example.restaurantdispatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class Order {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("dispatch_status")
    @Expose
    private String dispatch_status;
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("country_code")
    @Expose
    private String country_code;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("updated_at")
    @Expose
    private String updated_at;
    @SerializedName("payment_details_status")
    @Expose
    private String payment_details_status;
    @SerializedName("cart")
    @Expose
    private ArrayList<CartItemsModel> cart;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDispatch_status() {
        return dispatch_status;
    }

    public void setDispatch_status(String dispatch_status) {
        this.dispatch_status = dispatch_status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPayment_details_status() {
        return payment_details_status;
    }

    public void setPayment_details_status(String payment_details_status) {
        this.payment_details_status = payment_details_status;
    }

    public ArrayList<CartItemsModel> getCart() {
        return cart;
    }

    public void setCart(ArrayList<CartItemsModel> cart) {
        this.cart = cart;
    }

    public Order(String dispatch_status) {
        this.dispatch_status = dispatch_status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dispatch_status='" + dispatch_status + '\'' +
                ", user_id='" + user_id + '\'' +
                ", country_code='" + country_code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", total='" + total + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", payment_details_status='" + payment_details_status + '\'' +
                ", cart=" + cart +
                '}';
    }
}
