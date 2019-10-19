package com.example.restaurantdispatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Orders.java - Model class to access all orders details
 *
 * @version 1.0
 * @author Zephania Mwando
 */
public class Orders {

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

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dispatch_status='" + dispatch_status + '\'' +
                '}';
    }
}
