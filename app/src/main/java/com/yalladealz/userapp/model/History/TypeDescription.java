
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class TypeDescription {

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
    @SerializedName("type_description")
    private String mTypeDescription;
    @SerializedName("type_id")
    private String mTypeId;
    @SerializedName("type_name")
    private String mTypeName;

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

    public String getTypeDescription() {
        return mTypeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        mTypeDescription = typeDescription;
    }

    public String getTypeId() {
        return mTypeId;
    }

    public void setTypeId(String typeId) {
        mTypeId = typeId;
    }

    public String getTypeName() {
        return mTypeName;
    }

    public void setTypeName(String typeName) {
        mTypeName = typeName;
    }

}
