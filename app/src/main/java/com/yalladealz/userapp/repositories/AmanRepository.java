package com.yalladealz.userapp.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.AmanResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmanRepository {

    private ApiInterface apiInterface;
    private MutableLiveData<AmanResponse> payResponse = new MutableLiveData<>();

    public AmanRepository() {
        apiInterface = RetrofitClient.getPaymentAPI();
    }

    public LiveData<AmanResponse> payRequest(JsonObject data) {


        apiInterface.payWithAman(data).enqueue(new Callback<AmanResponse>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onResponse(@NonNull Call<AmanResponse> call, @NonNull Response<AmanResponse> response) {

                AmanResponse amanResponse = response.body();
                if (amanResponse.getDetail() == null) {
                    payResponse.postValue(amanResponse);
                } else {
                    Log.v("AmanRepository", "payWithFawry: onResponse: " + amanResponse.getDetail());
                }
            }

            @Override
            public void onFailure(@NonNull Call<AmanResponse> call, @NonNull Throwable t) {
                Log.v("AmanRepository", "payWithFawry: onFailure: " + t.getMessage());
            }
        });

        return payResponse;
    }

}
