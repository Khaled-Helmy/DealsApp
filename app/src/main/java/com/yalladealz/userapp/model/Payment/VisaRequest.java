package com.yalladealz.userapp.model.Payment;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisaRequest implements Parcelable
{

	@SerializedName("merchantCode")
	@Expose
	private String merchantCode;
	@SerializedName("customerProfileId")
	@Expose
	private String customerProfileId;
	@SerializedName("customerMobile")
	@Expose
	private String customerMobile;
	@SerializedName("customerEmail")
	@Expose
	private String customerEmail;
	@SerializedName("cardNumber")
	@Expose
	private String cardNumber;
	@SerializedName("expiryYear")
	@Expose
	private String expiryYear;
	@SerializedName("expiryMonth")
	@Expose
	private String expiryMonth;
	@SerializedName("cvv")
	@Expose
	private String cvv;
	public final static Parcelable.Creator<VisaRequest> CREATOR = new Creator<VisaRequest>() {


		@SuppressWarnings({
				"unchecked"
		})
		public VisaRequest createFromParcel(Parcel in) {
			return new VisaRequest(in);
		}

		public VisaRequest[] newArray(int size) {
			return (new VisaRequest[size]);
		}

	}
			;

	protected VisaRequest(Parcel in) {
		this.merchantCode = ((String) in.readValue((String.class.getClassLoader())));
		this.customerProfileId = ((String) in.readValue((String.class.getClassLoader())));
		this.customerMobile = ((String) in.readValue((String.class.getClassLoader())));
		this.customerEmail = ((String) in.readValue((String.class.getClassLoader())));
		this.cardNumber = ((String) in.readValue((String.class.getClassLoader())));
		this.expiryYear = ((String) in.readValue((String.class.getClassLoader())));
		this.expiryMonth = ((String) in.readValue((String.class.getClassLoader())));
		this.cvv = ((String) in.readValue((String.class.getClassLoader())));
	}

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public VisaRequest() {
	}

	/**
	 *
	 * @param expiryYear
	 * @param customerMobile
	 * @param expiryMonth
	 * @param cvv
	 * @param customerProfileId
	 * @param customerEmail
	 * @param merchantCode
	 * @param cardNumber
	 */
	public VisaRequest(String merchantCode, String customerProfileId, String customerMobile, String customerEmail, String cardNumber, String expiryYear, String expiryMonth, String cvv) {
		super();
		this.merchantCode = merchantCode;
		this.customerProfileId = customerProfileId;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.cardNumber = cardNumber;
		this.expiryYear = expiryYear;
		this.expiryMonth = expiryMonth;
		this.cvv = cvv;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getCustomerProfileId() {
		return customerProfileId;
	}

	public void setCustomerProfileId(String customerProfileId) {
		this.customerProfileId = customerProfileId;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(merchantCode);
		dest.writeValue(customerProfileId);
		dest.writeValue(customerMobile);
		dest.writeValue(customerEmail);
		dest.writeValue(cardNumber);
		dest.writeValue(expiryYear);
		dest.writeValue(expiryMonth);
		dest.writeValue(cvv);
	}

	public int describeContents() {
		return 0;
	}

}
