package com.yalladealz.userapp.ui.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emeint.android.fawryplugin.Plugininterfacing.FawrySdk;
import com.emeint.android.fawryplugin.models.FawryCardToken;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.SearchResultPagedAdapter;
import com.yalladealz.userapp.viewModels.HomeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FilterResultFragment extends DialogFragment {
    @BindView(R.id.search_result_rv)
    RecyclerView searchResultRv;
    private HomeViewModel homeViewModel;


    public FilterResultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.SearchDialog);
        homeViewModel = ViewModelProviders.of(getActivity())
                .get(HomeViewModel.class);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        SearchResultPagedAdapter adapter = new SearchResultPagedAdapter(getActivity());
        searchResultRv.setHasFixedSize(true);
        searchResultRv.setLayoutManager(new LinearLayoutManager(getContext()));
        searchResultRv.setAdapter(adapter);

        ViewModelProviders.of(getActivity()).get(HomeViewModel.class).getSearchResultDeals()
                .observe(this, adapter::submitList);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;

            dialog.getWindow().setLayout(width, height);
        }
    }
}
