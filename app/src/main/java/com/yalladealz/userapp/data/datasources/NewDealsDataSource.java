package com.yalladealz.userapp.data.datasources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.responses.NewDealsResponse;
import com.yalladealz.userapp.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewDealsDataSource extends PageKeyedDataSource<Integer, Deal> {

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Deal> callback) {
        RetrofitClient.getInstance().getNewsDeals(1)
                .enqueue(new Callback<NewDealsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<NewDealsResponse> call, @NonNull Response<NewDealsResponse> response) {
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
                    public void onFailure(@NonNull Call<NewDealsResponse> call, @NonNull Throwable t) {
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Deal> callback) {
        RetrofitClient.getInstance().getNewsDeals(params.key)
                .enqueue(new Callback<NewDealsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<NewDealsResponse> call, @NonNull Response<NewDealsResponse> response) {
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
                    public void onFailure(@NonNull Call<NewDealsResponse> call, @NonNull Throwable t) {
                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Deal> callback) {
        RetrofitClient.getInstance().getNewsDeals(params.key)
                .enqueue(new Callback<NewDealsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<NewDealsResponse> call, @NonNull Response<NewDealsResponse> response) {
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
                    public void onFailure(@NonNull Call<NewDealsResponse> call, @NonNull Throwable t) {
                    }
                });
    }
}
