package com.yalladealz.userapp.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.WalletResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WalletRepository {

    private ApiInterface apiInterface;
    private MutableLiveData<WalletResponse> payResponse = new MutableLiveData<>();

    public WalletRepository() {
        apiInterface = RetrofitClient.getAcceptAPI();
    }

    public LiveData<WalletResponse> payRequest(JsonObject data) {

        apiInterface.payWithWallet(data).enqueue(new Callback<WalletResponse>() {
            @Override
            public void onResponse(@NonNull Call<WalletResponse> call, @NonNull Response<WalletResponse> response) {

                WalletResponse walletResponse = response.body();
                if (walletResponse != null) {
                    if (walletResponse.getDetail() == null) {
                        payResponse.postValue(walletResponse);
                    } else {
                        Log.v("WalletRepository", "payWithFawry: onResponse: " + walletResponse.getDetail());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<WalletResponse> call, @NonNull Throwable t) {
                Log.v("WalletRepository", "payWithFawry: onFailure: " + t.getMessage());
            }
        });

        return payResponse;
    }
}
