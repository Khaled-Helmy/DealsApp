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
import com.yalladealz.userapp.viewModels.CategoryViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCategoryFragment extends Fragment {


    @BindView(R.id.sub_category_deals_recyclerView)
    RecyclerView subCategoryDealsRecyclerView;
    @BindView(R.id.sub_category_deals_progressBar)
    ProgressBar subCategoryDealsProgressBar;

    private CategoryViewModel categoryViewModel;
    private DealsPagedListAdapter dealsPagedListAdapter;
    private Unbinder unbinder;

    public SubCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_category, container, false);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        subCategoryDealsProgressBar.setVisibility(View.VISIBLE);
        categoryViewModel = ViewModelProviders.of(getActivity()).get(CategoryViewModel.class);
        dealsPagedListAdapter = new DealsPagedListAdapter(getContext());
        initSubCategoryDealsRecyclerView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initSubCategoryDealsRecyclerView() {
        subCategoryDealsRecyclerView.setHasFixedSize(true);
        subCategoryDealsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        subCategoryDealsRecyclerView.setAdapter(dealsPagedListAdapter);
        categoryViewModel.getSubCategoryDeals().observe(this, deals -> {
            dealsPagedListAdapter.submitList(deals);
            subCategoryDealsProgressBar.setVisibility(View.INVISIBLE);
        });
    }
}
