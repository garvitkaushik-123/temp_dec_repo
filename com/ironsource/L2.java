package com.ironsource;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.AbstractC3292s3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Map;

/* loaded from: classes6.dex */
public class L2 extends AbstractC3292s3<InterfaceC3272r0> implements BannerAdListener, C0 {
    public static final String t = "bannerLayout";
    public static final String u = "bannerSize";
    private final IronSourceBannerLayout r;
    private final boolean s;

    class a extends Pd {
        final /* synthetic */ View b;
        final /* synthetic */ FrameLayout.LayoutParams c;

        a(View view, FrameLayout.LayoutParams layoutParams) {
            this.b = view;
            this.c = layoutParams;
        }

        @Override // com.ironsource.Pd
        public void a() {
            L2.this.a(this.b, this.c);
        }
    }

    class b extends Pd {
        b() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            L2.this.J();
        }
    }

    public L2(InterfaceC3012bd interfaceC3012bd, C3171l0 c3171l0, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, IronSourceBannerLayout ironSourceBannerLayout, Placement placement, boolean z, C3207n2 c3207n2, InterfaceC3272r0 interfaceC3272r0) {
        super(interfaceC3012bd, c3171l0, baseAdAdapter, new C3000b1(c3171l0.g(), c3171l0.g().getBannerSettings(), IronSource.AD_UNIT.BANNER), c3207n2, interfaceC3272r0);
        this.r = ironSourceBannerLayout;
        this.g = placement;
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (y()) {
            super.onAdOpened();
            return;
        }
        if (this.e == AbstractC3292s3.h.FAILED) {
            return;
        }
        ironLog.error(String.format("unexpected onAdOpened for %s, state - %s", k(), this.e));
        if (this.d != null) {
            this.d.j.q(String.format("unexpected onAdOpened, state - %s", this.e));
        }
    }

    @Override // com.ironsource.AbstractC3292s3
    protected void G() {
        Object obj = this.c;
        if (obj instanceof AdapterBannerInterface) {
            ((AdapterBannerInterface) obj).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this.r.getSize(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
        }
    }

    @Override // com.ironsource.AbstractC3292s3
    protected boolean O() {
        return false;
    }

    public void P() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(AbstractC3292s3.h.NONE);
        Object obj = this.c;
        if (obj == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (obj instanceof AdapterBannerInterface) {
                ((AdapterBannerInterface) obj).destroyAd(this.k);
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d0 = this.d;
            if (d0 != null) {
                d0.j.g(str);
            }
        }
        D0 d02 = this.d;
        if (d02 != null) {
            d02.f.a(r().intValue());
        }
    }

    public void Q() {
        Object obj = this.c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewBound(this.k);
        }
    }

    public void R() {
        Object obj = this.c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewWillBind(this.k);
        }
    }

    @Override // com.ironsource.AbstractC3292s3
    protected AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        D0 d0;
        Placement placement = this.g;
        if (placement != null && (d0 = this.d) != null) {
            d0.i.f(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != 0) {
            ((InterfaceC3272r0) listener).c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams) {
        if (u().e()) {
            u().a(new a(view, layoutParams));
        } else {
            a(view, layoutParams);
        }
    }

    @Override // com.ironsource.AbstractC3292s3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        if (u().e()) {
            u().a(new b());
        } else {
            J();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        D0 d0;
        Placement placement = this.g;
        if (placement != null && (d0 = this.d) != null) {
            d0.i.c(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != 0) {
            ((InterfaceC3272r0) listener).b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        D0 d0;
        Placement placement = this.g;
        if (placement != null && (d0 = this.d) != null) {
            d0.i.h(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != 0) {
            ((InterfaceC3272r0) listener).f(this);
        }
    }

    @Override // com.ironsource.AbstractC3292s3
    protected boolean v() {
        return this.s;
    }

    @Override // com.ironsource.AbstractC3292s3
    protected Map<String, Object> a(Map<String, Object> map) {
        Map<String, Object> a2 = super.a(map);
        C3171l0 c3171l0 = this.f3690a;
        if (c3171l0 != null && this.r != null && TextUtils.isEmpty(c3171l0.g().getCustomNetwork())) {
            a2.put("bannerLayout", this.r);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        Listener listener;
        super.onAdLoadSuccess();
        if (!y() || (listener = this.b) == 0) {
            return;
        }
        ((InterfaceC3272r0) listener).a(this, view, layoutParams);
    }

    @Override // com.ironsource.AbstractC3292s3, com.ironsource.C0
    public Map<String, Object> a(A0 a0) {
        Map<String, Object> a2 = super.a(a0);
        IronSourceBannerLayout ironSourceBannerLayout = this.r;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            com.ironsource.mediationsdk.l.a(a2, this.r.getSize());
        }
        if (this.g != null) {
            a2.put("placement", j());
        }
        return a2;
    }
}
