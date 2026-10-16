package com.ironsource;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.C3172l1;
import com.ironsource.InterfaceC3122i1;
import com.ironsource.K8;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.ironsourceads.banner.BannerAdInfo;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Q2 implements D2 {

    /* renamed from: a, reason: collision with root package name */
    private final B9 f3004a;
    private final C3078f8 b;
    private final W1 c;
    private final InterfaceC3240p1 d;
    private final Ub e;
    private final Cf f;
    private final K8 g;
    private final K8.a h;
    private BannerAdInfo i;
    private WeakReference<R2> j;
    private WeakReference<FrameLayout> k;

    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            C3044d8 size = Q2.this.d().getSize();
            ((FrameLayout) v).addView(Q2.this.d(), 0, new FrameLayout.LayoutParams(size.c(), size.a(), 17));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ((FrameLayout) v).removeAllViews();
        }
    }

    public Q2(B9 adInstance, C3078f8 container, W1 auctionDataReporter, InterfaceC3240p1 analytics, Ub networkDestroyAPI, Cf threadManager, K8 sessionDepthService, K8.a sessionDepthServiceEditor) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(auctionDataReporter, "auctionDataReporter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(networkDestroyAPI, "networkDestroyAPI");
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(sessionDepthService, "sessionDepthService");
        Intrinsics.checkNotNullParameter(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        this.f3004a = adInstance;
        this.b = container;
        this.c = auctionDataReporter;
        this.d = analytics;
        this.e = networkDestroyAPI;
        this.f = threadManager;
        this.g = sessionDepthService;
        this.h = sessionDepthServiceEditor;
        String f = adInstance.f();
        Intrinsics.checkNotNullExpressionValue(f, "adInstance.instanceId");
        String e = adInstance.e();
        Intrinsics.checkNotNullExpressionValue(e, "adInstance.id");
        this.i = new BannerAdInfo(f, e);
        this.j = new WeakReference<>(null);
        this.k = new WeakReference<>(null);
        C3301sc c3301sc = new C3301sc();
        adInstance.a(c3301sc);
        c3301sc.a(this);
    }

    public final void a(BannerAdInfo bannerAdInfo) {
        Intrinsics.checkNotNullParameter(bannerAdInfo, "<set-?>");
        this.i = bannerAdInfo;
    }

    public final void b(WeakReference<FrameLayout> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.k = value;
        FrameLayout frameLayout = value.get();
        if (frameLayout != null) {
            frameLayout.addOnAttachStateChangeListener(a());
        }
    }

    public final BannerAdInfo c() {
        return this.i;
    }

    public final C3078f8 d() {
        return this.b;
    }

    public final WeakReference<R2> e() {
        return this.j;
    }

    public final WeakReference<FrameLayout> f() {
        return this.k;
    }

    protected final void finalize() {
        b();
    }

    @Override // com.ironsource.D2
    public void onBannerClick() {
        InterfaceC3122i1.a.f3348a.a().a(this.d);
        this.f.a(new Runnable() { // from class: com.ironsource.Q2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Q2.b(Q2.this);
            }
        });
    }

    @Override // com.ironsource.D2
    public void onBannerShowSuccess() {
        K8 k8 = this.g;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        InterfaceC3122i1.a.f3348a.f(new C3172l1.w(k8.a(ad_unit))).a(this.d);
        this.h.b(ad_unit);
        this.c.b("onBannerShowSuccess");
        this.f.a(new Runnable() { // from class: com.ironsource.Q2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Q2.c(Q2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Q2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        R2 r2 = this$0.j.get();
        if (r2 != null) {
            r2.onBannerAdShown();
        }
    }

    public final void a(WeakReference<R2> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.j = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Q2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC3122i1.d.f3353a.b().a(this$0.d);
        this$0.e.a(this$0.f3004a);
    }

    public final void b() {
        Cf.a(this.f, new Runnable() { // from class: com.ironsource.Q2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Q2.a(Q2.this);
            }
        }, 0L, 2, null);
    }

    private final a a() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Q2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        R2 r2 = this$0.j.get();
        if (r2 != null) {
            r2.onBannerAdClicked();
        }
    }

    public /* synthetic */ Q2(B9 b9, C3078f8 c3078f8, W1 w1, InterfaceC3240p1 interfaceC3240p1, Ub ub, Cf cf, K8 k8, K8.a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(b9, c3078f8, w1, interfaceC3240p1, (i & 16) != 0 ? new Vb() : ub, (i & 32) != 0 ? R7.f3025a : cf, (i & 64) != 0 ? C3334ub.s.d().s() : k8, (i & 128) != 0 ? C3334ub.s.a().h() : aVar);
    }
}
