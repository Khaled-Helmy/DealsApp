package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {

	@SerializedName("token")
	@Expose
	private String token;
	@SerializedName("creationDate")
	@Expose
	private Long creationDate;
	@SerializedName("lastFourDigits")
	@Expose
	private String lastFourDigits;
	@SerializedName("brand")
	@Expose
	private String brand;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Card() {
	}

	/**
	 *  @param token
	 * @param creationDate
	 * @param lastFourDigits
	 * @param brand
	 */
	public Card(String token, Long creationDate, String lastFourDigits, String brand) {
		super();
		this.token = token;
		this.creationDate = creationDate;
		this.lastFourDigits = lastFourDigits;
		this.brand = brand;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastFourDigits() {
		return lastFourDigits;
	}

	public void setLastFourDigits(String lastFourDigits) {
		this.lastFourDigits = lastFourDigits;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}