
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class MerchantInfo {

    @SerializedName("Category")
    private Category mCategory;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("MerchantBranch")
    private Object mMerchantBranches;
    @SerializedName("MerchantContact")
    private MerchantContact mMerchantContact;
    @SerializedName("merchant_description")
    private String mMerchantDescription;
    @SerializedName("merchant_email")
    private String mMerchantEmail;
    @SerializedName("merchant_id")
    private Long mMerchantId;
    @SerializedName("merchant_landline")
    private String mMerchantLandline;
    @SerializedName("MerchantLogin")
    private MerchantLogin mMerchantLogin;
    @SerializedName("merchant_mobile")
    private String mMerchantMobile;
    @SerializedName("merchant_name")
    private String mMerchantName;
    @SerializedName("merchant_status")
    private Boolean mMerchantStatus;
    @SerializedName("merchant_website")
    private String mMerchantWebsite;
    @SerializedName("profile_cover")
    private String mProfileCover;
    @SerializedName("profile_image")
    private String mProfileImage;

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public Object getMerchantBranches() {
        return mMerchantBranches;
    }

    public void setMerchantBranches(Object merchantBranches) {
        mMerchantBranches = merchantBranches;
    }

    public MerchantContact getMerchantContact() {
        return mMerchantContact;
    }

    public void setMerchantContact(MerchantContact merchantContact) {
        mMerchantContact = merchantContact;
    }

    public String getMerchantDescription() {
        return mMerchantDescription;
    }

    public void setMerchantDescription(String merchantDescription) {
        mMerchantDescription = merchantDescription;
    }

    public String getMerchantEmail() {
        return mMerchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        mMerchantEmail = merchantEmail;
    }

    public Long getMerchantId() {
        return mMerchantId;
    }

    public void setMerchantId(Long merchantId) {
        mMerchantId = merchantId;
    }

    public String getMerchantLandline() {
        return mMerchantLandline;
    }

    public void setMerchantLandline(String merchantLandline) {
        mMerchantLandline = merchantLandline;
    }

    public MerchantLogin getMerchantLogin() {
        return mMerchantLogin;
    }

    public void setMerchantLogin(MerchantLogin merchantLogin) {
        mMerchantLogin = merchantLogin;
    }

    public String getMerchantMobile() {
        return mMerchantMobile;
    }

    public void setMerchantMobile(String merchantMobile) {
        mMerchantMobile = merchantMobile;
    }

    public String getMerchantName() {
        return mMerchantName;
    }

    public void setMerchantName(String merchantName) {
        mMerchantName = merchantName;
    }

    public Boolean getMerchantStatus() {
        return mMerchantStatus;
    }

    public void setMerchantStatus(Boolean merchantStatus) {
        mMerchantStatus = merchantStatus;
    }

    public String getMerchantWebsite() {
        return mMerchantWebsite;
    }

    public void setMerchantWebsite(String merchantWebsite) {
        mMerchantWebsite = merchantWebsite;
    }

    public String getProfileCover() {
        return mProfileCover;
    }

    public void setProfileCover(String profileCover) {
        mProfileCover = profileCover;
    }

    public String getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(String profileImage) {
        mProfileImage = profileImage;
    }

}
