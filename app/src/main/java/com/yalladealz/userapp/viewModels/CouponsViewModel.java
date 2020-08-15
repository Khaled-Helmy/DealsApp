package com.yalladealz.userapp.viewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yalladealz.userapp.model.responses.CouponData;
import com.yalladealz.userapp.repositories.CouponsRepository;

import java.util.List;

public class CouponsViewModel extends AndroidViewModel {

    private CouponsRepository repository;

    public CouponsViewModel(@NonNull Application application) {
        super(application);

        repository = new CouponsRepository();
    }

    public LiveData<List<CouponData>> getCoupons(Context context, String deal_id) {
        return repository.getCoupons(context, deal_id);
    }
}
