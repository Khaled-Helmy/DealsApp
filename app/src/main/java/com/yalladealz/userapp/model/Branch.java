package com.yalladealz.userapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Branch {

    @SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("merchant_id")
    @Expose
    private Integer merchantId;
    @SerializedName("branch_name")
    @Expose
    private String branchName;
    @SerializedName("branch_city")
    @Expose
    private String branchCity;
    @SerializedName("branch_address")
    @Expose
    private String branchAddress;
    @SerializedName("location_latitude")
    @Expose
    private String locationLatitude;
    @SerializedName("location_longitude")
    @Expose
    private String locationLongitude;
    @SerializedName("main_branch")
    @Expose
    private Boolean mainBranch;
    @SerializedName("branch_status")
    @Expose
    private Boolean branchStatus;

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public Boolean getMainBranch() {
        return mainBranch;
    }

    public void setMainBranch(Boolean mainBranch) {
        this.mainBranch = mainBranch;
    }

    public Boolean getBranchStatus() {
        return branchStatus;
    }

    public void setBranchStatus(Boolean branchStatus) {
        this.branchStatus = branchStatus;
    }

}
