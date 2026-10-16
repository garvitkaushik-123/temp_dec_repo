package com.ironsource;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.y2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3393y2 extends AbstractC3407z implements BannerAdListener {
    private WeakReference<A2> x;
    private View y;
    private FrameLayout.LayoutParams z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3393y2(V0 adTools, A instanceData, G adInstancePayload, A2 listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.x = new WeakReference<>(listener);
    }

    private final ISBannerSize I() {
        V0 f = f();
        AbstractC3340v0 i = n().i();
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return f.a(((N2) i).b().h());
    }

    private final void J() {
        Placement j = j();
        if (j != null) {
            f().e().a().f(j.getPlacementName());
        }
        A2 a2 = this.x.get();
        if (a2 != null) {
            a2.a(this);
        }
    }

    private final void K() {
        Placement j = j();
        if (j != null) {
            f().e().a().c(j.getPlacementName());
        }
        A2 a2 = this.x.get();
        if (a2 != null) {
            a2.b(this);
        }
    }

    private final void L() {
        Placement j = j();
        if (j != null) {
            f().e().a().h(j.getPlacementName());
        }
        A2 a2 = this.x.get();
        if (a2 != null) {
            a2.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3393y2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C3393y2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L();
    }

    @Override // com.ironsource.AbstractC3407z
    protected void A() {
        if (!(g() instanceof AdapterBannerInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
            return;
        }
        AdData i = i();
        ISBannerSize I = I();
        Map<String, Object> adUnitData = i.getAdUnitData();
        Intrinsics.checkNotNullExpressionValue(adUnitData, "adData.adUnitData");
        adUnitData.put("bannerLayout", new IronSourceBannerLayout(ContextProvider.getInstance().getApplicationContext(), I));
        Object g = g();
        Intrinsics.checkNotNull(g, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterBannerInterface) g).loadAd(i, ContextProvider.getInstance().getCurrentActiveActivity(), I, this);
    }

    @Override // com.ironsource.AbstractC3407z
    public void a(I adInstancePresenter) {
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    @Override // com.ironsource.AbstractC3407z
    public void b() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(q());
        C3047db.a(f(), new Runnable() { // from class: com.ironsource.y2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3393y2.a(C3393y2.this);
            }
        }, 0L, 2, (Object) null);
        if (g() == null) {
            ironLog.warning("adapter == null");
            return;
        }
        try {
            if (g() instanceof AdapterBannerInterface) {
                Object g = g();
                Intrinsics.checkNotNull(g, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<*>");
                ((AdapterBannerInterface) g).destroyAd(i());
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            f().e().h().g(str);
        }
        super.b();
    }

    @Override // com.ironsource.AbstractC3407z
    public LevelPlayAdInfo e() {
        String uuid = n().i().b().b().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "instanceData.adUnitData.…roperties.adId.toString()");
        String c = n().i().b().c();
        String ad_unit = n().h().toString();
        Intrinsics.checkNotNullExpressionValue(ad_unit, "instanceData.adFormat.toString()");
        ImpressionData a2 = n().n().a(k());
        C3132ib d = n().n().d();
        AbstractC3340v0 i = n().i();
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return new LevelPlayAdInfo(uuid, c, ad_unit, a2, d, ((N2) i).b().h(), n().i().l());
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        a(new Runnable() { // from class: com.ironsource.y2$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3393y2.b(C3393y2.this);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(final View adView, final FrameLayout.LayoutParams frameLayoutParams) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(frameLayoutParams, "frameLayoutParams");
        C3047db.a(f(), new Runnable() { // from class: com.ironsource.y2$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                C3393y2.a(C3393y2.this, adView, frameLayoutParams);
            }
        }, 0L, 2, (Object) null);
        super.onAdLoadSuccess();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        a(new Runnable() { // from class: com.ironsource.y2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3393y2.c(C3393y2.this);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        a(new Runnable() { // from class: com.ironsource.y2$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                C3393y2.d(C3393y2.this);
            }
        });
    }

    public final void a(final Yf viewBinder) {
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        C3047db.a(f(), new Runnable() { // from class: com.ironsource.y2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3393y2.a(C3393y2.this, viewBinder);
            }
        }, 0L, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final C3393y2 this$0, Yf viewBinder) {
        FrameLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewBinder, "$viewBinder");
        View view = this$0.y;
        if (view == null || (layoutParams = this$0.z) == null) {
            return;
        }
        viewBinder.a(view, layoutParams, this$0.f());
        IronLog.INTERNAL.verbose(C3205n0.a(this$0.f(), "Bind banner view", (String) null, 2, (Object) null));
        this$0.f().d(new Runnable() { // from class: com.ironsource.y2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3393y2.e(C3393y2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3393y2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y = null;
        this$0.z = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3393y2 this$0, View adView, FrameLayout.LayoutParams frameLayoutParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adView, "$adView");
        Intrinsics.checkNotNullParameter(frameLayoutParams, "$frameLayoutParams");
        this$0.y = adView;
        this$0.z = frameLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C3393y2 this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M a2 = this$0.f().e().a();
        Placement j = this$0.j();
        if (j == null || (str = j.getPlacementName()) == null) {
            str = "";
        }
        a2.j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3393y2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
    }
}
