package com.yalladealz.userapp.ui.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.yalladealz.userapp.BuildConfig;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.Payment.ChargeItem;
import com.yalladealz.userapp.model.Payment.FawryCallback;
import com.yalladealz.userapp.model.Payment.FawryRequest;
import com.yalladealz.userapp.model.Payment.FawryResponse;
import com.yalladealz.userapp.model.Payment.FawryStatusRequest;
import com.yalladealz.userapp.model.Payment.FawryStatusResponse;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.util.ValidationUtil;
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

public class FawryFragment extends Fragment {

    private final String MERCHANT_CODE = "GgL/5qa6LYS6h4pxxCxOaw==";
    private final String MERCHANT_REF_NUMBER = "1000000720";

    private final String SECURE_KEY = "99f759e98956446bb8a19d1457636c4f";
    private final String PAYMENT_AMOUNT = "100.00";

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.bt_submit)
    Button btSubmit;
    @BindView(R.id.payment_group)
    RadioGroup paymentRadioGroup;

    private Unbinder unbinder;

    private FawryViewModel viewModel;

    private ProgressDialog progressDialog;

    private int money = 0;
    private ArrayList<CartProduct> products = new ArrayList<>();

    public FawryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fawry, container, false);
        unbinder = ButterKnife.bind(this, view);

        debug("fawryfragment");
        if (getArguments() != null) {
            debug(getArguments().toString());
            money = getArguments().getInt("money", 0);
            products = getArguments().getParcelableArrayList("products");
            debug("fawry fragment money: " + money);
            debug("fawry: " + products.toString());
        } else {
            debug("args empty");
        }

        //TODO: check - Eng. Mohamed shawky
        /*
            This fragment not work
            Ask ENG. Mohamed Shawky if we delete
         */
        viewModel = ViewModelProviders.of(this).get(FawryViewModel.class);

        String signatureString = MERCHANT_CODE +
                MERCHANT_REF_NUMBER +
                SECURE_KEY;

        String signature = "";
        try {
            signature = toHexString(getSHA(signatureString));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        debug("signature: " + signature);
        FawryStatusRequest statusRequest
                = new FawryStatusRequest(MERCHANT_CODE, MERCHANT_REF_NUMBER, signature);

        viewModel.getStatus(statusRequest).observe(getActivity(), fawryStatusResponse -> {
            debug(fawryStatusResponse.getStatusDescription());
            switch (fawryStatusResponse.getStatusCode()) {
                case 9949:
//                    btSubmit.setEnabled(false);
                    Toast.makeText(getContext(), "Item pending payment", Toast.LENGTH_SHORT).show();
                    break;
                case 200:
                    Toast.makeText(getContext(), "Item purchased successfully", Toast.LENGTH_SHORT).show();
                    btSubmit.setEnabled(true);
                    break;
                default:
                    Toast.makeText(getContext(), fawryStatusResponse.getStatusDescription(), Toast.LENGTH_SHORT).show();
                    btSubmit.setEnabled(true);
            }
        });


        if (BuildConfig.DEBUG) {
            name.setText("test name");
            email.setText("test@test.com");
            phone.setText("01145201145");
            btSubmit.setEnabled(true);
        }
        setFields();
        return view;
    }

    private void setFields() {

        LoginResponse response = SharedPrefUtil.getLoginResponse(getContext());
        if (response != null) {
            debug(response.toString());
            name.setText(String.format("%s %s", response.getUserInfo().getFirstName(), response.getUserInfo().getLastName()));
            email.setText(response.getUserInfo().getEmail());
            phone.setText(response.getUserInfo().getMobile());
        }

    }

    @OnClick(R.id.bt_submit)
    public void onViewClicked() {

        int id = paymentRadioGroup.getCheckedRadioButtonId();
        boolean payWithVisa = id == R.id.fawry_visa;
        String PAYMENT_METHOD = payWithVisa? "CARD" : "PAYATFAWRY";

        if (checkFields()) {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Get Code");
            progressDialog.setMessage("Loading");
            progressDialog.show();

            @SuppressLint("DefaultLocale")
            String totalPrice = String.format("%.2f", (float) money);

            String cardToken = "";
            if (payWithVisa) {
                // TODO: 11/09/19 get card token
            }
            // TODO: 09/09/19 send request to fawry with payment
            String signatureString = MERCHANT_CODE +
                    MERCHANT_REF_NUMBER +
                    MERCHANT_REF_NUMBER +
                    PAYMENT_METHOD +
                    totalPrice +
                    cardToken +
                    SECURE_KEY;
            String signature = "";
            try {
                signature = toHexString(getSHA(signatureString));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            List<ChargeItem> chargeItems = new ArrayList<>();
            for (CartProduct product : products) {
                chargeItems.add(new ChargeItem(String.valueOf(product.getId()),
                        product.getTitle(), product.getPrice(), product.getAmount()));
            }

            long timeNow = System.currentTimeMillis();
            long expirePeriod = 24*60*60*1000; //24h

            FawryRequest fawryRequest
                    = new FawryRequest(MERCHANT_CODE,
                    MERCHANT_REF_NUMBER,
                    MERCHANT_REF_NUMBER,
                    phone.getText().toString(),
                    email.getText().toString(),
                    PAYMENT_METHOD,
                    String.valueOf(money),
                    "EGP",
                    "description",
                    String.valueOf(timeNow + expirePeriod),
                    chargeItems,
                    cardToken,
                    signature);

            if (payWithVisa) {
                // TODO: 11/09/19 navigate to visa fragment
                progressDialog.dismiss();
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                        .navigate(R.id.action_fawryFragment_to_visaFragment);
            } else {
                viewModel.payRequest(fawryRequest).observe(getActivity(), fawryResponse -> {
                    progressDialog.dismiss();

                    if (fawryResponse.getStatusCode() != 200) {
//                        Toast.makeText(getContext(), fawryResponse.getStatusDescription(), Toast.LENGTH_SHORT).show();
                        debug("payment: " + fawryResponse.getStatusDescription());
                    } else {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

                        LayoutInflater inflater = getActivity().getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.aman_response_layout, null);
                        alert.setView(dialogView);

                        TextView codeText = dialogView.findViewById(R.id.codeText);
                        Button okBtn = dialogView.findViewById(R.id.ok);
                        codeText.setText(fawryResponse.getReferenceNumber());

                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();

                        listenToCallback(fawryResponse.getReferenceNumber());

                        btSubmit.setEnabled(false);
                        okBtn.setOnClickListener(view -> {
                            alertDialog.dismiss();
                            Bundle bundle = new Bundle();
                            bundle.putString("action", "finished");
                            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                                    .navigate(R.id.action_fawryFragment_to_cartFragment, bundle);
                        });
                    }
                });
            }
        }
    }

    private void listenToCallback(String referenceNumber) {
        @SuppressLint("DefaultLocale") String totalPrice = String.format("%.2f", (float) money);
        String message
                = referenceNumber
                + MERCHANT_REF_NUMBER
                + "NEW"
                + totalPrice
                + SECURE_KEY;
        String messageSignature = "";
        try {
            messageSignature = toHexString(getSHA(message));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        FawryCallback fawryCallback
                = new FawryCallback(referenceNumber,
                MERCHANT_REF_NUMBER,
                "NEW", money, messageSignature);

        viewModel.getCallback(fawryCallback)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        // TODO: 11/09/19 implement
                    }
                });
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
