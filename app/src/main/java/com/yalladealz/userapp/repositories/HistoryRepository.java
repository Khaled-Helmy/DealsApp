package com.yalladealz.userapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.History.Deal;
import com.yalladealz.userapp.model.History.HistoryResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class HistoryRepository implements RetrofitClient.HistoryFace {

    private MutableLiveData<List<Deal>> history = new MutableLiveData<>();
    private MutableLiveData<List<Deal>> available = new MutableLiveData<>();
    private ApiInterface apiInterface;

    public HistoryRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public void history(Long id, String hash) {
        RetrofitClient.getHistory(id, hash, this, apiInterface);
    }

    @Override
    public void onSucceed(HistoryResponse historyResponse) {
        if(historyResponse != null && historyResponse.getDeal().size() > 0){

        List<Deal> availableDeals = new ArrayList<>();
        List<Deal> historyDeals = new ArrayList<>();
            for (Deal deal : historyResponse.getDeal()) {
                if (deal.getDealData().getDealRedeemed().getRedeemed()) {
                    historyDeals.add(deal);
                } else {
                    availableDeals.add(deal);
                }
            }

            history.postValue(historyDeals);
            available.postValue(availableDeals);
        }
    }

    public LiveData<List<Deal>> getHistory() {
        return history;
    }

    public LiveData<List<Deal>> getAvailable() {
        return available;
    }
}