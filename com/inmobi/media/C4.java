package com.inmobi.media;

import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class C4 {
    public static final JSONObject a(B4 b4) {
        Intrinsics.checkNotNullParameter(b4, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(VastAttributes.HORIZONTAL_POSITION, Float.valueOf(B2.a(b4.f2241a)));
        jSONObject.put(VastAttributes.VERTICAL_POSITION, Float.valueOf(B2.a(b4.b)));
        jSONObject.put("width", b4.c);
        jSONObject.put("height", b4.d);
        return jSONObject;
    }
}
