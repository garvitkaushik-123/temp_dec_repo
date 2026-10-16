package com.bytedance.sdk.openadsdk.utils;

/* loaded from: classes3.dex */
public class Xb {
    public static int eli() {
        try {
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 33554432);
            if (maxMemory <= 2) {
                return 2;
            }
            if (maxMemory >= 5) {
                return 5;
            }
            return maxMemory;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
