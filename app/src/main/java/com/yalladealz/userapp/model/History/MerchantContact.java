
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class MerchantContact {

    @SerializedName("contact_email")
    private String mContactEmail;
    @SerializedName("contact_id")
    private String mContactId;
    @SerializedName("contact_name")
    private String mContactName;
    @SerializedName("contact_number")
    private String mContactNumber;
    @SerializedName("merchant_id")
    private Long mMerchantId;

    public String getContactEmail() {
        return mContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        mContactEmail = contactEmail;
    }

    public String getContactId() {
        return mContactId;
    }

    public void setContactId(String contactId) {
        mContactId = contactId;
    }

    public String getContactName() {
        return mContactName;
    }

    public void setContactName(String contactName) {
        mContactName = contactName;
    }

    public String getContactNumber() {
        return mContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        mContactNumber = contactNumber;
    }

    public Long getMerchantId() {
        return mMerchantId;
    }

    public void setMerchantId(Long merchantId) {
        mMerchantId = merchantId;
    }

}
