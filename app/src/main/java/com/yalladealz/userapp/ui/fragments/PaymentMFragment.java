package com.yalladealz.userapp.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.PaymentMAdapter;
import com.yalladealz.userapp.model.CartProduct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.LogUtil.debug;


public class PaymentMFragment extends Fragment {


    @BindView(R.id.home_categories_recyclerView)
    RecyclerView recyclerView;

    private List<Pair<Integer, Integer>> list;
    private Unbinder unbinder;

    public PaymentMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_m, container, false);
        unbinder = ButterKnife.bind(this, view);

        int money = 0;
        ArrayList<CartProduct> products = new ArrayList<>();
        if (getArguments() != null) {
            money = getArguments().getInt("money");
            products = getArguments().getParcelableArrayList("products");
            debug(String.valueOf(products));
            debug(String.valueOf(money));
        }

        list = new ArrayList<>();
        PaymentMAdapter adapter = new PaymentMAdapter(list, products,  money);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        // TODO: 09/09/19 add other payments after Fawry integration
        // processing
//        list.add(new Pair<>(R.drawable.ic_visa, R.id.action_paymentMFragment_to_visaActivity));

        // processing
//        list.add(new Pair<>(R.drawable.masary, R.id.action_paymentMFragment_to_amanFragment));
        list.add(new Pair<>(R.drawable.fawry, R.id.action_paymentMFragment_to_fawryFragment));

//        list.add(new Pair<>(R.drawable.accept, R.id.action_paymentMFragment_to_cashCollectionFragment));
//        list.add(new Pair<>(R.drawable.walleticon, R.id.action_paymentMFragment_to_smartWalletFragment));
        // processing
//        list.add(new Pair<>(R.drawable.walleticon, R.id.action_paymentMFragment_to_cashCollectionFragment));

        // processing
//        list.add(new Pair<>(R.drawable.smartwallet, R.id.action_paymentMFragment_to_smartWalletFragment));
//        list.add(new Pair<>(R.drawable.mhfzty, R.id.action_paymentMFragment_to_mhfztyFragment));
        adapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
