package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.a1;
import com.fyber.inneractive.sdk.util.z0;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class p0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public UnitDisplayType f1111a;

    @Override // com.fyber.inneractive.sdk.util.z0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a1.a(jSONObject, "unitDisplayType", this.f1111a);
        return jSONObject;
    }
}
