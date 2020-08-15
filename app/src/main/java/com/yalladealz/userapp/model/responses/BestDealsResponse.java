package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.deals.Deal;

import java.util.List;

public class BestDealsResponse {

    @SerializedName("best_deals")
    @Expose
    private List<Deal> deals = null;
    @SerializedName("error")
    @Expose
    private int error;

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
