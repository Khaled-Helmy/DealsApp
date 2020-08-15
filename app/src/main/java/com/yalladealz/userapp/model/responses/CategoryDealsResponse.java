package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.Category;
import com.yalladealz.userapp.model.deals.Deal;

import java.util.List;

public class CategoryDealsResponse {

    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("deals")
    @Expose
    private List<Deal> deals = null;
    @SerializedName("error")
    @Expose
    private int error;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

}
