package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.SerializedName;

public class FawryStatusRequest {
	@SerializedName("merchantCode")
	String merchantCode;

	@SerializedName("merchantRefNumber")
	String merchantRefNumber;

	@SerializedName("signature")
	String signature;

	public FawryStatusRequest(String merchantCode, String merchantRefNumber, String signature) {
		this.merchantCode = merchantCode;
		this.merchantRefNumber = merchantRefNumber;
		this.signature = signature;
	}

	public FawryStatusRequest() {
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMerchantRefNumber() {
		return merchantRefNumber;
	}

	public void setMerchantRefNumber(String merchantRefNumber) {
		this.merchantRefNumber = merchantRefNumber;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
