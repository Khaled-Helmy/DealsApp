package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.SerializedName;

public class CardResponse {
	@SerializedName("type")
	private String type;
	@SerializedName("referenceNumber")
	private String referenceNumber;
	@SerializedName("merchantRefNumber")
	private String merchantRefNumber;
	@SerializedName("statusCode")
	private int statusCode;
	@SerializedName("statusDescription")
	private String statusDescription;

	public CardResponse() {
	}

	public CardResponse(String type, String referenceNumber, String merchantRefNumber, int statusCode, String statusDescription) {
		this.type = type;
		this.referenceNumber = referenceNumber;
		this.merchantRefNumber = merchantRefNumber;
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getMerchantRefNumber() {
		return merchantRefNumber;
	}

	public void setMerchantRefNumber(String merchantRefNumber) {
		this.merchantRefNumber = merchantRefNumber;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
