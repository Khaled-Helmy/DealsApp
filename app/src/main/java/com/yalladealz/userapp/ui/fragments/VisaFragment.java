package com.yalladealz.userapp.ui.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;
import com.yalladealz.userapp.BuildConfig;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.Payment.ChargeItem;
import com.yalladealz.userapp.model.Payment.FawryRequest;
import com.yalladealz.userapp.model.Payment.FawryResponse;
import com.yalladealz.userapp.model.Payment.VisaRequest;
import com.yalladealz.userapp.model.Payment.VisaResponse;
import com.yalladealz.userapp.viewModels.FawryViewModel;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.LogUtil.debug;

public class VisaFragment extends Fragment {

	private final String MERCHANT_CODE = "GgL/5qa6LYS6h4pxxCxOaw=="; //1tSa6uxz2nQeR/6BqV3rrg==
	private final String MERCHANT_REF_NUMBER = "1000000720";
	private final String PROFILE_REF = "7uyA76gf2";
	private final String SECURE_KEY = "99f759e98956446bb8a19d1457636c4f";

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

	private Unbinder unbinder;

	FawryViewModel viewModel;
	ProgressDialog progressDialog;

	private int money = 0;
	private ArrayList<CartProduct> products = new ArrayList<>();

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_visa, container, false);

		unbinder = ButterKnife.bind(this, view);

		viewModel = ViewModelProviders.of(this).get(FawryViewModel.class);

		if (getArguments() != null) {
			debug(getArguments().toString());
			money = getArguments().getInt("money", 0);
			products = getArguments().getParcelableArrayList("products");
			debug("fawry fragment money: " + money);
			debug("fawry: " + products.toString());
		} else {
			debug("args empty");
		}

		if (BuildConfig.DEBUG) {
			nameEt.setText("ahmed galal");
			cardNumberEt.setText("5123456789012346");
			expireEt.setText("05/21");
			cvvEt.setText("123");
			phoneEt.setText("01000000000");
			emailEt.setText("test@test.com");
		}
		return view;
	}

	@OnClick(R.id.continueBtn)
	public void setContinueBtn(){
		progressDialog = new ProgressDialog(getContext());
		progressDialog.setCancelable(false);
		progressDialog.setTitle("Loading...");
		progressDialog.setMessage("Getting token");
		progressDialog.show();

		if (checkInput()) {
			String phone = phoneEt.getEditableText().toString();
			String email = emailEt.getEditableText().toString();

			VisaRequest visaRequest
					= new VisaRequest
					(MERCHANT_CODE,
					MERCHANT_REF_NUMBER,
					phone,
					email,
					cardNumberEt.getEditableText().toString(),
					expireEt.getEditableText().toString().substring(3),
					expireEt.getEditableText().toString().substring(0, 2),
					cvvEt.getEditableText().toString());

			viewModel.getVisaToken(visaRequest)
					.observe(this, new Observer<VisaResponse>() {
						@Override
						public void onChanged(VisaResponse visaResponse) {
							progressDialog.setMessage("Paying with Visa");

							String token = visaResponse.getCard().getToken();
							List<ChargeItem> chargeItems = new ArrayList<>();
							for (CartProduct product : products) {
								chargeItems.add(new ChargeItem(String.valueOf(product.getId()),
										product.getTitle(), product.getPrice(), product.getAmount()));
							}
							if (BuildConfig.DEBUG) {
								chargeItems.add(new ChargeItem("15.20", "description", "100", 1));
							}

							final String AMOUNT = "20";
							String signatureString =
									MERCHANT_CODE +
									MERCHANT_REF_NUMBER +
									MERCHANT_REF_NUMBER +
									"CARD" +
									AMOUNT + ".00" +
									token +
									SECURE_KEY;

							debug("signatureString: " + signatureString);
							String signature = "";
							try {
								signature = bin2hex(getSHA(signatureString));
							} catch (NoSuchAlgorithmException e) {
								e.printStackTrace();
							}

							debug("signature11: " + signature);
							long timeNow = System.currentTimeMillis();
							long expire = 24*60*60*1000;

							FawryRequest fawryRequest
									= new FawryRequest(
											MERCHANT_CODE,
									MERCHANT_REF_NUMBER,
									MERCHANT_REF_NUMBER,
									phone,
									email,
									"CARD",
									AMOUNT,
									"EGP",
									"description",
									"",
									chargeItems,
									token,
									signature
							);

							viewModel.payRequest(fawryRequest)
								.observe(VisaFragment.this, new Observer<FawryResponse>() {
								@Override
								public void onChanged(FawryResponse fawryResponse) {
									progressDialog.dismiss();

									if (fawryResponse.getStatusCode() != 200) {
										Toast.makeText(getContext(), fawryResponse.getStatusDescription(), Toast.LENGTH_SHORT).show();
									} else {
										new AlertDialog.Builder(getContext())
												.setPositiveButton("OK", new DialogInterface.OnClickListener() {
													@Override
													public void onClick(DialogInterface dialogInterface, int i) {
														Bundle bundle = new Bundle();
														bundle.putString("action", "finished");
														Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
																.navigate(R.id.action_visaFragment_to_cartFragment, bundle);
													}
												})
												.setMessage("Payment Successful")
												.setCancelable(false)
												.create().show();
									}
								}
							});
						}
					});
		}
	}

	private byte[] getSHA(String input) throws NoSuchAlgorithmException
	{
		// Static getInstance method is called with hashing SHA
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		// digest() method called
		// to calculate message digest of an input
		// and return array of byte
		return md.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	private String toHexString(byte[] hash)
	{
		// Convert byte array into signum representation
		BigInteger number = new BigInteger(1, hash);

		// Convert message digest into hex value
		StringBuilder hexString = new StringBuilder(number.toString(16));

		// Pad with leading zeros
		while (hexString.length() < 32)
		{
			hexString.insert(0, '0');
		}

		return hexString.toString();
	}

	private String bin2hex(byte[] data) {
		StringBuilder hex = new StringBuilder(data.length * 2);
		for (byte b : data)
			hex.append(String.format("%02x", b & 0xFF));
		return hex.toString();
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

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}
