package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i0;
import com.fyber.inneractive.sdk.web.j1;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class q extends e {
    public q(LinkedHashMap linkedHashMap, i0 i0Var, e1 e1Var) {
        super(linkedHashMap, i0Var, e1Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final void a() {
        com.fyber.inneractive.sdk.util.b0 b0Var;
        String str = (String) this.b.get("url");
        IAlog.e("IAmraidActionOpen: opening Internal Browser For Url: %s", str);
        i0 i0Var = this.c;
        if (i0Var != null) {
            e1 e1Var = this.d;
            j1 j1Var = i0Var.g;
            if (j1Var != null) {
                b0Var = ((com.fyber.inneractive.sdk.web.b0) j1Var).a(str, e1Var);
            } else {
                com.fyber.inneractive.sdk.util.e0 e0Var = com.fyber.inneractive.sdk.util.e0.FAILED;
                Exception exc = new Exception("No webview listener available");
                if (com.fyber.inneractive.sdk.util.o.a(i0Var.b) != null) {
                    com.fyber.inneractive.sdk.util.o.a(i0Var.b).getClass();
                }
                b0Var = new com.fyber.inneractive.sdk.util.b0(e0Var, exc);
            }
            if (b0Var.f1751a == com.fyber.inneractive.sdk.util.e0.FAILED) {
                i0 i0Var2 = this.c;
                k kVar = k.OPEN;
                Throwable th = b0Var.b;
                i0Var2.a(kVar, th == null ? "unknown error" : th.getMessage());
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.e
    public final String c() {
        return (String) this.b.get("url");
    }

    @Override // com.fyber.inneractive.sdk.mraid.e
    public final void d() {
        i0 i0Var = this.c;
        if (i0Var != null) {
            i0Var.a(k.OPEN, "No native click was detected in a timely fashion");
        }
    }
}
