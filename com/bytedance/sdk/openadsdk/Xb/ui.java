package com.bytedance.sdk.openadsdk.Xb;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

/* loaded from: classes3.dex */
public class ui {
    protected static String DbA = null;
    public static int FC = 4;
    public static int MGA = 0;
    protected static int Os = 1;
    public static int aAs = 8;
    protected static int aGH = 30;
    public static int du = 16;
    protected static String eli = "images";
    public static int kb = 1;
    public static int nlS = 32;
    protected static long ui = 15360;
    public static int wC = 2;

    protected static boolean eli(Context context, String str) {
        return false;
    }

    protected static Bitmap eli(String str) {
        byte[] decode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static boolean eli(Context context, int i) {
        boolean eli2;
        boolean eli3;
        if (MGA == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                eli2 = eli(context, "android.permission.READ_MEDIA_IMAGES");
                eli3 = true;
            } else {
                eli2 = eli(context, "android.permission.READ_EXTERNAL_STORAGE");
                eli3 = eli(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean eli4 = eli(context, "android.permission.CAMERA");
            boolean eli5 = eli(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (eli2 && eli3) {
                MGA |= kb;
            }
            if (eli4 && packageManager.hasSystemFeature("android.hardware.camera")) {
                MGA |= wC;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                MGA |= FC;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                MGA |= aAs;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                MGA |= du;
            }
            if (eli5 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                MGA |= nlS;
            }
        }
        return (MGA & i) != 0;
    }

    public static boolean eli(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z2 = false;
                return !z2 && z;
            }
        }
        z2 = true;
        if (z2) {
        }
    }

    public static boolean DbA(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static float DbA(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }
}
