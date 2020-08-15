package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.SerializedName;

public class SginUpUserInfo {

    @SerializedName("email")
    private String mEmail;
    @SerializedName("firstName")
    private String mFirstName;
    @SerializedName("lastName")
    private String mLastName;
    @SerializedName("phone")
    private String mMobile;
    @SerializedName("password")
    private String mpassword;

    public SginUpUserInfo(String mMobile, String mpassword) {
        this.mpassword = mpassword;
        this.mMobile = mMobile;
    }




    public SginUpUserInfo(String mFirstName, String mLastName, String mpassword, String mMobile, String mEmail) {
        this.mEmail = mEmail;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mMobile = mMobile;
        this.mpassword = mpassword;
    }


    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmMobile() {
        return mMobile;
    }

    public void setmMobile(String mMobile) {
        this.mMobile = mMobile;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }


}
