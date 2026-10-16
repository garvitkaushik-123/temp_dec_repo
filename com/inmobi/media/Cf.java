package com.inmobi.media;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Cf {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2256a = new ConcurrentHashMap();

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.f2256a.entrySet()) {
                jSONObject.put(String.valueOf(AbstractC2829qa.a((EnumC2813pa) entry.getKey())), ((Bf) entry.getValue()).a());
            }
            return jSONObject;
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return new JSONObject();
        }
    }
}
