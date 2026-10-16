package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.flow.u0;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class r extends c {
    public r(u0 u0Var, com.fyber.inneractive.sdk.model.vast.c cVar, int i) {
        super(u0Var, cVar, i);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(JSONArray jSONArray) {
        this.b = jSONArray;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final n c() {
        return new u(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean k() {
        JSONArray jSONArray = this.b;
        return jSONArray != null && jSONArray.length() > 0;
    }
}
