package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.SerializedName;

public class FawryCallback {
	@SerializedName("FawryRefNo")
	private String fawryRef;
	@SerializedName("MerchnatRefNo")
	private String merchantRef;
	@SerializedName("OrderStatus")
	private String orderStatus;
	@SerializedName("Amount")
	private Integer amount;
	@SerializedName("MessageSignature")
	private String messageSignature;

	public FawryCallback(String fawryRef, String merchantRef, String orderStatus, Integer amount, String messageSignature) {
		this.fawryRef = fawryRef;
		this.merchantRef = merchantRef;
		this.orderStatus = orderStatus;
		this.amount = amount;
		this.messageSignature = messageSignature;
	}

	public String getFawryRef() {
		return fawryRef;
	}

	public String getMerchantRef() {
		return merchantRef;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getMessageSignature() {
		return messageSignature;
	}
}
