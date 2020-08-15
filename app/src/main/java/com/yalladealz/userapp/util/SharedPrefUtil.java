package com.yalladealz.userapp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.yalladealz.userapp.model.responses.LoginResponse;

import java.lang.ref.WeakReference;

public class SharedPrefUtil {

    @SuppressLint("ApplySharedPref")
    public static void save(Context context, String key, Object value) {
        WeakReference<Context> contextWeakReference = new WeakReference<>(context);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(contextWeakReference.get());

        Editor editor = pref.edit();
        if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof String) {
            editor.putString(key, value.toString());
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }
        editor.apply();
    }

    public static Object getData(Context context, String key, Object defaultValue) {
        WeakReference<Context> contextWeakReference = new WeakReference<>(context);
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(contextWeakReference.get());

        if (defaultValue instanceof String) {
            return pref.getString(key, defaultValue.toString());
        } else if (defaultValue instanceof Integer) {
            return pref.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return pref.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Long) {
            return pref.getLong(key, (Long) defaultValue);
        } else if (defaultValue instanceof Float) {
            return pref.getFloat(key, (Float) defaultValue);
        }


        return defaultValue;

    }

    @SuppressLint("ApplySharedPref")
    public static void remove(Context context, String key) {
        WeakReference<Context> contextWeakReference = new WeakReference<>(context);
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(contextWeakReference.get());

        Editor editor = pref.edit();
        editor.remove(key).apply();

    }

    public static boolean hasKey(Context context, String key) {
        WeakReference<Context> contextWeakReference = new WeakReference<>(context);
        SharedPreferences pref = PreferenceManager.
                getDefaultSharedPreferences(contextWeakReference.get());
        Log.d("preffs", "hasKey: " + pref.getString(key, "no value"));
        return pref.contains(key);

    }


    public static void saveLoginResponse(Context context, LoginResponse loginResponse) {
        WeakReference<Context> contextWeakReference = new WeakReference<>(context);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(contextWeakReference.get());
        Editor editor = preferences.edit();
        Gson gson = new Gson();
        String user = gson.toJson(loginResponse);
        editor.putString("USER", user);
        editor.apply();
    }

    public static LoginResponse getLoginResponse(Context context) {
        WeakReference<Context> contextWeakReference = new WeakReference<>(context);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(contextWeakReference.get());
        Gson gson = new Gson();
        String user = preferences.getString("USER", "");
        return gson.fromJson(user, LoginResponse.class);
    }


}
