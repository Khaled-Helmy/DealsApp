package com.yalladealz.userapp.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.yalladealz.userapp.data.datasourceFactories.BestDealsDataSourceFactory;
import com.yalladealz.userapp.data.datasourceFactories.BestReviewsDataSourceFactory;
import com.yalladealz.userapp.data.datasourceFactories.NewDealsDataSourceFactory;
import com.yalladealz.userapp.data.datasourceFactories.SearchDataSourceFactory;
import com.yalladealz.userapp.model.Category;
import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.responses.CategoriesResponse;
import com.yalladealz.userapp.model.responses.SearchResultResponseWrapper;
import com.yalladealz.userapp.model.search.SearchParameters;
import com.yalladealz.userapp.model.search.SearchResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {

    private ApiInterface apiInterface;

    public HomeRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public LiveData<List<Category>> getAllCategories() {
        final MutableLiveData<List<Category>> allCategories = new MutableLiveData<>();
        apiInterface.getCategories().enqueue(new Callback<CategoriesResponse>() {
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
                allCategories.setValue(categories);
            }

            @Override
            public void onFailure(@NonNull Call<CategoriesResponse> call, @NonNull Throwable t) {
            }
        });
        return allCategories;
    }

    public SearchResultResponseWrapper getSearchResultDeals(SearchParameters parameters) {
        SearchDataSourceFactory searchDataSourceFactory = new SearchDataSourceFactory(parameters);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        LiveData<PagedList<SearchResponse.Result>> searchResultDeals = new LivePagedListBuilder<>(searchDataSourceFactory, config).build();
        return new SearchResultResponseWrapper(searchResultDeals);
    }

    public LiveData<PagedList<Deal>> getBestDeals() {
        BestDealsDataSourceFactory bestDealsDataSourceFactory = new BestDealsDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        return new LivePagedListBuilder<>(bestDealsDataSourceFactory, config).build();
    }

    public LiveData<PagedList<Deal>> getBestReviews() {
        BestReviewsDataSourceFactory bestReviewsDataSourceFactory = new BestReviewsDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        return new LivePagedListBuilder<>(bestReviewsDataSourceFactory, config).build();
    }

    public LiveData<PagedList<Deal>> getNewDeals() {
        NewDealsDataSourceFactory newDealsDataSourceFactory = new NewDealsDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        return new LivePagedListBuilder<>(newDealsDataSourceFactory, config).build();
    }
}
