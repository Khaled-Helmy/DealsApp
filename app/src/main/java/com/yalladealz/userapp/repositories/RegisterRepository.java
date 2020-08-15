package com.yalladealz.userapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

public class RegisterRepository implements RetrofitClient.Register {

    private MutableLiveData<LoginResponse> responseMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorString = new MutableLiveData<>();
    private ApiInterface apiInterface ;

    public RegisterRepository() {
        apiInterface = RetrofitClient.getInstance();
    }



    public void getRegisterData(SginUpUserInfo info) {
        RetrofitClient.getRegister(info, this, apiInterface); }



    @Override
    public void onSucceed(LoginResponse loginResponse) {

        responseMutableLiveData.postValue(loginResponse);
    }

    @Override
    public void onError(String msg) {

        errorString.postValue(msg);
    }

    public LiveData<LoginResponse> getRegisterResponse()
    {
        return responseMutableLiveData;
    }

    public LiveData<String> getErrorResponse()
    {
        return errorString;
    }

}