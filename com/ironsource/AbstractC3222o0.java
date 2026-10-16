package com.ironsource;

import com.ironsource.D0;
import com.ironsource.InterfaceC3034cf;
import com.ironsource.InterfaceC3121i0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* renamed from: com.ironsource.o0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3222o0 {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC3340v0 f3607a;
    private final T6 b;
    private final V0 c;
    private L0 d;
    private InterfaceC3374x0 e;
    private final gg f;
    private final WeakReference<J0> g;
    private C3126i5 h;
    private InterfaceC3034cf.a i;
    private final B5 j;

    /* renamed from: com.ironsource.o0$a */
    protected class a implements D {
        public a() {
        }

        @Override // com.ironsource.D
        public void a(AbstractC3407z instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            AbstractC3222o0.this.j.a().a(AbstractC3222o0.this.h());
            J0 j0 = (J0) AbstractC3222o0.this.g.get();
            if (j0 != null) {
                j0.g();
            }
        }

        @Override // com.ironsource.D
        public void b(AbstractC3407z instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(AbstractC3222o0.this.a(instance.q()));
            AbstractC3222o0.this.k().b(instance);
            AbstractC3222o0.this.j.a().g(AbstractC3222o0.this.h());
            AbstractC3222o0.this.f().l().b(AbstractC3222o0.this.e().b().a());
        }
    }

    /* renamed from: com.ironsource.o0$b */
    public static final class b implements ng {
        b() {
        }

        @Override // com.ironsource.ng
        public void a(int i, String errorReason) {
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            AbstractC3222o0.this.a(i, errorReason);
        }

        @Override // com.ironsource.ng
        public void b(AbstractC3407z instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            AbstractC3222o0.this.j.e().a(C3126i5.a(AbstractC3222o0.this.h), AbstractC3222o0.this.e().u());
            L0 j = AbstractC3222o0.this.j();
            if (j != null) {
                j.a(new C3289s0(AbstractC3222o0.this, instance.e()));
            }
            AbstractC3222o0.this.l();
        }

        @Override // com.ironsource.ng
        public void a(AbstractC3407z instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            AbstractC3222o0.this.f().e().a().e(AbstractC3222o0.this.h());
            L0 j = AbstractC3222o0.this.j();
            if (j != null) {
                j.b(new C3289s0(AbstractC3222o0.this, instance.e()));
            }
            AbstractC3222o0.this.l();
        }
    }

    public AbstractC3222o0(C3205n0 adTools, AbstractC3340v0 adUnitData, J0 listener, T6 taskScheduler) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(taskScheduler, "taskScheduler");
        this.f3607a = adUnitData;
        this.b = taskScheduler;
        V0 v0 = new V0(adTools, adUnitData, D0.b.MEDIATION);
        this.c = v0;
        this.f = new gg(v0, adUnitData, c());
        this.g = new WeakReference<>(listener);
        this.j = v0.e();
        IronLog.INTERNAL.verbose("adFormat = " + adUnitData.b().a() + ", adUnitId = " + adUnitData.b().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        IronLog.INTERNAL.verbose(a("starting expiration scheduled task"));
        InterfaceC3034cf.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
        long b2 = this.c.b(this.f3607a.b().e());
        T6 t6 = this.b;
        Runnable runnable = new Runnable() { // from class: com.ironsource.o0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3222o0.e(AbstractC3222o0.this);
            }
        };
        Duration.Companion companion = Duration.INSTANCE;
        this.i = t6.a(runnable, DurationKt.toDuration(b2, DurationUnit.MILLISECONDS));
    }

    protected abstract C a();

    protected final AbstractC3340v0 e() {
        return this.f3607a;
    }

    protected final V0 f() {
        return this.c;
    }

    protected final Placement g() {
        return this.f3607a.b().f();
    }

    protected final String h() {
        return this.f3607a.l();
    }

    protected final InterfaceC3374x0 i() {
        return this.e;
    }

    protected final L0 j() {
        return this.d;
    }

    protected final gg k() {
        return this.f;
    }

    private final b c() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AbstractC3222o0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L0 l0 = this$0.d;
        if (l0 != null) {
            l0.a();
        }
    }

    protected final void a(InterfaceC3374x0 interfaceC3374x0) {
        this.e = interfaceC3374x0;
    }

    protected final void b(L0 l0) {
        this.d = l0;
    }

    public InterfaceC3121i0 d() {
        return this.f.d() ? InterfaceC3121i0.b.f3347a : new InterfaceC3121i0.a(null, 1, null);
    }

    public void a(L0 loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        IronLog.INTERNAL.verbose(C3205n0.a(this.c, (String) null, (String) null, 3, (Object) null));
        this.c.a(b());
        this.d = loadListener;
        this.j.a(this.f3607a.u());
        this.h = new C3126i5();
        this.f.a(a());
    }

    public C3256q0 b() {
        return new C3256q0(this.f3607a.b());
    }

    public final void a(I adInstancePresenter, InterfaceC3374x0 displayListener) {
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        this.e = displayListener;
        InterfaceC3034cf.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
        this.f.a(adInstancePresenter);
    }

    public final void a(boolean z) {
        IronLog.INTERNAL.verbose(C3205n0.a(this.c, (String) null, (String) null, 3, (Object) null));
        this.f.a();
        if (z) {
            this.c.e().e().a(this.c.f());
        }
    }

    protected final void a(int i, String errorReason) {
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
        IronLog.INTERNAL.verbose(a("errorCode = " + i + ", errorReason = " + errorReason));
        this.j.e().a(C3126i5.a(this.h), i, errorReason, this.f3607a.u());
        L0 l0 = this.d;
        if (l0 != null) {
            l0.a(new IronSourceError(i, errorReason));
        }
    }

    protected final String a(String str) {
        return C3205n0.a(this.c, str, (String) null, 2, (Object) null);
    }

    public /* synthetic */ AbstractC3222o0(C3205n0 c3205n0, AbstractC3340v0 abstractC3340v0, J0 j0, T6 t6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3205n0, abstractC3340v0, j0, (i & 8) != 0 ? new T6(U6.a(c3205n0.a())) : t6);
    }
}
