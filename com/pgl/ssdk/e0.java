package com.pgl.ssdk;

import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* loaded from: classes6.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f6391a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    private static int f;
    private static int g;
    private static int h;

    public static int a(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                return configuration.touchscreen;
            }
            return 666666;
        } catch (Throwable unused) {
            return 666666;
        }
    }

    private static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f = (int) displayMetrics.density;
            e = displayMetrics.densityDpi;
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            g = (int) displayMetrics.xdpi;
            h = (int) displayMetrics.ydpi;
        } catch (Throwable unused) {
        }
    }

    private static void d(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            f6391a = displayMetrics.widthPixels;
            b = displayMetrics.heightPixels;
            Display.Mode mode = defaultDisplay.getMode();
            c = mode.getPhysicalWidth();
            d = mode.getPhysicalHeight();
        } catch (Throwable unused) {
        }
    }

    public static String e(Context context) {
        int i = -1;
        if (context != null) {
            try {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            } catch (Throwable unused) {
            }
        }
        return String.valueOf(i);
    }

    public static String f(Context context) {
        try {
            d(context);
            b(context);
            c(context);
        } catch (Throwable unused) {
        }
        return e + "[<!>]" + f6391a + "," + b + "[<!>]" + c + VastAttributes.HORIZONTAL_POSITION + d + "[<!>]";
    }
}
