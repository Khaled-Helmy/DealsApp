package com.yalladealz.userapp.model.responses;

import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.Category;

import java.util.List;

public class SubCategoryResponseWrapper {

    private MutableLiveData<List<Category>> subCategories;

    public SubCategoryResponseWrapper(MutableLiveData<List<Category>> subCategories) {
        this.subCategories = subCategories;
    }

    public MutableLiveData<List<Category>> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(MutableLiveData<List<Category>> subCategories) {
        this.subCategories = subCategories;
    }
}
