package com.yalladealz.userapp.model.responses;

public class ProfileHistoryResponse {

    private String imageUrl;
    private String title;
    private String amount;
    private String price;

    public ProfileHistoryResponse(String title, String price, String imageUrl, String amount){
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.amount = amount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public String getPrice() {
        return price;
    }


}
