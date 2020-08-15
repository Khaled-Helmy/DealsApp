package com.yalladealz.userapp.data.datasourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.yalladealz.userapp.data.datasources.BestReviewsDataSource;
import com.yalladealz.userapp.model.deals.Deal;

public class BestReviewsDataSourceFactory extends DataSource.Factory<Integer, Deal> {

    private MutableLiveData<BestReviewsDataSource> bestReviewsDataSourceMutableLiveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, Deal> create() {
        BestReviewsDataSource bestReviewsDataSource = new BestReviewsDataSource();
        bestReviewsDataSourceMutableLiveData.postValue(bestReviewsDataSource);
        return bestReviewsDataSource;
    }

    public LiveData<BestReviewsDataSource> getBestReviewsLiveDataSource() {
        return bestReviewsDataSourceMutableLiveData;
    }
}
