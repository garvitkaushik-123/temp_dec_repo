package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class U8 {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f2450a;
    public final String b;
    public Map c;
    public final String d;
    public HashMap e;

    public U8(String url, int i, String eventType, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter("url_ping", "trackerType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.f2450a = i;
        this.b = eventType;
        this.c = hashMap;
        int length = url.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) url.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        this.d = I7.a(length, 1, url, i2);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "url_ping");
            jSONObject.put("url", this.d);
            jSONObject.put("eventType", this.b);
            jSONObject.put("eventId", this.f2450a);
            boolean z = T9.f2439a;
            Map map = this.c;
            if (map == null) {
                map = new HashMap();
            }
            jSONObject.put("extras", T9.a(",", map));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            return jSONObject2;
        } catch (JSONException e) {
            Intrinsics.checkNotNullExpressionValue("U8", "TAG");
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return "";
        }
    }
}
