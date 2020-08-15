package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("gender")
    private String gender;

    @SerializedName("date_of_birth")
    private String dateOfBirth;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("UserAddress")
    private Object userAddress;

    @SerializedName("UserLog")
    private Object userLog;

    @SerializedName("mobile_active")
    private String mobileActive;

    @SerializedName("is_affiliate")
    private String isAffiliate;

    @SerializedName("email_active")
    private String emailActive;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("rest_password_code")
    private String restPasswordCode;

    @SerializedName("app_hash")
    private String appHash;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("email")
    private String email;

    @SerializedName("mobile_active_code")
    private String mobileActiveCode;

    @SerializedName("wallet_amount")
    private String walletAmount;

    @SerializedName("status")
    private String status;

    @SerializedName("email_active_code")
    private String emailActiveCode;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setUserAddress(Object userAddress) {
        this.userAddress = userAddress;
    }

    public Object getUserAddress() {
        return userAddress;
    }

    public void setUserLog(Object userLog) {
        this.userLog = userLog;
    }

    public Object getUserLog() {
        return userLog;
    }

    public void setMobileActive(String mobileActive) {
        this.mobileActive = mobileActive;
    }

    public String getMobileActive() {
        return mobileActive;
    }

    public void setIsAffiliate(String isAffiliate) {
        this.isAffiliate = isAffiliate;
    }

    public String getIsAffiliate() {
        return isAffiliate;
    }

    public void setEmailActive(String emailActive) {
        this.emailActive = emailActive;
    }

    public String getEmailActive() {
        return emailActive;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setRestPasswordCode(String restPasswordCode) {
        this.restPasswordCode = restPasswordCode;
    }

    public String getRestPasswordCode() {
        return restPasswordCode;
    }

    public String getAppHash() {
        return appHash;
    }

    public void setAppHash(String appHash) {
        this.appHash = appHash;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMobileActiveCode(String mobileActiveCode) {
        this.mobileActiveCode = mobileActiveCode;
    }

    public String getMobileActiveCode() {
        return mobileActiveCode;
    }

    public void setWalletAmount(String walletAmount) {
        this.walletAmount = walletAmount;
    }

    public String getWalletAmount() {
        return walletAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setEmailActiveCode(String emailActiveCode) {
        this.emailActiveCode = emailActiveCode;
    }

    public String getEmailActiveCode() {
        return emailActiveCode;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "gender = '" + gender + '\'' +
                        ",date_of_birth = '" + dateOfBirth + '\'' +
                        ",mobile = '" + mobile + '\'' +
                        ",last_name = '" + lastName + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",userAddress = '" + userAddress + '\'' +
                        ",userLog = '" + userLog + '\'' +
                        ",mobile_active = '" + mobileActive + '\'' +
                        ",is_affiliate = '" + isAffiliate + '\'' +
                        ",email_active = '" + emailActive + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",rest_password_code = '" + restPasswordCode + '\'' +
                        ",app_hash = '" + appHash + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        ",email = '" + email + '\'' +
                        ",mobile_active_code = '" + mobileActiveCode + '\'' +
                        ",wallet_amount = '" + walletAmount + '\'' +
                        ",status = '" + status + '\'' +
                        ",email_active_code = '" + emailActiveCode + '\'' +
                        "}";
    }
}