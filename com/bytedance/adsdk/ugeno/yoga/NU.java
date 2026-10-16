package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes3.dex */
public enum NU {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);

    private final int aGH;

    NU(int i) {
        this.aGH = i;
    }

    public int eli() {
        return this.aGH;
    }

    public static NU eli(int i) {
        if (i == 0) {
            return STATIC;
        }
        if (i == 1) {
            return RELATIVE;
        }
        if (i == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static NU eli(String str) {
        str.hashCode();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
