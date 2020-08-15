package com.yalladealz.userapp.data.datasourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.yalladealz.userapp.data.datasources.NewDealsDataSource;
import com.yalladealz.userapp.model.deals.Deal;

public class NewDealsDataSourceFactory extends DataSource.Factory<Integer, Deal> {

    private MutableLiveData<NewDealsDataSource> newDealsDataSourceMutableLiveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, Deal> create() {
        NewDealsDataSource newDealsDataSource = new NewDealsDataSource();
        newDealsDataSourceMutableLiveData.postValue(newDealsDataSource);
        return newDealsDataSource;
    }

    public LiveData<NewDealsDataSource> getNewDealsLiveDataSource() {
        return newDealsDataSourceMutableLiveData;
    }
}
