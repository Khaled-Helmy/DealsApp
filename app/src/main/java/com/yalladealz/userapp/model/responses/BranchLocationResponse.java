package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.Branch;

import java.util.List;

public class BranchLocationResponse {
    @SerializedName("branches")
    @Expose
    private List<Branch> branches = null;
    @SerializedName("error")
    @Expose
    private Integer error;

    public List<Branch> getBrances() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

}
