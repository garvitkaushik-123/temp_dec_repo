package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes3.dex */
public enum MGA {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);

    private final int kb;

    MGA(int i) {
        this.kb = i;
    }

    public int eli() {
        return this.kb;
    }

    public static MGA eli(int i) {
        if (i == 0) {
            return FLEX_START;
        }
        if (i == 1) {
            return CENTER;
        }
        if (i == 2) {
            return FLEX_END;
        }
        if (i == 3) {
            return SPACE_BETWEEN;
        }
        if (i == 4) {
            return SPACE_AROUND;
        }
        if (i == 5) {
            return SPACE_EVENLY;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static MGA eli(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return CENTER;
            case "space_around":
                return SPACE_AROUND;
            case "space_evenly":
                return SPACE_EVENLY;
            case "flex_start":
                return FLEX_START;
            case "space_between":
                return SPACE_BETWEEN;
            case "flex_end":
                return FLEX_END;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
