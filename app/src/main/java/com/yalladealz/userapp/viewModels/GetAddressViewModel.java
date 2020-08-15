package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.model.responses.UserAddressesResponse;
import com.yalladealz.userapp.model.responses.check.CheckAddAddress;
import com.yalladealz.userapp.model.responses.check.CheckDeleteAddress;
import com.yalladealz.userapp.model.responses.check.CheckEditAddress;
import com.yalladealz.userapp.repositories.GetAddressRepository;

public class GetAddressViewModel extends ViewModel {

    private GetAddressRepository getAddressRepository = new GetAddressRepository();
    private LiveData<UserAddressesResponse> userAddressesResponseLiveData;

    public GetAddressViewModel() {
        userAddressesResponseLiveData = getAddressRepository.getUserAddressList();
    }

    public LiveData<UserAddressesResponse> getUserAddressList() {
        return userAddressesResponseLiveData;
    }

    public void getAddress(Long id, String hash) {
        getAddressRepository.getAddress(id, hash);
    }

    public LiveData<CheckAddAddress> addAddress(Address address) {
        return getAddressRepository.addAddress(address);
    }

    public LiveData<CheckEditAddress> editAddress(Address address) {
        return getAddressRepository.editAddress(address);
    }

    public LiveData<CheckDeleteAddress> deleteAddress(Long user_id, String hash, Long address_id) {
        return getAddressRepository.deleteAddress(user_id, hash, address_id);
    }
}
