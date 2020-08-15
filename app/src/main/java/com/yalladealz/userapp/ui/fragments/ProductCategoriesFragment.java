package com.yalladealz.userapp.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.CategoriesAdapter;
import com.yalladealz.userapp.viewModels.HomeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ProductCategoriesFragment extends Fragment {


    @BindView(R.id.product_categories_recyclerView)
    RecyclerView productCategoriesRecyclerView;

    private CategoriesAdapter categoriesAdapter;
    private HomeViewModel homeViewModel;
    private Unbinder unbinder;

    public ProductCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_categories, container, false);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        categoriesAdapter = new CategoriesAdapter(getActivity());
        initRecycleView();
    }

    private void initRecycleView() {
        productCategoriesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        productCategoriesRecyclerView.setHasFixedSize(true);
        productCategoriesRecyclerView.setAdapter(categoriesAdapter);
        homeViewModel.getAllCategories().observe(this, categories -> categoriesAdapter.setCategories(categories));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
