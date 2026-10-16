package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i0;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class l extends f {
    public l(LinkedHashMap linkedHashMap, i0 i0Var, e1 e1Var) {
        super(linkedHashMap, i0Var, e1Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final void a() {
        this.c.a(k.GET_CURRENT_POSITION, "Unsupported action getCurrentPosition");
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final boolean b() {
        return false;
    }
}
