package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
final class Ja implements InterfaceC3174l3, P2 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3232oa f2918a;

    public Ja(InterfaceC3232oa listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f2918a = listener;
    }

    public void a() {
        this.f2918a.onAdLeftApplication();
    }

    public void b() {
        this.f2918a.n();
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void c(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo c = adUnitCallback.c();
        if (c != null) {
            this.f2918a.onAdLoaded(c);
        }
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void e(IronSourceError ironSourceError) {
        this.f2918a.d(ironSourceError);
    }

    @Override // com.ironsource.J0
    public void g() {
        this.f2918a.onAdClicked();
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void h() {
        this.f2918a.k();
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit i() {
        a();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit j() {
        c();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.P2
    public /* bridge */ /* synthetic */ Unit m() {
        b();
        return Unit.INSTANCE;
    }

    @Override // com.ironsource.InterfaceC3174l3
    public void c(IronSourceError ironSourceError) {
        this.f2918a.onAdLoadFailed(ironSourceError);
    }

    public void c() {
        this.f2918a.l();
    }
}
