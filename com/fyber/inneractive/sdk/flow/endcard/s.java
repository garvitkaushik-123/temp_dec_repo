package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o0;

/* loaded from: classes4.dex */
public final class s implements com.fyber.inneractive.sdk.web.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f1200a;

    public s(u uVar) {
        this.f1200a = uVar;
    }

    @Override // com.fyber.inneractive.sdk.web.g
    public final void a(com.fyber.inneractive.sdk.web.i iVar) {
        IAlog.a("%s End-Card loaded", this.f1200a.f1183a);
        this.f1200a.h.set(false);
        u uVar = this.f1200a;
        uVar.getClass();
        boolean z = iVar != null;
        uVar.f = z;
        com.fyber.inneractive.sdk.web.m mVar = z ? iVar.b : null;
        String str = IAConfigManager.O.H.e;
        if (!uVar.f() || mVar == null || TextUtils.isEmpty(str)) {
            uVar.b.m();
        } else {
            o0.a(mVar, str, uVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.g
    public final void a(com.fyber.inneractive.sdk.web.i iVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.f("%s End-Card failed to load!", this.f1200a.f1183a);
        this.f1200a.h.set(false);
        u uVar = this.f1200a;
        uVar.f = false;
        uVar.b.a(inneractiveInfrastructureError);
    }
}
