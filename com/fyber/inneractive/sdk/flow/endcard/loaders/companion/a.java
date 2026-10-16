package com.fyber.inneractive.sdk.flow.endcard.loaders.companion;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.endcard.j;
import com.fyber.inneractive.sdk.flow.endcard.p;
import com.fyber.inneractive.sdk.flow.endcard.r;
import com.fyber.inneractive.sdk.flow.endcard.t;
import com.fyber.inneractive.sdk.flow.endcard.v;
import com.fyber.inneractive.sdk.flow.endcard.x;
import com.fyber.inneractive.sdk.flow.u0;
import com.fyber.inneractive.sdk.flow.vast.h;
import com.fyber.inneractive.sdk.model.vast.i;
import com.fyber.inneractive.sdk.model.vast.k;
import com.fyber.inneractive.sdk.network.c1;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import com.fyber.inneractive.sdk.web.i1;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class a implements com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a {

    /* renamed from: a, reason: collision with root package name */
    public final j f1192a;
    public final b b = new b();
    public final e c = new e();
    public final f d = new f();
    public final u0 e;
    public Iterator f;
    public com.fyber.inneractive.sdk.flow.endcard.c g;
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.b h;

    public a(j jVar, u0 u0Var, com.fyber.inneractive.sdk.flow.endcard.loaders.b bVar) {
        this.f1192a = jVar;
        this.e = u0Var;
        this.h = bVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a
    public final void a() {
        com.fyber.inneractive.sdk.flow.endcard.loaders.b bVar = this.h;
        com.fyber.inneractive.sdk.flow.endcard.c cVar = this.g;
        bVar.getClass();
        if (cVar != null) {
            IAlog.a("%s : onCompanionLoadSuccess: endcard type: %s", "EndCardLoader", cVar.i());
            bVar.d.a(cVar);
        }
    }

    public final void b() {
        Iterator it = this.f;
        if (it == null || !it.hasNext()) {
            return;
        }
        com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) this.f.next();
        this.g = cVar;
        String str = null;
        if (cVar instanceof r) {
            r rVar = (r) cVar;
            this.b.getClass();
            String str2 = rVar.g.f;
            u0 u0Var = rVar.c;
            u uVar = u.VAST_COMPANION_LOAD_ATTEMPT;
            InneractiveAdRequest inneractiveAdRequest = u0Var.c;
            g gVar = u0Var.d;
            JSONArray jSONArray = u0Var.f;
            w wVar = new w(gVar);
            wVar.c = uVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = jSONArray;
            wVar.a((String) null);
            com.fyber.inneractive.sdk.flow.endcard.u uVar2 = (com.fyber.inneractive.sdk.flow.endcard.u) rVar.f();
            uVar2.e = str2;
            uVar2.a(this);
            return;
        }
        if (cVar instanceof v) {
            e eVar = this.c;
            v vVar = (v) cVar;
            eVar.getClass();
            k kVar = vVar.h;
            int i = c.f1193a[kVar.ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                IAlog.f("%s Invalid static type: %s", "StaticCompanionEndCardLoader", kVar);
                return;
            }
            String str3 = vVar.g.f;
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            IAlog.c("%s load Static End-Card image %s", "StaticCompanionEndCardLoader", str3);
            u0 u0Var2 = vVar.c;
            u uVar3 = u.VAST_COMPANION_LOAD_ATTEMPT;
            InneractiveAdRequest inneractiveAdRequest2 = u0Var2.c;
            g gVar2 = u0Var2.d;
            JSONArray jSONArray2 = u0Var2.f;
            w wVar2 = new w(gVar2);
            wVar2.c = uVar3;
            wVar2.f1340a = inneractiveAdRequest2;
            wVar2.d = jSONArray2;
            wVar2.a((String) null);
            IAConfigManager.O.s.b(new c1(new d(eVar, vVar, this), vVar.g.f, vVar.c.b.c));
            return;
        }
        if (cVar instanceof x) {
            x xVar = (x) cVar;
            this.d.getClass();
            if (xVar.g.f1282a != i.Static) {
                u0 u0Var3 = xVar.c;
                u uVar4 = u.VAST_COMPANION_LOAD_ATTEMPT;
                InneractiveAdRequest inneractiveAdRequest3 = u0Var3.c;
                g gVar3 = u0Var3.d;
                JSONArray jSONArray3 = u0Var3.f;
                w wVar3 = new w(gVar3);
                wVar3.c = uVar4;
                wVar3.f1340a = inneractiveAdRequest3;
                wVar3.d = jSONArray3;
                wVar3.a((String) null);
                String str4 = xVar.g.f;
                String b = o.b("fyb_iframe_endcard_tmpl.html");
                if (!TextUtils.isEmpty(b)) {
                    b = b.replace("$__SrcIframeUrl__$", str4);
                }
                com.fyber.inneractive.sdk.flow.endcard.u uVar5 = (com.fyber.inneractive.sdk.flow.endcard.u) xVar.f();
                uVar5.e = b;
                uVar5.a(this);
                return;
            }
            u0 u0Var4 = xVar.c;
            u uVar6 = u.VAST_COMPANION_LOAD_ATTEMPT;
            InneractiveAdRequest inneractiveAdRequest4 = u0Var4.c;
            g gVar4 = u0Var4.d;
            JSONArray jSONArray4 = u0Var4.f;
            w wVar4 = new w(gVar4);
            wVar4.c = uVar6;
            wVar4.f1340a = inneractiveAdRequest4;
            wVar4.d = jSONArray4;
            wVar4.a((String) null);
            com.fyber.inneractive.sdk.model.vast.c cVar2 = xVar.g;
            String str5 = cVar2.f;
            String str6 = cVar2.g;
            if (TextUtils.isEmpty(str6)) {
                com.fyber.inneractive.sdk.model.vast.b bVar = xVar.c.d.O;
                if (bVar != null) {
                    str = bVar.b;
                }
            } else {
                str = str6;
            }
            String b2 = o.b("fyb_static_endcard_tmpl.html");
            if (!TextUtils.isEmpty(b2)) {
                b2 = b2.replace("$__IMGSRC__$", str5);
                if (str != null) {
                    b2 = b2.replace("$__IMGHREF__$", str.replace("\"", "\\\""));
                }
            }
            com.fyber.inneractive.sdk.flow.endcard.u uVar7 = (com.fyber.inneractive.sdk.flow.endcard.u) xVar.f();
            uVar7.e = b2;
            if (TextUtils.isEmpty(b2)) {
                throw new h("End-Card HTML not loaded", "No template");
            }
            com.fyber.inneractive.sdk.player.controller.d e = uVar7.e();
            e.a();
            i1 i1Var = e.f1359a;
            if (i1Var != null) {
                i1Var.F = false;
            }
            e.a(b2, new t(uVar7, this), !(uVar7 instanceof p));
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a
    public final void a(String str) {
        this.h.getClass();
        IAlog.a("%s : onCompanionLoadFailure: error: %s", "EndCardLoader", str);
        b();
    }
}
