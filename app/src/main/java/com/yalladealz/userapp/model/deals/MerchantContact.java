package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class MerchantContact {

    @SerializedName("contact_name")
    private String contactName;

    @SerializedName("merchant_id")
    private int merchantId;

    @SerializedName("contact_id")
    private String contactId;

    @SerializedName("contact_number")
    private String contactNumber;

    @SerializedName("contact_email")
    private String contactEmail;

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    @Override
    public String toString() {
        return
                "MerchantContact{" +
                        "contact_name = '" + contactName + '\'' +
                        ",merchant_id = '" + merchantId + '\'' +
                        ",contact_id = '" + contactId + '\'' +
                        ",contact_number = '" + contactNumber + '\'' +
                        ",contact_email = '" + contactEmail + '\'' +
                        "}";
    }
}