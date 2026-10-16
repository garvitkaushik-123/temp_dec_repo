package com.fyber.inneractive.sdk.config.global.features;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class s {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1090a;

    static {
        int[] iArr = new int[UnitDisplayType.values().length];
        f1090a = iArr;
        try {
            iArr[UnitDisplayType.REWARDED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1090a[UnitDisplayType.INTERSTITIAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
