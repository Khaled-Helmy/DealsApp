package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.repositories.RegisterRepository;

public class RegisterViewModel extends ViewModel {

    private RegisterRepository registerRepository;
    private LiveData<LoginResponse> loginResponseLiveData;
    private LiveData<String> responseError;

    public RegisterViewModel() {

        registerRepository = new RegisterRepository();
        loginResponseLiveData = registerRepository.getRegisterResponse();
        responseError = registerRepository.getErrorResponse();
    }

    public void register(SginUpUserInfo info){
            registerRepository.getRegisterData(info);
        }


    public LiveData<LoginResponse> getRegisterResponseLiveData() {

        return loginResponseLiveData;
    }

    public LiveData<String> getResponseError() {
        return responseError;
    }

}
