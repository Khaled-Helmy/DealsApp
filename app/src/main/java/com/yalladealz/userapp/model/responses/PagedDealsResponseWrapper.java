package com.yalladealz.userapp.model.responses;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.yalladealz.userapp.model.deals.Deal;

public class PagedDealsResponseWrapper {

    private LiveData<PagedList<Deal>> pagedDeals;

    public PagedDealsResponseWrapper(LiveData<PagedList<Deal>> pagedDeals) {
        this.pagedDeals = pagedDeals;
    }

    public LiveData<PagedList<Deal>> getPagedDeals() {
        return pagedDeals;
    }

    public void setPagedDeals(LiveData<PagedList<Deal>> pagedDeals) {
        this.pagedDeals = pagedDeals;
    }
}
