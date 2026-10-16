package com.ironsource;

import android.content.Context;
import com.ironsource.C3101ge;
import com.ironsource.C3334ub;
import com.ironsource.Qc;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* renamed from: com.ironsource.ge, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3101ge {

    /* renamed from: a, reason: collision with root package name */
    public static final C3101ge f3320a;
    private static C3388xe b;
    private static final Lazy c;
    private static final String d;
    private static final C3168ke e;
    private static final C3303se f;
    private static final List<Yd> g;
    private static Sd h;
    private static Ud i;
    private static boolean j;
    private static long k;

    /* renamed from: com.ironsource.ge$a */
    static final class a extends Lambda implements Function0<InterfaceC3144j7> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3321a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC3144j7 invoke() {
            return C3334ub.s.d().k();
        }
    }

    /* renamed from: com.ironsource.ge$b */
    public static final class b implements Yd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3322a;

        b(Context context) {
            this.f3322a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Ud error) {
            Intrinsics.checkNotNullParameter(error, "$error");
            C3101ge.f3320a.a(error);
        }

        @Override // com.ironsource.Yd
        public void a(final Sd sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            C3168ke c3168ke = C3101ge.e;
            final Context context = this.f3322a;
            c3168ke.a(new Runnable() { // from class: com.ironsource.ge$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C3101ge.b.a(context, sdkConfig);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Context applicationContext, Sd sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
            C3101ge c3101ge = C3101ge.f3320a;
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            c3101ge.a(applicationContext, sdkConfig);
        }

        @Override // com.ironsource.Yd
        public void a(final Ud error) {
            Intrinsics.checkNotNullParameter(error, "error");
            C3101ge.e.a(new Runnable() { // from class: com.ironsource.ge$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3101ge.b.b(Ud.this);
                }
            });
        }
    }

    static {
        C3101ge c3101ge = new C3101ge();
        f3320a = c3101ge;
        c = LazyKt.lazy(a.f3321a);
        d = c3101ge.getClass().getSimpleName();
        e = new C3168ke();
        f = new C3303se();
        g = new ArrayList();
    }

    private C3101ge() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3013be serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "$serverResponse");
        Sd sd = new Sd(serverResponse);
        C3101ge c3101ge = f3320a;
        c3101ge.b(sd);
        c3101ge.a(sd);
    }

    private final InterfaceC3144j7 c() {
        return (InterfaceC3144j7) c.getValue();
    }

    private final void d() {
        if (C3334ub.s.d().g().g()) {
            Id.i().a(new C3413z5(A5.EP_CONFIG_RECEIVED, (JSONObject) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        f3320a.a(true);
    }

    public final void e() {
        e.c(new Runnable() { // from class: com.ironsource.ge$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3101ge.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Ud error) {
        Intrinsics.checkNotNullParameter(error, "$error");
        f3320a.a(error);
    }

    private final void a(Context context, J9 j9, C3337ue c3337ue) {
        j9.i(c3337ue.f().h());
        j9.c(c3337ue.f().d());
        A1 b2 = c3337ue.c().b();
        Intrinsics.checkNotNull(b2);
        j9.a(b2.a());
        j9.d(b2.c().b());
        j9.b(b2.k().b());
        j9.a(Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
        A1 b3 = c3337ue.c().b();
        Intrinsics.checkNotNull(b3);
        j9.b(b3.f().b());
    }

    public final void b(final Ud error) {
        Intrinsics.checkNotNullParameter(error, "error");
        e.c(new Runnable() { // from class: com.ironsource.ge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3101ge.c(Ud.this);
            }
        });
    }

    private final void b(Sd sd) {
        h = sd;
        a(false);
    }

    private final EnumC3135ie b() {
        if (h != null) {
            return EnumC3135ie.INITIATED;
        }
        if (i != null) {
            return EnumC3135ie.INIT_FAILED;
        }
        if (j) {
            return EnumC3135ie.INIT_IN_PROGRESS;
        }
        return EnumC3135ie.NOT_INIT;
    }

    public final void a(final Context context, final C2996ae initRequest, final Yd listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Context applicationContext = context.getApplicationContext();
        e.c(new Runnable() { // from class: com.ironsource.ge$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3101ge.a(Yd.this, context, initRequest, applicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Yd listener, Sd sdkConfig) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
        listener.a(sdkConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Yd listener, Ud error) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(error, "$error");
        listener.a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Yd listener, Context context, C2996ae initRequest, Context context2) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        Sd sd = h;
        if (sd != null) {
            f3320a.a(listener, sd);
            return;
        }
        g.add(listener);
        if (j) {
            return;
        }
        i = null;
        f3320a.a(true);
        k = new Date().getTime();
        f.a(context, initRequest, e, new b(context2));
    }

    private final void b(Context context, Sd sd) {
        Context context2;
        H1 b2;
        C3419zb e2;
        H1 g2;
        V2 c2;
        H1 g3;
        C3366w9 d2;
        H1 i2;
        Gd f2;
        H1 m;
        H1 b3;
        C3337ue d3 = sd.d();
        A1 b4 = d3.c().b();
        boolean l = (b4 == null || (b3 = b4.b()) == null) ? false : b3.l();
        U3 c3 = d3.c();
        boolean l2 = (c3 == null || (f2 = c3.f()) == null || (m = f2.m()) == null) ? false : m.l();
        U3 c4 = d3.c();
        boolean l3 = (c4 == null || (d2 = c4.d()) == null || (i2 = d2.i()) == null) ? false : i2.l();
        U3 c5 = d3.c();
        boolean l4 = (c5 == null || (c2 = c5.c()) == null || (g3 = c2.g()) == null) ? false : g3.l();
        U3 c6 = d3.c();
        boolean l5 = (c6 == null || (e2 = c6.e()) == null || (g2 = e2.g()) == null) ? false : g2.l();
        if (l) {
            A1 b5 = d3.c().b();
            if (b5 == null || (b2 = b5.b()) == null) {
                context2 = context;
            } else {
                context2 = context;
                a(f3320a, C3334ub.s.d().q(), b2, context2, d3, false, 16, null);
            }
        } else {
            context2 = context;
            C3334ub.s.d().q().a(false);
        }
        if (l2) {
            U3 c7 = d3.c();
            Gd f3 = c7 != null ? c7.f() : null;
            Intrinsics.checkNotNull(f3);
            H1 rewardedVideoConfig = f3.m();
            Id i3 = Id.i();
            Intrinsics.checkNotNullExpressionValue(i3, "getInstance()");
            Intrinsics.checkNotNullExpressionValue(rewardedVideoConfig, "rewardedVideoConfig");
            a(this, i3, rewardedVideoConfig, context2, d3, false, 16, null);
        } else {
            Id.i().a(false);
        }
        if (l3) {
            U3 c8 = d3.c();
            C3366w9 d4 = c8 != null ? c8.d() : null;
            Intrinsics.checkNotNull(d4);
            H1 interstitialConfig = d4.i();
            C3400y9 i4 = C3400y9.i();
            Intrinsics.checkNotNullExpressionValue(i4, "getInstance()");
            Intrinsics.checkNotNullExpressionValue(interstitialConfig, "interstitialConfig");
            a(this, i4, interstitialConfig, context2, d3, false, 16, null);
        } else if (l4) {
            U3 c9 = d3.c();
            V2 c10 = c9 != null ? c9.c() : null;
            Intrinsics.checkNotNull(c10);
            H1 bannerConfig = c10.g();
            C3400y9 i5 = C3400y9.i();
            Intrinsics.checkNotNullExpressionValue(i5, "getInstance()");
            Intrinsics.checkNotNullExpressionValue(bannerConfig, "bannerConfig");
            a(this, i5, bannerConfig, context2, d3, false, 16, null);
        } else if (l5) {
            U3 c11 = d3.c();
            C3419zb e3 = c11 != null ? c11.e() : null;
            Intrinsics.checkNotNull(e3);
            H1 g4 = e3.g();
            C3400y9 i6 = C3400y9.i();
            Intrinsics.checkNotNullExpressionValue(i6, "getInstance()");
            a(this, i6, g4, context2, d3, false, 16, null);
        } else {
            C3400y9.i().a(false);
        }
        U3 c12 = d3.c();
        A1 b6 = c12 != null ? c12.b() : null;
        Intrinsics.checkNotNull(b6);
        Rc i7 = b6.i();
        boolean a2 = i7.a();
        String b7 = i7.b();
        boolean c13 = i7.c();
        int d5 = i7.d();
        int[] e4 = i7.e();
        int[] f4 = i7.f();
        Qc qc = Qc.P;
        qc.a(a2);
        if (a2) {
            qc.b(b7, context2);
            qc.b(e4, context2);
            qc.c(f4, context2);
            qc.b(c13);
            qc.c(d5);
        }
    }

    public final void a(final C3013be serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "serverResponse");
        e.c(new Runnable() { // from class: com.ironsource.ge$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                C3101ge.b(C3013be.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Ud ud) {
        i = ud;
        a(false);
        Iterator<Yd> it = g.iterator();
        while (it.hasNext()) {
            a(it.next(), ud);
        }
        g.clear();
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: " + ud, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, Sd sd) {
        b(sd);
        K1 a2 = sd.a();
        X4 x4 = X4.f3123a;
        x4.c(a2.g());
        C3334ub.b bVar = C3334ub.s;
        bVar.a().o().a(a2.c());
        x4.a(a2.f());
        x4.a(a2.j());
        IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(a2.h());
        c().a(a2);
        C3168ke c3168ke = e;
        a(context, c3168ke.c(), sd.d());
        c3168ke.a(new Date().getTime() - k, sd.f());
        C3388xe c3388xe = new C3388xe();
        b = c3388xe;
        c3388xe.a(c());
        IronSourceUtils.saveLastResponse(context, sd.d().toString());
        bVar.d().q().c(true);
        C3400y9.i().c(true);
        Id.i().c(true);
        Qc.P.c(true);
        b(context, sd);
        IronSourceLoggerManager.getLogger(0).setDebugLevel(sd.e().b());
        D1 b2 = sd.b();
        if (b2.f()) {
            c3168ke.a(b2);
        }
        a(sd);
        new Qc.a().a();
        d();
    }

    private final void a(Sd sd) {
        Iterator<Yd> it = g.iterator();
        while (it.hasNext()) {
            a(it.next(), sd);
        }
        g.clear();
    }

    private final void a(boolean z) {
        j = z;
        e.a(b());
    }

    private final void a(final Yd yd, final Sd sd) {
        e.e(new Runnable() { // from class: com.ironsource.ge$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3101ge.b(Yd.this, sd);
            }
        });
    }

    private final void a(final Yd yd, final Ud ud) {
        e.e(new Runnable() { // from class: com.ironsource.ge$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3101ge.b(Yd.this, ud);
            }
        });
    }

    static /* synthetic */ void a(C3101ge c3101ge, AbstractC3326u3 abstractC3326u3, H1 h1, Context context, C3337ue c3337ue, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = true;
        }
        c3101ge.a(abstractC3326u3, h1, context, c3337ue, z);
    }

    private final void a(AbstractC3326u3 abstractC3326u3, H1 h1, Context context, C3337ue c3337ue, boolean z) {
        abstractC3326u3.a(z);
        abstractC3326u3.a(h1.c(), context);
        abstractC3326u3.b(h1.d(), context);
        abstractC3326u3.a(h1.f());
        abstractC3326u3.d(h1.e());
        abstractC3326u3.b(h1.a());
        abstractC3326u3.b(h1.i(), context);
        abstractC3326u3.c(h1.h(), context);
        abstractC3326u3.a(h1.j(), context);
        abstractC3326u3.d(h1.g(), context);
        A1 b2 = c3337ue.c().b();
        Intrinsics.checkNotNull(b2);
        abstractC3326u3.a(b2.j());
        abstractC3326u3.b(h1.k());
        abstractC3326u3.c(h1.b());
    }
}
