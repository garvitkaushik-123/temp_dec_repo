package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes3.dex */
public class FC {
    public static long eli(float f, float f2) {
        return Float.floatToRawIntBits(f2) | (Float.floatToRawIntBits(f) << 32);
    }

    public static long eli(int i, int i2) {
        return eli(i, i2);
    }
}
