package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ironsource.cc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3031cc implements Oe<JSONObject>, Me<C2994ac> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, C3088g1> f3231a = new LinkedHashMap();

    @Override // com.ironsource.InterfaceC3060e7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(Ne mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, C3088g1> entry : this.f3231a.entrySet()) {
            String key = entry.getKey();
            JSONArray a2 = entry.getValue().a(mode);
            if (a2.length() > 0) {
                jSONObject.put(key, a2);
            }
        }
        return jSONObject;
    }

    @Override // com.ironsource.Me
    public void a(C2994ac record) {
        Intrinsics.checkNotNullParameter(record, "record");
        String c = record.c();
        Map<String, C3088g1> map = this.f3231a;
        C3088g1 c3088g1 = map.get(c);
        if (c3088g1 == null) {
            c3088g1 = new C3088g1();
            map.put(c, c3088g1);
        }
        c3088g1.a(record.a(new C3011bc()));
    }
}
