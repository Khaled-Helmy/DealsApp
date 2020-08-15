package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.BranchDeal;

import java.util.List;

public class BranchDealsResponse {
    @SerializedName("deals")
    @Expose
    private List<BranchDeal> deals = null;
    @SerializedName("error")
    @Expose
    private Integer error;

    public List<BranchDeal> getDeals() {
        return deals;
    }

    public void setDeals(List<BranchDeal> deals) {
        this.deals = deals;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

}
