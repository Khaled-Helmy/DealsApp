package com.yalladealz.userapp.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.maps.MarkerCustomInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class CommonMethod {
    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void showAlert(String message, Activity context) {

        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("Ok", (dialog, id) -> {

                }).setIcon(R.drawable.ic_delete).show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE);

    }

    public static void setSystemBarColor(Activity act, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }

    public static void setSystemBarLight(Activity act) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View view = act.findViewById(android.R.id.content);
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
        }
    }

    public static List<String> readJsonFile(Context context) {
        String stringJson;
        JSONArray citiesNames;
        List<String> cities = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open("cities.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            stringJson = new String(buffer, StandardCharsets.UTF_8);

            try {
                JSONObject jsonObject = new JSONObject(stringJson);
                citiesNames = jsonObject.names();
                if (citiesNames != null) {
                    for (int i = 0; i < citiesNames.length(); i++) {
                        cities.add(citiesNames.getString(i));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return cities;
    }

    public static List<String> getSupCities(Context context, String cityName) {
        String stringJson;
        JSONArray citiesNames;
        List<String> cities = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open("cities.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            stringJson = new String(buffer, StandardCharsets.UTF_8);

            try {
                JSONObject jsonObject = new JSONObject(stringJson);
                citiesNames = jsonObject.getJSONArray(cityName);
                for (int i = 0; i < citiesNames.length(); i++) {
                    cities.add(citiesNames.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return cities;
    }

    public static void replaceFragment(FragmentManager manager, int containerId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void replaceFragmentWithBundle(FragmentManager manager, int containerId, Fragment fragment, String key, String data) {
        Bundle args = new Bundle();
        args.putString(key, data);
        fragment.setArguments(args);
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void showToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void requestLocationPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{ACCESS_FINE_LOCATION}, 1);
    }

    public static void showSelectionAlert(Context context, ArrayList<String> array, String title, OnSingleChoiseItem listener) {
        String[] items = array.toArray(new String[array.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setSingleChoiceItems(items, -1, (dialogInterface, i) -> {
            listener.onItemSingleItemSelected(items[i], i);
            dialogInterface.dismiss();

        });

        builder.show();

    }

    public interface OnSingleChoiseItem {
        void onItemSingleItemSelected(String selectedItem, int pos);
    }

    public static String fromMarkerCustomInfo(MarkerCustomInfo markerCustomInfo) {
        if (markerCustomInfo == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<MarkerCustomInfo>() {
        }.getType();
        return gson.toJson(markerCustomInfo, type);
    }

    public static MarkerCustomInfo fromJsonString(String json) {
        if (json == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<MarkerCustomInfo>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public static void snackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();

    }

    public static void shareTwitter(String message, Context context) {
        Intent tweetIntent = new Intent(Intent.ACTION_SEND);
        tweetIntent.putExtra(Intent.EXTRA_TEXT, "This is a Test.");
        tweetIntent.setType("text/plain");

        PackageManager packManager = context.getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for (ResolveInfo resolveInfo : resolvedInfoList) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name);
                resolved = true;
                break;
            }
        }
        if (resolved) {
            context.startActivity(tweetIntent);
        } else {
            Intent i = new Intent();
            i.putExtra(Intent.EXTRA_TEXT, message);
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode(message)));
            context.startActivity(i);
            Toast.makeText(context, "Twitter app isn't found", Toast.LENGTH_LONG).show();
        }
    }

    private static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.wtf("Common Method", "UTF-8 should always be supported", e);
            return "";
        }
    }
}
