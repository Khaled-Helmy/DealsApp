package com.yalladealz.userapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.poovam.pinedittextfield.LinePinField;
import com.yalladealz.userapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.SharedPrefUtil.getData;

@SuppressWarnings("ConstantConditions")
public class VerificationCode extends Fragment {

    @BindView(R.id.resend)
    TextView resend;
    private Unbinder unbinder;
    private LinePinField linePinField;


    public VerificationCode() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_verification_code, container, false);
        unbinder = ButterKnife.bind(this, v);
        linePinField = v.findViewById(R.id.lineField);


        // TODO: get verification code from the previous screen
        int verificationCode = (int) getData(getContext(), "code", 0);

        // send the number to the server
        linePinField.setOnTextCompleteListener(s -> {

            //TODO send the code to the server
            String code = linePinField.getText().toString();
            Toast.makeText(getContext(), code, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.nav_homeFragment);

            return false;
        });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.resend)
    public void onViewClicked() {


        //TODO resend the code to the user - API

    }
}
