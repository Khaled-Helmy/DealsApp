package com.yalladealz.userapp.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
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

    public class OptionDescription {

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

    public class PrimaryOption {

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

        public List<OptionDescription> getOptionDescriptions() {
            return optionDescriptions;
        }

        public void setOptionDescriptions(List<OptionDescription> optionDescriptions) {
            this.optionDescriptions = optionDescriptions;
        }

    }

    public class Result {

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
        private List<Object> dealReview = null;

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

        public List<Object> getDealReview() {
            return dealReview;
        }

        public void setDealReview(List<Object> dealReview) {
            this.dealReview = dealReview;
        }

    }

}