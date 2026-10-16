package com.bytedance.sdk.openadsdk.utils;

import java.lang.ref.SoftReference;

/* loaded from: classes3.dex */
public class DbA {
    private static Boolean DbA;
    public static SoftReference<com.bytedance.sdk.openadsdk.core.model.ev> eli;

    public static boolean eli() {
        try {
            if (DbA == null) {
                boolean z = true;
                if (com.bytedance.sdk.openadsdk.bf.eli.eli("enable_get_ad_new", 0) != 1) {
                    z = false;
                }
                DbA = Boolean.valueOf(z);
            }
            return DbA.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static com.bytedance.sdk.openadsdk.core.model.ev DbA() {
        SoftReference<com.bytedance.sdk.openadsdk.core.model.ev> softReference = eli;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar == null) {
            return;
        }
        eli = new SoftReference<>(evVar);
    }
}
