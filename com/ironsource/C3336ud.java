package com.ironsource;

import android.app.Activity;
import com.ironsource.C3172l1;
import com.ironsource.InterfaceC3122i1;
import com.ironsource.K8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.ironsourceads.rewarded.RewardedAdInfo;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ud, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3336ud implements InterfaceC3042d6 {

    /* renamed from: a, reason: collision with root package name */
    private B9 f3895a;
    private InterfaceC2982a0 b;
    private X1 c;
    private InterfaceC3240p1 d;
    private Ub e;
    private Cf f;
    private K8 g;
    private K8.a h;
    private final Map<String, C3336ud> i;
    private RewardedAdInfo j;
    private InterfaceC3353vd k;

    public C3336ud(B9 adInstance, InterfaceC2982a0 adNetworkShow, X1 auctionDataReporter, InterfaceC3240p1 analytics, Ub networkDestroyAPI, Cf threadManager, K8 sessionDepthService, K8.a sessionDepthServiceEditor, Map<String, C3336ud> retainer) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(adNetworkShow, "adNetworkShow");
        Intrinsics.checkNotNullParameter(auctionDataReporter, "auctionDataReporter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(networkDestroyAPI, "networkDestroyAPI");
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(sessionDepthService, "sessionDepthService");
        Intrinsics.checkNotNullParameter(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        Intrinsics.checkNotNullParameter(retainer, "retainer");
        this.f3895a = adInstance;
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
        String e = this.f3895a.e();
        Intrinsics.checkNotNullExpressionValue(e, "adInstance.id");
        this.j = new RewardedAdInfo(f, e);
        C3005b6 c3005b6 = new C3005b6();
        this.f3895a.a(c3005b6);
        c3005b6.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C3336ud this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3353vd interfaceC3353vd = this$0.k;
        if (interfaceC3353vd != null) {
            interfaceC3353vd.onRewardedAdShown();
        }
    }

    public final void a(RewardedAdInfo rewardedAdInfo) {
        Intrinsics.checkNotNullParameter(rewardedAdInfo, "<set-?>");
        this.j = rewardedAdInfo;
    }

    public final RewardedAdInfo b() {
        return this.j;
    }

    public final InterfaceC3353vd c() {
        return this.k;
    }

    public final boolean d() {
        boolean a2 = this.b.a(this.f3895a);
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
        this.f.a(new Runnable() { // from class: com.ironsource.ud$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3336ud.b(C3336ud.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidDismiss() {
        this.i.remove(this.j.getAdId());
        InterfaceC3122i1.a.f3348a.a(new InterfaceC3189m1[0]).a(this.d);
        this.f.a(new Runnable() { // from class: com.ironsource.ud$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3336ud.c(C3336ud.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidReward(String str, int i) {
        C3172l1.u uVar = new C3172l1.u("Virtual Item");
        C3172l1.t tVar = new C3172l1.t(1);
        C3172l1.q qVar = new C3172l1.q("DefaultRewardedVideo");
        String transId = IronSourceUtils.getTransId(System.currentTimeMillis(), this.f3895a.g());
        Intrinsics.checkNotNullExpressionValue(transId, "getTransId(System.curren…illis(), adInstance.name)");
        InterfaceC3122i1.a.f3348a.c(uVar, tVar, qVar, new C3172l1.y(transId)).a(this.d);
        this.f.a(new Runnable() { // from class: com.ironsource.ud$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3336ud.d(C3336ud.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void onAdInstanceDidShow() {
        K8 k8 = this.g;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        InterfaceC3122i1.a.f3348a.b(new C3172l1.w(k8.a(ad_unit))).a(this.d);
        this.h.b(ad_unit);
        this.c.b("onAdInstanceDidShow");
        this.f.a(new Runnable() { // from class: com.ironsource.ud$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                C3336ud.e(C3336ud.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3336ud this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3353vd interfaceC3353vd = this$0.k;
        if (interfaceC3353vd != null) {
            interfaceC3353vd.onRewardedAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3336ud this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3353vd interfaceC3353vd = this$0.k;
        if (interfaceC3353vd != null) {
            interfaceC3353vd.onRewardedAdDismissed();
        }
    }

    public final void a(InterfaceC3353vd interfaceC3353vd) {
        this.k = interfaceC3353vd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C3336ud this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3353vd interfaceC3353vd = this$0.k;
        if (interfaceC3353vd != null) {
            interfaceC3353vd.onUserEarnedReward();
        }
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.i.put(this.j.getAdId(), this);
        if (!this.b.a(this.f3895a)) {
            a(C3362w5.f3920a.t());
        } else {
            InterfaceC3122i1.a.f3348a.d(new InterfaceC3189m1[0]).a(this.d);
            this.b.a(activity, this.f3895a);
        }
    }

    @Override // com.ironsource.InterfaceC3042d6
    public void a(String str) {
        a(C3362w5.f3920a.c(new IronSourceError(0, str)));
    }

    private final void a(final IronSourceError ironSourceError) {
        this.i.remove(this.j.getAdId());
        InterfaceC3122i1.a.f3348a.a(new C3172l1.j(ironSourceError.getErrorCode()), new C3172l1.k(ironSourceError.getErrorMessage())).a(this.d);
        this.f.a(new Runnable() { // from class: com.ironsource.ud$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3336ud.a(C3336ud.this, ironSourceError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3336ud this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        InterfaceC3353vd interfaceC3353vd = this$0.k;
        if (interfaceC3353vd != null) {
            interfaceC3353vd.onRewardedAdFailedToShow(error);
        }
    }

    public final void a() {
        Cf.a(this.f, new Runnable() { // from class: com.ironsource.ud$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3336ud.a(C3336ud.this);
            }
        }, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3336ud this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3122i1.d.f3353a.b().a(this$0.d);
        this$0.e.a(this$0.f3895a);
    }

    public /* synthetic */ C3336ud(B9 b9, InterfaceC2982a0 interfaceC2982a0, X1 x1, InterfaceC3240p1 interfaceC3240p1, Ub ub, Cf cf, K8 k8, K8.a aVar, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(b9, interfaceC2982a0, x1, interfaceC3240p1, (i & 16) != 0 ? new Vb() : ub, (i & 32) != 0 ? R7.f3025a : cf, (i & 64) != 0 ? C3334ub.s.d().s() : k8, (i & 128) != 0 ? C3334ub.s.a().h() : aVar, map);
    }
}
