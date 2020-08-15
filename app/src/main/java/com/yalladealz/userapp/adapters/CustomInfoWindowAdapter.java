package com.yalladealz.userapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatRatingBar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.maps.MarkerCustomInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yalladealz.userapp.util.CommonMethod.fromJsonString;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    @BindView(R.id.info_deal_title)
    TextView infoDealTitle;
    @BindView(R.id.info_deal_distance)
    TextView infoDealDistance;
    @BindView(R.id.info_deal_ratingBar)
    AppCompatRatingBar infoDealRatingBar;
    @BindView(R.id.info_deal_reviews_number)
    TextView infoDealReviewsNumber;
    @BindView(R.id.info_deal_price)
    TextView infoDealPrice;
    @BindView(R.id.info_deal_address)
    TextView infoDealAddress;
    @BindView(R.id.info_deal_category)
    TextView infoDealCategory;
    @BindView(R.id.info_deal_open)
    TextView infoDealOpen;

    private Context context;

    public CustomInfoWindowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
        ButterKnife.bind(this, view);
        MarkerCustomInfo info = fromJsonString(marker.getSnippet());
        infoDealTitle.setText(info.getTitle());
        infoDealDistance.setText(info.getDistance());
        infoDealRatingBar.setRating(Float.parseFloat(info.getRating()));
        infoDealReviewsNumber.setText(info.getReviewsNo());
        infoDealPrice.setText(info.getPrice());
        infoDealAddress.setText(info.getAddress());
        infoDealCategory.setText(info.getCategory());
        infoDealOpen.setText(info.getIsOpen());

        return view;
    }
}
