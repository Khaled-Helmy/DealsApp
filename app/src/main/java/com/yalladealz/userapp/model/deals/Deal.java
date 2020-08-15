package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.History.DealRedeemed;

import java.util.List;

public class Deal {

    @SerializedName("deal_start_date")
    private String dealStartDate;

    @SerializedName("branch_latitude")
    private String branchLat;

    @SerializedName("branch_longitude")
    private String branchLong;

    @SerializedName("coupon_valid_from")
    private String couponValidFrom;

    @SerializedName("CategoryInfo")
    private CategoryInfo categoryInfo;

    @SerializedName("live_deal")
    private boolean liveDeal;

    @SerializedName("DealDescriptions")
    private Object dealDescriptions;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("cash_on_delivery")
    private String cashOnDelivery;

    @SerializedName("youtube_link")
    private String youtubeLink;

    @SerializedName("DealRedeemed")
    private DealRedeemed dealRedeemed;

    @SerializedName("coupon_valid_to")
    private String couponValidTo;

    @SerializedName("max_coupon")
    private String maxCoupon;

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("live_days")
    private String liveDays;

    @SerializedName("DealOptions")
    private List<DealOptions> dealOptions;

    @SerializedName("TypeDescription")
    private TypeDescription typeDescription;

    @SerializedName("deal_end_date")
    private String dealEndDate;

    @SerializedName("deal_id")
    private int dealId;

    @SerializedName("DealFiles")
    private List<DealFilesItem> dealFiles;

    @SerializedName("image")
    private String image;

    @SerializedName("PrimaryOption")
    private PrimaryOption primaryOption;

    @SerializedName("type_id")
    private String typeId;

    @SerializedName("deal_type")
    private String dealType;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("total_review")
    private int totalReview;

    @SerializedName("deal_visible")
    private boolean dealVisible;

    @SerializedName("DealReview")
    private List<DealReviewItem> dealReview;

    @SerializedName("TypeInfo")
    private TypeInfo typeInfo;

    @SerializedName("DealDescription")
    private DealDescription dealDescription;

    @SerializedName("start_time")
    private String startTime;

    @SerializedName("MerchantInfo")
    private MerchantInfo merchantInfo;

    @SerializedName("min_buy")
    private String minBuy;

    @SerializedName("CategoryDescription")
    private CategoryDescription categoryDescription;

    @SerializedName("max_buy")
    private String maxBuy;

    @SerializedName("deal_branches[]")
    private Object dealBranches;

    public String getBranchLat() {
        return branchLat;
    }

    public void setBranchLat(String branchLat) {
        this.branchLat = branchLat;
    }

    public String getBranchLong() {
        return branchLong;
    }

    public void setBranchLong(String branchLong) {
        this.branchLong = branchLong;
    }

    public void setDealStartDate(String dealStartDate) {
        this.dealStartDate = dealStartDate;
    }

    public String getDealStartDate() {
        return dealStartDate;
    }

    public void setCouponValidFrom(String couponValidFrom) {
        this.couponValidFrom = couponValidFrom;
    }

