package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1135a;

    static {
        int[] iArr = new int[UnitDisplayType.values().length];
        f1135a = iArr;
        try {
            iArr[UnitDisplayType.INTERSTITIAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1135a[UnitDisplayType.BANNER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1135a[UnitDisplayType.MRECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1135a[UnitDisplayType.REWARDED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
