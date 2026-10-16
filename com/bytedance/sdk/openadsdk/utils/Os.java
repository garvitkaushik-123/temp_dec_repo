package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: classes3.dex */
public class Os {
    public static int eli = -1;

    public static int eli(Context context, int i, int i2) {
        int round;
        int eli2 = eli(context, i2);
        if (eli2 == -1) {
            return eli;
        }
        int min = Math.min(90, Math.round(eli2 * 0.15f));
        if (i > 655) {
            round = Math.round((i / 728.0f) * 90.0f);
        } else if (i > 632) {
            round = 81;
        } else if (i > 526) {
            round = Math.round((i / 468.0f) * 60.0f);
        } else {
            round = i > 432 ? 68 : Math.round((i / 320.0f) * 50.0f);
        }
        return Math.max(Math.min(round, min), 50);
    }

    public static int eli(Context context, int i) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context != null) {
            try {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null && (configuration = resources.getConfiguration()) != null) {
                    int i2 = configuration.orientation;
                    if (i == 0) {
                        i = i2;
                    }
                    if (i == i2) {
                        return Math.round(displayMetrics.heightPixels / displayMetrics.density);
                    }
                    return Math.round(displayMetrics.widthPixels / displayMetrics.density);
                }
            } catch (Throwable unused) {
                return eli;
            }
        }
        return eli;
    }
}
