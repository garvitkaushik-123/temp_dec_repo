package com.ironsource;

import android.os.Bundle;
import com.ironsource.C3040d4;
import com.ironsource.C3172l1;
import com.ironsource.Ef;
import com.ironsource.InterfaceC3122i1;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.wd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3370wd implements InterfaceC3148jb, InterfaceC3022c6 {

    /* renamed from: a, reason: collision with root package name */
    private final RewardedAdRequest f3925a;
    private final C3165kb b;
    private final T<RewardedAd> c;
    private final InterfaceC3190m2 d;
    private final InterfaceC3048dc e;
    private final InterfaceC3240p1 f;
    private final InterfaceC3016c0<RewardedAd> g;
    private final Ef.c h;
    private final Executor i;
    private C3126i5 j;
    private Ef k;
    private W1 l;
    private boolean m;

    /* renamed from: com.ironsource.wd$a */
    public static final class a implements Ef.a {
        a() {
        }

        @Override // com.ironsource.Ef.a
        public void a() {
            C3370wd.this.a(C3362w5.f3920a.s());
        }
    }

    public C3370wd(RewardedAdRequest adRequest, C3165kb loadTaskConfig, T<RewardedAd> adLoadTaskListener, InterfaceC3190m2 auctionResponseFetcher, InterfaceC3048dc networkLoadApi, InterfaceC3240p1 analytics, InterfaceC3016c0<RewardedAd> adObjectFactory, Ef.c timerFactory, Executor taskFinishedExecutor) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(loadTaskConfig, "loadTaskConfig");
        Intrinsics.checkNotNullParameter(adLoadTaskListener, "adLoadTaskListener");
        Intrinsics.checkNotNullParameter(auctionResponseFetcher, "auctionResponseFetcher");
        Intrinsics.checkNotNullParameter(networkLoadApi, "networkLoadApi");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adObjectFactory, "adObjectFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
        Intrinsics.checkNotNullParameter(taskFinishedExecutor, "taskFinishedExecutor");
        this.f3925a = adRequest;
        this.b = loadTaskConfig;
        this.c = adLoadTaskListener;
        this.d = auctionResponseFetcher;
        this.e = networkLoadApi;
        this.f = analytics;
        this.g = adObjectFactory;
        this.h = timerFactory;
        this.i = taskFinishedExecutor;
    }

    @Override // com.ironsource.InterfaceC3022c6
    public void a(final B9 adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        this.i.execute(new Runnable() { // from class: com.ironsource.wd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3370wd.a(C3370wd.this, adInstance);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3148jb
    public void start() {
        this.j = new C3126i5();
        this.f.a(new C3172l1.s(this.b.f()), new C3172l1.n(this.b.g().b()), new C3172l1.b(this.f3925a.getAdId$mediationsdk_release()));
        InterfaceC3122i1.c.f3351a.a().a(this.f);
        a(this.f3925a.getExtraParams());
        long h = this.b.h();
        Ef.c cVar = this.h;
        Ef.b bVar = new Ef.b();
        bVar.b(h);
        Unit unit = Unit.INSTANCE;
        Ef a2 = cVar.a(bVar);
        this.k = a2;
        if (a2 != null) {
            a2.a(new a());
        }
        Object a3 = this.d.a();
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
        EnumC3096g9 g = this.b.g();
        C3005b6 c3005b6 = new C3005b6();
        c3005b6.a(this);
        B9 adInstance = new C9(this.f3925a.getProviderName$mediationsdk_release().value(), c3005b6).a(g.b(EnumC3096g9.Bidder)).b(this.b.i()).c().a(this.f3925a.getAdId$mediationsdk_release()).a(MapsKt.plus(new Wb().a(), R5.f3023a.a(this.f3925a.getExtraParams()))).a();
        InterfaceC3240p1 interfaceC3240p12 = this.f;
        String e = adInstance.e();
        Intrinsics.checkNotNullExpressionValue(e, "adInstance.id");
        interfaceC3240p12.a(new C3172l1.b(e));
        C3082fc c3082fc = new C3082fc(c3139j2, this.b.j());
        this.l = new W1(new C3079f9(this.f3925a.getInstanceId(), g.b(), c3139j2.a()), new com.ironsource.mediationsdk.d(), c3139j2.c());
        InterfaceC3122i1.d.f3353a.c().a(this.f);
        InterfaceC3048dc interfaceC3048dc = this.e;
        Intrinsics.checkNotNullExpressionValue(adInstance, "adInstance");
        interfaceC3048dc.a(adInstance, c3082fc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3370wd this$0, B9 adInstance) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInstance, "$adInstance");
        if (this$0.m) {
            return;
        }
        this$0.m = true;
        Ef ef = this$0.k;
        if (ef != null) {
            ef.cancel();
        }
        C3126i5 c3126i5 = this$0.j;
        if (c3126i5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskStartedTime");
            c3126i5 = null;
        }
        InterfaceC3122i1.c.f3351a.a(new C3172l1.f(C3126i5.a(c3126i5))).a(this$0.f);
        W1 w1 = this$0.l;
        if (w1 != null) {
            w1.c("onAdInstanceLoadSuccess");
        }
        InterfaceC3016c0<RewardedAd> interfaceC3016c0 = this$0.g;
        W1 w12 = this$0.l;
        Intrinsics.checkNotNull(w12);
        this$0.c.a(interfaceC3016c0.a(adInstance, w12));
    }

    public /* synthetic */ C3370wd(RewardedAdRequest rewardedAdRequest, C3165kb c3165kb, T t, InterfaceC3190m2 interfaceC3190m2, InterfaceC3048dc interfaceC3048dc, InterfaceC3240p1 interfaceC3240p1, InterfaceC3016c0 interfaceC3016c0, Ef.c cVar, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rewardedAdRequest, c3165kb, t, interfaceC3190m2, interfaceC3048dc, interfaceC3240p1, interfaceC3016c0, (i & 128) != 0 ? new Ef.d() : cVar, (i & 256) != 0 ? R7.f3025a.c() : executor);
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

    @Override // com.ironsource.InterfaceC3022c6
    public void a(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        a(C3362w5.f3920a.c(description));
    }

    public final void a(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.i.execute(new Runnable() { // from class: com.ironsource.wd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3370wd.a(C3370wd.this, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3370wd this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        if (this$0.m) {
            return;
        }
        this$0.m = true;
        Ef ef = this$0.k;
        if (ef != null) {
            ef.cancel();
        }
        InterfaceC3122i1.c.a aVar = InterfaceC3122i1.c.f3351a;
        C3172l1.j jVar = new C3172l1.j(error.getErrorCode());
        C3172l1.k kVar = new C3172l1.k(error.getErrorMessage());
        C3126i5 c3126i5 = this$0.j;
        if (c3126i5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskStartedTime");
            c3126i5 = null;
        }
        aVar.a(jVar, kVar, new C3172l1.f(C3126i5.a(c3126i5))).a(this$0.f);
        W1 w1 = this$0.l;
        if (w1 != null) {
            w1.a("onAdInstanceLoadFail");
        }
        this$0.c.onAdLoadFailed(error);
    }
}
