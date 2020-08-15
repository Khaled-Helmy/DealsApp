
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;
public class CategoryInfo {

    @SerializedName("CategoryDescription")
    private CategoryDescription mCategoryDescription;
    @SerializedName("CategoryDescriptions")
    private Object mCategoryDescriptions;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("ParentDescription")
    private ParentDescription mParentDescription;
    @SerializedName("parent_id")
    private String mParentId;

    public CategoryDescription getCategoryDescription() {
        return mCategoryDescription;
    }

    public void setCategoryDescription(CategoryDescription categoryDescription) {
        mCategoryDescription = categoryDescription;
    }

    public Object getCategoryDescriptions() {
        return mCategoryDescriptions;
    }

    public void setCategoryDescriptions(Object categoryDescriptions) {
        mCategoryDescriptions = categoryDescriptions;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public ParentDescription getParentDescription() {
        return mParentDescription;
    }

    public void setParentDescription(ParentDescription parentDescription) {
        mParentDescription = parentDescription;
    }

    public String getParentId() {
        return mParentId;
    }

    public void setParentId(String parentId) {
        mParentId = parentId;
    }

}
