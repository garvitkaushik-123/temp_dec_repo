package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class p extends o implements IAConfigManager.OnConfigurationReadyAndValidListener {
    public com.fyber.inneractive.sdk.response.e g;

    public p(String str) {
        super(str);
    }

    @Override // com.fyber.inneractive.sdk.flow.o, com.fyber.inneractive.sdk.interfaces.a
    public final void a(InneractiveAdRequest inneractiveAdRequest) {
        com.fyber.inneractive.sdk.metrics.i b = com.fyber.inneractive.sdk.metrics.d.d.b(this.e);
        b.b.put(new com.fyber.inneractive.sdk.metrics.h("success"), Long.valueOf(System.currentTimeMillis() - b.d));
        super.a(inneractiveAdRequest);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void b() {
        com.fyber.inneractive.sdk.metrics.i b = com.fyber.inneractive.sdk.metrics.d.d.b(this.e);
        b.b.put(new com.fyber.inneractive.sdk.metrics.h("retrying"), Long.valueOf(System.currentTimeMillis() - b.d));
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (z) {
            return;
        }
        a(null, c(), new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.NO_APP_CONFIG_AVAILABLE, exc));
    }

    @Override // com.fyber.inneractive.sdk.flow.o
    public final void b(InneractiveAdRequest inneractiveAdRequest) {
        a(inneractiveAdRequest, this.g);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        com.fyber.inneractive.sdk.metrics.i b = com.fyber.inneractive.sdk.metrics.d.d.b(this.e);
        b.b.put(new com.fyber.inneractive.sdk.metrics.h("dyn_timeout"), Long.valueOf(System.currentTimeMillis() - b.d));
    }

    @Override // com.fyber.inneractive.sdk.flow.o
    public final void a(boolean z) {
        com.fyber.inneractive.sdk.network.m mVar = this.d;
        if (mVar != null) {
            mVar.a();
        }
        super.a(true);
    }

    @Override // com.fyber.inneractive.sdk.flow.o
    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        String str;
        if (eVar == null || (str = eVar.B) == null) {
            return;
        }
        com.fyber.inneractive.sdk.metrics.i b = com.fyber.inneractive.sdk.metrics.d.d.b(str);
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        if (rVar == null) {
            rVar = com.fyber.inneractive.sdk.config.global.r.a();
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray a2 = com.fyber.inneractive.sdk.metrics.i.a(b.b);
        try {
            jSONObject.put("adl", a2);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "adl", a2);
        }
        JSONArray a3 = com.fyber.inneractive.sdk.metrics.i.a(b.f1279a);
        try {
            jSONObject.put("adml", a3);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "adml", a3);
        }
        if (!TextUtils.isEmpty(null)) {
            try {
                jSONObject.put("dns_failed", (Object) null);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", "dns_failed", null);
            }
        }
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.SDK_BIDDING_METRICS;
        JSONArray b2 = rVar.b();
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar.c = uVar;
        wVar.f1340a = inneractiveAdRequest;
        wVar.d = b2;
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }
}
