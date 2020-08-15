package com.yalladealz.userapp.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.viewModels.UserUpdateViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class WalletFragment extends Fragment {


    @BindView(R.id.wallet_balance_textView)
    TextView walletBalanceTextView;

    private UserUpdateViewModel userUpdateViewModel;
    private Unbinder unbinder;

    public WalletFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        userUpdateViewModel = ViewModelProviders.of(this).get(UserUpdateViewModel.class);
        if (SharedPrefUtil.hasKey(getContext(), "ID") || SharedPrefUtil.hasKey(getContext(), "HASH")) {
            long id = Long.parseLong(SharedPrefUtil.getData(getContext(), "ID", 0L).toString());
            String hash = String.valueOf(SharedPrefUtil.getData(getContext(), "HASH", " "));
         /*   getUserInfo(id, hash);*/
        }
    }
/*
    private void getUserInfo(long id, String hash) {
        userUpdateViewModel.UpdateUser(new UserInfo(
                id,
                hash,
                null,
                null,
                null,
                null,
                null));
        updateWalletBalance();
    }*/

    private void updateWalletBalance() {
        userUpdateViewModel.GetData().observe(this, loginResponse ->
                walletBalanceTextView.setText(loginResponse.getUserInfo().getWalletAmount()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
