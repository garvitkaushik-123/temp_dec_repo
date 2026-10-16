package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class FC {
    private static volatile Handler eli;

    public static Handler eli() {
        return com.bytedance.sdk.component.wC.eli.eli.eli().DbA();
    }

    public static Handler DbA() {
        if (eli == null) {
            synchronized (FC.class) {
                if (eli == null) {
                    eli = new Handler(Looper.getMainLooper());
                }
            }
        }
        return eli;
    }
}
