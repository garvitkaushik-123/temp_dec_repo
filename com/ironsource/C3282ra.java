package com.ironsource;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.ironsource.ra, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3282ra implements InterfaceC3215na {

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f3670a;
    private final X2 b;
    private final long c;
    private final long d;
    private final K2 e;
    private InterfaceC3232oa f;
    private final O2 g;
    private final InterfaceC3034cf h;
    private final InterfaceC3293s4 i;
    private L0 j;
    private InterfaceC3374x0 k;
    private P2 l;
    private Ba m;

    /* renamed from: com.ironsource.ra$a */
    public static final class a implements P2 {
        a() {
        }

        public void a() {
            C3282ra.this.n().onAdLeftApplication();
        }

        public void b() {
            C3282ra.this.n().n();
        }

        public void c() {
            C3282ra.this.n().l();
        }

        @Override // com.ironsource.J0
        public void g() {
            C3282ra.this.n().onAdClicked();
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

    /* renamed from: com.ironsource.ra$b */
    public static final class b implements L0 {
        b() {
        }

        @Override // com.ironsource.L0
        public void a(C3289s0 adUnitCallback) {
            Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
            C3282ra.this.m().a(adUnitCallback);
        }

        @Override // com.ironsource.L0
        public void a(IronSourceError ironSourceError) {
            C3282ra.this.m().a(ironSourceError);
        }
    }

    /* renamed from: com.ironsource.ra$c */
    public static final class c implements InterfaceC3374x0 {
        c() {
        }

        @Override // com.ironsource.InterfaceC3374x0
        public void b(IronSourceError ironSourceError) {
            C3282ra.this.n().d(ironSourceError);
        }

        @Override // com.ironsource.InterfaceC3374x0
        public void f() {
            C3282ra.this.n().k();
        }
    }

    /* renamed from: com.ironsource.ra$d */
    static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ M2 b;
        final /* synthetic */ AbstractC3157k3 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(M2 m2, AbstractC3157k3 abstractC3157k3) {
            super(0);
            this.b = m2;
            this.c = abstractC3157k3;
        }

        public final void a() {
            C3282ra.this.a(this.b, this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.ironsource.ra$e */
    static final class e extends Lambda implements Function0<Unit> {
        final /* synthetic */ M2 b;
        final /* synthetic */ Long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(M2 m2, Long l) {
            super(0);
            this.b = m2;
            this.c = l;
        }

        public final void a() {
            C3282ra c3282ra = C3282ra.this;
            c3282ra.a((Ba) new C3350va(c3282ra, this.b, this.c));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.ironsource.ra$f */
    public static final class f implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ M2 b;
        final /* synthetic */ AbstractC3157k3 c;
        final /* synthetic */ Long d;

        /* renamed from: com.ironsource.ra$f$a */
        static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C3282ra f3677a;
            final /* synthetic */ M2 b;
            final /* synthetic */ AbstractC3157k3 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C3282ra c3282ra, M2 m2, AbstractC3157k3 abstractC3157k3) {
                super(0);
                this.f3677a = c3282ra;
                this.b = m2;
                this.c = abstractC3157k3;
            }

            public final void a() {
                this.f3677a.a(this.b, this.c);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* renamed from: com.ironsource.ra$f$b */
        static final class b extends Lambda implements Function0<Unit> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C3282ra f3678a;
            final /* synthetic */ M2 b;
            final /* synthetic */ Long c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C3282ra c3282ra, M2 m2, Long l) {
                super(0);
                this.f3678a = c3282ra;
                this.b = m2;
                this.c = l;
            }

            public final void a() {
                C3282ra c3282ra = this.f3678a;
                c3282ra.a((Ba) new C3350va(c3282ra, this.b, this.c));
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        f(M2 m2, AbstractC3157k3 abstractC3157k3, Long l) {
            this.b = m2;
            this.c = abstractC3157k3;
            this.d = l;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (C3282ra.this.k().getViewTreeObserver().isAlive()) {
                C3282ra.this.k().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (eg.a(C3282ra.this.k(), new Rect())) {
                C3047db.a((C3047db) C3282ra.this.a(), Pd.f2996a.a(new a(C3282ra.this, this.b, this.c)), 0L, 2, (Object) null);
            } else {
                C3047db.a((C3047db) C3282ra.this.a(), Pd.f2996a.a(new b(C3282ra.this, this.b, this.d)), 0L, 2, (Object) null);
            }
        }
    }

    public C3282ra(C3205n0 adTools, X2 bannerContainer, long j, long j2, K2 bannerAdProperties, InterfaceC3232oa strategyListener, O2 bannerAdUnitFactory, InterfaceC3034cf taskScheduler, InterfaceC3293s4 timeProvider) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        Intrinsics.checkNotNullParameter(strategyListener, "strategyListener");
        Intrinsics.checkNotNullParameter(bannerAdUnitFactory, "bannerAdUnitFactory");
        Intrinsics.checkNotNullParameter(taskScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f3670a = adTools;
        this.b = bannerContainer;
        this.c = j;
        this.d = j2;
        this.e = bannerAdProperties;
        this.f = strategyListener;
        this.g = bannerAdUnitFactory;
        this.h = taskScheduler;
        this.i = timeProvider;
        this.j = new b();
        this.k = new c();
        this.l = new a();
        this.m = new C3316ta(this, false, 2, null);
    }

    public final C3205n0 a() {
        return this.f3670a;
    }

    public final void b(InterfaceC3232oa interfaceC3232oa) {
        Intrinsics.checkNotNullParameter(interfaceC3232oa, "<set-?>");
        this.f = interfaceC3232oa;
    }

    @Override // com.ironsource.InterfaceC3215na
    public void c() {
        this.m.c();
    }

    @Override // com.ironsource.InterfaceC3215na
    public void d() {
        this.m.d();
    }

    @Override // com.ironsource.InterfaceC3215na
    public void e() {
        this.m.e();
    }

    public final P2 f() {
        return this.l;
    }

    public final L0 g() {
        return this.j;
    }

    public final InterfaceC3374x0 h() {
        return this.k;
    }

    public final K2 i() {
        return this.e;
    }

    public final O2 j() {
        return this.g;
    }

    public final X2 k() {
        return this.b;
    }

    public final long l() {
        return this.c;
    }

    public final Ba m() {
        return this.m;
    }

    public final InterfaceC3232oa n() {
        return this.f;
    }

    public final InterfaceC3034cf o() {
        return this.h;
    }

    public final InterfaceC3293s4 p() {
        return this.i;
    }

    public final long q() {
        return this.d;
    }

    public final void r() {
        this.f3670a.e().h().h("Banner view is not visible");
    }

    public final void a(L0 l0) {
        Intrinsics.checkNotNullParameter(l0, "<set-?>");
        this.j = l0;
    }

    @Override // com.ironsource.InterfaceC3215na
    public void b() {
        this.m.b();
    }

    public final void a(InterfaceC3374x0 interfaceC3374x0) {
        Intrinsics.checkNotNullParameter(interfaceC3374x0, "<set-?>");
        this.k = interfaceC3374x0;
    }

    public final void a(P2 p2) {
        Intrinsics.checkNotNullParameter(p2, "<set-?>");
        this.l = p2;
    }

    public final void a(Ba ba) {
        Intrinsics.checkNotNullParameter(ba, "<set-?>");
        this.m = ba;
    }

    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f3670a.e().h().f("Banner Reload Strategy - " + message);
    }

    public final void a(C3289s0 adUnitCallback, M2 currentAdUnit, M2 m2, AbstractC3157k3 reloadReason, boolean z, Long l) {
        Unit unit;
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(reloadReason, "reloadReason");
        currentAdUnit.a(this.b.getViewBinder(), this.k);
        LevelPlayAdInfo c2 = adUnitCallback.c();
        if (c2 != null) {
            this.f.onAdLoaded(c2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            IronLog.INTERNAL.error(C3205n0.a(this.f3670a, "adInfo is null in handleLoadSuccess", (String) null, 2, (Object) null));
        }
        if (m2 != null) {
            m2.a(false);
        }
        if (z) {
            this.m = new C3384xa(this, currentAdUnit);
        } else {
            a(currentAdUnit, reloadReason, l);
        }
    }

    public final void a(IronSourceError ironSourceError, M2 currentAdUnit, AbstractC3157k3 reloadReason, boolean z, boolean z2, Long l) {
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(reloadReason, "reloadReason");
        this.f.onAdLoadFailed(ironSourceError);
        if (z2) {
            this.m = new C3384xa(this, currentAdUnit);
        } else if (z) {
            a(currentAdUnit, reloadReason, l);
        } else {
            a(currentAdUnit, reloadReason);
        }
    }

    public final void a(final M2 currentAdUnit, final AbstractC3157k3 reloadReason, final Long l) {
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(reloadReason, "reloadReason");
        C3047db.a(this.f3670a, new Runnable() { // from class: com.ironsource.ra$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3282ra.a(C3282ra.this, currentAdUnit, reloadReason, l);
            }
        }, 0L, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3282ra this$0, M2 currentAdUnit, AbstractC3157k3 reloadReason, Long l) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentAdUnit, "$currentAdUnit");
        Intrinsics.checkNotNullParameter(reloadReason, "$reloadReason");
        if (eg.a(this$0.b, new Rect())) {
            C3047db.a((C3047db) this$0.f3670a, Pd.f2996a.a(this$0.new d(currentAdUnit, reloadReason)), 0L, 2, (Object) null);
        } else if (!this$0.b.getViewTreeObserver().isAlive()) {
            C3047db.a((C3047db) this$0.f3670a, Pd.f2996a.a(this$0.new e(currentAdUnit, l)), 0L, 2, (Object) null);
        } else {
            this$0.b.getViewTreeObserver().addOnGlobalLayoutListener(this$0.new f(currentAdUnit, reloadReason, l));
        }
    }

    public /* synthetic */ C3282ra(C3205n0 c3205n0, X2 x2, long j, long j2, K2 k2, InterfaceC3232oa interfaceC3232oa, O2 o2, InterfaceC3034cf interfaceC3034cf, InterfaceC3293s4 interfaceC3293s4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3205n0, x2, j, j2, k2, interfaceC3232oa, o2, (i & 128) != 0 ? new T6(U6.a(c3205n0.a())) : interfaceC3034cf, interfaceC3293s4);
    }

    public final void a(M2 currentAdUnit, AbstractC3157k3 reloadReason) {
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(reloadReason, "reloadReason");
        M2 a2 = this.g.a(false);
        C3401ya c3401ya = new C3401ya(this, currentAdUnit, a2, this.i.a());
        a(reloadReason);
        this.m = c3401ya;
        a2.a(this.j);
    }

    private final void a(AbstractC3157k3 abstractC3157k3) {
        this.f3670a.e().h().a(abstractC3157k3.c(), abstractC3157k3.b(), abstractC3157k3.a());
    }

    @Override // com.ironsource.InterfaceC3215na
    public void a(InterfaceC3232oa listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f = listener;
    }
}
