package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f1;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class i extends s {
    public final r0 A;
    public final o y;
    public p z;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i(Context context, a aVar, com.fyber.inneractive.sdk.player.n nVar, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        super(context, r5, null);
        com.fyber.inneractive.sdk.flow.g gVar;
        boolean z;
        p pVar;
        r0 r0Var;
        r0 r0Var2;
        com.fyber.inneractive.sdk.config.global.r rVar2 = rVar;
        this.A = null;
        this.A = nVar != null ? nVar.b : null;
        if (context == null || nVar == null || (r0Var2 = nVar.b) == null) {
            gVar = null;
        } else {
            rVar2 = rVar;
            gVar = new com.fyber.inneractive.sdk.flow.g(context, false, r0Var2.f1249a, r0Var2.b, rVar);
        }
        if (nVar == null || (r0Var = nVar.b) == null) {
            z = false;
        } else {
            com.fyber.inneractive.sdk.response.e eVar = r0Var.b;
            z = com.fyber.inneractive.sdk.player.f.a(rVar2, eVar != null ? ((com.fyber.inneractive.sdk.response.g) eVar).H : com.fyber.inneractive.sdk.ignite.m.NONE);
        }
        o oVar = new o(context, gVar, aVar, rVar2, z, str);
        this.y = oVar;
        if (nVar == null) {
            IAlog.a("%s : flow manager is missing, unexpected and dynamic controls status are unknown", "IAVideoViewComposition");
            com.fyber.inneractive.sdk.network.events.a.a(t.VAST_ERROR_DVC_FAILURE, com.fyber.inneractive.sdk.network.events.b.TEMPLATE_CONTENT_ERROR, getAdRequest(), getAdResponse(), "Missing flow manager", "", (Boolean) null);
        } else {
            com.fyber.inneractive.sdk.model.vast.b bVar = nVar.p;
            if (bVar != null && !TextUtils.isEmpty(bVar.n)) {
                com.fyber.inneractive.sdk.player.ui.remote.g gVar2 = nVar.u;
                if ((gVar2 != null ? gVar2.f1653a : null) != null) {
                    com.fyber.inneractive.sdk.player.ui.remote.d dVar = gVar2 != null ? gVar2.f1653a : null;
                    if (dVar.h) {
                        IAlog.a("%s : dynamic controls are already destroyed", "IAVideoViewComposition");
                    } else if (dVar.g) {
                        IAlog.a("%s : dynamic controls load process timed out", "IAVideoViewComposition");
                        com.fyber.inneractive.sdk.player.ui.remote.g gVar3 = nVar.u;
                        (gVar3 != null ? gVar3.f1653a : null).a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_LOAD_TIMEOUT, "Template loading is timed out", true, null);
                    } else {
                        if (dVar.b.j) {
                            pVar = new p(getContext().getApplicationContext(), aVar, dVar, oVar);
                            this.z = pVar;
                            this.l = oVar.l;
                            this.q = oVar.q;
                            this.r = oVar.r;
                            this.m = oVar.m;
                            TextView textView = oVar.u;
                            this.u = textView;
                            a(textView, 10);
                            a(this.m, 8);
                            a(this.l, 7);
                            a(this.q, -1);
                            if (a()) {
                                p pVar2 = this.z;
                                IAsmoothProgressBar iAsmoothProgressBar = oVar.O;
                                f(iAsmoothProgressBar != null && iAsmoothProgressBar.getVisibility() == 0);
                                ImageView imageView = oVar.M;
                                d(imageView != null && imageView.getVisibility() == 0);
                                oVar.g();
                                attachViewToParent(pVar2, 0, new RelativeLayout.LayoutParams(-1, -1));
                                u uVar = u.VAST_EVENT_DVC_IMPRESSION;
                                InneractiveAdRequest adRequest = getAdRequest();
                                com.fyber.inneractive.sdk.response.e adResponse = getAdResponse();
                                com.fyber.inneractive.sdk.player.ui.remote.d dVar2 = pVar2.L;
                                String str2 = dVar2.f;
                                Boolean valueOf = Boolean.valueOf(dVar2.i);
                                w wVar = new w(uVar, adRequest, adResponse);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("loaded_from_cache", valueOf);
                                } catch (Exception unused) {
                                    IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", valueOf);
                                }
                                try {
                                    jSONObject.put("templateURL", str2);
                                } catch (Exception unused2) {
                                    IAlog.f("Got exception adding param to json object: %s, %s", "templateURL", str2);
                                }
                                wVar.f.put(jSONObject);
                                wVar.a((String) null);
                            }
                            View view = this.y;
                            attachViewToParent(view, 0, view.getLayoutParams());
                        }
                        IAlog.a("%s : dynamic controls are not ready, yet", "IAVideoViewComposition");
                        com.fyber.inneractive.sdk.player.ui.remote.g gVar4 = nVar.u;
                        (gVar4 != null ? gVar4.f1653a : null).a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_ERROR, "Template isn't loaded yet", true, null);
                    }
                }
            }
            IAlog.a("%s : dynamic controls are not available", "IAVideoViewComposition");
        }
        pVar = null;
        this.z = pVar;
        this.l = oVar.l;
        this.q = oVar.q;
        this.r = oVar.r;
        this.m = oVar.m;
        TextView textView2 = oVar.u;
        this.u = textView2;
        a(textView2, 10);
        a(this.m, 8);
        a(this.l, 7);
        a(this.q, -1);
        if (a()) {
        }
        View view2 = this.y;
        attachViewToParent(view2, 0, view2.getLayoutParams());
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, com.fyber.inneractive.sdk.player.ui.m
    public final boolean a() {
        p pVar = this.z;
        return pVar != null && pVar.a();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void b(boolean z) {
        this.y.b(z);
        if (a(this.z)) {
            this.z.b(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void c(boolean z) {
        this.y.c(z);
        if (a(this.z)) {
            this.z.c(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void d(boolean z) {
        this.y.d(z);
        if (a(this.z)) {
            this.z.d(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void e(boolean z) {
        if (a(this.z)) {
            this.z.e(z);
        } else {
            this.y.e(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f(boolean z) {
        this.y.f(z);
        if (a(this.z)) {
            this.z.f(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g(boolean z) {
        if (a(this.z)) {
            this.z.g(z);
        } else {
            this.y.g(z);
        }
    }

    public InneractiveAdRequest getAdRequest() {
        r0 r0Var = this.A;
        if (r0Var != null) {
            return r0Var.f1249a;
        }
        return null;
    }

    public com.fyber.inneractive.sdk.response.e getAdResponse() {
        r0 r0Var = this.A;
        if (r0Var != null) {
            return r0Var.b;
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View getEndCardView() {
        return this.y.getEndCardView();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyView() {
        return a(this.z) ? this.z.getTrackingFriendlyView() : this.y.getTrackingFriendlyView();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return a(this.z) ? this.z.getTrackingFriendlyViewObstructionPurposeOther() : this.y.getTrackingFriendlyViewObstructionPurposeOther();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean i() {
        return a(this.z) ? this.z.L.n : this.y.i();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void j() {
        this.y.j();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void k() {
        this.y.k();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean l() {
        return a(this.z) ? this.z.L.m : this.y.l();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void m() {
        this.y.m();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void n() {
        this.y.n();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void o() {
        this.y.o();
        this.t = this.y.t;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setAppInfoButtonRound(TextView textView) {
        this.y.setAppInfoButtonRound(textView);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setListener(n nVar) {
        super.setListener(nVar);
        this.y.setListener(nVar);
        if (a(this.z)) {
            this.z.setListener(nVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setMuteButtonState(boolean z) {
        this.y.setMuteButtonState(z);
        if (a(this.z)) {
            this.z.setMuteButtonState(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setRemainingTime(String str) {
        this.y.setRemainingTime(str);
        if (a(this.z)) {
            this.z.setRemainingTime(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setSkipText(String str) {
        this.y.setSkipText(str);
        if (a(this.z)) {
            this.z.setSkipText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setUnitConfig(s0 s0Var) {
        super.setUnitConfig(s0Var);
        this.y.setUnitConfig(s0Var);
        if (a(this.z)) {
            this.z.setUnitConfig(s0Var);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
        ViewGroup viewGroup;
        p pVar;
        this.y.a(dVar, bVar);
        if (!a(this.z) || (viewGroup = this.q) == null || viewGroup.getVisibility() != 0 || (pVar = this.z) == null) {
            return;
        }
        pVar.destroy();
        this.z = null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f() {
        this.y.f();
        if (a(this.z)) {
            this.z.f();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void e() {
        o oVar = this.y;
        oVar.p();
        oVar.B = true;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g() {
        this.y.g();
        if (a(this.z)) {
            this.z.g();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar) {
        if (!a(this.z)) {
            this.y.a(z, mVar);
        } else {
            this.z.a(z, mVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, String str) {
        this.y.a(z, str);
        if (a(this.z)) {
            this.z.a(z, str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, int i, int i2) {
        this.n = i;
        this.o = i2;
        this.p = z;
        o oVar = this.y;
        oVar.n = i;
        oVar.o = i2;
        oVar.p = z;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar, b bVar2) {
        this.y.a(bVar, bVar2);
        p pVar = this.z;
        if (pVar != null) {
            pVar.destroy();
            this.z = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z) {
        if (a(this.z)) {
            this.z.a(z);
        } else {
            this.y.a(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(int i, int i2) {
        this.y.a(i, i2);
        if (a(this.z)) {
            this.z.a(i, i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void a(f1 f1Var, int i, int i2) {
        this.y.a(f1Var, i, i2);
    }

    public static boolean a(p pVar) {
        return (pVar == null || pVar.L.h || !pVar.a()) ? false : true;
    }
}
