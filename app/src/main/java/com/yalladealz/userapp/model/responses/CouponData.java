package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CouponData{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("item_id")
    @Expose
    private int itemId;
    @SerializedName("coupon_code")
    @Expose
    private String couponCode;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("expire_date")
    @Expose
    private String expireDate;
    @SerializedName("live_deal")
    @Expose
    private boolean liveDeal;
    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("is_used")
    @Expose
    private boolean isUsed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public boolean getLiveDeal() {
        return liveDeal;
    }

    public void setLiveDeal(boolean liveDeal) {
        this.liveDeal = liveDeal;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

}
