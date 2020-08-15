package com.yalladealz.userapp.ui.activities;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yalladealz.userapp.BuildConfig;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.DealOptionsAdapter;
import com.yalladealz.userapp.adapters.ProductImageAdapter;
import com.yalladealz.userapp.adapters.ReviewsAdapter;
import com.yalladealz.userapp.interfaces.OptionItemListener;
import com.yalladealz.userapp.model.CartProduct;
import com.yalladealz.userapp.model.WishListTable;
import com.yalladealz.userapp.model.deals.Deal;
import com.yalladealz.userapp.model.deals.DealFilesItem;
import com.yalladealz.userapp.model.deals.DealReviewItem;
import com.yalladealz.userapp.model.deals.MerchantBranch;
import com.yalladealz.userapp.model.deals.OptionDescription;
import com.yalladealz.userapp.model.deals.PrimaryOption;
import com.yalladealz.userapp.ui.fragments.GalleryFragment;
import com.yalladealz.userapp.util.ConstantUtil;
import com.yalladealz.userapp.util.PermissionUtils;
import com.yalladealz.userapp.viewModels.CartViewModel;
import com.yalladealz.userapp.viewModels.DealViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

import static com.yalladealz.userapp.util.CommonMethod.shareTwitter;
import static com.yalladealz.userapp.util.CommonMethod.showToast;
import static com.yalladealz.userapp.util.ConstantUtil.DEAL_ID;
import static com.yalladealz.userapp.util.ConstantUtil.DEAL_IMAGE;
import static com.yalladealz.userapp.util.ConstantUtil.OPTION_ID;
import static com.yalladealz.userapp.util.LogUtil.debug;
import static com.yalladealz.userapp.util.LogUtil.verbose;
import static com.yalladealz.userapp.util.SharedPrefUtil.getData;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class DealsDetailsActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    @BindView(R.id.no_review_empty_view)
    TextView noReviewEmptyView;
    @BindView(R.id.tv_quantity)
    TextView tvQuantity;
    String maxBuy;
    String minBuy;
    int deal_id;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.product_tv)
    TextView productTv;
    @BindView(R.id.shop_name_tv)
    TextView shopNameTv;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.finalPrice)
    TextView finalPrice;
    @BindView(R.id.discount)
    TextView discount;
    @BindView(R.id.product_card)
    CardView productCard;
    @BindView(R.id.images_recycler)
    RecyclerView imagesRecycler;
    @BindView(R.id.recycler_card)
    CardView recyclerCard;
    @BindView(R.id.product_desc_tv)
    TextView productDescTv;
    @BindView(R.id.description_card)
    CardView descriptionCard;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView nestedScrollView;
    @BindView(R.id.buttons_card)
    CardView buttonsCard;
    boolean isButtonCardHide = false;
    @BindView(R.id.reviews_recycler)
    RecyclerView reviewsRecycler;
    @BindView(R.id.bt_add_to_wishlist)
    AppCompatButton btAddToWishlist;
    @BindView(R.id.bt_add_to_cart)
    AppCompatButton btAddToCart;
    @BindView(R.id.parent_view)
    RelativeLayout parentView;
    @BindView(R.id.youtube_fragment_container)
    LinearLayout youtubeFragmentContainer;
    @BindView(R.id.gallery_viewpager)
    ViewPager viewPager;
    @BindView(R.id.deal_appCompatRatingBar)
    AppCompatRatingBar ratingBar;
    @BindView(R.id.distance)
    TextView distanctTv;
    @BindView(R.id.mapView)
    MapView mapView;
    @BindView(R.id.viewMap_btn)
    TextView viewMapBtn;
    @BindView(R.id.product_options_recycler)
    RecyclerView optionsRv;

    String lat, log;

    String optionId;
    private CartProduct cartProduct;
    private ProductImageAdapter imageAdapter;
    private YouTubePlayerFragment youTubePlayerFragment;
    private CartViewModel cartViewModel;
    String imageUrl;
    private ReviewsAdapter reviewsAdapter;
    private String priceFinal;
    private int dealId;
    //    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    private DealViewModel dealViewModel;
    private WishListTable wishListTable;
    private String cashOnDelivery;

	DealOptionsAdapter optionsAdapter;

	private List<String> optionsPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals_details);
        ButterKnife.bind(this);
        optionsPrices = new ArrayList<>();

        dealViewModel = ViewModelProviders.of(this)
                .get(DealViewModel.class);

        cartViewModel = ViewModelProviders.of(this)
                .get(CartViewModel.class);

        wishListTable = new WishListTable();
        reviewsAdapter = new ReviewsAdapter();

        mapView.onCreate(savedInstanceState);

        MapsInitializer.initialize(this);

        updatButtonText();
        updateCartButtonText();
        initDealImages();
        initDealReviewsRecycler();


        deal_id = Integer.parseInt(getData(this, DEAL_ID, 0).toString());
        int option_id = Integer.parseInt(getData(this, OPTION_ID, 0).toString());

        getSingleDealData(deal_id, option_id);

        hideAddToCartView();

    }

    private void getUserLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
        || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, LOCATION_PERMISSION_REQUEST_CODE);

        } else {
            getFusedLocation();
        }
    }

    private void getFusedLocation() {
        // Access to the location has been granted to the app.
        FusedLocationProviderClient fusedLocationProviderClient = new FusedLocationProviderClient(this);
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        debug("location- lat: " + location.getLatitude());
                        debug("location- long: " + location.getLongitude());
                        double far = distFrom(Float.parseFloat(lat), Float.parseFloat(log),
                                (float) location.getLatitude(), (float)location.getLongitude());
                        debug("" + far);
                        distanctTv.setText(String.format("%.2f km", far));
                    }
                });
    }

    public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return (float) ((earthRadius * c)/1000);
    }

    private void initDealReviewsRecycler() {
        reviewsRecycler.setLayoutManager(new LinearLayoutManager(this));
        reviewsRecycler.setHasFixedSize(true);
        reviewsRecycler.setAdapter(reviewsAdapter);
    }

    private void initDealImages() {
        imagesRecycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        imagesRecycler.setHasFixedSize(true);
        imageAdapter = new ProductImageAdapter(this);
        imagesRecycler.setAdapter(imageAdapter);


    }

    private void getSingleDealData(int deal_id, int option_id) {
        dealViewModel.getSingleDeal(deal_id, option_id)
                .observe(this, deal -> {
                    displayDealData(deal);
                    List<DealReviewItem> dealReview = deal.getDealReview();
                    if (dealReview == null || dealReview.size() == 0) {
                        noReviewEmptyView.setVisibility(View.VISIBLE);
                        reviewsRecycler.setVisibility(View.GONE);
                    } else {
                        reviewsAdapter.setReviewItems(dealReview);
                        noReviewEmptyView.setVisibility(View.GONE);
                    }

                    populateOptions(deal);
                });
    }

    private void populateOptions(Deal deal) {
	    optionsAdapter = new DealOptionsAdapter(this);
	    optionsRv.setHasFixedSize(true);
	    optionsRv.setAdapter(optionsAdapter);
	    optionsRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
	    optionsAdapter.setOptions(deal.getDealOptions());
	    optionsAdapter.setItemListener(new OptionItemListener() {
            @Override
            public void onOptionItemSelected(String itemPrice) {
                debug("itemPrice: " + itemPrice);
                optionsPrices.add(itemPrice);
            }

            @Override
            public void onOptionItemUnselected(String itemPrice) {
                optionsPrices.remove(itemPrice);
            }
        });
    }

    private void displayDealData(Deal deal) {
        optionId = deal.getPrimaryOption().getOptionDescription().getOptionId();
        priceFinal = deal.getPrimaryOption().getFinalPrice();
        imageUrl = deal.getDealFiles().get(0).getFileName();
        wishListTable.setImageUrl(imageUrl);
        minBuy = deal.getMinBuy();
        maxBuy = deal.getMaxBuy();
//        imageUrl = deal.getImage();
        dealId = deal.getDealId();
        cashOnDelivery = deal.getCashOnDelivery();

        lat = deal.getBranchLat();
        log = deal.getBranchLong();
        debug("latt: " + lat);
        if(lat == null || lat.equals("")) lat = String.valueOf(0.0);
        if(log == null || log.equals("")) log = String.valueOf(0.0);

        String name = deal.getPrimaryOption().getOptionDescription().getOptionName();
        save(DealsDetailsActivity.this, "title", name);
        String totalPrice = deal.getPrimaryOption().getFinalPrice();
        save(DealsDetailsActivity.this, "price", totalPrice);
        List<MerchantBranch> branches = deal.getMerchantInfo().getMerchantBranches();
        String branchString = new Gson().toJson(branches, new TypeToken<List<MerchantBranch>>(){}.getType());
        save(DealsDetailsActivity.this, "branches", branchString);
        String rating = String.valueOf(deal.getTotalReview()/10);
        save(DealsDetailsActivity.this, "rating", rating);
        String totalReviews = String.valueOf(deal.getDealReview().size());
        save(DealsDetailsActivity.this, "total_reviews", totalReviews);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // TODO: 18/09/19
                // title: PrimaryOption -> OptionDescription -> option_name
                // price: PrimaryOption -> final_price
                // locations: MerchantInfo -> MerchantBranch -> location
                // rating bar: total_review / 10
                // review number: DealReview.size()
                // address: MerchantInfo -> MerchantBranch -> branch_address


                LatLng latLng = new LatLng(Double.parseDouble(lat),
                        Double.parseDouble(log));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                googleMap.addMarker(
                        new MarkerOptions()
                        .position(latLng)
                );
                viewMapBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        save(DealsDetailsActivity.this, "lat", String.valueOf(latLng.latitude));
                        save(DealsDetailsActivity.this, "long", String.valueOf(latLng.longitude));
                        startActivity(
                                new Intent(
                                        DealsDetailsActivity.this,
                                        MapsActivity.class
                                )
                        );
                    }
                });
            }
        });

        getUserLocation();

        ratingBar.setRating(deal.getTotalReview());
        productDescTv.setText(Html.fromHtml(deal.getDealDescription().getDealDescription()));
        productTv.setText(Html.fromHtml(deal.getDealDescription().getDealName()));
        price.setText(String.format("%s%s", deal.getPrimaryOption().getOriginalPrice(), getString(R.string.pound)));
        this.finalPrice.setText(String.format("%s %s", priceFinal, getString(R.string.pound)));
        discount.setText(String.format("%s%%", deal.getPrimaryOption().getDealDiscount()));
        shopNameTv.setText(deal.getMerchantInfo().getMerchantName());
        List<DealFilesItem> dealFiles = deal.getDealFiles();

        ArrayList<String> images = new ArrayList<>();
        String TAG = "galleryFragm";
        for (int i = 0; i < dealFiles.size(); i++) {
            String image = DEAL_IMAGE + dealFiles.get(i).getFileName();
            Log.d(TAG, "displayDealData: " + image);
            images.add(image);
        }
        Log.d(TAG, "getSingleDealData: " + images.size());
        viewPager.setAdapter(
                new GalleryFragment.GalleryPager(getSupportFragmentManager(), 1, images)
        );
