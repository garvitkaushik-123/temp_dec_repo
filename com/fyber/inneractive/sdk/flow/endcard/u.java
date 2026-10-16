package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.u0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.i1;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class u extends a implements ValueCallback {
    public final com.fyber.inneractive.sdk.flow.vast.a c;
    public com.fyber.inneractive.sdk.player.controller.d d;
    public String e;
    public boolean f;
    public ViewGroup g;
    public final AtomicBoolean h;
    public final s i;

    public u(b bVar) {
        super(bVar);
        this.f = false;
        this.h = new AtomicBoolean(false);
        this.i = new s(this);
        u0 u0Var = bVar.c;
        r0 r0Var = u0Var.b;
        InneractiveAdRequest inneractiveAdRequest = u0Var.c;
        com.fyber.inneractive.sdk.response.g gVar = u0Var.d;
        this.c = new com.fyber.inneractive.sdk.flow.vast.a(gVar.p, inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen(), gVar.e, gVar.f, r0Var.d);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.a, com.fyber.inneractive.sdk.flow.endcard.n
    public final void a() {
        com.fyber.inneractive.sdk.util.t.a(b());
        i1 i1Var = e().f1359a;
        if (i1Var != null) {
            i1Var.a(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public final View b() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (!this.f) {
            return null;
        }
        i1 i1Var = e().f1359a;
        com.fyber.inneractive.sdk.web.m mVar = i1Var == null ? null : i1Var.b;
        if (mVar == null) {
            return null;
        }
        ViewGroup a2 = a.a(mVar);
        this.g = a2;
        return a2;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.a
    public final void c() {
        com.fyber.inneractive.sdk.player.controller.d e = e();
        i1 i1Var = e.f1359a;
        if (i1Var != null) {
            UnitDisplayType unitDisplayType = e.c;
            if (!UnitDisplayType.INTERSTITIAL.equals(unitDisplayType) && !UnitDisplayType.REWARDED.equals(unitDisplayType)) {
                UnitDisplayType.VERTICAL.equals(unitDisplayType);
            }
            i1Var.l();
        }
    }

    public q d() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.a, com.fyber.inneractive.sdk.flow.endcard.n
    public final void destroy() {
        a();
        com.fyber.inneractive.sdk.player.controller.d e = e();
        i1 i1Var = e.f1359a;
        if (i1Var != null) {
            i1Var.e();
            e.f1359a = null;
        }
    }

    public final com.fyber.inneractive.sdk.player.controller.d e() {
        com.fyber.inneractive.sdk.player.controller.d dVar = this.d;
        if (dVar == null) {
            b bVar = this.b;
            dVar = new com.fyber.inneractive.sdk.player.controller.d(bVar.c.f1241a, this.c, bVar.i(), d());
            u0 u0Var = this.b.c;
            i1 i1Var = dVar.f1359a;
            if (i1Var != null) {
                if (i1Var.s == null) {
                    i1Var.setAdContent(u0Var.b);
                }
                if (i1Var.r == null) {
                    i1Var.setAdRequest(u0Var.c);
                }
                if (i1Var.t == null) {
                    i1Var.setAdResponse(u0Var.d);
                }
            }
            this.d = dVar;
        }
        return dVar;
    }

    public boolean f() {
        com.fyber.inneractive.sdk.config.s sVar = IAConfigManager.O.u;
        return sVar != null && sVar.b.a(false, "dt_plbl");
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            IAlog.a("%s Playable detected: %s", this.f1183a, str);
            try {
                this.b.a(new JSONArray(str));
            } catch (JSONException e) {
                IAlog.f("%s invalid playable detection method: %s", this.f1183a, e.getMessage());
            }
        }
        this.b.m();
    }

    public final void a(com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a aVar) {
        com.fyber.inneractive.sdk.web.g tVar;
        String str = this.e;
        if (!TextUtils.isEmpty(str)) {
            com.fyber.inneractive.sdk.player.controller.d e = e();
            if (aVar == null) {
                tVar = this.i;
            } else {
                tVar = new t(this, aVar);
            }
            e.a(str, tVar, !(this instanceof p));
            return;
        }
        throw new com.fyber.inneractive.sdk.flow.vast.h("End-Card HTML not loaded", "No template");
    }
}
