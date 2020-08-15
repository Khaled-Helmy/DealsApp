
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class DealRedeemed {

    @SerializedName("deal_id")
    private Long mDealId;
    @SerializedName("redeemed")
    private Boolean mRedeemed;
    @SerializedName("redeemed_id")
    private Long mRedeemedId;
    @SerializedName("user_id")
    private Long mUserId;

    public Long getDealId() {
        return mDealId;
    }

    public void setDealId(Long dealId) {
        mDealId = dealId;
    }

    public Boolean getRedeemed() {
        return mRedeemed;
    }

    public void setRedeemed(Boolean redeemed) {
        mRedeemed = redeemed;
    }

    public Long getRedeemedId() {
        return mRedeemedId;
    }

    public void setRedeemedId(Long redeemedId) {
        mRedeemedId = redeemedId;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

}