    public String getCouponValidFrom() {
        return couponValidFrom;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setLiveDeal(boolean liveDeal) {
        this.liveDeal = liveDeal;
    }

    public boolean isLiveDeal() {
        return liveDeal;
    }

    public void setDealDescriptions(Object dealDescriptions) {
        this.dealDescriptions = dealDescriptions;
    }

    public Object getDealDescriptions() {
        return dealDescriptions;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setCashOnDelivery(String cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    public String getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public DealRedeemed getDealRedeemed() {
        return dealRedeemed;
    }

    public void setDealRedeemed(DealRedeemed dealRedeemed) {
        this.dealRedeemed = dealRedeemed;
    }

    public void setCouponValidTo(String couponValidTo) {
        this.couponValidTo = couponValidTo;
    }

    public String getCouponValidTo() {
        return couponValidTo;
    }

    public void setMaxCoupon(String maxCoupon) {
        this.maxCoupon = maxCoupon;
    }

    public String getMaxCoupon() {
        return maxCoupon;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setLiveDays(String liveDays) {
        this.liveDays = liveDays;
    }

    public String getLiveDays() {
        return liveDays;
    }

    public void setDealOptions(List<DealOptions> dealOptions) {
        this.dealOptions = dealOptions;
    }

    public List<DealOptions> getDealOptions() {
        return dealOptions;
    }

    public void setTypeDescription(TypeDescription typeDescription) {
        this.typeDescription = typeDescription;
    }

    public TypeDescription getTypeDescription() {
        return typeDescription;
    }

    public void setDealEndDate(String dealEndDate) {
        this.dealEndDate = dealEndDate;
    }

    public String getDealEndDate() {
        return dealEndDate;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealFiles(List<DealFilesItem> dealFiles) {
        this.dealFiles = dealFiles;
    }

    public List<DealFilesItem> getDealFiles() {
        return dealFiles;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setPrimaryOption(PrimaryOption primaryOption) {
        this.primaryOption = primaryOption;
    }

    public PrimaryOption getPrimaryOption() {
        return primaryOption;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getDealType() {
        return dealType;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setTotalReview(int totalReview) {
        this.totalReview = totalReview;
    }

    public int getTotalReview() {
        return totalReview;
    }

    public void setDealVisible(boolean dealVisible) {
        this.dealVisible = dealVisible;
    }

    public boolean isDealVisible() {
        return dealVisible;
    }

    public List<DealReviewItem> getDealReview() {
        return dealReview;
    }

    public void setDealReview(List<DealReviewItem> dealReview) {
        this.dealReview = dealReview;
    }

    public void setTypeInfo(TypeInfo typeInfo) {
        this.typeInfo = typeInfo;
    }

    public TypeInfo getTypeInfo() {
        return typeInfo;
    }

    public void setDealDescription(DealDescription dealDescription) {
        this.dealDescription = dealDescription;
    }

    public DealDescription getDealDescription() {
        return dealDescription;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMinBuy(String minBuy) {
        this.minBuy = minBuy;
    }

    public String getMinBuy() {
        return minBuy;
    }

    public void setCategoryDescription(CategoryDescription categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public CategoryDescription getCategoryDescription() {
        return categoryDescription;
    }

    public void setMaxBuy(String maxBuy) {
        this.maxBuy = maxBuy;
    }

    public String getMaxBuy() {
        return maxBuy;
    }

    public void setDealBranches(Object dealBranches) {
        this.dealBranches = dealBranches;
    }

    public Object getDealBranches() {
        return dealBranches;
    }

    @Override
    public String toString() {
        return
                "Deal{" +
                        "deal_start_date = '" + dealStartDate + '\'' +
                        ",coupon_valid_from = '" + couponValidFrom + '\'' +
                        ",categoryInfo = '" + categoryInfo + '\'' +
                        ",live_deal = '" + liveDeal + '\'' +
                        ",dealDescriptions = '" + dealDescriptions + '\'' +
                        ",merchant_id = '" + merchantId + '\'' +
                        ",cash_on_delivery = '" + cashOnDelivery + '\'' +
                        ",youtube_link = '" + youtubeLink + '\'' +
                        ",dealRedeemed = '" + dealRedeemed + '\'' +
                        ",coupon_valid_to = '" + couponValidTo + '\'' +
                        ",max_coupon = '" + maxCoupon + '\'' +
                        ",category_id = '" + categoryId + '\'' +
                        ",live_days = '" + liveDays + '\'' +
                        ",dealOptions = '" + dealOptions + '\'' +
                        ",typeDescription = '" + typeDescription + '\'' +
                        ",deal_end_date = '" + dealEndDate + '\'' +
                        ",deal_id = '" + dealId + '\'' +
                        ",dealFiles = '" + dealFiles + '\'' +
                        ",image = '" + image + '\'' +
                        ",primaryOption = '" + primaryOption + '\'' +
                        ",type_id = '" + typeId + '\'' +
                        ",deal_type = '" + dealType + '\'' +
                        ",end_time = '" + endTime + '\'' +
                        ",total_review = '" + totalReview + '\'' +
                        ",deal_visible = '" + dealVisible + '\'' +
                        ",dealReview = '" + dealReview + '\'' +
                        ",typeInfo = '" + typeInfo + '\'' +
                        ",dealDescription = '" + dealDescription + '\'' +
                        ",start_time = '" + startTime + '\'' +
                        ",merchantInfo = '" + merchantInfo + '\'' +
                        ",min_buy = '" + minBuy + '\'' +
                        ",categoryDescription = '" + categoryDescription + '\'' +
                        ",max_buy = '" + maxBuy + '\'' +
                        ",deal_branches[] = '" + dealBranches + '\'' +
                        "}";
    }
}