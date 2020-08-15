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

public class SubCategoriesAdapter extends RecyclerView.Adapter<SubCategoriesAdapter.SubCategoriesViewHolder> {

    @BindView(R.id.category_image)
    ImageView categoryImage;
    @BindView(R.id.category_title)
    TextView categoryTitle;

    private List<Category> subCategories;
    private FragmentActivity activity;

    public SubCategoriesAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public SubCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubCategoriesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoriesViewHolder holder, int position) {
        holder.bindTo(subCategories.get(position), activity);
    }

    @Override
    public int getItemCount() {
        return (subCategories != null) ? subCategories.size() : 0;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    class SubCategoriesViewHolder extends RecyclerView.ViewHolder {

        SubCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindTo(Category category, FragmentActivity activity) {
            Glide.with(itemView)
                    .load("https://www.yalladealz.com/images/category/" + category.getIcon())
                    .into(categoryImage);
            categoryTitle.setText(category.getCategoryDescription().getCategoryName());
            itemView.setOnClickListener(v -> {
                ViewModelProviders.of(activity).get(CategoryViewModel.class).setSubCategoryId(category.getCategoryId());
                Navigation.findNavController(itemView)
                        .navigate(R.id.action_productCategoryFragment_to_subCategoryFragment);
            });
        }

    }
}
