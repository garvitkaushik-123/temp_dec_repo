package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class G0 implements Oe<JSONObject>, Me<E0> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, C3031cc> f2877a = new LinkedHashMap();

    @Override // com.ironsource.InterfaceC3060e7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(Ne mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, C3031cc> entry : this.f2877a.entrySet()) {
            String key = entry.getKey();
            JSONObject a2 = entry.getValue().a(mode);
            if (a2.length() > 0) {
                jSONObject.put(StringsKt.substringAfterLast$default(key, "_", (String) null, 2, (Object) null), a2);
            }
        }
        return jSONObject;
    }

    @Override // com.ironsource.Me
    public void a(E0 record) {
        Intrinsics.checkNotNullParameter(record, "record");
        String d = record.d();
        Map<String, C3031cc> map = this.f2877a;
        C3031cc c3031cc = map.get(d);
        if (c3031cc == null) {
            c3031cc = new C3031cc();
            map.put(d, c3031cc);
        }
        c3031cc.a(record.a(new F0()));
    }
}
