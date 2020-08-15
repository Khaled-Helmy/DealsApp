package com.yalladealz.userapp.ui.fragments;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.SplashViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.CommonMethod.setSystemBarColor;
import static com.yalladealz.userapp.util.CommonMethod.setSystemBarLight;
import static com.yalladealz.userapp.util.ConstantUtil.about_title_array;
import static com.yalladealz.userapp.util.SharedPrefUtil.getData;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreenFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private static final int MAX_STEP = 4;
    @BindView(R.id.splash_view_pager)
    ViewPager viewPager;
    @BindView(R.id.splash_layoutDots)
    LinearLayout layoutDots;
    @BindView(R.id.splash_btn_next)
    Button btnNext;
    private Unbinder unbinder;

    public SplashScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        if (!((Boolean) getData(getContext(), "isFirstRun", true))) {
            Navigation.findNavController(view).navigate(R.id.action_splashScreenFragment_to_homeFragment);
        }

        // adding bottom dots
        bottomProgressDots(0);
        SplashViewPagerAdapter adapter = new SplashViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        viewPager.setClipToPadding(false);
        viewPager.setPadding(0, 0, 0, 0);
        viewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.viewpager_margin_overlap));
        viewPager.setOffscreenPageLimit(4);

        setSystemBarColor(getActivity(), R.color.grey_10);
        setSystemBarLight(getActivity());

        btnNext.setOnClickListener(view1 -> {
            int current = viewPager.getCurrentItem() + 1;
            if (current < MAX_STEP) {
                // move to next screen
                viewPager.setCurrentItem(current);
            } else {
                Navigation.findNavController(view1).navigate(R.id.action_splashScreenFragment_to_homeFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void bottomProgressDots(int current_index) {
        ImageView[] dots = new ImageView[MAX_STEP];

        layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getContext());
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle);
            dots[i].setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
            layoutDots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current_index].setImageResource(R.drawable.shape_circle);
            dots[current_index].setColorFilter(getResources().getColor(R.color.light_green_600), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        bottomProgressDots(position);
    }

    @Override
    public void onPageSelected(int position) {
        if (viewPager.getCurrentItem() == about_title_array.length - 1) {
            btnNext.setText(R.string.get_started);
        } else {
            btnNext.setText(R.string.next);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
