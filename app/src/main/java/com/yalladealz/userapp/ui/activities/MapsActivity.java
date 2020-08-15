package com.yalladealz.userapp.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.CustomInfoWindowAdapter;
import com.yalladealz.userapp.model.BranchDeal;
import com.yalladealz.userapp.model.deals.MerchantBranch;
import com.yalladealz.userapp.model.maps.MarkerCustomInfo;
import com.yalladealz.userapp.util.PermissionUtils;
import com.yalladealz.userapp.viewModels.MapsViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.yalladealz.userapp.util.CommonMethod.fromMarkerCustomInfo;
import static com.yalladealz.userapp.util.LogUtil.debug;
import static com.yalladealz.userapp.util.SharedPrefUtil.getData;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class MapsActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleMap.OnInfoWindowClickListener {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final String TAG = MapsActivity.class.getSimpleName();
    private GoogleMap mMap;
    private boolean mPermissionDenied = false;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private List<LatLng> locations = new ArrayList<>();
    private List<MarkerCustomInfo> markerCustomInfos = new ArrayList<>();
    private CustomInfoWindowAdapter adapter;
    private MapsViewModel mapsViewModel;
    private List<MerchantBranch> branches = new ArrayList<>();

    String title;
    String totalPrice;
    String rating;
    String totalReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapsViewModel = ViewModelProviders.of(this).get(MapsViewModel.class);
        fusedLocationProviderClient = new FusedLocationProviderClient(this);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_activity_fragment);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        adapter = new CustomInfoWindowAdapter(this);

//        LatLng latLng = new LatLng(
//                Double.parseDouble((String) getData(this, "lat", "0")),
//                Double.parseDouble((String) getData(this, "long", "0"))
//        );
//        locations.add(latLng);

        String branchesS = (String) getData(this,
                "branches",
                "");
        branches = new Gson().fromJson(branchesS, new TypeToken<List<MerchantBranch>>(){}.getType());

        title = (String) getData(this, "title", "");
        totalPrice = (String) getData(this, "price", "");
        rating = (String) getData(this, "rating", "");
        totalReviews = (String) getData(this, "total_reviews", "");

    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(locations.get(0)));
        mMap.setOnMarkerClickListener(this);
//        mMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        mMap.setBuildingsEnabled(false);
//        mMap.setIndoorEnabled(false);
//        mMap.setTrafficEnabled(false);
//        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.google_map_style));
//        mMap.setMaxZoomPreference(20f);
//        mMap.setMinZoomPreference(12f);
        enableMyLocation();
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            addCustomMarkers(location);

                            int i=0;
                            for (LatLng loc : locations) {
//                                Location location1 = new Location("");
//                                location1.setLatitude(loc.latitude);
//                                location1.setLongitude(loc.longitude);
//                                if (location.distanceTo(location1) < 10000) {
                                    String snippet = fromMarkerCustomInfo(markerCustomInfos.get(i++));
                                    MarkerOptions markerOptions = new MarkerOptions();
                                    markerOptions.position(loc)
//                                            .title("Test Deal Title")
                                            .snippet(snippet)
                                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.fav));
                                    mMap.setInfoWindowAdapter(adapter);
                                    mMap.setOnInfoWindowClickListener(this);
                                    mMap.addMarker(markerOptions).showInfoWindow();
                                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 20f));
//                                }
                            }
                            Log.d(TAG, "enableMyLocation: " + location.getLatitude() + ", " + location.getLongitude());
//                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
//                            mapsViewModel.getNearByBranches(location, 10000).observe(this, this::putDealsMarkersOnMap);
                        }
                    });
        }
    }

    private void addCustomMarkers(Location location) {
        MarkerCustomInfo markerCustomInfo;
        for (MerchantBranch branch : branches) {
            String lat = branch.getLocationLatitude();
            String log = branch.getLocationLongitude();
            Location location1 = new Location("");
            location1.setLatitude(Double.parseDouble(lat));
            location1.setLongitude(Double.parseDouble(log));
            float kilos = location.distanceTo(location1) / 1000;
            markerCustomInfo = new MarkerCustomInfo(title,
                    String.valueOf(kilos) + " km",
                    rating,
                    totalReviews + " Reviews",
                    totalPrice + " EGP",
                    branch.getBranchAddress(),
                    "Supermarket",
                    "Open");
            locations.add(
                    new LatLng(location1.getLatitude(),
                            location1.getLongitude())
            );
            markerCustomInfos.add(markerCustomInfo);
        }
    }

    //TODO: implement - waiting for API - Hazem
    private void putDealsMarkersOnMap(List<BranchDeal> branchDeals) {
//        for (BranchDeal branchDeal : branchDeals) {
//            LatLng latLng = new LatLng()
//        }
//
//
//
//        for (LatLng loc : locations) {
//            Location location1 = new Location("");
//            location1.setLatitude(loc.latitude);
//            location1.setLongitude(loc.longitude);
//            if (location1.distanceTo() < 10000) {
//                String snippet = fromMarkerCustomInfo(markerCustomInfo);
//                MarkerOptions markerOptions = new MarkerOptions();
//                markerOptions.position(loc)
//                        .title("Test Deal Title")
//                        .snippet(snippet)
//                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fav));
//                mMap.setInfoWindowAdapter(adapter);
//                mMap.setOnInfoWindowClickListener(this);
//                mMap.addMarker(markerOptions).showInfoWindow();
//            }
//        }
    }

//    @Override
//    public boolean onMyLocationButtonClick() {
//        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
//        // Return false so that we don't consume the event and the default behavior still occurs
//        // (the camera animates to the user's current position).
//        return false;
//    }

//    @Override
//    public void onMyLocationClick(@NonNull Location location) {
//        Toast.makeText(this, "Current location:\n" + location.getLatitude() + " " + location.getLongitude(), Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        debug(marker.getPosition().toString());
        marker.showInfoWindow();
        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        //TODO: click handling - needs data from API - Hazem
        save(this, "deal_id", 2);
        save(this, "option_id", 32);
        startActivity(new Intent(this, DealsDetailsActivity.class));

    }
}
