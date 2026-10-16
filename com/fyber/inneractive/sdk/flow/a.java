package com.fyber.inneractive.sdk.flow;

import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class a {
    public static void a(InneractiveAdRequest inneractiveAdRequest, InneractiveInfrastructureError inneractiveInfrastructureError, x xVar, com.fyber.inneractive.sdk.response.e eVar, JSONArray jSONArray) {
        String sb;
        if (inneractiveInfrastructureError.getErrorCode().getMetricable() == InneractiveErrorCode.Metricable.INCLUDED_IN_FAILED_METRICS) {
            if ((xVar == null || xVar.d() || xVar.isVideoAd()) && !inneractiveInfrastructureError.isErrorAlreadyReported(com.fyber.inneractive.sdk.network.t.IA_AD_LOAD_FAILED)) {
                IAlog.a("Firing Event 801 - AdLoadFailed - errorCode - %s", inneractiveInfrastructureError.getErrorCode());
                if (inneractiveInfrastructureError.getCause() != null) {
                    sb = Arrays.toString(inneractiveInfrastructureError.getCause().getStackTrace());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    for (int i = 7; i >= 0 && i < 13 && i < stackTrace.length; i++) {
                        sb2.append(stackTrace[i].toString()).append(",");
                    }
                    Log.d("stack trace:", sb2.toString());
                    sb = sb2.toString();
                }
                com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.IA_AD_LOAD_FAILED;
                com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVar);
                wVar.b = tVar;
                wVar.f1340a = inneractiveAdRequest;
                wVar.d = jSONArray;
                JSONObject jSONObject = new JSONObject();
                String obj = inneractiveInfrastructureError.getFyberMarketplaceAdLoadFailureReason().toString();
                try {
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, obj);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", PglCryptUtils.KEY_MESSAGE, obj);
                }
                try {
                    jSONObject.put("description", sb);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "description", sb);
                }
                String description = inneractiveInfrastructureError.description();
                try {
                    jSONObject.put("extra_description", description);
                } catch (Exception unused3) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "extra_description", description);
                }
                wVar.f.put(jSONObject);
                wVar.a((String) null);
                inneractiveInfrastructureError.addReportedError(tVar);
            }
        }
    }
}
