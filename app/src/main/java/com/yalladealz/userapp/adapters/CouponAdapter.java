package com.yalladealz.userapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.responses.CouponData;
import com.yalladealz.userapp.util.QRCodeConverter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.CouponViewHolder> {

    private List<CouponData> couponList;

    public CouponAdapter(List<CouponData> couponList) {
        this.couponList = couponList;
    }

    @NonNull
    @Override
    public CouponViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_item, parent, false);
        return new CouponViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouponViewHolder holder, int position) {

        QRCodeConverter qrCodeConverter = new QRCodeConverter();
        holder.couponImage.setImageBitmap(qrCodeConverter.convertString(couponList.get(position).getCouponCode()));
        holder.progressBar.setVisibility(View.GONE);
        holder.couponTex.setText(couponList.get(position).getCouponCode());

        if (couponList.get(position).getIsUsed()) {
            holder.couponTex.setText("This coupon is used");
        }
    }

    @Override
    public int getItemCount() {
        return couponList != null ? couponList.size() : 0;
    }

    static class CouponViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.QRcode)
        ImageView couponImage;
        @BindView(R.id.progressBar)
        ProgressBar progressBar;
        @BindView(R.id.codeText)
        TextView couponTex;

        CouponViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
