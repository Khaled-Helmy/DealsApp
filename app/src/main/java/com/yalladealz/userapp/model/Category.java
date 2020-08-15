package com.yalladealz.userapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    private class ParentDescription {

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

}
