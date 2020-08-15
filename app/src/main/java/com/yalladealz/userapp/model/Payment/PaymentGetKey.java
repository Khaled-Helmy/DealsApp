package com.yalladealz.userapp.model.Payment;

public class PaymentGetKey {

    private String auth_token;
    private String amount_cents;
    private int expiration;
    private String order_id;
    private BuildingData billing_data;
    private String currency;
    private int integration_id;
    private boolean lock_order_when_paid;

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getAmount_cents() {
        return amount_cents;
    }

    public void setAmount_cents(String amount_cents) {
        this.amount_cents = amount_cents;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public BuildingData getBilling_data() {
        return billing_data;
    }

    public void setBilling_data(BuildingData billing_data) {
        this.billing_data = billing_data;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getIntegration_id() {
        return integration_id;
    }

    public void setIntegration_id(int integration_id) {
        this.integration_id = integration_id;
    }

    public boolean isLock_order_when_paid() {
        return lock_order_when_paid;
    }

    public void setLock_order_when_paid(boolean lock_order_when_paid) {
        this.lock_order_when_paid = lock_order_when_paid;
    }
}
