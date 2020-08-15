package com.yalladealz.userapp;

import android.app.Application;
import android.content.res.Resources;

import java.util.Locale;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class CalligraphyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        String deviceLanguage = Resources.getSystem().getConfiguration().locale.getLanguage();

        if (deviceLanguage.equals("en") || deviceLanguage.equals("en-US") || deviceLanguage.equals("en-UK")) {
            ViewPump.init(ViewPump.builder()
                    .addInterceptor(new CalligraphyInterceptor(
                            new CalligraphyConfig.Builder()
                                    .setDefaultFontPath("fonts/english_font.ttf")
                                    .setFontAttrId(R.attr.fontPath)
                                    .build()))
                    .build());

        } else if (Locale.getDefault().getLanguage().equals("ar")) {
            ViewPump.init(ViewPump.builder()
                    .addInterceptor(new CalligraphyInterceptor(
                            new CalligraphyConfig.Builder()
                                    .setDefaultFontPath("fonts/app_font.ttf")
                                    .setFontAttrId(R.attr.fontPath)
                                    .build()))
                    .build());

        }

    }
}
