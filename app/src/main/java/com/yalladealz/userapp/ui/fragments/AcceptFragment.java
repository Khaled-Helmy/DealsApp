package com.yalladealz.userapp.ui.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.paymob.acceptsdk.IntentConstants;
import com.paymob.acceptsdk.PayActivity;
import com.paymob.acceptsdk.PayActivityIntentKeys;
import com.paymob.acceptsdk.PayResponseKeys;
import com.paymob.acceptsdk.SaveCardResponseKeys;
import com.paymob.acceptsdk.ToastMaker;
import com.yalladealz.userapp.BuildConfig;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.Payment.ChargeItem;
import com.yalladealz.userapp.model.Payment.FawryRequest;
import com.yalladealz.userapp.model.Payment.FawryResponse;
import com.yalladealz.userapp.model.Payment.PaymentShippingData;
import com.yalladealz.userapp.model.Payment.VisaRequest;
import com.yalladealz.userapp.model.Payment.VisaResponse;
import com.yalladealz.userapp.viewModels.FawryViewModel;
import com.yalladealz.userapp.viewModels.VisaViewModel;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.LogUtil.debug;


public class AcceptFragment extends Fragment {

	private static final String API_KEY = "ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6VXhNaUo5LmV5SnVZVzFsSWpvaU1UVTJOVEUzT0RneE1DNDNPRFEzTURraUxDSmpiR0Z6Y3lJNklrMWxjbU5vWVc1MElpd2ljSEp2Wm1sc1pWOXdheUk2TVRZME5YMC5wdkRlQW05a05kbjhidndRY1RCdDRQeERON1RFWFBMMkQzN3YzaDNpZjBZOWNPUUtoZG16VGNTcHBYRi1QSnNUdlB2U0c3ZWdRbE9sYU12RC1OYUVYUQ==";
	private final int ACCEPT_PAYMENT_REQUEST = 1;

	@BindView(R.id.et_card_number)
	TextInputEditText cardNumberEt;
	@BindView(R.id.et_expire)
	TextInputEditText expireEt;
	@BindView(R.id.et_cvv)
	TextInputEditText cvvEt;
	@BindView(R.id.et_name)
	TextInputEditText nameEt;
	@BindView(R.id.continueBtn)
	Button continueBtn;
	@BindView(R.id.card_number)
	TextView cardNumber;
	@BindView(R.id.card_expire)
	TextView cardExpire;
	@BindView(R.id.card_cvv)
	TextView cvvCard;
	@BindView(R.id.card_name)
	TextView cardName;
	@BindView(R.id.et_phone)
	TextInputEditText phoneEt;
	@BindView(R.id.et_email)
	TextInputEditText emailEt;

	ProgressDialog progressDialog;
	JsonObject key;

	private int money;
	ArrayList<CartProduct> products;
	Unbinder unbinder;

	VisaViewModel viewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_visa, container, false);

		unbinder = ButterKnife.bind(this, view);

		if (getArguments() != null) {
			money = getArguments().getInt("money", 0) * 100;
			products = getArguments().getParcelableArrayList("products");
		}
