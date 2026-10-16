package com.fyber.inneractive.sdk.cache.session.enums;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1051a;

    static {
        int[] iArr = new int[UnitDisplayType.values().length];
        f1051a = iArr;
        try {
            iArr[UnitDisplayType.REWARDED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1051a[UnitDisplayType.MRECT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1051a[UnitDisplayType.BANNER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1051a[UnitDisplayType.INTERSTITIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
