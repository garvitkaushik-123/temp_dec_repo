package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;

/* loaded from: classes7.dex */
public abstract class d1 {

    /* renamed from: a, reason: collision with root package name */
    public static int f6550a;

    public static Point a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            return new Point(currentWindowMetrics.getBounds().width(), currentWindowMetrics.getBounds().height());
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static void a(Activity activity, FrameLayout frameLayout) {
        if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
            Insets insets = activity.getWindow().getDecorView().getRootWindowInsets().getInsets(f6550a);
            frameLayout.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        }
    }

    public static void a(Activity activity, FrameLayout frameLayout, boolean z, boolean z2) {
        int navigationBars;
        int i;
        boolean z3;
        int systemUiVisibility;
        if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
            WindowInsetsController windowInsetsController = activity.getWindow().getDecorView().getWindowInsetsController();
            if (windowInsetsController != null) {
                if (z) {
                    i = WindowInsets.Type.navigationBars();
                    navigationBars = 0;
                    z3 = true;
                } else {
                    navigationBars = WindowInsets.Type.navigationBars();
                    i = 0;
                    z3 = false;
                }
                if (z2) {
                    i |= WindowInsets.Type.statusBars();
                    z3 = true;
                } else {
                    navigationBars |= WindowInsets.Type.statusBars();
                }
                if (i != 0) {
                    windowInsetsController.hide(i);
                }
                if (navigationBars != 0) {
                    windowInsetsController.show(navigationBars);
                }
                f6550a = navigationBars;
                windowInsetsController.setSystemBarsBehavior(z3 ? 2 : 1);
            }
            activity.getWindow().setDecorFitsSystemWindows(false);
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (z) {
            systemUiVisibility = decorView.getSystemUiVisibility() | 5894;
        } else {
            systemUiVisibility = decorView.getSystemUiVisibility() & (-5895);
        }
        if (z2) {
            systemUiVisibility |= 1024;
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }
}
