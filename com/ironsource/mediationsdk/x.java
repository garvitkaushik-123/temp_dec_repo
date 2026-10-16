package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.A3;
import com.ironsource.A5;
import com.ironsource.C3000b1;
import com.ironsource.C3124i3;
import com.ironsource.C3126i5;
import com.ironsource.C3260q4;
import com.ironsource.C3400y9;
import com.ironsource.C3413z5;
import com.ironsource.InterfaceC3049dd;
import com.ironsource.V9;
import com.ironsource.Ye;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class x extends y implements BannerSmashListener, Ye.a, A3 {
    private k h;
    private Ye i;
    private a j;
    private InterfaceC3049dd k;
    private IronSourceBannerLayout l;
    private String m;
    private JSONObject n;
    private int o;
    private String p;
    private C3124i3 q;
    private final Object r;
    private C3126i5 s;
    private boolean t;
    private boolean u;
    private JSONObject v;

    protected enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    x(k kVar, InterfaceC3049dd interfaceC3049dd, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i, boolean z) {
        this(kVar, interfaceC3049dd, networkSettings, abstractAdapter, i, "", null, 0, "", z);
    }

    private void A() {
        IronLog.INTERNAL.verbose();
        a(a.INIT_IN_PROGRESS);
        F();
        try {
            if (this.f3591a != null) {
                if (p()) {
                    this.f3591a.initBannerForBidding(this.h.a(), this.h.i(), this.d, this);
                } else {
                    this.f3591a.initBanners(this.h.a(), this.h.i(), this.d, this);
                }
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to init banner from " + this.f3591a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            onBannerInitFailed(new IronSourceError(612, th.getLocalizedMessage()));
            a(A5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean B() {
        boolean z;
        synchronized (this.r) {
            z = this.j == a.DESTROYED;
        }
        return z;
    }

    private boolean C() {
        boolean z;
        synchronized (this.r) {
            z = this.j == a.LOADED;
        }
        return z;
    }

    private void F() {
        if (this.f3591a == null) {
            return;
        }
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (TextUtils.isEmpty(pluginType)) {
                return;
            }
            this.f3591a.setPluginData(pluginType);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to set custom params from " + this.f3591a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(A5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_internal)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean b(A5 a5) {
        return a5 == A5.BN_INSTANCE_LOAD_SUCCESS || a5 == A5.BN_INSTANCE_LOAD || a5 == A5.BN_INSTANCE_RELOAD || a5 == A5.BN_INSTANCE_RELOAD_SUCCESS || a5 == A5.BN_INSTANCE_CLICK || a5 == A5.BN_INSTANCE_DESTROY || a5 == A5.BN_INSTANCE_LOAD_ERROR || a5 == A5.BN_INSTANCE_LOAD_NO_FILL || a5 == A5.BN_INSTANCE_RELOAD_NO_FILL || a5 == A5.BN_INSTANCE_PRESENT_SCREEN || a5 == A5.BN_INSTANCE_DISMISS_SCREEN || a5 == A5.BN_INSTANCE_LEAVE_APP || a5 == A5.BN_INSTANCE_SHOW;
    }

    private void u() {
        IronLog.INTERNAL.verbose("isBidder = " + p() + ", shouldEarlyInit = " + s());
        this.u = true;
        A();
    }

    public void D() {
        this.f3591a.onBannerViewBound(this.b.h().getBannerSettings());
    }

    public void E() {
        this.f3591a.onBannerViewWillBind(this.b.h().getBannerSettings());
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, C3124i3 c3124i3, String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        this.q = c3124i3;
        this.v = jSONObject;
        if (!l.c(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            ironLog.verbose(str2);
            this.k.a(new IronSourceError(610, str2), this, false);
            return;
        }
        if (this.f3591a == null) {
            ironLog.verbose("mAdapter is null");
            this.k.a(new IronSourceError(611, "mAdapter is null"), this, false);
            return;
        }
        this.l = ironSourceBannerLayout;
        this.i.a((Ye.a) this);
        try {
            if (p()) {
                a(str, this.v);
            } else {
                A();
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error("exception = " + th.getLocalizedMessage());
            onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
        }
    }

    @Override // com.ironsource.A3
    public void collectBiddingData(AdData adData, BiddingDataCallback biddingDataCallback) {
        a(A5.BN_INSTANCE_COLLECT_TOKEN);
        try {
            this.f3591a.collectBannerBiddingData(this.d, adData != null ? V9.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to collectBannerBiddingData from " + this.f3591a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.y
    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.BANNER;
    }

    @Override // com.ironsource.mediationsdk.y
    public String k() {
        return "ProgBannerSmash";
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(f());
        a(A5.BN_INSTANCE_CLICK);
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(f());
        a(A5.BN_INSTANCE_LEAVE_APP);
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose(y() + "error = " + ironSourceError);
        this.i.e();
        if (a(a.LOADING, a.LOAD_FAILED)) {
            a(ironSourceError);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(f());
        this.i.e();
        if (!a(a.LOADING, a.LOADED)) {
            a(this.t ? A5.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : A5.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS);
            return;
        }
        a(this.t ? A5.BN_INSTANCE_RELOAD_SUCCESS : A5.BN_INSTANCE_LOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(C3126i5.a(this.s))}});
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.a(this, view, layoutParams);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(f());
        a(A5.BN_INSTANCE_DISMISS_SCREEN);
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.e(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(f());
        a(A5.BN_INSTANCE_PRESENT_SCREEN);
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (!C()) {
            ironLog.warning("wrong state - mState = " + this.j);
            a(A5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1}, new Object[]{"reason", "Wrong State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, c()}});
            return;
        }
        a(A5.BN_INSTANCE_SHOW);
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.a(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(y() + "error = " + ironSourceError);
        this.i.e();
        if (!a(a.INIT_IN_PROGRESS, a.NONE)) {
            ironLog.warning("wrong state - mState = " + this.j);
            return;
        }
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.a(ironSourceError, this, false);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(f());
        if (a(a.INIT_IN_PROGRESS, a.READY_TO_LOAD)) {
            if (this.u) {
                this.u = false;
            } else {
                if (p()) {
                    return;
                }
                if (l.c(this.l)) {
                    a((String) null, this.v);
                } else {
                    this.k.a(new IronSourceError(605, this.l == null ? "banner is null" : "banner is destroyed"), this, false);
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.y
    public void q() {
        this.i.d();
        super.q();
    }

    public void t() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a(A5.BN_INSTANCE_DESTROY);
        a(a.DESTROYED);
        AbstractAdapter abstractAdapter = this.f3591a;
        if (abstractAdapter == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            abstractAdapter.destroyBanner(this.b.h().getBannerSettings());
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to destroy banner from " + this.f3591a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(A5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_destroy)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    public String v() {
        return !TextUtils.isEmpty(this.b.h().getAdSourceNameForEvents()) ? this.b.h().getAdSourceNameForEvents() : i();
    }

    public AbstractAdapter w() {
        return this.f3591a;
    }

    public String x() {
        return this.m;
    }

    public String y() {
        return String.format("%s - ", f());
    }

    public String z() {
        return this.b.i();
    }

    x(k kVar, InterfaceC3049dd interfaceC3049dd, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i, String str, JSONObject jSONObject, int i2, String str2, boolean z) {
        super(new C3000b1(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.r = new Object();
        this.j = a.NONE;
        this.h = kVar;
        this.i = new Ye(kVar.e());
        this.k = interfaceC3049dd;
        this.f = i;
        this.m = str;
        this.o = i2;
        this.p = str2;
        this.n = jSONObject;
        this.t = z;
        this.v = null;
        if (r()) {
            u();
        }
    }

    private void a(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (a(a.READY_TO_LOAD, a.LOADING)) {
            this.s = new C3126i5();
            a(this.t ? A5.BN_INSTANCE_RELOAD : A5.BN_INSTANCE_LOAD);
            if (this.f3591a == null) {
                return;
            }
            try {
                try {
                    if (p()) {
                        this.f3591a.loadBannerForBidding(this.d, this.v, str, this.l, this);
                    } else {
                        this.f3591a.loadBanner(this.d, this.v, this.l, this);
                    }
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    C3260q4.d().a(th2);
                    IronLog.INTERNAL.error("Exception while trying to load banner from " + this.f3591a.getProviderName() + ", exception =  " + th2.getLocalizedMessage());
                    onBannerAdLoadFailed(new IronSourceError(605, th2.getLocalizedMessage()));
                    a(A5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{"reason", th2.getLocalizedMessage()}});
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            ironLog.error("wrong state - state = " + this.j);
        }
    }

    private boolean a(a aVar, a aVar2) {
        boolean z;
        synchronized (this.r) {
            if (this.j == aVar) {
                IronLog.INTERNAL.verbose(y() + "set state from '" + this.j + "' to '" + aVar2 + "'");
                this.j = aVar2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void a(a aVar) {
        IronLog.INTERNAL.verbose(y() + "state = " + aVar.name());
        synchronized (this.r) {
            this.j = aVar;
        }
    }

    @Override // com.ironsource.Ye.a
    public void a() {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a aVar = a.INIT_IN_PROGRESS;
        a aVar2 = a.LOAD_FAILED;
        if (a(aVar, aVar2)) {
            ironLog.verbose("init timed out");
            ironSourceError = new IronSourceError(607, "Timed out");
        } else if (a(a.LOADING, aVar2)) {
            ironLog.verbose("load timed out");
            ironSourceError = new IronSourceError(608, "Timed out");
        } else {
            ironLog.error("unexpected state - " + this.j);
            return;
        }
        a(ironSourceError);
    }

    private void a(IronSourceError ironSourceError) {
        boolean z = ironSourceError.getErrorCode() == 606;
        if (z) {
            a(this.t ? A5.BN_INSTANCE_RELOAD_NO_FILL : A5.BN_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{"duration", Long.valueOf(C3126i5.a(this.s))}});
        } else {
            a(this.t ? A5.BN_INSTANCE_RELOAD_ERROR : A5.BN_INSTANCE_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(C3126i5.a(this.s))}});
        }
        InterfaceC3049dd interfaceC3049dd = this.k;
        if (interfaceC3049dd != null) {
            interfaceC3049dd.a(ironSourceError, this, z);
        }
    }

    public void a(A5 a5) {
        a(a5, (Object[][]) null);
    }

    public void a(A5 a5, Object[][] objArr) {
        Map<String, Object> m = m();
        if (B()) {
            m.put("reason", "banner is destroyed");
        } else {
            IronSourceBannerLayout ironSourceBannerLayout = this.l;
            if (ironSourceBannerLayout != null) {
                l.a(m, ironSourceBannerLayout.getSize());
            }
        }
        if (!TextUtils.isEmpty(this.m)) {
            m.put("auctionId", this.m);
        }
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.length() > 0) {
            m.put("genericParams", this.n);
        }
        C3124i3 c3124i3 = this.q;
        if (c3124i3 != null) {
            m.put("placement", c3124i3.getPlacementName());
        }
        if (b(a5)) {
            C3400y9.i().a(m, this.o, this.p);
        }
        m.put("sessionDepth", Integer.valueOf(this.f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    m.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(c() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e));
            }
        }
        C3400y9.i().a(new C3413z5(a5, new JSONObject(m)));
    }
}
