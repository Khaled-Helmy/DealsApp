package com.yalladealz.userapp.ui.viewHolders;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.core.util.Pair;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.ui.activities.VisaActivity;
import com.yalladealz.userapp.util.Constant;
import com.yalladealz.userapp.util.SharedPrefUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.ID;
import static com.yalladealz.userapp.util.LogUtil.debug;

public class PaymentMViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.methodItem)
    RelativeLayout methodItem;

    @BindView(R.id.methodImage)
    ImageView methodImage;

    private Context context;
    private Pair<Integer, Integer> item;
    private int money;
    private ArrayList<CartProduct> products;

    public PaymentMViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(Pair<Integer, Integer> item, ArrayList<CartProduct> products, int money, Context context) {
        this.context = context;
        this.item = item;
        this.money = money;
        this.products = products;
        methodImage.setImageResource(item.first);
    }

    @OnClick(R.id.methodItem)
    void onClick(View view) {

        // Check if the user login or not
        debug(String.valueOf(SharedPrefUtil.hasKey(context, ID)));
        debug(String.valueOf(SharedPrefUtil.getData(context, ID, "")));
//        if (SharedPrefUtil.hasKey(context, ID)) {
            Bundle bundle = new Bundle();
            bundle.putInt("money", money);
            bundle.putParcelableArrayList("products", products);
            if (item.second == R.id.action_paymentMFragment_to_cashCollectionFragment) {
                boolean legalForCash = false; //if at least one product can be delivered
                // put it in the bundle
                ArrayList<CartProduct> deliveryProducts = new ArrayList<>();
                for (CartProduct product : products) {
                    if (product.getCashOnDelivery().equals("true")) {
                        legalForCash = true;
                        deliveryProducts.add(product);
                    }
                }
                CharSequence[] methods;
                if (legalForCash) {
                    methods = new CharSequence[]{"VISA", "CASH"};
                } else {
                    methods = new CharSequence[]{"VISA"};
                    Toast.makeText(context, "You can't use Cash on delivery for these products", Toast.LENGTH_SHORT).show();
                }
                new AlertDialog.Builder(context)
                        .setItems(methods, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                Navigation.findNavController(view).navigate(item.second, bundle);

                                switch (which) {
                                    case 0: //visa
                                        Navigation.findNavController((Activity) context, R.id.nav_host_fragment)
                                                .navigate(R.id.action_paymentMFragment_to_acceptFragment, bundle);
                                        break;
//                                    case 1: //wallet
//                                        Navigation.findNavController((Activity) context, R.id.nav_host_fragment)
//                                                .navigate(R.id.action_paymentMFragment_to_smartWalletFragment, bundle);
//                                        break;
                                    case 1: //cash
                                        bundle.putParcelableArrayList("products", deliveryProducts);
                                        Navigation.findNavController((Activity) context, R.id.nav_host_fragment)
                                                .navigate(R.id.action_paymentMFragment_to_cashCollectionFragment, bundle);
                                        break;
                                }
                            }
                        }).create().show();
            } else {
                Navigation.findNavController(view).navigate(item.second, bundle);
            }
//        } else {
//            Navigation.findNavController(view).navigate(R.id.login_process);
//        }
    }
}
