package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.WishListTable;
import com.yalladealz.userapp.ui.activities.DealsDetailsActivity;
import com.yalladealz.userapp.util.ConstantUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {


    private Context context;
    private List<WishListTable> wishList;

    public WishListAdapter(Context context) {
        this.context = context;
    }

    public void setWishList(List<WishListTable> wishList) {
        this.wishList = wishList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wish_list_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WishListTable wishListTable = wishList.get(position);
        setData(wishListTable, holder);
        holder.itemView.setOnClickListener(view -> {
            Intent in = new Intent(context, DealsDetailsActivity.class);
            save(context, ConstantUtil.DEAL_ID, wishListTable.getDealId());
            save(context, ConstantUtil.OPTION_ID, wishListTable.getOptionId());
            context.startActivity(in);
        });

    }

    private void setData(WishListTable cartProduct, ViewHolder holder) {
        Glide.with(context)
                .load(ConstantUtil.DEAL_IMAGE + cartProduct.getImageUrl())
                .into(holder.image);

        holder.productNameTv.setText(cartProduct.getDealname());
        holder.discount.setText(cartProduct.getDealDiscount());
        holder.finalPrice.setText(cartProduct.getFinalPrice() + context.getString(R.string.pound));

    }

    @Override
    public int getItemCount() {
        if (wishList == null) {
            return 0;
        }
        return wishList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.product_name_tv)
        TextView productNameTv;
        @BindView(R.id.finalPrice)
        TextView finalPrice;
        @BindView(R.id.discount)
        TextView discount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
