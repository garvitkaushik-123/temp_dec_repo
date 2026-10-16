package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i0;
import com.fyber.inneractive.sdk.web.j1;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class w extends f {
    public w(LinkedHashMap linkedHashMap, i0 i0Var, e1 e1Var) {
        super(linkedHashMap, i0Var, e1Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final void a() {
        boolean equals = "true".equals(this.b.get("shouldUseCustomClose"));
        if (InneractiveAdManager.isCurrentUserAChild()) {
            equals = false;
        }
        i0 i0Var = this.c;
        i0Var.X = equals;
        j1 j1Var = i0Var.g;
        if (j1Var != null) {
            ((com.fyber.inneractive.sdk.web.b0) j1Var).b(equals);
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final boolean b() {
        return false;
    }
}