//        money = 10;

		if (BuildConfig.DEBUG) {
			nameEt.setText("Test Account");
			cardNumberEt.setText("4987654321098769");
			expireEt.setText("05/21");
			cvvEt.setText("123");
			phoneEt.setText("01000000000");
			emailEt.setText("test@te.com");
		}

		viewModel = ViewModelProviders.of(this).get(VisaViewModel.class);
		key = new JsonObject();
		key.addProperty("api_key", API_KEY);

		return view;
	}

	@OnClick(R.id.continueBtn)
	public void onClick(){
		progressDialog = new ProgressDialog(getContext());
		progressDialog.setCancelable(false);
		progressDialog.setTitle("Loading...");
		progressDialog.setMessage("Getting token");

//        boolean isShipping = getIntent().getBooleanExtra("shipping", false);
		if (checkInput()) {
			progressDialog.show();
			viewModel.getToken(key).observe(this, response -> {
				if (response != null) {
					String token = response.getToken();
					debug("token: " + token);
					registerOrder(token,
							String.valueOf(response.getProfile().getId()),
							String.valueOf(System.currentTimeMillis())
					);
				} else {
					progressDialog.dismiss();
				}
			});
		}
	}

	private boolean checkInput() {
		boolean check = false;
		if (cardNumberEt.getEditableText().toString().trim().equals("")) {
			cardNumberEt.setError("Enter card number");
		} else if (expireEt.getEditableText().toString().trim().equals("")) {
			expireEt.setError("Enter expire date");
		} else if (cvvEt.getEditableText().toString().trim().equals("")) {
			cvvEt.setError("Enter CVV");
		} else if (nameEt.getEditableText().toString().trim().equals("")) {
			nameEt.setError("Enter Name on the Card");
		} else if(phoneEt.getEditableText().toString().trim().equals("")){
			phoneEt.setError("Enter your phone");
		} else if (emailEt.getEditableText().toString().trim().equals("")) {
			emailEt.setError("Enter your email");
		} else {
			check = true;
		}
		return check;
	}

	private void registerOrder(String token, String merchant_id, String merchant_order_id) {

		JsonObject order = new JsonObject();
		order.addProperty("auth_token", token);
		order.addProperty("delivery_needed", false);
		order.addProperty("merchant_id", String.valueOf(merchant_id));
		order.addProperty("amount_cents", String.valueOf(money));
		order.addProperty("currency", "EGP");
		order.addProperty("merchant_order_id", merchant_order_id);
		// FIXME: 12/09/19 get items
		JsonArray array = new JsonArray();
		for (CartProduct product : products) {
			JsonObject object = new JsonObject();
			object.addProperty("name", product.getTitle());
			object.addProperty("amount_cents", product.getPrice());
			object.addProperty("quantity", product.getAmount());
			array.add(object);
			order.add("items", array);

		}

		debug("ordeer: " + order.toString());
		viewModel.registerOrder(order).observe(this,
				orderResponse -> {
					debug("register: " + orderResponse);
					getPaymentKey(token, orderResponse.getId(), orderResponse.getShippingData());
				});

	}

	private void getPaymentKey(String token, int order_id, PaymentShippingData shippingData) {

		JsonObject details = new JsonObject();
		details.addProperty("amount_cents", String.valueOf(money));
		details.addProperty("auth_token", token);

//		if (shippingData != null) {
//			JsonObject data = new JsonObject();
//			data.addProperty("apartment", shippingData.getApartment());
//			data.addProperty("building", shippingData.getBuilding());
//			data.addProperty("city",shippingData.getCity());
//			data.addProperty("country",shippingData.getCountry());
//			data.addProperty("email",shippingData.getEmail());
//			data.addProperty("first_name",shippingData.getFirstName());
//			data.addProperty("floor",shippingData.getFloor());
//			data.addProperty("last_name",shippingData.getLastName());
//			data.addProperty("phone_number",shippingData.getPhoneNumber());
//			data.addProperty("postal_code",shippingData.getPostalCode());
//			data.addProperty("shipping_method",shippingData.getShipping_method());
//			data.addProperty("state",shippingData.getState());
//			data.addProperty("street",shippingData.getStreet());
//			details.add("billing_data", data);
//		}

		details.addProperty("currency", "EGP");
		details.addProperty("expiration",3600);
		details.addProperty("integration_id", 2413);
		details.addProperty("lock_order_when_paid", false);
		details.addProperty("order_id", String.valueOf(order_id));


		viewModel.getPaymentKey(details).observe(this, s -> {

			final String PAYMENT_KEY = s;

			progressDialog.dismiss();
			startPayActivityNoToken(PAYMENT_KEY, true);
		});
	}

	private void startPayActivityNoToken(String payment, Boolean showSaveCard) {
		Intent pay_intent = new Intent(getContext(), PayActivity.class);

		putNormalExtras(pay_intent, payment);
		pay_intent.putExtra(PayActivityIntentKeys.SAVE_CARD_DEFAULT, true);
		pay_intent.putExtra(PayActivityIntentKeys.SHOW_ALERTS, showSaveCard);
		pay_intent.putExtra(PayActivityIntentKeys.SHOW_SAVE_CARD, showSaveCard);
		pay_intent.putExtra(PayActivityIntentKeys.THEME_COLOR, 0x8033B5E5);

		startActivityForResult(pay_intent, ACCEPT_PAYMENT_REQUEST);
	}

