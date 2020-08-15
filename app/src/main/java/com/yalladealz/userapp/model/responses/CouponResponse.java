package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CouponResponse {

    @SerializedName("coupons")
    @Expose
    private List<CouponData> coupons = null;
    @SerializedName("error")
    @Expose
    private int error;

    public List<CouponData> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponData> coupons) {
        this.coupons = coupons;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

}
