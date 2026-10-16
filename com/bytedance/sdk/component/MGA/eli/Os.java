package com.bytedance.sdk.component.MGA.eli;

/* loaded from: classes3.dex */
public class Os {
    public static void eli(Object obj, String str) {
        if (obj == null) {
            eli(str);
        }
    }

    public static void eli(String str) {
        throw new IllegalArgumentException(str);
    }
}
