package com.yalladealz.userapp.model.responses;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.yalladealz.userapp.model.search.SearchResponse;

public class SearchResultResponseWrapper {

    private LiveData<PagedList<SearchResponse.Result>> pagedDeals;

    public SearchResultResponseWrapper(LiveData<PagedList<SearchResponse.Result>> pagedDeals) {
        this.pagedDeals = pagedDeals;
    }

    public LiveData<PagedList<SearchResponse.Result>> getPagedDeals() {
        return pagedDeals;
    }

    public void setPagedDeals(LiveData<PagedList<SearchResponse.Result>> pagedDeals) {
        this.pagedDeals = pagedDeals;
    }
}
