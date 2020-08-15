package com.yalladealz.userapp.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.repositories.DealRepository;

public class DealViewModel extends AndroidViewModel {

    private DealRepository dealRepository;
    private MutableLiveData<String> message = new MutableLiveData<>();

    public DealViewModel(@NonNull Application application) {
        super(application);
        dealRepository = new DealRepository(application);
    }


    public LiveData<Deal> getSingleDeal(int deal_id, int option_id) {
        return dealRepository.singleDeal(deal_id, option_id);
    }
}
