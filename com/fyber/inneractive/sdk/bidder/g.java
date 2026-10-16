package com.fyber.inneractive.sdk.bidder;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1034a;

    static {
        int[] iArr = new int[UnitDisplayType.values().length];
        f1034a = iArr;
        try {
            iArr[UnitDisplayType.BANNER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1034a[UnitDisplayType.INTERSTITIAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1034a[UnitDisplayType.REWARDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1034a[UnitDisplayType.MRECT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
