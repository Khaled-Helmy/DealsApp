package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.Payment.OrderResponse;
import com.yalladealz.userapp.model.Payment.PayWithAman;
import com.yalladealz.userapp.model.Payment.PaymentApiKey;
import com.yalladealz.userapp.model.Payment.PaymentGetKey;
import com.yalladealz.userapp.model.Payment.PaymentOrder;
import com.yalladealz.userapp.model.Payment.TokenResponse;
import com.yalladealz.userapp.model.Payment.WalletResponse;
import com.yalladealz.userapp.repositories.VisaRepository;
import com.yalladealz.userapp.repositories.WalletRepository;

public class WalletViewModel extends ViewModel {

    private VisaRepository visaRepository;
    private WalletRepository walletRepository;

    public WalletViewModel() {
        visaRepository = new VisaRepository();
        walletRepository = new WalletRepository();
    }

    public LiveData<TokenResponse> getToken(JsonObject key){
        return visaRepository.getToken(key);
    }

    public LiveData<OrderResponse> registerOrder(JsonObject order){
        return visaRepository.registerOrder(order);
    }

    public LiveData<String> getPaymentKey(JsonObject details){
        return visaRepository.getPaymentKey(details);
    }

    public LiveData<WalletResponse> payRequest(JsonObject data){
        return walletRepository.payRequest(data);
    }
}
