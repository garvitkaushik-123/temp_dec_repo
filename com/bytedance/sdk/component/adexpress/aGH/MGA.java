package com.bytedance.sdk.component.adexpress.aGH;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class MGA {
    public static boolean eli(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean DbA(String str) {
        return com.bytedance.sdk.component.adexpress.aGH.DbA() && eli(str);
    }
}