//	private void startPayActivityToken(String PAYMENT_KEY) {
//		try {
//			debug("finisheed");
//			Intent pay_intent = new Intent(getContext(), PayActivity.class);
//
//			putNormalExtras(pay_intent, PAYMENT_KEY);
//			// replace this with your actual card token
//			pay_intent.putExtra(PayActivityIntentKeys.TOKEN, "eeb8890b12907005ec4e58ede5df7bc6df1ef4adba01c0cb687eb9168be2217d");
//			pay_intent.putExtra(PayActivityIntentKeys.MASKED_PAN_NUMBER, "4987654321098769");
//			pay_intent.putExtra(PayActivityIntentKeys.SAVE_CARD_DEFAULT, false);
//			pay_intent.putExtra(PayActivityIntentKeys.SHOW_ALERTS, true);
//			pay_intent.putExtra(PayActivityIntentKeys.SHOW_SAVE_CARD, false);
//
//			debug("starting activity");
//			startActivityForResult(pay_intent, ACCEPT_PAYMENT_REQUEST);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	private void putNormalExtras(Intent intent, String PAYMENT_KEY) {
		intent.putExtra(PayActivityIntentKeys.FIRST_NAME, "Test");
		intent.putExtra(PayActivityIntentKeys.LAST_NAME, "Account");
		intent.putExtra(PayActivityIntentKeys.BUILDING, "1");
		intent.putExtra(PayActivityIntentKeys.FLOOR, "1");
		intent.putExtra(PayActivityIntentKeys.APARTMENT, "1");
		intent.putExtra(PayActivityIntentKeys.CITY, "cairo");
		intent.putExtra(PayActivityIntentKeys.STATE, "new_cairo");
		intent.putExtra(PayActivityIntentKeys.COUNTRY, "egypt");
		intent.putExtra(PayActivityIntentKeys.EMAIL, "email@gmail.com");
		intent.putExtra(PayActivityIntentKeys.PHONE_NUMBER, "2345678");
		intent.putExtra(PayActivityIntentKeys.POSTAL_CODE, "3456");
		intent.putExtra(PayActivityIntentKeys.PAYMENT_KEY, PAYMENT_KEY);

		intent.putExtra(PayActivityIntentKeys.THREE_D_SECURE_ACTIVITY_TITLE, "Verification");
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		debug("requeest: " + requestCode);
		debug("result: " + resultCode);
		Bundle extras = data.getExtras();
		String TAG = "extraaa";
		if (extras != null) {
			Bundle bundle1 = data.getExtras();
				for (String key : bundle1.keySet()) {
					Object value = bundle1.get(key);
					Log.d("extraaa", String.format("%s %s (%s)", key,
							value.toString(), value.getClass().getName()));
				}
			if (extras.getString(PayResponseKeys.PENDING).equals("false")
					&& extras.getString(PayResponseKeys.SUCCESS).equals("true")) {
		        Bundle bundle = new Bundle();
		        bundle.putString("action", "finished");
				Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
						.navigate(R.id.action_acceptFragment_to_cartFragment, bundle);
				debug("done");
				Toast.makeText(getContext(), extras.getString(PayResponseKeys.DATA_MESSAGE), Toast.LENGTH_SHORT).show();
			} else if (extras.getString(PayResponseKeys.PENDING).equals("true")) {
				debug("pending");
				Toast.makeText(getContext(), extras.getString(PayResponseKeys.DATA_MESSAGE), Toast.LENGTH_SHORT).show();
			} else {
				debug("failed");
				Toast.makeText(getContext(), extras.getString(PayResponseKeys.DATA_MESSAGE), Toast.LENGTH_SHORT).show();
			}
		}
		if (requestCode == ACCEPT_PAYMENT_REQUEST) {

			if (resultCode == IntentConstants.USER_CANCELED) {
				// User canceled and did no payment request was fired
				ToastMaker.displayShortToast(getActivity(), "User canceled!!");
			} else if (resultCode == IntentConstants.MISSING_ARGUMENT) {
				// You forgot to pass an important key-value pair in the intent's extras
				ToastMaker.displayShortToast(getActivity(), "Missing Argument == " + extras.getString(IntentConstants.MISSING_ARGUMENT_VALUE));
			} else if (resultCode == IntentConstants.TRANSACTION_ERROR) {
				// An error occurred while handling an API's response
				ToastMaker.displayShortToast(getActivity(), "Reason == " + extras.getString(IntentConstants.TRANSACTION_ERROR_REASON));
			} else if (resultCode == IntentConstants.TRANSACTION_REJECTED) {
				// User attempted to pay but their transaction was rejected

				// Use the static keys declared in PayResponseKeys to extract the fields you want
				ToastMaker.displayShortToast(getActivity(), extras.getString(PayResponseKeys.DATA_MESSAGE));
			} else if (resultCode == IntentConstants.TRANSACTION_REJECTED_PARSING_ISSUE) {
				// User attempted to pay but their transaction was rejected. An error occured while reading the returned JSON
				ToastMaker.displayShortToast(getActivity(), extras.getString(IntentConstants.RAW_PAY_RESPONSE));
			} else if (resultCode == IntentConstants.TRANSACTION_SUCCESSFUL) {
				// User finished their payment successfully

				// Use the static keys declared in PayResponseKeys to extract the fields you want
				ToastMaker.displayShortToast(getActivity(), extras.getString(PayResponseKeys.DATA_MESSAGE));
			} else if (resultCode == IntentConstants.TRANSACTION_SUCCESSFUL_PARSING_ISSUE) {
				// User finished their payment successfully. An error occured while reading the returned JSON.
				ToastMaker.displayShortToast(getActivity(), "TRANSACTION_SUCCESSFUL - Parsing Issue");

				// ToastMaker.displayShortToast(this, extras.getString(IntentConstants.RAW_PAY_RESPONSE));
			} else if (resultCode == IntentConstants.TRANSACTION_SUCCESSFUL_CARD_SAVED) {
				// User finished their payment successfully and card was saved.

				// Use the static keys declared in PayResponseKeys to extract the fields you want
				// Use the static keys declared in SaveCardResponseKeys to extract the fields you want
				ToastMaker.displayShortToast(getActivity(), "Token == " + extras.getString(SaveCardResponseKeys.TOKEN));
			} else if (resultCode == IntentConstants.USER_CANCELED_3D_SECURE_VERIFICATION) {
				ToastMaker.displayShortToast(getActivity(), "User canceled 3-d scure verification!!");

				// Note that a payment process was attempted. You can extract the original returned values
				// Use the static keys declared in PayResponseKeys to extract the fields you want
				ToastMaker.displayShortToast(getActivity(), extras.getString(PayResponseKeys.PENDING));
			} else if (resultCode == IntentConstants.USER_CANCELED_3D_SECURE_VERIFICATION_PARSING_ISSUE) {
				ToastMaker.displayShortToast(getActivity(), "User canceled 3-d scure verification - Parsing Issue!!");

				// Note that a payment process was attempted.
				// User finished their payment successfully. An error occured while reading the returned JSON.
				ToastMaker.displayShortToast(getActivity(), extras.getString(IntentConstants.RAW_PAY_RESPONSE));
			}
		}
	}
}
