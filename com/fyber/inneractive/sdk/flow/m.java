package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class m extends o {
    public l g;

    public m(String str) {
        super(str);
    }

    public static void a(boolean z, com.fyber.inneractive.sdk.response.e eVar, InneractiveAdRequest inneractiveAdRequest) {
        String str;
        String spotId = inneractiveAdRequest.getSpotId();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        String str2 = (String) iAConfigManager.x.c.get("KEY_MISSMATCH_STATS_SPOTS");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (str2.contains("-" + spotId + "-")) {
            return;
        }
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(com.fyber.inneractive.sdk.network.t.MISSMATCH_SPOTID, inneractiveAdRequest, eVar);
        if (z) {
            str = "There is no " + spotId + " spot ID in current app config";
        } else {
            str = "spot ID " + spotId + " is not active in current app config";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", str);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "reason", str);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
        iAConfigManager.x.c.put("KEY_MISSMATCH_STATS_SPOTS", str2 + " -" + spotId + "-");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void b() {
        IAlog.a("%s onRetry()", IAlog.a(this));
    }

    public final void c(InneractiveAdRequest inneractiveAdRequest) {
        o oVar;
        com.fyber.inneractive.sdk.config.t0 t0Var;
        UnitDisplayType unitDisplayType;
        n nVar;
        if (!InneractiveAdManager.wasInitialized() && (nVar = this.b) != null) {
            ((d0) nVar).a(inneractiveAdRequest, c(), new InneractiveInfrastructureError(InneractiveErrorCode.SDK_NOT_INITIALIZED, i.NO_APP_CONFIG_AVAILABLE));
        }
        String spotId = inneractiveAdRequest.getSpotId();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap hashMap = iAConfigManager.f1068a;
        com.fyber.inneractive.sdk.config.q0 q0Var = (hashMap == null || !hashMap.containsKey(spotId)) ? null : (com.fyber.inneractive.sdk.config.q0) iAConfigManager.f1068a.get(spotId);
        com.fyber.inneractive.sdk.response.e c = c();
        if (q0Var != null && !q0Var.b) {
            a(false, c, inneractiveAdRequest);
            ((d0) this.b).a(inneractiveAdRequest, c(), new InneractiveInfrastructureError(InneractiveErrorCode.SPOT_DISABLED, i.NO_APP_CONFIG_AVAILABLE));
            return;
        }
        if (q0Var == null || !q0Var.f1113a.iterator().hasNext()) {
            if (q0Var == null) {
                a(true, c, inneractiveAdRequest);
                IAConfigManager.a();
            }
            IAlog.f("************************************************************************************************************************", new Object[0]);
            IAlog.f("*** Requested spot id '%s' doesn't exist within this application config - application Id: '%s'", inneractiveAdRequest.getSpotId(), iAConfigManager.c);
            IAlog.f("*** Are you sure that you are using the correct application and spot ids, as defined for this application in the Inneractive console?", new Object[0]);
            IAlog.f("************************************************************************************************************************", new Object[0]);
            ((d0) this.b).a(inneractiveAdRequest, c, new InneractiveInfrastructureError(InneractiveErrorCode.ERROR_CONFIGURATION_NO_SUCH_SPOT, i.NO_APP_CONFIG_AVAILABLE));
            return;
        }
        com.fyber.inneractive.sdk.config.r0 r0Var = (com.fyber.inneractive.sdk.config.r0) q0Var.f1113a.get(0);
        if (r0Var.c == null && ((t0Var = r0Var.f) == null || !((unitDisplayType = t0Var.j) == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED))) {
            ((d0) this.b).a(inneractiveAdRequest, c(), new InneractiveInfrastructureError(InneractiveErrorCode.UNSUPPORTED_SPOT, i.NO_APP_CONFIG_AVAILABLE));
            return;
        }
        com.fyber.inneractive.sdk.config.global.r a2 = com.fyber.inneractive.sdk.config.global.r.a();
        this.c = a2;
        a2.a(false, inneractiveAdRequest.getSpotId());
        com.fyber.inneractive.sdk.network.s sVar = new com.fyber.inneractive.sdk.network.s(inneractiveAdRequest, inneractiveAdRequest.b, this.c, this);
        this.d = sVar;
        sVar.b = false;
        IAlog.a("IARemoteAdFetcher: requestAd called", new Object[0]);
        if (TextUtils.isEmpty(inneractiveAdRequest.getSpotId())) {
            IAlog.b("appID is null or empty. Please provide a valid appID and re-try.", new Object[0]);
        } else {
            if (com.fyber.inneractive.sdk.util.o.a("android.permission.INTERNET")) {
                if (!com.fyber.inneractive.sdk.util.o.a("android.permission.ACCESS_NETWORK_STATE")) {
                    IAlog.b("It is recommended to add ACCESS_NETWORK_STATE permission to the Manifest for better targetting", new Object[0]);
                }
                if (!com.fyber.inneractive.sdk.util.o.a("android.permission.READ_PHONE_STATE")) {
                    IAlog.f("It is recomended to add the READ_PHONE_STATE permission to the manifest for better targetting", new Object[0]);
                }
                iAConfigManager.s.b(sVar.f);
                return;
            }
            IAlog.b("INTERNET permission is missing. Please add it to the Manifest and re-try, otherwise ads will not be requested and displayed! ", new Object[0]);
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, i.VALIDATE_PARAMS_FAILED, new Exception("appID is null or empty or INTERNET permission is missing"));
        if (sVar.b || (oVar = sVar.f1330a) == null) {
            return;
        }
        oVar.a(inneractiveAdRequest, null, inneractiveInfrastructureError);
    }

    @Override // com.fyber.inneractive.sdk.flow.o
    public final String d() {
        return IAlog.a(this);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        IAlog.a("%s onTimeout()", IAlog.a(this));
    }
}
