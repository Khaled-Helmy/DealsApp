package com.yalladealz.userapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yalladealz.userapp.model.Payment.FawryCallback;
import com.yalladealz.userapp.model.Payment.FawryRequest;
import com.yalladealz.userapp.model.Payment.FawryResponse;
import com.yalladealz.userapp.model.Payment.FawryStatusRequest;
import com.yalladealz.userapp.model.Payment.FawryStatusResponse;
import com.yalladealz.userapp.model.Payment.VisaRequest;
import com.yalladealz.userapp.model.Payment.VisaResponse;
import com.yalladealz.userapp.remote.ApiInterface;
import com.yalladealz.userapp.remote.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yalladealz.userapp.util.LogUtil.debug;
import static com.yalladealz.userapp.util.LogUtil.error;

public class FawryRepository {
	private ApiInterface apiInterface;
	private MutableLiveData<FawryResponse> payResponse = new MutableLiveData<>();
	private MutableLiveData<FawryStatusResponse> statusData = new MutableLiveData<>();
	private MutableLiveData<String> callbackData = new MutableLiveData<String>();
	private MutableLiveData<VisaResponse> visaTokenData = new MutableLiveData<>();

	public FawryRepository(){
		apiInterface = RetrofitClient.getPaymentAPI();
	}

	public LiveData<FawryResponse> payWithFawry(FawryRequest fawryRequest){
		apiInterface.payWithFawry(fawryRequest).enqueue(new Callback<FawryResponse>() {
			@Override
			public void onResponse(Call<FawryResponse> call, Response<FawryResponse> response) {
				FawryResponse fawryResponse = response.body();
				if (fawryResponse != null) {
					if (fawryResponse.getStatusCode() == 200
					&& fawryResponse.getStatusDescription().equals("Operation done successfully")) {
						debug("Pay with Fawry Succeed");
						debug(fawryResponse.getReferenceNumber());
					} else {
						error("Payment failed with error code: " + fawryResponse.getStatusCode());
						error("Payment failed with status: " + fawryResponse.getStatusDescription());
					}
					payResponse.postValue(fawryResponse);
				}
			}

			@Override
			public void onFailure(Call<FawryResponse> call, Throwable t) {
				t.printStackTrace();
			}
		});

		return payResponse;
	}

	public LiveData<FawryStatusResponse> getStatus(FawryStatusRequest statusRequest) {
		String merchant = statusRequest.getMerchantCode();
		debug("merchantCodee: " + merchant);
//		apiInterface
//				.getFawryStatus(merchant,
//						statusRequest.getMerchantRefNumber(),
//						statusRequest.getSignature())
//				.enqueue(new Callback<FawryStatusResponse>() {
//					@Override
//					public void onResponse(Call<FawryStatusResponse> call, Response<FawryStatusResponse> response) {
//						FawryStatusResponse statusResponse = response.body();
//						debug("urrl: " + response.toString());
//						if (statusResponse != null) {
//							if (statusResponse.getStatusCode() != 200) {
//								error(statusResponse.getStatusDescription());
//							} else {
//								debug(statusResponse.getStatusDescription());
//							}
//							statusData.postValue(statusResponse);
//						}
//					}
//
//					@Override
//					public void onFailure(Call<FawryStatusResponse> call, Throwable t) {
//
//					}
//				});

		OkHttpClient client = new OkHttpClient();

		String url
				= "https://atfawry.fawrystaging.com/ECommerceWeb/Fawry/payments/status?merchantCode="
				+ statusRequest.getMerchantCode() + "&"
				+ "merchantRefNumber=" + statusRequest.getMerchantRefNumber() + "&"
				+ "signature=" + statusRequest.getSignature();

		Request request = new Request.Builder()
				.url(url)
				.get()
				.build();

		new Thread(new Runnable() {
			@Override
			public void run() {
				//					okhttp3.Response response = client.newCall(request).execute();
				client.newCall(request).enqueue(new okhttp3.Callback() {
					@Override
					public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {
						e.printStackTrace();
					}

					@Override
					public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {
						ResponseBody responseBody = response.body();
						if (responseBody != null) {
							String body = responseBody.string();
							debug(body);
							Gson gson = new Gson();
							Type userType = new TypeToken<FawryStatusResponse>(){}.getType();
							FawryStatusResponse statusResponse = gson.fromJson(body, userType);
							statusData.postValue(statusResponse);
						}
					}
				});
			}
		}).start();


		return statusData;
	}

	public LiveData<String> getCallback(FawryCallback fawryCallback) {

		apiInterface.getFawryCallback(fawryCallback.getMerchantRef(),
				fawryCallback.getFawryRef(),
				fawryCallback.getOrderStatus(),
				String.valueOf(fawryCallback.getAmount()),
				fawryCallback.getMessageSignature())
				.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						ResponseBody body = response.body();
						if (body != null) {
							try {
								String text = body.string();
								callbackData.postValue(text);
							} catch (IOException e) {
								e.printStackTrace();
								callbackData.postValue(e.getLocalizedMessage());
							}
						} else {
							callbackData.postValue("");
						}
					}

					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						callbackData.postValue(t.getLocalizedMessage());
					}
				});
		return callbackData;
	}

	public LiveData<VisaResponse> getVisaToken(VisaRequest visaRequest) {
		apiInterface.getVisaToken(visaRequest)
				.enqueue(new Callback<VisaResponse>() {
					@Override
					public void onResponse(Call<VisaResponse> call, Response<VisaResponse> response) {
						debug(response.toString());
						VisaResponse visaResponse = response.body();
						if (visaResponse != null) {
							visaTokenData.postValue(visaResponse);
						}
					}

					@Override
					public void onFailure(Call<VisaResponse> call, Throwable t) {
						t.printStackTrace();
					}
				});
		return visaTokenData;
	}
}
