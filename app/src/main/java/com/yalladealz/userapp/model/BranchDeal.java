package com.yalladealz.userapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BranchDeal {

    @SerializedName("deal_id")
    @Expose
    private Integer dealId;
    @SerializedName("type_id")
    @Expose
    private String typeId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("youtube_link")
    @Expose
    private String youtubeLink;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("total_review")
    @Expose
    private Integer totalReview;
    @SerializedName("DealFiles")
    @Expose
    private List<DealFile> dealFiles = null;
    @SerializedName("DealDescription")
    @Expose
    private DealDescription dealDescription;
    @SerializedName("PrimaryOption")
    @Expose
    private PrimaryOption primaryOption;
    @SerializedName("DealReview")
    @Expose
    private List<DealReview> dealReview = null;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(Integer totalReview) {
        this.totalReview = totalReview;
    }

    public List<DealFile> getDealFiles() {
        return dealFiles;
    }

    public void setDealFiles(List<DealFile> dealFiles) {
        this.dealFiles = dealFiles;
    }

    public DealDescription getDealDescription() {
        return dealDescription;
    }

    public void setDealDescription(DealDescription dealDescription) {
        this.dealDescription = dealDescription;
    }

    public PrimaryOption getPrimaryOption() {
        return primaryOption;
    }

    public void setPrimaryOption(PrimaryOption primaryOption) {
        this.primaryOption = primaryOption;
    }

    public List<DealReview> getDealReview() {
        return dealReview;
    }

    public void setDealReview(List<DealReview> dealReview) {
        this.dealReview = dealReview;
    }

    public class Category {

        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("parent_id")
        @Expose
        private String parentId;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("CategoryDescriptions")
        @Expose
        private Object categoryDescriptions;
        @SerializedName("CategoryDescription")
        @Expose
        private CategoryDescription__ categoryDescription;
        @SerializedName("ParentDescription")
        @Expose
        private ParentDescription_ parentDescription;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getCategoryDescriptions() {
            return categoryDescriptions;
        }

        public void setCategoryDescriptions(Object categoryDescriptions) {
            this.categoryDescriptions = categoryDescriptions;
        }

        public CategoryDescription__ getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(CategoryDescription__ categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public ParentDescription_ getParentDescription() {
            return parentDescription;
        }

        public void setParentDescription(ParentDescription_ parentDescription) {
            this.parentDescription = parentDescription;
        }

    }

    public class CategoryDescription {

        @SerializedName("description_id")
        @Expose
        private String descriptionId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_description")
        @Expose
        private String categoryDescription;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDescriptionId() {
            return descriptionId;
        }

        public void setDescriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class CategoryDescription_ {

        @SerializedName("description_id")
        @Expose
        private String descriptionId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_description")
        @Expose
        private String categoryDescription;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDescriptionId() {
            return descriptionId;
        }

        public void setDescriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class CategoryDescription__ {

        @SerializedName("description_id")
        @Expose
        private String descriptionId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_description")
        @Expose
        private String categoryDescription;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDescriptionId() {
            return descriptionId;
        }

        public void setDescriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class CategoryInfo {

        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("parent_id")
        @Expose
        private String parentId;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("CategoryDescriptions")
        @Expose
        private Object categoryDescriptions;
        @SerializedName("CategoryDescription")
        @Expose
        private CategoryDescription categoryDescription;
        @SerializedName("ParentDescription")
        @Expose
        private ParentDescription parentDescription;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getCategoryDescriptions() {
            return categoryDescriptions;
        }

        public void setCategoryDescriptions(Object categoryDescriptions) {
            this.categoryDescriptions = categoryDescriptions;
        }

        public CategoryDescription getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(CategoryDescription categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public ParentDescription getParentDescription() {
            return parentDescription;
        }

        public void setParentDescription(ParentDescription parentDescription) {
            this.parentDescription = parentDescription;
        }

    }

    public class DealDescription {

        @SerializedName("deal_id")
        @Expose
        private String dealId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("deal_name")
        @Expose
        private String dealName;
        @SerializedName("deal_description")
        @Expose
        private String dealDescription;
        @SerializedName("deal_highlights")
        @Expose
        private String dealHighlights;
        @SerializedName("deal_conditions")
        @Expose
        private String dealConditions;
        @SerializedName("tags")
        @Expose
        private String tags;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDealId() {
            return dealId;
        }

        public void setDealId(String dealId) {
            this.dealId = dealId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getDealName() {
            return dealName;
        }

        public void setDealName(String dealName) {
            this.dealName = dealName;
        }

        public String getDealDescription() {
            return dealDescription;
        }

        public void setDealDescription(String dealDescription) {
            this.dealDescription = dealDescription;
        }

        public String getDealHighlights() {
            return dealHighlights;
        }

        public void setDealHighlights(String dealHighlights) {
            this.dealHighlights = dealHighlights;
        }

        public String getDealConditions() {
            return dealConditions;
        }

        public void setDealConditions(String dealConditions) {
            this.dealConditions = dealConditions;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class DealDescription_ {

        @SerializedName("deal_id")
        @Expose
        private String dealId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("deal_name")
        @Expose
        private String dealName;
        @SerializedName("deal_description")
        @Expose
        private String dealDescription;
        @SerializedName("deal_highlights")
        @Expose
        private String dealHighlights;
        @SerializedName("deal_conditions")
        @Expose
        private String dealConditions;
        @SerializedName("tags")
        @Expose
        private String tags;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDealId() {
            return dealId;
        }

        public void setDealId(String dealId) {
            this.dealId = dealId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getDealName() {
            return dealName;
        }

        public void setDealName(String dealName) {
            this.dealName = dealName;
        }

        public String getDealDescription() {
            return dealDescription;
        }

        public void setDealDescription(String dealDescription) {
            this.dealDescription = dealDescription;
        }

        public String getDealHighlights() {
            return dealHighlights;
        }

        public void setDealHighlights(String dealHighlights) {
            this.dealHighlights = dealHighlights;
        }

        public String getDealConditions() {
            return dealConditions;
        }

        public void setDealConditions(String dealConditions) {
            this.dealConditions = dealConditions;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class DealFile {

        @SerializedName("deal_id")
        @Expose
        private Integer dealId;
        @SerializedName("file_type")
        @Expose
        private String fileType;
        @SerializedName("file_name")
        @Expose
        private String fileName;

        public Integer getDealId() {
            return dealId;
        }

        public void setDealId(Integer dealId) {
            this.dealId = dealId;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

    }

    public class DealRedeemed {

        @SerializedName("redeemed_id")
        @Expose
        private Integer redeemedId;
        @SerializedName("redeemed")
        @Expose
        private Boolean redeemed;
        @SerializedName("deal_id")
        @Expose
        private Integer dealId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;

        public Integer getRedeemedId() {
            return redeemedId;
        }

        public void setRedeemedId(Integer redeemedId) {
            this.redeemedId = redeemedId;
        }

        public Boolean getRedeemed() {
            return redeemed;
        }

        public void setRedeemed(Boolean redeemed) {
            this.redeemed = redeemed;
        }

        public Integer getDealId() {
            return dealId;
        }

        public void setDealId(Integer dealId) {
            this.dealId = dealId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

    }

    public class DealReview {

        @SerializedName("review_id")
        @Expose
        private Integer reviewId;
        @SerializedName("deal_id")
        @Expose
        private Integer dealId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("rate")
        @Expose
        private Integer rate;
        @SerializedName("review_comment")
        @Expose
        private String reviewComment;
        @SerializedName("total_review")
        @Expose
        private String totalReview;
        @SerializedName("Deal")
        @Expose
        private Deal_ deal;
        @SerializedName("User")
        @Expose
        private User user;

        public Integer getReviewId() {
            return reviewId;
        }

        public void setReviewId(Integer reviewId) {
            this.reviewId = reviewId;
        }

        public Integer getDealId() {
            return dealId;
        }

        public void setDealId(Integer dealId) {
            this.dealId = dealId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getRate() {
            return rate;
        }

        public void setRate(Integer rate) {
            this.rate = rate;
        }

        public String getReviewComment() {
            return reviewComment;
        }

        public void setReviewComment(String reviewComment) {
            this.reviewComment = reviewComment;
        }

        public String getTotalReview() {
            return totalReview;
        }

        public void setTotalReview(String totalReview) {
            this.totalReview = totalReview;
        }

        public Deal_ getDeal() {
            return deal;
        }

        public void setDeal(Deal_ deal) {
            this.deal = deal;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }

    public class Deal_ {

        @SerializedName("deal_id")
        @Expose
        private Integer dealId;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("merchant_id")
        @Expose
        private String merchantId;
        @SerializedName("deal_start_date")
        @Expose
        private String dealStartDate;
        @SerializedName("deal_end_date")
        @Expose
        private String dealEndDate;
        @SerializedName("coupon_valid_from")
        @Expose
        private String couponValidFrom;
        @SerializedName("coupon_valid_to")
        @Expose
        private String couponValidTo;
        @SerializedName("live_deal")
        @Expose
        private Boolean liveDeal;
        @SerializedName("live_days")
        @Expose
        private String liveDays;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("max_coupon")
        @Expose
        private String maxCoupon;
        @SerializedName("min_buy")
        @Expose
        private String minBuy;
        @SerializedName("max_buy")
        @Expose
        private String maxBuy;
        @SerializedName("deal_visible")
        @Expose
        private Boolean dealVisible;
        @SerializedName("deal_type")
        @Expose
        private String dealType;
        @SerializedName("youtube_link")
        @Expose
        private String youtubeLink;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("cash_on_delivery")
        @Expose
        private String cashOnDelivery;
        @SerializedName("total_review")
        @Expose
        private Integer totalReview;
        @SerializedName("deal_branches[]")
        @Expose
        private Object dealBranches;
        @SerializedName("DealDescriptions")
        @Expose
        private Object dealDescriptions;
        @SerializedName("DealFiles")
        @Expose
        private Object dealFiles;
        @SerializedName("DealDescription")
        @Expose
        private DealDescription_ dealDescription;
        @SerializedName("DealOptions")
        @Expose
        private Object dealOptions;
        @SerializedName("PrimaryOption")
        @Expose
        private PrimaryOption_ primaryOption;
        @SerializedName("DealReview")
        @Expose
        private Object dealReview;
        @SerializedName("CategoryInfo")
        @Expose
        private CategoryInfo categoryInfo;
        @SerializedName("CategoryDescription")
        @Expose
        private CategoryDescription_ categoryDescription;
        @SerializedName("TypeInfo")
        @Expose
        private TypeInfo typeInfo;
        @SerializedName("TypeDescription")
        @Expose
        private TypeDescription_ typeDescription;
        @SerializedName("MerchantInfo")
        @Expose
        private MerchantInfo merchantInfo;
        @SerializedName("DealRedeemed")
        @Expose
        private DealRedeemed dealRedeemed;

        public Integer getDealId() {
            return dealId;
        }

        public void setDealId(Integer dealId) {
            this.dealId = dealId;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getDealStartDate() {
            return dealStartDate;
        }

        public void setDealStartDate(String dealStartDate) {
            this.dealStartDate = dealStartDate;
        }

        public String getDealEndDate() {
            return dealEndDate;
        }

        public void setDealEndDate(String dealEndDate) {
            this.dealEndDate = dealEndDate;
        }

        public String getCouponValidFrom() {
            return couponValidFrom;
        }

        public void setCouponValidFrom(String couponValidFrom) {
            this.couponValidFrom = couponValidFrom;
        }

        public String getCouponValidTo() {
            return couponValidTo;
        }

        public void setCouponValidTo(String couponValidTo) {
            this.couponValidTo = couponValidTo;
        }

        public Boolean getLiveDeal() {
            return liveDeal;
        }

        public void setLiveDeal(Boolean liveDeal) {
            this.liveDeal = liveDeal;
        }

        public String getLiveDays() {
            return liveDays;
        }

        public void setLiveDays(String liveDays) {
            this.liveDays = liveDays;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getMaxCoupon() {
            return maxCoupon;
        }

        public void setMaxCoupon(String maxCoupon) {
            this.maxCoupon = maxCoupon;
        }

        public String getMinBuy() {
            return minBuy;
        }

        public void setMinBuy(String minBuy) {
            this.minBuy = minBuy;
        }

        public String getMaxBuy() {
            return maxBuy;
        }

        public void setMaxBuy(String maxBuy) {
            this.maxBuy = maxBuy;
        }

        public Boolean getDealVisible() {
            return dealVisible;
        }

        public void setDealVisible(Boolean dealVisible) {
            this.dealVisible = dealVisible;
        }

        public String getDealType() {
            return dealType;
        }

        public void setDealType(String dealType) {
            this.dealType = dealType;
        }

        public String getYoutubeLink() {
            return youtubeLink;
        }

        public void setYoutubeLink(String youtubeLink) {
            this.youtubeLink = youtubeLink;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCashOnDelivery() {
            return cashOnDelivery;
        }

        public void setCashOnDelivery(String cashOnDelivery) {
            this.cashOnDelivery = cashOnDelivery;
        }

        public Integer getTotalReview() {
            return totalReview;
        }

        public void setTotalReview(Integer totalReview) {
            this.totalReview = totalReview;
        }

        public Object getDealBranches() {
            return dealBranches;
        }

        public void setDealBranches(Object dealBranches) {
            this.dealBranches = dealBranches;
        }

        public Object getDealDescriptions() {
            return dealDescriptions;
        }

        public void setDealDescriptions(Object dealDescriptions) {
            this.dealDescriptions = dealDescriptions;
        }

        public Object getDealFiles() {
            return dealFiles;
        }

        public void setDealFiles(Object dealFiles) {
            this.dealFiles = dealFiles;
        }

        public DealDescription_ getDealDescription() {
            return dealDescription;
        }

        public void setDealDescription(DealDescription_ dealDescription) {
            this.dealDescription = dealDescription;
        }

        public Object getDealOptions() {
            return dealOptions;
        }

        public void setDealOptions(Object dealOptions) {
            this.dealOptions = dealOptions;
        }

        public PrimaryOption_ getPrimaryOption() {
            return primaryOption;
        }

        public void setPrimaryOption(PrimaryOption_ primaryOption) {
            this.primaryOption = primaryOption;
        }

        public Object getDealReview() {
            return dealReview;
        }

        public void setDealReview(Object dealReview) {
            this.dealReview = dealReview;
        }

        public CategoryInfo getCategoryInfo() {
            return categoryInfo;
        }

        public void setCategoryInfo(CategoryInfo categoryInfo) {
            this.categoryInfo = categoryInfo;
        }

        public CategoryDescription_ getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(CategoryDescription_ categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public TypeInfo getTypeInfo() {
            return typeInfo;
        }

        public void setTypeInfo(TypeInfo typeInfo) {
            this.typeInfo = typeInfo;
        }

        public TypeDescription_ getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(TypeDescription_ typeDescription) {
            this.typeDescription = typeDescription;
        }

        public MerchantInfo getMerchantInfo() {
            return merchantInfo;
        }

        public void setMerchantInfo(MerchantInfo merchantInfo) {
            this.merchantInfo = merchantInfo;
        }

        public DealRedeemed getDealRedeemed() {
            return dealRedeemed;
        }

        public void setDealRedeemed(DealRedeemed dealRedeemed) {
            this.dealRedeemed = dealRedeemed;
        }

    }

    public class MerchantContact {

        @SerializedName("contact_id")
        @Expose
        private String contactId;
        @SerializedName("merchant_id")
        @Expose
        private Integer merchantId;
        @SerializedName("contact_name")
        @Expose
        private String contactName;
        @SerializedName("contact_number")
        @Expose
        private String contactNumber;
        @SerializedName("contact_email")
        @Expose
        private String contactEmail;

        public String getContactId() {
            return contactId;
        }

        public void setContactId(String contactId) {
            this.contactId = contactId;
        }

        public Integer getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(Integer merchantId) {
            this.merchantId = merchantId;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

    }

    public class MerchantInfo {

        @SerializedName("merchant_id")
        @Expose
        private Integer merchantId;
        @SerializedName("merchant_name")
        @Expose
        private String merchantName;
        @SerializedName("merchant_email")
        @Expose
        private String merchantEmail;
        @SerializedName("merchant_mobile")
        @Expose
        private String merchantMobile;
        @SerializedName("merchant_landline")
        @Expose
        private String merchantLandline;
        @SerializedName("merchant_website")
        @Expose
        private String merchantWebsite;
        @SerializedName("merchant_description")
        @Expose
        private String merchantDescription;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
        @SerializedName("profile_cover")
        @Expose
        private String profileCover;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("merchant_status")
        @Expose
        private Boolean merchantStatus;
        @SerializedName("MerchantBranch")
        @Expose
        private Object merchantBranches;
        @SerializedName("MerchantContact")
        @Expose
        private MerchantContact merchantContact;
        @SerializedName("MerchantLogin")
        @Expose
        private MerchantLogin merchantLogin;
        @SerializedName("Category")
        @Expose
        private Category category;

        public Integer getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(Integer merchantId) {
            this.merchantId = merchantId;
        }

        public String getMerchantName() {
            return merchantName;
        }

        public void setMerchantName(String merchantName) {
            this.merchantName = merchantName;
        }

        public String getMerchantEmail() {
            return merchantEmail;
        }

        public void setMerchantEmail(String merchantEmail) {
            this.merchantEmail = merchantEmail;
        }

        public String getMerchantMobile() {
            return merchantMobile;
        }

        public void setMerchantMobile(String merchantMobile) {
            this.merchantMobile = merchantMobile;
        }

        public String getMerchantLandline() {
            return merchantLandline;
        }

        public void setMerchantLandline(String merchantLandline) {
            this.merchantLandline = merchantLandline;
        }

        public String getMerchantWebsite() {
            return merchantWebsite;
        }

        public void setMerchantWebsite(String merchantWebsite) {
            this.merchantWebsite = merchantWebsite;
        }

        public String getMerchantDescription() {
            return merchantDescription;
        }

        public void setMerchantDescription(String merchantDescription) {
            this.merchantDescription = merchantDescription;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public String getProfileCover() {
            return profileCover;
        }

        public void setProfileCover(String profileCover) {
            this.profileCover = profileCover;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public Boolean getMerchantStatus() {
            return merchantStatus;
        }

        public void setMerchantStatus(Boolean merchantStatus) {
            this.merchantStatus = merchantStatus;
        }

        public Object getMerchantBranches() {
            return merchantBranches;
        }

        public void setMerchantBranches(Object merchantBranches) {
            this.merchantBranches = merchantBranches;
        }

        public MerchantContact getMerchantContact() {
            return merchantContact;
        }

        public void setMerchantContact(MerchantContact merchantContact) {
            this.merchantContact = merchantContact;
        }

        public MerchantLogin getMerchantLogin() {
            return merchantLogin;
        }

        public void setMerchantLogin(MerchantLogin merchantLogin) {
            this.merchantLogin = merchantLogin;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

    }

    public class MerchantLogin {

        @SerializedName("login_id")
        @Expose
        private Integer loginId;
        @SerializedName("merchant_id")
        @Expose
        private Integer merchantId;
        @SerializedName("merchant_login_email")
        @Expose
        private String merchantLoginEmail;
        @SerializedName("merchant_login_password")
        @Expose
        private String merchantLoginPassword;

        public Integer getLoginId() {
            return loginId;
        }

        public void setLoginId(Integer loginId) {
            this.loginId = loginId;
        }

        public Integer getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(Integer merchantId) {
            this.merchantId = merchantId;
        }

        public String getMerchantLoginEmail() {
            return merchantLoginEmail;
        }

        public void setMerchantLoginEmail(String merchantLoginEmail) {
            this.merchantLoginEmail = merchantLoginEmail;
        }

        public String getMerchantLoginPassword() {
            return merchantLoginPassword;
        }

        public void setMerchantLoginPassword(String merchantLoginPassword) {
            this.merchantLoginPassword = merchantLoginPassword;
        }

    }

    public static class OptionDescription {

        @SerializedName("option_id")
        @Expose
        private String optionId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("option_name")
        @Expose
        private String optionName;

        public String getOptionId() {
            return optionId;
        }

        public void setOptionId(String optionId) {
            this.optionId = optionId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getOptionName() {
            return optionName;
        }

        public void setOptionName(String optionName) {
            this.optionName = optionName;
        }

    }

    public class OptionDescription_ {

        @SerializedName("option_id")
        @Expose
        private String optionId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("option_name")
        @Expose
        private String optionName;

        public String getOptionId() {
            return optionId;
        }

        public void setOptionId(String optionId) {
            this.optionId = optionId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getOptionName() {
            return optionName;
        }

        public void setOptionName(String optionName) {
            this.optionName = optionName;
        }

    }

    public class ParentDescription {

        @SerializedName("description_id")
        @Expose
        private String descriptionId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_description")
        @Expose
        private String categoryDescription;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDescriptionId() {
            return descriptionId;
        }

        public void setDescriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class ParentDescription_ {

        @SerializedName("description_id")
        @Expose
        private String descriptionId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_description")
        @Expose
        private String categoryDescription;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDescriptionId() {
            return descriptionId;
        }

        public void setDescriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public static class PrimaryOption {

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
        private Object optionDescriptions;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDealId() {
            return dealId;
        }

        public void setDealId(String dealId) {
            this.dealId = dealId;
        }

        public String getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(String originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getDealDiscount() {
            return dealDiscount;
        }

        public void setDealDiscount(String dealDiscount) {
            this.dealDiscount = dealDiscount;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(String finalPrice) {
            this.finalPrice = finalPrice;
        }

        public Boolean getIsprimary() {
            return isprimary;
        }

        public void setIsprimary(Boolean isprimary) {
            this.isprimary = isprimary;
        }

        public OptionDescription getOptionDescription() {
            return optionDescription;
        }

        public void setOptionDescription(OptionDescription optionDescription) {
            this.optionDescription = optionDescription;
        }

        public Object getOptionDescriptions() {
            return optionDescriptions;
        }

        public void setOptionDescriptions(Object optionDescriptions) {
            this.optionDescriptions = optionDescriptions;
        }

    }

    public class PrimaryOption_ {

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
        private OptionDescription_ optionDescription;
        @SerializedName("OptionDescriptions")
        @Expose
        private Object optionDescriptions;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDealId() {
            return dealId;
        }

        public void setDealId(String dealId) {
            this.dealId = dealId;
        }

        public String getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(String originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getDealDiscount() {
            return dealDiscount;
        }

        public void setDealDiscount(String dealDiscount) {
            this.dealDiscount = dealDiscount;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(String finalPrice) {
            this.finalPrice = finalPrice;
        }

        public Boolean getIsprimary() {
            return isprimary;
        }

        public void setIsprimary(Boolean isprimary) {
            this.isprimary = isprimary;
        }

        public OptionDescription_ getOptionDescription() {
            return optionDescription;
        }

        public void setOptionDescription(OptionDescription_ optionDescription) {
            this.optionDescription = optionDescription;
        }

        public Object getOptionDescriptions() {
            return optionDescriptions;
        }

        public void setOptionDescriptions(Object optionDescriptions) {
            this.optionDescriptions = optionDescriptions;
        }

    }

    public class TypeDescription {

        @SerializedName("description_id")
        @Expose
        private String descriptionId;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("type_name")
        @Expose
        private String typeName;
        @SerializedName("type_description")
        @Expose
        private String typeDescription;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDescriptionId() {
            return descriptionId;
        }

        public void setDescriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(String typeDescription) {
            this.typeDescription = typeDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class TypeDescription_ {

        @SerializedName("description_id")
        @Expose
        private String descriptionId;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("language_id")
        @Expose
        private String languageId;
        @SerializedName("type_name")
        @Expose
        private String typeName;
        @SerializedName("type_description")
        @Expose
        private String typeDescription;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("meta_keyword")
        @Expose
        private String metaKeyword;

        public String getDescriptionId() {
            return descriptionId;
        }

        public void setDescriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getLanguageId() {
            return languageId;
        }

        public void setLanguageId(String languageId) {
            this.languageId = languageId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(String typeDescription) {
            this.typeDescription = typeDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(String metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

    }

    public class TypeInfo {

        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("TypeDescriptions")
        @Expose
        private Object typeDescriptions;
        @SerializedName("TypeDescription")
        @Expose
        private TypeDescription typeDescription;

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getTypeDescriptions() {
            return typeDescriptions;
        }

        public void setTypeDescriptions(Object typeDescriptions) {
            this.typeDescriptions = typeDescriptions;
        }

        public TypeDescription getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(TypeDescription typeDescription) {
            this.typeDescription = typeDescription;
        }

    }

    public class User {

        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("app_hash")
        @Expose
        private String appHash;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("wallet_amount")
        @Expose
        private String walletAmount;
        @SerializedName("is_affiliate")
        @Expose
        private String isAffiliate;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("mobile_active")
        @Expose
        private String mobileActive;
        @SerializedName("mobile_active_code")
        @Expose
        private String mobileActiveCode;
        @SerializedName("email_active")
        @Expose
        private String emailActive;
        @SerializedName("email_active_code")
        @Expose
        private String emailActiveCode;
        @SerializedName("rest_password_code")
        @Expose
        private String restPasswordCode;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("UserAddress")
        @Expose
        private Object userAddress;
        @SerializedName("UserLog")
        @Expose
        private Object userLog;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAppHash() {
            return appHash;
        }

        public void setAppHash(String appHash) {
            this.appHash = appHash;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getWalletAmount() {
            return walletAmount;
        }

        public void setWalletAmount(String walletAmount) {
            this.walletAmount = walletAmount;
        }

        public String getIsAffiliate() {
            return isAffiliate;
        }

        public void setIsAffiliate(String isAffiliate) {
            this.isAffiliate = isAffiliate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMobileActive() {
            return mobileActive;
        }

        public void setMobileActive(String mobileActive) {
            this.mobileActive = mobileActive;
        }

        public String getMobileActiveCode() {
            return mobileActiveCode;
        }

        public void setMobileActiveCode(String mobileActiveCode) {
            this.mobileActiveCode = mobileActiveCode;
        }

        public String getEmailActive() {
            return emailActive;
        }

        public void setEmailActive(String emailActive) {
            this.emailActive = emailActive;
        }

        public String getEmailActiveCode() {
            return emailActiveCode;
        }

        public void setEmailActiveCode(String emailActiveCode) {
            this.emailActiveCode = emailActiveCode;
        }

        public String getRestPasswordCode() {
            return restPasswordCode;
        }

        public void setRestPasswordCode(String restPasswordCode) {
            this.restPasswordCode = restPasswordCode;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(Object userAddress) {
            this.userAddress = userAddress;
        }

        public Object getUserLog() {
            return userLog;
        }

        public void setUserLog(Object userLog) {
            this.userLog = userLog;
        }

    }
}
