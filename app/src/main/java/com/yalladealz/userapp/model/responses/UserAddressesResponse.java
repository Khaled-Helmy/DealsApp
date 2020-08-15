package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserAddressesResponse {

    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;
    @SerializedName("error")
    @Expose
    private Integer error;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
