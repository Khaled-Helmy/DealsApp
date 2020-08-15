
package com.yalladealz.userapp.model.History;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DealData {

    @SerializedName("cash_on_delivery")
    private String mCashOnDelivery;
    @SerializedName("CategoryDescription")
    private CategoryDescription mCategoryDescription;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("CategoryInfo")
    private CategoryInfo mCategoryInfo;
    @SerializedName("coupon_valid_from")
    private String mCouponValidFrom;
    @SerializedName("coupon_valid_to")
    private String mCouponValidTo;
    @SerializedName("deal_branches[]")
    private List<String> mDealBranches;
    @SerializedName("DealDescription")
    private DealDescription mDealDescription;
    @SerializedName("DealDescriptions")
    private Object mDealDescriptions;
    @SerializedName("deal_end_date")
    private String mDealEndDate;
    @SerializedName("DealFiles")
    private List<DealFile> mDealFiles;
    @SerializedName("deal_id")
    private Long mDealId;
    @SerializedName("DealOptions")
    private Object mDealOptions;
    @SerializedName("DealRedeemed")
    private DealRedeemed mDealRedeemed;
    @SerializedName("DealReview")
    private Object mDealReview;
    @SerializedName("deal_start_date")
    private String mDealStartDate;
    @SerializedName("deal_type")
    private String mDealType;
    @SerializedName("deal_visible")
    private Boolean mDealVisible;
    @SerializedName("end_time")
    private String mEndTime;
    @SerializedName("image")
    private String mImage;
    @SerializedName("live_days")
    private String mLiveDays;
    @SerializedName("live_deal")
    private Boolean mLiveDeal;
    @SerializedName("max_buy")
    private String mMaxBuy;
    @SerializedName("max_coupon")
    private String mMaxCoupon;
    @SerializedName("merchant_id")
    private String mMerchantId;
    @SerializedName("MerchantInfo")
    private MerchantInfo mMerchantInfo;
    @SerializedName("min_buy")
    private String mMinBuy;
    @SerializedName("PrimaryOption")
    private PrimaryOption mPrimaryOption;
    @SerializedName("start_time")
    private String mStartTime;
    @SerializedName("total_review")
    private Long mTotalReview;
    @SerializedName("TypeDescription")
    private TypeDescription mTypeDescription;
    @SerializedName("type_id")
    private String mTypeId;
    @SerializedName("TypeInfo")
    private TypeInfo mTypeInfo;
    @SerializedName("youtube_link")
    private String mYoutubeLink;

    public String getCashOnDelivery() {
        return mCashOnDelivery;
    }

    public void setCashOnDelivery(String cashOnDelivery) {
        mCashOnDelivery = cashOnDelivery;
    }

    public CategoryDescription getCategoryDescription() {
        return mCategoryDescription;
    }

    public void setCategoryDescription(CategoryDescription categoryDescription) {
        mCategoryDescription = categoryDescription;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public CategoryInfo getCategoryInfo() {
        return mCategoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        mCategoryInfo = categoryInfo;
    }

    public String getCouponValidFrom() {
        return mCouponValidFrom;
    }

    public void setCouponValidFrom(String couponValidFrom) {
        mCouponValidFrom = couponValidFrom;
    }

    public String getCouponValidTo() {
        return mCouponValidTo;
    }

    public void setCouponValidTo(String couponValidTo) {
        mCouponValidTo = couponValidTo;
    }

    public List<String> getDealBranches() {
        return mDealBranches;
    }

    public void setDealBranches(List<String> dealBranches) {
        mDealBranches = dealBranches;
    }

    public DealDescription getDealDescription() {
        return mDealDescription;
    }

    public void setDealDescription(DealDescription dealDescription) {
        mDealDescription = dealDescription;
    }

    public Object getDealDescriptions() {
        return mDealDescriptions;
    }

    public void setDealDescriptions(Object dealDescriptions) {
        mDealDescriptions = dealDescriptions;
    }

    public String getDealEndDate() {
        return mDealEndDate;
    }

    public void setDealEndDate(String dealEndDate) {
        mDealEndDate = dealEndDate;
    }

    public List<DealFile> getDealFiles() {
        return mDealFiles;
    }

    public void setDealFiles(List<DealFile> dealFiles) {
        mDealFiles = dealFiles;
    }

    public Long getDealId() {
        return mDealId;
    }

    public void setDealId(Long dealId) {
        mDealId = dealId;
    }

    public Object getDealOptions() {
        return mDealOptions;
    }

    public void setDealOptions(Object dealOptions) {
        mDealOptions = dealOptions;
    }

    public DealRedeemed getDealRedeemed() {
        return mDealRedeemed;
    }

    public void setDealRedeemed(DealRedeemed dealRedeemed) {
        mDealRedeemed = dealRedeemed;
    }

    public Object getDealReview() {
        return mDealReview;
    }

    public void setDealReview(Object dealReview) {
        mDealReview = dealReview;
    }

    public String getDealStartDate() {
        return mDealStartDate;
    }

    public void setDealStartDate(String dealStartDate) {
        mDealStartDate = dealStartDate;
    }

    public String getDealType() {
        return mDealType;
    }

    public void setDealType(String dealType) {
        mDealType = dealType;
    }

    public Boolean getDealVisible() {
        return mDealVisible;
    }

    public void setDealVisible(Boolean dealVisible) {
        mDealVisible = dealVisible;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getLiveDays() {
        return mLiveDays;
    }

    public void setLiveDays(String liveDays) {
        mLiveDays = liveDays;
    }

    public Boolean getLiveDeal() {
        return mLiveDeal;
    }

    public void setLiveDeal(Boolean liveDeal) {
        mLiveDeal = liveDeal;
    }

    public String getMaxBuy() {
        return mMaxBuy;
    }

    public void setMaxBuy(String maxBuy) {
        mMaxBuy = maxBuy;
    }

    public String getMaxCoupon() {
        return mMaxCoupon;
    }

    public void setMaxCoupon(String maxCoupon) {
        mMaxCoupon = maxCoupon;
    }

    public String getMerchantId() {
        return mMerchantId;
    }

    public void setMerchantId(String merchantId) {
        mMerchantId = merchantId;
    }

    public MerchantInfo getMerchantInfo() {
        return mMerchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        mMerchantInfo = merchantInfo;
    }

    public String getMinBuy() {
        return mMinBuy;
    }

    public void setMinBuy(String minBuy) {
        mMinBuy = minBuy;
    }

    public PrimaryOption getPrimaryOption() {
        return mPrimaryOption;
    }

    public void setPrimaryOption(PrimaryOption primaryOption) {
        mPrimaryOption = primaryOption;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public Long getTotalReview() {
        return mTotalReview;
    }

    public void setTotalReview(Long totalReview) {
        mTotalReview = totalReview;
    }

    public TypeDescription getTypeDescription() {
        return mTypeDescription;
    }

    public void setTypeDescription(TypeDescription typeDescription) {
        mTypeDescription = typeDescription;
    }

    public String getTypeId() {
        return mTypeId;
    }

    public void setTypeId(String typeId) {
        mTypeId = typeId;
    }

    public TypeInfo getTypeInfo() {
        return mTypeInfo;
    }

    public void setTypeInfo(TypeInfo typeInfo) {
        mTypeInfo = typeInfo;
    }

    public String getYoutubeLink() {
        return mYoutubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        mYoutubeLink = youtubeLink;
    }

}
