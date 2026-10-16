package com.ironsource;

import android.content.Context;
import android.os.Bundle;
import com.ironsource.C3040d4;
import com.ironsource.C3172l1;
import com.ironsource.Ef;
import com.ironsource.InterfaceC3122i1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import com.unity3d.ironsourceads.banner.BannerAdView;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.d3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3039d3 implements InterfaceC3148jb, B2 {

    /* renamed from: a, reason: collision with root package name */
    private final BannerAdRequest f3238a;
    private final AdSize b;
    private final InterfaceC3190m2 c;
    private final C3165kb d;
    private final InterfaceC3048dc e;
    private final InterfaceC3240p1 f;
    private final T<BannerAdView> g;
    private final E2 h;
    private final Ef.c i;
    private final Executor j;
    private C3126i5 k;
    private Ef l;
    private W1 m;
    private boolean n;

    /* renamed from: com.ironsource.d3$a */
    public static final class a implements Ef.a {
        a() {
        }

        @Override // com.ironsource.Ef.a
        public void a() {
            C3039d3.this.a(C3362w5.f3920a.s());
        }
    }

    public C3039d3(BannerAdRequest adRequest, AdSize size, InterfaceC3190m2 auctionResponseFetcher, C3165kb loadTaskConfig, InterfaceC3048dc networkLoadApi, InterfaceC3240p1 analytics, T<BannerAdView> adLoadTaskListener, E2 adLayoutFactory, Ef.c timerFactory, Executor taskFinishedExecutor) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(auctionResponseFetcher, "auctionResponseFetcher");
        Intrinsics.checkNotNullParameter(loadTaskConfig, "loadTaskConfig");
        Intrinsics.checkNotNullParameter(networkLoadApi, "networkLoadApi");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adLoadTaskListener, "adLoadTaskListener");
        Intrinsics.checkNotNullParameter(adLayoutFactory, "adLayoutFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
        Intrinsics.checkNotNullParameter(taskFinishedExecutor, "taskFinishedExecutor");
        this.f3238a = adRequest;
        this.b = size;
        this.c = auctionResponseFetcher;
        this.d = loadTaskConfig;
        this.e = networkLoadApi;
        this.f = analytics;
        this.g = adLoadTaskListener;
        this.h = adLayoutFactory;
        this.i = timerFactory;
        this.j = taskFinishedExecutor;
    }

    private final void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Map<String, String> a2 = R5.f3023a.a(bundle);
        for (String str : a2.keySet()) {
            InterfaceC3122i1.c.f3351a.a(new C3172l1.l(str + C3040d4.i.b + String.valueOf(a2.get(str)))).a(this.f);
        }
    }

    @Override // com.ironsource.B2
    public void onBannerLoadFail(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        a(C3362w5.f3920a.c(description));
    }

    @Override // com.ironsource.B2
    public void onBannerLoadSuccess(final B9 adInstance, final C3078f8 adContainer) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        this.j.execute(new Runnable() { // from class: com.ironsource.d3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3039d3.a(C3039d3.this, adInstance, adContainer);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3148jb
    public void start() {
        this.k = new C3126i5();
        this.f.a(new C3172l1.s(this.d.f()), new C3172l1.n(this.d.g().b()), new C3172l1.c(this.b), new C3172l1.b(this.f3238a.getAdId$mediationsdk_release()));
        InterfaceC3122i1.c.f3351a.a().a(this.f);
        a(this.f3238a.getExtraParams());
        long h = this.d.h();
        Ef.c cVar = this.i;
        Ef.b bVar = new Ef.b();
        bVar.b(h);
        Unit unit = Unit.INSTANCE;
        Ef a2 = cVar.a(bVar);
        this.l = a2;
        if (a2 != null) {
            a2.a(new a());
        }
        Object a3 = this.c.a();
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a3);
        if (m10244exceptionOrNullimpl != null) {
            Intrinsics.checkNotNull(m10244exceptionOrNullimpl, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.error.ISException");
            a(((C2990a8) m10244exceptionOrNullimpl).a());
            a3 = null;
        }
        C3139j2 c3139j2 = (C3139j2) a3;
        if (c3139j2 == null) {
            return;
        }
        InterfaceC3240p1 interfaceC3240p1 = this.f;
        String b = c3139j2.b();
        if (b != null) {
            interfaceC3240p1.a(new C3172l1.d(b));
        }
        JSONObject f = c3139j2.f();
        if (f != null) {
            interfaceC3240p1.a(new C3172l1.m(f));
        }
        String a4 = c3139j2.a();
        if (a4 != null) {
            interfaceC3240p1.a(new C3172l1.g(a4));
        }
        EnumC3096g9 g = this.d.g();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        C3044d8 c3044d8 = new C3044d8(AdapterUtils.dpToPixels(applicationContext, this.b.getWidth()), AdapterUtils.dpToPixels(applicationContext, this.b.getHeight()), this.b.getSizeDescription());
        C3301sc c3301sc = new C3301sc();
        c3301sc.a(this);
        B9 adInstance = new C9(this.f3238a.getProviderName$mediationsdk_release().value(), c3301sc).a(g.b(EnumC3096g9.Bidder)).a(c3044d8).b(this.d.i()).a(this.f3238a.getAdId$mediationsdk_release()).a(MapsKt.plus(new Wb().a(), R5.f3023a.a(this.f3238a.getExtraParams()))).a();
        C3082fc c3082fc = new C3082fc(c3139j2, this.d.j());
        this.m = new W1(new C3079f9(this.f3238a.getInstanceId(), g.b(), c3139j2.a()), new com.ironsource.mediationsdk.d(), c3139j2.c());
        InterfaceC3122i1.d.f3353a.c().a(this.f);
        InterfaceC3048dc interfaceC3048dc = this.e;
        Intrinsics.checkNotNullExpressionValue(adInstance, "adInstance");
        interfaceC3048dc.a(adInstance, c3082fc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3039d3 this$0, B9 adInstance, C3078f8 adContainer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInstance, "$adInstance");
        Intrinsics.checkNotNullParameter(adContainer, "$adContainer");
        if (this$0.n) {
            return;
        }
        this$0.n = true;
        Ef ef = this$0.l;
        if (ef != null) {
            ef.cancel();
        }
        C3126i5 c3126i5 = this$0.k;
        if (c3126i5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskStartedTime");
            c3126i5 = null;
        }
        InterfaceC3122i1.c.f3351a.a(new C3172l1.f(C3126i5.a(c3126i5))).a(this$0.f);
        W1 w1 = this$0.m;
        if (w1 != null) {
            w1.c("onBannerLoadSuccess");
        }
        E2 e2 = this$0.h;
        W1 w12 = this$0.m;
        Intrinsics.checkNotNull(w12);
        this$0.g.a(e2.a(adInstance, adContainer, w12));
    }

    public /* synthetic */ C3039d3(BannerAdRequest bannerAdRequest, AdSize adSize, InterfaceC3190m2 interfaceC3190m2, C3165kb c3165kb, InterfaceC3048dc interfaceC3048dc, InterfaceC3240p1 interfaceC3240p1, T t, E2 e2, Ef.c cVar, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bannerAdRequest, adSize, interfaceC3190m2, c3165kb, interfaceC3048dc, interfaceC3240p1, t, e2, (i & 256) != 0 ? new Ef.d() : cVar, (i & 512) != 0 ? R7.f3025a.c() : executor);
    }

    public final void a(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.j.execute(new Runnable() { // from class: com.ironsource.d3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3039d3.a(C3039d3.this, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3039d3 this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        if (this$0.n) {
            return;
        }
        this$0.n = true;
        Ef ef = this$0.l;
        if (ef != null) {
            ef.cancel();
        }
        InterfaceC3122i1.c.a aVar = InterfaceC3122i1.c.f3351a;
        C3172l1.j jVar = new C3172l1.j(error.getErrorCode());
        C3172l1.k kVar = new C3172l1.k(error.getErrorMessage());
        C3126i5 c3126i5 = this$0.k;
        if (c3126i5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskStartedTime");
            c3126i5 = null;
        }
        aVar.a(jVar, kVar, new C3172l1.f(C3126i5.a(c3126i5))).a(this$0.f);
        W1 w1 = this$0.m;
        if (w1 != null) {
            w1.a("onBannerLoadFail");
        }
        this$0.g.onAdLoadFailed(error);
    }
}
