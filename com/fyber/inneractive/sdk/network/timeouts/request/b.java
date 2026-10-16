package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.j;

/* loaded from: classes4.dex */
public final class b extends a {
    public b(j jVar, String str) {
        super(str, jVar, null);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar, String str) {
        jVar.getClass();
        String str2 = str + "_global_timeout";
        int i = j.d(str) ? 30000 : 10000;
        Integer a2 = jVar.a(str2);
        return a2 != null ? a2.intValue() : i;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b(j jVar, String str) {
        jVar.getClass();
        String a2 = j.a(str, "min", "rat");
        "read".equalsIgnoreCase(str);
        Integer a3 = jVar.a(a2);
        if (a3 != null) {
            return a3.intValue();
        }
        return 5000;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c(j jVar, String str) {
        jVar.getClass();
        String a2 = j.a(str, "rat_perc");
        int i = "read".equalsIgnoreCase(str) ? 15 : 10;
        Integer a3 = jVar.a(a2);
        return a3 != null ? a3.intValue() : i;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar) {
        jVar.getClass();
        Integer a2 = jVar.a(j.a("timeout", "threshold"));
        if (a2 != null) {
            return a2.intValue();
        }
        return 300;
    }
}
