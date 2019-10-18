package com.example.restaurantdispatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ModelClass.java - Model class to access the outer nodes of JSON
 *
 * @version 1.0
 * @author Zephania Mwando
 */
public class ModelClass {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
