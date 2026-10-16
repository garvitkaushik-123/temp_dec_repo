package com.ironsource;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.AbstractC3242p3;
import com.ironsource.N0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class H2 extends AbstractC3242p3<L2, AdapterAdViewListener> implements InterfaceC3272r0, G2 {
    private C3002b3 K;
    private boolean L;
    private IronSourceBannerLayout M;
    private View N;
    private AbstractC3292s3<?> O;
    private FrameLayout.LayoutParams P;
    private final AtomicBoolean Q;
    private final AtomicBoolean R;

    class a implements D3 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC3292s3 f2890a;

        a(AbstractC3292s3 abstractC3292s3) {
            this.f2890a = abstractC3292s3;
        }

        @Override // com.ironsource.D3
        public void a() {
            ((L2) this.f2890a).Q();
        }
    }

    class b implements D3 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC3292s3 f2891a;

        b(AbstractC3292s3 abstractC3292s3) {
            this.f2891a = abstractC3292s3;
        }

        @Override // com.ironsource.D3
        public void a() {
            ((L2) this.f2891a).Q();
            H2 h2 = H2.this;
            h2.s.i.j(h2.n());
            H2.this.Q.set(false);
            H2.this.W();
            IronLog.INTERNAL.verbose("start binding timer after impression, expected interval = " + H2.this.o.h().b() + ", current timestamp = " + System.currentTimeMillis());
            H2.this.O().h();
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2892a;

        static {
            int[] iArr = new int[N0.a.values().length];
            f2892a = iArr;
            try {
                iArr[N0.a.MANUAL_WITH_AUTOMATIC_RELOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2892a[N0.a.MANUAL_WITH_LOAD_ON_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public H2(List<NetworkSettings> list, V2 v2, String str, Z9 z9, IronSourceSegment ironSourceSegment) {
        super(new I2(str, list, v2), z9, ironSourceSegment);
        this.L = false;
        this.Q = new AtomicBoolean(true);
        this.R = new AtomicBoolean(false);
        this.K = N();
    }

    private void M() {
        int i = c.f2892a[this.q.b().a().ordinal()];
        if (i == 1) {
            P().a();
        } else {
            if (i != 2) {
                return;
            }
            P().l();
            P().m();
            O().a();
            O().b();
        }
    }

    private C3002b3 N() {
        return new C3002b3(this.o.h(), this.o.g(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C3002b3 O() {
        return this.K;
    }

    private C3107h3 P() {
        return (C3107h3) this.q;
    }

    private ISBannerSize Q() {
        IronSourceBannerLayout ironSourceBannerLayout = this.M;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return this.M.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? com.ironsource.mediationsdk.l.a() : ISBannerSize.BANNER : this.M.getSize();
    }

    private boolean S() {
        IronLog.INTERNAL.verbose(b(this.N + ", " + this.P + ", " + this.O));
        return (this.N == null || this.P == null || this.O == null) ? false : true;
    }

    private void U() {
        int i = c.f2892a[this.q.b().a().ordinal()];
        if (i == 1) {
            P().k();
        } else {
            if (i != 2) {
                return;
            }
            P().r();
        }
    }

    private void V() {
        int i = c.f2892a[this.q.b().a().ordinal()];
        if (i == 1) {
            P().k();
        } else {
            if (i != 2) {
                return;
            }
            P().q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.O = null;
        this.N = null;
        this.P = null;
    }

    boolean R() {
        if (!this.M.isShown()) {
            IronLog.INTERNAL.verbose("banner or one of its parents are INVISIBLE or GONE");
            return false;
        }
        if (!this.M.hasWindowFocus()) {
            IronLog.INTERNAL.verbose("banner has no window focus");
            return false;
        }
        boolean globalVisibleRect = this.M.getGlobalVisibleRect(new Rect());
        IronLog.INTERNAL.verbose("visible = " + globalVisibleRect);
        return globalVisibleRect;
    }

    public void T() {
        IronSourceBannerLayout ironSourceBannerLayout = this.M;
        if (ironSourceBannerLayout != null) {
            a(ironSourceBannerLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.AbstractC3242p3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public L2 a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, int i, String str, C3207n2 c3207n2) {
        return new L2(this, new C3171l0(IronSource.AD_UNIT.BANNER, this.o.o(), i, this.g, str, this.e, this.f, networkSettings, this.o.n()), baseAdAdapter, this.M, this.i, v(), c3207n2, this);
    }

    @Override // com.ironsource.G2
    public void c() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, binding skipped");
            O().h();
            this.s.f.b(IronSourceError.ERROR_BN_BINDING_SKIP_INVISIBLE);
        } else if (S()) {
            IronLog.INTERNAL.verbose("done binding timer, binding view now, current timestamp = " + System.currentTimeMillis());
            c(this.O, this.N, this.P);
        } else {
            IronLog.INTERNAL.verbose("Cannot bind banner view after interval, the next ad is not ready yet");
            this.Q.set(true);
        }
    }

    @Override // com.ironsource.G2
    public void d() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, starting the impression timeout timer again");
            O().e();
        } else if (this.R.compareAndSet(false, true)) {
            IronLog.INTERNAL.verbose("banner impression timeout reached, reloading banner manually");
            U();
            this.s.j.b("banner impression timeout reached, reloading banner manually");
        }
    }

    @Override // com.ironsource.T0
    public void f(AbstractC3292s3<?> abstractC3292s3) {
        IronLog.INTERNAL.verbose(b(abstractC3292s3.k()));
        this.t.f(abstractC3292s3.f());
    }

    @Override // com.ironsource.AbstractC3242p3
    protected K0 g() {
        return new C3019c3();
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void g(AbstractC3292s3<?> abstractC3292s3) {
    }

    @Override // com.ironsource.AbstractC3242p3
    protected P0 h() {
        return new C3107h3(this.o.h(), this);
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void h(AbstractC3292s3<?> abstractC3292s3) {
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String l() {
        return "BN";
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String o() {
        return IronSourceConstants.OPW_BN_MANAGER_NAME;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected boolean v() {
        return this.L;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void a(Context context, com.ironsource.mediationsdk.i iVar, S1 s1) {
        if (this.c == null) {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        } else {
            iVar.a(Q());
            this.c.a(context, iVar, s1);
        }
    }

    @Override // com.ironsource.AbstractC3242p3
    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return ((AdapterSettingsInterface) adapterBaseInterface).getBannerLoadWhileShowSupportedState(networkSettings);
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void a(int i, String str, boolean z) {
        if (v()) {
            if (!z) {
                this.s.f.a(C3126i5.a(this.n), i, str);
                com.ironsource.mediationsdk.n.a().b(this.o.b(), new IronSourceError(i, str));
            }
            if (v()) {
                a(AbstractC3242p3.f.SHOWING);
                V();
                return;
            }
            return;
        }
        super.a(i, str, z);
    }

    @Override // com.ironsource.AbstractC3242p3, com.ironsource.InterfaceC3216nb
    public void b() {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        try {
            if (this.M == null) {
                ironLog.error("mIronSourceBanner is null");
                this.s.f.b(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL);
                return;
            }
            if (R()) {
                synchronized (this.x) {
                    if (a(AbstractC3242p3.f.SHOWING, AbstractC3242p3.f.READY_TO_LOAD)) {
                        ironLog.verbose("start reload");
                        z = true;
                        this.L = true;
                    } else {
                        ironLog.error("wrong state = " + this.p);
                        z = false;
                    }
                }
                if (z) {
                    a(this.M, this.i);
                    return;
                }
                return;
            }
            if (this.o.h().a() == N0.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
                ironLog.verbose("banner is not visible, reload skipped");
                this.s.f.b(613);
            }
            U();
        } catch (Throwable th) {
            C3260q4.d().a(th);
            this.s.j.c(th.getMessage());
        }
    }

    private void c(AbstractC3292s3<?> abstractC3292s3, View view, FrameLayout.LayoutParams layoutParams) {
        if (a(AbstractC3242p3.f.READY_TO_SHOW, AbstractC3242p3.f.SHOWING)) {
            this.R.set(false);
            O().e();
            ((L2) abstractC3292s3).R();
            com.ironsource.mediationsdk.l.a(this.M, view, layoutParams, new b(abstractC3292s3));
            return;
        }
        IronLog.INTERNAL.verbose("wrong state = " + this.p);
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, Placement placement) {
        String format;
        IronLog.INTERNAL.verbose("placement = " + placement);
        int i = 510;
        if (!b(ironSourceBannerLayout)) {
            format = String.format("can't load banner - %s", ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed");
        } else if (placement != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            if (this.E.c(ContextProvider.getInstance().getApplicationContext(), placement, this.o.b())) {
                format = String.format("placement %s is capped", placement.getPlacementName());
                i = C3408z0.f(this.o.b());
            } else {
                format = null;
            }
        } else {
            format = String.format("can't load banner - %s", placement == null ? "placement is null" : "placement name is empty");
            i = C3408z0.b(this.o.b());
        }
        if (!TextUtils.isEmpty(format)) {
            IronLog.API.error(b(format));
            a(i, format, false);
        } else {
            com.ironsource.mediationsdk.l.b(ironSourceBannerLayout);
            this.M = ironSourceBannerLayout;
            this.i = placement;
            A();
        }
    }

    @Override // com.ironsource.T0
    public void c(AbstractC3292s3<?> abstractC3292s3) {
        IronLog.INTERNAL.verbose(b(abstractC3292s3.k()));
        this.t.b(abstractC3292s3.f());
    }

    boolean b(IronSourceBannerLayout ironSourceBannerLayout) {
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    private void b(AbstractC3292s3<?> abstractC3292s3, View view, FrameLayout.LayoutParams layoutParams) {
        ((L2) abstractC3292s3).R();
        com.ironsource.mediationsdk.l.a(this.M, view, layoutParams, new a(abstractC3292s3));
    }

    @Override // com.ironsource.T0
    public void b(AbstractC3292s3<?> abstractC3292s3) {
        IronLog.INTERNAL.verbose(b(abstractC3292s3.k()));
        this.t.e(abstractC3292s3.f());
    }

    @Override // com.ironsource.AbstractC3242p3
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getBannerSettings();
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        int a2;
        try {
            if (!b(ironSourceBannerLayout)) {
                IronLog.API.error("destroy banner failed - errorMessage = " + String.format("can't destroy banner - %s", ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed"));
                return;
            }
            IronLog.INTERNAL.verbose("destroying banner");
            M();
            L2 l2 = (L2) this.f3628a.d();
            if (l2 != null) {
                if (l2.r() != null) {
                    a2 = l2.r().intValue();
                } else {
                    a2 = this.C.a(this.o.b());
                }
                this.s.f.a(a2);
                l2.P();
                this.f3628a.a(null);
                this.f3628a.b(null);
            }
            com.ironsource.mediationsdk.l.a(ironSourceBannerLayout);
            this.M = null;
            this.i = null;
            this.L = false;
            if (P().o()) {
                this.Q.set(true);
                this.R.set(false);
                W();
            }
            a(AbstractC3242p3.f.READY_TO_LOAD);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.p;
            IronLog.INTERNAL.error(b(str));
            D0 d0 = this.s;
            if (d0 != null) {
                d0.j.g(str);
            }
        }
    }

    @Override // com.ironsource.AbstractC3242p3, com.ironsource.C0
    public Map<String, Object> a(A0 a0) {
        Map<String, Object> a2 = super.a(a0);
        if (b(this.M)) {
            com.ironsource.mediationsdk.l.a(a2, this.M.getSize());
        }
        if (this.i != null) {
            a2.put("placement", n());
        }
        return a2;
    }

    @Override // com.ironsource.InterfaceC3272r0
    public void a(AbstractC3292s3<?> abstractC3292s3, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose("mState = " + this.p);
        super.d(abstractC3292s3);
        if (this.o.h().a() == N0.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            if (a(AbstractC3242p3.f.READY_TO_SHOW, AbstractC3242p3.f.SHOWING)) {
                this.f3628a.a(abstractC3292s3);
                this.f3628a.b(abstractC3292s3);
                b(abstractC3292s3, view, layoutParams);
                P().k();
                this.t.c(abstractC3292s3.f());
                return;
            }
            return;
        }
        if (P().o()) {
            this.f3628a.b(abstractC3292s3);
            if (this.Q.get()) {
                c(abstractC3292s3, view, layoutParams);
            } else {
                this.O = abstractC3292s3;
                this.N = view;
                this.P = layoutParams;
            }
            this.t.c(abstractC3292s3.f());
        }
    }

    @Override // com.ironsource.AbstractC3242p3, com.ironsource.Q0
    public void a(AbstractC3292s3<?> abstractC3292s3) {
        super.a(abstractC3292s3);
        if (P().o()) {
            if (this.R.compareAndSet(false, true)) {
                O().b();
                U();
            } else {
                IronLog.INTERNAL.verbose("Impression already recorded as receive, it can occur from network onAdOpened or from impression timeout timer - loading next ad already in progress");
            }
        }
    }

    @Override // com.ironsource.AbstractC3242p3
    protected AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.o.b(), str, this.M);
    }
}
