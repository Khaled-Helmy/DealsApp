package com.yalladealz.userapp.ui.fragments;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.yalladealz.userapp.BuildConfig;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.remote.RetrofitClient;
import com.yalladealz.userapp.util.CommonMethod;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.util.ValidationUtil;
import com.yalladealz.userapp.viewModels.RegisterViewModel;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.EMAIL;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.ID;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.USER_NAME;
import static com.yalladealz.userapp.util.SharedPrefUtil.getData;

public class RegisterFragment extends Fragment {

    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_phone_number)
    EditText inputPhoneNumber;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.confirm_pass)
    EditText confirmPass;
    Unbinder unbinder;
    @BindView(R.id.textDate)
    TextView textDate;
    @BindView(R.id.input_fname)
    EditText inputFname;
    @BindView(R.id.input_lname)
    EditText inputLname;
    @BindView(R.id.gender_spinner)
    Spinner genderSpinner;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;
    @BindView(R.id.textSingIn)
    TextView textSingIn;

    private DatePickerDialog.OnDateSetListener listener;

    private RegisterViewModel model;


    public RegisterFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        model = ViewModelProviders.of(this).get(RegisterViewModel.class);

        datePicker();

        String email = String.valueOf(getData(getActivity(), EMAIL, ""));
        String username = String.valueOf(getData(getContext(), USER_NAME, ""));
        String id = String.valueOf(getData(getContext(), ID, ""));



      displayData(email, username, id);
        if (BuildConfig.DEBUG) {
            inputEmail.setText("ahmed.galal23222@gmail.com");
            inputPassword.setText("123456789");
            confirmPass.setText("123456789");
            inputFname.setText("ahmed");
            inputLname.setText("galal");
            inputPhoneNumber.setText("01148029979");
        }

        return view;
    }


    private void displayData(String email, String username, String id) {

        if (email != null) {
            inputEmail.setText(email);
        } else {
            inputEmail.setError(getString(R.string.enter_email_error));
        }

        if (username != null) {
            inputLname.setText(username);
        } else {
            inputLname.setError("Required");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @SuppressWarnings("ConstantConditions")
    @OnClick({R.id.btn_sign_up, R.id.textDate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_up:

                if (signUpValidations()) {
                     Log.d("khaled2","khaled2" );
                     String gender = genderSpinner.getSelectedItem().toString();
                     String birth = textDate.getText().toString().trim();
                     String fname= inputFname.getText().toString().trim();
                     String lname= inputLname.getText().toString().trim();
                     String uEmail= inputEmail.getText().toString().trim();
                     String uPassword=inputPassword.getText().toString().trim();
                     String uPhoneNumber= inputPhoneNumber.getText().toString().trim();

                     model.register(new SginUpUserInfo( fname, lname, uPassword,uPhoneNumber,uEmail));
                        
                     model.getRegisterResponseLiveData().observe(this, loginResponse -> {
                        Log.d("khaled1","khaled1" );


                      if ( loginResponse.getLogin() != null || BuildConfig.DEBUG ) {

                            Log.d("khaled0","khaled0" );
                            SharedPrefUtil.save(getContext(),"firstName" , loginResponse.getSginUpUserInfo().getFirstName());
                            SharedPrefUtil.save(getContext(), "lastName",  loginResponse.getSginUpUserInfo().getLastName());
                            SharedPrefUtil.save(getContext(), "password", loginResponse.getSginUpUserInfo().getPassword());
                            SharedPrefUtil.save(getContext(), "phone", loginResponse.getSginUpUserInfo().getMobile());
                            SharedPrefUtil.save(getContext(), "email", loginResponse.getSginUpUserInfo().getEmail());
                          SharedPrefUtil.save(getContext(), "message",loginResponse.getSginUpUserInfo().getMassage());

                         Toast.makeText(getContext(),"Massage" +loginResponse.getSginUpUserInfo().getMassage(),Toast.LENGTH_LONG).show();


                          Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                                  .navigate(R.id.action_nav_registerFragment_to_nav_loginFragment);
                            ////// TODO: add Verification code to shared preference and send it to VerificationCode Fragment

                            Log.d("khaled3","khaled3" );

                        } else {
                            Toast.makeText(getContext(), loginResponse.getSginUpUserInfo().getMassage() + "", Toast.LENGTH_SHORT).show();
                            Log.d("khaled4","khaled4" );
                        }
                    });
                     Log.d("khaled5","khaled5" );
                    model.getResponseError().observe(this, s -> Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show());
                }
                break;


            case R.id.textDate:
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
                break;
        }
    }

    private void datePicker() {

        listener = (view, year, month, dayOfMonth) -> {
            int m = month + 1;

            String date = dayOfMonth + "/" + m + "/" + year;
            if (year > 2015 || year < 1920) {
                CommonMethod.showToast("Pick a Valid date", getContext());
                return;
            }
            textDate.setText(date);
        };
    }

    @SuppressWarnings("ConstantConditions")
    private boolean signUpValidations() {
        if (!CommonMethod.isNetworkAvailable(getContext())) {
            CommonMethod.showAlert("Fail to connect to the internet", getActivity());
            return false;
        }
        if (inputFname.getText().toString().trim().equals("")) {
            inputFname.setError("Enter your first name");
            return false;
        }
        if (inputLname.getText().toString().trim().equals("")) {
            inputLname.setError("Enter your last name");
            return false;
        }
        if (inputEmail.getText().toString().trim().equals("")) {
            inputEmail.setError("Enter your email");
            return false;
        }
        if (ValidationUtil.validEmail(inputEmail.getText().toString().trim())) {
            inputEmail.setError("this email is not valid");
            return false;
        }
        if (inputPassword.getText().toString().trim().equals("")) {
            inputPassword.setError("Enter a password");
            return false;
        }
        if (inputPassword.getText().toString().trim().length() < 6) {
            inputPassword.setError(getString(R.string.password_size_error));
            return false;
        }
        if (!inputPassword.getText().toString().equals(confirmPass.getText().toString())) {
            confirmPass.setError("Password is not matching");
            return false;
        }
        if (textDate.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Pick your Birth Date", getActivity());
            return false;
        }
        return true;
    }

    @SuppressWarnings("ConstantConditions")
    @OnClick(R.id.textSingIn)
    public void onViewClicked() {

        Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_nav_registerFragment_to_nav_loginFragment);

    }
}