//        viewPager.setCurrentItem(0);

        if (dealFiles.size() > 1) {
            imageAdapter.setItems(dealFiles);
        } else {
            recyclerCard.setVisibility(View.GONE);

        }
        imageAdapter.setClickListener((item, pos) -> {
            if (item.getFileType().equals("image")) {
                youtubeFragmentContainer.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
                Glide.with(getApplicationContext())
                        .load(DEAL_IMAGE + item.getFileName())
                        .into(image);
                viewPager.setCurrentItem(pos);
            }

        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                viewPager.setVisibility(View.VISIBLE);

            }
        });
        String imagePath = dealFiles.get(0).getFileName();
        String fileType = dealFiles.get(0).getFileType();
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        String youtubeLink = deal.getYoutubeLink();
        if (!youtubeLink.equals("") && youtubeLink != null) {
            if (youtubeLink.contains("youtu")) {
                youtubeFragmentContainer.setVisibility(View.VISIBLE);
                image.setVisibility(View.GONE);
                String[] splittedLink = youtubeLink.split("/");
                String link = null;
                if (splittedLink.length >= 3) {
                    link = splittedLink[3];
                    initYoutubeFragment(link);
                }

            } else {
                youtubeFragmentContainer.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
                if (imagePath != null && fileType.equals("image")) {
                    Glide.with(this)
                            .load(DEAL_IMAGE + imagePath).into(image);
                    youtubeFragmentContainer.setVisibility(View.GONE);
                    image.setVisibility(View.VISIBLE);
                }
            }

        } else {
            youtubeFragmentContainer.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            if (imagePath != null && fileType.equals("image")) {
                Glide.with(this)
                        .load(DEAL_IMAGE + imagePath).into(image);
                youtubeFragmentContainer.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getVisibility() == View.VISIBLE) {
            viewPager.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    private void hideAddToCartView() {
        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
//            if (scrollY < oldScrollY) {
//                animateView(true);
//            }
//
//            if (scrollY > oldScrollY) {
//                animateView(false);
//            }
            buttonsCard.setVisibility(View.GONE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!nestedScrollView.canScrollVertically(-1)) {
                        buttonsCard.setVisibility(View.GONE);
                    } else if (!nestedScrollView.canScrollVertically(1)) {
                        buttonsCard.setVisibility(View.GONE);
                    } else {
                        buttonsCard.setVisibility(View.VISIBLE);
                    }
                }
            }, 1000);
        });
    }

    private void initYoutubeFragment(String link) {
        verbose("youtube id: " + link);
        youTubePlayerFragment = (YouTubePlayerFragment)
                getFragmentManager().findFragmentById(R.id.youtube_fragment);
        youTubePlayerFragment.initialize(ConstantUtil.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    youTubePlayer.loadVideo(link);

                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {

            }

        });
    }


    private void animateView(boolean hide) {
        if (hide) {
            buttonsCard.animate().alpha(0).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    buttonsCard.setVisibility(View.GONE);
                    super.onAnimationEnd(animation);
                }
            }).start();


        } else {
            buttonsCard.animate().alpha(1).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    buttonsCard.setVisibility(View.VISIBLE);
                    super.onAnimationEnd(animation);
                }
            }).start();
        }
    }

    @OnClick(R.id.facebook_btn)
    public void onFacebookBtnClicked() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.yalladealz.com/deal/" + deal_id))
                .setShareHashtag(new ShareHashtag.Builder().setHashtag("#yallaDealz").build())
                .build();

        ShareDialog shareDialog = new ShareDialog(this);
        shareDialog.show(content, ShareDialog.Mode.AUTOMATIC);
    }

    @OnClick(R.id.twitter_btn)
    public void onTwitterBtnClicked() {
        shareTwitter("https://www.yalladealz.com/deal/" + deal_id, this);
    }

    @OnClick(R.id.bt_add_to_wishlist)
    public void onBtAddToWishlistClicked() {
        wishListTable.setDealname(productTv.getText().toString());
        wishListTable.setFinalPrice(priceFinal);
        wishListTable.setDealDiscount(discount.getText().toString());
        wishListTable.setOptionId(Integer.parseInt(optionId));
        wishListTable.setDealId(dealId);
        cartViewModel.addToWishList(wishListTable);
    }

    @OnClick(R.id.bt_add_to_cart)
    public void onBtAddToCartClicked() {
        debug(String.valueOf(optionsPrices.size()));
        List<CartProduct> products = new ArrayList<>();
        if (optionsPrices.size() == 0) {
            Toast.makeText(this, "Please select deal option(s)", Toast.LENGTH_SHORT).show();
        } else {
            for (String price : optionsPrices) {
                cartProduct = new CartProduct();
                cartProduct.setImageUrl(imageUrl);
                cartProduct.setAmount(1);
                cartProduct.setTitle(productTv.getText().toString());
                cartProduct.setCashOnDelivery(cashOnDelivery);
                cartProduct.setPrice(price);
                products.add(cartProduct);
            }
            cartViewModel.addToCart(products);
        }
    }

    private void updatButtonText() {
        cartViewModel.getCartProductLiveData().observe(this, cartProductList -> {
            if (cartProductList.size() == 0) {
                return;
            }

            btAddToCart.setText(String.format(Locale.ENGLISH, "%d deal(s) in your cart.",
                    cartProductList.size()));
        });
    }


    private void updateCartButtonText() {
        cartViewModel.getWishListLiveData().observe(this, wishListTables -> {
            if (wishListTables.size() == 0) {
                return;
            }

            btAddToWishlist.setText(String.format(Locale.ENGLISH, "%d deals(s) in your wish list", wishListTables.size()));
        });

    }


    @OnClick(R.id.btn_whatsapp)
    public void onWhatsAppShare() {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "https://www.yalladealz.com/deal/" + deal_id);
        try {
            startActivity(whatsappIntent);
        } catch (ActivityNotFoundException ex) {
            showToast("Whatsapp have not been installed.", this);
        }
    }

    @OnClick({R.id.minus_btn, R.id.add_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.minus_btn:
                sub();
                break;
            case R.id.add_btn:
                add();
                break;
        }
    }

    private void add() {
        int quantity = Integer.parseInt(tvQuantity.getText().toString());
        if (quantity < 10) {
            quantity++;
            tvQuantity.setText(String.format(Locale.ENGLISH, "%d", quantity));
        }
    }

    private void sub() {
        int quantity = Integer.parseInt(tvQuantity.getText().toString());
        if (quantity > 1) {
            quantity--;
            tvQuantity.setText(String.format(Locale.ENGLISH, "%d", quantity));
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)
        && PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_COARSE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            getFusedLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            Toast.makeText(this, "Please grant location permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
