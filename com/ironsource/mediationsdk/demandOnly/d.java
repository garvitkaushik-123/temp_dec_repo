package com.ironsource.mediationsdk.demandOnly;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.C3000b1;
import com.ironsource.C3038d2;
import com.ironsource.C3126i5;
import com.ironsource.C3207n2;
import com.ironsource.C3210n5;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3400y9;
import com.ironsource.C3413z5;
import com.ironsource.InterfaceC3001b2;
import com.ironsource.K8;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.b;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class d extends m implements BannerSmashListener, InterfaceC3001b2 {
    private C3126i5 n;
    private C3126i5 o;
    private String p;
    private String q;
    private C3038d2 r;
    private com.ironsource.mediationsdk.e s;
    private ISDemandOnlyBannerLayout t;
    private final K8 u;
    private final K8.a v;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ironsource.mediationsdk.i f3513a;

        a(com.ironsource.mediationsdk.i iVar) {
            this.f3513a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(83500, (Object[][]) null);
            IronLog.INTERNAL.verbose("auction waterfallString = " + this.f3513a.r());
            d.this.a(83510, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.f3513a.r()}});
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            d dVar = d.this;
            dVar.s.a(applicationContext, this.f3513a, dVar);
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + d.this.k());
            d.this.a(new IronSourceError(608, "load timed out"));
        }
    }

    public d(String str, String str2, NetworkSettings networkSettings, long j, AbstractAdapter abstractAdapter, com.ironsource.mediationsdk.e eVar) {
        super(new C3000b1(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.u = C3334ub.U().s();
        this.v = C3334ub.O().h();
        this.f = j;
        this.p = str;
        this.q = str2;
        this.r = new C3038d2();
        this.f3524a.initBannerForBidding(str, str2, this.c, this);
        this.s = eVar;
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(618, "No available ad to load"));
            } else {
                a(83302, (Object[][]) null);
                this.o = new C3126i5();
                this.f3524a.initBannerForBidding(this.p, this.q, this.c, this);
                this.f3524a.loadBannerForDemandOnlyForBidding(this.c, str, this.t, this);
            }
        }
    }

    private boolean t() {
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.t;
        return iSDemandOnlyBannerLayout == null || iSDemandOnlyBannerLayout.isDestroyed();
    }

    private void u() {
        IronLog.INTERNAL.verbose();
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(q()));
    }

    private void v() {
        this.g = null;
        this.h = null;
        this.r = new C3038d2();
    }

    private void w() {
        IronLog.INTERNAL.verbose();
        a(new b());
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, o oVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        if (iSDemandOnlyBannerLayout == null) {
            a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is null | state: " + k()}});
            return;
        }
        m.a[] aVarArr = {m.a.NOT_LOADED, m.a.LOADED};
        m.a aVar = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(aVarArr, aVar);
        if (a2 == aVar || a2 == m.a.SHOW_IN_PROGRESS) {
            if (iSDemandOnlyBannerLayout.isDestroyed()) {
                a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is destroyed | state: " + k()}});
                return;
            }
            String str = "banner layout in blocking state | state: " + k();
            iSDemandOnlyBannerLayout.getListener().a(l(), new IronSourceError(619, str));
            a(b.c.e, new Object[][]{new Object[]{"reason", str}});
            return;
        }
        v();
        a(3002, (Object[][]) null);
        if (iSDemandOnlyBannerLayout.isDestroyed()) {
            a(new IronSourceError(610, "bannerLayout is destroyed"));
            return;
        }
        this.t = iSDemandOnlyBannerLayout;
        if (!n()) {
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadBannerForBidder in IAB flow must be called by bidder instances");
            a(3300, (Object[][]) null);
            a(buildLoadFailedError);
            return;
        }
        try {
            d.a aVar2 = (d.a) oVar.a(new C3210n5());
            C3207n2 a3 = new a.C0296a(aVar2.h()).a(h());
            if (a3 == null) {
                IronSourceError buildLoadFailedError2 = ErrorBuilder.buildLoadFailedError("loadBannerForBidder invalid enriched ADM");
                a(3300, (Object[][]) null);
                a(buildLoadFailedError2);
                return;
            }
            String k = a3.k();
            if (k == null) {
                ironLog.error("serverData is null");
                a(new IronSourceError(618, "No available ad to load"));
                return;
            }
            b(k);
            a(aVar2.a());
            a(aVar2.f());
            a(83302, (Object[][]) null);
            this.r.a(a3.b());
            this.n = new C3126i5();
            w();
            this.f3524a.initBannerForBidding(this.p, this.q, this.c, this);
            this.f3524a.loadBannerForDemandOnlyForBidding(this.c, k, iSDemandOnlyBannerLayout, this);
        } catch (Exception e) {
            C3260q4.d().a(e);
            a(ErrorBuilder.buildLoadFailedError("loadBannerForBidder: Exception= " + e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.m
    public Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        try {
            if (t()) {
                hashMap.put("reason", "banner is destroyed");
            } else {
                com.ironsource.mediationsdk.l.a(hashMap, this.t.getSize());
            }
            AbstractAdapter abstractAdapter = this.f3524a;
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : "");
            AbstractAdapter abstractAdapter2 = this.f3524a;
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, abstractAdapter2 != null ? abstractAdapter2.getCoreSDKVersion() : "");
            hashMap.put("spId", this.b.i());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.b.a());
            hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            if (o()) {
                hashMap.put("isOneFlow", 1);
            }
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            hashMap.put("instanceType", Integer.valueOf(this.b.d()));
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put("auctionId", this.g);
            }
            JSONObject jSONObject = this.h;
            if (jSONObject != null && jSONObject.length() > 0) {
                hashMap.put("genericParams", this.h);
            }
            if (!TextUtils.isEmpty(this.j)) {
                hashMap.put("dynamicDemandSource", this.j);
                return hashMap;
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("Instance: " + h() + " " + e.getMessage());
        }
        return hashMap;
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose("smash - " + s());
        a(3008, (Object[][]) null);
        if (t()) {
            return;
        }
        this.t.getListener().a(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose("smash - " + s());
        a(b.C0297b.g, (Object[][]) null);
        if (t()) {
            return;
        }
        this.t.getListener().b(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("smash - " + s());
        a(83300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(C3126i5.a(this.o))}});
        a(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose("smash = " + s());
        K8 k8 = this.u;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        int a2 = k8.a(ad_unit);
        a(b.c.d, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(a2)}, new Object[]{"duration", Long.valueOf(C3126i5.a(this.o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            p();
            if (!t()) {
                this.t.a(view, layoutParams);
            }
            a(3005, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(a2)}, new Object[]{"duration", Long.valueOf(C3126i5.a(this.n))}});
            this.v.b(ad_unit);
            a(this.r.c(), IronSourceUtils.getCurrentMethodName());
            if (t()) {
                return;
            }
            this.t.getListener().c(l());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        if (a(m.a.LOADED, m.a.SHOW_IN_PROGRESS)) {
            IronLog.INTERNAL.verbose("smash - " + s());
            a(3009, (Object[][]) null);
            a(this.r.a(), IronSourceUtils.getCurrentMethodName());
            if (t()) {
                return;
            }
            this.t.getListener().d(l());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("smash - " + s() + " " + ironSourceError.toString());
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose("smash - " + s());
    }

    com.ironsource.mediationsdk.i q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h());
        String str = "" + i() + h();
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(IronSource.AD_UNIT.BANNER);
        iVar.a(arrayList);
        iVar.d(str);
        iVar.c(l());
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(true);
        iVar.c(true);
        iVar.a(this.t.getSize());
        return iVar;
    }

    public void r() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        a(new m.a[]{m.a.LOADED, m.a.LOAD_IN_PROGRESS, m.a.SHOW_IN_PROGRESS}, m.a.NOT_LOADED);
        if (t()) {
            ironLog.error("Banner is null or already destroyed and can't be used anymore");
            return;
        }
        p();
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.t;
        if (iSDemandOnlyBannerLayout != null) {
            iSDemandOnlyBannerLayout.a();
        }
        this.t = null;
        AbstractAdapter abstractAdapter = this.f3524a;
        if (abstractAdapter == null) {
            ironLog.error("can't destroy adapter. mAdapter == null");
        } else {
            abstractAdapter.destroyBanner(this.c);
        }
        a(3305, (Object[][]) null);
        ironLog.verbose("banner layout was destroyed. bannerId: " + l());
    }

    public String s() {
        return this.b.h().isMultipleInstances() ? this.b.h().getProviderTypeForReflection() : this.b.h().getProviderName();
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        if (iSDemandOnlyBannerLayout == null) {
            a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is null | state: " + k()}});
            return;
        }
        m.a[] aVarArr = {m.a.NOT_LOADED, m.a.LOADED};
        m.a aVar = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(aVarArr, aVar);
        if (a2 != aVar && a2 != m.a.SHOW_IN_PROGRESS) {
            v();
            a(3002, (Object[][]) null);
            if (!o()) {
                ironLog.verbose("can't load banner when isOneFlow = false");
                a(new IronSourceError(1063, "Missing configuration settings"));
                return;
            }
            this.t = iSDemandOnlyBannerLayout;
            this.n = new C3126i5();
            w();
            if (this.s.a()) {
                u();
                return;
            } else {
                ironLog.verbose("can't load the banner the auction isn't enabled");
                a(new IronSourceError(1063, "Missing server configuration"));
                return;
            }
        }
        if (iSDemandOnlyBannerLayout.isDestroyed()) {
            a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is destroyed | state: " + k()}});
            return;
        }
        String str = "banner layout in blocking state | state: " + k();
        iSDemandOnlyBannerLayout.getListener().a(l(), new IronSourceError(619, str));
        a(b.c.e, new Object[][]{new Object[]{"reason", str}});
    }

    @Override // com.ironsource.S1
    public void a(int i, String str, int i2, String str2, long j) {
        IronLog.INTERNAL.verbose("Auction failed. error " + i + " - " + str);
        this.g = null;
        this.h = null;
        a(b.c.g, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(621, "No available ad to load"));
        }
    }

    @Override // com.ironsource.S1
    public void a(List<C3207n2> list, String str, C3207n2 c3207n2, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        IronLog.INTERNAL.error("onAuctionSuccess - Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("error = " + ironSourceError.getErrorMessage() + " smash - " + s());
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            p();
            a(ironSourceError, C3126i5.a(this.n));
            a(this.r.b(), IronSourceUtils.getCurrentMethodName());
            if (t()) {
                return;
            }
            this.t.getListener().a(l(), ironSourceError);
        }
    }

    private void a(IronSourceError ironSourceError, long j) {
        if (ironSourceError.getErrorCode() == 606) {
            a(b.C0297b.i, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(j)}});
        } else {
            a(3300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(j)}});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object[][] objArr) {
        Map<String, Object> j = j();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    if (objArr2[1] != null) {
                        j.put(objArr2[0].toString(), objArr2[1]);
                    }
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
        C3400y9.i().a(new C3413z5(i, new JSONObject(j)));
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.j, str);
    }

    @Override // com.ironsource.InterfaceC3001b2
    public void a(d.a aVar, int i, long j, int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        this.g = aVar.a();
        this.h = aVar.f();
        a.C0296a c0296a = new a.C0296a(aVar.h());
        if (!TextUtils.isEmpty(str)) {
            a(88002, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str}});
        }
        a(b.c.h, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        a(b.c.j, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, c0296a.b()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (c0296a.isEmpty()) {
                IronSourceError ironSourceError = new IronSourceError(b.C0297b.i, "There is no available ad to load");
                ironLog.error("loadBanner - empty waterfall");
                a(ironSourceError);
                return;
            }
            C3207n2 c3207n2 = c0296a.get(0);
            this.r.a(c3207n2.b());
            this.r.c(c3207n2.h());
            this.r.b(c3207n2.g());
            String k = c3207n2.k();
            b(k);
            c(k);
        }
    }
}
