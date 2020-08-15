package com.yalladealz.userapp.ar.model;

import android.location.Location;

public class ARPoint {
    private Location location;
    private String name;

    public ARPoint(String name, double lat, double lon, double altitude) {
        this.name = name;
        location = new Location("ARPoint");
        location.setLatitude(lat);
        location.setLongitude(lon);
        location.setAltitude(altitude);
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ARPoint{" +
                "location=" + location +
                ", name='" + name + '\'' +
                '}';
    }
}
