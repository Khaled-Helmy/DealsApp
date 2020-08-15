package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.OrderResponse;
import com.yalladealz.userapp.model.Payment.TokenResponse;
import com.yalladealz.userapp.repositories.VisaRepository;

public class VisaViewModel extends ViewModel {

    private VisaRepository visaRepository;

    public VisaViewModel() {
        visaRepository = new VisaRepository();
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
}
