package com.yalladealz.userapp.adapters;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.deals.DealReviewItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {

    private List<DealReviewItem> reviewItems = new ArrayList<>();

    public void setReviewItems(List<DealReviewItem> reviewItems) {
        this.reviewItems = reviewItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reviews_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, reviewItems.get(position));

    }

    private void setData(ViewHolder holder, DealReviewItem dealReviewItem) {
        holder.comment.setText(dealReviewItem.getReviewComment());
        String username = dealReviewItem.getUser().getFirstName()
                + dealReviewItem.getUser().getLastName();
        holder.rate.setRating(dealReviewItem.getRate());
        if (TextUtils.isEmpty(username)) {
            holder.tvUsername.setText("No username");
            return;
        }
        holder.tvUsername.setText(username);


    }

    @Override
    public int getItemCount() {
        return reviewItems != null ? reviewItems.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.rate)
        AppCompatRatingBar rate;
        @BindView(R.id.comment)
        TextView comment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
