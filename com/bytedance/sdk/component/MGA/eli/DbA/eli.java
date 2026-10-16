package com.bytedance.sdk.component.MGA.eli.DbA;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.eli.ui;
import com.bytedance.sdk.component.MGA.eli.wC;

/* loaded from: classes3.dex */
public class eli {
    public static long eli(int i, Context context) {
        return DbA(i, context);
    }

    private static long DbA(int i, Context context) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long maxMemory = (runtime.maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - (runtime.totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        if (maxMemory <= 0) {
            if (freeMemory <= 2) {
                return 1L;
            }
            if (freeMemory <= 10) {
                return Math.min(i, 10);
            }
            return Math.min((freeMemory / 2) * 10, i);
        }
        long j = ((freeMemory + maxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        if (j <= 10) {
            return Math.min(i, 10);
        }
        return Math.min(j * 10, i);
    }

    public static boolean eli() {
        ui aGH = wC.kb().aGH();
        return (aGH == null || TextUtils.isEmpty(aGH.eli())) ? false : true;
    }

    public static boolean DbA() {
        ui aGH = wC.kb().aGH();
        return (aGH == null || TextUtils.isEmpty(aGH.DbA())) ? false : true;
    }

    public static boolean Os() {
        ui aGH = wC.kb().aGH();
        return (aGH == null || TextUtils.isEmpty(aGH.aGH())) ? false : true;
    }

    public static boolean aGH() {
        ui aGH = wC.kb().aGH();
        return (aGH == null || TextUtils.isEmpty(aGH.ui())) ? false : true;
    }

    public static boolean ui() {
        ui aGH = wC.kb().aGH();
        return (aGH == null || TextUtils.isEmpty(aGH.Os())) ? false : true;
    }

    public static boolean MGA() {
        ui aGH = wC.kb().aGH();
        return (aGH == null || TextUtils.isEmpty(aGH.MGA())) ? false : true;
    }
}
