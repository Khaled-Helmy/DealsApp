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
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BestDealsFragment extends Fragment {
    @BindView(R.id.deals_recycler_view)
    RecyclerView dealsRecyclerView;
    @BindView(R.id.no_deals_view_container)
    LinearLayout noDealsViewContainer;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.lyt_no_connection)
    LinearLayout lytNoConnection;
    @BindView(R.id.loading)
    ProgressBar loading;
    private HomeViewModel homeViewModel;

    private DealsPagedListAdapter dealsPagedListAdapter;
    private Unbinder unbinder;

    public BestDealsFragment() {
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
        return inflater.inflate(R.layout.fragment_best_deals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initRecyclerView();

    }

    private void initRecyclerView() {
        dealsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dealsRecyclerView.setHasFixedSize(true);
        dealsPagedListAdapter = new DealsPagedListAdapter(getContext());
        dealsRecyclerView.setAdapter(dealsPagedListAdapter);

        homeViewModel.getBestDeals().observe(this, deals -> {
            if (deals == null) {
                loading.setVisibility(View.GONE);
                noDealsViewContainer.setVisibility(View.VISIBLE);
                return;
            }

            loading.setVisibility(View.GONE);
            dealsPagedListAdapter.submitList(deals);


        });

    }

    @OnClick(R.id.bt_retry)
    public void onViewClicked() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
