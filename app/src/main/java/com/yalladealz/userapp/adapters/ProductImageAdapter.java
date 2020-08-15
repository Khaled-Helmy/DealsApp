package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.interfaces.OnImageClickListener;
import com.yalladealz.userapp.model.deals.DealFilesItem;
import com.yalladealz.userapp.ui.fragments.GalleryFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yalladealz.userapp.util.ConstantUtil.DEAL_IMAGE;

public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ViewHolder> {

    private OnImageClickListener clickListener;

    private List<DealFilesItem> items = new ArrayList<>();
    private Context context;

    public ProductImageAdapter(Context context) {
        this.context = context;
    }

    public void setClickListener(OnImageClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setItems(List<DealFilesItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_image_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DealFilesItem item = items.get(position);
        setData(item, holder);
    }

    private void setData(DealFilesItem item, ViewHolder holder) {
        Glide.with(context)
                .load(DEAL_IMAGE + item.getFileName())
                .into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_image)
        ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> clickListener.onImageClick(items.get(getAdapterPosition()), getAdapterPosition()));
        }
    }
}
