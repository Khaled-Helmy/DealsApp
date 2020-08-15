package com.yalladealz.userapp.data.datasourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.yalladealz.userapp.data.datasources.SearchDataSource;
import com.yalladealz.userapp.model.search.SearchParameters;
import com.yalladealz.userapp.model.search.SearchResponse;

public class SearchDataSourceFactory extends DataSource.Factory<Integer, SearchResponse.Result> {

    private SearchParameters parameters;
    private MutableLiveData<SearchDataSource> searchDataSourceMutableLiveData = new MutableLiveData<>();

    public SearchDataSourceFactory(SearchParameters parameters) {
        this.parameters = parameters;
    }

    @NonNull
    @Override
    public DataSource<Integer, SearchResponse.Result> create() {
        SearchDataSource searchDataSource = new SearchDataSource(parameters);
        searchDataSourceMutableLiveData.postValue(searchDataSource);
        return searchDataSource;
    }

    public LiveData<SearchDataSource> getSearchDataSourceMutableLiveData() {
        return searchDataSourceMutableLiveData;
    }
}
