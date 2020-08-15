package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class OptionDescription {

    @SerializedName("option_id")
    private String optionId;

    @SerializedName("option_name")
    private String optionName;

    @SerializedName("language_id")
    private String languageId;

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return optionName;
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
                "OptionDescription{" +
                        "option_id = '" + optionId + '\'' +
                        ",option_name = '" + optionName + '\'' +
                        ",language_id = '" + languageId + '\'' +
                        "}";
    }
}