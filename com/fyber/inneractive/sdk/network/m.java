package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.flow.o f1330a;
    public volatile boolean b = false;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final String d;

    public m(com.fyber.inneractive.sdk.config.global.r rVar, String str, com.fyber.inneractive.sdk.flow.o oVar) {
        this.f1330a = oVar;
        this.c = rVar;
        this.d = str;
    }

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        com.fyber.inneractive.sdk.flow.o oVar;
        com.fyber.inneractive.sdk.flow.x xVar;
        if (this.f1330a == null) {
            return;
        }
        if (this.b) {
            IAlog.e("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.config.r0 a2 = com.fyber.inneractive.sdk.config.a.a(eVar.o);
        if (inneractiveAdRequest != null) {
            inneractiveAdRequest.setSelectedUnitConfig(a2);
        }
        com.fyber.inneractive.sdk.config.global.e eVar2 = new com.fyber.inneractive.sdk.config.global.e();
        ImpressionData impressionData = eVar.t;
        eVar2.f1088a = impressionData != null ? impressionData.getDemandId() : null;
        try {
            eVar2.b = Long.valueOf(IAConfigManager.O.d);
        } catch (NumberFormatException unused) {
            IAlog.a("invalid publisherId", new Object[0]);
        }
        this.c.a(eVar2);
        InneractiveErrorCode a3 = a2 == null ? InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH : eVar.a(inneractiveAdRequest, this.c);
        if (a3 != null) {
            com.fyber.inneractive.sdk.flow.i iVar = com.fyber.inneractive.sdk.flow.i.CONTENT_ERROR_UNSPECIFIED;
            if (a2 == null || a3 == InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH) {
                iVar = com.fyber.inneractive.sdk.flow.i.NO_APP_CONFIG_AVAILABLE;
                IAlog.b("%sGot configuration mismatch!", IAlog.a(this));
                IAConfigManager.a();
            }
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(a3, iVar);
            Exception exc = eVar.z;
            if (exc != null) {
                inneractiveInfrastructureError.setCause(exc);
            }
            com.fyber.inneractive.sdk.response.a a4 = com.fyber.inneractive.sdk.response.a.a(eVar.g);
            if (a4 != null) {
                Exception exc2 = eVar.z;
                if (exc2 != null) {
                    inneractiveInfrastructureError.setCause(exc2);
                }
                com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.flow.e(new com.fyber.inneractive.sdk.flow.f(eVar, inneractiveAdRequest, a4 == com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML ? "send_failed_display_creatives" : "send_failed_vast_creatives", this.c.b()), inneractiveInfrastructureError));
            }
            com.fyber.inneractive.sdk.config.global.r rVar = this.c;
            if (rVar == null) {
                InneractiveAdSpot spot = InneractiveAdSpotManager.get().getSpot(this.d);
                rVar = (spot == null || spot.getAdContent() == null) ? null : spot.getAdContent().c;
            }
            com.fyber.inneractive.sdk.flow.a.a(inneractiveAdRequest, inneractiveInfrastructureError, null, eVar, rVar != null ? rVar.b() : null);
            if (this.b || (oVar = this.f1330a) == null) {
                return;
            }
            oVar.a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
            return;
        }
        com.fyber.inneractive.sdk.flow.o oVar2 = this.f1330a;
        if (oVar2.f) {
            IAlog.e("IAAdSourceBase: load cancelled: ignoring response. Previous load request was cancelled", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.config.global.r rVar2 = oVar2.c;
        IAlog.e("%sonAdDataAvailable: got response data: %s", oVar2.d(), eVar);
        if (eVar.a()) {
            com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
            if (hVar.f) {
                hVar.a((com.digitalturbine.ignite.authenticator.listeners.internal.a) null);
            }
        }
        com.fyber.inneractive.sdk.response.a a5 = com.fyber.inneractive.sdk.response.a.a(eVar.g);
        com.fyber.inneractive.sdk.interfaces.c cVar = oVar2.f1212a;
        if (cVar != null && (xVar = ((com.fyber.inneractive.sdk.flow.k) cVar).c) != null) {
            xVar.a();
        }
        com.fyber.inneractive.sdk.factories.e eVar3 = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1171a.f1172a.get(a5);
        com.fyber.inneractive.sdk.interfaces.c a6 = eVar3 != null ? eVar3.a() : null;
        oVar2.f1212a = a6;
        if (a6 == null) {
            IAlog.f("%sonAdDataAvailable: Cannot find content handler for ad type: %s", oVar2.d(), a5);
            com.fyber.inneractive.sdk.flow.n nVar = oVar2.b;
            if (nVar != null) {
                ((com.fyber.inneractive.sdk.flow.d0) nVar).a(inneractiveAdRequest, eVar, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.NO_CONTENT_LOADER_AVAILABLE));
            }
        } else {
            IAlog.e("%sonAdDataAvailable: found response loader: %s", oVar2.d(), oVar2.f1212a);
        }
        com.fyber.inneractive.sdk.interfaces.c cVar2 = oVar2.f1212a;
        if (cVar2 != null) {
            ((com.fyber.inneractive.sdk.flow.k) cVar2).a(inneractiveAdRequest, eVar, rVar2, oVar2, oVar2);
        } else {
            z.a("NullPointerException prevented", "mAdContentLoader is null", inneractiveAdRequest, eVar);
        }
    }

    public String b() {
        return null;
    }

    public void a() {
        this.b = true;
        this.f1330a = null;
    }
}
