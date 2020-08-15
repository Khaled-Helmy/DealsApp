
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class DealDescription {

    @SerializedName("deal_conditions")
    private String mDealConditions;
    @SerializedName("deal_description")
    private String mDealDescription;
    @SerializedName("deal_highlights")
    private String mDealHighlights;
    @SerializedName("deal_id")
    private String mDealId;
    @SerializedName("deal_name")
    private String mDealName;
    @SerializedName("language_id")
    private String mLanguageId;
    @SerializedName("meta_description")
    private String mMetaDescription;
    @SerializedName("meta_keyword")
    private String mMetaKeyword;
    @SerializedName("meta_title")
    private String mMetaTitle;
    @SerializedName("tags")
    private String mTags;

    public String getDealConditions() {
        return mDealConditions;
    }

    public void setDealConditions(String dealConditions) {
        mDealConditions = dealConditions;
    }

    public String getDealDescription() {
        return mDealDescription;
    }

    public void setDealDescription(String dealDescription) {
        mDealDescription = dealDescription;
    }

    public String getDealHighlights() {
        return mDealHighlights;
    }

    public void setDealHighlights(String dealHighlights) {
        mDealHighlights = dealHighlights;
    }

    public String getDealId() {
        return mDealId;
    }

    public void setDealId(String dealId) {
        mDealId = dealId;
    }

    public String getDealName() {
        return mDealName;
    }

    public void setDealName(String dealName) {
        mDealName = dealName;
    }

    public String getLanguageId() {
        return mLanguageId;
    }

    public void setLanguageId(String languageId) {
        mLanguageId = languageId;
    }

    public String getMetaDescription() {
        return mMetaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        mMetaDescription = metaDescription;
    }

    public String getMetaKeyword() {
        return mMetaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        mMetaKeyword = metaKeyword;
    }

    public String getMetaTitle() {
        return mMetaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        mMetaTitle = metaTitle;
    }

    public String getTags() {
        return mTags;
    }

    public void setTags(String tags) {
        mTags = tags;
    }

}
