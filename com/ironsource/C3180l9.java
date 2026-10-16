package com.ironsource;

import android.app.Activity;
import com.ironsource.C3172l1;
import com.ironsource.InterfaceC3122i1;
import com.ironsource.K8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAdInfo;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.l9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3180l9 implements InterfaceC3042d6 {

    /* renamed from: a, reason: collision with root package name */
    private B9 f3447a;
    private InterfaceC2982a0 b;
    private X1 c;
    private InterfaceC3240p1 d;
    private Ub e;
    private Cf f;
    private K8 g;
    private K8.a h;
    private final Map<String, C3180l9> i;
    private InterstitialAdInfo j;
    private InterfaceC3197m9 k;

    public C3180l9(B9 adInstance, InterfaceC2982a0 adNetworkShow, X1 auctionDataReporter, InterfaceC3240p1 analytics, Ub networkDestroyAPI, Cf threadManager, K8 sessionDepthService, K8.a sessionDepthServiceEditor, Map<String, C3180l9> retainer) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(adNetworkShow, "adNetworkShow");
        Intrinsics.checkNotNullParameter(auctionDataReporter, "auctionDataReporter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(networkDestroyAPI, "networkDestroyAPI");
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(sessionDepthService, "sessionDepthService");
        Intrinsics.checkNotNullParameter(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        Intrinsics.checkNotNullParameter(retainer, "retainer");
        this.f3447a = adInstance;
        this.b = adNetworkShow;
        this.c = auctionDataReporter;
        this.d = analytics;
        this.e = networkDestroyAPI;
        this.f = threadManager;
        this.g = sessionDepthService;
        this.h = sessionDepthServiceEditor;
        this.i = retainer;
        String f = adInstance.f();
        Intrinsics.checkNotNullExpressionValue(f, "adInstance.instanceId");
        String e = this.f3447a.e();
        Intrinsics.checkNotNullExpressionValue(e, "adInstance.id");
        this.j = new InterstitialAdInfo(f, e);
        C3005b6 c3005b6 = new C3005b6();
        this.f3447a.a(c3005b6);
        c3005b6.a(this);
    }

    public final void a(InterstitialAdInfo interstitialAdInfo) {
        Intrinsics.checkNotNullParameter(interstitialAdInfo, "<set-?>");
        this.j = interstitialAdInfo;
    }

    public final InterstitialAdInfo b() {
        return this.j;
    }

    public final InterfaceC3197m9 c() {
        return this.k;
    }

    public final boolean d() {
        boolean a2 = this.b.a(this.f3447a);
        InterfaceC3122i1.a.f3348a.a(a2).a(this.d);
        return a2;
    }

    protected final void finalize() {
        a();
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidBecomeVisible() {
        InterfaceC3122i1.a.f3348a.f(new InterfaceC3189m1[0]).a(this.d);
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidClick() {
        InterfaceC3122i1.a.f3348a.a().a(this.d);
        this.f.a(new Runnable() { // from class: com.ironsource.l9$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3180l9.b(C3180l9.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidDismiss() {
        this.i.remove(this.j.getAdId());
        InterfaceC3122i1.a.f3348a.a(new InterfaceC3189m1[0]).a(this.d);
        this.f.a(new Runnable() { // from class: com.ironsource.l9$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3180l9.c(C3180l9.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidReward(String str, int i) {
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidShow() {
        K8 k8 = this.g;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        InterfaceC3122i1.a.f3348a.b(new C3172l1.w(k8.a(ad_unit))).a(this.d);
        this.h.b(ad_unit);
        this.c.b("onAdInstanceDidShow");
        this.f.a(new Runnable() { // from class: com.ironsource.l9$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3180l9.d(C3180l9.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3180l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3197m9 interfaceC3197m9 = this$0.k;
        if (interfaceC3197m9 != null) {
            interfaceC3197m9.onAdInstanceDidClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3180l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3197m9 interfaceC3197m9 = this$0.k;
        if (interfaceC3197m9 != null) {
            interfaceC3197m9.onAdInstanceDidDismiss();
        }
    }

    public final void a(InterfaceC3197m9 interfaceC3197m9) {
        this.k = interfaceC3197m9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C3180l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3197m9 interfaceC3197m9 = this$0.k;
        if (interfaceC3197m9 != null) {
            interfaceC3197m9.onAdInstanceDidShow();
        }
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.i.put(this.j.getAdId(), this);
        if (!this.b.a(this.f3447a)) {
            a(C3362w5.f3920a.t());
        } else {
            InterfaceC3122i1.a.f3348a.d(new InterfaceC3189m1[0]).a(this.d);
            this.b.a(activity, this.f3447a);
        }
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void a(String str) {
        a(C3362w5.f3920a.c(new IronSourceError(0, str)));
    }

    private final void a(final IronSourceError ironSourceError) {
        this.i.remove(this.j.getAdId());
        InterfaceC3122i1.a.f3348a.a(new C3172l1.j(ironSourceError.getErrorCode()), new C3172l1.k(ironSourceError.getErrorMessage())).a(this.d);
        this.f.a(new Runnable() { // from class: com.ironsource.l9$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3180l9.a(C3180l9.this, ironSourceError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3180l9 this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        InterfaceC3197m9 interfaceC3197m9 = this$0.k;
        if (interfaceC3197m9 != null) {
            interfaceC3197m9.onAdInstanceDidFailedToShow(error);
        }
    }

    public final void a() {
        Cf.a(this.f, new Runnable() { // from class: com.ironsource.l9$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3180l9.a(C3180l9.this);
            }
        }, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3180l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3122i1.d.f3353a.b().a(this$0.d);
        this$0.e.a(this$0.f3447a);
    }

    public /* synthetic */ C3180l9(B9 b9, InterfaceC2982a0 interfaceC2982a0, X1 x1, InterfaceC3240p1 interfaceC3240p1, Ub ub, Cf cf, K8 k8, K8.a aVar, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(b9, interfaceC2982a0, x1, interfaceC3240p1, (i & 16) != 0 ? new Vb() : ub, (i & 32) != 0 ? R7.f3025a : cf, (i & 64) != 0 ? C3334ub.s.d().s() : k8, (i & 128) != 0 ? C3334ub.s.a().h() : aVar, map);
    }
}
