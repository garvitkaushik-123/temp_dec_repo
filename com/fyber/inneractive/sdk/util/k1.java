package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* loaded from: classes4.dex */
public abstract class k1 {
    public static void a(UnitDisplayType unitDisplayType, f1 f1Var, int i, int i2, int i3, int i4) {
        if (i > 0 && i2 > 0) {
            float f = i;
            float f2 = i2;
            float f3 = f / f2;
            if (unitDisplayType == UnitDisplayType.SQUARE) {
                i3 = (int) (i4 * f3);
            } else {
                if (Math.abs(f3 - 1.7777778f) >= 0.1f) {
                    Math.abs(f3 - 1.3333334f);
                }
                float min = Math.min(i3 / f, 10.0f);
                float f4 = i4;
                float f5 = min * f2;
                if (f4 > f5) {
                    i3 = (int) (min * f);
                    i4 = (int) f5;
                } else {
                    float min2 = Math.min(f4 / f2, 10.0f);
                    i3 = (int) (f * min2);
                    i4 = (int) (min2 * f2);
                }
            }
        }
        f1Var.f1758a = i3;
        f1Var.b = i4;
    }
}
