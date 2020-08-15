package com.yalladealz.userapp.repositories;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.responses.LowBranchDealResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MerchentLocationRepository {

    private ApiInterface apiInterface;
    private Application application;

    public MerchentLocationRepository(Application application) {
        apiInterface = RetrofitClient.getInstance();
        this.application = application;
    }

    public LiveData<LowBranchDealResponse.Deal> merchent(double latitude, double longitude, int distance) {
        MutableLiveData<LowBranchDealResponse.Deal> merchant = new MutableLiveData<>();
        Call<LowBranchDealResponse> call = apiInterface.getLowestBranch(latitude, longitude, distance);
        call.enqueue(new Callback<LowBranchDealResponse>() {
            @Override
            public void onResponse(@NotNull Call<LowBranchDealResponse> call, @NotNull Response<LowBranchDealResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        merchant.postValue(response.body().getDeal());
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<LowBranchDealResponse> call, @NotNull Throwable t) {
                Toast.makeText(application, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return merchant;
    }
}
