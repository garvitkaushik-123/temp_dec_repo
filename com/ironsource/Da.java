package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Da implements InterfaceC3215na {

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f2827a;
    private final X2 b;
    private final O2 c;
    private InterfaceC3232oa d;
    private Ia e;
    private M2 f;
    private final L0 g;
    private final InterfaceC3374x0 h;
    private final P2 i;

    public static final class a implements P2 {
        a() {
        }

        public void a() {
            InterfaceC3232oa m = Da.this.m();
            if (m != null) {
                m.onAdLeftApplication();
            }
        }

        public void b() {
            InterfaceC3232oa m = Da.this.m();
            if (m != null) {
                m.n();
            }
        }

        public void c() {
            InterfaceC3232oa m = Da.this.m();
            if (m != null) {
                m.l();
            }
        }

        @Override // com.ironsource.J0
        public void g() {
            InterfaceC3232oa m = Da.this.m();
            if (m != null) {
                m.onAdClicked();
            }
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
    }

    public static final class b implements L0 {
        b() {
        }

        @Override // com.ironsource.L0
        public void a(C3289s0 adUnitCallback) {
            Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
            Da.this.l().a(adUnitCallback);
        }

        @Override // com.ironsource.L0
        public void a(IronSourceError ironSourceError) {
            Da.this.l().a(ironSourceError);
        }
    }

    public static final class c implements InterfaceC3374x0 {
        c() {
        }

        @Override // com.ironsource.InterfaceC3374x0
        public void b(IronSourceError ironSourceError) {
            InterfaceC3232oa m = Da.this.m();
            if (m != null) {
                m.d(ironSourceError);
            }
        }

        @Override // com.ironsource.InterfaceC3374x0
        public void f() {
            InterfaceC3232oa m = Da.this.m();
            if (m != null) {
                m.k();
            }
        }
    }

    public Da(C3205n0 adTools, X2 bannerContainer, O2 bannerAdUnitFactory) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        Intrinsics.checkNotNullParameter(bannerAdUnitFactory, "bannerAdUnitFactory");
        this.f2827a = adTools;
        this.b = bannerContainer;
        this.c = bannerAdUnitFactory;
        this.e = new Ea(this);
        this.g = new b();
        this.h = new c();
        this.i = new a();
    }

    public final C3205n0 a() {
        return this.f2827a;
    }

    public final void b(InterfaceC3232oa interfaceC3232oa) {
        this.d = interfaceC3232oa;
    }

    @Override // com.ironsource.InterfaceC3215na
    public void c() {
        this.e.c();
    }

    @Override // com.ironsource.InterfaceC3215na
    public void d() {
    }

    @Override // com.ironsource.InterfaceC3215na
    public void e() {
    }

    public final P2 f() {
        return this.i;
    }

    public final L0 g() {
        return this.g;
    }

    public final InterfaceC3374x0 h() {
        return this.h;
    }

    public final O2 i() {
        return this.c;
    }

    public final X2 j() {
        return this.b;
    }

    public final M2 k() {
        return this.f;
    }

    public final Ia l() {
        return this.e;
    }

    public final InterfaceC3232oa m() {
        return this.d;
    }

    public final void a(Ia ia) {
        Intrinsics.checkNotNullParameter(ia, "<set-?>");
        this.e = ia;
    }

    @Override // com.ironsource.InterfaceC3215na
    public void b() {
        this.e.b();
    }

    public final void a(M2 m2) {
        this.f = m2;
    }

    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f2827a.e().h().f("Banner Single Ad Unit Strategy - " + message);
    }

    public final void a(C3289s0 adUnitCallback, M2 adUnit) {
        InterfaceC3232oa interfaceC3232oa;
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        adUnit.a(this.b.getViewBinder(), this.h);
        LevelPlayAdInfo c2 = adUnitCallback.c();
        if (c2 == null || (interfaceC3232oa = this.d) == null) {
            return;
        }
        interfaceC3232oa.onAdLoaded(c2);
    }

    public final void a(IronSourceError ironSourceError) {
        InterfaceC3232oa interfaceC3232oa = this.d;
        if (interfaceC3232oa != null) {
            interfaceC3232oa.onAdLoadFailed(ironSourceError);
        }
    }

    @Override // com.ironsource.InterfaceC3215na
    public void a(InterfaceC3232oa listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d = listener;
    }
}
