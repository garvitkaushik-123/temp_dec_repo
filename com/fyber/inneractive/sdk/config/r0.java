package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.a1;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class r0 implements s0 {

    /* renamed from: a, reason: collision with root package name */
    public String f1114a;
    public String b;
    public l0 c;
    public o0 d;
    public p0 e;
    public t0 f;
    public u0 g;

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        a1.a(jSONObject, "id", this.f1114a);
        a1.a(jSONObject, "spotId", this.b);
        a1.a(jSONObject, "display", this.c);
        a1.a(jSONObject, "monitor", this.d);
        a1.a(jSONObject, "native", this.e);
        a1.a(jSONObject, "video", this.f);
        a1.a(jSONObject, "viewability", this.g);
        return jSONObject.toString();
    }
}
