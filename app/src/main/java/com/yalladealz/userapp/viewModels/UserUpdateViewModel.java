package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.repositories.UserUpdateRepository;

public class UserUpdateViewModel extends ViewModel {

    private UserUpdateRepository userUpdateRepository;
    private LiveData<LoginResponse> userData;

    public UserUpdateViewModel() {
        userUpdateRepository = new UserUpdateRepository();
        userData = userUpdateRepository.GetData();
    }

    public void UpdateUser(UserInfo userInfo){
        userUpdateRepository.updateUser(userInfo);
    }

    public LiveData<LoginResponse> GetData(){
        return userData;
    }
}
