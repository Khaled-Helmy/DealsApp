package com.yalladealz.userapp.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.responses.LowBranchDealResponse;
import com.yalladealz.userapp.remote.RetrofitClient;
import com.yalladealz.userapp.util.GetCurrentLocation;
import com.yalladealz.userapp.util.SharedPrefUtil;

import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NBLService extends Service {
    private boolean mRunning;

    private String title;
    private String text;
    private LatLng userLocation = null;
    private LatLng oldUserLocation = null;
    private boolean isPushNotifications;

    public NBLService() {}
    @Override
    public void onCreate() {
        super.onCreate();
        mRunning = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (!mRunning) {
            mRunning = true;

            runTheService();
        }
        return START_STICKY;
    }

    private void runTheService() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                if (userLocation != null) {
                    oldUserLocation = userLocation;
                }

                new GetCurrentLocation(getApplicationContext());

                if (!SharedPrefUtil.hasKey(getApplicationContext(), "Longitude")) {
                    return;
                }

                userLocation = new LatLng(Double.parseDouble(SharedPrefUtil.getData(getApplicationContext(), "Latitude", "no location").toString())
                        , Double.parseDouble(SharedPrefUtil.getData(getApplicationContext(), "Longitude", "no location").toString()));

                if (oldUserLocation != null) {
                    double distance = SphericalUtil.computeDistanceBetween(userLocation, oldUserLocation);

                    if (distance >= 2000) {
                        isPushNotifications = true;
                    }

                    RetrofitClient.getInstance().getLowestBranch(Double.parseDouble(SharedPrefUtil.getData(getApplicationContext(), "Latitude", "no location").toString())
                            , Double.parseDouble(SharedPrefUtil.getData(getApplicationContext(), "Longitude", "no location").toString()), 25)

                            .enqueue(new Callback<LowBranchDealResponse>() {
                                @Override
                                public void onResponse(@NotNull Call<LowBranchDealResponse> call, @NotNull Response<LowBranchDealResponse> response) {
                                    if (response.isSuccessful()) {
                                        if (response.body() != null) {
                                            LowBranchDealResponse.Deal deal = response.body().getDeal();
                                            if (deal.getDealId() != 0) {
                                                if (isPushNotifications) {
                                                    title = "YallaDealz \n" + deal.getDealName();
                                                    text = "at " + deal.getBranchName() + "\n Price : " + deal.getDealPrice();
                                                    pushNotifications(title, text);
                                                }
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(@NotNull Call<LowBranchDealResponse> call, @NotNull Throwable t) {

                                }
                            });
                }
            }
        };
        timer.schedule(timerTask, 600000, 600000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent cast = new Intent(this, AutoLoadBroadcast.class);
        sendBroadcast(cast);
    }

    private void pushNotifications(String title, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "1")
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(Notification.PRIORITY_MAX);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(0, builder.build());

        isPushNotifications = false;
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "1";
            String description = "12";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
