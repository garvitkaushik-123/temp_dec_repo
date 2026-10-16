package com.fyber.inneractive.sdk.flow;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class f0 implements g0, p0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1202a;
    public InneractiveAdSpot.RequestListener b;
    public InneractiveAdRequest c;
    public d0 d;
    public x e;
    public q0 f;
    public final HashSet g;
    public m h;
    public e0 i;
    public boolean j = true;
    public boolean k = false;
    public p l;

    public f0() {
        String uuid = UUID.randomUUID().toString();
        this.f1202a = uuid;
        this.g = new HashSet();
        IAlog.a("%sInneractiveAdSpotImpl created with UID: %s", IAlog.a(this), uuid);
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final void a(e0 e0Var) {
        this.i = e0Var;
        requestAd(null);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void addUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            q0 q0Var = (q0) inneractiveUnitController;
            q0Var.setAdSpot(this);
            if (this.g.size() > 0) {
                Iterator it = new HashSet(this.g).iterator();
                while (it.hasNext()) {
                    InneractiveUnitController inneractiveUnitController2 = (InneractiveUnitController) it.next();
                    if (inneractiveUnitController2.getClass().equals(inneractiveUnitController.getClass())) {
                        removeUnitController(inneractiveUnitController2);
                    }
                }
            }
            this.g.add(q0Var);
            if (this.e != null) {
                Iterator it2 = this.g.iterator();
                while (it2.hasNext()) {
                    q0 q0Var2 = (q0) it2.next();
                    if (q0Var2.supports(this)) {
                        this.f = q0Var2;
                        return;
                    }
                }
            }
        }
    }

    public final void b() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((InneractiveUnitController) it.next()).destroy();
        }
        this.g.clear();
        p pVar = this.l;
        if (pVar != null) {
            pVar.a(true);
            pVar.b = null;
            this.l = null;
        }
        m mVar = this.h;
        if (mVar != null) {
            l lVar = mVar.g;
            if (lVar != null) {
                IAConfigManager.removeListener(lVar);
            }
            com.fyber.inneractive.sdk.network.m mVar2 = mVar.d;
            if (mVar2 != null) {
                mVar2.a();
                mVar.d = null;
            }
            mVar.a(true);
            mVar.b = null;
            this.h = null;
        }
        this.b = null;
        a();
        InneractiveAdSpotManager.get().removeSpot(this);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final x getAdContent() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveAdRequest getCurrentProcessedRequest() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getLocalUniqueId() {
        return this.f1202a;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveMediationName getMediationName() {
        return IAConfigManager.O.m;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationNameString() {
        return IAConfigManager.O.l;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationVersion() {
        return IAConfigManager.O.n;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getRequestedSpotId() {
        InneractiveAdRequest inneractiveAdRequest = this.c;
        return inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : "";
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveUnitController getSelectedUnitController() {
        return this.f;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final boolean isReady() {
        boolean z;
        x xVar;
        com.fyber.inneractive.sdk.response.e c;
        Long valueOf;
        Long valueOf2;
        x xVar2 = this.e;
        if (xVar2 == null) {
            return false;
        }
        if (xVar2.c() != null) {
            com.fyber.inneractive.sdk.response.e c2 = this.e.c();
            c2.getClass();
            if (c2.f1727a < System.currentTimeMillis()) {
                z = true;
                if (z && (xVar = this.e) != null) {
                    c = xVar.c();
                    if (!this.k && c != null) {
                        long minutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - c.c);
                        long j = c.b;
                        long j2 = minutes - j;
                        IAlog.a("Firing Event 802 - AdExpired - time passed- " + j2 + ", sessionTimeOut - " + j, new Object[0]);
                        com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.IA_AD_EXPIRED;
                        InneractiveAdRequest inneractiveAdRequest = xVar.f1249a;
                        JSONArray b = xVar.c.b();
                        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(c);
                        wVar.b = tVar;
                        wVar.f1340a = inneractiveAdRequest;
                        wVar.d = b;
                        JSONObject jSONObject = new JSONObject();
                        valueOf = Long.valueOf(j2);
                        try {
                            jSONObject.put("time_passed", valueOf);
                        } catch (Exception unused) {
                            IAlog.f("Got exception adding param to json object: %s, %s", "time_passed", valueOf);
                        }
                        valueOf2 = Long.valueOf(j);
                        try {
                            jSONObject.put("timeout", valueOf2);
                        } catch (Exception unused2) {
                            IAlog.f("Got exception adding param to json object: %s, %s", "timeout", valueOf2);
                        }
                        wVar.f.put(jSONObject);
                        wVar.a((String) null);
                        this.k = true;
                    }
                }
                return !z && this.e.f();
            }
        }
        z = false;
        if (z) {
            c = xVar.c();
            if (!this.k) {
                long minutes2 = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - c.c);
                long j3 = c.b;
                long j22 = minutes2 - j3;
                IAlog.a("Firing Event 802 - AdExpired - time passed- " + j22 + ", sessionTimeOut - " + j3, new Object[0]);
                com.fyber.inneractive.sdk.network.t tVar2 = com.fyber.inneractive.sdk.network.t.IA_AD_EXPIRED;
                InneractiveAdRequest inneractiveAdRequest2 = xVar.f1249a;
                JSONArray b2 = xVar.c.b();
                com.fyber.inneractive.sdk.network.w wVar2 = new com.fyber.inneractive.sdk.network.w(c);
                wVar2.b = tVar2;
                wVar2.f1340a = inneractiveAdRequest2;
                wVar2.d = b2;
                JSONObject jSONObject2 = new JSONObject();
                valueOf = Long.valueOf(j22);
                jSONObject2.put("time_passed", valueOf);
                valueOf2 = Long.valueOf(j3);
                jSONObject2.put("timeout", valueOf2);
                wVar2.f.put(jSONObject2);
                wVar2.a((String) null);
                this.k = true;
            }
        }
        if (z) {
            return false;
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void removeUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            q0 q0Var = this.f;
            if (q0Var != null && q0Var.equals(inneractiveUnitController)) {
                this.f.destroy();
                this.f = null;
            }
            this.g.remove(inneractiveUnitController);
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void requestAd(InneractiveAdRequest inneractiveAdRequest) {
        if (IAConfigManager.d()) {
            IAlog.a("%sIAB TCF purpose 1 disabled, dropping request", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.IAB_TCF_PURPOSE_1_DISABLED);
                return;
            }
            return;
        }
        IAlog.a("%srequestAd called with request: %s", IAlog.a(this), inneractiveAdRequest);
        if (inneractiveAdRequest == null && this.c == null) {
            IAlog.b("%srequestAd called with a null request, but no previous request is available! Cannot continue", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener3 = this.b;
            if (requestListener3 != null) {
                requestListener3.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
                return;
            }
            return;
        }
        InneractiveAdRequest inneractiveAdRequest2 = inneractiveAdRequest != null ? inneractiveAdRequest : this.c;
        String str = this.f1202a;
        inneractiveAdRequest2.b = str;
        com.fyber.inneractive.sdk.metrics.d.d.a(str).c();
        if (this.g.isEmpty()) {
            IAlog.b("%srequestAd called but no AdUnitControllers exist! Cannot continue", IAlog.a(this));
            if (this.b != null) {
                if (inneractiveAdRequest == null) {
                    inneractiveAdRequest = this.c;
                }
                a(inneractiveAdRequest, null);
                this.b.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        IAConfigManager.b();
        m mVar = this.h;
        if (mVar != null) {
            boolean z = inneractiveAdRequest != null || this.c == null;
            l lVar = mVar.g;
            if (lVar != null) {
                IAConfigManager.removeListener(lVar);
            }
            com.fyber.inneractive.sdk.network.m mVar2 = mVar.d;
            if (mVar2 != null) {
                mVar2.a();
                mVar.d = null;
            }
            mVar.a(z);
            mVar.b = null;
        }
        if (inneractiveAdRequest != null) {
            InneractiveAdRequest inneractiveAdRequest3 = this.c;
            if (inneractiveAdRequest3 != null) {
                inneractiveAdRequest.setSelectedUnitConfig(inneractiveAdRequest3.getSelectedUnitConfig());
            }
            this.c = inneractiveAdRequest;
            x xVar = this.e;
            if (xVar != null) {
                xVar.a();
                this.j = true;
            }
            Iterator it = this.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.c.f1240a = false;
                    break;
                } else if (((q0) it.next()) instanceof InneractiveFullscreenUnitController) {
                    break;
                }
            }
        }
        this.h = new m(this.f1202a);
        if (this.d == null) {
            this.d = new d0(this);
        }
        IAlog.a("%sFound ad source for request! %s", IAlog.a(this), this.h);
        IAlog.a("%s initOmidSdkIfNeeded", IAlog.a(this));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager.K;
        if (eVar == null || !eVar.f1268a) {
            Application application = com.fyber.inneractive.sdk.util.o.f1770a;
            IAlog.c("initOmidSdk", new Object[0]);
            com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.config.a0(iAConfigManager, application));
        }
        iAConfigManager.H.a();
        m mVar3 = this.h;
        if (mVar3 != null) {
            InneractiveAdRequest inneractiveAdRequest4 = this.c;
            mVar3.b = this.d;
            if (IAConfigManager.e()) {
                mVar3.c(inneractiveAdRequest4);
                return;
            }
            l lVar2 = new l(mVar3, inneractiveAdRequest4);
            mVar3.g = lVar2;
            IAConfigManager.addListener(lVar2);
            IAConfigManager.a();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(InneractiveMediationName inneractiveMediationName) {
        InneractiveAdManager.setMediationName(inneractiveMediationName);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationVersion(String str) {
        InneractiveAdManager.setMediationVersion(str);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void destroy() {
        IAlog.a("%sInneractiveAdSpotImpl spot destroy: %s", IAlog.a(this), this.f1202a);
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            com.fyber.inneractive.sdk.util.r.b.post(new c0(this));
        } else {
            b();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void loadAd(String str) {
        IAlog.a("%s : InneractiveAdSpotImpl Start load ad process", IAlog.a(this));
        if (IAConfigManager.d()) {
            IAlog.a("%sIAB TCF purpose 1 disabled, dropping request", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.IAB_TCF_PURPOSE_1_DISABLED);
                return;
            }
            return;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener3 = this.b;
            if (requestListener3 != null) {
                requestListener3.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.d.d.a(this.f1202a).c();
        String str2 = this.f1202a;
        this.l = new p(str2);
        if (this.d == null) {
            this.d = new d0(this);
        }
        com.fyber.inneractive.sdk.bidder.adm.y yVar = new com.fyber.inneractive.sdk.bidder.adm.y(str, str2);
        com.fyber.inneractive.sdk.config.global.r a2 = com.fyber.inneractive.sdk.config.global.r.a();
        b0 b0Var = new b0(this, yVar, a2, str);
        IAlog.a("%s initOmidSdkIfNeeded", IAlog.a(this));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager.K;
        if (eVar == null || !eVar.f1268a) {
            Application application = com.fyber.inneractive.sdk.util.o.f1770a;
            IAlog.c("initOmidSdk", new Object[0]);
            com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.config.a0(iAConfigManager, application));
        }
        iAConfigManager.H.a();
        com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.bidder.adm.t(yVar, b0Var, a2));
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(String str) {
        InneractiveAdManager.setMediationName(str);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setRequestListener(InneractiveAdSpot.RequestListener requestListener) {
        IAlog.a("%ssetRequestListener called with: %s", IAlog.a(this), requestListener);
        this.b = requestListener;
    }

    @Override // com.fyber.inneractive.sdk.flow.g0
    public final void a() {
        x xVar;
        JSONArray b;
        com.fyber.inneractive.sdk.config.global.r rVar;
        x xVar2 = this.e;
        if (xVar2 != null) {
            if (xVar2.d() && (xVar = this.e) != null && !xVar.e) {
                String arrays = Arrays.toString(Thread.currentThread().getStackTrace());
                IAlog.a("Firing Event 803 - Stack trace - %s", arrays);
                com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.IA_AD_DESTROYED_WITHOUT_SHOW;
                x xVar3 = this.e;
                InneractiveAdRequest inneractiveAdRequest = xVar3.f1249a;
                com.fyber.inneractive.sdk.response.e c = xVar3.c();
                m mVar = this.h;
                p pVar = this.l;
                com.fyber.inneractive.sdk.config.global.r rVar2 = pVar != null ? pVar.c : null;
                if (mVar != null && (rVar = mVar.c) != null) {
                    b = rVar.b();
                } else {
                    b = rVar2 != null ? rVar2.b() : null;
                }
                com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(c);
                wVar.b = tVar;
                wVar.f1340a = inneractiveAdRequest;
                wVar.d = b;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("stack_trace", arrays);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "stack_trace", arrays);
                }
                wVar.f.put(jSONObject);
                wVar.a((String) null);
            }
            this.e.a();
            this.e = null;
        }
        this.f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        UnitDisplayType unitDisplayType;
        com.fyber.inneractive.sdk.response.e eVar2;
        com.fyber.inneractive.sdk.response.e eVar3;
        if (inneractiveAdRequest != null && inneractiveAdRequest.getSelectedUnitConfig() != null) {
            if (((com.fyber.inneractive.sdk.config.r0) inneractiveAdRequest.getSelectedUnitConfig()).c != null) {
                unitDisplayType = ((com.fyber.inneractive.sdk.config.r0) inneractiveAdRequest.getSelectedUnitConfig()).c.b;
            } else if (((com.fyber.inneractive.sdk.config.r0) inneractiveAdRequest.getSelectedUnitConfig()).f != null) {
                unitDisplayType = ((com.fyber.inneractive.sdk.config.r0) inneractiveAdRequest.getSelectedUnitConfig()).f.j;
            }
            x xVar = this.e;
            eVar2 = (xVar != null || (eVar3 = xVar.b) == null) ? eVar : eVar3;
            String str = this.f1202a;
            if (unitDisplayType == null && eVar2 != null) {
                unitDisplayType = eVar2.p;
            }
            UnitDisplayType unitDisplayType2 = unitDisplayType;
            x xVar2 = this.e;
            new com.fyber.inneractive.sdk.metrics.c(eVar2, inneractiveAdRequest, str, unitDisplayType2, xVar2 != null ? xVar2.c.b() : null).a();
        }
        unitDisplayType = null;
        x xVar3 = this.e;
        if (xVar3 != null) {
        }
        String str2 = this.f1202a;
        if (unitDisplayType == null) {
            unitDisplayType = eVar2.p;
        }
        UnitDisplayType unitDisplayType22 = unitDisplayType;
        x xVar22 = this.e;
        new com.fyber.inneractive.sdk.metrics.c(eVar2, inneractiveAdRequest, str2, unitDisplayType22, xVar22 != null ? xVar22.c.b() : null).a();
    }
}
