package com.yalladealz.userapp.util.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

public class PermissionManager extends Activity {
    private static final int REQUEST_CODE = 1000;
    private static PermissionManager permissionManager = new PermissionManager();
    private Activity activity;
    private OnRequestPermissionResultListener onRequestPermissionResultListener;
    private OnCheckPermissionListener onCheckPermissionListener;
    private String permission;

    public PermissionManager() {
    }

    public static PermissionManager init(Activity activity) {
        permissionManager.setActivity(activity);

        return permissionManager;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String checkPermission(String permission,
                                  OnCheckPermissionListener onCheckPermissionListener) {

        this.permission = permission;
        this.onCheckPermissionListener = onCheckPermissionListener;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = this.activity.checkSelfPermission(permission);
            if (result == PackageManager.PERMISSION_GRANTED) {
                this.onCheckPermissionListener.onGranted();

                return "Granted";
            } else if (result == PackageManager.PERMISSION_DENIED) {
                if (activity.shouldShowRequestPermissionRationale(permission)) {
                    this.onCheckPermissionListener.onDenied();
                    return "Denied";

                } else {
                    this.onCheckPermissionListener.onDontAskAgain();
                    return "Don't ask Again.";
                }

            } else {
                return null;

            }


        }

        return null;

    }


}
