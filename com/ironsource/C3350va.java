package com.ironsource;

import android.graphics.Rect;
import com.ironsource.AbstractC3157k3;
import com.ironsource.InterfaceC3034cf;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* renamed from: com.ironsource.va, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3350va implements Ba {

    /* renamed from: a, reason: collision with root package name */
    private final C3282ra f3912a;
    private final M2 b;
    private final Long c;
    private InterfaceC3034cf.a d;
    private final long e;

    /* renamed from: com.ironsource.va$a */
    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AbstractC3157k3.c b;
        final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC3157k3.c cVar, long j) {
            super(0);
            this.b = cVar;
            this.c = j;
        }

        public final void a() {
            C3350va.this.f3912a.a(C3350va.this.b, this.b, Long.valueOf(this.c));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public C3350va(C3282ra strategy, M2 currentAdUnit, Long l) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        this.f3912a = strategy;
        this.b = currentAdUnit;
        this.c = l;
        this.e = strategy.p().a();
        strategy.r();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final C3350va this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C3047db.a(this$0.f3912a.a(), new Runnable() { // from class: com.ironsource.va$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3350va.d(C3350va.this);
            }
        }, 0L, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C3350va this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!eg.a(this$0.f3912a.k(), new Rect())) {
            this$0.f();
            return;
        }
        long a2 = this$0.f3912a.p().a();
        long j = a2 - this$0.e;
        Long l = this$0.c;
        C3047db.a((C3047db) this$0.f3912a.a(), Pd.f2996a.a(this$0.new a(new AbstractC3157k3.c(l != null ? a2 - l.longValue() : 0L, new AbstractC3157k3.d.f(j)), a2)), 0L, 2, (Object) null);
    }

    private final void f() {
        long q = this.f3912a.q();
        InterfaceC3034cf o = this.f3912a.o();
        Runnable runnable = new Runnable() { // from class: com.ironsource.va$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3350va.c(C3350va.this);
            }
        };
        Duration.Companion companion = Duration.INSTANCE;
        this.d = o.a(runnable, DurationKt.toDuration(q, DurationUnit.MILLISECONDS));
    }

    @Override // com.ironsource.Ba
    public void e() {
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f3912a.a("Received load success while paused not visible");
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.f3912a.a("Loading a loaded ad");
    }

    @Override // com.ironsource.Ba
    public void c() {
        InterfaceC3034cf.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
        this.b.a(true);
        C3282ra c3282ra = this.f3912a;
        c3282ra.a((Ba) new C3333ua(c3282ra));
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f3912a.a("Received load success while paused not visible");
    }

    @Override // com.ironsource.Ba
    public void d() {
        InterfaceC3034cf.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
        C3282ra c3282ra = this.f3912a;
        c3282ra.a((Ba) new C3384xa(c3282ra, this.b));
    }
}
