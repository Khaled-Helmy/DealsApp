package com.yalladealz.userapp.data.datasourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.yalladealz.userapp.data.datasources.BestDealsDataSource;
import com.yalladealz.userapp.model.deals.Deal;

public class BestDealsDataSourceFactory extends DataSource.Factory<Integer, Deal> {

    private MutableLiveData<BestDealsDataSource> bestDealsDataSourceMutableLiveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, Deal> create() {
        BestDealsDataSource bestDealsDataSource = new BestDealsDataSource();
        bestDealsDataSourceMutableLiveData.postValue(bestDealsDataSource);
        return bestDealsDataSource;
    }

    public LiveData<BestDealsDataSource> getBestDealsLiveDataSource() {
        return bestDealsDataSourceMutableLiveData;
    }
}
