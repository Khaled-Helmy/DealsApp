
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class TypeInfo {

    @SerializedName("icon")
    private String mIcon;
    @SerializedName("TypeDescription")
    private TypeDescription mTypeDescription;
    @SerializedName("TypeDescriptions")
    private Object mTypeDescriptions;
    @SerializedName("type_id")
    private String mTypeId;

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public TypeDescription getTypeDescription() {
        return mTypeDescription;
    }

    public void setTypeDescription(TypeDescription typeDescription) {
        mTypeDescription = typeDescription;
    }

    public Object getTypeDescriptions() {
        return mTypeDescriptions;
    }

    public void setTypeDescriptions(Object typeDescriptions) {
        mTypeDescriptions = typeDescriptions;
    }

    public String getTypeId() {
        return mTypeId;
    }

    public void setTypeId(String typeId) {
        mTypeId = typeId;
    }

}
