package com.yalladealz.userapp.ui.fragments.ProfilePageFragments;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.util.CommonMethod;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.viewModels.GetAddressViewModel;
import com.yalladealz.userapp.viewModels.UserUpdateViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

@SuppressWarnings("ConstantConditions")
public class EditeDetailsFragment extends Fragment {

    @BindView(R.id.update_fname)
    EditText updateFname;
    @BindView(R.id.update_lname)
    EditText updateLname;
    @BindView(R.id.update_gender_spinner)
    Spinner updateGenderSpinner;
    @BindView(R.id.textDateUpdate)
    TextView textDateUpdate;
    @BindView(R.id.bt_update)
    Button btUpdate;
    @BindView(R.id.update_profile_ly)
    LinearLayout updateProfileLy;
    @BindView(R.id.mobile)
    EditText updateMobile;

    private UserUpdateViewModel UpdateModel;

    private LoginResponse loginResponse;

    private long id;
    private String hash;
    @BindView(R.id.city_spinner)
    Spinner citySpinner;
    @BindView(R.id.subCity_spinner)
    Spinner subCitySpinner;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.setAddress)
    LinearLayout setAddress;
    @BindView(R.id.building)
    EditText building;
    @BindView(R.id.apartment)
    EditText apartment;
    @BindView(R.id.bt_updateAddress)
    Button btUpdateAddress;

    private GetAddressViewModel addressModel;
    private String cityName = null;
    private List<String> cityList = new ArrayList<>();
    private List<String> subCityList = new ArrayList<>();

    private DatePickerDialog.OnDateSetListener listener;
    private Unbinder unbinder;


    public EditeDetailsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_edite_details, container, false);
        unbinder = ButterKnife.bind(this, v);

        addressModel = ViewModelProviders.of(this).get(GetAddressViewModel.class);
        datePicker();
        PickAddress();
        LoadTheData();

        return v;
    }


    private void LoadTheData() {
        UpdateModel = ViewModelProviders.of(this).get(UserUpdateViewModel.class);
        if (SharedPrefUtil.hasKey(getContext(), "ID") || SharedPrefUtil.hasKey(getContext(), "HASH")) {
            id = Long.parseLong(SharedPrefUtil.getData(getContext(), "ID", 0L).toString());
            hash = String.valueOf(SharedPrefUtil.getData(getContext(), "HASH", " "));

            // TODO complete set data 3/16/2020

           /* UpdateModel.UpdateUser(new UserInfo(id, hash, null, null, null, null, null));*/

            UpdateModel.GetData().observe(this, loginRespons -> {
                loginResponse = loginRespons;

                if (loginResponse != null) {
                    updateFname.setText(loginResponse.getUserInfo().getFirstName());
                    updateLname.setText(loginResponse.getUserInfo().getLastName());
                    textDateUpdate.setText(loginResponse.getUserInfo().getDateOfBirth());
                    updateMobile.setText(loginResponse.getUserInfo().getMobile());

                    if (loginRespons.getUserInfo().getGender().equals("Female")) {
                        updateGenderSpinner.setSelection(1);
                    }
                }
            });

        } else {
            Toast.makeText(getContext(), "no id", Toast.LENGTH_SHORT).show();

        }
    }

    private void PickAddress() {
        cityList = CommonMethod.readJsonFile(getContext());
        cityList.add(0, "Select city");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, cityList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(dataAdapter);
        cityName = cityList.get(0);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityName = cityList.get(position);

                // Set subCities in spinner
                subCityList = CommonMethod.getSupCities(getContext(), cityName);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, subCityList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                subCitySpinner.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        subCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.bt_update)
    public void onViewClicked() {



        Toast.makeText(getContext(), "Updated successfully ...", Toast.LENGTH_SHORT).show();
/*   UpdateModel.UpdateUser(new UserInfo(id, hash, updateMobile.getText().toString(), textDateUpdate.getText().toString(), updateFname.getText().toString(),
                updateGenderSpinner.getSelectedItem().toString(), updateLname.getText().toString()));*/
    }

    @OnClick(R.id.textDateUpdate)
    void onViewClickedDate() {

        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog date = new DatePickerDialog(getContext(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                listener, y, m, d);
        date.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        date.setCancelable(true);
        date.show();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(30, 0, 30, 0);

        date.getButton(DatePickerDialog.BUTTON_POSITIVE).setLayoutParams(params);
        date.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE);
    }

    private void datePicker() {

        listener = (view, year, month, dayOfMonth) -> {

            int m = month+1;
            String date = dayOfMonth + "/" + m + "/" + year;
            if (year > 2015 || year < 1920) {
                CommonMethod.showToast("Pick a Valid date", getContext());
                return;
            }
            textDateUpdate.setText(date);
        };
    }


    @OnClick(R.id.bt_updateAddress)
    void onViewClickedAddress() {

        String country = "Egypt";
        String state = citySpinner.getSelectedItem().toString();
        String city = subCitySpinner.getSelectedItem().toString();
        String ad = address.getText().toString();
        String bu = building.getText().toString();
        String ap = apartment.getText().toString();

        Address address = new Address(id, country, state, city, ad, bu, ap);

        addressModel.addAddress(address).observe(this, checkAddAddress -> {
            if (checkAddAddress.getError() == 0) {
                Toast.makeText(getContext(), "Added Successfully...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Error accrued, try again...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.add_address_tv)
    void onAddAddressTextViewClicked() {
        if (setAddress.getVisibility() == View.GONE) {
            setAddress.setVisibility(View.VISIBLE);
            setAddress.animate().alpha(100)
                    .setDuration(200).start();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
