package com.yalladealz.userapp.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.model.responses.UserAddressesResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAddressesRepository {

    private ApiInterface apiInterface;
    private MutableLiveData<List<Address>> userAddresses = new MutableLiveData<>();

    public UserAddressesRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public LiveData<List<Address>> getUserAddresses(String user_id, String hash){

        apiInterface.getAddresses(Long.parseLong(user_id), hash).enqueue(new Callback<UserAddressesResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserAddressesResponse> call, @NonNull Response<UserAddressesResponse> response) {

                if (response.body() != null){
                    UserAddressesResponse addressesResponse = response.body();

                    if(addressesResponse.getError() == 0){
                        userAddresses.postValue(addressesResponse.getAddresses()); }
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserAddressesResponse> call, @NonNull Throwable t) {
                String error = t.getMessage() != null ? t.getMessage() : "Unknown Error";
                Log.v("onFailure", error);
            }
        });

        return userAddresses;
    }
}
