package com.unity3d.player;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import java.io.File;
import java.util.Locale;

/* loaded from: classes7.dex */
class DeviceInfo {
    DeviceInfo() {
    }

    public static String getSystemLanguage() {
        return Locale.getDefault().toString();
    }

    public static String getLocaleList(Context context) {
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < locales.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(locales.get(i).toString());
        }
        return sb.toString();
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static long getTotalSpace(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null || !cacheDir.exists()) {
            return -1L;
        }
        return Math.round(cacheDir.getTotalSpace() / 1024);
    }

    public static long getSystemBootTime() {
        return (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000;
    }
}
