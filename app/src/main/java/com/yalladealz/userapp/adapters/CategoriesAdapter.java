package com.yalladealz.userapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.Category;
import com.yalladealz.userapp.viewModels.CategoryViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private List<Category> categories;
    private FragmentActivity activity;

    public CategoriesAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        holder.bindTo(categories.get(position), activity);
    }

    @Override
    public int getItemCount() {
        return (categories != null) ? categories.size() : 0;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    class CategoriesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.category_image)
        ImageView categoryImage;
        @BindView(R.id.category_title)
        TextView categoryTitle;

        CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindTo(Category category, FragmentActivity activity) {
            categoryTitle.setText(category.getCategoryDescription().getCategoryName());
            Glide.with(itemView)
                    .load("https://www.yalladealz.com/images/category/" + category.getIcon())
                    .into(categoryImage);
            itemView.setOnClickListener(v -> {
                ViewModelProviders.of(activity).get(CategoryViewModel.class).setCategoryId(category.getCategoryId());
                Navigation.findNavController(v)
                        .navigate(R.id.nav_productCategoryFragment);
            });
        }
    }
}
