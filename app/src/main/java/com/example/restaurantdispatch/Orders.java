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
    @SerializedName("dispatchStatus")
    @Expose
    private String dispatchStatus;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("total")
    @Expose
    private String total;

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

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dispatchStatus='" + dispatchStatus + '\'' +
                ", description='" + description + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
