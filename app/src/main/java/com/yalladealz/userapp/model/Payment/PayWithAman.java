package com.yalladealz.userapp.model.Payment;

public class PayWithAman {

    private AmanResponseSource source;
    private String payment_token;

    public AmanResponseSource getSource() {
        return source;
    }

    public void setSource(AmanResponseSource source) {
        this.source = source;
    }

    public String getPayment_token() {
        return payment_token;
    }

    public void setPayment_token(String payment_token) {
        this.payment_token = payment_token;
    }
}
