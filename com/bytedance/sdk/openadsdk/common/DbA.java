package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public class DbA {
    private static String eli;

    public static String eli() {
        return "open_news";
    }

    public static String DbA() {
        return "1371";
    }

    public static String Os() {
        return BuildConfig.VERSION_NAME;
    }

    public static String aGH() {
        return dZ.wC();
    }

    public static String ui() {
        return com.bytedance.sdk.openadsdk.core.FC.DbA().wC();
    }

    public static String MGA() {
        return com.bytedance.sdk.component.utils.nGm.kb(com.bytedance.sdk.openadsdk.core.dV.eli());
    }

    public static String eli(Context context) {
        return com.bytedance.sdk.openadsdk.core.nlS.eli(context);
    }

    public static String kb() {
        if (!TextUtils.isEmpty(eli)) {
            return eli;
        }
        String eli2 = com.bytedance.sdk.openadsdk.core.FC.eli("sdk_app_sha1", 259200000L);
        eli = eli2;
        if (eli(eli2)) {
            return eli;
        }
        String eli3 = com.bytedance.sdk.component.utils.Os.eli(com.bytedance.sdk.openadsdk.core.dV.eli());
        eli = eli3;
        if (eli(eli3)) {
            String upperCase = eli.toUpperCase();
            eli = upperCase;
            com.bytedance.sdk.openadsdk.core.FC.eli("sdk_app_sha1", upperCase);
            return eli;
        }
        return "";
    }

    private static boolean eli(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split(":")) != null && split.length >= 20) {
            for (String str2 : split) {
                if (!"00".equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
