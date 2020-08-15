package com.yalladealz.userapp.ui.fragments.ProfilePageFragments;

import android.app.AlertDialog;
import android.graphics.Color;
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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.UserAddressAdapter;
import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.util.CommonMethod;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.viewModels.GetAddressViewModel;
import com.yalladealz.userapp.viewModels.UserUpdateViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressWarnings("ConstantConditions")
public class DetailsFragment extends Fragment {


    @BindView(R.id.txtPhone)
    TextView txtPhone;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtGender)
    TextView txtGender;
    @BindView(R.id.txtBirth)
    TextView txtBirth;
    @BindView(R.id.fab_edit)
    FloatingActionButton fabEdit;
    private long id;
    private String hash;
    private List<Address> addressList;
    private String cityName = null;
    private List<String> cityList = new ArrayList<>();
    private List<String> subCityList = new ArrayList<>();

    private Spinner citySpinner;
    private Spinner subCitySpinner;

    private GetAddressViewModel addressModel;
    @BindView(R.id.recyclerAddress)
    RecyclerView recyclerAddress;
    private UserAddressAdapter adapter;
    private Unbinder unbinder;

    public DetailsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        recyclerAddress.setHasFixedSize(true);
        recyclerAddress.setLayoutManager(new LinearLayoutManager(getContext()));
        UserUpdateViewModel updateModel = ViewModelProviders.of(this).get(UserUpdateViewModel.class);
        addressModel = ViewModelProviders.of(this).get(GetAddressViewModel.class);

        if (SharedPrefUtil.hasKey(getContext(), "ID") || SharedPrefUtil.hasKey(getContext(), "HASH")) {
            id = Long.parseLong(SharedPrefUtil.getData(getContext(), "ID", 0L).toString());
            hash = String.valueOf(SharedPrefUtil.getData(getContext(), "HASH", " "));
            /*
            int mMobile, String mDateOfBirth, String mFirstName, String mGender, String mLastName
            updateModel.UpdateUser(new UserInfo(id, hash, null, null, null, null, null));
            addressModel.getAddress(id, hash);*/

            updateModel.GetData().observe(this, loginResponse -> {
                if (loginResponse != null) {
                    txtEmail.setText(loginResponse.getUserInfo().getEmail());
                    txtPhone.setText(loginResponse.getUserInfo().getMobile());
                    txtGender.setText(loginResponse.getUserInfo().getGender());
                    txtBirth.setText(loginResponse.getUserInfo().getDateOfBirth());
                }
            });
        } else {
            Toast.makeText(getContext(), "no id", Toast.LENGTH_SHORT).show();

        }

        adapter = new UserAddressAdapter();
        recyclerAddress.setAdapter(adapter);

        addressModel.getUserAddressList().observe(this, addressesResponse -> {
            addressList = new ArrayList<>();
            if (addressesResponse.getError() == 0) {
                addressList.addAll(addressesResponse.getAddresses());
                adapter.updateAddress(addressList);
                adapter.setListner(new UserAddressAdapter.ClickA() {
                    @Override
                    public void onDelete(int position) {

                        deleteAddress(position);
                    }

                    @Override
                    public void onEdit(int position) {
                        updateAdress(position);
                    }
                });


            } else {
                Toast.makeText(getContext(), "An Error Accrued", Toast.LENGTH_SHORT).show();
            }
        });

        fabEdit.setOnClickListener(v -> {
            NavOptions navOptions = new NavOptions.Builder()
                    .setLaunchSingleTop(true).build();
            Navigation.findNavController(v)
                    .navigate(R.id.nav_editeDetailsFragment, null, navOptions);

        });
    }

    private void updateAdress(int position) {
        Address userAddress = addressList.get(position);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.addresses_adapter, null);
        dialogBuilder.setView(dialogView);


        citySpinner = dialogView.findViewById(R.id.city_spinner);
        subCitySpinner = dialogView.findViewById(R.id.subCity_spinner);
        EditText address = dialogView.findViewById(R.id.address);
        EditText building = dialogView.findViewById(R.id.building);
        EditText apartment = dialogView.findViewById(R.id.apartment);
        Button bt_updateAddress = dialogView.findViewById(R.id.bt_updateAddress);

        PickAddress();

        address.setText(userAddress.getAddress());
        building.setText(userAddress.getBuilding());
        apartment.setText(userAddress.getApartment());

        for (int in = 0; in < cityList.size(); in++) {
            if (cityList.get(in).equals(userAddress.getState())) {
                citySpinner.setSelection(in);
            }
        }

        for (int i = 0; i < subCityList.size(); i++) {
            if (subCityList.get(i).equals(userAddress.getCity())) {
                subCitySpinner.setSelection(i);
            }
        }

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCancelable(true);
        alertDialog.show();

        bt_updateAddress.setOnClickListener(view -> {

            String state = citySpinner.getSelectedItem().toString();
            String city = subCitySpinner.getSelectedItem().toString();
            String ad = address.getText().toString();
            String bu = building.getText().toString();
            String ap = apartment.getText().toString();
            addressModel.editAddress(new Address(userAddress.getId(), id, "Egypt",
                    state, city, ad, bu, ap))
                    .observe(DetailsFragment.this, checkEditAddress -> {
                        if (checkEditAddress.getError() == 0) {
                            addressModel.getAddress(id, hash);
                            Toast.makeText(getContext(), "Updated Successfully...", Toast.LENGTH_SHORT).show();
                            alertDialog.dismiss();

                        } else {
                            Toast.makeText(getContext(), "An Error Accrued, try again...", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    private void deleteAddress(int position) {
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(getContext())
                .setTitle("Delete").setMessage("Are You Sure To Delete This Address")
                .setPositiveButton("Yes", (dialog, which) -> addressModel.deleteAddress(id, hash, addressList.get(position).getId()).
                        observe(DetailsFragment.this, checkDeleteAddress -> {
                            if (checkDeleteAddress.getError() == 0) {
                                addressModel.getAddress(id, hash);
                                Toast.makeText(getContext(), "Address Deleted ...", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "An Error Accrued, try again...", Toast.LENGTH_SHORT).show();
                            }
                        })).setNegativeButton("No", (dialog, which) -> {
                })
                .setIcon(R.drawable.ic_delete).show();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(40, 0, 20, 0);

        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.WHITE);
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE);
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setLayoutParams(params);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
