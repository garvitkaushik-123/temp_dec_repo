package com.ironsource;

import android.app.Activity;
import com.ironsource.D0;
import com.ironsource.InterfaceC3034cf;
import com.ironsource.InterfaceC3293s4;
import com.ironsource.Za;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* renamed from: com.ironsource.q6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3262q6 implements InterfaceC3143j6 {

    /* renamed from: a, reason: collision with root package name */
    private final C3334ub f3653a;
    private final V0 b;
    private final AbstractC3340v0 c;
    private InterfaceC3312t6 d;
    private final Function3<A, G, InterfaceC3143j6, C3127i6> e;
    private final InterfaceC3034cf f;
    private final InterfaceC3293s4 g;
    private b h;
    private a i;
    private final gg j;
    private InterfaceC3034cf.a k;
    private Long l;

    /* renamed from: com.ironsource.q6$a */
    public interface a {
        void a(C3262q6 c3262q6, IronSourceError ironSourceError);

        void a(C3262q6 c3262q6, LevelPlayAdInfo levelPlayAdInfo);
    }

    /* renamed from: com.ironsource.q6$b */
    public interface b {
        void a(C3262q6 c3262q6);

        void b(C3262q6 c3262q6, IronSourceError ironSourceError);

        void b(C3262q6 c3262q6, LevelPlayAdInfo levelPlayAdInfo);

        void c(C3262q6 c3262q6, LevelPlayAdInfo levelPlayAdInfo);
    }

    /* renamed from: com.ironsource.q6$d */
    /* synthetic */ class d extends FunctionReferenceImpl implements Function3<A, G, InterfaceC3143j6, C3127i6> {
        d(Object obj) {
            super(3, obj, C3262q6.class, "createAdInstance", "createAdInstance(Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/AdInstanceData;Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/AdInstancePayload;Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/listeners/FullscreenAdInstanceListener;)Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/FullscreenAdInstance;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C3127i6 invoke(A p0, G p1, InterfaceC3143j6 p2) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return ((C3262q6) this.receiver).a(p0, p1, p2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3262q6(C3334ub mediationServices, V0 adUnitTools, AbstractC3340v0 adUnitData, InterfaceC3312t6 fullscreenListener, hg hgVar, Function3<? super A, ? super G, ? super InterfaceC3143j6, C3127i6> function3, InterfaceC3034cf taskScheduler, InterfaceC3293s4 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(mediationServices, "mediationServices");
        Intrinsics.checkNotNullParameter(adUnitTools, "adUnitTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(fullscreenListener, "fullscreenListener");
        Intrinsics.checkNotNullParameter(taskScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.f3653a = mediationServices;
        this.b = adUnitTools;
        this.c = adUnitData;
        this.d = fullscreenListener;
        this.e = function3;
        this.f = taskScheduler;
        this.g = currentTimeProvider;
        this.j = a(hgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(C3262q6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.h;
        if (bVar != null) {
            bVar.a(this$0);
        }
        this$0.j.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        return this.c.l();
    }

    private final Za<Unit> f() {
        if (!this.j.d()) {
            return new Za.a(new IronSourceError(509, "show called while ad unit is not ready to show"));
        }
        if (this.f3653a.p().a(c(), b()).d()) {
            return new Za.a(new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, "placement " + c() + " is capped"));
        }
        if (!this.f3653a.f().a(this.c.b().c()).d()) {
            return new Za.b(Unit.INSTANCE);
        }
        return new Za.a(new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "adUnitId " + this.c.b().c() + " is capped"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        InterfaceC3034cf.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
        long b2 = this.b.b(b());
        InterfaceC3034cf interfaceC3034cf = this.f;
        Runnable runnable = new Runnable() { // from class: com.ironsource.q6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3262q6.h(C3262q6.this);
            }
        };
        Duration.Companion companion = Duration.INSTANCE;
        this.k = interfaceC3034cf.a(runnable, DurationKt.toDuration(b2, DurationUnit.MILLISECONDS));
    }

    @Override // com.ironsource.D
    public void b(AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.j.b(instance);
        this.b.e().a().g(c());
        this.f3653a.h().b(com.unity3d.mediation.a.a(b()));
    }

    public final InterfaceC3312t6 d() {
        return this.d;
    }

    public final LevelPlayAdInfo e() {
        AbstractC3407z c2 = this.j.c();
        if (c2 != null) {
            return c2.e();
        }
        return null;
    }

    private final void h() {
        String c2 = c();
        if (c2.length() > 0) {
            this.f3653a.a().b(c2, b());
            N3 a2 = this.f3653a.p().a(c2, b());
            if (a2.d()) {
                this.b.e().a().b(c2, a2.e());
            }
        }
    }

    public final void a(InterfaceC3312t6 interfaceC3312t6) {
        Intrinsics.checkNotNullParameter(interfaceC3312t6, "<set-?>");
        this.d = interfaceC3312t6;
    }

    public final void a(b loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        IronLog.INTERNAL.verbose(C3205n0.a(this.b, (String) null, (String) null, 3, (Object) null));
        this.h = loadListener;
        this.l = Long.valueOf(this.g.a());
        this.b.a(new C3256q0(this.c.b()));
        C c2 = new C() { // from class: com.ironsource.q6$$ExternalSyntheticLambda1
            @Override // com.ironsource.C
            public final AbstractC3407z a(A a2, G g) {
                AbstractC3407z a3;
                a3 = C3262q6.a(C3262q6.this, a2, g);
                return a3;
            }
        };
        this.b.e().e().a(this.c.u());
        this.j.a(c2);
    }

    /* renamed from: com.ironsource.q6$c */
    public static final class c implements ng {
        c() {
        }

        @Override // com.ironsource.ng
        public void a(int i, String errorReason) {
            Long l;
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            Long l2 = C3262q6.this.l;
            if (l2 != null) {
                l = Long.valueOf(C3262q6.this.g.a() - l2.longValue());
            } else {
                l = null;
            }
            C3262q6.this.b.e().e().a(l != null ? l.longValue() : 0L, i, errorReason, C3262q6.this.c.u());
            b bVar = C3262q6.this.h;
            if (bVar != null) {
                bVar.b(C3262q6.this, new IronSourceError(i, errorReason));
            }
        }

        @Override // com.ironsource.ng
        public void b(AbstractC3407z instance) {
            Long l;
            Intrinsics.checkNotNullParameter(instance, "instance");
            Long l2 = C3262q6.this.l;
            if (l2 != null) {
                l = Long.valueOf(C3262q6.this.g.a() - l2.longValue());
            } else {
                l = null;
            }
            C3262q6.this.b.e().e().a(l != null ? l.longValue() : 0L, C3262q6.this.c.u());
            C3262q6.this.g();
            b bVar = C3262q6.this.h;
            if (bVar != null) {
                bVar.b(C3262q6.this, instance.e());
            }
        }

        @Override // com.ironsource.ng
        public void a(AbstractC3407z instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            C3262q6.this.b.e().a().e(C3262q6.this.c());
            C3262q6.this.g();
            b bVar = C3262q6.this.h;
            if (bVar != null) {
                bVar.c(C3262q6.this, instance.e());
            }
        }
    }

    @Override // com.ironsource.InterfaceC3143j6
    public void b(C3127i6 fullscreenInstance) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        this.b.e().a().b(c());
        this.d.onClosed();
    }

    private final LevelPlay.AdFormat b() {
        return this.c.b().e();
    }

    public /* synthetic */ C3262q6(C3334ub c3334ub, V0 v0, AbstractC3340v0 abstractC3340v0, InterfaceC3312t6 interfaceC3312t6, hg hgVar, Function3 function3, InterfaceC3034cf interfaceC3034cf, InterfaceC3293s4 interfaceC3293s4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3334ub, v0, abstractC3340v0, interfaceC3312t6, (i & 16) != 0 ? null : hgVar, (i & 32) != 0 ? null : function3, (i & 64) != 0 ? new T6(U6.a(v0.a())) : interfaceC3034cf, (i & 128) != 0 ? new InterfaceC3293s4.a() : interfaceC3293s4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC3407z a(C3262q6 this$0, A instanceData, G adInstancePayload) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Function3 function3 = this$0.e;
        if (function3 == null) {
            function3 = new d(this$0);
        }
        return (AbstractC3407z) function3.invoke(instanceData, adInstancePayload, this$0);
    }

    public final void a(Activity activity, a displayListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(C3205n0.a(this.b, (String) null, (String) null, 3, (Object) null));
        this.i = displayListener;
        this.b.e().a().a(activity, c());
        Za<Unit> f = f();
        if (f instanceof Za.a) {
            IronSourceError b2 = ((Za.a) f).b();
            ironLog.verbose(C3205n0.a(this.b, b2.getErrorMessage(), (String) null, 2, (Object) null));
            this.b.e().a().a(c(), b2.getErrorCode(), b2.getErrorMessage(), "");
            displayListener.a(this, b2);
            return;
        }
        InterfaceC3034cf.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
        this.j.a(new C3160k6(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3127i6 a(A a2, G g, InterfaceC3143j6 interfaceC3143j6) {
        return new C3127i6(new V0(this.b, D0.b.PROVIDER), a2, g, interfaceC3143j6);
    }

    private final gg a(hg hgVar) {
        ng a2 = a();
        if (hgVar != null) {
            return hgVar.a(a2);
        }
        return new gg(this.b, this.c, a2);
    }

    private final ng a() {
        return new c();
    }

    @Override // com.ironsource.InterfaceC3143j6
    public void a(C3127i6 fullscreenInstance) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        this.b.e().a().l(c());
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this, fullscreenInstance.e());
        }
        h();
        this.f3653a.l().b(this.c.b().c());
    }

    @Override // com.ironsource.InterfaceC3143j6
    public void a(C3127i6 fullscreenInstance, IronSourceError error) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.INTERNAL.verbose(C3205n0.a(this.b, error.toString(), (String) null, 2, (Object) null));
        this.b.e().a().a(c(), error.getErrorCode(), error.getErrorMessage(), "");
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this, error);
        }
    }

    @Override // com.ironsource.InterfaceC3143j6
    public void a(C3127i6 fullscreenInstance, LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        Intrinsics.checkNotNullParameter(reward, "reward");
        IronLog.INTERNAL.verbose(C3205n0.a(this.b, fullscreenInstance.q(), (String) null, 2, (Object) null));
        this.d.a(reward);
    }

    @Override // com.ironsource.D
    public void a(AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.b.e().a().a(c());
        this.d.g();
    }
}
