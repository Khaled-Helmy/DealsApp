package com.yalladealz.userapp.ui.fragments.ProfilePageFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.HistoryAdapter;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.viewModels.HistoryViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OrderHistoryFragment extends Fragment {


    @BindView(R.id.recyclerHistory)
    RecyclerView recyclerHistory;

    private HistoryAdapter adapter;
    private Unbinder unbinder;


    public OrderHistoryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order_history, container, false);
        unbinder = ButterKnife.bind(this, v);

        recyclerHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerHistory.setHasFixedSize(true);

        HistoryViewModel model = ViewModelProviders.of(this).get(HistoryViewModel.class);

        if (SharedPrefUtil.hasKey(getContext(), "ID") || SharedPrefUtil.hasKey(getContext(), "HASH")) {
            long id = Long.parseLong(SharedPrefUtil.getData(getContext(), "ID", 0L).toString());
            String hash = String.valueOf(SharedPrefUtil.getData(getContext(), "HASH", " "));

            model.history(id, hash);

            model.getHistory().observe(this, deals -> {
                adapter = new HistoryAdapter(deals, getContext());
                recyclerHistory.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            });
        }


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
