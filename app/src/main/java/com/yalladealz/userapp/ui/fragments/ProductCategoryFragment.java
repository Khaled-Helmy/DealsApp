package com.yalladealz.userapp.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.DealsPagedListAdapter;
import com.yalladealz.userapp.adapters.SubCategoriesAdapter;
import com.yalladealz.userapp.viewModels.CategoryViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProductCategoryFragment extends Fragment {

    @BindView(R.id.category_progress_bar)
    ProgressBar categoryProgressBar;
    @BindView(R.id.category_recyclerView)
    RecyclerView categoryRecyclerView;
    @BindView(R.id.category_subcategories_recyclerView)
    RecyclerView categorySubcategoriesRecyclerView;

    private DealsPagedListAdapter dealsPagedListAdapter;
    private SubCategoriesAdapter subCategoriesAdapter;
    private CategoryViewModel categoryViewModel;
    private Unbinder unbinder;

    public ProductCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_category, container, false);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryViewModel = ViewModelProviders.of(getActivity()).get(CategoryViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        categoryProgressBar.setVisibility(View.VISIBLE);
        dealsPagedListAdapter = new DealsPagedListAdapter(getContext());
        subCategoriesAdapter = new SubCategoriesAdapter(getActivity());
        initSubCategoriesRecyclerView();
        initDealsRecyclerView();
    }

    private void initSubCategoriesRecyclerView() {
        categorySubcategoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        categorySubcategoriesRecyclerView.setHasFixedSize(true);
        categorySubcategoriesRecyclerView.setAdapter(subCategoriesAdapter);
        categoryViewModel.getSubCategories().observe(this, categories -> subCategoriesAdapter.setSubCategories(categories));
    }

    private void initDealsRecyclerView() {
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        categoryRecyclerView.setHasFixedSize(true);
        categoryRecyclerView.setAdapter(dealsPagedListAdapter);
        categoryViewModel.getCategoryDeals().observe(this, deals -> {
            dealsPagedListAdapter.submitList(deals);
            categoryProgressBar.setVisibility(View.GONE);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
