package com.yalladealz.userapp.adapters;

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
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.search.SearchResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yalladealz.userapp.util.ConstantUtil.DEAL_ID;
import static com.yalladealz.userapp.util.ConstantUtil.DEAL_IMAGE;
import static com.yalladealz.userapp.util.ConstantUtil.OPTION_ID;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class SearchResultPagedAdapter extends PagedListAdapter<SearchResponse.Result, SearchResultPagedAdapter.ResultViewHolder> {


    private static DiffUtil.ItemCallback<SearchResponse.Result> DIFF_CALLBACK = new DiffUtil.ItemCallback<SearchResponse.Result>() {
        @Override
        public boolean areItemsTheSame(@NonNull SearchResponse.Result oldItem, @NonNull SearchResponse.Result newItem) {
            return (oldItem.getDealId().equals(newItem.getDealId()));
        }

        @Override
        public boolean areContentsTheSame(@NonNull SearchResponse.Result oldItem, @NonNull SearchResponse.Result newItem) {
            return (oldItem.getDealDescription().getDealName())
                    .equals(newItem.getDealDescription().getDealName());
        }
    };
    private FragmentActivity context;

    public SearchResultPagedAdapter(FragmentActivity context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }


    @NonNull
    @Override
    public SearchResultPagedAdapter.ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchResultPagedAdapter.ResultViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deals_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultPagedAdapter.ResultViewHolder holder, int position) {
        holder.setData(context, getItem(position));
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {

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

        ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(FragmentActivity context, SearchResponse.Result deal) {
            discountPercentTv.setText(deal.getPrimaryOption().getDealDiscount());
            dealDescTv.setText(Html.fromHtml(deal.getDealDescription().getDealDescription()));
            dealTitleTv.setText(Html.fromHtml(deal.getDealDescription().getDealName()));
            dealAppCompatRatingBar.setRating(deal.getTotalReview());
            discountPercentTv.setText(String.format("%s %% ", deal.getPrimaryOption().getDiscountAmount()));
            originalPriceTv.setText(String.format("%s جنيه ", deal.getPrimaryOption().getOriginalPrice()));
            originalPriceTv.setPaintFlags(originalPriceTv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            discountedPriceTv.setText(String.format("%s جنيه ", deal.getPrimaryOption().getFinalPrice()));
            List<SearchResponse.DealFile> dealFiles = deal.getDealFiles();
            Glide.with(itemView).load(DEAL_IMAGE
                    + dealFiles.get(0).getFileName()).into(dealImage);
            yallaDealzButton.setOnClickListener(v -> {
                save(context, DEAL_ID, deal.getDealId());
                save(context, OPTION_ID, deal.getPrimaryOption().getId());
                Navigation.findNavController(context, R.id.nav_host_fragment).navigate(R.id.nav_dealsDetailsActivity);
            });
        }
    }
}
