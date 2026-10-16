package com.ironsource.mediationsdk;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

/* loaded from: classes6.dex */
public class AdapterUtils {
    public static final int MIN_TABLET_DP_SIZE = 600;

    public static int dpToPixels(Context context, int i) {
        if (context != null) {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils dpToPixels - context is null, returning dpSize", 3);
        return i;
    }

    public static String getScreenSizeParams(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        float min = Math.min(displayMetrics.widthPixels / f2, f / f2);
        float f3 = displayMetrics.xdpi;
        float f4 = displayMetrics.widthPixels / f3;
        float f5 = displayMetrics.heightPixels / displayMetrics.ydpi;
        return "smallestWidth = " + min + " diagonalInches = " + Math.sqrt((f4 * f4) + (f5 * f5)) + " smallScreenDpApi =  " + context.getResources().getConfiguration().smallestScreenWidthDp;
    }

    public static boolean isLargeScreen(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils isLargeScreen - context is null", 3);
        return false;
    }
}
