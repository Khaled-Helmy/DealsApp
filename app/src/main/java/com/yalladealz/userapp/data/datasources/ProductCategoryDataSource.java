package com.yalladealz.userapp.data.datasources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.responses.CategoryDealsResponse;
import com.yalladealz.userapp.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductCategoryDataSource extends PageKeyedDataSource<Integer, Deal> {

    private String category_id;

    public ProductCategoryDataSource(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Deal> callback) {
        RetrofitClient.getInstance().getCategoryDeals(category_id, 1)
                .enqueue(new Callback<CategoryDealsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CategoryDealsResponse> call, @NonNull Response<CategoryDealsResponse> response) {
                        if (response.isSuccessful()) {
                            List<Deal> deals;
                            if (response.body() != null) {
                                deals = response.body().getDeals();
                            } else {
                                deals = Collections.emptyList();
                            }
                            callback.onResult(deals, null, 2);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CategoryDealsResponse> call, @NonNull Throwable t) {
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Deal> callback) {
        RetrofitClient.getInstance().getCategoryDeals(category_id, params.key)
                .enqueue(new Callback<CategoryDealsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CategoryDealsResponse> call, @NonNull Response<CategoryDealsResponse> response) {
                        if (response.isSuccessful()) {
                            List<Deal> deals;
                            if (response.body() != null) {
                                deals = response.body().getDeals();
                            } else {
                                deals = Collections.emptyList();
                            }
                            callback.onResult(deals, params.key - 1);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CategoryDealsResponse> call, @NonNull Throwable t) {
                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Deal> callback) {
        RetrofitClient.getInstance().getCategoryDeals(category_id, params.key)
                .enqueue(new Callback<CategoryDealsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CategoryDealsResponse> call, @NonNull Response<CategoryDealsResponse> response) {
                        if (response.isSuccessful()) {
                            List<Deal> deals;
                            if (response.body() != null) {
                                deals = response.body().getDeals();
                            } else {
                                deals = Collections.emptyList();
                            }
                            callback.onResult(deals, params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CategoryDealsResponse> call, @NonNull Throwable t) {
                    }
                });
    }
}
