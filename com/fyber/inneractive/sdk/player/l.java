package com.fyber.inneractive.sdk.player;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class l {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1620a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[com.fyber.inneractive.sdk.player.enums.a.values().length];
        b = iArr;
        try {
            iArr[com.fyber.inneractive.sdk.player.enums.a.Uninitialized.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[com.fyber.inneractive.sdk.player.enums.a.Started.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[com.fyber.inneractive.sdk.player.enums.a.FirstQuarter.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[com.fyber.inneractive.sdk.player.enums.a.MidPoint.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[com.fyber.inneractive.sdk.player.enums.a.ThirdPQuarter.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[com.fyber.inneractive.sdk.player.enums.a.Completed.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr2 = new int[com.fyber.inneractive.sdk.player.enums.b.values().length];
        f1620a = iArr2;
        try {
            iArr2[com.fyber.inneractive.sdk.player.enums.b.Prepared.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f1620a[com.fyber.inneractive.sdk.player.enums.b.Playing.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f1620a[com.fyber.inneractive.sdk.player.enums.b.Completed.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
