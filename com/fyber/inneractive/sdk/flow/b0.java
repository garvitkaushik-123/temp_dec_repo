package com.fyber.inneractive.sdk.flow;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.i1;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.bidder.adm.y f1177a;
    public final /* synthetic */ com.fyber.inneractive.sdk.config.global.r b;
    public final /* synthetic */ String c;
    public final /* synthetic */ f0 d;

    public b0(f0 f0Var, com.fyber.inneractive.sdk.bidder.adm.y yVar, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        this.d = f0Var;
        this.f1177a = yVar;
        this.b = rVar;
        this.c = str;
    }

    public final void a() {
        com.fyber.inneractive.sdk.config.global.b bVar;
        com.fyber.inneractive.sdk.config.global.k kVar;
        com.fyber.inneractive.sdk.config.global.l lVar;
        f0 f0Var = this.d;
        f0Var.getClass();
        IAlog.a("%s : InneractiveAdSpotImpl markup data available", IAlog.a(f0Var));
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.f1177a.f1029a;
        if (admParametersOuterClass$AdmParameters != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.b;
            List<AdmParametersOuterClass$AdmParameters.Experiment> abExperimentsList = admParametersOuterClass$AdmParameters.getAbExperimentsList();
            rVar.getClass();
            com.fyber.inneractive.sdk.config.global.a aVar = IAConfigManager.O.z;
            aVar.getClass();
            for (com.fyber.inneractive.sdk.config.global.features.h hVar : rVar.b.values()) {
                if (hVar != null && (lVar = aVar.f1085a) != null) {
                    com.fyber.inneractive.sdk.config.global.q qVar = (com.fyber.inneractive.sdk.config.global.q) lVar.f1094a.get(hVar.b);
                    if (qVar != null) {
                        hVar.f1096a = qVar.f1096a;
                    }
                }
            }
            if (abExperimentsList == null || abExperimentsList.size() <= 0) {
                return;
            }
            com.fyber.inneractive.sdk.config.global.a aVar2 = IAConfigManager.O.z;
            aVar2.b = rVar;
            for (com.fyber.inneractive.sdk.config.global.features.h hVar2 : rVar.b.values()) {
                for (AdmParametersOuterClass$AdmParameters.Experiment experiment : abExperimentsList) {
                    String identifier = experiment.getIdentifier();
                    String variant = experiment.getVariant();
                    com.fyber.inneractive.sdk.config.global.l lVar2 = aVar2.f1085a;
                    if (lVar2 != null) {
                        com.fyber.inneractive.sdk.config.global.q qVar2 = (com.fyber.inneractive.sdk.config.global.q) lVar2.f1094a.get(hVar2.b);
                        if (qVar2 != null && (bVar = (com.fyber.inneractive.sdk.config.global.b) qVar2.c.get(identifier)) != null) {
                            Iterator it = bVar.c.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    kVar = (com.fyber.inneractive.sdk.config.global.k) it.next();
                                    if (kVar.b.equals(variant)) {
                                        break;
                                    }
                                } else {
                                    kVar = null;
                                    break;
                                }
                            }
                            hVar2.c.put(bVar.f1086a, bVar);
                            if (kVar != null) {
                                hVar2.d.put(bVar.f1086a, kVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(Exception exc, InneractiveErrorCode inneractiveErrorCode, com.fyber.inneractive.sdk.response.e... eVarArr) {
        com.fyber.inneractive.sdk.network.t tVar;
        f0 f0Var = this.d;
        f0Var.getClass();
        IAlog.a("%s : InneractiveAdSpotImpl data error", IAlog.a(f0Var));
        com.fyber.inneractive.sdk.response.e eVar = eVarArr.length > 0 ? eVarArr[0] : null;
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, i.ADM_FETCH_FAILED);
        d0 d0Var = this.d.d;
        if (d0Var != null) {
            d0Var.a(null, eVar, inneractiveInfrastructureError);
        }
        p pVar = this.d.l;
        if (pVar != null) {
            IAlog.e("%sgot handleFailedLoading! with: %s", pVar.d(), inneractiveInfrastructureError);
            n nVar = pVar.b;
            if (nVar != null) {
                ((d0) nVar).a(null, eVar, inneractiveInfrastructureError);
            }
            pVar.a(null, eVar);
        }
        f0 f0Var2 = this.d;
        String str = this.c;
        com.fyber.inneractive.sdk.config.global.r rVar = this.b;
        f0Var2.getClass();
        if (!inneractiveErrorCode.equals(InneractiveErrorCode.CONNECTION_ERROR) && !inneractiveErrorCode.equals(InneractiveErrorCode.NO_FILL)) {
            tVar = com.fyber.inneractive.sdk.network.t.FATAL_ADM_PARSING_ERROR;
        } else {
            tVar = com.fyber.inneractive.sdk.network.t.FATAL_ADM_MARKUP_FETCHING_ERROR;
        }
        if (eVar != null) {
            eVar.D = false;
        }
        String name = exc.getClass().getName();
        if (exc instanceof i1) {
            name = "NetworkStackException";
        }
        JSONArray b = rVar.b();
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar.b = tVar;
        wVar.f1340a = null;
        wVar.d = b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exception", name);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "exception", name);
        }
        String localizedMessage = exc.getLocalizedMessage();
        String str2 = exc;
        if (localizedMessage != null) {
            str2 = exc.getLocalizedMessage();
        }
        try {
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", PglCryptUtils.KEY_MESSAGE, str2);
        }
        try {
            jSONObject.put("admPayload", str);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "admPayload", str);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }
}
