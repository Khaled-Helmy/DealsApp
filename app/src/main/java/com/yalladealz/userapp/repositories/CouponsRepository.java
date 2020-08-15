package com.yalladealz.userapp.repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.responses.CouponData;
import com.yalladealz.userapp.model.responses.CouponResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;
import com.yalladealz.userapp.util.SharedPrefUtil;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CouponsRepository {

    private ApiInterface apiInterface;
    private MutableLiveData<List<CouponData>> coupons = new MutableLiveData<>();

    public CouponsRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public LiveData<List<CouponData>> getCoupons(Context context, String deal_id) {

        String user_id = String.valueOf(SharedPrefUtil.getLoginResponse(context).getUserInfo().getUserId());
        String hash = SharedPrefUtil.getLoginResponse(context).getUserInfo().getAppHash();

//        String user_id = "25";
//        String hash = "nDORtJdAZL1PbToFDGC85Av5nY5EpA";

        apiInterface.getCoupons(user_id, hash, deal_id).enqueue(new Callback<CouponResponse>() {
            @Override
            public void onResponse(@NotNull Call<CouponResponse> call, @NotNull Response<CouponResponse> response) {

                CouponResponse couponResponse = response.body();
                if (couponResponse != null) {
                    if (couponResponse.getError() == 0) {
                        coupons.postValue(couponResponse.getCoupons());
                    } else {
                        Log.v("CouponsRepository", "getCoupons: onSuccess: error");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<CouponResponse> call, @NotNull Throwable t) {
                Log.v("CouponsRepository", "getCoupons: onFailure: " + t.getMessage());
            }
        });

        return coupons;
    }


}
