
package com.yalladealz.userapp.model.deals;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealOptions implements Parcelable
{

    Integer quantity;

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("deal_id")
    @Expose
    private String dealId;
    @SerializedName("original_price")
    @Expose
    private String originalPrice;
    @SerializedName("deal_discount")
    @Expose
    private String dealDiscount;
    @SerializedName("discount_amount")
    @Expose
    private String discountAmount;
    @SerializedName("final_price")
    @Expose
    private String finalPrice;
    @SerializedName("isprimary")
    @Expose
    private Boolean isprimary;
    @SerializedName("OptionDescription")
    @Expose
    private OptionDescription optionDescription;
    @SerializedName("OptionDescriptions")
    @Expose
    private List<OptionDescription> optionDescriptions = null;
    public final static Creator<DealOptions> CREATOR = new Creator<DealOptions>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DealOptions createFromParcel(Parcel in) {
            return new DealOptions(in);
        }

        public DealOptions[] newArray(int size) {
            return (new DealOptions[size]);
        }

    }
    ;

    protected DealOptions(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dealId = ((String) in.readValue((String.class.getClassLoader())));
        this.originalPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.dealDiscount = ((String) in.readValue((String.class.getClassLoader())));
        this.discountAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.finalPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.isprimary = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.optionDescription = ((OptionDescription) in.readValue((OptionDescription.class.getClassLoader())));
        in.readList(this.optionDescriptions, (com.yalladealz.userapp.model.deals.OptionDescription.class.getClassLoader()));
    }

    public DealOptions() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DealOptions withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public DealOptions withDealId(String dealId) {
        this.dealId = dealId;
        return this;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public DealOptions withOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public String getDealDiscount() {
        return dealDiscount;
    }

    public void setDealDiscount(String dealDiscount) {
        this.dealDiscount = dealDiscount;
    }

    public DealOptions withDealDiscount(String dealDiscount) {
        this.dealDiscount = dealDiscount;
        return this;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public DealOptions withDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public DealOptions withFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public Boolean getIsprimary() {
        return isprimary;
    }

    public void setIsprimary(Boolean isprimary) {
        this.isprimary = isprimary;
    }

    public DealOptions withIsprimary(Boolean isprimary) {
        this.isprimary = isprimary;
        return this;
    }

    public OptionDescription getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(OptionDescription optionDescription) {
        this.optionDescription = optionDescription;
    }

    public DealOptions withOptionDescription(OptionDescription optionDescription) {
        this.optionDescription = optionDescription;
        return this;
    }

    public List<OptionDescription> getOptionDescriptions() {
        return optionDescriptions;
    }

    public void setOptionDescriptions(List<OptionDescription> optionDescriptions) {
        this.optionDescriptions = optionDescriptions;
    }

    public DealOptions withOptionDescriptions(List<OptionDescription> optionDescriptions) {
        this.optionDescriptions = optionDescriptions;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(dealId);
        dest.writeValue(originalPrice);
        dest.writeValue(dealDiscount);
        dest.writeValue(discountAmount);
        dest.writeValue(finalPrice);
        dest.writeValue(isprimary);
        dest.writeValue(optionDescription);
        dest.writeList(optionDescriptions);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int describeContents() {
        return  0;
    }

}
