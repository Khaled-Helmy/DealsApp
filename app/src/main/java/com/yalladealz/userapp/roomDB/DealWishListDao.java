package com.yalladealz.userapp.roomDB;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.yalladealz.userapp.model.WishListTable;

import java.util.List;

@Dao
public interface DealWishListDao {

    @Query("Select * from wish_list_table")
    LiveData<List<WishListTable>> getAllWishDeals();

    @Insert
    void addDealToWishList(WishListTable wishListTable);


}
