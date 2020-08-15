package com.yalladealz.userapp.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.OrderResponse;
import com.yalladealz.userapp.model.Payment.PaymentKeyResponse;
import com.yalladealz.userapp.model.Payment.TokenResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yalladealz.userapp.util.LogUtil.error;

public class VisaRepository {

    private ApiInterface apiInterface, acceptInterface;
    private MutableLiveData<TokenResponse> token = new MutableLiveData<>();
    private MutableLiveData<OrderResponse> orderData = new MutableLiveData<>();
    private MutableLiveData<String> paymentKey = new MutableLiveData<>();

    public VisaRepository() {
        apiInterface = RetrofitClient.getPaymentAPI();
        acceptInterface = RetrofitClient.getAcceptAPI();
    }

    public LiveData<TokenResponse> getToken(JsonObject key){

        acceptInterface.getVisaToken(key).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(@NonNull Call<TokenResponse> call, @NonNull Response<TokenResponse> response) {
                TokenResponse tokenResponse = response.body();
                if (tokenResponse != null) {
                    if (tokenResponse.getDetail() == null) {
                        token.postValue(tokenResponse);
                    } else {
                        Log.v("VisaRepository", "onResponse registerOrder: " + tokenResponse.getDetail());

                        // FIXME: 12/09/19 ???
                        tokenResponse.setToken("");
                        token.postValue(tokenResponse);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<TokenResponse> call, @NonNull Throwable t) {
                error("VisaRepository: onFailure: " + t.getMessage());

            }
        });

        return token;
    }

    public LiveData<OrderResponse> registerOrder(JsonObject order){

        acceptInterface.registerPaymentOrder(order).enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(@NonNull Call<OrderResponse> call, @NonNull Response<OrderResponse> response) {

                OrderResponse order = response.body();
                if (order != null) {
                    if (order.getDetail() == null) {
                        orderData.postValue(order);
                    } else {
                        Log.v("VisaRepository", "onResponse registerOrder: " + order.getDetail());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<OrderResponse> call, @NonNull Throwable t) {
                Log.v("VisaRepository", "onFailure registerOrder: " + t.getMessage());
            }
        });

        return orderData;
    }

    public LiveData<String> getPaymentKey(JsonObject details){

        acceptInterface.getPaymentKey(details).enqueue(new Callback<PaymentKeyResponse>() {
            @Override
            public void onResponse(@NonNull Call<PaymentKeyResponse> call, @NonNull Response<PaymentKeyResponse> response) {

                PaymentKeyResponse key = response.body();
                if (key != null) {
                    if (key.getDetail() == null) {
                        paymentKey.postValue(key.getPaymentKey());
                    } else {
                        Log.v("VisaRepository", "onResponse getPaymentKey: " + key.getDetail());

                        paymentKey.postValue("");
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<PaymentKeyResponse> call, @NonNull Throwable t) {
                Log.v("VisaRepository", "onFailure getPaymentKey: " + t.getMessage());
            }
        });

        return paymentKey;
    }
}
