package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class CategoryInfo {

    @SerializedName("CategoryDescriptions")
    private Object categoryDescriptions;

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("parent_id")
    private String parentId;

    @SerializedName("icon")
    private String icon;

    @SerializedName("ParentDescription")
    private ParentDescription parentDescription;

    @SerializedName("CategoryDescription")
    private CategoryDescription categoryDescription;

    public void setCategoryDescriptions(Object categoryDescriptions) {
        this.categoryDescriptions = categoryDescriptions;
    }

    public Object getCategoryDescriptions() {
        return categoryDescriptions;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setParentDescription(ParentDescription parentDescription) {
        this.parentDescription = parentDescription;
    }

    public ParentDescription getParentDescription() {
        return parentDescription;
    }

    public void setCategoryDescription(CategoryDescription categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public CategoryDescription getCategoryDescription() {
        return categoryDescription;
    }

    @Override
    public String toString() {
        return
                "CategoryInfo{" +
                        "categoryDescriptions = '" + categoryDescriptions + '\'' +
                        ",category_id = '" + categoryId + '\'' +
                        ",parent_id = '" + parentId + '\'' +
                        ",icon = '" + icon + '\'' +
                        ",parentDescription = '" + parentDescription + '\'' +
                        ",categoryDescription = '" + categoryDescription + '\'' +
                        "}";
    }
}