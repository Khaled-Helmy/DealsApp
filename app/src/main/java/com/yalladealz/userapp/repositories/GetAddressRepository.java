package com.yalladealz.userapp.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.model.responses.UserAddressesResponse;
import com.yalladealz.userapp.model.responses.check.CheckAddAddress;
import com.yalladealz.userapp.model.responses.check.CheckDeleteAddress;
import com.yalladealz.userapp.model.responses.check.CheckEditAddress;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAddressRepository implements RetrofitClient.AddressFace {

    private ApiInterface apiInterface;
    private MutableLiveData<UserAddressesResponse> addressMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CheckAddAddress> addAddressMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CheckEditAddress> editAddressMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CheckDeleteAddress> deleteAddressMutableLiveData = new MutableLiveData<>();

    public GetAddressRepository() {
        apiInterface = RetrofitClient.getInstance();
    }

    public void getAddress(Long id, String hash){
        RetrofitClient.getAddress(id, hash, this, apiInterface);
    }

    @Override
    public void onSucceed(UserAddressesResponse addressesResponse) {
        addressMutableLiveData.postValue(addressesResponse);
    }

    public LiveData<UserAddressesResponse> getUserAddressList(){
        return addressMutableLiveData;
    }

    public LiveData<CheckAddAddress> addAddress(Address address){
        Call<CheckAddAddress> callAdd = apiInterface.addAddress(address);
        callAdd.enqueue(new Callback<CheckAddAddress>() {
            @Override
            public void onResponse(@NonNull Call<CheckAddAddress> call, @NonNull Response<CheckAddAddress> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        addAddressMutableLiveData.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<CheckAddAddress> call, @NonNull Throwable t) {

            }
        });
        return addAddressMutableLiveData;
    }

    public LiveData<CheckEditAddress> editAddress(Address address){
        Call<CheckEditAddress> callEdit = apiInterface.editAddress(address);
        callEdit.enqueue(new Callback<CheckEditAddress>() {
            @Override
            public void onResponse(@NonNull Call<CheckEditAddress> call, @NonNull Response<CheckEditAddress> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        editAddressMutableLiveData.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<CheckEditAddress> call, @NonNull Throwable t) {

            }
        });
        return editAddressMutableLiveData;
    }

    public LiveData<CheckDeleteAddress> deleteAddress(Long user_id, String hash, Long address_id){
        Call<CheckDeleteAddress> callDelete = apiInterface.deleteAddress(user_id, hash, address_id);
        callDelete.enqueue(new Callback<CheckDeleteAddress>() {
            @Override
            public void onResponse(@NonNull Call<CheckDeleteAddress> call, @NonNull Response<CheckDeleteAddress> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        deleteAddressMutableLiveData.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<CheckDeleteAddress> call, @NonNull Throwable t) {

            }
        });
        return deleteAddressMutableLiveData;
    }
}
