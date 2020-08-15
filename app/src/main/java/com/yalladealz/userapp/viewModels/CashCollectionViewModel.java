package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.CashCollectionResponse;
import com.yalladealz.userapp.model.Payment.OrderResponse;
import com.yalladealz.userapp.model.Payment.TokenResponse;
import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.repositories.CashCollectionRepository;
import com.yalladealz.userapp.repositories.UserAddressesRepository;
import com.yalladealz.userapp.repositories.VisaRepository;

import java.util.List;

public class CashCollectionViewModel extends ViewModel {

    private VisaRepository visaRepository;
    private CashCollectionRepository cashCollectionRepository;
    private UserAddressesRepository userAddressesRepository;

    public CashCollectionViewModel() {

        visaRepository = new VisaRepository();
        userAddressesRepository = new UserAddressesRepository();
        cashCollectionRepository = new CashCollectionRepository();
    }

    public LiveData<TokenResponse> getToken(JsonObject key) {
        return visaRepository.getToken(key);
    }

    public LiveData<OrderResponse> registerOrder(JsonObject order) {
        return visaRepository.registerOrder(order);
    }

    public LiveData<String> getPaymentKey(JsonObject details) {
        return visaRepository.getPaymentKey(details);
    }

    public LiveData<CashCollectionResponse> payRequest(JsonObject data) {
        return cashCollectionRepository.payRequest(data);
    }

    public LiveData<List<Address>> getUserAddresses(String user_id, String hash) {
        return userAddressesRepository.getUserAddresses(user_id, hash);
    }

}
