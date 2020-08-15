package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FawryResponse {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("referenceNumber")
	@Expose
	private String referenceNumber;
	@SerializedName("merchantRefNumber")
	@Expose
	private String merchantRefNumber;
	@SerializedName("expirationTime")
	@Expose
	private Long expirationTime;
	@SerializedName("statusCode")
	@Expose
	private Integer statusCode;
	@SerializedName("statusDescription")
	@Expose
	private String statusDescription;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public FawryResponse() {
	}

	/**
	 *
	 * @param type
	 * @param referenceNumber
	 * @param merchantRefNumber
	 * @param expirationTime
	 * @param statusCode
	 * @param statusDescription
	 */
	public FawryResponse(String type, String referenceNumber, String merchantRefNumber, Long expirationTime, Integer statusCode, String statusDescription) {
		this.type = type;
		this.referenceNumber = referenceNumber;
		this.merchantRefNumber = merchantRefNumber;
		this.expirationTime = expirationTime;
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

	public Long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

}