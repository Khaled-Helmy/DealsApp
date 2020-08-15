package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.SerializedName;

public class UserAddressResponse {

    @SerializedName("user_id")
    private long user_id;

    @SerializedName("country")
     private String country;

    @SerializedName("state")
     private String state;


    @SerializedName("city")
     private String city;


    @SerializedName("address")
     private String address;


    @SerializedName("building")
     private String building;


    @SerializedName("apartment")
     private String apartment;

    public UserAddressResponse(long user_id, String country, String state, String city, String address,
                               String building, String apartment) {
        this.user_id = user_id;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.building = building;
        this.apartment = apartment;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
