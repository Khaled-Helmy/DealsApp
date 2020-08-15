package com.yalladealz.userapp.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yalladealz.userapp.model.History.HistoryResponse;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.model.responses.UserAddressesResponse;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.repositories.LoginRepository;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.yalladealz.userapp.util.LogUtil.verbose;

public class RetrofitClient {

   private static final String BASE_URL = "https://yalla-ebdaa.herokuapp.com/";
    private static final String BASE_PHONE_URL = "https://api.cequens.com/";
    private static final String FAWRY_URL = "https://www.atfawry.com/";
    private static final String ACCEPT_URL = "https://accept.paymobsolutions.com/";


    private static ApiInterface sInstance = null;
    private static ApiInterface sInstanceP = null;
    private static ApiInterface paymentInstance = null;
    private static ApiInterface acceptInstance = null;

    public static ApiInterface getInstance() {

        if (sInstance == null) {

            HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)

                    .build();

            Retrofit.Builder builder =
                    new Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create());

            sInstance = builder.build().create(ApiInterface.class);
        }
        return sInstance;
    }

    public static ApiInterface getPhoneAPI() {
        if (sInstanceP == null) {

            //For logging
            HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            // Building OkHttp client
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl( BASE_PHONE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            sInstanceP = retrofit.create(ApiInterface.class);
        }
        return sInstanceP;
    }


    public static ApiInterface getPaymentAPI() {
        if (paymentInstance == null) {

            //For logging
            HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            Gson gson = new GsonBuilder().disableHtmlEscaping()
                    .setLenient()
                    .create();
            // Building OkHttp client
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(FAWRY_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            paymentInstance = retrofit.create(ApiInterface.class);
        }

        return paymentInstance;
    }

    public static ApiInterface getAcceptAPI() {
        if (acceptInstance == null) {

            //For logging
            HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            Gson gson = new GsonBuilder().disableHtmlEscaping()
                    .setLenient()
                    .create();
            // Building OkHttp client
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ACCEPT_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            acceptInstance = retrofit.create(ApiInterface.class);
        }

        return acceptInstance;
    }
    ////////// post userInfo to New Api




    public static void getRegister(SginUpUserInfo info, final Register  register, ApiInterface apiInterface) {


        Call<LoginResponse> call = apiInterface.register(info);
            call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.v("khaled100","khaled100" );
                        register.onSucceed(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Log.v("khaled200","khaled200" );
                register.onError(t.getMessage());
            }
        });
    }


    public static void getLoginFlied(SginUpUserInfo info, final LoginRepository login, ApiInterface apiInterface) {


        Call<LoginResponse> call =  apiInterface.loginFlied(info);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.v("khaled100LoginFlied","khaled100LoginFlied" );


                        login.onSucceed(response.body());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Log.v("khaled200LoginFlied","khaled200LoginFlied" );
                login.onError(t.getMessage());
            }
        });
    }
    public static void getforgetpassword(SginUpUserInfo info, final LoginRepository login, ApiInterface apiInterface) {


        Call<LoginResponse> call =  apiInterface.forgetPassword(info);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.v("khaled5000","khaled5000" );
                        login.onSucceed(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Log.v("khaled6000","khaled6000" );
                login.onError(t.getMessage());
            }
        });
    }

    public static void login(String mobile, String password, final GetLogin getLogin, ApiInterface apiInterface) {

        Call<LoginResponse> call = apiInterface.login(mobile, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        getLogin.onSucceed(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                getLogin.onError(t.getMessage());
            }
        });
    }

    public static void loginMobile(String mobile, String password, final GetLogin getLogin, ApiInterface apiInterface) {

        Call<LoginResponse> call = apiInterface.loginMobile(mobile, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        getLogin.onSucceed(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                getLogin.onError(t.getMessage());
            }
        });
    }

    public static void getData(UserInfo userInfo, GetData getData, ApiInterface apiInterface) {
        Call<LoginResponse> call = apiInterface.updateUser(userInfo);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        getData.onSucceed(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                verbose("response: failed " + t.getMessage());
            }
        });
    }

    public static void getHistory(Long id, String hash, HistoryFace historyFace, ApiInterface apiInterface) {
        Call<HistoryResponse> call = apiInterface.getHistory(id, hash);
        call.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<HistoryResponse> call, @NonNull Response<HistoryResponse> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        historyFace.onSucceed(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<HistoryResponse> call, @NonNull Throwable t) {

            }
        });
    }

    public static void getAddress(Long id, String hash, AddressFace addressFace, ApiInterface apiInterface) {

        Call<UserAddressesResponse> call = apiInterface.getAddresses(id, hash);
        call.enqueue(new Callback<UserAddressesResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserAddressesResponse> call, @NonNull Response<UserAddressesResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        addressFace.onSucceed(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserAddressesResponse> call, @NonNull Throwable t) {

            }
        });
    }

    public interface Register {
        void onSucceed(LoginResponse loginResponse);

        void onError(String msg);
    }

    public interface GetLogin {
        void onSucceed(LoginResponse loginResponse);

        void onError(String error);
    }

    public interface GetData {
        void onSucceed(LoginResponse loginResponse);
    }

    public interface HistoryFace {
        void onSucceed(HistoryResponse historyResponse);
    }

    public interface AddressFace {
        void onSucceed(UserAddressesResponse addressesResponse);
    }
}