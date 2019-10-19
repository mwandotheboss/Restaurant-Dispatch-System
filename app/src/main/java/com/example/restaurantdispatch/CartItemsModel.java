package com.example.restaurantdispatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartItemsModel {

    @SerializedName("product_id")
    @Expose
    private String product_id;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("accompaniment_id")
    @Expose
    private String accompaniment_id;
    @SerializedName("product_name")
    @Expose
    private String product_name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("products_attribute_accompaniment")
    @Expose
    private String products_attribute_accompaniment;
    @SerializedName("product_attrubute_size")
    @Expose
    private String product_attrubute_size;
    @SerializedName("product_attrubute_price")
    @Expose
    private String product_attrubute_price;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccompaniment_id() {
        return accompaniment_id;
    }

    public void setAccompaniment_id(String accompaniment_id) {
        this.accompaniment_id = accompaniment_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducts_attribute_accompaniment() {
        return products_attribute_accompaniment;
    }

    public void setProducts_attribute_accompaniment(String products_attribute_accompaniment) {
        this.products_attribute_accompaniment = products_attribute_accompaniment;
    }

    public String getProduct_attrubute_size() {
        return product_attrubute_size;
    }

    public void setProduct_attrubute_size(String product_attrubute_size) {
        this.product_attrubute_size = product_attrubute_size;
    }

    public String getProduct_attrubute_price() {
        return product_attrubute_price;
    }

    public void setProduct_attrubute_price(String product_attrubute_price) {
        this.product_attrubute_price = product_attrubute_price;
    }

    @Override
    public String toString() {
        return "CartItemsModel{" +
                "product_id='" + product_id + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", accompaniment_id='" + accompaniment_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", products_attribute_accompaniment='" + products_attribute_accompaniment + '\'' +
                ", product_attrubute_size='" + product_attrubute_size + '\'' +
                ", product_attrubute_price='" + product_attrubute_price + '\'' +
                '}';
    }
}
