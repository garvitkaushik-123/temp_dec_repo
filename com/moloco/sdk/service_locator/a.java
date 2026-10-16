package com.moloco.sdk.service_locator;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.A;
import com.moloco.sdk.internal.B;
import com.moloco.sdk.internal.C3425b;
import com.moloco.sdk.internal.InterfaceC3424a;
import com.moloco.sdk.internal.services.C;
import com.moloco.sdk.internal.services.C3436b;
import com.moloco.sdk.internal.services.C3441e;
import com.moloco.sdk.internal.services.C3443g;
import com.moloco.sdk.internal.services.C3445i;
import com.moloco.sdk.internal.services.D;
import com.moloco.sdk.internal.services.F;
import com.moloco.sdk.internal.services.G;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3435a;
import com.moloco.sdk.internal.services.InterfaceC3440d;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.internal.services.InterfaceC3447k;
import com.moloco.sdk.internal.services.J;
import com.moloco.sdk.internal.services.K;
import com.moloco.sdk.internal.services.SingleObserverBackgroundThenForegroundAnalyticsListener;
import com.moloco.sdk.internal.services.init.g;
import com.moloco.sdk.internal.services.l;
import com.moloco.sdk.internal.services.n;
import com.moloco.sdk.internal.services.o;
import com.moloco.sdk.internal.services.q;
import com.moloco.sdk.internal.services.r;
import com.moloco.sdk.internal.services.s;
import com.moloco.sdk.internal.services.t;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.internal.services.v;
import com.moloco.sdk.internal.services.w;
import com.moloco.sdk.internal.services.y;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3462l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3464n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3460j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.L;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.m;
import io.ktor.client.HttpClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5748a = new a();
    public static final int b = 0;

    /* renamed from: com.moloco.sdk.service_locator.a$a, reason: collision with other inner class name */
    public static final class C0463a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0463a f5749a = new C0463a();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.C0463a.c();
            }
        });
        public static final int c = 8;

        public static final K c() {
            return new K(a.f5748a.a());
        }

        public final InterfaceC3460j a() {
            return C3462l.a(g.f5755a.a(), b.f5750a.f());
        }

        public final K b() {
            return (K) b.getValue();
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5750a = new b();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$b$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.b.a();
            }
        });
        public static final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$b$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.b.j();
            }
        });
        public static final Lazy d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$b$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.b.b();
            }
        });
        public static final Lazy e = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$b$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.b.c();
            }
        });
        public static final Lazy f = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$b$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.b.i();
            }
        });
        public static final int g = 8;

        public static final com.moloco.sdk.internal.services.analytics.b a() {
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i c2 = i.f5757a.c();
            k kVar = k.f5759a;
            return new com.moloco.sdk.internal.services.analytics.b(c2, kVar.b(), kVar.c());
        }

        public static final C3443g b() {
            return new C3443g(ProcessLifecycleOwner.INSTANCE.get().getLifecycle(), f5750a.h());
        }

        public static final com.moloco.sdk.internal.error.c c() {
            return new com.moloco.sdk.internal.error.c(c.f5751a.b(), new com.moloco.sdk.internal.error.api.b(h.f5756a.h(), com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a()));
        }

        public static final com.moloco.sdk.internal.ilrd.b i() {
            return new com.moloco.sdk.internal.ilrd.b(a.f5748a.a());
        }

        public static final SingleObserverBackgroundThenForegroundAnalyticsListener j() {
            return new SingleObserverBackgroundThenForegroundAnalyticsListener(f5750a.d(), h.f5756a.h());
        }

        public final com.moloco.sdk.internal.services.analytics.a d() {
            return (com.moloco.sdk.internal.services.analytics.a) b.getValue();
        }

        public final InterfaceC3442f e() {
            return (InterfaceC3442f) d.getValue();
        }

        public final com.moloco.sdk.internal.error.b f() {
            return (com.moloco.sdk.internal.error.b) e.getValue();
        }

        public final com.moloco.sdk.internal.ilrd.b g() {
            return (com.moloco.sdk.internal.ilrd.b) f.getValue();
        }

        public final SingleObserverBackgroundThenForegroundAnalyticsListener h() {
            return (SingleObserverBackgroundThenForegroundAnalyticsListener) c.getValue();
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5751a = new c();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$c$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.c.a();
            }
        });
        public static final int c = 8;

        public static final com.moloco.sdk.internal.services.config.b a() {
            return new com.moloco.sdk.internal.services.config.b();
        }

        public final com.moloco.sdk.internal.services.config.a b() {
            return (com.moloco.sdk.internal.services.config.a) b.getValue();
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f5752a = new d();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$d$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.d.a();
            }
        });
        public static final int c = 8;

        public static final com.moloco.sdk.internal.error.crash.b a() {
            return new com.moloco.sdk.internal.error.crash.b(new com.moloco.sdk.internal.error.crash.d(CollectionsKt.listOf(new com.moloco.sdk.internal.error.crash.filters.b()), new com.moloco.sdk.internal.error.api.b(h.f5756a.h(), com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a()), MetricsRecorder.INSTANCE.withNoMediation()));
        }

        public final com.moloco.sdk.internal.error.crash.a b() {
            return (com.moloco.sdk.internal.error.crash.a) b.getValue();
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f5753a = new e();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$e$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.e.b();
            }
        });
        public static final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$e$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.e.f();
            }
        });
        public static final Lazy d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$e$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.e.c();
            }
        });
        public static final Lazy e = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$e$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.e.n();
            }
        });
        public static final Lazy f = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$e$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.e.e();
            }
        });
        public static final Lazy g = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$e$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.e.d();
            }
        });
        public static final Lazy h = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$e$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.e.a();
            }
        });
        public static final int i = 8;

        public static final C3436b a() {
            return new C3436b(a.f5748a.a());
        }

        public static final l b() {
            return new l(a.f5748a.a());
        }

        public static final o c() {
            return new o(a.f5748a.a());
        }

        public static final r d() {
            return new r(a.f5748a.a());
        }

        public static final v e() {
            return new v(a.f5748a.a());
        }

        public static final C3445i f() {
            return new C3445i(a.f5748a.a());
        }

        public static final G n() {
            return new G(a.f5748a.a());
        }

        public final InterfaceC3435a g() {
            return (InterfaceC3435a) h.getValue();
        }

        public final InterfaceC3447k h() {
            return (InterfaceC3447k) b.getValue();
        }

        public final n i() {
            return (n) d.getValue();
        }

        public final q j() {
            return (q) g.getValue();
        }

        public final u k() {
            return (u) f.getValue();
        }

        public final y l() {
            return (y) c.getValue();
        }

        public final F m() {
            return (F) e.getValue();
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public static final g f5755a = new g();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$g$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.g.d();
            }
        });
        public static final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$g$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.g.c();
            }
        });
        public static final int d = 8;

        public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j c() {
            g gVar = f5755a;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l b2 = gVar.b();
            e eVar = e.f5753a;
            u k = eVar.k();
            b bVar = b.f5750a;
            com.moloco.sdk.internal.error.b f = bVar.f();
            i iVar = i.f5757a;
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j(gVar.b(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d(eVar.k(), bVar.f(), iVar.a()), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b(b2, k, f, iVar.a()), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.g(a.f5748a.a(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.k.f5870a));
        }

        public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l d() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l) c.f5751a.b().a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l.class, m.a());
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i a() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i) c.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l b() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l) b.getValue();
        }
    }

    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public static final h f5756a = new h();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$h$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.h.l();
            }
        });
        public static final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$h$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.h.k();
            }
        });
        public static final Lazy d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$h$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.h.b();
            }
        });
        public static final Lazy e = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$h$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.h.m();
            }
        });
        public static final Lazy f = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$h$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.h.a();
            }
        });
        public static final int g = 8;

        public static final ActivityManager a() {
            Object systemService = a.f5748a.a().getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            return (ActivityManager) systemService;
        }

        public static final C3441e b() {
            return new C3441e(a.f5748a.a());
        }

        public static final com.moloco.sdk.internal.services.proto.b k() {
            return new com.moloco.sdk.internal.services.proto.b();
        }

        public static final J l() {
            return new J();
        }

        public static final B m() {
            return new B();
        }

        public final ActivityManager c() {
            return (ActivityManager) f.getValue();
        }

        public final InterfaceC3440d d() {
            return (InterfaceC3440d) d.getValue();
        }

        public final s e() {
            return new t(f(), k.f5759a.b());
        }

        public final InterfaceC3463m f() {
            return new C3464n(a.f5748a.a());
        }

        public final com.moloco.sdk.internal.services.proto.a g() {
            return (com.moloco.sdk.internal.services.proto.a) c.getValue();
        }

        public final I h() {
            return (I) b.getValue();
        }

        public final A i() {
            return (A) e.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K j() {
            return new L();
        }
    }

    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        public static final i f5757a = new i();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$i$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.i.e();
            }
        });
        public static final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$i$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.i.f();
            }
        });
        public static final Lazy d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$i$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.i.h();
            }
        });
        public static final Lazy e = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$i$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.i.g();
            }
        });
        public static final int f = 8;

        public static final HttpClient e() {
            e eVar = e.f5753a;
            return com.moloco.sdk.internal.http.a.a(eVar.h().invoke(), eVar.l().invoke());
        }

        public static final C f() {
            return new C(a.f5748a.a(), e.f5753a.l());
        }

        public static final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i g() {
            return com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i.f6372a.a(f5757a.d());
        }

        public static final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m h() {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m(a.f5748a.a());
        }

        public final HttpClient a() {
            return (HttpClient) b.getValue();
        }

        public final com.moloco.sdk.internal.services.B b() {
            return (com.moloco.sdk.internal.services.B) c.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i c() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i) e.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.l d() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.l) d.getValue();
        }
    }

    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        public static final j f5758a = new j();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$j$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.j.a();
            }
        });
        public static final int c = 8;

        public static final D a() {
            SharedPreferences sharedPreferences = a.f5748a.a().getSharedPreferences("moloco_sdk_preferences", 0);
            Intrinsics.checkNotNull(sharedPreferences);
            return new D(sharedPreferences);
        }

        public final w b() {
            return (w) b.getValue();
        }
    }

    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        public static final k f5759a = new k();
        public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$k$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.k.g();
            }
        });
        public static final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$k$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.k.h();
            }
        });
        public static final Lazy d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$k$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.k.a();
            }
        });
        public static final int e = 8;

        public static final com.moloco.sdk.internal.services.events.c a() {
            return new com.moloco.sdk.internal.services.events.c();
        }

        public static final com.moloco.sdk.internal.services.usertracker.c g() {
            return new com.moloco.sdk.internal.services.usertracker.c(j.f5758a.b());
        }

        public static final com.moloco.sdk.internal.services.usertracker.g h() {
            k kVar = f5759a;
            return new com.moloco.sdk.internal.services.usertracker.g(kVar.e(), kVar.d());
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b() {
            e eVar = e.f5753a;
            InterfaceC3447k h = eVar.h();
            com.moloco.sdk.internal.services.B b2 = i.f5757a.b();
            y l = eVar.l();
            F m = eVar.m();
            com.moloco.sdk.internal.services.usertracker.f f = f();
            h hVar = h.f5756a;
            return new com.moloco.sdk.internal.services.events.a(h, b2, l, m, f, hVar.d(), hVar.g(), c(), BuildConfig.SDK_VERSION_NAME);
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c c() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c) d.getValue();
        }

        public final com.moloco.sdk.internal.services.usertracker.b d() {
            return (com.moloco.sdk.internal.services.usertracker.b) b.getValue();
        }

        public final com.moloco.sdk.internal.services.usertracker.e e() {
            return new com.moloco.sdk.internal.services.usertracker.a();
        }

        public final com.moloco.sdk.internal.services.usertracker.f f() {
            return (com.moloco.sdk.internal.services.usertracker.f) c.getValue();
        }
    }

    public final Context a() {
        return com.moloco.sdk.internal.android_context.b.a(null, 1, null);
    }

    public static final class f {
        public static volatile InterfaceC3424a b;

        /* renamed from: a, reason: collision with root package name */
        public static final f f5754a = new f();
        public static final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$f$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.f.f();
            }
        });
        public static final Lazy d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$f$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.f.d();
            }
        });
        public static final Lazy e = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.service_locator.a$f$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.f.e();
            }
        });
        public static final int f = 8;

        public static final com.moloco.sdk.internal.services.init.e d() {
            e eVar = e.f5753a;
            return new com.moloco.sdk.internal.services.init.e(eVar.l(), eVar.h(), k.f5759a.f(), BuildConfig.SDK_VERSION_NAME, BuildConfig.MOLOCO_ENDPOINT_INIT_CONFIG, 3000L, i.f5757a.a());
        }

        public static final com.moloco.sdk.internal.services.init.l e() {
            com.moloco.sdk.internal.services.init.d a2 = f5754a.a();
            g.a aVar = com.moloco.sdk.internal.services.init.g.f5697a;
            SharedPreferences sharedPreferences = a.f5748a.a().getSharedPreferences("moloco_sdk_init_cache", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return new com.moloco.sdk.internal.services.init.l(a2, aVar.a(sharedPreferences), CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))));
        }

        public static final com.moloco.sdk.internal.services.init.o f() {
            return new com.moloco.sdk.internal.services.init.o(BuildConfig.MOLOCO_ENDPOINT_INIT_TRACKING, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a());
        }

        public final InterfaceC3424a a(Init.SDKInitResponse initResponse) {
            InterfaceC3424a interfaceC3424a;
            Intrinsics.checkNotNullParameter(initResponse, "initResponse");
            InterfaceC3424a interfaceC3424a2 = b;
            if (interfaceC3424a2 != null) {
                return interfaceC3424a2;
            }
            synchronized (this) {
                interfaceC3424a = b;
                if (interfaceC3424a == null) {
                    interfaceC3424a = new C3425b(initResponse, k.f5759a.b(), h.f5756a.e());
                    b = interfaceC3424a;
                }
            }
            return interfaceC3424a;
        }

        public final com.moloco.sdk.internal.services.init.k b() {
            return (com.moloco.sdk.internal.services.init.k) e.getValue();
        }

        public final com.moloco.sdk.internal.services.init.n c() {
            return (com.moloco.sdk.internal.services.init.n) c.getValue();
        }

        public final com.moloco.sdk.internal.services.init.d a() {
            return (com.moloco.sdk.internal.services.init.d) d.getValue();
        }
    }
}
