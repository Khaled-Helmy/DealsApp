package com.yalladealz.userapp.viewModels;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.Task;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.repositories.LoginRepository;

import static com.yalladealz.userapp.util.LogUtil.debug;

public class LoginViewModel extends AndroidViewModel {

    private LoginRepository loginRepository;
    private LiveData<LoginResponse> responseLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
        responseLiveData = loginRepository.getData();
    }

    public void login(String username, String password) {
        loginRepository.login(username, password);
    }

    public void loginMobile(String mobile, String password) {
        loginRepository.loginMobile(mobile, password);
    }

    public void forget(SginUpUserInfo info){
        loginRepository.forgetPassword(info);
    }

    public void loginFlied(SginUpUserInfo info){
        loginRepository.getLoginFliedData(info);
    }

    public LiveData<LoginResponse> getData() {
        return responseLiveData;
    }

    public LiveData<String> getError() {
        return loginRepository.getError();
    }

    public void facebookLogin(LoginButton loginButton, CallbackManager callbackManager, Activity activity) {
        debug("facebook viewmodel");
        loginRepository.facebookLogin(loginButton, callbackManager, activity);

    }

    public GoogleSignInClient configureGoogleSignIn() {
        return loginRepository.configureGoogleSignIn();

    }

    public GoogleSignInAccount getLastSignedInAccount() {
        return loginRepository.getLastSignedInAccount();
    }

    public Task<GoogleSignInAccount> getSinedInAccount(Intent data) {
        return loginRepository.getSinedInAccount(data);
    }

    public Intent signIn(GoogleSignInClient signInClient) {
        return loginRepository.signIn(signInClient);
    }

    public String getEmailGoogle (String userEmail){
    return userEmail ;
    }

    public String getLastNameGoogle(String userLastName){
        return userLastName;
    }

}

