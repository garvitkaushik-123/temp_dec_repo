package com.fyber.inneractive.sdk.dv.handler;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1140a;

    static {
        int[] iArr = new int[UnitDisplayType.values().length];
        f1140a = iArr;
        try {
            iArr[UnitDisplayType.BANNER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1140a[UnitDisplayType.MRECT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1140a[UnitDisplayType.REWARDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
