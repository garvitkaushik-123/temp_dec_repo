package com.bytedance.adsdk.ugeno.MGA;

import java.util.Collection;

/* loaded from: classes3.dex */
public class aGH {
    public static int eli(boolean z, int i, int i2) {
        if (i2 == 0 || !z) {
            return i;
        }
        int i3 = i - 512;
        int abs = Math.abs(i3) % i2;
        return (i3 >= 0 || abs == 0) ? abs : i2 - abs;
    }

    public static boolean eli(int i, Collection<?> collection) {
        return i >= 0 && i < collection.size();
    }
}
