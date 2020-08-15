package com.yalladealz.userapp.model.deals;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MerchantBranch {
	@SerializedName("branch_id")
	@Expose
	private Integer branchId;
	@SerializedName("merchant_id")
	@Expose
	private Integer merchantId;
	@SerializedName("branch_name")
	@Expose
	private String branchName;
	@SerializedName("branch_city")
	@Expose
	private String branchCity;
	@SerializedName("branch_address")
	@Expose
	private String branchAddress;
	@SerializedName("location_latitude")
	@Expose
	private String locationLatitude;
	@SerializedName("location_longitude")
	@Expose
	private String locationLongitude;
	@SerializedName("main_branch")
	@Expose
	private Boolean mainBranch;
	@SerializedName("branch_status")
	@Expose
	private Boolean branchStatus;
	public final static Parcelable.Creator<MerchantBranch> CREATOR = new Parcelable.Creator<MerchantBranch>() {


		@SuppressWarnings({
				"unchecked"
		})
		public MerchantBranch createFromParcel(Parcel in) {
			return new MerchantBranch(in);
		}

		public MerchantBranch[] newArray(int size) {
			return (new MerchantBranch[size]);
		}

	}
			;

	protected MerchantBranch(Parcel in) {
		this.branchId = ((Integer) in.readValue((Integer.class.getClassLoader())));
		this.merchantId = ((Integer) in.readValue((Integer.class.getClassLoader())));
		this.branchName = ((String) in.readValue((String.class.getClassLoader())));
		this.branchCity = ((String) in.readValue((String.class.getClassLoader())));
		this.branchAddress = ((String) in.readValue((String.class.getClassLoader())));
		this.locationLatitude = ((String) in.readValue((String.class.getClassLoader())));
		this.locationLongitude = ((String) in.readValue((String.class.getClassLoader())));
		this.mainBranch = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
		this.branchStatus = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
	}

	public MerchantBranch() {
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public MerchantBranch withBranchId(Integer branchId) {
		this.branchId = branchId;
		return this;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public MerchantBranch withMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
		return this;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public MerchantBranch withBranchName(String branchName) {
		this.branchName = branchName;
		return this;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public MerchantBranch withBranchCity(String branchCity) {
		this.branchCity = branchCity;
		return this;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public MerchantBranch withBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
		return this;
	}

	public String getLocationLatitude() {
		return locationLatitude;
	}

	public void setLocationLatitude(String locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	public MerchantBranch withLocationLatitude(String locationLatitude) {
		this.locationLatitude = locationLatitude;
		return this;
	}

	public String getLocationLongitude() {
		return locationLongitude;
	}

	public void setLocationLongitude(String locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public MerchantBranch withLocationLongitude(String locationLongitude) {
		this.locationLongitude = locationLongitude;
		return this;
	}

	public Boolean getMainBranch() {
		return mainBranch;
	}

	public void setMainBranch(Boolean mainBranch) {
		this.mainBranch = mainBranch;
	}

	public MerchantBranch withMainBranch(Boolean mainBranch) {
		this.mainBranch = mainBranch;
		return this;
	}

	public Boolean getBranchStatus() {
		return branchStatus;
	}

	public void setBranchStatus(Boolean branchStatus) {
		this.branchStatus = branchStatus;
	}

	public MerchantBranch withBranchStatus(Boolean branchStatus) {
		this.branchStatus = branchStatus;
		return this;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(branchId);
		dest.writeValue(merchantId);
		dest.writeValue(branchName);
		dest.writeValue(branchCity);
		dest.writeValue(branchAddress);
		dest.writeValue(locationLatitude);
		dest.writeValue(locationLongitude);
		dest.writeValue(mainBranch);
		dest.writeValue(branchStatus);
	}

	public int describeContents() {
		return 0;
	}

}
