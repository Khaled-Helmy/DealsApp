package com.yalladealz.userapp.model.responses;

public class PhotoResponse {
    private String name ;
    private String IMG_URL ;

    public PhotoResponse(String name, String IMG_URL) {
        this.name = name;
        this.IMG_URL = IMG_URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIMG_URL() {
        return IMG_URL;
    }

    public void setIMG_URL(String IMG_URL) {
        this.IMG_URL = IMG_URL;
    }
}
