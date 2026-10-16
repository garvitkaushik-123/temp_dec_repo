package com.ironsource;

import com.ironsource.InterfaceC3293s4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ma, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3198ma extends AbstractC3187m implements P2, InterfaceC3232oa, InterfaceC3161k7 {
    private final C3205n0 b;
    private final K2 c;
    private final WeakReference<InterfaceC3376x2> d;
    private LevelPlayAdInfo e;
    private final InterfaceC3215na f;

    public C3198ma(InterfaceC3376x2 listener, C3205n0 adTools, K2 bannerAdProperties, X2 bannerViewContainer) {
        InterfaceC3215na a2;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        Intrinsics.checkNotNullParameter(bannerViewContainer, "bannerViewContainer");
        this.b = adTools;
        this.c = bannerAdProperties;
        this.d = new WeakReference<>(listener);
        this.e = q();
        a2 = Ka.f2926a.a(adTools, bannerViewContainer, adTools.d(bannerAdProperties.c()), bannerAdProperties, this, p(), (r17 & 64) != 0 ? new InterfaceC3293s4.a() : null);
        this.f = a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M2 a(C3198ma this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.a(this$0.b, this$0.c, z);
    }

    private final O2 p() {
        return new O2() { // from class: com.ironsource.ma$$ExternalSyntheticLambda0
            @Override // com.ironsource.O2
            public final M2 a(boolean z) {
                M2 a2;
                a2 = C3198ma.a(C3198ma.this, z);
                return a2;
            }
        };
    }

    private final LevelPlayAdInfo q() {
        String uuid = this.c.b().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "bannerAdProperties.adId.toString()");
        String c = this.c.c();
        String ad_unit = this.c.a().toString();
        Intrinsics.checkNotNullExpressionValue(ad_unit, "bannerAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(uuid, c, ad_unit, null, null, null, null, 120, null);
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void b() {
        this.f.b();
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void c() {
        this.f.c();
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void d() {
        this.f.d();
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void e() {
        this.f.e();
    }

    @Override // com.ironsource.J0
    public void g() {
        onAdClicked();
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit i() {
        r();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit j() {
        t();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void k() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.b(this.e);
        }
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void l() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.a(this.e);
        }
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit m() {
        s();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void n() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.c(this.e);
        }
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void onAdClicked() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.d(this.e);
        }
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void onAdLeftApplication() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.e(this.e);
        }
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void onAdLoadFailed(IronSourceError ironSourceError) {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            String uuid = this.c.b().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "bannerAdProperties.adId.toString()");
            interfaceC3376x2.a(new LevelPlayAdError(ironSourceError, uuid, this.c.c()));
        }
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.e = adInfo;
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.a(adInfo, false);
        }
    }

    public void r() {
        onAdLeftApplication();
    }

    public void s() {
        n();
    }

    public void t() {
        l();
    }

    private final M2 a(C3205n0 c3205n0, K2 k2, boolean z) {
        IronLog.INTERNAL.verbose();
        return new M2(c3205n0, N2.z.a(k2, o().a(), z), this);
    }

    @Override // com.ironsource.InterfaceC3232oa
    public void d(IronSourceError ironSourceError) {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            LevelPlayAdInfo levelPlayAdInfo = this.e;
            String uuid = this.c.b().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "bannerAdProperties.adId.toString()");
            interfaceC3376x2.a(levelPlayAdInfo, new LevelPlayAdError(ironSourceError, uuid, this.c.c()));
        }
    }
}
