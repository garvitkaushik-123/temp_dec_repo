package com.fyber.inneractive.sdk.flow.endcard.loaders.fmp;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.endcard.o;
import com.fyber.inneractive.sdk.flow.endcard.p;
import com.fyber.inneractive.sdk.flow.u0;
import com.fyber.inneractive.sdk.network.e0;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final p f1196a;
    public final o b;
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a c;
    public final String d;

    public b(o oVar, com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a aVar, String str) {
        this.b = oVar;
        this.f1196a = (p) oVar.f();
        this.c = aVar;
        this.d = str;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null && exc == null) {
            IAlog.c("%s loaded FMP End-Card icon %s", "IconCallback", this.d);
            p pVar = this.f1196a;
            pVar.k = str;
            pVar.b(this.c);
            return;
        }
        if (TextUtils.isEmpty(this.f1196a.k)) {
            o oVar = this.b;
            IAlog.a("%s sending FMP_COMPANION_FAILED_LOADING event", "IconCallback");
            JSONObject jSONObject = new JSONObject();
            String a2 = t.a(exc);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    jSONObject.put("error", a2);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "error", a2);
                }
            }
            String n = oVar.n();
            if (!TextUtils.isEmpty(n)) {
                try {
                    jSONObject.put("version", n);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "version", n);
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            try {
                jSONObject.put("loaded_from_cache", valueOf);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", valueOf);
            }
            u0 u0Var = oVar.c;
            com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.FMP_COMPANION_FAILED_LOADING;
            InneractiveAdRequest inneractiveAdRequest = u0Var.c;
            g gVar = u0Var.d;
            JSONArray jSONArray = u0Var.f;
            w wVar = new w(gVar);
            wVar.b = tVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = jSONArray;
            wVar.f.put(jSONObject);
            wVar.a((String) null);
        }
    }
}
