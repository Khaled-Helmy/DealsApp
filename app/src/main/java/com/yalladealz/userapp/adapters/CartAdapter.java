package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.util.ConstantUtil;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private onIncrementDecrementClicked onIncrementDecrementClicked;

    private List<CartProduct> products;

    public CartAdapter(Context context) {
        this.context = context;
    }

    public List<CartProduct> getCartProducts(){
        return products;
    }
    public void setOnIncrementDecrementClicked(CartAdapter.onIncrementDecrementClicked onIncrementDecrementClicked) {
        this.onIncrementDecrementClicked = onIncrementDecrementClicked;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_adapter, parent, false);

        return new CartViewHolder(v, onIncrementDecrementClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartProduct product = products.get(position);
        Glide.with(context)
                .load(ConstantUtil.DEAL_IMAGE + product.getImageUrl())
                .into(holder.ivDeal);
        holder.tvDealPrice.setText(String.valueOf(product.getPrice()));
        holder.tvProductTitle.setText(product.getTitle());
        holder.tvAmount.setText(String.format(Locale.ENGLISH, "%d", product.getAmount()));

    }

    public void removeFromCart(int position) {
        products.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, products.size());
    }

    public interface onIncrementDecrementClicked {
        void onIncremenent(int position);

        void onDecrement(int position);
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_deal)
        ImageView ivDeal;
        @BindView(R.id.tv_deal_price)
        TextView tvDealPrice;
        @BindView(R.id.btn_add)
        ImageButton btnAdd;
        @BindView(R.id.btn_minus)
        ImageButton btnMinus;
        @BindView(R.id.tv_product_title)
        TextView tvProductTitle;
        @BindView(R.id.tv_amount)
        TextView tvAmount;

        CartViewHolder(@NonNull View v, onIncrementDecrementClicked onClickCart) {
            super(v);
            ButterKnife.bind(this, v);

            btnAdd.setOnClickListener(v1 -> {
                if (onClickCart != null) {
                    int p = getAdapterPosition();
                    if (p != RecyclerView.NO_POSITION) {
                        onClickCart.onIncremenent(p);
                    }
                }
            });

            btnMinus.setOnClickListener(v12 -> {
                if (onClickCart != null) {
                    int p = getAdapterPosition();
                    if (p != RecyclerView.NO_POSITION) {
                        onClickCart.onDecrement(p);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (products != null) ? products.size() : 0;
    }

    public void setProducts(List<CartProduct> cartProducts) {
        this.products = cartProducts;
        notifyDataSetChanged();
    }
}
