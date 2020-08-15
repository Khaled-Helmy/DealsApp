package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisaResponse {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("card")
	@Expose
	private Card card;
	@SerializedName("statusCode")
	@Expose
	private Integer statusCode;
	@SerializedName("statusDescription")
	@Expose
	private String statusDescription;

	/**
	 * No args constructor for use in serialization
	 */
	public VisaResponse() {
	}

	/**
	 * @param statusCode
	 * @param statusDescription
	 * @param card
	 * @param type
	 */
	public VisaResponse(String type, Card card, Integer statusCode, String statusDescription) {
		super();
		this.type = type;
		this.card = card;
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
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