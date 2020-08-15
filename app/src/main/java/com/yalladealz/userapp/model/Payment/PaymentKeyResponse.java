package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentKeyResponse {

    @SerializedName("token")
    @Expose
    private String paymentKey;
    private String detail;

    public String getDetail() {
        return detail;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }
}
