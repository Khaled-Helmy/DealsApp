
package com.yalladealz.userapp.model.responses.check;

import com.google.gson.annotations.SerializedName;

public class CheckDeleteAddress {

    @SerializedName("error")
    private Long mError;
    @SerializedName("message")
    private String mMessage;

    public Long getError() {
        return mError;
    }

    public void setError(Long error) {
        mError = error;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
