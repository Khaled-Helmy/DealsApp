package com.yalladealz.userapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

public class UserUpdateRepository implements RetrofitClient.GetData {

    private MutableLiveData<LoginResponse> userData = new MutableLiveData<>();
    private ApiInterface apiInterface;

    public UserUpdateRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public void updateUser(UserInfo userInfo){
        RetrofitClient.getData(userInfo, this, apiInterface);
    }

    @Override
    public void onSucceed(LoginResponse loginResponse) {
        userData.postValue(loginResponse);
    }

    public LiveData<LoginResponse> GetData(){
        return userData;
    }
}
