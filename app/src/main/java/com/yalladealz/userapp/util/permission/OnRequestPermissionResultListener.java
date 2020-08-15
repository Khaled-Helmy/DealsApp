package com.yalladealz.userapp.util.permission;

public interface OnRequestPermissionResultListener {
    void onGranted();

    void onDenied();

    void onDontAskAgain();
}
