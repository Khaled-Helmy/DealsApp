package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.AmanResponse;
import com.yalladealz.userapp.model.Payment.OrderResponse;
import com.yalladealz.userapp.model.Payment.TokenResponse;
import com.yalladealz.userapp.repositories.AmanRepository;
import com.yalladealz.userapp.repositories.VisaRepository;

public class AmanViewModel extends ViewModel {

    private VisaRepository visaRepository;
    private AmanRepository amanRepository;

    public AmanViewModel() {

        visaRepository = new VisaRepository();
        amanRepository = new AmanRepository();
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

    public LiveData<AmanResponse> payRequest(JsonObject data) {
        return amanRepository.payRequest(data);
    }
}
