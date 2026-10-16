package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.j;

/* loaded from: classes4.dex */
public final class d extends a {
    public d(String str, j jVar, String str2) {
        super(str, jVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar, String str) {
        return jVar.c(str, this.l);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String a2 = j.a(str, "min", "rat", j.e(str2));
        "read".equalsIgnoreCase(str);
        Integer a3 = jVar.a(j.a(str, "min", "rat", "all_mediators"));
        int intValue = a3 != null ? a3.intValue() : 5000;
        Integer a4 = jVar.a(a2);
        return a4 != null ? a4.intValue() : intValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String a2 = j.a(str, "rat", "perc", j.e(str2));
        String a3 = j.a(str, "rat", "perc", "all_mediators");
        int i = "read".equalsIgnoreCase(str) ? 15 : 10;
        Integer a4 = jVar.a(a3);
        if (a4 != null) {
            i = a4.intValue();
        }
        Integer a5 = jVar.a(a2);
        return a5 != null ? a5.intValue() : i;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar) {
        String str = this.l;
        jVar.getClass();
        String a2 = j.a("timeout", "threshold", j.e(str));
        Integer a3 = jVar.a(j.a("timeout", "threshold", "all_mediators"));
        int intValue = a3 != null ? a3.intValue() : 300;
        Integer a4 = jVar.a(a2);
        return a4 != null ? a4.intValue() : intValue;
    }
}
