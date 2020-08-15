package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.Payment.PaymentProfile;

public class TokenResponse {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("profile")
    @Expose
    private PaymentProfile profile;

    @SerializedName("detail")
    @Expose
    private String detail;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public PaymentProfile getProfile() {
        return profile;
    }

    public void setProfile(PaymentProfile profile) {
        this.profile = profile;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
