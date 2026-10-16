package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.t3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3309t3 implements InterfaceC3037d1 {

    /* renamed from: a, reason: collision with root package name */
    private final U3 f3841a;
    private final C3167kd b;
    private final IronSource.AD_UNIT c;

    /* renamed from: com.ironsource.t3$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3842a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3842a = iArr;
        }
    }

    public C3309t3(U3 adFormatConfigurations, C3167kd c3167kd, IronSource.AD_UNIT adFormat) {
        Intrinsics.checkNotNullParameter(adFormatConfigurations, "adFormatConfigurations");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.f3841a = adFormatConfigurations;
        this.b = c3167kd;
        this.c = adFormat;
    }

    @Override // com.ironsource.InterfaceC3037d1
    public InterfaceC3062e9 a(InterfaceC3100gd providerName) {
        NetworkSettings b;
        Gd f;
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        C3167kd c3167kd = this.b;
        if (c3167kd == null || (b = c3167kd.b(providerName.value())) == null) {
            return null;
        }
        int i = a.f3842a[this.c.ordinal()];
        if (i == 1) {
            V2 c = this.f3841a.c();
            if (c != null) {
                return new C2985a3(new C3000b1(b, b.getBannerSettings(), this.c), c);
            }
            return null;
        }
        if (i != 2) {
            if (i == 3 && (f = this.f3841a.f()) != null) {
                return new C3319td(new C3000b1(b, b.getRewardedVideoSettings(), this.c), f);
            }
            return null;
        }
        C3366w9 d = this.f3841a.d();
        if (d != null) {
            return new C3417z9(new C3000b1(b, b.getInterstitialSettings(), this.c), d);
        }
        return null;
    }
}
