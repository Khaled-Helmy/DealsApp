package com.yalladealz.userapp.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.yalladealz.userapp.data.datasourceFactories.ProductCategoryDataSourceFactory;
import com.yalladealz.userapp.model.Category;
import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.responses.CategoriesResponse;
import com.yalladealz.userapp.model.responses.PagedDealsResponseWrapper;
import com.yalladealz.userapp.model.responses.SubCategoryResponseWrapper;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {

    private ApiInterface apiInterface;

    public CategoryRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public PagedDealsResponseWrapper getCategoryDeals(String category_id) {
        ProductCategoryDataSourceFactory productCategoryDataSourceFactory = new ProductCategoryDataSourceFactory(category_id);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        LiveData<PagedList<Deal>> categoryDeals = new LivePagedListBuilder<>(productCategoryDataSourceFactory, config).build();
        return new PagedDealsResponseWrapper(categoryDeals);
    }

    public SubCategoryResponseWrapper getSubCategories(String category_id) {
        MutableLiveData<List<Category>> subCategories = new MutableLiveData<>();
        apiInterface.getSubCategories(category_id).enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(@NonNull Call<CategoriesResponse> call, @NonNull Response<CategoriesResponse> response) {
                List<Category> categories = new ArrayList<>();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        categories = response.body().getCategories();
                    }
                } else {
                    categories = Collections.emptyList();
                }
                subCategories.setValue(categories);
            }

            @Override
            public void onFailure(@NonNull Call<CategoriesResponse> call, @NonNull Throwable t) {

            }
        });
        return new SubCategoryResponseWrapper(subCategories);
    }
}
