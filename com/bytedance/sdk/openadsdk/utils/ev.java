package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ev {
    public static boolean eli() {
        if (Build.VERSION.SDK_INT < 33) {
            return Build.VERSION.SDK_INT >= 32 && eli("T", Build.VERSION.CODENAME);
        }
        return true;
    }

    public static boolean eli(String str, String str2) {
        return !"REL".equals(str2) && str2.toUpperCase(Locale.ROOT).compareTo(str.toUpperCase(Locale.ROOT)) >= 0;
    }
}
