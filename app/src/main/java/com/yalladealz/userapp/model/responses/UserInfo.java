package com.yalladealz.userapp.model.responses;

import androidx.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("app_hash")
    private String mAppHash;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("date_of_birth")
    private String mDateOfBirth;

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

    @SerializedName("email_active")
    private String mEmailActive;
    @SerializedName("email_active_code")
    private String mEmailActiveCode;



    @SerializedName("gender")
    private String mGender;
    @SerializedName("is_affiliate")
    private String mIsAffiliate;

    @SerializedName("mobile_active")
    private String mMobileActive;
    @SerializedName("mobile_active_code")
    private String mMobileActiveCode;
    @SerializedName("rest_password_code")
    private String mRestPasswordCode;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("UserAddress")
    private Object mUserAddress;

    @SerializedName("user_id")
    private Long mUserId;

    @SerializedName("UserLog")
    private Object mUserLog;
    @SerializedName("wallet_amount")
    private String mWalletAmount;



    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }



    @Ignore
    private String password;


    public UserInfo(String mDateOfBirth, String mEmail, String mFirstName, String mGender,
                    String mLastName, String mMobile, String password) {
        this.mDateOfBirth = mDateOfBirth;
        this.mEmail = mEmail;
        this.mFirstName = mFirstName;
        this.mGender = mGender;
        this.mLastName = mLastName;
        this.mMobile = mMobile;
        this.mpassword = password;
    }

    public UserInfo(Long mUserId,String mAppHash,String mMobile, String mDateOfBirth, String mFirstName, String mGender, String mLastName) {
        this.mDateOfBirth = mDateOfBirth;
        this.mFirstName = mFirstName;
        this.mGender = mGender;
        this.mLastName = mLastName;
        this.mUserId = mUserId;
        this.mAppHash = mAppHash;
        this.mMobile = mMobile;
    }

    public String getAppHash() {
        return mAppHash;
    }

    public void setAppHash(String appHash) {
        mAppHash = appHash;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getEmailActive() {
        return mEmailActive;
    }

    public void setEmailActive(String emailActive) {
        mEmailActive = emailActive;
    }

    public String getEmailActiveCode() {
        return mEmailActiveCode;
    }

    public void setEmailActiveCode(String emailActiveCode) {
        mEmailActiveCode = emailActiveCode;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getIsAffiliate() {
        return mIsAffiliate;
    }

    public void setIsAffiliate(String isAffiliate) {
        mIsAffiliate = isAffiliate;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getMobileActive() {
        return mMobileActive;
    }

    public void setMobileActive(String mobileActive) {
        mMobileActive = mobileActive;
    }

    public String getMobileActiveCode() {
        return mMobileActiveCode;
    }

    public void setMobileActiveCode(String mobileActiveCode) {
        mMobileActiveCode = mobileActiveCode;
    }

    public String getRestPasswordCode() {
        return mRestPasswordCode;
    }

    public void setRestPasswordCode(String restPasswordCode) {
        mRestPasswordCode = restPasswordCode;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public Object getUserAddress() {
        return mUserAddress;
    }

    public void setUserAddress(Object userAddress) {
        mUserAddress = userAddress;
    }

   public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public Object getUserLog() {
        return mUserLog;
    }

    public void setUserLog(Object userLog) {
        mUserLog = userLog;
    }

    public String getWalletAmount() {
        return mWalletAmount;
    }

    public void setWalletAmount(String walletAmount) {
        mWalletAmount = walletAmount;
    }

}