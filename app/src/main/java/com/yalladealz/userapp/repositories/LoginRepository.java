package com.yalladealz.userapp.repositories;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;
import com.yalladealz.userapp.util.SharedPrefUtil;

import org.json.JSONException;

import java.util.Arrays;

import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.EMAIL;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.ID;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.USER_NAME;
import static com.yalladealz.userapp.util.LogUtil.debug;
import static com.yalladealz.userapp.util.LogUtil.verbose;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class LoginRepository implements RetrofitClient.GetLogin {

    private Application application;
    private ApiInterface apiInterface;
    private MutableLiveData<LoginResponse> loginResponseMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorMutableLiveData = new MutableLiveData<>();


    public LoginRepository(Application application) {
        apiInterface = RetrofitClient.getInstance();
        this.application = application;
        if (errorMutableLiveData != null) {
            errorMutableLiveData.postValue(null);
        }
    }

    public void  forgetPassword(SginUpUserInfo info){
        RetrofitClient.getforgetpassword(info , this,apiInterface);
    }
    public void getLoginFliedData(SginUpUserInfo info){
        RetrofitClient.getLoginFlied(info,this,apiInterface);
    }

    public void login(String email, String password) {
        RetrofitClient.login(email, password, this, apiInterface);
    }

    public void loginMobile(String mobile, String password) {
        RetrofitClient.loginMobile(mobile, password, this, apiInterface);
    }

    @Override
    public void onSucceed(LoginResponse loginResponse) {
        loginResponseMutableLiveData.postValue(loginResponse);

        save(application, "loginExpiration", System.currentTimeMillis());
    }

    @Override
    public void onError(String error) {
        errorMutableLiveData.postValue(error);
    }

    public LiveData<LoginResponse> getData() {
        return loginResponseMutableLiveData;
    }

    public LiveData<String> getError() {
        return errorMutableLiveData;
    }

    public void facebookLogin(LoginButton loginButton, CallbackManager callbackManager, Activity activity) {
        debug("facebook repo.");
        loginButton.setPermissions(Arrays.asList("email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult result) {
                AccessToken token = result.getAccessToken();
                debug("facebook token: " + token);
                userProfileInfo(token, activity);
            }

            @Override
            public void onCancel() {
                debug("cancel");
            }

            @Override
            public void onError(FacebookException error) {
                verbose("onFacebookLoginError: " + error.getMessage());

            }
        });
    }

    private void userProfileInfo(AccessToken token, Activity activity) {
        debug("userProfileInfo");
        GraphRequest request = GraphRequest.newMeRequest(token, (object, response) -> {
            debug("request: " + response.toString());
            try {
                String name = object.getString("name");
                debug("name: " + name);

                String email = object.getString("email");
                String id = object.getString("id");

                saveData(name, email, id, activity);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        });
        Bundle param = new Bundle();
        param.putString("fields", "id,name,email,picture.width(200)");
        request.setParameters(param);
        request.executeAsync();
    }

    private void saveDataGoogle(String email , String LastName){
        if (!SharedPrefUtil.hasKey(application,ID)){



        }

    }

    private void saveData(String name, String email, String id, Activity activity) {
        debug("saveData");
        if (!SharedPrefUtil.hasKey(application, ID)) {
            save(application, ID, id);
            save(application, EMAIL, email);
            save(application, USER_NAME, name);
            save(application, "loginExpiration", System.currentTimeMillis());
            Navigation.findNavController(activity, R.id.nav_host_fragment)
                    .navigate(R.id.action_loginFragment_to_registerFragment);
        }
        else {
            save(application, "loginExpiration", System.currentTimeMillis());
            debug("navigating");
            Navigation.findNavController(activity, R.id.nav_host_fragment)
                    .navigate(R.id.action_global_homeFragment);
        }
    }

    public GoogleSignInClient configureGoogleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(application.getString(R.string.request_default_web_client_id))
                .requestId()
                .requestEmail()
                .build();

        verbose("onConfigureGoogleSignIn");
        return GoogleSignIn.getClient(application, gso);
    }

    public GoogleSignInAccount getLastSignedInAccount() {
        verbose("getLastSignedInAccount");
        return      GoogleSignIn.getLastSignedInAccount(application);
    }

    public Task<GoogleSignInAccount> getSinedInAccount(Intent data) {
        return GoogleSignIn.getSignedInAccountFromIntent(data);
    }

    public Intent signIn(GoogleSignInClient signInClient) {
        return signInClient.getSignInIntent();
    }

}
