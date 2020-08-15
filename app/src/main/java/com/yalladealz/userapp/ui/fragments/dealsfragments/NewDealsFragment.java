package com.yalladealz.userapp.ui.fragments.dealsfragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.DealsPagedListAdapter;
import com.yalladealz.userapp.viewModels.HomeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDealsFragment extends Fragment {


    @BindView(R.id.new_deals_recycler)
    RecyclerView newDealsRecycler;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.no_deals_view_container)
    LinearLayout noDealsViewContainer;

    private HomeViewModel homeViewModel;
    private DealsPagedListAdapter adapter;
    private Unbinder unbinder;

    public NewDealsFragment() {
        // Required empty public constructor
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_deals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initRecycler();
    }

    private void initRecycler() {
        newDealsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        newDealsRecycler.setHasFixedSize(true);

        adapter = new DealsPagedListAdapter(getContext());
        newDealsRecycler.setAdapter(adapter);
        homeViewModel.getNewDeals().observe(this, deals -> {
            if (deals == null) {
                loading.setVisibility(View.GONE);
                noDealsViewContainer.setVisibility(View.VISIBLE);
                return;
            }

            loading.setVisibility(View.GONE);
            adapter.submitList(deals);

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
