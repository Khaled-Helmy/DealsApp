
package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.SerializedName;

public class MobileVerificationResponse {

    @SerializedName("code")
    private String mCode;
    @SerializedName("etisalat")
    private Long mEtisalat;
    @SerializedName("Etisalat_cost")
    private Long mEtisalatCost;
    @SerializedName("Language")
    private String mLanguage;
    @SerializedName("orange")
    private Long mOrange;
    @SerializedName("orange_cost")
    private Long mOrangeCost;

    @SerializedName("SMSID")
    private Long mSMSID;

    @SerializedName("vodafone")
    private Long mVodafone;
    @SerializedName("Vodafone_cost")
    private Long mVodafoneCost;
    @SerializedName("we")
    private Long mWe;
    @SerializedName("we_cost")
    private Long mWeCost;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getEtisalat() {
        return mEtisalat;
    }

    public void setEtisalat(Long etisalat) {
        mEtisalat = etisalat;
    }

    public Long getEtisalatCost() {
        return mEtisalatCost;
    }

    public void setEtisalatCost(Long etisalatCost) {
        mEtisalatCost = etisalatCost;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public Long getOrange() {
        return mOrange;
    }

    public void setOrange(Long orange) {
        mOrange = orange;
    }

    public Long getOrangeCost() {
        return mOrangeCost;
    }

    public void setOrangeCost(Long orangeCost) {
        mOrangeCost = orangeCost;
    }

    public Long getSMSID() {
        return mSMSID;
    }

    public void setSMSID(Long sMSID) {
        mSMSID = sMSID;
    }

    public Long getVodafone() {
        return mVodafone;
    }

    public void setVodafone(Long vodafone) {
        mVodafone = vodafone;
    }

    public Long getVodafoneCost() {
        return mVodafoneCost;
    }

    public void setVodafoneCost(Long vodafoneCost) {
        mVodafoneCost = vodafoneCost;
    }

    public Long getWe() {
        return mWe;
    }

    public void setWe(Long we) {
        mWe = we;
    }

    public Long getWeCost() {
        return mWeCost;
    }

    public void setWeCost(Long weCost) {
        mWeCost = weCost;
    }

}
