package com.yalladealz.userapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.ar.core.Frame;
import com.google.ar.core.Plane;
import com.google.ar.core.Session;
import com.google.ar.core.TrackingState;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.rendering.FixedWidthViewSizer;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.yalladealz.userapp.ar.DemoUtils;
import com.yalladealz.userapp.model.Branch;
import com.yalladealz.userapp.model.BranchDeal;
import com.yalladealz.userapp.model.responses.BranchLocationResponse;
import com.yalladealz.userapp.viewModels.MapsViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import uk.co.appoly.arcorelocation.LocationMarker;
import uk.co.appoly.arcorelocation.LocationScene;
import uk.co.appoly.arcorelocation.rendering.LocationNode;
import uk.co.appoly.arcorelocation.rendering.LocationNodeRender;
import uk.co.appoly.arcorelocation.utils.ARLocationPermissionHelper;

/**
 * This is a simple example that shows how to create an augmented reality (AR) application using the
 * ARCore and Sceneform APIs.
 */
public class ARActivity extends AppCompatActivity {
    private static final int MAX_DISTANCE = 10000;
    private boolean installRequested;
    private boolean hasFinishedLoading = false;

    private Snackbar loadingMessageSnackbar = null;

    private ArSceneView arSceneView;

    // Renderables for this example
//    private ModelRenderable andyRenderable;
    private ViewRenderable exampleLayoutRenderable;

    // Our ARCore-Location scene
    private LocationScene locationScene;

    private MapsViewModel viewModel;
    private FusedLocationProviderClient fusedLocationProviderClient;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    // CompletableFuture requires api level 24
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar2);
        arSceneView = findViewById(R.id.ar_scene_view);

        viewModel = ViewModelProviders.of(this).get(MapsViewModel.class);
        fusedLocationProviderClient = new FusedLocationProviderClient(this);

        // Build a renderable from a 2D View.
        CompletableFuture<ViewRenderable> exampleLayout =
                ViewRenderable.builder()
                        .setView(this, R.layout.example_layout)
                        .setSizer(new FixedWidthViewSizer(0.5f))
                        .build();

        // When you build a Renderable, Sceneform loads its resources in the background while returning
        // a CompletableFuture. Call thenAccept(), handle(), or check isDone() before calling get().
