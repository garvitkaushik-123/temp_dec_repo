package com.fyber.inneractive.sdk.ui;

import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1748a;

    static {
        int[] iArr = new int[IFyberAdIdentifier.Corner.values().length];
        f1748a = iArr;
        try {
            iArr[IFyberAdIdentifier.Corner.TOP_LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1748a[IFyberAdIdentifier.Corner.TOP_RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1748a[IFyberAdIdentifier.Corner.BOTTOM_LEFT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1748a[IFyberAdIdentifier.Corner.BOTTOM_RIGHT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
