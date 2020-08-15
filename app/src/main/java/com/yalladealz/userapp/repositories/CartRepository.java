package com.yalladealz.userapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.WishListTable;
import com.yalladealz.userapp.roomDB.AppDatabase;
import com.yalladealz.userapp.roomDB.DealCartDao;
import com.yalladealz.userapp.roomDB.DealWishListDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CartRepository {

    private DealCartDao cartDao;
    private DealWishListDao wishListDao;
    private LiveData<List<CartProduct>> cartProductLiveData;
    private LiveData<List<WishListTable>> wishListData;
    private LiveData<List<Integer>> cartIdList;
    private Executor executor;

    public CartRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);
        cartDao = database.dealCartDao();
        cartProductLiveData = cartDao.getAllCart();
        wishListDao = database.dealWishListDao();
        wishListData = wishListDao.getAllWishDeals();
        cartIdList = cartDao.getCartId();
        executor = Executors.newFixedThreadPool(5);
    }

    public void updateCart(CartProduct cartProduct) {
        executor.execute(() -> cartDao.updateCart(cartProduct));
    }

    public void addToCart(List<CartProduct> cartProducts) {
        executor.execute(() -> cartDao.addToCart(cartProducts));
    }

    public void deleteFromCart(CartProduct cartProduct) {
        executor.execute(() -> cartDao.deleteFromCart(cartProduct));
    }

    public void addToWishList(WishListTable cartProduct) {
        executor.execute(() -> wishListDao.addDealToWishList(cartProduct));
    }

    public LiveData<List<CartProduct>> getCartProductLiveData() {
        return cartProductLiveData;
    }

    public LiveData<List<WishListTable>> getWishListData() {
        return wishListData;
    }

    public LiveData<List<Integer>> getCartIdList() {
        return cartIdList;
    }
}
