package com.bytedance.adsdk.DbA.MGA;

/* loaded from: classes3.dex */
public class DbA {
    private static float eli(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float DbA(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int eli(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float DbA = DbA(((i >> 16) & 255) / 255.0f);
        float DbA2 = DbA(((i >> 8) & 255) / 255.0f);
        float DbA3 = DbA((i & 255) / 255.0f);
        float DbA4 = DbA(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float DbA5 = DbA2 + ((DbA(((i2 >> 8) & 255) / 255.0f) - DbA2) * f);
        float DbA6 = DbA3 + (f * (DbA((i2 & 255) / 255.0f) - DbA3));
        return (Math.round(eli(DbA + ((DbA4 - DbA) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(eli(DbA5) * 255.0f) << 8) | Math.round(eli(DbA6) * 255.0f);
    }
}
