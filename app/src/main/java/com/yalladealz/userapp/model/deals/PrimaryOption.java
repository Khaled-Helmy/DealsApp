package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class PrimaryOption {

    @SerializedName("original_price")
    private String originalPrice;

    @SerializedName("deal_discount")
    private String dealDiscount;

    @SerializedName("OptionDescription")
    private OptionDescription optionDescription;

    @SerializedName("final_price")
    private String finalPrice;

    @SerializedName("discount_amount")
    private String discountAmount;

    @SerializedName("OptionDescriptions")
    private Object optionDescriptions;

    @SerializedName("id")
    private int id;

    @SerializedName("deal_id")
    private String dealId;

    @SerializedName("isprimary")
    private boolean isprimary;

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setDealDiscount(String dealDiscount) {
        this.dealDiscount = dealDiscount;
    }

    public String getDealDiscount() {
        return dealDiscount;
    }

    public void setOptionDescription(OptionDescription optionDescription) {
        this.optionDescription = optionDescription;
    }

    public OptionDescription getOptionDescription() {
        return optionDescription;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public Object getOptionDescriptions() {
        return optionDescriptions;
    }

    public void setOptionDescriptions(Object optionDescriptions) {
        this.optionDescriptions = optionDescriptions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealId() {
        return dealId;
    }

    public void setIsprimary(boolean isprimary) {
        this.isprimary = isprimary;
    }

    public boolean isIsprimary() {
        return isprimary;
    }

    @Override
    public String toString() {
        return
                "PrimaryOption{" +
                        "original_price = '" + originalPrice + '\'' +
                        ",deal_discount = '" + dealDiscount + '\'' +
                        ",optionDescription = '" + optionDescription + '\'' +
                        ",final_price = '" + finalPrice + '\'' +
                        ",discount_amount = '" + discountAmount + '\'' +
                        ",optionDescriptions = '" + optionDescriptions + '\'' +
                        ",id = '" + id + '\'' +
                        ",deal_id = '" + dealId + '\'' +
                        ",isprimary = '" + isprimary + '\'' +
                        "}";
    }
}