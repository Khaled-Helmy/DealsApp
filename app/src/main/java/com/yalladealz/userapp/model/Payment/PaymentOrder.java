package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentOrder {

    @SerializedName("auth_token")
    @Expose
    private String authToken;
    @SerializedName("delivery_needed")
    @Expose
    private String deliveryNeeded;
    @SerializedName("merchant_id")
    @Expose
    private String merchantId;
    @SerializedName("amount_cents")
    @Expose
    private String amountCents;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("merchant_order_id")
    @Expose
    private int merchantOrderId;
    @SerializedName("items")
    @Expose
    private List<Object> items = null;
    @SerializedName("shipping_data")
    @Expose
    private PaymentShippingData shippingData;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getDeliveryNeeded() {
        return deliveryNeeded;
    }

    public void setDeliveryNeeded(String deliveryNeeded) {
        this.deliveryNeeded = deliveryNeeded;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(String amountCents) {
        this.amountCents = amountCents;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(int merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public PaymentShippingData getShippingData() {
        return shippingData;
    }

    public void setShippingData(PaymentShippingData shippingData) {
        this.shippingData = shippingData;
    }

}
