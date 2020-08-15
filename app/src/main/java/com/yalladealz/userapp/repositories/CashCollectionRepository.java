package com.yalladealz.userapp.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.CashCollectionResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yalladealz.userapp.util.LogUtil.debug;

public class CashCollectionRepository {

    private ApiInterface apiInterface;
    private MutableLiveData<CashCollectionResponse> payResponse = new MutableLiveData<>();

    public CashCollectionRepository() {
        apiInterface = RetrofitClient.getAcceptAPI();
    }

    public LiveData<CashCollectionResponse> payRequest(JsonObject data) {


        apiInterface.payWithCashCollection(data).enqueue(new Callback<CashCollectionResponse>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onResponse(@NonNull Call<CashCollectionResponse> call, @NonNull Response<CashCollectionResponse> response) {

                CashCollectionResponse cashCollectionResponse = response.body();
                debug("caash: " + cashCollectionResponse.getPending());
                if (cashCollectionResponse.getDetail() == null) {
                    payResponse.postValue(cashCollectionResponse);
                } else {
                    Log.d("CashCollectionRepositor", "payWithFawry: onResponse: " + cashCollectionResponse.getDetail());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CashCollectionResponse> call, @NonNull Throwable t) {
                payResponse.postValue(null);
                Log.d("CashCollectionRepositor", "payWithFawry: onFailure: " + t);
                t.printStackTrace();
            }
        });

        return payResponse;
    }
}
