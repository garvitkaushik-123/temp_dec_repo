package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes3.dex */
public enum wC {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    private final int aGH;

    wC(int i) {
        this.aGH = i;
    }

    public static wC eli(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
