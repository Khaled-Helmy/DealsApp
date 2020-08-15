package com.yalladealz.userapp.viewModels;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.yalladealz.userapp.model.Category;
import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.responses.SearchResultResponseWrapper;
import com.yalladealz.userapp.model.search.SearchParameters;
import com.yalladealz.userapp.model.search.SearchResponse;
import com.yalladealz.userapp.repositories.HomeRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final LiveData<List<Category>> allCategories;
    private HomeRepository homeRepository;
    private LiveData<PagedList<Deal>> bestDeals;
    private LiveData<PagedList<Deal>> bestReviews;
    private LiveData<PagedList<Deal>> newDeals;
    private MutableLiveData<SearchParameters> searchParameters = new MutableLiveData<>();
    private LiveData<SearchResultResponseWrapper> searchPagedDealsResponseWrapperLiveData = Transformations
            .map(searchParameters, new Function<SearchParameters, SearchResultResponseWrapper>() {
                @Override
                public SearchResultResponseWrapper apply(SearchParameters input) {
                    return homeRepository.getSearchResultDeals(input);
                }
            });
    private LiveData<PagedList<SearchResponse.Result>> searchResultDeals = Transformations
            .switchMap(searchPagedDealsResponseWrapperLiveData, SearchResultResponseWrapper::getPagedDeals);

    public HomeViewModel() {
        homeRepository = new HomeRepository();
        bestReviews = homeRepository.getBestReviews();
        newDeals = homeRepository.getNewDeals();
        bestDeals = homeRepository.getBestDeals();
        allCategories = homeRepository.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public void search(SearchParameters parameters) {
        searchParameters.postValue(parameters);
    }

    public LiveData<PagedList<SearchResponse.Result>> getSearchResultDeals() {
        return searchResultDeals;
    }

    public LiveData<PagedList<Deal>> getBestDeals() {
        return bestDeals;
    }

    public LiveData<PagedList<Deal>> getBestReviews() {
        return bestReviews;
    }

    public LiveData<PagedList<Deal>> getNewDeals() {
        return newDeals;
    }
}
