package com.yalladealz.userapp.viewModels;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.yalladealz.userapp.model.Category;
import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.responses.PagedDealsResponseWrapper;
import com.yalladealz.userapp.model.responses.SubCategoryResponseWrapper;
import com.yalladealz.userapp.repositories.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<String> categoryId = new MutableLiveData<>();
    private MutableLiveData<String> subCategoryId = new MutableLiveData<>();
    private CategoryRepository categoryRepository;

    private LiveData<PagedDealsResponseWrapper> categoryDealsResponseWrapperLiveData = Transformations
            .map(categoryId, new Function<String, PagedDealsResponseWrapper>() {
                @Override
                public PagedDealsResponseWrapper apply(String input) {
                    return categoryRepository.getCategoryDeals(input);
                }
            });

    private LiveData<PagedList<Deal>> categoryDeals = Transformations
            .switchMap(categoryDealsResponseWrapperLiveData, PagedDealsResponseWrapper::getPagedDeals);

    private LiveData<PagedDealsResponseWrapper> subCategoryDealsResponseWrapperLiveData = Transformations
            .map(subCategoryId, new Function<String, PagedDealsResponseWrapper>() {
                @Override
                public PagedDealsResponseWrapper apply(String input) {
                    return categoryRepository.getCategoryDeals(input);
                }
            });

    private LiveData<PagedList<Deal>> subCategoryDeals = Transformations
            .switchMap(subCategoryDealsResponseWrapperLiveData, PagedDealsResponseWrapper::getPagedDeals);

    private LiveData<SubCategoryResponseWrapper> subCategoryResponseWrapperLiveData = Transformations
            .map(categoryId, new Function<String, SubCategoryResponseWrapper>() {
                @Override
                public SubCategoryResponseWrapper apply(String input) {
                    return categoryRepository.getSubCategories(input);
                }
            });

    private LiveData<List<Category>> subCategories = Transformations
            .switchMap(subCategoryResponseWrapperLiveData, SubCategoryResponseWrapper::getSubCategories);

    public CategoryViewModel() {
        categoryRepository = new CategoryRepository();
    }

    public void setCategoryId(String categoryId) {
        this.categoryId.postValue(categoryId);
    }

    public LiveData<PagedList<Deal>> getCategoryDeals() {
        return categoryDeals;
    }

    public LiveData<List<Category>> getSubCategories() {
        return subCategories;
    }

    public LiveData<PagedList<Deal>> getSubCategoryDeals() {
        return subCategoryDeals;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId.postValue(subCategoryId);
    }
}
