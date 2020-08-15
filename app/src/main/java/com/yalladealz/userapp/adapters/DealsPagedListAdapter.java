package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.navigation.Navigation;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.deals.DealFilesItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yalladealz.userapp.util.ConstantUtil.DEAL_ID;
import static com.yalladealz.userapp.util.ConstantUtil.DEAL_IMAGE;
import static com.yalladealz.userapp.util.ConstantUtil.DEAL_RATING;
import static com.yalladealz.userapp.util.ConstantUtil.OPTION_ID;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class DealsPagedListAdapter extends PagedListAdapter<Deal, DealsPagedListAdapter.DealsViewHolder> {


    private Context context;

    private static DiffUtil.ItemCallback<Deal> DIFF_CALLBACK = new DiffUtil.ItemCallback<Deal>() {
        @Override
        public boolean areItemsTheSame(@NonNull Deal oldItem, @NonNull Deal newItem) {
            return (oldItem.getDealId() == newItem.getDealId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Deal oldItem, @NonNull Deal newItem) {
            return (oldItem.getDealDescription().getDealName())
                    .equals(newItem.getDealDescription().getDealName());
        }
    };

    public DealsPagedListAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }


    @NonNull
    @Override
    public DealsPagedListAdapter.DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DealsPagedListAdapter.DealsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deals_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DealsPagedListAdapter.DealsViewHolder holder, int position) {
        holder.setData(getItem(position));
    }

    class DealsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.deal_image)
        ImageView dealImage;
        @BindView(R.id.discount_percent_tv)
        TextView discountPercentTv;
        @BindView(R.id.deal_title_tv)
        TextView dealTitleTv;
        @BindView(R.id.deal_desc_tv)
        TextView dealDescTv;
        @BindView(R.id.original_price_tv)
        TextView originalPriceTv;
        @BindView(R.id.discounted_price_tv)
        TextView discountedPriceTv;
        @BindView(R.id.deal_appCompatRatingBar)
        AppCompatRatingBar dealAppCompatRatingBar;
        @BindView(R.id.yalla_dealz_button)
        Button yallaDealzButton;

        DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(Deal deal) {
            discountPercentTv.setText(deal.getPrimaryOption().getDealDiscount());
            dealDescTv.setText(Html.fromHtml(deal.getDealDescription().getDealDescription()));
            dealTitleTv.setText(Html.fromHtml(deal.getDealDescription().getDealName()));
            dealAppCompatRatingBar.setRating(deal.getTotalReview());
            discountPercentTv.setText(String.format("%s %% ", deal.getPrimaryOption().getDealDiscount()));
            originalPriceTv.setText(String.format("%s %s ", deal.getPrimaryOption().getOriginalPrice(), context.getString(R.string.pound)));
            originalPriceTv.setPaintFlags(originalPriceTv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            discountedPriceTv.setText(String.format("%s %s ", deal.getPrimaryOption().getFinalPrice(), context.getString(R.string.pound)));

            List<DealFilesItem> dealFiles = deal.getDealFiles();

            Glide.with(itemView).load(DEAL_IMAGE
                    + dealFiles.get(0).getFileName()).into(dealImage);
//            yallaDealzButton.setOnClickListener(v -> {
//                save(context, DEAL_ID, deal.getDealId());
//                save(context, OPTION_ID, deal.getDealOptions());
//                Navigation.findNavController(v).navigate(R.id.nav_dealsDetailsActivity);
//            });

            itemView.setOnClickListener(view -> {
                save(context, DEAL_ID, deal.getDealId());
                save(context, OPTION_ID, deal.getPrimaryOption().getId());
                Navigation.findNavController(view).navigate(R.id.nav_dealsDetailsActivity);

            });
        }
    }
}
