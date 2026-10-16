package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i0;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class i extends e {
    public i(LinkedHashMap linkedHashMap, i0 i0Var, e1 e1Var) {
        super(linkedHashMap, i0Var, e1Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final void a() {
        int a2 = a("w");
        int a3 = a("h");
        this.c.a((String) this.b.get("url"), a2 <= 0 ? -1 : a2, a3 <= 0 ? -1 : a3, "true".equals(this.b.get("shouldUseCustomClose")), "true".equals(this.b.get("lockOrientation")));
    }

    @Override // com.fyber.inneractive.sdk.mraid.e
    public final String c() {
        return (String) this.b.get("url");
    }
}
