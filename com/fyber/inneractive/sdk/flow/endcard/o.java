package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.u0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.i1;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class o extends b {
    public final String g;
    public com.fyber.inneractive.sdk.web.a h;

    public o(u0 u0Var, String str, int i) {
        super(i, u0Var);
        this.h = new com.fyber.inneractive.sdk.web.a(null, 0);
        this.g = str;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar) {
        p pVar = (p) f();
        View b = pVar.b();
        if (b != null) {
            com.fyber.inneractive.sdk.util.t.a(b);
            viewGroup.addView(b);
            i1 i1Var = pVar.e().f1359a;
            if (i1Var != null) {
                i1Var.a(true);
            }
        }
        a(this.e, this.c);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final n c() {
        return new p(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.player.ui.c d() {
        View b = f().b();
        com.fyber.inneractive.sdk.player.ui.c d = super.d();
        d.e = b;
        return d;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.util.g g() {
        com.fyber.inneractive.sdk.web.a aVar = this.h;
        com.fyber.inneractive.sdk.util.g gVar = com.fyber.inneractive.sdk.util.g.FMP_ENDCARD;
        gVar.a(aVar.f1788a);
        gVar.a(aVar.b);
        return gVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final l h() {
        return l.Fmp;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.model.vast.i i() {
        return com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean j() {
        return this.e > 1;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean l() {
        p pVar = (p) f();
        return pVar.f && pVar.b() != null;
    }

    public final String n() {
        q qVar;
        com.fyber.inneractive.sdk.web.b bVar = (com.fyber.inneractive.sdk.web.b) ((p) f()).e().f1359a;
        if (bVar == null || (qVar = bVar.N) == null) {
            return null;
        }
        return qVar.c;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        if (inneractiveInfrastructureError.isErrorAlreadyReported(com.fyber.inneractive.sdk.network.t.FMP_COMPANION_FAILED_LOADING)) {
            return;
        }
        Throwable cause = inneractiveInfrastructureError.getCause();
        IAlog.a("%s sending FMP_COMPANION_FAILED_LOADING event", this.f1184a);
        JSONObject jSONObject = new JSONObject();
        String a2 = com.fyber.inneractive.sdk.util.t.a(cause);
        if (!TextUtils.isEmpty(a2)) {
            try {
                jSONObject.put("error", a2);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "error", a2);
            }
        }
        String n = n();
        if (!TextUtils.isEmpty(n)) {
            try {
                jSONObject.put("version", n);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "version", n);
            }
        }
        Boolean bool = Boolean.FALSE;
        try {
            jSONObject.put("loaded_from_cache", bool);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", bool);
        }
        u0 u0Var = this.c;
        com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.FMP_COMPANION_FAILED_LOADING;
        InneractiveAdRequest inneractiveAdRequest = u0Var.c;
        com.fyber.inneractive.sdk.response.g gVar = u0Var.d;
        JSONArray jSONArray = u0Var.f;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(gVar);
        wVar.b = tVar;
        wVar.f1340a = inneractiveAdRequest;
        wVar.d = jSONArray;
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }

    public final void a(int i, u0 u0Var) {
        String n = n();
        this.h = new com.fyber.inneractive.sdk.web.a(n, i);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(n)) {
            try {
                jSONObject.put("version", n);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "version", n);
            }
        }
        Boolean valueOf = Boolean.valueOf(((p) f()).l);
        try {
            jSONObject.put("loaded_from_cache", valueOf);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", valueOf);
        }
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.FMP_COMPANION_SUCCESSFULLY_SHOWN;
        InneractiveAdRequest inneractiveAdRequest = u0Var.c;
        com.fyber.inneractive.sdk.response.g gVar = u0Var.d;
        JSONArray jSONArray = u0Var.f;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(gVar);
        wVar.c = uVar;
        wVar.f1340a = inneractiveAdRequest;
        wVar.d = jSONArray;
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }
}
