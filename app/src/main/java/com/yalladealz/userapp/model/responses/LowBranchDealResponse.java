
package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class LowBranchDealResponse {

    @SerializedName("deal")
    private Deal mDeal;
    @SerializedName("error")
    private Long mError;

    public Deal getDeal() {
        return mDeal;
    }

    public void setDeal(Deal deal) {
        mDeal = deal;
    }

    public Long getError() {
        return mError;
    }

    public void setError(Long error) {
        mError = error;
    }

    public class Deal {

        @SerializedName("branch_name")
        private String mBranchName;
        @SerializedName("deal_id")
        private Long mDealId;
        @SerializedName("deal_name")
        private String mDealName;
        @SerializedName("deal_price")
        private String mDealPrice;
        @SerializedName("location_latitude")
        private String mLocationLatitude;
        @SerializedName("location_longitude")
        private String mLocationLongitude;

        public String getBranchName() {
            return mBranchName;
        }

        public void setBranchName(String branchName) {
            mBranchName = branchName;
        }

        public Long getDealId() {
            return mDealId;
        }

        public void setDealId(Long dealId) {
            mDealId = dealId;
        }

        public String getDealName() {
            return mDealName;
        }

        public void setDealName(String dealName) {
            mDealName = dealName;
        }

        public String getDealPrice() {
            return mDealPrice;
        }

        public void setDealPrice(String dealPrice) {
            mDealPrice = dealPrice;
        }

        public String getLocationLatitude() {
            return mLocationLatitude;
        }

        public void setLocationLatitude(String locationLatitude) {
            mLocationLatitude = locationLatitude;
        }

        public String getLocationLongitude() {
            return mLocationLongitude;
        }

        public void setLocationLongitude(String locationLongitude) {
            mLocationLongitude = locationLongitude;
        }
    }
}
