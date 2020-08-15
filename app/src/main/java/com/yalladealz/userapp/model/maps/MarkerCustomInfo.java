package com.yalladealz.userapp.model.maps;

public class MarkerCustomInfo {

    private String title;
    private String distance;
    private String rating;
    private String reviewsNo;
    private String price;
    private String address;
    private String category;
    private String isOpen;

    public MarkerCustomInfo(String title, String distance, String rating, String reviewsNo, String price, String address, String category, String isOpen) {
        this.title = title;
        this.distance = distance;
        this.rating = rating;
        this.reviewsNo = reviewsNo;
        this.price = price;
        this.address = address;
        this.category = category;
        this.isOpen = isOpen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReviewsNo() {
        return reviewsNo;
    }

    public void setReviewsNo(String reviewsNo) {
        this.reviewsNo = reviewsNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }
}