//        CompletableFuture<ModelRenderable> andy = ModelRenderable.builder()
//                .setSource(this, R.raw.andy)
//                .build();


        CompletableFuture.allOf(
                exampleLayout)
                .handle(
                        (notUsed, throwable) -> {
                            // When you build a Renderable, Sceneform loads its resources in the background while
                            // returning a CompletableFuture. Call handle(), thenAccept(), or check isDone()
                            // before calling get().

                            if (throwable != null) {
                                DemoUtils.displayError(this, "Unable to load renderables", throwable);
                                return null;
                            }

                            try {
                                exampleLayoutRenderable = exampleLayout.get();
//                                andyRenderable = andy.get();
                                hasFinishedLoading = true;

                            } catch (InterruptedException | ExecutionException ex) {
                                DemoUtils.displayError(this, "Unable to load renderables", ex);
                            }

                            return null;
                        });

        // Set an update listener on the Scene that will hide the loading message once a Plane is
        // detected.
        arSceneView
            .getScene()
            .addOnUpdateListener(
                frameTime -> {
                        if (!hasFinishedLoading) {
                            return;
                        }

                        if (locationScene == null) {
                            // If our locationScene object hasn't been setup yet, this is a good time to do it
                            // We know that here, the AR components have been initiated.
                            locationScene = new LocationScene(this, arSceneView);

                            // Now lets create our location markers.
                            // First, a layout
                            fusedLocationProviderClient.getLastLocation()
                                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                                    @Override
                                    public void onSuccess(Location location) {
                                        if (BuildConfig.DEBUG) {
                                            Branch branch = new Branch();
                                            branch.setLocationLongitude(String.valueOf(location.getLongitude()));
                                            branch.setLocationLatitude(String.valueOf(location.getLatitude()));
                                            branch.setBranchAddress("address");
                                            List<Branch> branches = new ArrayList<>();
                                            branches.add(branch);
                                            getBranchesDeals(branches);
                                        } else {
                                            viewModel.getNearByDeals(
                                                    location, MAX_DISTANCE
                                            ).observe(ARActivity.this, branchLocationResponse -> {
                                                if (branchLocationResponse != null) {
                                                    List<Branch> branches = branchLocationResponse.getBrances();
                                                    getBranchesDeals(branches);
                                                }
                                            });
                                        }
                                    }
                                });
                        }

                        Frame frame = arSceneView.getArFrame();
                        if (frame == null) {
                            return;
                        }

                        if (frame.getCamera().getTrackingState() != TrackingState.TRACKING) {
                            return;
                        }

                        if (locationScene != null) {
                            locationScene.processFrame(frame);
                        }

                        if (loadingMessageSnackbar != null) {
                            for (Plane plane : frame.getUpdatedTrackables(Plane.class)) {
                                if (plane.getTrackingState() == TrackingState.TRACKING) {
                                    hideLoadingMessage();
                                }
                            }
                        }
                    });

        // Lastly request CAMERA & fine location permission which is required by ARCore-Location.
        ARLocationPermissionHelper.requestPermission(this);
    }

    private void getBranchesDeals(List<Branch> branches) {
        for (Branch branch : branches) {
            if (BuildConfig.DEBUG) {
                BranchDeal deal = new BranchDeal();
                BranchDeal.OptionDescription optionDescription = new BranchDeal.OptionDescription();
                optionDescription.setOptionName("name");
                BranchDeal.PrimaryOption primaryOption = new BranchDeal.PrimaryOption();
                primaryOption.setOptionDescription(optionDescription);
                primaryOption.setFinalPrice("300");
                deal.setTotalReview(152);
                deal.setPrimaryOption(primaryOption);
                List<BranchDeal> deals = new ArrayList<>();
                deals.add(deal);
                setMarkerData(branch, deals);
            } else {
                viewModel.getBranchDeals(String.valueOf(branch.getBranchId()))
                    .observe(ARActivity.this, new Observer<List<BranchDeal>>() {
                        @Override
                        public void onChanged(List<BranchDeal> branchDeals) {
                            if (branchDeals != null) {
                                setMarkerData(branch, branchDeals);
                            }
                        }
                    });
            }
        }
    }

    private void setMarkerData(Branch branch, List<BranchDeal> branchDeals) {
        for (BranchDeal branchDeal : branchDeals) {
            LocationMarker layoutLocationMarker = new LocationMarker(
                    Double.parseDouble(branch.getLocationLongitude()),
                    Double.parseDouble(branch.getLocationLatitude()),
                    getExampleView()
            );

            // An example "onRender" event, called every frame
            // Updates the layout with the markers distance
            layoutLocationMarker.setRenderEvent(new LocationNodeRender() {
                @Override
                public void render(LocationNode node) {
                    View eView = exampleLayoutRenderable.getView();
                    TextView distanceTextView = eView.findViewById(R.id.info_deal_distance);
                    TextView titleTv = eView.findViewById(R.id.info_deal_title);
                    TextView reviewsTv = eView.findViewById(R.id.info_deal_reviews_number);
                    TextView priceTv = eView.findViewById(R.id.info_deal_price);
                    TextView addressTv = eView.findViewById(R.id.info_deal_address);
                    TextView categoryTv = eView.findViewById(R.id.info_deal_category);

                    distanceTextView.setText(node.getDistance() + " m");
                    titleTv.setText(branchDeal.getPrimaryOption().getOptionDescription().getOptionName());
                    reviewsTv.setText(String.valueOf(branchDeal.getTotalReview()));
                    priceTv.setText(branchDeal.getPrimaryOption().getFinalPrice());
                    addressTv.setText(branch.getBranchAddress());
                    // TODO: 24/09/19
                    categoryTv.setText("Super Market");
                }
            });
            // Adding the marker
            locationScene.mLocationMarkers.add(layoutLocationMarker);
        }
    }

    /**
     * Example node of a layout
     *
     * @return
     */
    @SuppressLint("ClickableViewAccessibility")
    private Node getExampleView() {
        Node base = new Node();
        base.setRenderable(exampleLayoutRenderable);
        Context c = this;
        // Add  listeners etc here
        View eView = exampleLayoutRenderable.getView();
        eView.setOnTouchListener((v, event) -> {
            Toast.makeText(
                    c, "Location marker touched.", Toast.LENGTH_LONG)
                    .show();
            return false;
        });

        return base;
    }

    /**
     * Make sure we call locationScene.resume();
     */
    @Override
    protected void onResume() {
        super.onResume();

        if (locationScene != null) {
            locationScene.resume();
        }

        if (arSceneView.getSession() == null) {
            // If the session wasn't created yet, don't resume rendering.
            // This can happen if ARCore needs to be updated or permissions are not granted yet.
            try {
                Session session = DemoUtils.createArSession(this, installRequested);
                if (session == null) {
                    installRequested = ARLocationPermissionHelper.hasPermission(this);
                    return;
                } else {
                    arSceneView.setupSession(session);
                }
            } catch (UnavailableException e) {
                DemoUtils.handleSessionException(this, e);
            }
        }

        try {
            arSceneView.resume();
        } catch (CameraNotAvailableException ex) {
            DemoUtils.displayError(this, "Unable to get camera", ex);
            finish();
            return;
        }

        if (arSceneView.getSession() != null) {
            showLoadingMessage();
        }
    }

    /**
     * Make sure we call locationScene.pause();
     */
    @Override
    public void onPause() {
        super.onPause();

        if (locationScene != null) {
            locationScene.pause();
        }

        arSceneView.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        arSceneView.destroy();
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] results) {
        if (!ARLocationPermissionHelper.hasPermission(this)) {
            if (!ARLocationPermissionHelper.shouldShowRequestPermissionRationale(this)) {
                // Permission denied with checking "Do not ask again".
                ARLocationPermissionHelper.launchPermissionSettings(this);
            } else {
                Toast.makeText(
                        this, "Camera permission is needed to run this application", Toast.LENGTH_LONG)
                        .show();
            }
            finish();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // Standard Android full-screen functionality.
            getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    private void showLoadingMessage() {
        if (loadingMessageSnackbar != null && loadingMessageSnackbar.isShownOrQueued()) {
            return;
        }

        loadingMessageSnackbar =
                Snackbar.make(
                        findViewById(android.R.id.content),
                        "loading",
                        Snackbar.LENGTH_INDEFINITE);
        loadingMessageSnackbar.getView().setBackgroundColor(0xbf323232);
        loadingMessageSnackbar.show();
    }

    private void hideLoadingMessage() {
        if (loadingMessageSnackbar == null) {
            return;
        }

        loadingMessageSnackbar.dismiss();
        loadingMessageSnackbar = null;
    }
}