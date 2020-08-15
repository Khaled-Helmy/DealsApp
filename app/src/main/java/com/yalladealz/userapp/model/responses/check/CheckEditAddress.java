
package com.yalladealz.userapp.model.responses.check;

import com.google.gson.annotations.SerializedName;

public class CheckEditAddress {

    @SerializedName("address")
    private Address mAddress;
    @SerializedName("error")
    private Long mError;

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public Long getError() {
        return mError;
    }

    public void setError(Long error) {
        mError = error;
    }


    public class Address {

        @SerializedName("address")
        private String mAddress;
        @SerializedName("apartment")
        private String mApartment;
        @SerializedName("building")
        private String mBuilding;
        @SerializedName("city")
        private String mCity;
        @SerializedName("country")
        private String mCountry;
        @SerializedName("id")
        private Long mId;
        @SerializedName("state")
        private String mState;
        @SerializedName("user_id")
        private Long mUserId;

        public String getAddress() {
            return mAddress;
        }

        public void setAddress(String address) {
            mAddress = address;
        }

        public String getApartment() {
            return mApartment;
        }

        public void setApartment(String apartment) {
            mApartment = apartment;
        }

        public String getBuilding() {
            return mBuilding;
        }

        public void setBuilding(String building) {
            mBuilding = building;
        }

        public String getCity() {
            return mCity;
        }

        public void setCity(String city) {
            mCity = city;
        }

        public String getCountry() {
            return mCountry;
        }

        public void setCountry(String country) {
            mCountry = country;
        }

        public Long getId() {
            return mId;
        }

        public void setId(Long id) {
            mId = id;
        }

        public String getState() {
            return mState;
        }

        public void setState(String state) {
            mState = state;
        }

        public Long getUserId() {
            return mUserId;
        }

        public void setUserId(Long userId) {
            mUserId = userId;
        }

    }
}

