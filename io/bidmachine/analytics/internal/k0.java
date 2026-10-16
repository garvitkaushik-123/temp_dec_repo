package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.internal.h0;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class k0 {
    public static final j0 a(h0 h0Var) {
        byte[] bArr;
        JSONObject a2;
        String jSONObject;
        String c = h0Var.c();
        String d = h0Var.d();
        long f = h0Var.f();
        String a3 = h0Var.a();
        String jSONObject2 = a(h0Var.e()).toString();
        q0 b = h0Var.b();
        if (b == null || (a2 = r0.a(b)) == null || (jSONObject = a2.toString()) == null || (bArr = jSONObject.getBytes(Charsets.UTF_8)) == null) {
            bArr = new byte[0];
        }
        return new j0(c, d, f, a3, jSONObject2, bArr, h0Var.g());
    }

    public static final h0 a(j0 j0Var) {
        return new h0(j0Var.c(), j0Var.d(), j0Var.f(), j0Var.a(), a(new JSONObject(j0Var.e())), j0Var.b().length == 0 ? null : r0.a(new JSONObject(new String(j0Var.b(), Charsets.UTF_8))), j0Var.g());
    }

    public static final JSONObject a(h0.a aVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tag", aVar.b());
        jSONObject.put("path", aVar.a());
        return jSONObject;
    }

    public static final h0.a a(JSONObject jSONObject) {
        return new h0.a(jSONObject.optString("tag"), jSONObject.optString("path"));
    }
}
