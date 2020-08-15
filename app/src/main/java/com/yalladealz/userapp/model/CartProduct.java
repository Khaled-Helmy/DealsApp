package com.yalladealz.userapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_cart_product")
public class CartProduct implements Parcelable {

    @ColumnInfo(name = "id")
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo(name = "deal_id")
    private int dealId;

    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "amount")
    private int amount;

    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "priceBefore")
    private double priceBefore;

    @ColumnInfo(name = "cash_on_delivery")
    private String cashOnDelivery;

    public CartProduct(String title, String price, double priceBefore, String imageUrl, int amount) {
        this.title = title;
        this.price = price;
        this.priceBefore = priceBefore;
        this.imageUrl = imageUrl;
        this.amount = amount;
    }

    @Ignore
    public CartProduct(int id, int dealId, String imageUrl, String title, int amount, String price, double priceBefore, String cashOnDelivery) {
        this.id = id;
        this.dealId = dealId;
        this.imageUrl = imageUrl;
        this.title = title;
        this.amount = amount;
        this.price = price;
        this.priceBefore = priceBefore;
        this.cashOnDelivery = cashOnDelivery;
    }

    @Ignore
    public CartProduct() {
    }

    protected CartProduct(Parcel in) {
        id = in.readInt();
        dealId = in.readInt();
        imageUrl = in.readString();
        title = in.readString();
        amount = in.readInt();
        price = in.readString();
        priceBefore = in.readDouble();
        cashOnDelivery = in.readString();
    }

    public static final Creator<CartProduct> CREATOR = new Creator<CartProduct>() {
        @Override
        public CartProduct createFromParcel(Parcel in) {
            return new CartProduct(in);
        }

        @Override
        public CartProduct[] newArray(int size) {
            return new CartProduct[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public double getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(double priceBefore) {
        this.priceBefore = priceBefore;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(String cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(dealId);
        parcel.writeString(imageUrl);
        parcel.writeString(title);
        parcel.writeInt(amount);
        parcel.writeString(price);
        parcel.writeDouble(priceBefore);
        parcel.writeString(cashOnDelivery);
    }
}
