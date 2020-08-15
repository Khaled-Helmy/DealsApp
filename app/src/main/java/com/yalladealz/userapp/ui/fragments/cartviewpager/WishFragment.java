package com.yalladealz.userapp.ui.fragments.cartviewpager;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.WishListAdapter;
import com.yalladealz.userapp.model.WishListTable;
import com.yalladealz.userapp.viewModels.CartViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishFragment extends Fragment {


    @BindView(R.id.wish_recycler)
    RecyclerView wishRecycler;

    private CartViewModel cartViewModel;

    public WishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wish, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartViewModel = ViewModelProviders.of(this)
                .get(CartViewModel.class);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        initWishRecycler();
    }

    private void initWishRecycler() {
        wishRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        wishRecycler.setHasFixedSize(true);
        WishListAdapter adapter = new WishListAdapter(getContext());
        wishRecycler.setAdapter(adapter);
        cartViewModel.getWishListLiveData().observe(this, new Observer<List<WishListTable>>() {
            @Override
            public void onChanged(List<WishListTable> wishListTables) {
                if (wishListTables != null) {
                    adapter.setWishList(wishListTables);

                }
            }
        });
    }
}
