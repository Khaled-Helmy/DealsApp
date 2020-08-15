
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class CategoryDescription {

    @SerializedName("category_description")
    private String mCategoryDescription;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("category_name")
    private String mCategoryName;
    @SerializedName("description_id")
    private String mDescriptionId;
    @SerializedName("language_id")
    private String mLanguageId;
    @SerializedName("meta_description")
    private String mMetaDescription;
    @SerializedName("meta_keyword")
    private String mMetaKeyword;
    @SerializedName("meta_title")
    private String mMetaTitle;

    public String getCategoryDescription() {
        return mCategoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        mCategoryDescription = categoryDescription;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public String getDescriptionId() {
        return mDescriptionId;
    }

    public void setDescriptionId(String descriptionId) {
        mDescriptionId = descriptionId;
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

}
