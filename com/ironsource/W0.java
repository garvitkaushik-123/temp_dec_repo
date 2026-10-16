package com.ironsource;

import com.ironsource.N6;
import com.ironsource.mediationsdk.IronSource;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class W0 {

    /* renamed from: a, reason: collision with root package name */
    public static final W0 f3101a = new W0();

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3102a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3102a = iArr;
        }
    }

    private W0() {
    }

    @JvmStatic
    public static final N6.a a(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        int i = a.f3102a[adUnit.ordinal()];
        if (i == 1) {
            return N6.a.REWARDED_VIDEO;
        }
        if (i == 2) {
            return N6.a.INTERSTITIAL;
        }
        if (i == 3) {
            return N6.a.BANNER;
        }
        if (i == 4) {
            return N6.a.NATIVE_AD;
        }
        throw new NoWhenBranchMatchedException();
    }
}
