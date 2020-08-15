package com.yalladealz.userapp.ui.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yalladealz.userapp.BuildConfig;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.Payment.PaymentShippingData;
import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.util.CommonMethod;
import com.yalladealz.userapp.viewModels.CashCollectionViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.ID;
import static com.yalladealz.userapp.util.LogUtil.debug;
import static com.yalladealz.userapp.util.SharedPrefUtil.getData;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressWarnings("ConstantConditions")
public class CashCollectionFragment extends Fragment {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.addresses)
    Spinner userAddressesSpinner;
    @BindView(R.id.countrySpinner)
    Spinner countrySpinner;
    @BindView(R.id.stateSpinner)
    Spinner stateSpinner;
    @BindView(R.id.citySpinner)
    Spinner citySpinner;
    @BindView(R.id.streetET)
    EditText streetET;
    @BindView(R.id.buildingET)
    EditText buildingET;
    @BindView(R.id.floorET)
    EditText floorET;
    @BindView(R.id.apartmentET)
    EditText apartmentET;
    @BindView(R.id.postalCodeEt)
    EditText postalCodeEt;
    @BindView(R.id.bt_submit)
    AppCompatButton btSubmit;
    @BindView(R.id.cashCollectionFrameLayout)
    FrameLayout cashCollectionFrameLayout;
    @BindView(R.id.otherAddress)
    CardView otherAddress;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.countryET)
    EditText countryET;
    @BindView(R.id.stateET)
    EditText stateET;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.cityEt)
    EditText cityEt;
    @BindView(R.id.linear3)
    LinearLayout linear3;

    private String cityName = null, stateName = null, addressNumber = null, countryName = null;
    private int cityIndex = 0;
    private int stateInd = 0;
    private int addressNumberInd = 0;
    private int countryInd = 0;
    private int money;
    private List<String> cityList = new ArrayList<>();
    private List<String> stateList = new ArrayList<>();
    private List<Address> userAddresses = new ArrayList<>();
    private List<String> countryList = new ArrayList<>();
    private ArrayList<CartProduct> products = new ArrayList<>();
    private CashCollectionViewModel viewModel;
    private List<String> userAddressesNumbers = new ArrayList<>();
    private Boolean getAddressAppear = true;
    //private LoginResponse.UserInfo currentUser;
    private Unbinder unbinder;
    private ProgressDialog progressDialog;
    private static final String API_KEY = "ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6VXhNaUo5LmV5SnVZVzFsSWpvaU1UVTJOVEUzT0RneE1DNDNPRFEzTURraUxDSmpiR0Z6Y3lJNklrMWxjbU5vWVc1MElpd2ljSEp2Wm1sc1pWOXdheUk2TVRZME5YMC5wdkRlQW05a05kbjhidndRY1RCdDRQeERON1RFWFBMMkQzN3YzaDNpZjBZOWNPUUtoZG16VGNTcHBYRi1QSnNUdlB2U0c3ZWdRbE9sYU12RC1OYUVYUQ==";

    public CashCollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cash_collection, container, false);
        unbinder = ButterKnife.bind(this, view);

        viewModel = ViewModelProviders.of(getActivity()).get(CashCollectionViewModel.class);
        //currentUser = SharedPrefUtil.getLoginResponse(getContext()).getUserInfo();

        Bundle bundle = getArguments().getBundle("bundle");

        try {
            products = getArguments().getParcelableArrayList("products");
            money = getArguments().getInt("money", 0)*100;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        money = 10;

        setFields();

        userAddressesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addressNumber = userAddressesNumbers.get(position);
                addressNumberInd = position;

                if (addressNumberInd == 0) {
                    otherAddress.setVisibility(View.GONE);
                } else if (addressNumberInd != userAddressesNumbers.size() - 1) {
                    getFields();
                    otherAddress.setVisibility(View.VISIBLE);
                } else {
                    newAddress();
                    otherAddress.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryName = countryList.get(position);
                countryInd = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stateName = stateList.get(position);
                stateInd = position;

                if (stateInd != 0) {

                    cityList = CommonMethod.getSupCities(getContext(), stateName);
                    cityList.add(0, "Select city");
                    ArrayAdapter<String> stateDataAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, cityList);
                    stateDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    citySpinner.setAdapter(stateDataAdapter);


                    cityEt.setVisibility(View.GONE);
                    citySpinner.setVisibility(View.VISIBLE);
                    streetET.setText("");
                    buildingET.setText("");
                    floorET.setText("");
                    apartmentET.setText("");
                    postalCodeEt.setText("");

                    linear1.setVisibility(View.VISIBLE);

                } else {
                    linear1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityName = cityList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    private void newAddress() {

        linear2.setVisibility(View.GONE);

        countryList.add("Select country");
        countryList.add("Egypt");
        ArrayAdapter<String> countryDataAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, countryList);
        countryDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryDataAdapter);
        countryName = countryList.get(0);

        stateList = CommonMethod.readJsonFile(getContext());
        stateList.add(0, "Select state");
        ArrayAdapter<String> stateDataAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, stateList);
        stateDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateDataAdapter);
        stateName = stateList.get(0);
        cityEt.setVisibility(View.GONE);
        linear3.setVisibility(View.VISIBLE);

        streetET.setText("");
        buildingET.setText("");
        floorET.setText("");
        apartmentET.setText("");
        postalCodeEt.setText("");
    }

    private void getFields() {

        Address address = userAddresses.get(addressNumberInd - 1);

        countryET.setText(address.getCountry());
        countryET.setClickable(false);
        countryET.setFocusable(false);
        stateET.setText(address.getState());
        stateET.setClickable(false);
        stateET.setFocusable(false);
        citySpinner.setVisibility(View.GONE);
        cityEt.setText(address.getCity());
        cityEt.setClickable(false);
        cityEt.setFocusable(false);
        buildingET.setText(address.getBuilding());
        buildingET.setClickable(false);
        buildingET.setFocusable(false);
        apartmentET.setText(address.getApartment());
        apartmentET.setClickable(false);
        apartmentET.setFocusable(false);
        streetET.setText("");
        postalCodeEt.setText("");
        floorET.setText("");
        citySpinner.setVisibility(View.GONE);
        linear3.setVisibility(View.GONE);
        linear2.setVisibility(View.VISIBLE);
        linear1.setVisibility(View.VISIBLE);
        cityEt.setVisibility(View.VISIBLE);
    }


    private void setFields() {

        //name.setText(String.format("%s %s", currentUser.getFirstName(), currentUser.getLastName()));
        name.setText("George Samuel");
        name.setClickable(false);
        //email.setText(currentUser.getEmail());
        email.setText("asd@asd.com");
        email.setClickable(false);
        //phone.setText(currentUser.getMobile());
        phone.setText("01211075441");
        phone.setClickable(false);



        try {
            viewModel.getUserAddresses(String.valueOf(getData(getContext(),
                    "ID", 0L)),
                    String.valueOf(getData(getContext(), "HASH", "")))
                    .observe(this, addresses -> {

                        userAddresses = addresses;

                        String address;
                        userAddressesNumbers.add("Choose address");

                        for (int ind = 0; ind < addresses.size(); ind++) {
                            userAddressesNumbers.add("Address " + (ind + 1));
                        }

                        userAddressesNumbers.add("Other");

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, userAddressesNumbers);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        userAddressesSpinner.setAdapter(adapter);

                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @OnClick(R.id.bt_submit)
    public void onViewClicked() {

        if (checkFields()) {

            progressDialog = new ProgressDialog(getContext());
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Pay with cash collection");
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

    private void registerOrder(String token, String merchant_id, String merchant_order_id) {

        JsonObject order = new JsonObject();
        order.addProperty("auth_token", token);
        order.addProperty("delivery_needed", String.valueOf(true));
        order.addProperty("merchant_id", String.valueOf(merchant_id));
        order.addProperty("amount_cents", String.valueOf(money));
        order.addProperty("currency", "EGP");
        order.addProperty("merchant_order_id", merchant_order_id);
        JsonArray array = new JsonArray();
        for (CartProduct product : products) {
            JsonObject object = new JsonObject();
            object.addProperty("name", product.getTitle());
            object.addProperty("amount_cents", product.getPrice());
            object.addProperty("quantity", product.getAmount());
            array.add(object);
            order.add("items", array);
        }

        String apartment = apartmentET.getEditableText().toString().trim();
        String building = buildingET.getEditableText().toString().trim();
        String city, state;
        if (addressNumberInd == userAddressesNumbers.size() - 1) {
            city = cityName;
            state = stateName;
        } else {
            city = cityEt.getEditableText().toString().trim();
            state = stateET.getEditableText().toString().trim();
        }
        String e_mail = email.getEditableText().toString().trim();
        String _name = name.getEditableText().toString().trim();
        int spaceInd = searchIndex(_name);
        String firstName, lastName;
        if (spaceInd != -1) {
            firstName = _name.substring(0, spaceInd);
            lastName = _name.substring(spaceInd + 1, _name.length());
        } else {
            firstName = _name;
            lastName = _name;
        }
        String floor = floorET.getEditableText().toString().trim();
        String phoneNum = phone.getEditableText().toString().trim();
        String postalCode = postalCodeEt.getEditableText().toString().trim();

        String street = streetET.getEditableText().toString().trim();

        JsonObject shippingData = new JsonObject();
        shippingData.addProperty("apartment", apartment);
        shippingData.addProperty("building", building);
        shippingData.addProperty("city", city);
        shippingData.addProperty("country", "EG");
        shippingData.addProperty("email", e_mail);
        shippingData.addProperty("first_name", firstName);
        shippingData.addProperty("floor", floor);
        shippingData.addProperty("last_name", lastName);
        shippingData.addProperty("phone_number", phoneNum);
        shippingData.addProperty("postal_code", postalCode);
        shippingData.addProperty("state", state);
        shippingData.addProperty("street", street);

        order.add("shipping_data", shippingData);

        viewModel.registerOrder(order).observe(this, orderResponse -> getPaymentKey(token, orderResponse.getId(), orderResponse.getShippingData()));
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
        details.addProperty("integration_id", 4900);
        details.addProperty("lock_order_when_paid", false);
        details.addProperty("order_id", String.valueOf(order_id));


        viewModel.getPaymentKey(details).observe(this, s -> {

            final String PAYMENT_KEY = s;

            debug("PAYMENT_KEY: " + PAYMENT_KEY);

            JsonObject pay = new JsonObject();

            JsonObject source = new JsonObject();
            source.addProperty("identifier", "cash");
            source.addProperty("subtype", "CASH");

            pay.add("source", source);
            pay.addProperty("payment_token", PAYMENT_KEY);

            viewModel.payRequest(pay).observe(getActivity(), cashCollectionResponse -> {

                progressDialog.dismiss();

                if (cashCollectionResponse != null) {
//                    Log.d("CashCollectionFragment", "patRequest: onChanged: pending: " + cashCollectionResponse.getPending());
                    if (cashCollectionResponse.getPending().equals("true")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("action", "finished");
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                                .navigate(R.id.action_cashFragment_to_cartFragment, bundle);
                    }
                }

            });


        });
    }

    private int searchIndex(String str) {
        int ind = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ind = i;
                break;
            }
        }
        return ind;
    }

    private boolean checkFields() {
        boolean check = false;

        String street = streetET.getEditableText().toString().trim();
        String buildNumber = buildingET.getEditableText().toString().trim();
        String floor = floorET.getEditableText().toString().trim();
        String apartment = apartmentET.getEditableText().toString().trim();
        String postalCode = postalCodeEt.getEditableText().toString().trim();

        if (addressNumberInd == 0) {
            Snackbar.make(getView(), "Choose address", Snackbar.LENGTH_SHORT).show();
        } else {
            if (street.equals("")) {
                streetET.setError("Write your street name");
            } else if (buildNumber.equals("")) {
                buildingET.setError("Write your building number");
            } else if (floor.equals("")) {
                floorET.setError("Write your apartment's floor");
            } else if (apartment.equals("")) {
                apartmentET.setError("Write your apartment floor");
            } else if (postalCode.equals("")) {
                postalCodeEt.setError("Write postal code of your city");
            } else {
                check = true;
            }
        }

        return check;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}