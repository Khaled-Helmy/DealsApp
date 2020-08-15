package com.yalladealz.userapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.yalladealz.userapp.R;

import static com.yalladealz.userapp.util.ConstantUtil.about_description_array;
import static com.yalladealz.userapp.util.ConstantUtil.about_images_array;
import static com.yalladealz.userapp.util.ConstantUtil.about_title_array;

public class SplashViewPagerAdapter extends PagerAdapter {

    public SplashViewPagerAdapter() {
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_card_wizard, container, false);
        ((TextView) view.findViewById(R.id.title)).setText(about_title_array[position]);
        ((TextView) view.findViewById(R.id.description)).setText(about_description_array[position]);
        ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return about_title_array.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
