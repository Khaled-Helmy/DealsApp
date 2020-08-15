package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class CategoryDescription {

    @SerializedName("category_description")
    private String categoryDescription;

    @SerializedName("meta_description")
    private String metaDescription;

    @SerializedName("category_name")
    private String categoryName;

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("meta_title")
    private String metaTitle;

    @SerializedName("description_id")
    private String descriptionId;

    @SerializedName("meta_keyword")
    private String metaKeyword;

    @SerializedName("language_id")
    private String languageId;

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setDescriptionId(String descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDescriptionId() {
        return descriptionId;
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

    @Override
    public String toString() {
        return
                "CategoryDescription{" +
                        "category_description = '" + categoryDescription + '\'' +
                        ",meta_description = '" + metaDescription + '\'' +
                        ",category_name = '" + categoryName + '\'' +
                        ",category_id = '" + categoryId + '\'' +
                        ",meta_title = '" + metaTitle + '\'' +
                        ",description_id = '" + descriptionId + '\'' +
                        ",meta_keyword = '" + metaKeyword + '\'' +
                        ",language_id = '" + languageId + '\'' +
                        "}";
    }
}