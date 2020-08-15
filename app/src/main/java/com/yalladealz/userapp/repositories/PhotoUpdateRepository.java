package com.yalladealz.userapp.repositories;

import com.yalladealz.userapp.model.responses.PhotoResponse;
import com.yalladealz.userapp.remote.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoUpdateRepository {

    public void updatePhoto(MultipartBody.Part body) {
        RetrofitClient.getInstance().updatePhoto(body).enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(@NotNull Call<PhotoResponse> call, @NotNull Response<PhotoResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        PhotoResponse photoResponse = response.body();
                    }
                }
                //TODO: Finish implementation - waiting for API

                //there is no API yet
                //save to SharedPref
            }

            @Override
            public void onFailure(@NotNull Call<PhotoResponse> call, @NotNull Throwable t) {

            }
        });
    }
}
