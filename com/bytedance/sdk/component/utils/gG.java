package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class gG {
    private static volatile String eli;

    public static String eli() {
        if (!TextUtils.isEmpty(eli)) {
            return eli;
        }
        String str = Build.MODEL;
        eli = str;
        return str;
    }
}
