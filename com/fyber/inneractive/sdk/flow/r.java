package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class r {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1214a;

    static {
        int[] iArr = new int[UnitDisplayType.values().length];
        f1214a = iArr;
        try {
            iArr[UnitDisplayType.INTERSTITIAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1214a[UnitDisplayType.REWARDED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
