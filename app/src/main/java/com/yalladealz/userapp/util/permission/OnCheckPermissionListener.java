package com.yalladealz.userapp.util.permission;

public interface OnCheckPermissionListener
        extends OnRequestPermissionResultListener {

    void onDontAskAgain();
}
