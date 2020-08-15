package com.yalladealz.userapp.repositories;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.WishListTable;
import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.responses.DealResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;
import com.yalladealz.userapp.roomDB.AppDatabase;
import com.yalladealz.userapp.roomDB.DealWishListDao;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yalladealz.userapp.util.LogUtil.error;
import static com.yalladealz.userapp.util.LogUtil.verbose;

public class DealRepository {

    private ApiInterface apiInterface;
    private DealWishListDao dealWishListDao;
    private Executor executor;

    public DealRepository(Application application) {
        apiInterface = RetrofitClient.getInstance();
        AppDatabase db = AppDatabase.getDatabase(application);
        dealWishListDao = db.dealWishListDao();
        executor = Executors.newFixedThreadPool(5);
    }


    public void addDealToWishList(WishListTable deal) {
        executor.execute(() -> dealWishListDao.addDealToWishList(deal));
    }

    public LiveData<Deal> singleDeal(int deal_id, int option_id) {
        MutableLiveData<Deal> singleDeal = new MutableLiveData<>();
        apiInterface.getDeal(deal_id, option_id)
                .enqueue(new Callback<DealResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<DealResponse> call, @NonNull Response<DealResponse> response) {
                        if (response.isSuccessful()) {
                            DealResponse body = response.body();
                            if (body != null) {
                                if (body.getError() == 0) {
                                    Deal deal = body.getDeal();
                                    singleDeal.postValue(deal);
                                    verbose("onResponse: single deal: " + (response.body() != null ? response.body().getDeal() : null));

                                } else {
                                    singleDeal.postValue(null);
                                    verbose("onResponse: error: " + (response.body() != null ? response.body().getError() : 0));
                                }
                            }
                        } else {
                            singleDeal.postValue(null);
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<DealResponse> call, @NonNull Throwable t) {
                        error("onFailure: " + t.getMessage());

                    }
                });

        return singleDeal;

    }
}
