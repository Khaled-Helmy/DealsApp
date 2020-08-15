
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class MerchantLogin {

    @SerializedName("login_id")
    private Long mLoginId;
    @SerializedName("merchant_id")
    private Long mMerchantId;
    @SerializedName("merchant_login_email")
    private String mMerchantLoginEmail;
    @SerializedName("merchant_login_password")
    private String mMerchantLoginPassword;

    public Long getLoginId() {
        return mLoginId;
    }

    public void setLoginId(Long loginId) {
        mLoginId = loginId;
    }

    public Long getMerchantId() {
        return mMerchantId;
    }

    public void setMerchantId(Long merchantId) {
        mMerchantId = merchantId;
    }

    public String getMerchantLoginEmail() {
        return mMerchantLoginEmail;
    }

    public void setMerchantLoginEmail(String merchantLoginEmail) {
        mMerchantLoginEmail = merchantLoginEmail;
    }

    public String getMerchantLoginPassword() {
        return mMerchantLoginPassword;
    }

    public void setMerchantLoginPassword(String merchantLoginPassword) {
        mMerchantLoginPassword = merchantLoginPassword;
    }

}
