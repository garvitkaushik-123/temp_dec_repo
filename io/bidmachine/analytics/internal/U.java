package io.bidmachine.analytics.internal;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class U {
    public static final T a(Q q) {
        byte[] bArr;
        JSONObject a2;
        String jSONObject;
        byte[] bytes = q.a().isEmpty() ? new byte[0] : s0.a(q.a()).toString().getBytes(Charsets.UTF_8);
        String c = q.c();
        String d = q.d();
        String e = q.e();
        long f = q.f();
        q0 b = q.b();
        if (b == null || (a2 = r0.a(b)) == null || (jSONObject = a2.toString()) == null || (bArr = jSONObject.getBytes(Charsets.UTF_8)) == null) {
            bArr = new byte[0];
        }
        return new T(c, d, e, f, bytes, bArr);
    }

    public static final Q a(T t) {
        Map a2;
        if (t.a().length == 0) {
            a2 = MapsKt.emptyMap();
        } else {
            a2 = s0.a(new JSONObject(new String(t.a(), Charsets.UTF_8)));
        }
        return new Q(t.c(), t.d(), t.e(), t.f(), a2, t.b().length == 0 ? null : r0.a(new JSONObject(new String(t.b(), Charsets.UTF_8))));
    }
}
