package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.History.Deal;
import com.yalladealz.userapp.util.ConstantUtil;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<Deal> deals;
    private Context context;

    public HistoryAdapter(List<Deal> deals, Context context) {
        this.context = context;
        this.deals = deals;
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        private TextView pTitle, pPrice, pAmount, pTPrice;
        private ImageView pIMG;

        HistoryViewHolder(@NonNull View v) {
            super(v);

            pTitle = v.findViewById(R.id.pTitle);
            pPrice = v.findViewById(R.id.pPrice);
            pTPrice = v.findViewById(R.id.pTPrice);
            pAmount = v.findViewById(R.id.pAmount);
            pIMG = v.findViewById(R.id.pIMG);
        }
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_adapter, parent, false);

        return new HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int i) {

        Deal deal = deals.get(i);

        if (deal.getDealData().getDealRedeemed().getRedeemed()){
            holder.pTitle.setText(deal.getDealData().getDealDescription().getDealName());
            holder.pAmount.setText(deal.getQuantity());
            holder.pPrice.setText(deal.getItemPrice());
            holder.pTPrice.setText(String.valueOf(Integer.parseInt(deal.getQuantity()) * Integer.parseInt(deal.getItemPrice())));

            if(deal.getDealData().getDealFiles() != null){
                Glide.with(context).load(ConstantUtil.DEAL_IMAGE +
                        deal.getDealData().getDealFiles().get(0).getFileName()).into(holder.pIMG);
            }
        }

    }

    @Override
    public int getItemCount() {
        return (deals != null ? deals.size() : 0);
    }

}
