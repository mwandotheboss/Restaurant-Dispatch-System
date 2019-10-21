package com.example.restaurantdispatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelClass2 {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data2 data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data2 getData() {
        return data;
    }

    public void setData(Data2 data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ModelClass2{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
