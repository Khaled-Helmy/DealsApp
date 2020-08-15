package com.yalladealz.userapp.ui.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.ui.activities.VisaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MhfztyFragment extends Fragment {

    //TODO: Test implementation
    //TODO Firebase notification

    /*
        In this fragment backend must push notification from server
        Receive this notification in App

       you should show the response form server to user to know if the process done or not

       then:
            update the value in mhfzty (pocket money of app) if the response is successfully

     */

    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.payBtn)
    Button payBtn;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.visaImage)
    ImageView visaImage;
    @BindView(R.id.cardView)
    CardView cardView;
    @BindView(R.id.text2)
    TextView text2;

    private Unbinder unbinder;

    public MhfztyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mhfzty, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.payBtn)
    public void onViewClicked() {
    }

    @OnClick(R.id.text2)
    void obnText2Clicked() {
        if (cardView.getVisibility() == View.GONE) {
            cardView.setVisibility(View.VISIBLE);
            cardView.animate().alpha(1).setDuration(500).start();
        }

    }

    @OnClick(R.id.chargeBtn)
    void onViewClickedChargeBtn() {

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.charge_mhfzty_layout, null);
        alert.setView(dialogView);


        EditText moneyText = dialogView.findViewById(R.id.moneyText);
        Button chargeBtn = (AppCompatButton) dialogView.findViewById(R.id.chargeBtn);

        chargeBtn.setOnClickListener(view -> {
            try {
                int money = Integer.parseInt(moneyText.getEditableText().toString().trim());
                Intent intent = new Intent(getContext(), VisaActivity.class);
                intent.putExtra("money", money);
                startActivity(intent);
            } catch (Exception e) {
            }
        });

        alert.setNegativeButton("Cancel", (dialogInterface, i) -> {

        });

        alert.show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
