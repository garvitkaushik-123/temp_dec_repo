package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.u0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class c extends b implements com.fyber.inneractive.sdk.response.i {
    public final com.fyber.inneractive.sdk.model.vast.c g;

    public c(u0 u0Var, com.fyber.inneractive.sdk.model.vast.c cVar, int i) {
        super(i, u0Var);
        this.g = cVar;
    }

    public final void a(com.fyber.inneractive.sdk.network.u uVar, u0 u0Var) {
        InneractiveAdRequest inneractiveAdRequest = u0Var.c;
        com.fyber.inneractive.sdk.response.g gVar = u0Var.d;
        JSONArray jSONArray = u0Var.f;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(gVar);
        wVar.c = uVar;
        wVar.f1340a = inneractiveAdRequest;
        wVar.d = jSONArray;
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = this.g.a();
        try {
            jSONObject.put("companion_data", a2);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", a2);
        }
        JSONArray jSONArray2 = this.b;
        if (jSONArray2 != null && jSONArray2.length() > 0) {
            JSONArray jSONArray3 = this.b;
            try {
                jSONObject.put("plbl_det", jSONArray3);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "plbl_det", jSONArray3);
            }
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.player.ui.c d() {
        com.fyber.inneractive.sdk.config.global.features.u uVar = this.c.g;
        View b = f().b();
        com.fyber.inneractive.sdk.player.ui.c d = super.d();
        d.e = b;
        boolean z = false;
        if (uVar != null) {
            Boolean c = uVar.c("cta_text_all_caps");
            if (c != null ? c.booleanValue() : false) {
                z = true;
            }
        }
        d.b = z;
        boolean b2 = b.b(uVar);
        Integer valueOf = Integer.valueOf(b.a(uVar));
        if (b2) {
            d.d = valueOf;
        }
        return d;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void e() {
        a();
        View b = f().b();
        if (b != null) {
            b.setVisibility(8);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.util.g g() {
        return com.fyber.inneractive.sdk.util.g.VAST_ENDCARD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final l h() {
        return l.Companion;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.model.vast.i i() {
        return this.g.f1282a;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public boolean l() {
        return f().b() != null;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void m() {
        super.m();
        a(com.fyber.inneractive.sdk.network.u.VAST_COMPANION_LOADED, this.c);
    }

    public final void a(int i, u0 u0Var) {
        com.fyber.inneractive.sdk.player.n.a(this, com.fyber.inneractive.sdk.model.vast.x.EVENT_CREATIVE_VIEW);
        a(com.fyber.inneractive.sdk.network.u.VAST_COMPANION_DISPLAYED, u0Var);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s loading failed for %s", inneractiveInfrastructureError.getCause(), i(), this.f1184a);
        com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.VAST_COMPANION_FAILED_LOADING;
        if (inneractiveInfrastructureError.isErrorAlreadyReported(tVar)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = this.g.a();
        try {
            jSONObject.put("companion_data", a2);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", a2);
        }
        Throwable cause = inneractiveInfrastructureError.getCause();
        String description = inneractiveInfrastructureError.description();
        if (TextUtils.isEmpty(description)) {
            description = com.fyber.inneractive.sdk.util.t.a(cause);
        }
        if (!TextUtils.isEmpty(description)) {
            try {
                jSONObject.put("reason", inneractiveInfrastructureError);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "reason", inneractiveInfrastructureError);
            }
        }
        u0 u0Var = this.c;
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

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar) {
        View b = f().b();
        if (b != null) {
            ((a) f()).c();
            com.fyber.inneractive.sdk.util.t.a(b);
            viewGroup.addView(b);
            b.requestFocus();
            a(this.e, this.c);
        }
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public final List a(com.fyber.inneractive.sdk.model.vast.x xVar) {
        return this.g.a(xVar);
    }
}
