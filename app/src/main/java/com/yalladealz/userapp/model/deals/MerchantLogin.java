package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class MerchantLogin {

    @SerializedName("login_id")
    private int loginId;

    @SerializedName("merchant_login_password")
    private String merchantLoginPassword;

    @SerializedName("merchant_login_email")
    private String merchantLoginEmail;

    @SerializedName("merchant_id")
    private int merchantId;

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setMerchantLoginPassword(String merchantLoginPassword) {
        this.merchantLoginPassword = merchantLoginPassword;
    }

    public String getMerchantLoginPassword() {
        return merchantLoginPassword;
    }

    public void setMerchantLoginEmail(String merchantLoginEmail) {
        this.merchantLoginEmail = merchantLoginEmail;
    }

    public String getMerchantLoginEmail() {
        return merchantLoginEmail;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    @Override
    public String toString() {
        return
                "MerchantLogin{" +
                        "login_id = '" + loginId + '\'' +
                        ",merchant_login_password = '" + merchantLoginPassword + '\'' +
                        ",merchant_login_email = '" + merchantLoginEmail + '\'' +
                        ",merchant_id = '" + merchantId + '\'' +
                        "}";
    }
}