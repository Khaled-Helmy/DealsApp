package com.yalladealz.userapp.ui.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.BuildConfig;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.Payment.OrderResponse;
import com.yalladealz.userapp.model.Payment.PaymentShippingData;
import com.yalladealz.userapp.model.Payment.WalletResponse;
import com.yalladealz.userapp.util.ValidationUtil;
import com.yalladealz.userapp.viewModels.WalletViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.LogUtil.debug;

public class SmartWalletFragment extends Fragment {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.bt_submit)
    Button btSubmit;
    @BindView(R.id.payment_group)
    RadioGroup paymentGroup;
    private ProgressDialog progressDialog;

    private static final String API_KEY = "ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6VXhNaUo5LmV5SnVZVzFsSWpvaU1UVTJOVEUzT0RneE1DNDNPRFEzTURraUxDSmpiR0Z6Y3lJNklrMWxjbU5vWVc1MElpd2ljSEp2Wm1sc1pWOXdheUk2TVRZME5YMC5wdkRlQW05a05kbjhidndRY1RCdDRQeERON1RFWFBMMkQzN3YzaDNpZjBZOWNPUUtoZG16VGNTcHBYRi1QSnNUdlB2U0c3ZWdRbE9sYU12RC1OYUVYUQ==";
    private int money;
    private ArrayList<CartProduct> products = new ArrayList<>();
    private WalletViewModel viewModel;
    private Unbinder unbinder;

    public SmartWalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fawry, container, false);
        unbinder = ButterKnife.bind(this, view);

        paymentGroup.setVisibility(View.GONE);
        /*
            Just for test :)
            delete the static variable and delete //  line when application go live
         */

        if (BuildConfig.DEBUG) {
            name.setText("ahmed galal");
            email.setText("test@test.com");
            phone.setText("01148029979");
        }
        if (getArguments() != null) {
            money = getArguments().getInt("money", 0)*100;
            products = getArguments().getParcelableArrayList("products");
        }
//        money = 10;
        viewModel = ViewModelProviders.of(getActivity()).get(WalletViewModel.class);

        return view;
    }

    @OnClick(R.id.bt_submit)
    public void onViewClicked() {

        if (checkFields()) {

            progressDialog = new ProgressDialog(getContext());
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Getting Code");
            progressDialog.setMessage("Loading...");
            progressDialog.show();

            JsonObject key = new JsonObject();
            key.addProperty("api_key", API_KEY);
            viewModel.getToken(key).observe(this, response -> {
                if (response != null) {
                    registerOrder(response.getToken(), String.valueOf(response.getProfile().getId()), String.valueOf(System.currentTimeMillis()));
                }
            });


        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void registerOrder(String token, String merchant_id, String merchant_order_id) {

        JsonObject order = new JsonObject();
        order.addProperty("auth_token", token);
        order.addProperty("delivery_needed", String.valueOf(false));
        order.addProperty("merchant_id", String.valueOf(merchant_id));
        order.addProperty("amount_cents", String.valueOf(money));
        order.addProperty("currency", "EGP");
        order.addProperty("merchant_order_id", merchant_order_id);
//FIXME        order.add("items", products);


        JsonObject shippingData = new JsonObject();
        shippingData.addProperty("apartment", "803");
        shippingData.addProperty("building", "8028");
        shippingData.addProperty("city", "Jaskolskiburgh");
        shippingData.addProperty("country", "CR");
        shippingData.addProperty("email", "claudette09@exa.com");
        shippingData.addProperty("first_name", "Clifford");
        shippingData.addProperty("floor", "42");
        shippingData.addProperty("last_name", "Nicolas");
        shippingData.addProperty("phone_number", phone.getText().toString());
        shippingData.addProperty("postal_code", "01898");
        shippingData.addProperty("state", "Utah");
        shippingData.addProperty("street", "Ethan Land");

        order.add("shipping_data", shippingData);

        viewModel.registerOrder(order).observe(this, new Observer<OrderResponse>() {
            @Override
            public void onChanged(OrderResponse orderResponse) {
                getPaymentKey(token, orderResponse.getId(), orderResponse.getShippingData());
            }
        });
    }

    private void getPaymentKey(String token, int order_id, PaymentShippingData shippingData) {

        JsonObject details = new JsonObject();
        details.addProperty("amount_cents", String.valueOf(money));
        details.addProperty("auth_token", token);

        JsonObject data = new JsonObject();
        data.addProperty("apartment", shippingData.getApartment());
        data.addProperty("building", shippingData.getBuilding());
        data.addProperty("city", shippingData.getCity());
        data.addProperty("country", shippingData.getCountry());
        data.addProperty("email", shippingData.getEmail());
        data.addProperty("first_name", shippingData.getFirstName());
        data.addProperty("floor", shippingData.getFloor());
        data.addProperty("last_name", shippingData.getLastName());
        data.addProperty("phone_number", shippingData.getPhoneNumber());
        data.addProperty("postal_code", shippingData.getPostalCode());
        data.addProperty("shipping_method", shippingData.getShipping_method());
        data.addProperty("state", shippingData.getState());
        data.addProperty("street", shippingData.getStreet());

        details.add("billing_data", data);
        details.addProperty("currency", "EGP");
        details.addProperty("expiration", 3600);

        /*
            This number only for test integration_id
            When application go live must change this number
            Ask ENG. Mohamed Shawky for the live number

         */

        details.addProperty("integration_id", 4901);
        details.addProperty("lock_order_when_paid", false);
        details.addProperty("order_id", String.valueOf(order_id));


        viewModel.getPaymentKey(details).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                final String PAYMENT_KEY = s;

                JsonObject pay = new JsonObject();

                JsonObject source = new JsonObject();
                source.addProperty("identifier", phone.getEditableText().toString().trim());
                source.addProperty("subtype", "WALLET");

                pay.add("source", source);
                pay.addProperty("payment_token", PAYMENT_KEY);

                viewModel.payRequest(pay).observe(getActivity(), new Observer<WalletResponse>() {
                    @Override
                    public void onChanged(WalletResponse walletResponse) {
                        progressDialog.dismiss();
                        String amount = String.valueOf(walletResponse.getAmountCents()/100);
                        String merchantId = String.valueOf(walletResponse.getOrder().getMerchant().getId());
                        debug("pending: " + walletResponse.getPending());
                        debug("success: " + walletResponse.getSuccess());
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(walletResponse.getRedirectUrl()));
                        Bundle bundle = new Bundle();
                        bundle.putString("action", "finished");
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                                .navigate(R.id.action_smartWalletFragment_to_cartFragment, bundle);
                        startActivity(intent);
//                        debug("redirect: " + walletResponse.getRedirectUrl());
                    }
                });

            }
        });

    }

    private boolean checkFields() {
        boolean check = false;

        String nameText = name.getEditableText().toString().trim();
        String emailText = email.getEditableText().toString().trim();
        String phoneText = phone.getEditableText().toString().trim();

        if (nameText.equals("")) {
            name.setError("Enter your name");
        } else if (emailText.equals("")) {
            email.setError("Enter your email");
        } else if (ValidationUtil.validEmail(emailText)) {
            email.setError("Enter valid email");
        } else if (phoneText.equals("")) {
            phone.setError("Enter phone number");
        } else if (phoneText.length() != 11) {
            phone.setError("Enter valid number");
        } else {
            check = true;
        }
        return check;
    }
}
