package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.n1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3206n1 implements InterfaceC3223o1 {

    /* renamed from: a, reason: collision with root package name */
    private final IronSource.AD_UNIT f3595a;

    /* renamed from: com.ironsource.n1$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3596a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3596a = iArr;
        }
    }

    public C3206n1(IronSource.AD_UNIT adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.f3595a = adFormat;
    }

    @Override // com.ironsource.InterfaceC3223o1
    public InterfaceC3240p1 a(InterfaceC3155k1 eventBaseData) {
        Intrinsics.checkNotNullParameter(eventBaseData, "eventBaseData");
        int i = a.f3596a[this.f3595a.ordinal()];
        if (i == 1) {
            return new C3349v9(eventBaseData);
        }
        if (i == 2) {
            return new Fd(eventBaseData);
        }
        if (i == 3) {
            return new S2(eventBaseData);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + this.f3595a);
    }
}
