package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FawryStatusResponse {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("referenceNumber")
	@Expose
	private String referenceNumber;
	@SerializedName("merchantRefNumber")
	@Expose
	private String merchantRefNumber;
	@SerializedName("paymentAmount")
	@Expose
	private Integer paymentAmount;
	@SerializedName("paymentDate")
	@Expose
	private Integer paymentDate;
	@SerializedName("expirationTime")
	@Expose
	private Integer expirationTime;
	@SerializedName("paymentStatus")
	@Expose
	private String paymentStatus;
	@SerializedName("paymentMethod")
	@Expose
	private String paymentMethod;
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
	public FawryStatusResponse() {
	}

	/**
	 *
	 * @param statusCode
	 * @param statusDescription
	 * @param paymentDate
	 * @param paymentAmount
	 * @param expirationTime
	 * @param referenceNumber
	 * @param merchantRefNumber
	 * @param paymentStatus
	 * @param type
	 * @param paymentMethod
	 */
	public FawryStatusResponse(String type, String referenceNumber, String merchantRefNumber, Integer paymentAmount, Integer paymentDate, Integer expirationTime, String paymentStatus, String paymentMethod, Integer statusCode, String statusDescription) {
		super();
		this.type = type;
		this.referenceNumber = referenceNumber;
		this.merchantRefNumber = merchantRefNumber;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.expirationTime = expirationTime;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
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

	public Integer getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Integer getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Integer paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Integer expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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