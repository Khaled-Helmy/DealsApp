package com.yalladealz.userapp.ui.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.CouponAdapter;
import com.yalladealz.userapp.model.responses.CouponData;
import com.yalladealz.userapp.viewModels.CouponsViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


@SuppressWarnings("ConstantConditions")
public class CouponFragment extends Fragment {


    //TODO Firebase Notification

    /*
        In this fragment backend must push notification from server
        Receive this notification in App

       if the notification tells you that coupon used successfully
       you must change the background of the coupon to red that means this coupon used

     */

    @BindView(R.id.pIMG)
    ImageView pIMG;
    @BindView(R.id.pTitle)
    TextView pTitle;
    @BindView(R.id.couponsList)
    RecyclerView couponsList;
    @BindView(R.id.couponsNumber)
    TextView couponsNumber;

    private String deal_id;
    private CouponAdapter adapter;
    private List<CouponData> couponDataList = new ArrayList<>();
    private CouponsViewModel viewModel;

    String deal_image_url = "";
    String deal_title = "";
    private Unbinder unbinder;

    public CouponFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon, container, false);
        unbinder = ButterKnife.bind(this, view);

        // used in FirebaseMessaging
        LocalBroadcastManager.getInstance(getContext())
                .registerReceiver(receiver, new IntentFilter("com.example.georgesamuel.firebasecm"));


        //TODO: link id, url, title with fragment - Mohamed + Mahmoud
        deal_id = getArguments().getString("deal_id");
        deal_image_url = getArguments().getString("image_url");
        deal_title = getArguments().getString("title");
//        deal_id = "13";

        adapter = new CouponAdapter(couponDataList);
        viewModel = ViewModelProviders.of(this).get(CouponsViewModel.class);

        setData();

        return view;
    }

    private void setData() {

        Glide.with(getContext()).load(deal_image_url).into(pIMG);
        pTitle.setText(deal_title);

        couponsList.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        couponsList.setHasFixedSize(true);
        couponsList.setAdapter(adapter);

        viewModel.getCoupons(getContext(), deal_id).observe(this, couponData -> {

            couponsNumber.setText(String.format(Locale.ENGLISH, "Coupons: %d", couponData.size()));

            //TODO: Eng.Khaled - please provide how to sort

            // Sort data according to coupon is used or not & get value false first
            /*Collections.sort(couponData, new Comparator<CouponData>() {
                @Override
                public int compare(CouponData couponData, CouponData t1) {
                    return Boolean.compare(!t1.getIsUsed(), !couponData.getIsUsed());
                }
            });*/

            // TODO: 03/10/19 ???: couponData.get(1).setIsUsed(false);
            couponDataList.addAll(couponData);
            adapter.notifyDataSetChanged();
        });
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null) {
            String message = intent.getExtras().getString("codeId");
            for (CouponData couponData : couponDataList) {
                if (message.equals(String.valueOf(couponData.getId()))) {
                    couponData.setIsUsed(true);
                    adapter.notifyDataSetChanged();
                }
            }
            // TODO: 30/09/19
        }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(receiver);
        unbinder.unbind();
    }
}
