package com.yalladealz.userapp.util;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

public class GetCurrentLocation {

    private final String TAG = "GetCurrentLocation";
    private Context context;

    public GetCurrentLocation(Context context) {
        this.context = context;
        getDeviceLocation();
    }


    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: get devices current location");

        FusedLocationProviderClient mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);

        try {


                Task location = mFusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.d(TAG, "OnComplete: found location");
                    LogUtil.verbose("foundlocation");
                    if (task.getResult() != null) {
                        Location currentLocation = (Location) task.getResult();

                        if (currentLocation != null) {

                            SharedPrefUtil.save(context, "Latitude", String.valueOf(currentLocation.getLatitude()));
                            SharedPrefUtil.save(context, "Longitude", String.valueOf(currentLocation.getLongitude()));
                        }
                    }
                } else {
                    Log.d(TAG, "OnComplete: current location is null");
                    }
                });

        } catch (SecurityException e) {
            Log.d(TAG, "getLocationServices: SecurityException: " + e.getMessage());
        }
    }
}
