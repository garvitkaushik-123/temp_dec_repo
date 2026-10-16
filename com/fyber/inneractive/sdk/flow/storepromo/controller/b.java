package com.fyber.inneractive.sdk.flow.storepromo.controller;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.endcard.k;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b implements com.fyber.inneractive.sdk.flow.storepromo.loader.a {

    /* renamed from: a, reason: collision with root package name */
    public final InneractiveAdRequest f1216a;
    public final e b;
    public c c;
    public com.fyber.inneractive.sdk.flow.storepromo.ui.c d;
    public com.fyber.inneractive.sdk.flow.storepromo.loader.b e;
    public com.fyber.inneractive.sdk.flow.storepromo.b f;
    public boolean g = false;
    public com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a h;
    public k i;

    public b(com.fyber.inneractive.sdk.flow.storepromo.model.c cVar, com.fyber.inneractive.sdk.flow.storepromo.b bVar, com.fyber.inneractive.sdk.flow.storepromo.loader.b bVar2, com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a aVar, e eVar, InneractiveAdRequest inneractiveAdRequest) {
        this.h = aVar;
        this.c = new c(cVar, this, this);
        this.f = bVar;
        this.f1216a = inneractiveAdRequest;
        this.b = eVar;
        this.e = bVar2;
    }

    public final void a() {
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar = this.d;
        if (cVar != null) {
            if (cVar.b != null && cVar.f1238a != null) {
                cVar.d.setAnimationListener(cVar.i);
                cVar.f1238a.setAnimation(cVar.d);
                cVar.f1238a.setVisibility(8);
            }
            k kVar = this.i;
            if (kVar == null || kVar.b.a() == null || kVar.b.a().f().b() == null) {
                return;
            }
            IAlog.a("%sonStorePromoDismissed restoring endcard focus", IAlog.a(kVar));
            kVar.b.a().f().b().requestFocus();
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.loader.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar, com.fyber.inneractive.sdk.flow.storepromo.model.c cVar) {
        this.d = new com.fyber.inneractive.sdk.flow.storepromo.ui.c(IAConfigManager.O.v.a(), aVar, this.f);
        u uVar = u.VAST_EVENT_SP_LOADED;
        InneractiveAdRequest inneractiveAdRequest = this.f1216a;
        e eVar = this.b;
        String str = cVar.h;
        w wVar = new w(uVar, inneractiveAdRequest, eVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("templateURL", str);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "templateURL", str);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
        IAlog.a("StorePromoController: onContentLoadedSuccess", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, String str2) {
        this.g = true;
        a();
        com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a aVar = this.h;
        if (aVar != null) {
            aVar.a(bVar, str, str2);
        }
    }
}
