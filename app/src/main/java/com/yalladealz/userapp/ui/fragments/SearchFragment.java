package com.yalladealz.userapp.ui.fragments;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.SearchResultPagedAdapter;
import com.yalladealz.userapp.model.Category;
import com.yalladealz.userapp.model.search.SearchParameters;
import com.yalladealz.userapp.viewModels.HomeViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.CommonMethod.showSelectionAlert;
import static com.yalladealz.userapp.util.LogUtil.verbose;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    @BindView(R.id.filter_category)
    TextInputEditText filterCategory;
    @BindView(R.id.filter_low_price)
    EditText filterLowPrice;
    @BindView(R.id.filter_high_price)
    EditText filterHighPrice;
    @BindView(R.id.sort_by_letters)
    EditText sortByLetters;
    @BindView(R.id.btn_search)
    AppCompatButton btnSearch;
    @BindView(R.id.et_search)
    TextInputEditText etSearch;
    private SearchParameters searchParameters;
    private String category_id;

    private Unbinder unbinder;
    private SearchResultPagedAdapter searchAdapter;
    private HomeViewModel homeViewModel;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        String sort = sortByLetters.getText().toString();
        if (TextUtils.isEmpty(sort)) {
            sort = "";
        }


        String highPrice = filterHighPrice.getText().toString();
        String lowPrice = filterLowPrice.getText().toString();
        String price = lowPrice + "-" + highPrice;
        if (TextUtils.isEmpty(highPrice) && TextUtils.isEmpty(lowPrice) && price.contains("-")) {
            price = "";
        }

        if (TextUtils.isEmpty(category_id)) {
            category_id = "";
        }

        String query = etSearch.getText().toString();
        if (TextUtils.isEmpty(query)) {
            query = "";
        }
        searchParameters = new SearchParameters(
                category_id,
                query,
                sort,
                "",
                price);
        verbose("search parameter: " + searchParameters.toString());
        homeViewModel.search(searchParameters);

        FilterResultFragment filterResultFragment = new FilterResultFragment();
        filterResultFragment.show(getChildFragmentManager(), "dialog");
    }


    @OnClick(R.id.filter_category)
    void onFilterCategoryClicked() {
        ArrayList<String> items = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        homeViewModel.getAllCategories().observe(this, categories -> {

            for (Category category : categories) {
                items.add(category.getCategoryDescription().getCategoryName());
                id.add(category.getCategoryId());
            }

        });

        showSelectionAlert(getContext(), items, "Filter by category", (selectedItem, pos) -> {
            filterCategory.setText(selectedItem);
            category_id = id.get(pos);

        });
    }


    @OnClick(R.id.sort_by_letters)
    void onSortByLettersClicked() {
        ArrayList<String> items = new ArrayList<>();
        items.add(getString(R.string.a_z));
        items.add(getString(R.string.z_a));
        items.add(getString(R.string.price_low));
        items.add(getString(R.string.price_high));
        items.add(getString(R.string.rating_high));
        items.add(getString(R.string.rating_low));

        showSelectionAlert(getContext(), items, "Sort:", (selectedItem, pos) -> sortByLetters.setText(selectedItem));
    }
}
