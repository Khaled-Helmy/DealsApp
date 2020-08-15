package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.ui.viewHolders.PaymentMViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PaymentMAdapter extends RecyclerView.Adapter<PaymentMViewHolder> {

    private List<Pair<Integer, Integer>> list;
    private Context context;
    private int money;
    private ArrayList<CartProduct> products;

    public PaymentMAdapter(List<Pair<Integer, Integer>> list, ArrayList<CartProduct> products, int money) {
        this.list = list;
        this.money = money;
        this.products = products;
    }


    @NonNull
    @Override
    public PaymentMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new PaymentMViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_method_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMViewHolder holder, int position) {

        holder.bind(list.get(position), products, money, context);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}
