package com.yalladealz.userapp.ui.fragments;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.github.glomadrian.materialanimatedswitch.MaterialAnimatedSwitch;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.yalladealz.userapp.ARActivity;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.HomeViewPagerAdapter;
import com.yalladealz.userapp.ar.AROldActivity;
import com.yalladealz.userapp.ui.fragments.dealsfragments.BestDealsFragment;
import com.yalladealz.userapp.ui.fragments.dealsfragments.BestReviewDeals;
import com.yalladealz.userapp.ui.fragments.dealsfragments.NewDealsFragment;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.IS_LOGIN;
import static com.yalladealz.userapp.util.SharedPrefUtil.getData;
import static com.yalladealz.userapp.util.SharedPrefUtil.remove;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class HomeFragment extends Fragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.search_location)
    ImageButton searchLocation;
    private Unbinder unbinder;
    @BindView(R.id.language_switch)
    MaterialAnimatedSwitch languageSwitch;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    boolean isLogged;
    FirebaseAuth auth;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        setupViewPager();
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            searchLocation.setVisibility(View.GONE);
        }
        isLogged = (boolean) getData(getContext(), IS_LOGIN, false);
        save(getContext(), "isFirstRun", false);

        auth = FirebaseAuth.getInstance();

        tabLayout.setupWithViewPager(viewPager);

        if (getData(getContext(), "lang", "en").equals("en")) {
            if(languageSwitch.isChecked()) {
                languageSwitch.post(new Runnable() {
                    @Override
                    public void run() {
                        languageSwitch.toggle();
                    }
                });
            }
            appBarLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        } else {
            appBarLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            if(!languageSwitch.isChecked())
                languageSwitch.post(new Runnable() {
                    @Override
                    public void run() {
                        languageSwitch.toggle();
                    }
                });
        }
        languageSwitch.setOnCheckedChangeListener(new MaterialAnimatedSwitch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean b) {
                if (b) {
//                    setLocale("ar-rEG");
                    save(getContext(), "lang", "ar");
                } else {
//                    setLocale("en");
                    save(getContext(), "lang", "en");
                }
//                Toast.makeText(getContext(), "Please restart the application", Toast.LENGTH_SHORT).show();
            }
        });

        searchLocation.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), ARActivity.class);
            startActivity(intent);
        });
    }

    private void setupViewPager() {
        HomeViewPagerAdapter viewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new BestDealsFragment(), getString(R.string.best_deals));
        viewPagerAdapter.addFragment(new NewDealsFragment(), getString(R.string.new_deals));
        viewPagerAdapter.addFragment(new BestReviewDeals(), getString(R.string.best_reviews));

        viewPager.setAdapter(viewPagerAdapter);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.home, menu);
        if (!isLogged) {
            menu.findItem(R.id.action_logout).setVisible(false);
        } else {
            menu.findItem(R.id.action_sign_in).setVisible(false);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            auth.signOut();

            save(getContext(), IS_LOGIN, false);
            remove(getContext(), "ID");
            remove(getContext(), "HASH");
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_homeFragment_to_login_process);
        } else if (item.getItemId() == R.id.action_sign_in) {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_homeFragment_to_login_process);

        }
        return super.onOptionsItemSelected(item);
    }
}
