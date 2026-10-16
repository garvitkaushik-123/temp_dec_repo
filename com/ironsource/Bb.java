package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Bb extends AbstractC3187m implements Pb, L0, InterfaceC3374x0 {
    private final Eb b;
    private final C3205n0 c;
    private final Lb d;
    private Nb e;
    private LevelPlayAdInfo f;

    public Bb(Eb listener, C3205n0 adTools, Lb nativeAdProperties) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(nativeAdProperties, "nativeAdProperties");
        this.b = listener;
        this.c = adTools;
        this.d = nativeAdProperties;
        this.f = p();
    }

    private final LevelPlayAdInfo p() {
        String uuid = this.d.b().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "nativeAdProperties.adId.toString()");
        String c = this.d.c();
        String ad_unit = this.d.a().toString();
        Intrinsics.checkNotNullExpressionValue(ad_unit, "nativeAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(uuid, c, ad_unit, null, null, null, null, 120, null);
    }

    public final void a(C3402yb nativeAdBinder) {
        Intrinsics.checkNotNullParameter(nativeAdBinder, "nativeAdBinder");
        Nb nb = this.e;
        if (nb == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdUnit");
            nb = null;
        }
        nb.a(new Gb(nativeAdBinder), this);
    }

    @Override // com.ironsource.InterfaceC3374x0
    public void b(IronSourceError ironSourceError) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ironsource.InterfaceC3374x0
    public void f() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ironsource.J0
    public void g() {
        this.b.b(this.f);
    }

    public final void q() {
        this.f = p();
        Nb nb = this.e;
        if (nb == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdUnit");
            nb = null;
        }
        nb.a(true);
    }

    public final void r() {
        Nb a2 = a(this.c, this.d);
        this.e = a2;
        if (a2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdUnit");
            a2 = null;
        }
        a2.a((L0) this);
    }

    private final Nb a(C3205n0 c3205n0, Lb lb) {
        IronLog.INTERNAL.verbose();
        return new Nb(c3205n0, Ob.y.a(lb, o().a()), this);
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo c = adUnitCallback.c();
        if (c != null) {
            this.f = c;
            this.b.a(c);
        }
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.b.onNativeAdLoadFailed(ironSourceError);
    }
}
