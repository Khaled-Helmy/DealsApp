package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yalladealz.userapp.model.Category;

import java.util.List;

public class CategoriesResponse {

    @SerializedName("Categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("error")
    @Expose
    private int error;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

}
