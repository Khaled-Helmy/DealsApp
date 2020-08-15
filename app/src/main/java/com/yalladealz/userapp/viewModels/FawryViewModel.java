package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.yalladealz.userapp.model.Payment.FawryCallback;
import com.yalladealz.userapp.model.Payment.FawryRequest;
import com.yalladealz.userapp.model.Payment.FawryResponse;
import com.yalladealz.userapp.model.Payment.FawryStatusRequest;
import com.yalladealz.userapp.model.Payment.FawryStatusResponse;
import com.yalladealz.userapp.model.Payment.VisaRequest;
import com.yalladealz.userapp.model.Payment.VisaResponse;
import com.yalladealz.userapp.repositories.FawryRepository;

public class FawryViewModel extends ViewModel {

	private FawryRepository fawryRepository;

	public FawryViewModel() {
		fawryRepository = new FawryRepository();
	}

	public LiveData<FawryResponse> payRequest(FawryRequest fawryRequest) {
		return fawryRepository.payWithFawry(fawryRequest);
	}

	public LiveData<VisaResponse> getVisaToken(VisaRequest visaRequest) {
		return fawryRepository.getVisaToken(visaRequest);
	}
	public LiveData<FawryStatusResponse> getStatus(FawryStatusRequest statusRequest) {
		return fawryRepository.getStatus(statusRequest);
	}

	public LiveData<String> getCallback(FawryCallback fawryCallback) {
		return fawryRepository.getCallback(fawryCallback);
	}
}
