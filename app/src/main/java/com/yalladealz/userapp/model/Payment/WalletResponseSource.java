package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WalletResponseSource {

    @SerializedName("sub_type")
    @Expose
    private String subType;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("owner_name")
    @Expose
    private Object ownerName;
    @SerializedName("pan")
    @Expose
    private String pan;

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(Object ownerName) {
        this.ownerName = ownerName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

}
