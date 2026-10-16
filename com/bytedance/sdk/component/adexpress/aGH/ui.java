package com.bytedance.sdk.component.adexpress.aGH;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class ui {
    public static boolean eli(String str) {
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            return TextUtils.equals(str, "embeded_ad") || TextUtils.equals(str, "banner_ad");
        }
        return false;
    }
}
