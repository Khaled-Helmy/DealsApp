package com.yalladealz.userapp.ui.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.Payment.PaymentShippingData;
import com.yalladealz.userapp.util.ValidationUtil;
import com.yalladealz.userapp.viewModels.AmanViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class AmanFragment extends Fragment {

    //TODO Firebase notification

    /*
        In this fragment backend must push notification from server
        Receive this notification in App

       you should show the response form server to user to know if the process done or not

     */

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.bt_submit)
    Button btSubmit;

    private ProgressDialog progressDialog;

    private static final String API_KEY = "ZXlKaGJHY2lPaUpJVXpVeE1pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SmpiR0Z6Y3lJNklrMWxjbU5vWVc1MElpd2libUZ0WlNJNkltbHVhWFJwWVd3aUxDSndjbTltYVd4bFgzQnJJam94TmpRMWZRLjVLckh1dUh2eWdKcnJJQWJBbG9hUDFjZXhQU3JMMDduNkZrRGUyRk41S1Vfa0tjdUV5bnYweGdCUExaOC1aUXJxSUFrMjFlRGRRalNyWEVwVXNHUkxR";
    private int money;
    private AmanViewModel viewModel;
    private Unbinder unbinder;

    public AmanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fawry, container, false);
        unbinder = ButterKnife.bind(this, view);

        /*
            Just for test :)
            delete the static variable and delete //  line when application go live
         */

        money = getArguments().getInt("money", 0);
//        money = 10;
        viewModel = ViewModelProviders.of(this).get(AmanViewModel.class);
        return view;
    }

    private void registerOrder(String token, String merchant_id, String merchant_order_id) {

        JsonObject order = new JsonObject();
        order.addProperty("auth_token", token);
        order.addProperty("delivery_needed", String.valueOf(false));
        order.addProperty("merchant_id", String.valueOf(merchant_id));
        order.addProperty("amount_cents", String.valueOf(money));
        order.addProperty("currency", "EGP");
        order.addProperty("merchant_order_id", merchant_order_id);
        order.add("items", null);


        JsonObject shippingData = new JsonObject();
        shippingData.addProperty("apartment", "803");
        shippingData.addProperty("building", "8028");
        shippingData.addProperty("city", "Jaskolskiburgh");
        shippingData.addProperty("country", "CR");
        shippingData.addProperty("email", "claudette09@exa.com");
        shippingData.addProperty("first_name", "Clifford");
        shippingData.addProperty("floor", "42");
        shippingData.addProperty("last_name", "Nicolas");
        shippingData.addProperty("phone_number", "+86(8)9135210487");
        shippingData.addProperty("postal_code", "01898");
        shippingData.addProperty("state", "Utah");
        shippingData.addProperty("street", "Ethan Land");

        order.add("shipping_data",shippingData);

        viewModel.registerOrder(order).observe(this, orderResponse -> getPaymentKey(token, orderResponse.getId(), orderResponse.getShippingData()));
    }

    private void getPaymentKey(String token, int order_id, PaymentShippingData shippingData) {

        JsonObject details = new JsonObject();
        details.addProperty("amount_cents", String.valueOf(money));
        details.addProperty("auth_token", token);

        JsonObject data = new JsonObject();
        data.addProperty("apartment", shippingData.getApartment());
        data.addProperty("building", shippingData.getBuilding());
        data.addProperty("city",shippingData.getCity());
        data.addProperty("country",shippingData.getCountry());
        data.addProperty("email",shippingData.getEmail());
        data.addProperty("first_name",shippingData.getFirstName());
        data.addProperty("floor",shippingData.getFloor());
        data.addProperty("last_name",shippingData.getLastName());
        data.addProperty("phone_number",shippingData.getPhoneNumber());
        data.addProperty("postal_code",shippingData.getPostalCode());
        data.addProperty("shipping_method",shippingData.getShipping_method());
        data.addProperty("state",shippingData.getState());
        data.addProperty("street",shippingData.getStreet());

        details.add("billing_data", data);
        details.addProperty("currency", "EGP");
        details.addProperty("expiration",3600);

        //TODO: change - integration_id
         /*
            This number only for test integration_id
            When application go live must change this number
            Ask ENG. Mohamed Shawky for the live number

         */

        details.addProperty("integration_id", 4902);
        details.addProperty("lock_order_when_paid", false);
        details.addProperty("order_id", String.valueOf(order_id));


        viewModel.getPaymentKey(details).observe(this, s -> {

            final String PAYMENT_KEY = s;



            JsonObject pay = new JsonObject();

            JsonObject source = new JsonObject();
            source.addProperty("identifier", "AGGREGATOR");
            source.addProperty("subtype", "AGGREGATOR");

            pay.add("source", source);
            pay.addProperty("payment_token", PAYMENT_KEY);

            viewModel.payRequest(pay).observe(getActivity(), amanResponse -> {

                progressDialog.dismiss();

                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.aman_response_layout, null);
                alert.setView(dialogView);

                TextView codeText = dialogView.findViewById(R.id.codeText);
                Button okBtn = dialogView.findViewById(R.id.ok);
                codeText.setText(String.valueOf(amanResponse.getData().getBillReference()));


                AlertDialog alertDialog = alert.create();
                alertDialog.show();

                okBtn.setOnClickListener(view -> alertDialog.dismiss());

            });


        });
    }

    @OnClick(R.id.bt_submit)
    public void onViewClicked() {

        if (checkFields()) {

            progressDialog = new ProgressDialog(getContext());
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Get Code");
            progressDialog.setMessage("Loading");
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

    private boolean checkFields() {
        boolean check = false;

        String nameText = name.getEditableText().toString().trim();
        String emailText = email.getEditableText().toString().trim();
        String phoneText = phone.getEditableText().toString().trim();

        if (nameText.equals("")) {
            name.setError("Enter your name");
        } else if (email.toString().equals("")) {
            email.setError("Enter your email");
        } else if (ValidationUtil.validEmail(emailText)) {
            email.setError("Enter valid email");
        } else if (phoneText.equals("")) {
            phone.setError("Enter phone number");
        } else if (phone.getEditableText().length() != 11) {
            phone.setError("Enter valid number");
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
