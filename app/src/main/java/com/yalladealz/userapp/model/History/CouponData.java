package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class CouponData {
	@SerializedName("id")
	private int id;
	@SerializedName("item_id")
	private int itemId;
	@SerializedName("coupon_code")
	private String couponCode;
	@SerializedName("start_date")
	private String startDate;
	@SerializedName("expire_date")
	private String expireDate;
	@SerializedName("live_deal")
	private boolean liveDeal;
	@SerializedName("days")
	private String days;
	@SerializedName("start_time")
	private String startTime;
	@SerializedName("end_time")
	private String endTime;
	@SerializedName("is_used")
	private boolean isUsed;

	public CouponData(int id, int itemId, String couponCode, String startDate, String expireDate, boolean liveDeal, String days, String startTime, String endTime, boolean isUsed) {
		this.id = id;
		this.itemId = itemId;
		this.couponCode = couponCode;
		this.startDate = startDate;
		this.expireDate = expireDate;
		this.liveDeal = liveDeal;
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isUsed = isUsed;
	}

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

	public boolean isLiveDeal() {
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

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean used) {
		isUsed = used;
	}
}
