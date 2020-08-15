
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class Deal {

    @SerializedName("AdminData")
    private AdminData mAdminData;
    @SerializedName("admin_id")
    private String mAdminId;
    @SerializedName("Coupons")
    private Object mCoupons;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("DealData")
    private DealData mDealData;
    @SerializedName("deal_description")
    private String mDealDescription;
    @SerializedName("deal_id")
    private String mDealId;
    @SerializedName("deal_name")
    private String mDealName;
    @SerializedName("id")
    private Long mId;
    @SerializedName("item_price")
    private String mItemPrice;
    @SerializedName("lang_id")
    private String mLangId;
    @SerializedName("order_id")
    private String mOrderId;
    @SerializedName("quantity")
    private String mQuantity;
    @SerializedName("total_price")
    private String mTotalPrice;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public AdminData getAdminData() {
        return mAdminData;
    }

    public void setAdminData(AdminData adminData) {
        mAdminData = adminData;
    }

    public String getAdminId() {
        return mAdminId;
    }

    public void setAdminId(String adminId) {
        mAdminId = adminId;
    }

    public Object getCoupons() {
        return mCoupons;
    }

    public void setCoupons(Object coupons) {
        mCoupons = coupons;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public DealData getDealData() {
        return mDealData;
    }

    public void setDealData(DealData dealData) {
        mDealData = dealData;
    }

    public String getDealDescription() {
        return mDealDescription;
    }

    public void setDealDescription(String dealDescription) {
        mDealDescription = dealDescription;
    }

    public String getDealId() {
        return mDealId;
    }

    public void setDealId(String dealId) {
        mDealId = dealId;
    }

    public String getDealName() {
        return mDealName;
    }

    public void setDealName(String dealName) {
        mDealName = dealName;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getItemPrice() {
        return mItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        mItemPrice = itemPrice;
    }

    public String getLangId() {
        return mLangId;
    }

    public void setLangId(String langId) {
        mLangId = langId;
    }

    public String getOrderId() {
        return mOrderId;
    }

    public void setOrderId(String orderId) {
        mOrderId = orderId;
    }

    public String getQuantity() {
        return mQuantity;
    }

    public void setQuantity(String quantity) {
        mQuantity = quantity;
    }

    public String getTotalPrice() {
        return mTotalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        mTotalPrice = totalPrice;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
