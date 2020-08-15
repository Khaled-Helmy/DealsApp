package com.yalladealz.userapp.data.datasources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.yalladealz.userapp.model.search.SearchParameters;
import com.yalladealz.userapp.model.search.SearchResponse;
import com.yalladealz.userapp.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yalladealz.userapp.util.LogUtil.error;
import static com.yalladealz.userapp.util.LogUtil.verbose;

public class SearchDataSource extends PageKeyedDataSource<Integer, SearchResponse.Result> {

    private SearchParameters parameters;

    public SearchDataSource(SearchParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, SearchResponse.Result> callback) {
        RetrofitClient.getInstance().search(parameters.getCategory_id(),
                parameters.getDeal_name(),
                1,
                parameters.getSort(),
                parameters.getTypes(),
                parameters.getPrice())
                .enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                        verbose("onSearchResponse: started...");
                        if (response.isSuccessful()) {
                            verbose("onSearchResponse: connection is successful");
                            List<SearchResponse.Result> deals;
                            if (response.body() != null) {
                                verbose("onSearchResponse: response body is not null");
                                deals = response.body().getResult();
                                verbose("onSearchResponse: " + deals.toString());


                            } else {
                                verbose("onSearchResponse: response body is null");
                                deals = Collections.emptyList();
                            }
                            callback.onResult(deals, null, 2);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                        error("onSearchFailure: failed to load data, please try again." + t.getMessage());
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SearchResponse.Result> callback) {
        RetrofitClient.getInstance().search(parameters.getCategory_id(),
                parameters.getDeal_name(),
                params.key,
                parameters.getSort(),
                parameters.getTypes(),
                parameters.getPrice())
                .enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                        verbose("onSearchResponse: started...");
                        if (response.isSuccessful()) {
                            verbose("onSearchResponse: connection is successful");
                            List<SearchResponse.Result> deals;
                            if (response.body() != null) {
                                deals = response.body().getResult();
                            } else {
                                deals = Collections.emptyList();
                            }
                            callback.onResult(deals, params.key - 1);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SearchResponse.Result> callback) {
        RetrofitClient.getInstance().search(parameters.getCategory_id(),
                parameters.getDeal_name(),
                params.key,
                parameters.getSort(),
                parameters.getTypes(),
                parameters.getPrice())
                .enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                        if (response.isSuccessful()) {
                            List<SearchResponse.Result> deals;
                            if (response.body() != null) {
                                deals = response.body().getResult();
                            } else {
                                deals = Collections.emptyList();
                            }
                            callback.onResult(deals, params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                    }
                });
    }
}
