package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class DealDescription {

    @SerializedName("meta_description")
    private String metaDescription;

    @SerializedName("deal_description")
    private String dealDescription;

    @SerializedName("deal_conditions")
    private String dealConditions;

    @SerializedName("meta_title")
    private String metaTitle;

    @SerializedName("deal_highlights")
    private String dealHighlights;

    @SerializedName("deal_name")
    private String dealName;

    @SerializedName("meta_keyword")
    private String metaKeyword;

    @SerializedName("language_id")
    private String languageId;

    @SerializedName("deal_id")
    private String dealId;

    @SerializedName("tags")
    private String tags;

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public void setDealConditions(String dealConditions) {
        this.dealConditions = dealConditions;
    }

    public String getDealConditions() {
        return dealConditions;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setDealHighlights(String dealHighlights) {
        this.dealHighlights = dealHighlights;
    }

    public String getDealHighlights() {
        return dealHighlights;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealName() {
        return dealName;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealId() {
        return dealId;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return
                "DealDescription{" +
                        "meta_description = '" + metaDescription + '\'' +
                        ",deal_description = '" + dealDescription + '\'' +
                        ",deal_conditions = '" + dealConditions + '\'' +
                        ",meta_title = '" + metaTitle + '\'' +
                        ",deal_highlights = '" + dealHighlights + '\'' +
                        ",deal_name = '" + dealName + '\'' +
                        ",meta_keyword = '" + metaKeyword + '\'' +
                        ",language_id = '" + languageId + '\'' +
                        ",deal_id = '" + dealId + '\'' +
                        ",tags = '" + tags + '\'' +
                        "}";
    }
}