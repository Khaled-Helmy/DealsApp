package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MerchantInfo {

    @SerializedName("merchant_email")
    private String merchantEmail;

    @SerializedName("MerchantBranches")
    private List<MerchantBranch> merchantBranches;

    @SerializedName("Category")
    private Category category;

    @SerializedName("profile_cover")
    private String profileCover;

    @SerializedName("merchant_mobile")
    private String merchantMobile;

    @SerializedName("merchant_name")
    private String merchantName;

    @SerializedName("merchant_id")
    private int merchantId;

    @SerializedName("merchant_status")
    private boolean merchantStatus;

    @SerializedName("merchant_landline")
    private String merchantLandline;

    @SerializedName("merchant_website")
    private String merchantWebsite;

    @SerializedName("profile_image")
    private String profileImage;

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("merchant_description")
    private String merchantDescription;

    @SerializedName("MerchantLogin")
    private MerchantLogin merchantLogin;

    @SerializedName("MerchantContact")
    private MerchantContact merchantContact;

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantBranches(List<MerchantBranch> merchantBranches) {
        this.merchantBranches = merchantBranches;
    }

    public List<MerchantBranch> getMerchantBranches() {
        return merchantBranches;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setProfileCover(String profileCover) {
        this.profileCover = profileCover;
    }

    public String getProfileCover() {
        return profileCover;
    }

    public void setMerchantMobile(String merchantMobile) {
        this.merchantMobile = merchantMobile;
    }

    public String getMerchantMobile() {
        return merchantMobile;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantStatus(boolean merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public boolean isMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantLandline(String merchantLandline) {
        this.merchantLandline = merchantLandline;
    }

    public String getMerchantLandline() {
        return merchantLandline;
    }

    public void setMerchantWebsite(String merchantWebsite) {
        this.merchantWebsite = merchantWebsite;
    }

    public String getMerchantWebsite() {
        return merchantWebsite;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setMerchantDescription(String merchantDescription) {
        this.merchantDescription = merchantDescription;
    }

    public String getMerchantDescription() {
        return merchantDescription;
    }

    public void setMerchantLogin(MerchantLogin merchantLogin) {
        this.merchantLogin = merchantLogin;
    }

    public MerchantLogin getMerchantLogin() {
        return merchantLogin;
    }

    public void setMerchantContact(MerchantContact merchantContact) {
        this.merchantContact = merchantContact;
    }

    public MerchantContact getMerchantContact() {
        return merchantContact;
    }

    @Override
    public String toString() {
        return
                "MerchantInfo{" +
                        "merchant_email = '" + merchantEmail + '\'' +
                        ",merchantBranches = '" + merchantBranches + '\'' +
                        ",category = '" + category + '\'' +
                        ",profile_cover = '" + profileCover + '\'' +
                        ",merchant_mobile = '" + merchantMobile + '\'' +
                        ",merchant_name = '" + merchantName + '\'' +
                        ",merchant_id = '" + merchantId + '\'' +
                        ",merchant_status = '" + merchantStatus + '\'' +
                        ",merchant_landline = '" + merchantLandline + '\'' +
                        ",merchant_website = '" + merchantWebsite + '\'' +
                        ",profile_image = '" + profileImage + '\'' +
                        ",category_id = '" + categoryId + '\'' +
                        ",merchant_description = '" + merchantDescription + '\'' +
                        ",merchantLogin = '" + merchantLogin + '\'' +
                        ",merchantContact = '" + merchantContact + '\'' +
                        "}";
    }
}