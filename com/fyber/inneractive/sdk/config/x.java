package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.b1;

/* loaded from: classes4.dex */
public final class x implements r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1131a;

    public x(IAConfigManager iAConfigManager) {
        this.f1131a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.config.r
    public final void onGlobalConfigChanged(s sVar, o oVar) {
        if (oVar.a("dv_enabled_v3", 0, 0) == 1) {
            this.f1131a.G.a();
        }
        com.fyber.inneractive.sdk.network.f fVar = this.f1131a.I;
        fVar.getClass();
        int a2 = IAConfigManager.O.u.b.a("send_events_batch_interval", 30, -1);
        int i = a2 >= 0 ? a2 : 30;
        String property = System.getProperty("fyber.marketplace.use_batch_interval");
        int i2 = (property == null || Boolean.getBoolean(property)) ? i : 0;
        fVar.f = true;
        fVar.e = i2;
        b1 b1Var = fVar.d;
        if (b1Var != null && b1Var.hasMessages(12312329)) {
            fVar.d.removeMessages(12312329);
        }
        long j = fVar.e * 1000;
        b1 b1Var2 = fVar.d;
        if (b1Var2 != null) {
            b1Var2.post(new com.fyber.inneractive.sdk.network.c(fVar, 12312329, j));
        }
    }
}
