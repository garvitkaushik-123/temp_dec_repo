package com.inmobi.media;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Ke {

    /* renamed from: a, reason: collision with root package name */
    public final byte f2344a;
    public final String b;

    public Ke(byte b, String str) {
        this.f2344a = b;
        this.b = str;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            byte b = this.f2344a;
            String str = "unknown";
            if (b != 0) {
                if (b == 1) {
                    str = "static";
                } else if (b == 2) {
                    str = AnalyticsConstants.CREATIVE_TYPE_HTML;
                } else if (b == 3) {
                    str = "iframe";
                }
            }
            jSONObject.put("type", str);
            jSONObject.put("content", this.b);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            return jSONObject2;
        } catch (JSONException e) {
            List list = Le.h;
            Intrinsics.checkNotNullExpressionValue("Le", "access$getTAG$cp(...)");
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return "";
        }
    }
}
