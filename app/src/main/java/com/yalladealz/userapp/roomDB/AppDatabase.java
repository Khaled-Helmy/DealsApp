package com.yalladealz.userapp.roomDB;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.WishListTable;


@Database(entities = {WishListTable.class, CartProduct.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract DealWishListDao dealWishListDao();

    public abstract DealCartDao dealCartDao();

    public static AppDatabase getDatabase(Application application) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(application.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


}
