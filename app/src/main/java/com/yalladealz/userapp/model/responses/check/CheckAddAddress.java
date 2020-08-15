
package com.yalladealz.userapp.model.responses.check;

import com.google.gson.annotations.SerializedName;

public class CheckAddAddress {

    @SerializedName("address")
    private Long mAddress;
    @SerializedName("error")
    private Long mError;

    public Long getAddress() {
        return mAddress;
    }

    public void setAddress(Long address) {
        mAddress = address;
    }

    public Long getError() {
        return mError;
    }

    public void setError(Long error) {
        mError = error;
    }

}
