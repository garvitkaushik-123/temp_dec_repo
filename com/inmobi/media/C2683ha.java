package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ha, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2683ha extends U8 {
    public final String g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2683ha(String vendorKey, String str, String url, HashMap hashMap) {
        super(url, 0, "OMID_VIEWABILITY", hashMap);
        Intrinsics.checkNotNullParameter(vendorKey, "vendorKey");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter("OMID_VIEWABILITY", "eventType");
        this.h = vendorKey;
        this.g = str;
    }

    @Override // com.inmobi.media.U8
    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "url_ping");
            jSONObject.put("url", this.d);
            jSONObject.put("eventType", this.b);
            jSONObject.put("eventId", this.f2450a);
            if (B2.a(this.h)) {
                jSONObject.put("vendorKey", this.h);
            }
            if (B2.a(this.g)) {
                jSONObject.put("verificationParams", this.g);
            }
            Map map = this.c;
            boolean z = T9.f2439a;
            if (map == null) {
                map = new HashMap();
            }
            jSONObject.put("extras", T9.a(",", map));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            return jSONObject2;
        } catch (JSONException e) {
            Intrinsics.checkNotNullExpressionValue("ha", "TAG");
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return "";
        }
    }
}
