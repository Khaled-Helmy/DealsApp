package com.yalladealz.userapp.model;

public class CashCollection {

    private String user_id;
    private String hash;
    private String session_id;
    private String add_from_wallet;
    private String shipping_address;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getAdd_from_wallet() {
        return add_from_wallet;
    }

    public void setAdd_from_wallet(String add_from_wallet) {
        this.add_from_wallet = add_from_wallet;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }
}
