package com.yalladealz.userapp.roomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yalladealz.userapp.model.CartProduct;

import java.util.List;

@Dao
public interface DealCartDao {

    @Insert
    void addToCart(List<CartProduct> products);

    @Query("SELECT * FROM table_cart_product")
    LiveData<List<CartProduct>> getAllCart();

    @Update
    void updateCart(CartProduct cartProduct);

    @Delete
    void deleteFromCart(CartProduct cartProduct);

    @Query("SELECT deal_id FROM table_cart_product")
    LiveData<List<Integer>> getCartId();


}
