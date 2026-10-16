package com.ironsource;

import com.ironsource.AbstractC3157k3;
import com.ironsource.InterfaceC3034cf;
import com.ironsource.Za;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* renamed from: com.ironsource.ya, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3401ya implements Ba {

    /* renamed from: a, reason: collision with root package name */
    private final C3282ra f3950a;
    private final M2 b;
    private final M2 c;
    private final long d;
    private Za<LevelPlayAdInfo> e;
    private InterfaceC3034cf.a f;

    public C3401ya(C3282ra strategy, M2 currentAdUnit, M2 reloadingAdUnit, long j) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(reloadingAdUnit, "reloadingAdUnit");
        this.f3950a = strategy;
        this.b = currentAdUnit;
        this.c = reloadingAdUnit;
        this.d = j;
        g();
    }

    private final void f() {
        Za<LevelPlayAdInfo> za = this.e;
        if (za == null) {
            C3282ra c3282ra = this.f3950a;
            c3282ra.a((Ba) new Aa(c3282ra, this.b, this.c, this.d));
        } else if (za instanceof Za.b) {
            a((LevelPlayAdInfo) ((Za.b) za).b());
        } else if (za instanceof Za.a) {
            b(((Za.a) za).b());
        }
    }

    private final void g() {
        InterfaceC3034cf o = this.f3950a.o();
        Runnable runnable = new Runnable() { // from class: com.ironsource.ya$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3401ya.a(C3401ya.this);
            }
        };
        Duration.Companion companion = Duration.INSTANCE;
        this.f = o.a(runnable, DurationKt.toDuration(this.f3950a.l(), DurationUnit.MILLISECONDS));
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo c = adUnitCallback.c();
        if (c != null) {
            a(new Za.b(c));
        } else {
            a(new Za.a(new IronSourceError(0, "Missing ad info")));
        }
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.f3950a.a("Loading an ad while reloading");
    }

    @Override // com.ironsource.Ba
    public void c() {
        InterfaceC3034cf.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
        this.b.a(true);
        this.c.a(true);
        C3282ra c3282ra = this.f3950a;
        c3282ra.a((Ba) new C3333ua(c3282ra));
    }

    @Override // com.ironsource.Ba
    public void d() {
        InterfaceC3034cf.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
        C3282ra c3282ra = this.f3950a;
        c3282ra.a((Ba) new C3384xa(c3282ra, this.b));
    }

    @Override // com.ironsource.Ba
    public void e() {
        C3282ra c3282ra = this.f3950a;
        c3282ra.a((Ba) new C3401ya(c3282ra, this.b, this.c, c3282ra.p().a()));
    }

    private final void b(IronSourceError ironSourceError) {
        this.f3950a.a(ironSourceError, this.b, (AbstractC3157k3) new AbstractC3157k3.c(this.f3950a.p().a() - this.d, AbstractC3157k3.d.g.f3396a), true, false, Long.valueOf(this.d));
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        if (ironSourceError == null) {
            ironSourceError = new IronSourceError(0, "Unknown error");
        }
        a(new Za.a(ironSourceError));
    }

    private final void a(LevelPlayAdInfo levelPlayAdInfo) {
        long a2 = this.f3950a.p().a() - this.d;
        this.f3950a.a(new C3289s0(this.c, levelPlayAdInfo), this.c, this.b, (AbstractC3157k3) new AbstractC3157k3.c(a2, AbstractC3157k3.d.h.f3397a), false, Long.valueOf(this.d));
    }

    private final void a(Za<LevelPlayAdInfo> za) {
        String b;
        if (this.e != null) {
            C3282ra c3282ra = this.f3950a;
            b = C3418za.b(za);
            c3282ra.a("Received excessive load " + b + " while reloading");
            return;
        }
        this.e = za;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3401ya this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }
}
