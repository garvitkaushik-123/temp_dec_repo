package com.bytedance.adsdk.ugeno.kb;

/* loaded from: classes3.dex */
public final class Os {
    public static float eli(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static int eli(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long eli(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static double eli(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static boolean eli(String str, boolean z) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException unused) {
            return z;
        }
    }
}
