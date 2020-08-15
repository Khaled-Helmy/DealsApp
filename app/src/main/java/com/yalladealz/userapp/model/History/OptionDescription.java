
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class OptionDescription {

    @SerializedName("language_id")
    private String mLanguageId;
    @SerializedName("option_id")
    private String mOptionId;
    @SerializedName("option_name")
    private String mOptionName;

    public String getLanguageId() {
        return mLanguageId;
    }

    public void setLanguageId(String languageId) {
        mLanguageId = languageId;
    }

    public String getOptionId() {
        return mOptionId;
    }

    public void setOptionId(String optionId) {
        mOptionId = optionId;
    }

    public String getOptionName() {
        return mOptionName;
    }

    public void setOptionName(String optionName) {
        mOptionName = optionName;
    }

}
