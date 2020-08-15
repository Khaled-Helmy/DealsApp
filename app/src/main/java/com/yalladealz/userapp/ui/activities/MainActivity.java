package com.yalladealz.userapp.ui.activities;

import android.Manifest;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.facebook.FacebookSdk;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.roomDB.AppDatabase;
import com.yalladealz.userapp.service.NBLService;
import com.yalladealz.userapp.ui.fragments.HomeFragment;
import com.yalladealz.userapp.util.AppRater;
import com.yalladealz.userapp.util.CameraPermissionHelper;
import com.yalladealz.userapp.util.ConstantUtil;
import com.yalladealz.userapp.util.GetCurrentLocation;
import com.yalladealz.userapp.util.SharedPrefUtil;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

import static com.yalladealz.userapp.util.SharedPrefUtil.getData;
import static com.yalladealz.userapp.util.SharedPrefUtil.hasKey;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class MainActivity extends AppCompatActivity implements

        NavController.OnDestinationChangedListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.nav_view)
    BottomNavigationView navView;

    boolean isLogged;

    // Set to true ensures requestInstall() triggers installation if necessary.
    public static boolean mLocationPermissionsGranted = false;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale((String) getData(this, "lang", "en"));
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // First run check
        if (!hasKey(this, "isFirstRun")) {
            save(this, "isFirstRun", true);
        }

        isLogged = (boolean) getData(this, ConstantUtil.SharedPrefUtilKeys.IS_LOGIN, false);
        if (!isLogged) {

            navView.getMenu().findItem(R.id.nav_userProfileFragment).setVisible(false);
        } else {
            navView.getMenu().findItem(R.id.nav_userProfileFragment).setVisible(true);
        }


//        checkArSupport();

        AppRater.launchTracker(this);

        FacebookSdk.setApplicationId("232332534303433");

        //TODO: check for deprecation - hassan
        //Facebook SDK now is initialized automatically on application start
//        FacebookSdk.sdkInitialize(this);

        getPermission();
        startNotificationService();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
        navController.addOnDestinationChangedListener(this);
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
//        Intent refresh = new Intent(getContext(), MainActivity.class);
//        getActivity().finish();
//        startActivity(refresh);
    }

    private void getPermission() {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionsGranted = true;
                } else {
                    ActivityCompat.requestPermissions(this, permissions, 1);
                }
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissions, 1);
        }
    }

//    //TODO: finish ARCore implementation - requires minSdk = 24 - Hazem
//
//    // ARCore implementation
//    void checkArSupport() {
//        ArCoreApk.Availability availability = ArCoreApk.getInstance().checkAvailability(this);
//        if (availability.isTransient()) {
//            // Re-query at 5Hz while compatibility is checked in the background.
//            new Handler().postDelayed(this::checkArSupport, 200);
//        }
//        if (availability.isSupported()) {
//            //TODO: handle
//        } else { // Unsupported or unknown.
//            //TODO: handle
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] results) {

        String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if
            (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;

                new GetCurrentLocation(this);

            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissions, 1);
        }


        // FIXME: 14/09/19 get camera realtime permission
//        if (CameraPermissionHelper.hasCameraPermission(this)) {
//            Toast.makeText(this, "Camera permission is needed to run this application", Toast.LENGTH_LONG)
//                    .show();
//            if (!CameraPermissionHelper.shouldShowRequestPermissionRationale(this)) {
//                // Permission denied with checking "Do not ask again".
//                CameraPermissionHelper.launchPermissionSettings(this);
//            }
//            finish();
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstance();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }


    @Override
    public void onDestinationChanged(@NonNull NavController controller
            , @NonNull NavDestination destination, @Nullable Bundle arguments) {
        switch (destination.getId()) {
            case R.id.nav_loginFragment:
                hideBottomNavigationView();
                break;
            case R.id.nav_registerFragment:
                hideBottomNavigationView();
                break;
            case R.id.nav_splashScreenFragment:
                hideBottomNavigationView();
                break;
            default:
                navView.setVisibility(View.VISIBLE);
        }
    }

    private void hideBottomNavigationView() {
        if (navView.getVisibility() == View.VISIBLE) {
            navView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private void startNotificationService() {

        NBLService nblService = new NBLService();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(new Intent(this, nblService.getClass()));
        } else {
            startService(new Intent(this, nblService.getClass()));
        }
        startService(new Intent(this, nblService.getClass()));

    }

    @Override
    protected void onStart() {
        super.onStart();

        // Check if user didn't use application for one week
        Long timeNow = System.currentTimeMillis();
        Long lastLogin = (Long) SharedPrefUtil.getData(MainActivity.this, "loginExpiration", timeNow);

        timeNow = timeNow - lastLogin;

        if (timeNow >= 604800000) {
            Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
                    .navigate(R.id.nav_loginFragment);
        } else {
            save(MainActivity.this, "loginExpiration", System.currentTimeMillis());
        }
    }
}
