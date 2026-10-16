package com.ironsource;

import android.app.Activity;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Fb extends AbstractC3407z implements NativeAdListener {
    private AdapterNativeAdData x;
    private AdapterNativeAdViewBinder y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fb(V0 adTools, A instanceData, G adInstancePayload, D listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.ironsource.AbstractC3407z
    protected void A() {
        if (!(g() instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterNativeAdInterface"));
            return;
        }
        AdData i = i();
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            IronLog.INTERNAL.error(a("activity must not be null"));
            f().e().h().g("activity must not be null");
            return;
        }
        Object g = g();
        Intrinsics.checkNotNull(g, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
        Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
        Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "getInstance().currentActiveActivity");
        ((AdapterNativeAdInterface) g).loadAd(i, currentActiveActivity, this);
    }

    public final AdapterNativeAdData I() {
        return this.x;
    }

    public final AdapterNativeAdViewBinder J() {
        return this.y;
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
        if (g() == null) {
            ironLog.warning("adapter == null");
            return;
        }
        try {
            if (g() instanceof AdapterNativeAdInterface) {
                Object g = g();
                Intrinsics.checkNotNull(g, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<*>");
                ((AdapterNativeAdInterface) g).destroyAd(i());
            } else {
                ironLog.error(a("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            f().e().h().g(str);
        }
        super.b();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener
    public void onAdLoadSuccess(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(nativeAdViewBinder, "nativeAdViewBinder");
        this.x = adapterNativeAdData;
        this.y = nativeAdViewBinder;
        super.onAdLoadSuccess();
    }

    public final void a(C3402yb nativeAdBinder) {
        Intrinsics.checkNotNullParameter(nativeAdBinder, "nativeAdBinder");
        nativeAdBinder.a(this.x);
        nativeAdBinder.a(this.y);
    }
}
