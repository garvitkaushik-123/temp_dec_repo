package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class nlS {
    public static void eli(String str) {
        eli("any_door_id", str);
    }

    public static String eli() {
        return DbA("any_door_id", null);
    }

    private static void eli(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli((String) null, str, str2);
        } catch (Throwable unused) {
        }
    }

    private static String DbA(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
