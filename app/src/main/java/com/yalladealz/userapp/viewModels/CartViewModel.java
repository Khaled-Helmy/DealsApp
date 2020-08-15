package com.yalladealz.userapp.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.WishListTable;
import com.yalladealz.userapp.repositories.CartRepository;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private CartRepository cartRepository;
    private LiveData<List<CartProduct>> cartProductLiveData;
    private LiveData<List<WishListTable>> wishListLiveData;

    public CartViewModel(Application application) {
        super(application);
        cartRepository = new CartRepository(application);
        cartProductLiveData = cartRepository.getCartProductLiveData();
        wishListLiveData = cartRepository.getWishListData();
    }

    public void addToCart(List<CartProduct> cartProducts) {
        cartRepository.addToCart(cartProducts);
    }

    public void deleteFromCart(CartProduct cartProduct) {
        cartRepository.deleteFromCart(cartProduct);
    }

    public LiveData<List<CartProduct>> getCartProductLiveData() {
        return cartProductLiveData;
    }

    public void updateCart(CartProduct cartProduct) {
        cartRepository.updateCart(cartProduct);
    }

    public void addToWishList(WishListTable cartProduct) {
        cartRepository.addToWishList(cartProduct);
    }

    public LiveData<List<WishListTable>> getWishListLiveData() {
        return wishListLiveData;
    }
}
