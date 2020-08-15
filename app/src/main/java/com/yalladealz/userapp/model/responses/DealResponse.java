package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.deals.Deal;

public class DealResponse {

    @SerializedName("deal")
    @Expose
    private Deal deal;
    @SerializedName("error")
    @Expose
    private int error;

    public Deal getDeal() {
        return deal;
    }

    public int getError() {
        return error;
    }
}
