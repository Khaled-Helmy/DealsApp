package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.History.Deal;
import com.yalladealz.userapp.ui.fragments.CouponFragment;
import com.yalladealz.userapp.util.ConstantUtil;

import java.util.List;

public class AvailableAdapter extends RecyclerView.Adapter<AvailableAdapter.AvailableViewHolder> {

    private List<Deal> deals;
    private Context context;

    public AvailableAdapter(List<Deal> deals, Context context) {
        this.context = context;
        this.deals = deals;
    }

    class AvailableViewHolder extends RecyclerView.ViewHolder {

        private TextView pTitlea, pPricea, pAmounta, pTPricea;
        private ImageView pIMGa;
        private CardView cardView;

        AvailableViewHolder(@NonNull View v) {
            super(v);

            pTitlea = v.findViewById(R.id.pTitlea);
            pPricea = v.findViewById(R.id.pPricea);
            pTPricea = v.findViewById(R.id.pTPricea);
            pAmounta = v.findViewById(R.id.pAmounta);
            pIMGa = v.findViewById(R.id.pIMGa);
            cardView = v.findViewById(R.id.cardView);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableAdapter.AvailableViewHolder holder, int i) {

        Deal deal = deals.get(i);

        holder.pTitlea.setText(deal.getDealData().getDealDescription().getDealName());
        holder.pAmounta.setText(deal.getQuantity());
        holder.pPricea.setText(deal.getItemPrice());
        holder.pTPricea.setText(String.valueOf(Integer.parseInt(deal.getQuantity()) * Integer.parseInt(deal.getItemPrice())));

        if (deal.getDealData().getDealFiles() != null) {
            Glide.with(context).load(ConstantUtil.DEAL_IMAGE +
                    deal.getDealData().getDealFiles().get(0).getFileName()).into(holder.pIMGa);
        }

        holder.cardView.setOnClickListener(view -> {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            CouponFragment couponFragment = new CouponFragment();
            Bundle bundle = new Bundle();
            bundle.putString("deal_id", String.valueOf(deal.getDealData().getDealId()));
            bundle.putString("image_url", ConstantUtil.DEAL_IMAGE + deal.getDealData().getDealFiles().get(0).getFileName());
            bundle.putString("title", deal.getDealData().getDealDescription().getDealName());
            couponFragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, couponFragment, null)
                    .addToBackStack(null).commit();
        });
    }

    @NonNull
    @Override
    public AvailableAdapter.AvailableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_deals_layout, parent, false);

        return new AvailableAdapter.AvailableViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return (deals != null ? deals.size() : 0);
    }

}
