package com.ironsource;

import com.ironsource.AbstractC3140j3;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Df extends AbstractC3140j3 implements L0, InterfaceC3374x0 {
    private final C3205n0 d;
    private final X2 e;
    private final InterfaceC3174l3 f;
    private final O2 g;
    private Lf h;
    private final C3358w1 i;
    private final bg j;
    private final C3300sb k;
    private a l;
    private a m;
    private boolean n;
    private boolean o;
    private C3289s0 p;
    private IronSourceError q;

    private final class a {

        /* renamed from: a, reason: collision with root package name */
        private final M2 f2834a;
        public C3289s0 b;
        private boolean c;
        final /* synthetic */ Df d;

        public a(Df df, O2 bannerAdUnitFactory, boolean z) {
            Intrinsics.checkNotNullParameter(bannerAdUnitFactory, "bannerAdUnitFactory");
            this.d = df;
            this.f2834a = bannerAdUnitFactory.a(z);
            this.c = true;
        }

        public final C3289s0 a() {
            C3289s0 c3289s0 = this.b;
            if (c3289s0 != null) {
                return c3289s0;
            }
            Intrinsics.throwUninitializedPropertyAccessException("adUnitCallback");
            return null;
        }

        public final M2 b() {
            return this.f2834a;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.f2834a.d().a();
        }

        public final void e() {
            this.f2834a.a((L0) this.d);
        }

        public final void a(C3289s0 c3289s0) {
            Intrinsics.checkNotNullParameter(c3289s0, "<set-?>");
            this.b = c3289s0;
        }

        public final void b(boolean z) {
            this.c = z;
        }

        public final void a(boolean z) {
            this.f2834a.a(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Df(C3205n0 adTools, X2 bannerContainer, AbstractC3140j3.b config, K2 bannerAdProperties, InterfaceC3174l3 bannerStrategyListener, O2 bannerAdUnitFactory) {
        super(config, bannerAdProperties);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        Intrinsics.checkNotNullParameter(bannerStrategyListener, "bannerStrategyListener");
        Intrinsics.checkNotNullParameter(bannerAdUnitFactory, "bannerAdUnitFactory");
        this.d = adTools;
        this.e = bannerContainer;
        this.f = bannerStrategyListener;
        this.g = bannerAdUnitFactory;
        IronLog.INTERNAL.verbose(C3205n0.a(adTools, "refresh interval: " + g() + ", auto refresh: " + h(), (String) null, 2, (Object) null));
        this.i = new C3358w1(adTools.b());
        this.j = new bg(bannerContainer);
        this.k = new C3300sb(!h());
        this.m = new a(this, bannerAdUnitFactory, true);
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Df this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n = true;
        if (this$0.m.d()) {
            this$0.l();
        } else {
            if (this$0.m.c()) {
                return;
            }
            this$0.i();
            this$0.a(this$0.i, this$0.k);
        }
    }

    private final void i() {
        if (h()) {
            a aVar = new a(this, this.g, false);
            this.m = aVar;
            aVar.e();
        }
    }

    private final void j() {
        this.d.a(new Runnable() { // from class: com.ironsource.Df$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Df.a(Df.this);
            }
        });
    }

    private final void k() {
        this.f.c(this.q);
        this.p = null;
        this.q = null;
    }

    private final void l() {
        this.o = false;
        this.m.b().a(this.e.getViewBinder(), this);
        this.f.c(this.m.a());
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(false);
        }
        this.l = this.m;
        i();
        a(this.j, this.i, this.k);
    }

    @Override // com.ironsource.AbstractC3140j3
    public void b() {
        this.m.e();
    }

    @Override // com.ironsource.AbstractC3140j3
    public void c() {
        this.i.e();
        this.j.e();
        Lf lf = this.h;
        if (lf != null) {
            lf.c();
        }
        this.h = null;
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(true);
        }
        this.m.a(true);
    }

    @Override // com.ironsource.AbstractC3140j3
    public void d() {
        if (h()) {
            this.k.e();
        }
    }

    @Override // com.ironsource.AbstractC3140j3
    public void e() {
        if (h()) {
            this.k.f();
        }
    }

    @Override // com.ironsource.InterfaceC3374x0
    public void f() {
        this.f.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Df this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
    }

    @Override // com.ironsource.InterfaceC3374x0
    public void b(IronSourceError ironSourceError) {
        this.f.e(ironSourceError);
    }

    private final void a(final Oc... ocArr) {
        this.n = false;
        this.d.c(new Runnable() { // from class: com.ironsource.Df$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Df.a(Df.this, ocArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final Df this$0, Oc[] triggers) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(triggers, "$triggers");
        Lf lf = this$0.h;
        if (lf != null) {
            lf.c();
        }
        this$0.h = new Lf(this$0.d, new Runnable() { // from class: com.ironsource.Df$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Df.b(Df.this);
            }
        }, this$0.g(), ArraysKt.toList(triggers));
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.m.a(adUnitCallback);
        this.m.b(false);
        if (this.n || this.o) {
            l();
        }
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.m.b(false);
        this.q = ironSourceError;
        if (this.o) {
            k();
            a(this.i, this.k);
        } else if (this.n) {
            k();
            i();
            a(this.i, this.k);
        }
    }
}
