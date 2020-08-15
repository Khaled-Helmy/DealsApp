package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderResponse {

    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("delivery_needed")
    @Expose
    private boolean deliveryNeeded;
    @SerializedName("merchant")
    @Expose
    private VisaMerchant merchant;
    @SerializedName("collector")
    @Expose
    private Object collector;
    @SerializedName("amount_cents")
    @Expose
    private int amountCents;
    @SerializedName("shipping_data")
    @Expose
    private PaymentShippingData shippingData;
    @SerializedName("shipping_details")
    @Expose
    private Object shippingDetails;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("is_payment_locked")
    @Expose
    private boolean isPaymentLocked;
    @SerializedName("is_return")
    @Expose
    private boolean isReturn;
    @SerializedName("is_cancel")
    @Expose
    private boolean isCancel;
    @SerializedName("is_returned")
    @Expose
    private boolean isReturned;
    @SerializedName("is_canceled")
    @Expose
    private boolean isCanceled;
    @SerializedName("merchant_order_id")
    @Expose
    private String merchantOrderId;
    @SerializedName("wallet_notification")
    @Expose
    private Object walletNotification;
    @SerializedName("paid_amount_cents")
    @Expose
    private int paidAmountCents;
    @SerializedName("notify_user_with_email")
    @Expose
    private boolean notifyUserWithEmail;
    @SerializedName("items")
    @Expose
    private List<Object> items = null;
    @SerializedName("order_url")
    @Expose
    private String orderUrl;
    @SerializedName("commission_fees")
    @Expose
    private int commissionFees;
    @SerializedName("delivery_fees_cents")
    @Expose
    private int deliveryFeesCents;
    @SerializedName("delivery_vat_cents")
    @Expose
    private int deliveryVatCents;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("merchant_staff_tag")
    @Expose
    private Object merchantStaffTag;
    @SerializedName("api_source")
    @Expose
    private String apiSource;
    @SerializedName("pickup_data")
    @Expose
    private Object pickupData;
    @SerializedName("delivery_status")
    @Expose
    private List<Object> deliveryStatus = null;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("url")
    @Expose
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getDeliveryNeeded() {
        return deliveryNeeded;
    }

    public void setDeliveryNeeded(boolean deliveryNeeded) {
        this.deliveryNeeded = deliveryNeeded;
    }

    public VisaMerchant getMerchant() {
        return merchant;
    }

    public void setMerchant(VisaMerchant merchant) {
        this.merchant = merchant;
    }

    public Object getCollector() {
        return collector;
    }

    public void setCollector(Object collector) {
        this.collector = collector;
    }

    public int getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(int amountCents) {
        this.amountCents = amountCents;
    }

    public PaymentShippingData getShippingData() {
        return shippingData;
    }

    public void setShippingData(PaymentShippingData shippingData) {
        this.shippingData = shippingData;
    }

    public Object getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(Object shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean getIsPaymentLocked() {
        return isPaymentLocked;
    }

    public void setIsPaymentLocked(boolean isPaymentLocked) {
        this.isPaymentLocked = isPaymentLocked;
    }

    public boolean getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(boolean isReturn) {
        this.isReturn = isReturn;
    }

    public boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(boolean isCancel) {
        this.isCancel = isCancel;
    }

    public boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Object getWalletNotification() {
        return walletNotification;
    }

    public void setWalletNotification(Object walletNotification) {
        this.walletNotification = walletNotification;
    }

    public int getPaidAmountCents() {
        return paidAmountCents;
    }

    public void setPaidAmountCents(int paidAmountCents) {
        this.paidAmountCents = paidAmountCents;
    }

    public boolean getNotifyUserWithEmail() {
        return notifyUserWithEmail;
    }

    public void setNotifyUserWithEmail(boolean notifyUserWithEmail) {
        this.notifyUserWithEmail = notifyUserWithEmail;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public int getCommissionFees() {
        return commissionFees;
    }

    public void setCommissionFees(int commissionFees) {
        this.commissionFees = commissionFees;
    }

    public int getDeliveryFeesCents() {
        return deliveryFeesCents;
    }

    public void setDeliveryFeesCents(int deliveryFeesCents) {
        this.deliveryFeesCents = deliveryFeesCents;
    }

    public int getDeliveryVatCents() {
        return deliveryVatCents;
    }

    public void setDeliveryVatCents(int deliveryVatCents) {
        this.deliveryVatCents = deliveryVatCents;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Object getMerchantStaffTag() {
        return merchantStaffTag;
    }

    public void setMerchantStaffTag(Object merchantStaffTag) {
        this.merchantStaffTag = merchantStaffTag;
    }

    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    public Object getPickupData() {
        return pickupData;
    }

    public void setPickupData(Object pickupData) {
        this.pickupData = pickupData;
    }

    public List<Object> getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(List<Object> deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
