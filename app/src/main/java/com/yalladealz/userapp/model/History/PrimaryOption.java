
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class PrimaryOption {

    @SerializedName("deal_discount")
    private String mDealDiscount;
    @SerializedName("deal_id")
    private String mDealId;
    @SerializedName("discount_amount")
    private String mDiscountAmount;
    @SerializedName("final_price")
    private String mFinalPrice;
    @SerializedName("id")
    private Long mId;
    @SerializedName("isprimary")
    private Boolean mIsprimary;
    @SerializedName("OptionDescription")
    private OptionDescription mOptionDescription;
    @SerializedName("OptionDescriptions")
    private Object mOptionDescriptions;
    @SerializedName("original_price")
    private String mOriginalPrice;

    public String getDealDiscount() {
        return mDealDiscount;
    }

    public void setDealDiscount(String dealDiscount) {
        mDealDiscount = dealDiscount;
    }

    public String getDealId() {
        return mDealId;
    }

    public void setDealId(String dealId) {
        mDealId = dealId;
    }

    public String getDiscountAmount() {
        return mDiscountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        mDiscountAmount = discountAmount;
    }

    public String getFinalPrice() {
        return mFinalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        mFinalPrice = finalPrice;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Boolean getIsprimary() {
        return mIsprimary;
    }

    public void setIsprimary(Boolean isprimary) {
        mIsprimary = isprimary;
    }

    public OptionDescription getOptionDescription() {
        return mOptionDescription;
    }

    public void setOptionDescription(OptionDescription optionDescription) {
        mOptionDescription = optionDescription;
    }

    public Object getOptionDescriptions() {
        return mOptionDescriptions;
    }

    public void setOptionDescriptions(Object optionDescriptions) {
        mOptionDescriptions = optionDescriptions;
    }

    public String getOriginalPrice() {
        return mOriginalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        mOriginalPrice = originalPrice;
    }

}
