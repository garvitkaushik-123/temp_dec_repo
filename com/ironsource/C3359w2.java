package com.ironsource;

import com.ironsource.AbstractC3140j3;
import com.ironsource.Ka;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.w2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3359w2 extends AbstractC3187m implements P2, InterfaceC3174l3, InterfaceC3161k7 {
    private final C3205n0 b;
    private final K2 c;
    private final WeakReference<InterfaceC3376x2> d;
    private LevelPlayAdInfo e;
    private LevelPlayAdInfo f;
    private final AbstractC3140j3 g;

    public C3359w2(InterfaceC3376x2 listener, C3205n0 adTools, K2 bannerAdProperties, X2 bannerViewContainer) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        Intrinsics.checkNotNullParameter(bannerViewContainer, "bannerViewContainer");
        this.b = adTools;
        this.c = bannerAdProperties;
        this.d = new WeakReference<>(listener);
        this.e = r();
        this.f = r();
        this.g = AbstractC3140j3.c.a(adTools, bannerViewContainer, q(), bannerAdProperties, this, p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M2 a(C3359w2 this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.a(this$0.b, this$0.c, z);
    }

    private final O2 p() {
        return new O2() { // from class: com.ironsource.w2$$ExternalSyntheticLambda0
            @Override // com.ironsource.O2
            public final M2 a(boolean z) {
                M2 a2;
                a2 = C3359w2.a(C3359w2.this, z);
                return a2;
            }
        };
    }

    private final AbstractC3140j3.b q() {
        Ka.a d = this.b.d(this.c.c());
        Long j = this.c.j();
        long longValue = j != null ? j.longValue() : d.d();
        Boolean i = this.c.i();
        return new AbstractC3140j3.b(longValue, i != null ? i.booleanValue() : d.f());
    }

    private final LevelPlayAdInfo r() {
        String uuid = this.c.b().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "bannerAdProperties.adId.toString()");
        String c = this.c.c();
        String ad_unit = this.c.a().toString();
        Intrinsics.checkNotNullExpressionValue(ad_unit, "bannerAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(uuid, c, ad_unit, null, null, null, null, 120, null);
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void b() {
        this.g.b();
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void c() {
        this.g.c();
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void d() {
        this.g.d();
    }

    @Override // com.ironsource.InterfaceC3161k7
    public void e() {
        this.g.e();
    }

    @Override // com.ironsource.J0
    public void g() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.d(this.e);
        }
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void h() {
        this.e = this.f;
        this.f = r();
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.b(this.e);
        }
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit i() {
        s();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit j() {
        u();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit m() {
        t();
        return Unit.INSTANCE;
    }

    public void s() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.e(this.e);
        }
    }

    public void t() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.c(this.e);
        }
    }

    public void u() {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            interfaceC3376x2.a(this.e);
        }
    }

    private final M2 a(C3205n0 c3205n0, K2 k2, boolean z) {
        IronLog.INTERNAL.verbose();
        return new M2(c3205n0, N2.z.a(k2, o().a(), z), this);
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void c(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo c = adUnitCallback.c();
        if (c != null) {
            this.f = c;
            InterfaceC3376x2 interfaceC3376x2 = this.d.get();
            if (interfaceC3376x2 != null) {
                interfaceC3376x2.a(c, false);
            }
        }
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void e(IronSourceError ironSourceError) {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            LevelPlayAdInfo levelPlayAdInfo = this.e;
            String uuid = this.c.b().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "bannerAdProperties.adId.toString()");
            interfaceC3376x2.a(levelPlayAdInfo, new LevelPlayAdError(ironSourceError, uuid, this.c.c()));
        }
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void c(IronSourceError ironSourceError) {
        InterfaceC3376x2 interfaceC3376x2 = this.d.get();
        if (interfaceC3376x2 != null) {
            String uuid = this.c.b().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "bannerAdProperties.adId.toString()");
            interfaceC3376x2.a(new LevelPlayAdError(ironSourceError, uuid, this.c.c()));
        }
    }
}
