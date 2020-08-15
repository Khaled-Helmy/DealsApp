package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class TypeInfo {

    @SerializedName("TypeDescriptions")
    private Object typeDescriptions;

    @SerializedName("type_id")
    private String typeId;

    @SerializedName("icon")
    private String icon;

    @SerializedName("TypeDescription")
    private TypeDescription typeDescription;

    public void setTypeDescriptions(Object typeDescriptions) {
        this.typeDescriptions = typeDescriptions;
    }

    public Object getTypeDescriptions() {
        return typeDescriptions;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setTypeDescription(TypeDescription typeDescription) {
        this.typeDescription = typeDescription;
    }

    public TypeDescription getTypeDescription() {
        return typeDescription;
    }

    @Override
    public String toString() {
        return
                "TypeInfo{" +
                        "typeDescriptions = '" + typeDescriptions + '\'' +
                        ",type_id = '" + typeId + '\'' +
                        ",icon = '" + icon + '\'' +
                        ",typeDescription = '" + typeDescription + '\'' +
                        "}";
    }
}