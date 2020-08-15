package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class TypeDescription {

    @SerializedName("meta_description")
    private String metaDescription;

    @SerializedName("type_name")
    private String typeName;

    @SerializedName("meta_title")
    private String metaTitle;

    @SerializedName("description_id")
    private String descriptionId;

    @SerializedName("type_id")
    private String typeId;

    @SerializedName("meta_keyword")
    private String metaKeyword;

    @SerializedName("language_id")
    private String languageId;

    @SerializedName("type_description")
    private String typeDescription;

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
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

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
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

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    @Override
    public String toString() {
        return
                "TypeDescription{" +
                        "meta_description = '" + metaDescription + '\'' +
                        ",type_name = '" + typeName + '\'' +
                        ",meta_title = '" + metaTitle + '\'' +
                        ",description_id = '" + descriptionId + '\'' +
                        ",type_id = '" + typeId + '\'' +
                        ",meta_keyword = '" + metaKeyword + '\'' +
                        ",language_id = '" + languageId + '\'' +
                        ",type_description = '" + typeDescription + '\'' +
                        "}";
    }
}