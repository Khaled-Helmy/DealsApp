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
import com.yalladealz.userapp.adapters.AvailableAdapter;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.viewModels.HistoryViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AvailableDealsFragment extends Fragment {

    @BindView(R.id.recyclerAvailable)
    RecyclerView recyclerAvailable;
    private AvailableAdapter adapter;
    private Unbinder unbinder;


    public AvailableDealsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_available_deals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        recyclerAvailable.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAvailable.setHasFixedSize(true);

        HistoryViewModel model = ViewModelProviders.of(this).get(HistoryViewModel.class);

        if (SharedPrefUtil.hasKey(getContext(), "ID") || SharedPrefUtil.hasKey(getContext(), "HASH")) {
            long id = Long.parseLong(SharedPrefUtil.getData(getContext(), "ID", 0L).toString());
            String hash = String.valueOf(SharedPrefUtil.getData(getContext(), "HASH", ""));

            model.history(id, hash);

            model.getAvailable().observe(this, deals -> {
                adapter = new AvailableAdapter(deals, getContext());
                recyclerAvailable.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
