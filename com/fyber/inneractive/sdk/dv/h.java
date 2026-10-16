package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.r0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class h extends com.fyber.inneractive.sdk.response.b {
    @Override // com.fyber.inneractive.sdk.response.b
    public final void a(String str, r0 r0Var) {
        try {
            ((i) this.f1726a).N = new JSONObject(str).getString("adm");
        } catch (JSONException e) {
            com.fyber.inneractive.sdk.dv.handler.e.a(r0Var != null ? r0Var.b : null, com.fyber.inneractive.sdk.dv.enums.a.Parse, null, null, e.getLocalizedMessage());
        }
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final com.fyber.inneractive.sdk.response.e a() {
        return new i();
    }
}
