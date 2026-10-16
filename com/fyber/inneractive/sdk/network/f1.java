package com.fyber.inneractive.sdk.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public final class f1 extends s0 {
    public final String p;

    public f1(e0 e0Var, String str) {
        super(e0Var, f0.c.a(), null);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        n0 n0Var = new n0();
        com.fyber.inneractive.sdk.click.c cVar = new com.fyber.inneractive.sdk.click.c();
        if (lVar != null) {
            ArrayList arrayList = lVar.f;
            cVar.f1057a.clear();
            cVar.f1057a.addAll(arrayList);
            InputStream inputStream = lVar.c;
            if (inputStream != null) {
                String stringBuffer = com.fyber.inneractive.sdk.util.t.a(inputStream).toString();
                cVar.b = stringBuffer;
                n0Var.b = stringBuffer;
            }
        }
        n0Var.f1331a = cVar;
        return n0Var;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return false;
    }
}
