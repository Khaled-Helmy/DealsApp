package com.yalladealz.userapp.repositories;

import android.location.Location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.Branch;
import com.yalladealz.userapp.model.BranchDeal;
import com.yalladealz.userapp.model.responses.BranchDealsResponse;
import com.yalladealz.userapp.model.responses.BranchLocationResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsRepository {

    private ApiInterface apiInterface;

    // TODO: 26/09/19 change in production
    public MapsRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public LiveData<List<BranchDeal>> getBranchDeals(String id) {
        MutableLiveData<List<BranchDeal>> branchDeals = new MutableLiveData<>();
        apiInterface.getBranchDeals(id)
                .enqueue(new Callback<BranchDealsResponse>() {
                    @Override
                    public void onResponse(Call<BranchDealsResponse> call, Response<BranchDealsResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            branchDeals.postValue(response.body().getDeals());
                        }
                    }

                    @Override
                    public void onFailure(Call<BranchDealsResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
        return branchDeals;
    }
    public LiveData<BranchLocationResponse> getNearByBranches(Location location, int distance) {
        MutableLiveData<BranchLocationResponse> nearByDeals = new MutableLiveData<>();
        apiInterface.getBranches(location.getLatitude(), location.getLongitude(), distance)
                .enqueue(new Callback<BranchLocationResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<BranchLocationResponse> call, @NotNull Response<BranchLocationResponse> response) {
//                        List<BranchDeal> branchDeals = new ArrayList<>();
                        if (response.isSuccessful()) {
                            BranchLocationResponse branchLocationResponse = response.body();
                            if (branchLocationResponse != null) {
//                                for (Branch branch : response.body().getBrances()) {
//                                    apiInterface.getBranchDeals(String.valueOf(branch.getBranchId()))
//                                            .enqueue(new Callback<BranchDealsResponse>() {
//                                                @Override
//                                                public void onResponse(@NotNull Call<BranchDealsResponse> call, @NotNull Response<BranchDealsResponse> response) {
//                                                    if (response.isSuccessful()) {
//                                                        if (response.body() != null) {
//                                                            branchDeals.addAll(response.body().getDeals());
//                                                        }
//                                                    }
//                                                }
//
//                                                @Override
//                                                public void onFailure(@NotNull Call<BranchDealsResponse> call, @NotNull Throwable t) {
//
//                                                }
//                                            });
//                                }
                                nearByDeals.postValue(branchLocationResponse);
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<BranchLocationResponse> call, @NotNull Throwable t) {
                        t.printStackTrace();
                    }
                });
        return nearByDeals;
    }

    public LiveData<BranchLocationResponse> getBranches(Location location) {
        MutableLiveData<BranchLocationResponse> branches = new MutableLiveData<>();
        apiInterface.getBranches(location.getLatitude(), location.getLongitude(), 0)
                .enqueue(new Callback<BranchLocationResponse>() {
                    @Override
                    public void onResponse(Call<BranchLocationResponse> call, Response<BranchLocationResponse> response) {
                        BranchLocationResponse result = response.body();
                        if (result != null) {
                            branches.postValue(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<BranchLocationResponse> call, Throwable t) {

                    }
                });
        return branches;
    }
}
