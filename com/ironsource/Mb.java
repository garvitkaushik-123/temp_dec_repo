package com.ironsource;

import android.app.Activity;
import com.ironsource.AbstractC3292s3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes6.dex */
public final class Mb extends AbstractC3292s3<Q0> implements NativeAdListener, C0 {
    private AdapterNativeAdData r;
    private AdapterNativeAdViewBinder s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mb(InterfaceC3012bd threadInterface, C3171l0 adSmashData, BaseAdAdapter<?, AdapterAdListener> baseAdAdapter, Placement placement, C3207n2 item, Q0 q0) {
        super(threadInterface, adSmashData, baseAdAdapter, new C3000b1(adSmashData.g(), adSmashData.g().getNativeAdSettings(), IronSource.AD_UNIT.NATIVE_AD), item, q0);
        Intrinsics.checkNotNullParameter(threadInterface, "threadInterface");
        Intrinsics.checkNotNullParameter(adSmashData, "adSmashData");
        Intrinsics.checkNotNullParameter(item, "item");
        this.g = placement;
    }

    private final void J() {
        Mf mf;
        IronLog.INTERNAL.verbose(d());
        if (y()) {
            super.onAdOpened();
            return;
        }
        if (this.e != AbstractC3292s3.h.FAILED) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("unexpected onAdOpened for %s, state - %s", Arrays.copyOf(new Object[]{k(), this.e}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            D0 d0 = this.d;
            if (d0 == null || (mf = d0.j) == null) {
                return;
            }
            mf.q(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Mb this$0, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "$adapterNativeAdData");
        Intrinsics.checkNotNullParameter(nativeAdViewBinder, "$nativeAdViewBinder");
        this$0.a(adapterNativeAdData, nativeAdViewBinder);
    }

    @Override // com.ironsource.AbstractC3292s3
    protected void G() {
        Mf mf;
        if (!(this.c instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterNativeAdInterface"));
            return;
        }
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            IronLog.INTERNAL.error(a("activity must not be null"));
            D0 d0 = this.d;
            if (d0 == null || (mf = d0.j) == null) {
                return;
            }
            mf.g("activity must not be null");
            return;
        }
        Object obj = this.c;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
        AdData mCurrentAdData = this.k;
        Intrinsics.checkNotNullExpressionValue(mCurrentAdData, "mCurrentAdData");
        Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
        Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "getInstance().currentActiveActivity");
        ((AdapterNativeAdInterface) obj).loadAd(mCurrentAdData, currentActiveActivity, this);
    }

    public final void P() {
        Mf mf;
        C3115hb c3115hb;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(AbstractC3292s3.h.NONE);
        Object obj = this.c;
        if (obj == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (obj instanceof AdapterNativeAdInterface) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<*>");
                AdData mCurrentAdData = this.k;
                Intrinsics.checkNotNullExpressionValue(mCurrentAdData, "mCurrentAdData");
                ((AdapterNativeAdInterface) obj).destroyAd(mCurrentAdData);
            } else {
                ironLog.error(a("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            D0 d0 = this.d;
            if (d0 != null && (mf = d0.j) != null) {
                mf.g(str);
            }
        }
        D0 d02 = this.d;
        if (d02 == null || (c3115hb = d02.f) == null) {
            return;
        }
        Integer sessionDepth = r();
        Intrinsics.checkNotNullExpressionValue(sessionDepth, "sessionDepth");
        c3115hb.a(sessionDepth.intValue());
    }

    public final AdapterNativeAdData Q() {
        return this.r;
    }

    public final AdapterNativeAdViewBinder R() {
        return this.s;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener
    public void onAdLoadSuccess(final AdapterNativeAdData adapterNativeAdData, final AdapterNativeAdViewBinder nativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(nativeAdViewBinder, "nativeAdViewBinder");
        if (u().e()) {
            u().a(new Runnable() { // from class: com.ironsource.Mb$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Mb.a(Mb.this, adapterNativeAdData, nativeAdViewBinder);
                }
            });
        } else {
            a(adapterNativeAdData, nativeAdViewBinder);
        }
    }

    @Override // com.ironsource.AbstractC3292s3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        if (u().e()) {
            u().a(new Runnable() { // from class: com.ironsource.Mb$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Mb.a(Mb.this);
                }
            });
        } else {
            J();
        }
    }

    private final void a(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        this.r = adapterNativeAdData;
        this.s = adapterNativeAdViewBinder;
        super.onAdLoadSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Mb this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
    }

    @Override // com.ironsource.AbstractC3292s3, com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map<String, Object> data = super.a(event);
        if (this.g != null) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            data.put("placement", j());
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        return data;
    }
}
