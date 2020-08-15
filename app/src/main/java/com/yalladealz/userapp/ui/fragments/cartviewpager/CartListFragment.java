package com.yalladealz.userapp.ui.fragments.cartviewpager;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.HidingScrollListener;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.CartAdapter;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.viewModels.CartViewModel;
import com.yalladealz.userapp.viewModels.FawryViewModel;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.yalladealz.userapp.util.LogUtil.debug;
import static com.yalladealz.userapp.util.LogUtil.verbose;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartListFragment extends Fragment {


    @BindView(R.id.cart_recycler)
    RecyclerView cartRecycler;
    @BindView(R.id.tv_final_price)
    TextView tvFinalPrice;
    @BindView(R.id.ly)
    LinearLayout ly;
    @BindView(R.id.btn_checkout)
    Button btnCheckout;

    private CartViewModel cartViewModel;
    private List<CartProduct> cartProducts;
    private CartAdapter cartAdapter;

    private int amount;


    public CartListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        cartProducts = new ArrayList<>();
        cartAdapter = new CartAdapter(getContext());

        initCartRecycler();
    }

    private void initCartRecycler() {
        cartRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        cartRecycler.setHasFixedSize(true);
        cartRecycler.setAdapter(cartAdapter);
        deleteBySwap();

        cartRecycler.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                ly.animate().alpha(0)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                ly.setVisibility(View.GONE);
                                super.onAnimationEnd(animation);
                            }
                        }).start();
            }

            @Override
            public void onShow() {
                ly.animate().alpha(1)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                ly.setVisibility(View.VISIBLE);
                                super.onAnimationEnd(animation);
                            }
                        }).start();

            }
        });

        if (getArguments() != null) {
            cartViewModel.getCartProductLiveData()
                    .observe(this, cartProducts -> {
                        for (CartProduct product : cartProducts) {
                            // TODO: 15/09/19 add coupon to account
                            cartViewModel.deleteFromCart(product);
                        }
                    });
        } else {
            cartViewModel.getCartProductLiveData()
                    .observe(this, cartProductList -> {
                        verbose("cart product: " + cartProductList.size());
                        verbose("cart product not null");
                        cartAdapter.setProducts(cartProductList);
                        cartProducts = cartProductList;
                        getTotalPrice(cartProducts);
                    });
        }

        cartAdapter.setOnIncrementDecrementClicked(new CartAdapter.onIncrementDecrementClicked() {
            @Override
            public void onIncremenent(int position) {
                CartProduct cartProduct = cartProducts.get(position);
                int amount = cartProduct.getAmount();
                amount++;

                cartProduct.setAmount(amount);
                cartViewModel.updateCart(cartProduct);

                getTotalPrice(cartProducts);

            }

            @Override
            public void onDecrement(int position) {

                CartProduct cartProduct = cartProducts.get(position);
                amount = cartProduct.getAmount();
                if (amount > 1) {
                    amount--;
                    cartProduct.setAmount(amount);
                    cartViewModel.updateCart(cartProduct);
                    getTotalPrice(cartProducts);
                }
            }
        });

    }


    private void getTotalPrice(List<CartProduct> Products) {
        double priceB = 0;
        for (CartProduct cartProduct : Products) {
            Integer price = Integer.parseInt(cartProduct.getPrice());
            Integer amount = cartProduct.getAmount();
            debug("price, amount: " + price + ", " + amount);
            try {
                priceB += price * amount;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (priceB == 0) {
            btnCheckout.setEnabled(false);
        } else {
            btnCheckout.setEnabled(true);
        }
        tvFinalPrice.setText(new DecimalFormat("######.##").format(priceB));
    }

    private void deleteBySwap() {

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                cartViewModel.deleteFromCart(cartProducts.get(position));
                cartAdapter.removeFromCart(position);
            }
        }).attachToRecyclerView(cartRecycler);
    }

    @OnClick(R.id.btn_checkout)
    public void onViewClicked() {
        if (getActivity() != null) {
            try {
                Bundle bundle = new Bundle();

                int money = Integer.parseInt(tvFinalPrice.getText().toString());
                debug("fragment money: " + money);
                bundle.putInt("money", money);
                bundle.putParcelableArrayList("products", (ArrayList<? extends Parcelable>) cartAdapter.getCartProducts());
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                        .navigate(R.id.action_cartFragment_to_navigation, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}